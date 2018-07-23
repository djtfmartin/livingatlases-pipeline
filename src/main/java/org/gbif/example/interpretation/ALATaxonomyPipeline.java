package org.gbif.example.interpretation;

import org.apache.beam.sdk.transforms.Values;
import org.gbif.pipelines.io.avro.ALATaxonRecord;
import org.gbif.pipelines.io.avro.ExtendedRecord;
import org.gbif.pipelines.io.avro.issue.OccurrenceIssue;
//import org.gbif.pipelines.transform.Kv2Value;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.io.AvroIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionTuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common example how to use {@link ALATransform}/{@link
 * org.gbif.pipelines.transform.RecordTransform} in Apache Beam
 */
public class ALATaxonomyPipeline {

  private static final Logger LOG = LoggerFactory.getLogger(ALATaxonomyPipeline.class);

  public static void main(String[] args) {

    LOG.info("Initializing pipeline options");
    ALAOptions options = PipelineOptionsFactory.fromArgs(args).as(ALAOptions.class);

    if(options.getDefaultTargetDirectory() == null) {
      PipelineOptionsFactory.printHelp(System.out, ALAOptions.class);
      System.exit(1);
    }

    LOG.info("Creating a beam pipeline");
    Pipeline p = Pipeline.create(options);
    String inputFile = options.getInputFile();
    String targetDataDirectory = options.getDefaultTargetDirectory() + "/ala-taxon-record";
    String targetIssueDirectory = options.getDefaultTargetDirectory() + "/ala-taxon-issue";

    LOG.info("Creating transform object");
    ALATransform transform = ALATransform.create().withAvroCoders(p);

    LOG.info("STEP 1: Read verbatim avro files");
    PCollection<ExtendedRecord> verbatimRecords =
        p.apply("Read an avro file", AvroIO.read(ExtendedRecord.class).from(inputFile));

    LOG.info("STEP 2: Apply our transform");
    PCollectionTuple exampleRecordTuple = verbatimRecords.apply(transform);

    LOG.info("Getting data from transformation");
    PCollection<ALATaxonRecord> exampleRecords =
        exampleRecordTuple.get(transform.getDataTag()).apply(Values.create());

    LOG.info("Getting issues from transformation");
    PCollection<OccurrenceIssue> issueRecords =
        exampleRecordTuple.get(transform.getIssueTag()).apply(Values.create());

    LOG.info("STEP 3: Save to an avro file");
    exampleRecords.apply(
        "Write data to an avro file",
        AvroIO.write(ALATaxonRecord.class).to(targetDataDirectory).withSuffix(".avro"));
    issueRecords.apply(
        "Write issues to an avro file",
        AvroIO.write(OccurrenceIssue.class).to(targetIssueDirectory).withSuffix(".avro"));

    // Run
    LOG.info("Starting the pipeline");
    PipelineResult result = p.run();
    result.waitUntilFinish();
    LOG.info("Pipeline finished with state: {} ", result.getState());
  }
}

package org.gbif.livingatlases.interpretation;

import org.apache.beam.runners.direct.DirectRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.io.AvroIO;
import org.apache.beam.sdk.io.solr.SolrIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.solr.common.SolrInputDocument;
import org.gbif.pipelines.common.beam.Coders;
import org.gbif.pipelines.io.avro.ExtendedRecord;
import org.gbif.pipelines.io.avro.UntypedOccurrence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ALASolrPipeline {
    private static final Logger LOG = LoggerFactory.getLogger(ALASolrPipeline.class);

    private static final String SOLR_HOSTS = "localhost:9983";

    public static void main(String[] args) {

        PipelineOptions options = PipelineOptionsFactory.create();
        options.setRunner(DirectRunner.class); // forced for this demo
        Pipeline p = Pipeline.create(options);

        // register Avro coders for serializing our messages
        Coders.registerAvroCoders(p, ExtendedRecord.class, UntypedOccurrence.class);

        // Read the DwC-A using our custom reader
        // Read Avro files
        PCollection<ExtendedRecord> verbatimStream =
                p.apply("Read Avro files", AvroIO.read(ExtendedRecord.class).from("/Users/mar759/gbif-pipelines-test/tmp/inter-finished/b13874fd-cd74-4600-bd0e-202bf3706983/1/**/interpreted*"));

        // Convert the ExtendedRecord into an UntypedOccurrence record
        PCollection<UntypedOccurrence> verbatimRecords = verbatimStream.apply(
                "Convert the objects into untyped DwC style records",
                MapElements.into(TypeDescriptors.untypedOccurrence()).via(FunctionFactory.untypedOccurrenceBuilder()));

        // Write the file to SOLR
        final SolrIO.ConnectionConfiguration conn = SolrIO.ConnectionConfiguration
                .create(SOLR_HOSTS);

        PCollection<SolrInputDocument> inputDocs = verbatimRecords.apply(
                "Convert to SOLR", ParDo.of(new SolrDocBuilder()));

        inputDocs.apply(SolrIO.write().to("beam-demo1").withConnectionConfiguration(conn));

        LOG.info("Starting the pipeline");
        PipelineResult result = p.run();
        result.waitUntilFinish();
        LOG.info("Pipeline finished with state: {} ", result.getState());
    }
}
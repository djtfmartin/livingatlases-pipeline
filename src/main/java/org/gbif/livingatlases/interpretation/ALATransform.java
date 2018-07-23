package org.gbif.livingatlases.interpretation;

import org.gbif.pipelines.common.beam.Coders;
import org.gbif.pipelines.core.interpretation.Interpretation;
import org.gbif.pipelines.io.avro.ALATaxonRecord;
import org.gbif.pipelines.io.avro.ExtendedRecord;
import org.gbif.pipelines.io.avro.issue.OccurrenceIssue;
import org.gbif.pipelines.io.avro.issue.Validation;
import org.gbif.pipelines.transform.RecordTransform;

import java.util.ArrayList;
import java.util.List;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.KV;

/**
 * Common abstraction for Apache Beam, extends RecordTransform, which extends Beam's PTransform
 * class. RecordTransform it as a typical transformation with one input format and two outputs.
 *
 * <p>Input: {@link ExtendedRecord} as a data source
 *
 * <p>Outputs: first - the main data output, in our case {@link ExampleRecord} and second common
 * type - {@link org.gbif.pipelines.io.avro.issue.OccurrenceIssue}
 *
 * <p>Example of using {@link ALATransform}:
 *
 * <pre>{@code
 * ExampleTransform transform = ExampleTransform.create().withAvroCoders(pipeline);
 * PCollectionTuple recordTuple = collections.apply(transform);
 *
 * }</pre>
 *
 * <p>You can get data from RecordTransform by tags, for main data use method - {@link
 * RecordTransform#getDataTag()}, for issue data use - {@link RecordTransform#getIssueTag()}
 *
 * <p>Example:
 *
 * <pre>{@code
 * PCollection<KV<String, ExampleRecord>> example = recordTuple.get(transform.getDataTag());
 *
 * or
 *
 * PCollection<ExampleRecord> example = recordTuple.get(transform.getDataTag()).apply(Kv2Value.create());
 *
 * }</pre>
 */
public class ALATransform extends RecordTransform<ExtendedRecord, ALATaxonRecord> {

  private ALATransform() {
    super("Interpret new record");
  }

  public static ALATransform create() {
    return new ALATransform();
  }

  @Override
  public DoFn<ExtendedRecord, KV<String, ALATaxonRecord>> interpret() {
    return new DoFn<ExtendedRecord, KV<String, ALATaxonRecord>>() {
      @ProcessElement
      public void processElement(ProcessContext context) {

        // Context element to be interpreted
        ExtendedRecord extendedRecord = context.element();
        String id = extendedRecord.getId();
        List<Validation> validations = new ArrayList<>();

        // Transformation main output
        ALATaxonRecord exampleRecord = ALATaxonRecord.newBuilder().setId(id).build();

        Interpretation.of(extendedRecord)
            .using(ALATaxonomyInterpreter.interpretStepOne(exampleRecord))
//            .using(ExampleInterpreter.interpretStepTwo(exampleRecord))
//            .using(ExampleInterpreter.interpretStepThree(exampleRecord))
            .forEachValidation(trace -> validations.add(toValidation(trace.getContext())));

        // Additional output
        if (!validations.isEmpty()) {
          OccurrenceIssue issue =
              OccurrenceIssue.newBuilder().setId(id).setIssues(validations).build();
          context.output(getIssueTag(), KV.of(id, issue));
        }

        // Main output
        context.output(getDataTag(), KV.of(exampleRecord.getId(), exampleRecord));
      }
    };
  }

  /**
   * If we want to use Avro as the main file type, we must register the necessary avro classes in
   * the pipeline. If you use several {@link RecordTransform}, this is the easiest way how not
   * forget to register all avro classes
   */
  @Override
  public ALATransform withAvroCoders(Pipeline pipeline) {
    Coders.registerAvroCoders(
        pipeline, OccurrenceIssue.class, ALATaxonRecord.class, ExtendedRecord.class);
    return this;
  }
}

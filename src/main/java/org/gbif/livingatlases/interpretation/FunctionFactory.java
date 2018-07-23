package org.gbif.livingatlases.interpretation;

import org.apache.beam.sdk.transforms.SerializableFunction;
import org.gbif.pipelines.io.avro.ExtendedRecord;
import org.gbif.pipelines.io.avro.UntypedOccurrence;

/**
 * Provider of reusable functions. All functions implement serializable.
 *
 * FIXME - copied from pipeline-labs
 */
public class FunctionFactory {

    private FunctionFactory() {
    }

    public static SerializableFunction<ExtendedRecord, UntypedOccurrence> untypedOccurrenceBuilder() {
        return new UntypedOccurrenceBuilder();
    }

}


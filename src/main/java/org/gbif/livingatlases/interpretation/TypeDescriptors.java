package org.gbif.livingatlases.interpretation;

import org.apache.beam.sdk.values.TypeDescriptor;
import org.gbif.pipelines.io.avro.TypedOccurrence;
import org.gbif.pipelines.io.avro.UntypedOccurrence;

/**
 * FIXME - copied from pipeline-labs
 */
public class TypeDescriptors {

    private TypeDescriptors() {
        // Can't have an instance
    }

    public static TypeDescriptor<TypedOccurrence> typedOccurrence() {
        return new TypeDescriptor<TypedOccurrence>() {};
    }

    public static TypeDescriptor<UntypedOccurrence> untypedOccurrence() {
        return new TypeDescriptor<UntypedOccurrence>() {};
    }

}

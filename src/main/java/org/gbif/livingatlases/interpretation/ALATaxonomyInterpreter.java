package org.gbif.livingatlases.interpretation;

import au.org.ala.names.gprc.GUIDRequest;
import au.org.ala.names.gprc.GUIDResponse;
import au.org.ala.names.gprc.NameMatchGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.gbif.pipelines.core.interpretation.Interpretation;
import org.gbif.pipelines.core.ws.client.match2.NameUsageMatchQueryConverter;
import org.gbif.pipelines.io.avro.ExtendedRecord;

import java.util.Map;
import java.util.function.Function;
import org.gbif.pipelines.io.avro.ALATaxonRecord;

/**
 * Interpreter for ALA taxonomy which uses GRPC.
 * This is proof of solution quality code.
 */
public interface ALATaxonomyInterpreter
        extends Function<ExtendedRecord, Interpretation<ExtendedRecord>> {

    static ALATaxonomyInterpreter interpretStepOne(ALATaxonRecord alaTaxonRecord) {
        return (ExtendedRecord extendedRecord) -> {

            // Create interpretation
            Interpretation<ExtendedRecord> interpretation = Interpretation.of(extendedRecord);
            Map<String, String> coreTerms = extendedRecord.getCoreTerms();
            Map<String, String> params = NameUsageMatchQueryConverter.convert(coreTerms);

            try {

                if(params.get("name") != null){
                    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                            .usePlaintext()
                            .build();

                    NameMatchGrpc.NameMatchBlockingStub blockingStub = NameMatchGrpc.newBlockingStub(channel);

                    GUIDRequest request = GUIDRequest.newBuilder().setName(params.get("name")).build();
                    GUIDResponse response = blockingStub.getGUID(request);

                    if(response.getSuccess()) {
                        alaTaxonRecord.setCleanName(response.getCleanName());
                        alaTaxonRecord.setAcceptedLsid(response.getAcceptedGuid());
                        alaTaxonRecord.setLeft(response.getLeft());
                        alaTaxonRecord.setRight(response.getRight());
                        alaTaxonRecord.setMatchType(response.getMatchType());
                    }

                    channel.shutdown();
                }

            } catch (Throwable e){
                e.printStackTrace();
            }

            return interpretation;
        };
    }
}

package com.eldermoraes;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://time-api-eldermoraes-dev.apps.rm2.thpm.p1.openshiftapps.com/time-api")
public interface TimeApiService {

    public static final String MSG_ERRO = "deu ruim";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Timeout(1000L)
    @Fallback(
            fallbackMethod = "getTimeFallback"
    )
    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = .5,
            delay = 3000L,
            successThreshold = 2
    )
    public String getTime();

    default String getTimeFallback(){
        return MSG_ERRO;
    }
}

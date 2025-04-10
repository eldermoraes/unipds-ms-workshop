package com.eldermoraes;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8081/time-api")
public interface TimeAppService {

    public static final String MSG_ERRO = "deu ruim ";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(value = 2000L)
    @Fallback(fallbackMethod = "getTimeFallback")
    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = .5,
            delay = 5000,
            successThreshold = 2
    )

    public String getTime();

    default String getTimeFallback(){
        return MSG_ERRO;
    }
}

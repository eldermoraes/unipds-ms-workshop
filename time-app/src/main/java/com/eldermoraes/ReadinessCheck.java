package com.eldermoraes;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    TimeApiService timeApiService;

    @Override
    public HealthCheckResponse call() {

        if (timeApiService.getTime().equals(TimeApiService.MSG_ERRO)){
            return HealthCheckResponse.down("não estou pronto");
        } else{
            return HealthCheckResponse.up("estou pronto");
        }
    }
}

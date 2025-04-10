package com.eldermoraes;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    TimeAppService timeAppService;

    @Override
    public HealthCheckResponse call() {

        if (timeAppService.getTime().equals(TimeAppService.MSG_ERRO)){
            return HealthCheckResponse.down("não estou pronto");
        } else{
            return HealthCheckResponse.up("estou pronto");
        }

    }
}

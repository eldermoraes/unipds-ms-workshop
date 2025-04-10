package com.eldermoraes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/time-app")
public class TimeAppResource {

    @RestClient
    TimeAppService timeAppService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTime(){
        return "App: " + timeAppService.getTime();
    }
}

package com.eldermoraes;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/time-app")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TimeAppResource {

    @RestClient
    TimeApiService timeApiService;

    @GET
    public String getTime() {
        return "App: " + timeApiService.getTime();
    }
}

package com.eldermoraes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDateTime;


@Path("/time-api")
public class TimeApiResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return LocalDateTime.now() + "\n";
    }
}

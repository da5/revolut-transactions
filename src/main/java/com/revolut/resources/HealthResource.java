package com.revolut.resources;

import com.codahale.metrics.annotation.Timed;
import com.revolut.common.data.model.Health;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.UUID;

@Path("/api/health")
@Produces(MediaType.APPLICATION_JSON)
public class HealthResource {
    @GET
    @Timed
    public Health sayHello(@QueryParam("name") Optional<String> name) {
        return new Health(UUID.randomUUID(), name.orElse("default"));
    }
}

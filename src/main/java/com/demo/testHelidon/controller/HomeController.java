package com.demo.testHelidon.controller;

import com.demo.testHelidon.model.User;
import com.demo.testHelidon.properties.UserProperties;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collections;

@Slf4j
@Path("/home")
@RequestScoped
@Tag(name = "Test Home service", description = "Get test data")
public class HomeController {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());

    @Context
    UriInfo uriInfo;
    @Context
    ResourceContext resourceContext;

    /* Inject class or service */
    @Inject
    private UserProperties userProp;

    @Inject
    @ConfigProperty(name = "injected.value")
    private String injectedValue;

    /* Test inject config value from microprofile-config.properties */
    @GET @Path("/helloWorld")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject helloWorld() {
        log.info("===== Enter helloWorld ====");

        return JSON.createObjectBuilder()
                .add("message1", "hello world")
                .build();
    }

    @POST @Path("/testPost")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testPost() {
        log.info("===== Enter testPost ====");
        return Response
                .status(Response.Status.OK)
                .entity(new User())
                .build();
    }


    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Get User data success.")
            , @APIResponse(responseCode = "404", description = "User data not found.")
    })
    @GET @Path("/testGetConfigValue")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testGetConfigValue() {
        log.info("===== Enter testGetConfigValue ====");
        log.info("Injected value : {}", injectedValue);
        log.info("username1 , default.properties: {}", userProp.getUsername());
        log.info("username3 , application.yaml: {}", userProp.getUsername2());
        log.info("username4 , db.properties: {}", userProp.getUsername3());
        log.info("username5 , test.yaml: {}", userProp.getUsername4());
        return Response
                .status(Response.Status.OK)
                .entity(new User())
                .build();
    }
}

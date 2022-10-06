package com.demo.testHelidon.controller;

import com.demo.testHelidon.model.User;
import com.demo.testHelidon.properties.UserProperties;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;

@Slf4j
@Path("/home")
@RequestScoped
@Tag(name = "Test Home service", description = "Get test data")
public class HomeController {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());

    /* How to Inject class or service */
    @Inject
    private UserProperties userProperties;

    @Inject
    @ConfigProperty(name = "injected.value")
    private String injectedValue;

    /* Test inject config value from microprofile-config.properties */
    @GET @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getInjectConfig() {
        log.info("===== Enter getDefaultMessage ====");

        return JSON.createObjectBuilder()
                .add("message1", "hello world")
                .add("injected value", injectedValue)
                .build();
    }


    /* Test openApi */
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Get User data success.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(ref = "User"))
            ),
            @APIResponse(responseCode = "404", description = "User data not found.")
    })
    @GET @Path("/testOpenApi")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testOpenApi() {
        log.info("===== Enter testOpenApi ====");
        return Response
                .status(Response.Status.OK)
                .entity(new User(userProperties.getName(), userProperties.getAge(), userProperties.isWorkFlag()))
                .build();
    }
}

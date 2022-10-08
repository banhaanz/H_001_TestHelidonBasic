//package com.demo.testHelidon.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.eclipse.microprofile.config.inject.ConfigProperty;
//
//import javax.enterprise.context.RequestScoped;
//import javax.inject.Inject;
//import javax.json.Json;
//import javax.json.JsonBuilderFactory;
//import javax.json.JsonObject;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import java.util.Collections;
//
//@Slf4j
//@Path("/home2")
//@RequestScoped
//public class Home2Controller {
//    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());
//
//    @Inject
//    @ConfigProperty(name = "injected.value")
//    private String injectedValue;
//
//    @GET @Path("/test")
//    @Produces(MediaType.APPLICATION_JSON)
//    public JsonObject getDefaultMessage() {
//        log.info("===== Enter getDefaultMessage ====");
//
//        return JSON.createObjectBuilder()
//                .add("message1", "hello world")
//                .add("message2", injectedValue)
//                .build();
//    }
//}

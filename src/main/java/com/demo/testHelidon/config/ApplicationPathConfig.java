package com.demo.testHelidon.config;

import com.demo.testHelidon.controller.Home2Controller;
import com.demo.testHelidon.controller.HomeController;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@OpenAPIDefinition(info = @Info(
        title = "Helidon-Service",
        version = "1.0.0",
        contact = @Contact(
                name = "Helidon-serivce",
                email = "helidon_serivce@mail.com",
                url = "http://www.helidon-serivce.com")
),
        servers = @Server(url = "http://localhost:8085", description = "Helidon Service")
)
@ApplicationPath("/AEKCOM")
@ApplicationScoped
public class ApplicationPathConfig extends Application {
//    @Override
//    public Set<Class<?>> getClasses() {
//
//        Set<Class<?>> classes = new HashSet<>();
//
//        // resources
//        classes.add(HomeController.class);
//        classes.add(Home2Controller.class);
//
//        return classes;
//    }


}

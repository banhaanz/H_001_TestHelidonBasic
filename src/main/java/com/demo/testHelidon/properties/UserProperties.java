package com.demo.testHelidon.properties;

import lombok.Data;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@Data
@RequestScoped
//@ConfigProperties(prefix = "user1.")
public class UserProperties {

    @Inject @ConfigProperty(name = "user1.username")
    private String username;

    @Inject @ConfigProperty(name = "user3.username")
    private String username3;

    @Inject @ConfigProperty(name = "user1.age")
    private int age;

    @Inject @ConfigProperty(name = "user1.workFlag")
    private boolean workFlag;

}

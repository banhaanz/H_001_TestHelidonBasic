package com.demo.testHelidon.properties;

import lombok.Getter;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.enterprise.context.ApplicationScoped;

@Getter
@ApplicationScoped
public class UserProperties {
    private final String name;
    private final int age;
    private final boolean workFlag;

    public UserProperties(){
        this.name = ConfigProvider.getConfig().getValue("user.username", String.class);
        this.age = ConfigProvider.getConfig().getValue("user.age", Integer.class);
        this.workFlag = ConfigProvider.getConfig().getValue("user.workFlag", Boolean.class);
    }
}

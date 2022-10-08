package com.demo.testHelidon.properties;

import com.demo.testHelidon.model.User;
import com.demo.testHelidon.util.ResourceUtil;
import lombok.Data;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.enterprise.context.RequestScoped;
import java.util.Properties;


@Data
@RequestScoped
//@ConfigProperties(prefix = "user1.")
public class UserProperties {

    private String username;
    private String username3;
    private int age;
    private boolean workFlag;

    public UserProperties(){
        this.username = ConfigProvider.getConfig().getValue("user1.username", String.class);
        this.username3 = ConfigProvider.getConfig().getValue("user3.username", String.class);
        this.age = ConfigProvider.getConfig().getValue("user1.age", Integer.class);
        this.workFlag = ConfigProvider.getConfig().getValue("user1.workFlag", Boolean.class);
    }
}

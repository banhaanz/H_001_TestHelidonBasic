package com.demo.testHelidon.properties;

import com.demo.testHelidon.model.User;
import com.demo.testHelidon.util.ResourceUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Properties;


@Data
@NoArgsConstructor
@RequestScoped
//@ConfigProperties(prefix = "user1.")
public class UserProperties {

    @Inject @ConfigProperty(name = "user1.username")
    private String username;
    @Inject @ConfigProperty(name = "user2.username")
    private String username2;
    @Inject @ConfigProperty(name = "user3.username")
    private String username3;
    @Inject @ConfigProperty(name = "user4.name.username")
    private String username4;
    @Inject @ConfigProperty(name = "user1.age")
    private int age;
    @Inject @ConfigProperty(name = "user1.workFlag")
    private boolean workFlag;
}

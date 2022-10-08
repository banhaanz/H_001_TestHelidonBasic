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
    private String username2;
    private String username3;
    private String username4;
    private String username5;
    private int age;
    private boolean workFlag;

    public UserProperties(){
        Properties dbProperties = ResourceUtil.getProperties("db.properties");
        User yaml = ResourceUtil.getYaml("test.yaml", User.class);
        this.username = ConfigProvider.getConfig().getValue("user1.username", String.class);
//        this.username2 = ConfigProvider.getConfig().getValue("user2.username", String.class);
        this.username3 = ConfigProvider.getConfig().getValue("user3.username", String.class);
        this.username4 = dbProperties.getProperty("user4.username");
        this.username5 = yaml.getUser5("name.username");
        this.age = ConfigProvider.getConfig().getValue("user1.age", Integer.class);
        this.workFlag = ConfigProvider.getConfig().getValue("user1.workFlag", Boolean.class);
    }
}

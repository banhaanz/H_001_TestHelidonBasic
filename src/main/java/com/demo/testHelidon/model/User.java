package com.demo.testHelidon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Map;

@Schema(name="User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Schema(required = true, description = "username")
    private String username;
    private Map<String, Map<String, String>> user4;
    private int age;
    private boolean workFlag;

    public String getUser4(String keyName){
        String[] strArr = keyName.split("\\.");
        return this.getUser4().get(strArr[0]).get(strArr[1]);
    }
}
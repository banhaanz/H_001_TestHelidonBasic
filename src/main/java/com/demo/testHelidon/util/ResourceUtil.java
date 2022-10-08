package com.demo.testHelidon.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Properties;

public class ResourceUtil
{
    public static Properties getProperties(String propFileName) {
        Properties p = new Properties();
        try {
            p.load(ResourceUtil.class.getResourceAsStream("/" + propFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public static<T> T getYaml(String yamlFileName,  Class<T> type) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        T objects = null;
        try {
            objects = mapper.readValue(ResourceUtil.class.getResource("/" + yamlFileName), type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

}

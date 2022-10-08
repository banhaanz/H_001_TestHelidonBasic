package com.demo.testHelidon.config;

import io.helidon.config.Config;
import io.helidon.config.spi.ConfigSource;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.function.Supplier;

import static io.helidon.config.ConfigSources.classpath;
import static io.helidon.config.ConfigSources.file;

@Slf4j
@ApplicationScoped
public class BuildConfig {
    public static Config buildConfig() {
        log.info("==== Enter buildConfig");
        return Config.builder()
                .disableEnvironmentVariablesSource()
                .sources(
                        file(""),
                        classpath(""),
                        classpath("META-INF/microprofile-config.properties"))
                .build();
    }
}

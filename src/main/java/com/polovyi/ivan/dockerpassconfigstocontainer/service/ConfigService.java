package com.polovyi.ivan.dockerpassconfigstocontainer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ConfigService {

    @Value("${app.name}")
    private String appName;

    @Value("${spring.datasource.url}")
    private String springDatasourceUrl;

    @Value("${spring.profiles.active}")
    private String springProfileActive;

    @Value("${management.endpoints.web.base-path}")
    private String managementEndpointsWebBasePath;

    public Map<String, String> getConfigs() {
        log.info("Getting configs...");
        return Map.of("app.name", appName,
                "spring.datasource.url", springDatasourceUrl,
                "spring.profiles.active", springProfileActive,
                "management.endpoints.web.base-path", managementEndpointsWebBasePath);
    }

    public List<String> getJavaOpts() {
        log.info("Getting JAVA_OPTS...");
        return ManagementFactory.getRuntimeMXBean().getInputArguments();
    }

}

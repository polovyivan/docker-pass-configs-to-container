package com.polovyi.ivan.dockerpassconfigstocontainer.controller;

import com.polovyi.ivan.dockerpassconfigstocontainer.service.ConfigService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public record ConfigController(ConfigService configService) {

    @GetMapping("/v1/configs")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> getSpringConfigsVariables() {
        return configService.getConfigs();
    }

    @GetMapping("/v1/java-opts")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getJavaOpts() {
        return configService.getJavaOpts();
    }

}

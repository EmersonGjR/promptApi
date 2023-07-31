package com.api.promptGpt.service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EnvApp {
    private final Environment environment;
    public EnvApp(Environment environment) {
        this.environment = environment;
    }
    public String getKey(){
        return environment.getProperty("openai.api.key");
    }
}

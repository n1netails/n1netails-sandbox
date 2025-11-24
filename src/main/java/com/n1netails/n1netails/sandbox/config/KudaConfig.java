package com.n1netails.n1netails.sandbox.config;

import com.n1netails.n1netails.kuda.internal.TailConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KudaConfig {

    @Value("${n1netails.sandbox.kuda.api}")
    private String api;

    @Value("${n1netails.sandbox.kuda.path}")
    private String path;

    @Value("${n1netails.sandbox.kuda.n1ne-token}")
    private String token;

    @Bean
    public String tailConfig() {
        TailConfig.setApiUrl(api);
        TailConfig.setApiPath(path);
        TailConfig.setN1neToken(token);
        TailConfig.enableExceptionHandler();
        return "Kuda Configured";
    }
}

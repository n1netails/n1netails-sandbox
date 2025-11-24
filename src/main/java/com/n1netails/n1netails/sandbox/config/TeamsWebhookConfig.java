package com.n1netails.n1netails.sandbox.config;

import com.n1netails.n1netails.teams.api.TeamsWebhookClient;
import com.n1netails.n1netails.teams.internal.TeamsWebhookClientImpl;
import com.n1netails.n1netails.teams.service.WebhookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamsWebhookConfig {

    @Bean
    public WebhookService teamsWebhookService() {
        return new WebhookService();
    }

    @Bean
    public TeamsWebhookClient teamsWebhookClient(WebhookService service) {
        return new TeamsWebhookClientImpl(service);
    }
}

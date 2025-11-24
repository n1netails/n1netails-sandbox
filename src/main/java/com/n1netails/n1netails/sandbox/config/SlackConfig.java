package com.n1netails.n1netails.sandbox.config;

import com.n1netails.n1netails.slack.api.SlackClient;
import com.n1netails.n1netails.slack.internal.SlackClientImpl;
import com.n1netails.n1netails.slack.service.BotService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackConfig {

    @Value("${n1netails.sandbox.slack.bot-token}")
    private String botToken;

    @Bean
    public BotService slackBotService() {
        return new BotService(botToken);
    }

    @Bean
    public SlackClient slackClient(BotService botService) {
        return new SlackClientImpl(botService);
    }
}

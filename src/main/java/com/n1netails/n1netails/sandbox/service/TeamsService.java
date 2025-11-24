package com.n1netails.n1netails.sandbox.service;

import com.n1netails.n1netails.teams.api.TeamsWebhookClient;
import com.n1netails.n1netails.teams.exception.TeamsWebhookException;
import com.n1netails.n1netails.teams.model.WebhookMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TeamsService implements CommunicationPlatform {

    @Value("${n1netails.sandbox.teams.webhook}")
    private String webhookUrl;

    private final TeamsWebhookClient webhookClient;

    public TeamsService(TeamsWebhookClient webhookClient) {
        this.webhookClient = webhookClient;
    }

    @Override
    public void sendNotification() throws TeamsWebhookException {
        WebhookMessage message = new com.n1netails.n1netails.teams.model.WebhookMessage();
        message.setContent("Hello, from n1netails-teams-webhook-client!");
        webhookClient.sendMessage(webhookUrl, message);
    }
}

package com.n1netails.n1netails.sandbox.service;

import com.n1netails.n1netails.discord.DiscordColor;
import com.n1netails.n1netails.discord.api.DiscordWebhookClient;
import com.n1netails.n1netails.discord.exception.DiscordWebhookException;
import com.n1netails.n1netails.discord.model.Embed;
import com.n1netails.n1netails.discord.model.WebhookMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscordService implements CommunicationPlatform {

    @Value("${n1netails.sandbox.discord.webhook}")
    private String webhookUrl;

    private final DiscordWebhookClient webhookClient;

    public DiscordService(DiscordWebhookClient webhookClient) {
        this.webhookClient = webhookClient;
    }

    @Override
    public void sendNotification() throws DiscordWebhookException {
        Embed embed = new Embed();
        embed.setTitle("Build Notification");
        embed.setDescription("The build has succeeded ✅");
        embed.setColor(DiscordColor.BLUE.getValue());

        WebhookMessage msg = new WebhookMessage();
        msg.setUsername("CI Bot");
        msg.setContent("Deployment update");
        msg.setEmbeds(List.of(embed));
        webhookClient.sendMessage(webhookUrl, msg);
    }
}

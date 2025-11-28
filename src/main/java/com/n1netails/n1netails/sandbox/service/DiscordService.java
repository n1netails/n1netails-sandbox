package com.n1netails.n1netails.sandbox.service;

import com.n1netails.n1netails.discord.DiscordColor;
import com.n1netails.n1netails.discord.api.DiscordWebhookClient;
import com.n1netails.n1netails.discord.exception.DiscordWebhookException;
import com.n1netails.n1netails.discord.model.Embed;
import com.n1netails.n1netails.discord.model.EmbedBuilder;
import com.n1netails.n1netails.discord.model.WebhookMessage;
import com.n1netails.n1netails.discord.model.WebhookMessageBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
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
        // simple
        Embed embed = new Embed();
        embed.setTitle("Build Notification");
        embed.setDescription("The build has succeeded ✅");
        embed.setColor(DiscordColor.BLUE.getValue());

        WebhookMessage msg = new WebhookMessage();
        msg.setUsername("CI Bot");
        msg.setContent("Deployment update");
        msg.setEmbeds(List.of(embed));
        webhookClient.sendMessage(webhookUrl, msg);


        // detailed message
        Embed.Author author = new Embed.Author();
        author.setName("N1ne Tails");
        author.setUrl("https://n1netails.com/");
        author.setIcon_url("https://raw.githubusercontent.com/n1netails/n1netails/refs/heads/main/n1netails_icon_transparent.png");

        Embed.EmbedField field = new Embed.EmbedField();
        field.setName("Environment");
        field.setValue("Development");
        field.setInline(true);

        Embed.Footer footer = new Embed.Footer();
        footer.setText("N1ne Tails @ 2024");
        footer.setIcon_url("https://raw.githubusercontent.com/n1netails/n1netails/refs/heads/main/n1netails_icon_transparent.png");

        Embed.Image image = new Embed.Image();
        image.setUrl("https://raw.githubusercontent.com/n1netails/n1netails/refs/heads/main/n1netails_icon_transparent.png");

        Embed.Thumbnail thumbnail = new Embed.Thumbnail();
        thumbnail.setUrl("hhttps://raw.githubusercontent.com/n1netails/n1netails/refs/heads/main/n1netails_icon_transparent.png");

        Embed embed2 = new EmbedBuilder()
                .withTitle("Build Notification")
                .withDescription("The build has succeeded ✅")
                .withUrl("https://n1netails.com/")
                .withColor(DiscordColor.BLUE.getValue())
                .withAuthor(author)
                .withFields(Collections.singletonList(field))
                .withFooter(footer)
                .withImage(image)
                .withThumbnail(thumbnail)
                .withTimestamp(Instant.now().toString())
                .build();

        WebhookMessage msg2 = new WebhookMessageBuilder()
                .withUsername("CI Bot")
                .withContent("Deployment update")
                .withEmbeds(Collections.singletonList(embed2))
                .build();
        webhookClient.sendMessage(webhookUrl, msg2);
    }
}

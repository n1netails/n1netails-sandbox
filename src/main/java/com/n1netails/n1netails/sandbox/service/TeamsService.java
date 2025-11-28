package com.n1netails.n1netails.sandbox.service;

import com.n1netails.n1netails.teams.api.TeamsWebhookClient;
import com.n1netails.n1netails.teams.exception.TeamsWebhookException;
import com.n1netails.n1netails.teams.model.Fact;
import com.n1netails.n1netails.teams.model.MessageCard;
import com.n1netails.n1netails.teams.model.Section;
import com.n1netails.n1netails.teams.model.WebhookMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
        // simple message
        WebhookMessage message = new com.n1netails.n1netails.teams.model.WebhookMessage();
        message.setContent("Hello, from n1netails-teams-webhook-client!");
        webhookClient.sendMessage(webhookUrl, message);


        // message card
        MessageCard messageCard = new MessageCard();
        messageCard.setTitle("Message Card Title");
        messageCard.setSummary("Message Card Summary");

        List<Section> sections = new ArrayList<>();
        Section section = new Section();
        section.setTitle("Section Title");

        List<Fact> facts = new ArrayList<>();
        facts.add(new Fact("Fact 1", "Fact 1 Value"));
        facts.add(new Fact("Fact 2", "Fact 2 Value"));
        section.setFacts(facts);
        sections.add(section);

        messageCard.setSections(sections);
        webhookClient.sendMessage(webhookUrl, messageCard);
    }
}

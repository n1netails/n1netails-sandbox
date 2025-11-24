package com.n1netails.n1netails.sandbox.service;

import com.n1netails.n1netails.slack.api.SlackClient;
import com.n1netails.n1netails.slack.exception.SlackClientException;
import com.n1netails.n1netails.slack.model.SlackMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SlackService implements CommunicationPlatform {

    @Value("${n1netails.sandbox.slack.channel}")
    private String channel;

    private final SlackClient slackClient;

    public SlackService(SlackClient slackClient) {
        this.slackClient = slackClient;
    }

    @Override
    public void sendNotification() throws SlackClientException {
        // Create the message
        SlackMessage message = new SlackMessage();
        message.setChannel(channel);
        message.setText("Hello from the N1ne Tails Slack Client!");
        // Send the message
        slackClient.sendMessage(message);
    }
}

package com.n1netails.n1netails.sandbox.service;

import com.n1netails.n1netails.slack.api.SlackClient;
import com.n1netails.n1netails.slack.exception.SlackClientException;
import com.n1netails.n1netails.slack.model.SlackMessage;
import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.composition.BlockCompositions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
        SlackMessage message = new SlackMessage();
        message.setChannel(channel);
        message.setText("This is a fallback message for notifications.");
        message.setBlocks(Arrays.asList(
                Blocks.section(section -> section.text(BlockCompositions.markdownText("*This is a message with blocks.*")))
        ));
        slackClient.sendMessage(message);
    }
}

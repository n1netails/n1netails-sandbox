package com.n1netails.n1netails.sandbox.service;

import com.n1netails.n1netails.telegram.api.TelegramClient;
import com.n1netails.n1netails.telegram.exception.TelegramClientException;
import com.n1netails.n1netails.telegram.model.Button;
import com.n1netails.n1netails.telegram.model.InlineKeyboardMarkup;
import com.n1netails.n1netails.telegram.model.TelegramMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TelegramService implements CommunicationPlatform {

    @Value("${n1netails.sandbox.telegram.bot-token}")
    private String botToken;
    @Value("${n1netails.sandbox.telegram.chat-id}")
    private String chatId;

    private final TelegramClient telegramClient;

    public TelegramService(TelegramClient telegramClient) {
        this.telegramClient = telegramClient;
    }

    @Override
    public void sendNotification() throws TelegramClientException {
        Button button = new Button("Visit N1netails", "https://n1netails.com");
        Button dashboardButton = new Button("Dashboard", "https://app.n1netails.com");
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(List.of(Arrays.asList(button, dashboardButton)));
        TelegramMessage telegramMessage = new TelegramMessage("N1netails Telegram Works!", false, keyboardMarkup);
        telegramClient.sendMessage(chatId, botToken, telegramMessage);
    }
}

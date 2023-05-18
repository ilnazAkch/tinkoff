package ru.tinkoff.edu.bot.tg;

import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

public class SendMessagerer {
    private final SendMessage message;

    public SendMessagerer(Long chatId, String text) {
        this.message = new SendMessage(chatId, text)
                .parseMode(ParseMode.Markdown);
    }

    public SendMessage getSendMessage() {
        return message;
    }
}

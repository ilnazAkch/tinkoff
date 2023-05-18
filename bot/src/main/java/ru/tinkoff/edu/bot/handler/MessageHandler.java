package ru.tinkoff.edu.bot.handler;

import com.pengrad.telegrambot.model.Update;
import ru.tinkoff.edu.bot.tg.TGBot;

public abstract class MessageHandler {
    protected MessageHandler nextHandler;

    protected TGBot TGBot;

    protected final String DEFAULT_MASSAGE = "Команда обработана: ";

    public MessageHandler(TGBot TGBot) {
        this.TGBot = TGBot;
    }


    public MessageHandler setNextHandler(MessageHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract void handleMessage(Update update);
}

package ru.tinkoff.edu.bot.handler;

import com.pengrad.telegrambot.model.Update;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.bot.tg.TGBot;
import ru.tinkoff.edu.bot.tg.SendMessagerer;

@Component
final class DefaultHandler extends MessageHandler{

    public DefaultHandler(TGBot TGBot) {
        super(TGBot);
    }

    @Override
    public void handleMessage(Update update) {
        TGBot.send(new SendMessagerer(update.message().chat().id(), "Нет подходящего обработчика")
                .getSendMessage()
        );
    }
}

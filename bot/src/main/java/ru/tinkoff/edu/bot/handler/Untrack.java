package ru.tinkoff.edu.bot.handler;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.bot.client.ScrapperClient;
import ru.tinkoff.edu.bot.tg.TGBot;
import ru.tinkoff.edu.bot.tg.SendMessagerer;

@Component
@Slf4j
public class Untrack extends MessageHandler{

    private final ScrapperClient scrapperClient;

    public Untrack(TGBot TGBot, ScrapperClient scrapperClient) {
        super(TGBot);
        this.scrapperClient = scrapperClient;
    }

    @Override
    public void handleMessage(Update update) {
        Message message = update.message();
        if (message.text().equals("/untrack")) {

            TGBot.send(new SendMessagerer(message.chat().id(), DEFAULT_MASSAGE + "untrack")
                    .getSendMessage());
        } else {
            nextHandler.handleMessage(update);
        }
    }
}

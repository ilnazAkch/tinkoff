package ru.tinkoff.edu.bot.handler;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.bot.tg.TGBot;
import ru.tinkoff.edu.bot.tg.SendMessagerer;

@Component
public class Help extends MessageHandler {
    private String HELP_MESSAGE;

    public Help(TGBot TGBot) {
        super(TGBot);
    }

    @Override
    public void handleMessage(Update update) {
        Message message = update.message();
        if (message.text().equals("/help")) {
            TGBot.send(new SendMessagerer(message.chat().id(), getHelpMessage())
                    .getSendMessage());
        } else {
            nextHandler.handleMessage(update);
        }
    }

    private String getHelpMessage() {
        if (HELP_MESSAGE == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("/start -- зарегистрировать пользователя\n")
                    .append("/help -- вывести окно с командами\n")
                    .append("/track -- начать отслеживание ссылки\n")
                    .append("/untrack -- прекратить отслеживание ссылки\n")
                    .append("/list -- показать список отслеживаемых ссылок\n");
            HELP_MESSAGE = sb.toString();
        }
        return HELP_MESSAGE;
    }
}

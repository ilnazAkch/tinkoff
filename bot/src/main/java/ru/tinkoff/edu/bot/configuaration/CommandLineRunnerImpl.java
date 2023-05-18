package ru.tinkoff.edu.bot.configuaration;

import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.bot.handler.MessageHandler;
import ru.tinkoff.edu.bot.tg.TGBot;

@Component
@RequiredArgsConstructor
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final TGBot TGBot;
    private final MessageHandler messageHandler;

    @Override
    public void run(String... args) { //решаю проблему циклической зависимости
        TGBot.getTelegramBot().setUpdatesListener(updates -> {
            for (Update update : updates) {
                messageHandler.handleMessage(update);
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
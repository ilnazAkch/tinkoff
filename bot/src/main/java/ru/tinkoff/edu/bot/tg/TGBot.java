package ru.tinkoff.edu.bot.tg;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Getter
public class TGBot {

    private final TelegramBot telegramBot;
    private final ApplicationContext applicationContext;

    public <T extends BaseRequest<T, R>, R extends BaseResponse> void send(T request) {
        telegramBot.execute(request, new Callback<T, R>() {
            @Override
            public void onResponse(T request, R response) {
                System.out.println("onResponse");
            }

            @Override
            public void onFailure(T request, IOException e) {
                System.out.println("onFailure");
                e.printStackTrace();
            }
        });
    }
}

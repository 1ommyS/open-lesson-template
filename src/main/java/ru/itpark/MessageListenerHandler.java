package ru.itpark;

import lombok.SneakyThrows;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.Random;

public class MessageListenerHandler implements LongPollingSingleThreadUpdateConsumer {
    TelegramClient client = new OkHttpTelegramClient("token");
    Random randomGenerator = new Random();

    @SneakyThrows
    @Override
    public void consume(Update update) {
       
    }
}

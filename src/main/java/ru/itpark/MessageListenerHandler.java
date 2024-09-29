package ru.itpark;

import lombok.SneakyThrows;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.Random;

public class MessageListenerHandler implements LongPollingSingleThreadUpdateConsumer {
    TelegramClient client = new OkHttpTelegramClient("7727206414:AAHKbGMYVtveLD0XODj2xIJ8q6N213lueQ8");
    Random randomGenerator = new Random();
    int myNumber = randomGenerator.nextInt(0, 100);

    @Override
    public void consume(Update update) {
        if (update.hasMessage() == true) {
            Message messageFromUser = update.getMessage();

            if (messageFromUser.hasText() == true) {
                String textFromMessage = messageFromUser.getText();

                if (textFromMessage.equals("/start") == true) {
                    SendMessage messageToSend = new SendMessage(messageFromUser.getChatId().toString(),
                            "Привет! Я загадал число от 0 до 100! Попробуй угадать");

                    try {
                        client.execute(messageToSend);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    int guessedNumber = Integer.parseInt(textFromMessage);

                    if (guessedNumber == myNumber) {
                        SendMessage messageToSend = new SendMessage(messageFromUser.getChatId().toString(),
                                "Ты угадал число");

                        try {
                            client.execute(messageToSend);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (myNumber > guessedNumber) {
                        SendMessage messageToSend = new SendMessage(messageFromUser.getChatId().toString(),
                                "Мое число больше твоего");

                        try {
                            client.execute(messageToSend);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (myNumber < guessedNumber) {
                        SendMessage messageToSend = new SendMessage(messageFromUser.getChatId().toString(),
                                "Мое число меньше твоего");

                        try {
                            client.execute(messageToSend);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}

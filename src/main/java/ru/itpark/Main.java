package ru.itpark;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Main {
    public static void main(String[] args) {


        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot("token", new MessageListenerHandler());


            Thread.currentThread().join();

        } catch (Exception e) {
            System.err.println("Error while registering bot  " + e.getMessage());
        }
    }
}
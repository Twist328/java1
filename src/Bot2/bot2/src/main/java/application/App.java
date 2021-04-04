package application;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("hello java!");
        TelegramBot bot = new TelegramBot("1675589814:AAFoAl8VGq5nFxSX0_OfP584DJkn43i5nn8");
        bot.setUpdatesListener(updates -> {
            updates.forEach(update -> {

                Keyboard keyboard = new ReplyKeyboardMarkup(new String[]{"button1", "button2"});


                System.out.println(update.toString());
                bot.execute(new SendMessage(update.message().chat().id(), "Hello!").replyToMessageId(update.message().messageId()),

                        new Callback<SendMessage, SendResponse>() {

                            @Override
                            public void onResponse(SendMessage request, SendResponse response) {
                                System.out.println(response.toString());
                            }
                            @Override
                            public void onFailure(SendMessage request, IOException e) {
                            }
                        });
                bot.execute(new SendAudio(update.message().chat().id(),
                        new File("audio/AC-DC - Thunderstruck.mp3")).replyMarkup(keyboard));
               
                bot.execute(new SendVideo(update.message().chat().id(),
                        new File("audio/ac-dc-big-gun_241127.mp4")).replyMarkup(keyboard));
                bot.execute(new SendDocument(update.message().chat().id(),
                        new File("audio/maxresdefault.jpg")).replyMarkup(keyboard));
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
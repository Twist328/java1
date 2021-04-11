package application;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Location;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static final String ONE = "audio/AC-DC - Thunderstruck.mp3";
    public static final String TWO = "audio/ac-dc-big-gun_241127.mp4";
    public static final String AUDIO_MAXRESDEFAULT_JPG = "audio/maxresdefault.jpg";


    public static void main(String[] args) throws IOException {
        System.out.println("hello java!");
        TelegramBot bot = new TelegramBot("1675589814:AAFoAl8VGq5nFxSX0_OfP584DJkn43i5nn8");
        bot.setUpdatesListener(updates -> {
            updates.forEach(update -> {

                Keyboard keyboard = new ReplyKeyboardMarkup(new String[]{
                        ONE, TWO});


                List<Keyboard> keyboardList = new ArrayList<>();
                keyboardList.add(keyboard);


               // bot.execute(new SendVideo(update.message().chat().id(),
                        //new File("audio/ac-dc-big-gun_241127.mp4")).replyMarkup(keyboard));

                    bot.execute(new SendMessage(update.message().chat().id(), "Hello!" +
                                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY ")) +
                                    (LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm "))))
                                    .replyToMessageId(update.message().messageId()),

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

                            });

                   // bot.execute(new SendAudio(update.message().chat().id(),
                           // new File("audio/AC-DC - Thunderstruck.mp3")).replyMarkup(keyboard));



            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });


    }
}

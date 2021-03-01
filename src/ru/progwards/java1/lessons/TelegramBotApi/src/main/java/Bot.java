import org.telegram.telegrambots.ApiContextInitializer;

import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {


    public static void main(String[] args) {
        ApiContextInitializer.init ();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi ();
        try {
            telegramBotsApi.registerBot (new Bot ());
        } catch (TelegramApiException e) {
            e.printStackTrace ();
        }
    }

    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage ();
        sendMessage.enableMarkdown (true);
        sendMessage.setChatId (message.getChatId ().toString ());
        sendMessage.setReplyToMessageId (message.getMessageId ());
        sendMessage.setText (text);
        try {
           // setButtons (sendMessage);
            sendMessage (sendMessage);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public String getBotUsername() {
        return "SubWeathBot";
    }

    public String getBotToken() {
        return "1675589814:AAFoAl8VGq5nFxSX0_OfP584DJkn43i5nn8";
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage ();
        SendMessage sendMessage = new SendMessage ();
        if (message != null && message.hasText ()) {
            switch (message.getText ()) {
                case "/help":
                    try {
                        execute (sendMessage.setText (message.getText () + "Чем я могу помочь?"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace ();
                    }
                    break;
                case "/settings":
                    try {
                        execute (sendMessage.setText (message.getText () + "Что будем отлаживать?"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace ();
                    }
                    break;
                default:
            }
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
    }
    }

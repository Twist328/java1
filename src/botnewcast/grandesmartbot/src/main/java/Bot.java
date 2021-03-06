import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    public static final String COLA_DRINKS = "Cola drinks";
    private static final String WHAT_THE_TIME_REQUEST = "What the time current";
    private static final String WHAT_THE_DATE_REQUEST = "What the datetime current";
    private static final String WHAT_IS_CAPITAL_OF_USD_REQUEST = "What is the capital of USD current";
    private static final String ORDER_PIZZA_REQUEST = "Order pizza";
    public static final String ROLLS_YAPOSH_SET_8 = "Rolls Yaposh set 8";
    public static final String TH_CHEESE_36_AS_USUAL = "4 th cheese 36 as usual";
    public static final String KARBONARA_36_AS_USUAL = "Karbonara 36 as usual";

    public static void main(String[] args) {
        System.out.println ("Hello bot!");

        ApiContextInitializer.init ();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi ();

        try {
            telegramBotsApi.registerBot (new Bot ());

        } catch (TelegramApiRequestException e) {
            e.printStackTrace ();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        Pattern pattern = new Pattern ();
        Message message = update.getMessage ();

        SendMessage responce = new SendMessage ();

        responce.setText ("Привет,   " + message.getFrom ().getFirstName ()
                + "! Вы мне прислали: " + message.getText ());
        message.getText ();

        responce.setChatId (message.getChatId ());
        responce.setReplyMarkup (getMainMenu ());
        try {
            execute (getResponceMessage (message));
        } catch (TelegramApiException e) {
            e.printStackTrace ();
        }

    }

    private SendMessage getResponceMessage(Message message) {
        switch (message.getText ()) {
            case WHAT_THE_TIME_REQUEST:
                return getCurrentTimeResponce (message);
            case ORDER_PIZZA_REQUEST:
                return getOrderPizza (message);
            case WHAT_THE_DATE_REQUEST:
                return getCurrentDateResponce (message);
            default:
                return greetingMessage (message);
        }

    }

    private SendMessage greetingMessage(Message message) {
        SendMessage responce = new SendMessage ();
        responce.setText ("Привет,   " + message.getFrom ().getFirstName ()
                + "! Вы мне прислали: " + message.getText () + Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_SMILING_EYES);

        responce.setChatId (message.getChatId ());
        responce.setReplyMarkup (getMainMenu ());
        return responce;
    }

    @Override
    public String getBotUsername() {
        return "SmartyKomBot";
    }

    @Override
    public String getBotToken() {
        return "1646881099:AAFbUeLTpwokLtWjJk0xQlFuxhVdzEantPU";
    }

    private ReplyKeyboardMarkup getMainMenu() {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup ();

        KeyboardRow row1 = new KeyboardRow ();

        row1.add (WHAT_THE_TIME_REQUEST);
        row1.add (WHAT_THE_DATE_REQUEST);

        KeyboardRow row2 = new KeyboardRow ();

        row2.add (WHAT_IS_CAPITAL_OF_USD_REQUEST);
        row2.add (ORDER_PIZZA_REQUEST);

        List<KeyboardRow> rows = new ArrayList<> ();
        rows.add (row1);
        rows.add (row2);
        markup.setKeyboard (rows);
        return markup;
    }

    private SendMessage getCurrentTimeResponce(Message message) {
        SendMessage responce = new SendMessage ();
        responce.setText (LocalDateTime.now ().format (DateTimeFormatter.ofPattern ("HH:mm")));
        responce.setChatId (message.getChatId ());
        responce.setReplyMarkup (getMainMenu ());
        return responce;
    }

    private SendMessage getCurrentDateResponce(Message message) {
        SendMessage responce = new SendMessage ();
        responce.setText (LocalDateTime.now ().format (DateTimeFormatter.ofPattern ("dd-MM-YYYY")));
        responce.setChatId (message.getChatId ());
        responce.setReplyMarkup (getMainMenu ());
        return responce;
    }

    private ReplyKeyboardMarkup creatChoisePizzaMenu() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup ();

        KeyboardRow row1 = new KeyboardRow ();

        row1.add (KARBONARA_36_AS_USUAL);
        row1.add (TH_CHEESE_36_AS_USUAL);

        KeyboardRow row2 = new KeyboardRow ();

        row2.add (ROLLS_YAPOSH_SET_8);
        row2.add (COLA_DRINKS);

        List<KeyboardRow> rows = new ArrayList<> ();
        rows.add (row1);
        rows.add (row2);
        markup.setKeyboard (rows);
        return markup;
    }

    private SendMessage getOrderPizza(Message message) {
        SendMessage responce = new SendMessage ();
        responce.setText ("Please make your chois:)" + Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_TIGHTLY_CLOSED_EYES);
        responce.setReplyMarkup (creatChoisePizzaMenu ());
        responce.setChatId (message.getChatId ());
        return responce;
    }
}

enum Emoji {
    // Emoticones group
    GRINNING_FACE_WITH_SMILING_EYES ('\uD83D', '\uDE01'),
    FACE_WITH_TEARS_OF_JOY ('\uD83D', '\uDE02'),
    SMILING_FACE_WITH_OPEN_MOUTH ('\uD83D', '\uDE03'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_SMILING_EYES ('\uD83D', '\uDE04'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_COLD_SWEAT ('\uD83D', '\uDE05'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_TIGHTLY_CLOSED_EYES ('\uD83D', '\uDE06'),
    WINKING_FACE ('\uD83D', '\uDE09');

    Character firstChar;
    Character secondChar;

    Emoji(Character firstChar, Character secondChar) {
        this.firstChar = firstChar;
        this.secondChar = secondChar;
    }

    Emoji() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder ();

        if (this.firstChar != null) {
            sb.append (this.firstChar);
        }
        if (this.secondChar != null) {
            sb.append (this.secondChar);
        }

        return sb.toString ();
    }
}
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

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Bot extends TelegramLongPollingBot {
    private static final String WHAT_THE_DATE_REQUEST = "Какой сегодня день?";
    public static final String ПРИВЕТ = "Привет!!!";
    public static final String НУ_И_КАК_ПОГОДА = "Ну и как погода?";
    private static final String WHAT_THE_TIME_REQUEST= "Который час?";
    public static final String START = "/start";
    public static final String HELP = "/help";
    public static final String СПАСИБО = "Спасибо";
    private Update update;

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
    public String getBotUsername() {
        return "SmartyKomBot";
    }

    @Override
    public String getBotToken() {
        return "1646881099:AAFbUeLTpwokLtWjJk0xQlFuxhVdzEantPU";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Pattern pattern = new Pattern ();
        Message message = update.getMessage ();
        SendMessage responce = new SendMessage ();
        responce.setText ("Привет,   " + message.getFrom ().getFirstName ()
                + "! Обрабатываю ваш запрос: " + message.getText ());
        responce.setChatId (message.getChatId ());
        responce.setReplyMarkup (getMainMenu ());
        if (message != null && message.hasText ()) {

            try {
                execute (getResponceMessage (message));
            } catch (TelegramApiException | IOException e) {
                e.printStackTrace ();
            }
            switch (message.getText ()) {
                case "/start":
                    sendMsg (message, " Мой друг, я смогу показать дату-время, а также погоду!" +
                            "  Воспользуйся клавиатурой "+Emoji.GRINNING_FACE_WITH_SMILING_EYES);
                    break;
                case WHAT_THE_TIME_REQUEST:
                    try {
                        execute(getCurrentTimeResponce (message));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case WHAT_THE_DATE_REQUEST:
                    try {
                        execute(getCurrentDateResponce (message));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case ПРИВЕТ:
                     sendMsg (message, " Я Бот-У, показываю Погод-y! Напиши город!" );
                     break;
                case "/help":
                    sendMsg (message, " Что пошло не так?\nНапишите город и я пришлю погоду в нём! Либо нажмите на встроенную клавиатуру"+Emoji.FACE_WITH_TEARS_OF_JOY);
                    break;
                case СПАСИБО:
                    try {
                        execute(getThanks(message));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Тупой бот":
                    sendMsg(message," Не ошибаются те, кто ничего не делает");
                    break;
                default:
                    try {
                        sendMsg (message, Climat.getWeather (message.getText (), pattern));
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
            }
        }
    }

    public SendMessage sendMsg(Message message, String text) {
        SendMessage responce = new SendMessage ();
        responce.enableMarkdown (true);

        responce.setChatId (message.getChatId ().toString ());

        responce.setReplyToMessageId (message.getMessageId ());

        responce.setText (text);
        try {
            sendMessage (responce);
            responce.setChatId (String.valueOf (getMainMenu ()));
            responce.setReplyMarkup (getMainMenu ());

        } catch (TelegramApiException e) {
            e.printStackTrace ();
        }
        return responce;
    }

    public Bot() {
        super ();
    }

    private SendMessage getResponceMessage(Message message) throws IOException {
        Pattern pattern = new Pattern ();
        switch (message.getText ()) {
            case НУ_И_КАК_ПОГОДА:
                return sendMsg (message, " Напиши город!" );
            /*case "Спасибо":
                return getThanks(message);*/
            default:
                return greetingMessage (message);
        }

    }

    private SendMessage greetingMessage(Message message) {
        SendMessage responce = new SendMessage ();
        responce.setText ("Привет,   " + message.getFrom ().getFirstName ()
                + "! Получил команду: " + message.getText () + Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_SMILING_EYES);

        responce.setChatId (message.getChatId ());
        responce.setReplyMarkup (getMainMenu ());
        return responce;
    }


    private ReplyKeyboardMarkup getMainMenu() {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup ();

        KeyboardRow row1 = new KeyboardRow ();

        row1.add (WHAT_THE_TIME_REQUEST);
        row1.add (WHAT_THE_DATE_REQUEST);
        row1.add (START);

        KeyboardRow row2 = new KeyboardRow ();

        row2.add (ПРИВЕТ);
        row2.add (СПАСИБО);
        row2.add (HELP);

        List<KeyboardRow> rows = new ArrayList<> ();
        rows.add (row1);
        rows.add (row2);
        markup.setKeyboard (rows);
        return markup;
    }

    private SendMessage getCurrentTimeResponce(Message message) {
        SendMessage responce = new SendMessage ();
        responce.setText (LocalDateTime.now ().format (DateTimeFormatter.ofPattern ("Сейчас " + "HH:mm ")) + Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_COLD_SWEAT);
        responce.setChatId (message.getChatId ());
        responce.setReplyMarkup (getMainMenu ());
        return responce;
    }

    private SendMessage getCurrentDateResponce(Message message) {
        SendMessage responce = new SendMessage ();
        responce.setText (LocalDateTime.now ().format (DateTimeFormatter.ofPattern ("Сегодня   " + "dd-MM-YYYY ")) + Emoji.WINKING_FACE);
        responce.setChatId (message.getChatId ());
        responce.setReplyMarkup (getMainMenu ());
        return responce;
    }

    /* private SendMessage getCurrentWeaterResponce(Message message) throws IOException {
         Pattern pattern = new Pattern ();
         SendMessage responce = new SendMessage ();
         sendMsg (message, Climat.getWeather (message.getText (), pattern));
         responce.setChatId (message.getChatId ());
         responce.setReplyMarkup (getMainMenu ());
         return responce;
     }*/
    private ReplyKeyboardMarkup creatChoisePizzaMenu() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup ();

        KeyboardRow row1 = new KeyboardRow ();

        //row1.add (KARBONARA_36_AS_USUAL);
        //row1.add (TH_CHEESE_36_AS_USUAL);

        KeyboardRow row2 = new KeyboardRow ();

        //row2.add (ROLLS_YAPOSH_SET_8);
        //row2.add (COLA_DRINKS);

        List<KeyboardRow> rows = new ArrayList<> ();
        rows.add (row1);
        rows.add (row2);
        markup.setKeyboard (rows);
        return markup;
    }

    private SendMessage getThanks(Message message) {
        SendMessage responce = new SendMessage ();
        responce.setText ("Всегда к вашим услугам)" + Emoji.WINKING_FACE);
        responce.setReplyMarkup (creatChoisePizzaMenu ());
        responce.setChatId (message.getChatId ());
        return responce;
    }
}

enum Emoji {

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
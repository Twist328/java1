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

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;


public class Bot extends TelegramLongPollingBot {

    public static final String MOSCOW = "Москва";
    public static final String CURRENCY_RATES = "Курсы валют";
    private static final String WHAT_THE_DATE_REQUEST = "Дата";
    public static final String HELLO = "Привет!!!";
    public static final String НУ_И_КАК_ПОГОДА = "Ну и как погода?";
    private static final String WHAT_THE_TIME_REQUEST = "Который час?";
    public static final String START = "/START";
    public static final String HELP = "/HELP";
    public static final String THANKS = "Спасибо";
    public static final String WEATHER_IN_TOWN = "ПОГОДА В ГОРОДЕ";
    public static final String ST_PETERSBURG = "Санкт-Петербург";
    public static final String СHINA = "Пекин";
    public static final String SOCHI = "Сочи";
    public static final String NEW_YORK = "Нью-Йорк";
    public static final String PARIS = "Париж";
    public static final String LONDON = "Лондон";
    public static final String PHUKET = "Пхукет";
    public static final String DULL_BOT = "Тупой бот";
    public static final String USD = "USD";
    public static final String JPY = "JPY";
    public static final String GBP = "GBP";
    public static final String EUR = "EUR";
    private Update update;

    public static void main(String[] args) throws IOException {
        out.println("Hello bot!");

        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new Bot());

        } catch (TelegramApiRequestException | MalformedURLException e) {
            e.printStackTrace();
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

        Pattern pattern = new Pattern();
        Message message = update.getMessage();
        SendMessage responce = new SendMessage();
        responce.setText("Привет,   " + message.getFrom().getFirstName()
                + " ! Обрабатываю ваш запрос: " + message.getText());
        responce.setChatId(message.getChatId());
        responce.setReplyMarkup(getMainMenu());
        if (message != null && message.hasText()) {

            try {
                execute(getResponceMessage(message));
            } catch (TelegramApiException | IOException e) {
                e.printStackTrace();
            }
            switch (message.getText()) {
                case START:
                    sendMsg(message, " Я БОТ БЕЗ ХЛОПОТ, УМЕЮ ПОКАЗЫВАТЬ ДАТУ/ВРЕМЯ ,ПОГОДУ В ЛЮБОМ УГОЛКЕ МИРА, КУРСЫ ОСНОВНЫХ ВАЛЮТ,\n" +
                            "ВЫБЕРИ МЕНЮ В IN-LINE КЛАВИАТУРЕ " + Emoji.GRINNING_FACE_WITH_SMILING_EYES);
                    break;
                case WHAT_THE_TIME_REQUEST:
                    try {
                        execute(getCurrentTimeResponce(message));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case WHAT_THE_DATE_REQUEST:
                    try {
                        execute(getCurrentDateResponce(message));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                case GBP:
                    sendMsg(message, " Курс GBP (ЦБ РФ) 102,49 " + Emoji.GRINNING_FACE_WITH_SMILING_EYES);
                    break;
                case JPY:
                    sendMsg(message, " Курс JPY (ЦБ РФ) 67,35" + Emoji.GRINNING_FACE_WITH_SMILING_EYES);
                    break;
                case EUR:
                    sendMsg(message, " Курс EUR (ЦБ РФ) 87,80 " + Emoji.GRINNING_FACE_WITH_SMILING_EYES);
                    break;
                case USD:
                    sendMsg(message, " Курс USD (ЦБ РФ) 73,51 " + Emoji.GRINNING_FACE_WITH_SMILING_EYES);
                    break;
                case "/help":
                    sendMsg(message, " Что-то пошло не так?\n Выберите пункт меню на на in-line клавиатуре" + Emoji.FACE_WITH_TEARS_OF_JOY);
                    break;
                case THANKS:
                    try {
                        execute(getThanks(message));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case CURRENCY_RATES:
                    try {
                        execute(getMoneyRates(message));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case WEATHER_IN_TOWN:
                    try {

                        execute(getWeather(message));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Тупой бот":
                    sendMsg(message, " Дружище! Я Вас понимаю,но не ошибаются те, кто ничего не делает, " +
                            "а также те которые тупее тупых Ботов (они просто ни чего не могут))) " + Emoji.WINKING_FACE);
                    break;
                default:
                    try {
                        sendMsg(message, Climat.getWeather(message.getText(), pattern));
                    } catch (IOException e) {
                        sendMsg(message, " К сожалению такой город я не нашёл" + Emoji.FACE_WITH_TEARS_OF_JOY +
                                Emoji.FACE_WITH_TEARS_OF_JOY + Emoji.FACE_WITH_TEARS_OF_JOY + "\n Введите другой город");
                    }
            }
        }
    }

    public SendMessage sendMsg(Message message, String text) {
        SendMessage responce = new SendMessage();
        responce.enableMarkdown(true);

        responce.setChatId(message.getChatId().toString());

        responce.setReplyToMessageId(message.getMessageId());

        responce.setText(text);
        try {
            sendMessage(responce);
            responce.setChatId(String.valueOf(getMainMenu()));
            responce.setReplyMarkup(getMainMenu());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return responce;
    }

    public Bot() throws IOException {
        super();
    }

    private SendMessage getResponceMessage(Message message) throws IOException {
        switch (message.getText()) {
            case НУ_И_КАК_ПОГОДА:
                return sendMsg(message, " Напиши город!");

            default:
                return greetingMessage(message);
        }

    }

    private SendMessage greetingMessage(Message message) {
        SendMessage responce = new SendMessage();
        responce.setText("Привет,   " + message.getFrom().getFirstName()
                + " ! Исполняю : " + message.getText() + Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_SMILING_EYES);

        responce.setChatId(message.getChatId());
        responce.setReplyMarkup(getMainMenu());
        return responce;
    }


    private ReplyKeyboardMarkup getMainMenu() {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardRow row1 = new KeyboardRow();

        row1.add(START);
        row1.add(WHAT_THE_TIME_REQUEST);
        row1.add(WHAT_THE_DATE_REQUEST);
        row1.add(HELP);

        KeyboardRow row2 = new KeyboardRow();


        row2.add(WEATHER_IN_TOWN);
        row2.add(THANKS);
        row2.add(DULL_BOT);
        row2.add(CURRENCY_RATES);

        List<KeyboardRow> rows = new ArrayList<>();

        rows.add(row1);
        rows.add(row2);

        markup.setKeyboard(rows);
        return markup;
    }

    private SendMessage getCurrentTimeResponce(Message message) {
        SendMessage responce = new SendMessage();
        responce.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("Сейчас " + "HH:mm ")) + Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_COLD_SWEAT);
        responce.setChatId(message.getChatId());
        responce.setReplyMarkup(getMainMenu());
        return responce;
    }

    /*URL url = new URL("http://api.coingate.com/v2/rates/merchant/EUR/RUB");
   BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(), "UTF-8")) {
              while(true){
        String line = reader.readLine();
        if(line ==null)
                break;
            System.out.println(line);
    }*/


    private SendMessage getCurrentDateResponce(Message message) {
        SendMessage responce = new SendMessage();
        responce.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("Сегодня   " + "dd-MM-YYYY ")) + Emoji.WINKING_FACE);
        responce.setChatId(message.getChatId());
        responce.setReplyMarkup(getMainMenu());
        return responce;

    }


    private ReplyKeyboardMarkup creatChoiseSity() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardRow row1 = new KeyboardRow();

        row1.add(MOSCOW);
        row1.add(ST_PETERSBURG);
        row1.add(NEW_YORK);
        row1.add(PHUKET);


        KeyboardRow row2 = new KeyboardRow();

        row2.add(СHINA);
        row2.add(SOCHI);
        row2.add(PARIS);
        row2.add(LONDON);

        List<KeyboardRow> rows = new ArrayList<>();

        rows.add(row1);
        rows.add(row2);

        markup.setKeyboard(rows);
        return markup;
    }

    private ReplyKeyboardMarkup creatChoiseMoney() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardRow row1 = new KeyboardRow();

        row1.add(USD);
        row1.add(JPY);
        //row1.add(НЬЮ_ЙОРК);
        // row1.add(ПХУКЕТ);


        KeyboardRow row2 = new KeyboardRow();

        row2.add(GBP);
        row2.add(EUR);
        //row2.add(ПАРИЖ);
        // row2.add(ЛОНДОН);

        List<KeyboardRow> rows = new ArrayList<>();

        rows.add(row1);
        rows.add(row2);

        markup.setKeyboard(rows);
        return markup;
    }

    private SendMessage getThanks(Message message) {
        SendMessage responce = new SendMessage();
        responce.setText("Всегда к вашим услугам)" + Emoji.WINKING_FACE);

        responce.setChatId(message.getChatId());
        return responce;
    }

    private SendMessage getWeather(Message message) {
        SendMessage responce = new SendMessage();
        responce.setText("Выберите город, если такого нет- напишите его в строке -Сообщение:)" + Emoji.WINKING_FACE);
        responce.setReplyMarkup(creatChoiseSity());
        responce.setChatId(message.getChatId());
        return responce;
    }

    private SendMessage getMoneyRates(Message message) {
        SendMessage responce = new SendMessage();
        responce.setText("Выберите Валюту:)" + Emoji.WINKING_FACE);
        responce.setReplyMarkup(creatChoiseMoney());
        responce.setChatId(message.getChatId());
        return responce;
    }

    private SendMessage setMoneyCurrentRates(Message message) {
        SendMessage responce = new SendMessage();

        responce.setReplyMarkup(creatChoiseMoney());
        responce.setChatId(message.getChatId());
        return responce;
    }
}

enum Emoji {

    GRINNING_FACE_WITH_SMILING_EYES('\uD83D', '\uDE01'),
    FACE_WITH_TEARS_OF_JOY('\uD83D', '\uDE02'),
    SMILING_FACE_WITH_OPEN_MOUTH('\uD83D', '\uDE03'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_SMILING_EYES('\uD83D', '\uDE04'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_COLD_SWEAT('\uD83D', '\uDE05'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_TIGHTLY_CLOSED_EYES('\uD83D', '\uDE06'),
    WINKING_FACE('\uD83D', '\uDE09');

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
        StringBuilder sb = new StringBuilder();

        if (this.firstChar != null) {
            sb.append(this.firstChar);
        }
        if (this.secondChar != null) {
            sb.append(this.secondChar);
        }

        return sb.toString();
    }
}

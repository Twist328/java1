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

public class Bot extends TelegramLongPollingBot {

    public static final String MOSCOW = "МОСКВА";
    public static final String CURRENCY_RATES = "КУРСЫ ВАЛЮТ";
    private static final String WHAT_THE_DATE_REQUEST = "ДАТА";
    public static final String HELLO = "Привет!!!";
    public static final String НУ_И_КАК_ПОГОДА = "Ну и как погода?";
    private static final String WHAT_THE_TIME_REQUEST = "КОТОРЫЙ\n ЧАС?";
    public static final String START = "/START";
    public static final String HELP = "/HELP";
    public static final String THANKS = "СПАСИБО";
    public static final String WEATHER_IN_TOWN = "ПОГОДА В ГОРОДЕ";
    public static final String ST_PETERSBURG = "САНКТ-ПЕТЕРБУРГ";
    public static final String СHINA = "ПЕКИН";
    public static final String SOCHI = "СОЧИ";
    public static final String NEW_YORK = "НЬЮ-ЙОРК";
    public static final String PARIS = "ПАРИЖ";
    public static final String LONDON = "ЛОНДОН";
    public static final String PHUKET = "ПХУКЕТ";
    public static final String DULL_BOT = "ТУПОЙ БОТ";
    public static final String USD = "USD";
    public static final String JPY = "JPY";
    public static final String GBP = "GBP";
    public static final String EUR = "EUR";
    private Update update;

    public static void main(String[] args) throws IOException {
        System.out.println("Hello bot!");

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
        Model model = new Model();
        Pattern pattern = new Pattern();
        Message message = update.getMessage();
        SendMessage responce = new SendMessage();
        responce.setText("ПРИВЕТ,   " + message.getFrom().getFirstName()
                + " ! ВЫПОЛНЯЮ ЗАПРОС: " + message.getText());
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
                    break;
                case GBP:
                    sendMsg(message, " Курс GBP (ЦБ РФ) 100,96 "+(LocalDateTime.now().format(DateTimeFormatter.ofPattern("СЕГОДНЯ   " + "dd-MM-YYYY ")) + (LocalDateTime.now().format(DateTimeFormatter.ofPattern( "HH:mm ")) + Emoji.GRINNING_FACE_WITH_SMILING_EYES)));
                    break;
                case JPY:
                    sendMsg(message, "Курс 100 JPY (ЦБ РФ) 66,8\n"+(LocalDateTime.now().format(DateTimeFormatter.ofPattern("СЕГОДНЯ  " + "dd-MM-YYYY "))+ (LocalDateTime.now().format(DateTimeFormatter.ofPattern( "HH:mm "))+ Emoji.GRINNING_FACE_WITH_SMILING_EYES)));
                    break;
                case EUR:
                    sendMsg(message, " Курс EUR (ЦБ РФ) 88,25 " +(LocalDateTime.now().format(DateTimeFormatter.ofPattern("СЕГОДНЯ   " + "dd-MM-YYYY "))+ (LocalDateTime.now().format(DateTimeFormatter.ofPattern( "HH:mm ")) + Emoji.GRINNING_FACE_WITH_SMILING_EYES)));
                    break;
                case USD:
                    sendMsg(message, " Курс USD (ЦБ РФ) 72,96 "+(LocalDateTime.now().format(DateTimeFormatter.ofPattern("СЕГОДНЯ   " + "dd-MM-YYYY ")) + (LocalDateTime.now().format(DateTimeFormatter.ofPattern( "HH:mm "))+ Emoji.GRINNING_FACE_WITH_SMILING_EYES)));
                    break;
                case HELP:
                    sendMsg(message, " ЧТО-ТО ПОШЛО НЕ ТАК?\n ВЫБЕРИТЕ ВАРИАНТ МЕНЮ НА IN-LINE КЛАВИАТУРЕ" + Emoji.FACE_WITH_TEARS_OF_JOY);
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
                case "ТУПОЙ БОТ":
                    sendMsg(message, " ДРУЖИЩЕ! Я ВАС ПОНЯЛ,НО НЕ ОШИБАЮТСЯ ТЕ, КТО НИЧЕГО НЕ ДЕЛАЕТ, " +
                            " И ТЕ КТО ЕЩЕ ТУПЕЕ ТУПЫХ БОТОВ" + Emoji.WINKING_FACE);
                    break;
                default:
                    try {
                       //sendMsg(message, Url.readLine(message.getText(), pattern));
                        sendMsg(message, Climat.getWeather(message.getText(), pattern));
                    } catch (IOException e) {
                        sendMsg(message, " К СОЖАЛЕНИЮ ГОРОД НЕ НАЙДЕН" + Emoji.FACE_WITH_TEARS_OF_JOY +
                                Emoji.FACE_WITH_TEARS_OF_JOY + Emoji.FACE_WITH_TEARS_OF_JOY + "\n ВВЕДИТЕ ДРУГОЕ ЗНАЧЕНИЕ");
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
        Model model = new Model();
        switch (message.getText()) {
            case НУ_И_КАК_ПОГОДА:
                return sendMsg(message, " Напиши город!");

            default:
                return greetingMessage(message);
                /*try {
                    sendMsg(message, Url.getRates(message.getText(), model));
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
        }


    }

    private SendMessage greetingMessage(Message message) {
        SendMessage responce = new SendMessage();
        responce.setText("ПРИВЕТ,   " + message.getFrom().getFirstName()
                + " ! ИСПОЛНЯЮ : " + message.getText() + Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_SMILING_EYES);

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
        responce.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("СЕЙЧАС (МСК) " + "HH:mm ")) + Emoji.SMILING_FACE_WITH_OPEN_MOUTH_AND_COLD_SWEAT);
        responce.setChatId(message.getChatId());
        responce.setReplyMarkup(getMainMenu());
        return responce;
    }

    private SendMessage getCurrentDateResponce(Message message) {
        SendMessage responce = new SendMessage();
        responce.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("СЕГОДНЯ   " + "dd-MM-YYYY ")) + Emoji.WINKING_FACE);
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



        KeyboardRow row2 = new KeyboardRow();

        row2.add(GBP);
        row2.add(EUR);

        List<KeyboardRow> rows = new ArrayList<>();

        rows.add(row1);
        rows.add(row2);

        markup.setKeyboard(rows);
        return markup;
    }

    private SendMessage getThanks(Message message) {
        SendMessage responce = new SendMessage();
        responce.setText("ВСЕГДА К ВАШИМ УСЛУГАМ)" + Emoji.WINKING_FACE);

        responce.setChatId(message.getChatId());
        return responce;
    }

    private SendMessage getWeather(Message message) {
        SendMessage responce = new SendMessage();
        responce.setText("ВЫБЕРИТЕ ГОРОД, ИЛИ НАПИШИТЕ НАЗВАНИЕ В СТРОКЕ СООБЩЕНИЯ)" + Emoji.WINKING_FACE);
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

}


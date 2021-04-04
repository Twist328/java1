package chatbots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyGrateBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                String text = message.getText();

                if (text.equals("/start")) {
                    System.out.println("Сообщение пришло");
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Привет бот!");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(message.getChatId());

                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
                    List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
                    InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                    inlineKeyboardButton1.setText("Привет");
                    inlineKeyboardButton2.setText("Как дела");
                    inlineKeyboardButton1.setCallbackData("Здорово");
                    inlineKeyboardButton2.setCallbackData("норм");
                    inlineKeyboardButtonList.add(inlineKeyboardButton1);
                    inlineKeyboardButtonList.add(inlineKeyboardButton2);
                    inlineButtons.add(inlineKeyboardButtonList);
                    inlineKeyboardMarkup.setKeyboard(inlineButtons);

                    sendMessage.setReplyMarkup(inlineKeyboardMarkup);

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
            } else if (update.hasCallbackQuery()) {
                Message message = update.getCallbackQuery().getMessage();
                CallbackQuery callbackQuery = update.getCallbackQuery();
                String data = callbackQuery.getData();
                SendMessage sendMessage = new SendMessage().setParseMode(ParseMode.MARKDOWN).setChatId(message.getChatId());
                if (data.equals("Привет")) {
                    sendMessage.setText("Салам - пополам!!!");
                } else if (data.equals("Как дела")) {
                    sendMessage.setText("Да капец ваще!");
                }
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }


        @Override
        public String getBotUsername () {
            return "PizKomBot";
        }

        @Override
        public String getBotToken () {
            return "1156742283:AAFI-S2YFXccCEwKA7j5pKhup8QfuCr3KDg";
        }
    }
     /*ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    replyKeyboardMarkup.setResizeKeyboard(true).setSelective(true);
                    KeyboardRow keyboardRow1 = new KeyboardRow();
                    KeyboardButton keyboardButton1 = new KeyboardButton();
                    //keyboardButton1.setText("поделиться контактом");
                    keyboardButton1.setText("поделиться местонахождением");
                    //keyboardButton1.setRequestContact(true);
                    keyboardButton1.setRequestLocation(true);
                    keyboardRow1.add(keyboardButton1);*/

                   /* List<KeyboardRow> keyboardRowList = new ArrayList<>();
                    keyboardRowList.add(keyboardRow1);
                    replyKeyboardMarkup.setKeyboard(keyboardRowList);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);*/

     /* }else if (text.equals("выберите язык")){
                    SendMessage sendMessage= new SendMessage()
                    .setText("Добро пожаловать!")
                            .setParseMode(ParseMode.MARKDOWN)
                            .setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }*/
           /* } else if (message.hasContact()) {
                Contact contact = message.getContact();
                SendMessage sendMessage = new SendMessage()
                        .setText("Ваш номер телефона:" + contact.getPhoneNumber())
                        .setParseMode(ParseMode.MARKDOWN)
                        .setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }


            } else if (message.hasLocation()) {
                Location location = message.getLocation();
                SendMessage sendMessage = new SendMessage()
                        .setText("Ваша геопозиция:" + location.getLatitude() + "," + location.getLongitude())
                        .setParseMode(ParseMode.MARKDOWN)
                        .setChatId(message.getChatId());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }*/
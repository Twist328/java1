package chatbots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
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

                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    replyKeyboardMarkup.setResizeKeyboard(true).setSelective(true);
                    KeyboardRow keyboardRow1 = new KeyboardRow();
                    KeyboardButton keyboardButton1 = new KeyboardButton();
                    //keyboardButton1.setText("поделиться контактом");
                    keyboardButton1.setText("поделиться местонахождением");
                    //keyboardButton1.setRequestContact(true);
                    keyboardButton1.setRequestLocation(true);
                    keyboardRow1.add(keyboardButton1);

                    List<KeyboardRow> keyboardRowList = new ArrayList<>();
                    keyboardRowList.add(keyboardRow1);
                    replyKeyboardMarkup.setKeyboard(keyboardRowList);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
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
            } else if (message.hasContact()) {
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
                }
            }
        }
    }
    @Override
    public String getBotUsername() {
        return "PizKomBot";
    }

    @Override
    public String getBotToken() {
        return "1156742283:AAFI-S2YFXccCEwKA7j5pKhup8QfuCr3KDg";
    }
}

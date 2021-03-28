package chatbots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyGrateBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "PizKomBot";
    }

    @Override
    public String getBotToken() {
        return "1156742283:AAFI-S2YFXccCEwKA7j5pKhup8QfuCr3KDg";
    }

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
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

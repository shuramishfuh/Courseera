package Mybot;


import FormaterIMplementation.InputParser;
import FormaterIMplementation.Linker;
import FormaterIMplementation.outPutFormatter;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        // if there is a message that has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // get the text of the message
            String receivedText = update.getMessage().getText();

            // send a reply
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(new outPutFormatter().selector(new Linker().callCoursera(new InputParser().convertStringToInstruction(receivedText))));

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "Cmps252JavaBot";
    }

    @Override
    public String getBotToken() {
        return "2142734392:AAHj31KTvkDYXkCeOCPAyOwER93hrwwmWpM";
    }

}

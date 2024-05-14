package github.f1angz.tmtb.bot;


import github.f1angz.tmtb.command.Command;
import github.f1angz.tmtb.util.PropertiesUtil;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TaskManagerTelegramBot extends TelegramLongPollingBot implements Command {

    private final String BOT_USERNAME = "bot.username";
    private final String BOT_TOKEN = "bot.token";

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();

            SendMessage sm = new SendMessage();
            sm.setChatId(chatId);
            sm.setText(message);

            try {
                execute(sm);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String getBotUsername() {
        return PropertiesUtil.get(BOT_USERNAME);
    }

    @Override
    public String getBotToken() {
        return PropertiesUtil.get(BOT_TOKEN);
    }

    @Override
    public void execute(Update update) {
        
    }
}

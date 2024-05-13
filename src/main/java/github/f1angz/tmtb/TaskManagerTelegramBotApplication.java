package github.f1angz.tmtb;

import github.f1angz.tmtb.bot.TaskManagerTelegramBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TaskManagerTelegramBotApplication {

    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new TaskManagerTelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

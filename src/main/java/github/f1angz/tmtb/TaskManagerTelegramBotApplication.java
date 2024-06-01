package github.f1angz.tmtb;

import github.f1angz.tmtb.bot.TaskManagerTelegramBot;
import github.f1angz.tmtb.repository.TaskRepositoryImpl;
import github.f1angz.tmtb.repository.TelegramUserRepositoryImpl;
import github.f1angz.tmtb.service.TaskService;
import github.f1angz.tmtb.service.TaskServiceImpl;
import github.f1angz.tmtb.service.TelegramUserService;
import github.f1angz.tmtb.service.TelegramUserServiceImpl;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TaskManagerTelegramBotApplication {

    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

            TelegramUserService telegramUserService = new TelegramUserServiceImpl(new TelegramUserRepositoryImpl());
            TaskService taskService = new TaskServiceImpl(new TaskRepositoryImpl());

            telegramBotsApi.registerBot(new TaskManagerTelegramBot(telegramUserService, taskService));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

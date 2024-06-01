package github.f1angz.tmtb.bot;


import github.f1angz.tmtb.command.Command;
import github.f1angz.tmtb.command.CommandContainer;
import github.f1angz.tmtb.service.SendMessageBotServiceImpl;
import github.f1angz.tmtb.service.TaskService;
import github.f1angz.tmtb.service.TelegramUserService;
import github.f1angz.tmtb.service.TelegramUserServiceImpl;
import github.f1angz.tmtb.util.PropertiesUtil;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static github.f1angz.tmtb.command.CommandName.NO;

public class TaskManagerTelegramBot extends TelegramLongPollingBot implements Command {

    private final String BOT_USERNAME = "bot.username";
    private final String BOT_TOKEN = "bot.token";
    public static String COMMAND_PREFIX = "/";
    private final CommandContainer commandContainer;

    public TaskManagerTelegramBot(TelegramUserService telegramUserService, TaskService taskService) {
        this.commandContainer = new CommandContainer(new SendMessageBotServiceImpl(this), telegramUserService, taskService);
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
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

package github.f1angz.tmtb.command;

import github.f1angz.tmtb.service.SendMessageBotService;
import github.f1angz.tmtb.service.TaskService;
import github.f1angz.tmtb.service.TelegramUserService;

import java.util.HashMap;
import java.util.Map;

import static github.f1angz.tmtb.command.CommandName.*;

public class CommandContainer {

    private final Map<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendMessageBotService sendMessageBotService, TelegramUserService telegramUserService, TaskService taskService) {

        commandMap = new HashMap<>();
        commandMap.put(START.getCommandName(), new StartCommand(sendMessageBotService, telegramUserService));
        commandMap.put(STOP.getCommandName(), new StopCommand(sendMessageBotService, telegramUserService));
        commandMap.put(HELP.getCommandName(), new HelpCommand(sendMessageBotService));
        commandMap.put(NO.getCommandName(), new HelpCommand(sendMessageBotService));
        commandMap.put(ADD.getCommandName(), new AddCommand(sendMessageBotService, taskService));
        commandMap.put(SHOW.getCommandName(), new ShowCommand(sendMessageBotService, taskService));

        unknownCommand = new UnknownCommand(sendMessageBotService);
    }

    public Command retrieveCommand(String commandName) {
        return commandMap.getOrDefault(commandName, unknownCommand);
    }
}

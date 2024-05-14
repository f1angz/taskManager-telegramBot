package github.f1angz.tmtb.command;

import github.f1angz.tmtb.service.SendMessageBotService;

import java.util.HashMap;
import java.util.Map;

import static github.f1angz.tmtb.command.CommandName.*;

public class CommandContainer {

    private final Map<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendMessageBotService sendMessageBotService) {

        commandMap = new HashMap<>();
        commandMap.put(START.getCommandName(), new StartCommand(sendMessageBotService));
        commandMap.put(STOP.getCommandName(), new StopCommand(sendMessageBotService));
        commandMap.put(HELP.getCommandName(), new HelpCommand(sendMessageBotService));
        commandMap.put(NO.getCommandName(), new HelpCommand(sendMessageBotService));

        unknownCommand = new UnknownCommand(sendMessageBotService);
    }

    public Command retrieveCommand(String commandName) {
        return commandMap.getOrDefault(commandName, unknownCommand);
    }
}

package command;


import github.f1angz.tmtb.command.Command;
import github.f1angz.tmtb.command.UnknownCommand;

import static github.f1angz.tmtb.command.UnknownCommand.UNKNOWN_MESSAGE;

public class UnknownCommandTest extends AbstarctCommandTest {
    @Override
    String getCommandName() {
        return "/fafafa";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendMessageBotService);
    }
}

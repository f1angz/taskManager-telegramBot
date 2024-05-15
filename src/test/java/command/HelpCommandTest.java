package command;

import github.f1angz.tmtb.command.Command;
import github.f1angz.tmtb.command.HelpCommand;
import org.junit.jupiter.api.DisplayName;

import static github.f1angz.tmtb.command.CommandName.HELP;
import static github.f1angz.tmtb.command.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-test testing for HelpCommand")
public class HelpCommandTest extends AbstarctCommandTest {

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendMessageBotService);
    }
}

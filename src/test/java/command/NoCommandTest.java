package command;

import github.f1angz.tmtb.command.Command;
import github.f1angz.tmtb.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static github.f1angz.tmtb.command.CommandName.NO;
import static github.f1angz.tmtb.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-test testing for NoCommand")
public class NoCommandTest extends AbstarctCommandTest {

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendMessageBotService);
    }
}

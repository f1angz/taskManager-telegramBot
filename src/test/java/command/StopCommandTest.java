package command;

import github.f1angz.tmtb.command.Command;
import github.f1angz.tmtb.command.StopCommand;
import org.junit.jupiter.api.DisplayName;

import static github.f1angz.tmtb.command.CommandName.STOP;
import static github.f1angz.tmtb.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-test testing for StopCommand")
public class StopCommandTest extends AbstarctCommandTest {

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendMessageBotService);
    }
}

package command;

import github.f1angz.tmtb.command.Command;
import github.f1angz.tmtb.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

import static github.f1angz.tmtb.command.CommandName.START;
import static github.f1angz.tmtb.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-test testing for StartCommand")
public class StartCommandTest extends AbstarctCommandTest {


    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendMessageBotService);
    }
}

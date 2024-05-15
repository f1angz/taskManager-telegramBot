package command;

import github.f1angz.tmtb.command.Command;
import github.f1angz.tmtb.command.CommandContainer;
import github.f1angz.tmtb.command.CommandName;
import github.f1angz.tmtb.command.UnknownCommand;
import github.f1angz.tmtb.service.SendMessageBotService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.SendMessageBotServiceTest;

import java.util.Arrays;

@DisplayName("Unit-test testing for CommandContainer")
public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendMessageBotService sendMessageBotService = Mockito.mock(SendMessageBotService.class);
        commandContainer = new CommandContainer(sendMessageBotService);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        String unknownCommand = "/fafafa";

        Command command = commandContainer.retrieveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}

package github.f1angz.tmtb.command;

import github.f1angz.tmtb.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static github.f1angz.tmtb.command.CommandName.*;

public class HelpCommand implements Command {

    private final SendMessageBotService sendMessageBotService;

    public static final String HELP_MESSAGE = String.format("<b>Доступные команды:<b>\n\n"
                                                            + "%s - запустить бота\n"
                                                            + "%s - приостановить работу бота\n"
                                                            + "%s - получить помощь по работе с ботом\n",
                                                            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }


    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}

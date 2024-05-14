package github.f1angz.tmtb.command;

import github.f1angz.tmtb.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    private final SendMessageBotService sendMessageBotService;

    private static final String STOP_MESSAGE = "До свидания!";

    public StopCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}

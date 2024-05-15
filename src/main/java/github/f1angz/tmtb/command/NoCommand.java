package github.f1angz.tmtb.command;

import github.f1angz.tmtb.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command {

    private final SendMessageBotService sendMessageBotService;

    public static final String NO_MESSAGE = "Я поддерживаю команды, которые начинаются со слеша.\nДля просмотра списка всех команд введите /help";

    public NoCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}

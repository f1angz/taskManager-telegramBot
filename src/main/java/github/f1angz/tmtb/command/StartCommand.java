package github.f1angz.tmtb.command;

import github.f1angz.tmtb.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private final SendMessageBotService sendMessageBotService;

    public final static String START_MESSAGE = "Привет! Я бот \" Менеджер задач\". Я помогу тебе планировать твоё время!";

    public StartCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}

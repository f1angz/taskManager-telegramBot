package github.f1angz.tmtb.command;

import github.f1angz.tmtb.service.SendMessageBotService;
import github.f1angz.tmtb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    private final SendMessageBotService sendMessageBotService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "До свидания!";

    public StopCommand(SendMessageBotService sendMessageBotService, TelegramUserService telegramUserService) {
        this.sendMessageBotService = sendMessageBotService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
        telegramUserService.findByChatId(update.getMessage().getChatId().toString())
                .ifPresent(it -> {
                    it.setActive(false);
                    System.out.println("Передаётся юзер с active: " + it.getActive());
                    telegramUserService.save(it);
                });
    }
}

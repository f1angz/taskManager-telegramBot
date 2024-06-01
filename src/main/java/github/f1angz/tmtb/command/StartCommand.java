package github.f1angz.tmtb.command;

import github.f1angz.tmtb.entity.TelegramUser;
import github.f1angz.tmtb.service.SendMessageBotService;
import github.f1angz.tmtb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    //Поля, отвечающие за отправку сообщений и взаимодействие с БД
    private final SendMessageBotService sendMessageBotService;
    private final TelegramUserService telegramUserService;
    //Сообщения для пользователя
    public final static String START_MESSAGE = "Привет! Я бот \" Менеджер задач\". Я помогу тебе планировать твоё время!";

    public StartCommand(SendMessageBotService sendMessageBotService, TelegramUserService telegramUserService) {
        this.sendMessageBotService = sendMessageBotService;
        this.telegramUserService = telegramUserService;
    }
    //Метод, который запускается при вызове команды
    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                });

        sendMessageBotService.sendMessage(chatId, START_MESSAGE);
    }
}

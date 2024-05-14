package github.f1angz.tmtb.service;

import github.f1angz.tmtb.bot.TaskManagerTelegramBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendMessageBotServiceImpl implements SendMessageBotService {

    private final TaskManagerTelegramBot taskManagerTelegramBot;

    public SendMessageBotServiceImpl(TaskManagerTelegramBot taskManagerTelegramBot) {
        this.taskManagerTelegramBot = taskManagerTelegramBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            taskManagerTelegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

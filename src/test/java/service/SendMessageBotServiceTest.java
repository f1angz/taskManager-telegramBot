package service;

import github.f1angz.tmtb.bot.TaskManagerTelegramBot;
import github.f1angz.tmtb.service.SendMessageBotService;
import github.f1angz.tmtb.service.SendMessageBotServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-test testing for SendMessageBotService")
public class SendMessageBotServiceTest {

    private SendMessageBotService sendMessageBotService;
    private TaskManagerTelegramBot taskManagerTelegramBot;

    @BeforeEach
    public void init() {
        taskManagerTelegramBot = Mockito.mock(TaskManagerTelegramBot.class);
        sendMessageBotService = new SendMessageBotServiceImpl(taskManagerTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {

        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendMessageBotService.sendMessage(chatId, message);

        Mockito.verify(taskManagerTelegramBot).execute(sendMessage);
    }

}

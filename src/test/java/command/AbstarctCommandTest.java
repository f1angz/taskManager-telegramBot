package command;

import github.f1angz.tmtb.bot.TaskManagerTelegramBot;
import github.f1angz.tmtb.command.Command;
import github.f1angz.tmtb.service.SendMessageBotService;
import github.f1angz.tmtb.service.SendMessageBotServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AbstarctCommandTest {

    protected TaskManagerTelegramBot taskManagerTelegramBot = Mockito.mock(TaskManagerTelegramBot.class);
    protected SendMessageBotService sendMessageBotService = new SendMessageBotServiceImpl(taskManagerTelegramBot);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chatId = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandMessage());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(taskManagerTelegramBot).execute(sendMessage);
    }
}

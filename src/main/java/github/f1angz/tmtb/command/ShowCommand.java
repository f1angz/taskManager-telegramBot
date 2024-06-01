package github.f1angz.tmtb.command;

import github.f1angz.tmtb.entity.Task;
import github.f1angz.tmtb.service.SendMessageBotService;
import github.f1angz.tmtb.service.TaskService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class ShowCommand implements Command {

    private final SendMessageBotService sendMessageBotService;
    private final TaskService taskService;

    public ShowCommand(SendMessageBotService sendMessageBotService, TaskService taskService) {
        this.sendMessageBotService = sendMessageBotService;
        this.taskService = taskService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        List<Task> allTasks = taskService.showTasks(chatId);

        String message = "Cписок всех задач:\n\n";
        for (Task task : allTasks) {
            message += task.getText() + "\n";
        }

        sendMessageBotService.sendMessage(chatId, message);
    }
}

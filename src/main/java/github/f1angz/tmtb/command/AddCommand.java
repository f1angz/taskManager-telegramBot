package github.f1angz.tmtb.command;

import github.f1angz.tmtb.entity.Task;
import github.f1angz.tmtb.service.SendMessageBotService;
import github.f1angz.tmtb.service.TaskService;
import org.telegram.telegrambots.meta.api.objects.Update;


public class AddCommand implements Command {

    private final SendMessageBotService sendMessageBotService;
    private final TaskService taskService;

    public final static String ADD_MESSAGE = "Задача успешно добавлена!";

    public AddCommand(SendMessageBotService sendMessageBotService, TaskService taskService) {
        this.sendMessageBotService = sendMessageBotService;
        this.taskService = taskService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        String taskText = update.getMessage().getText().replaceAll("/add", "").trim();
        System.out.println(taskText);

        Task task = new Task();
        task.setChatId(chatId);
        task.setText(taskText);
        taskService.addTask(task);

        sendMessageBotService.sendMessage(chatId, ADD_MESSAGE);

    }
}

package github.f1angz.tmtb.repository;

import github.f1angz.tmtb.entity.Task;
import github.f1angz.tmtb.entity.TelegramUser;

import java.util.List;

public interface TaskRepository {

    void addTask(Task task);
    List<Task> showTasks(String chatId);
}

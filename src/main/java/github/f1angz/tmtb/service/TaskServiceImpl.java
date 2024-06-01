package github.f1angz.tmtb.service;

import github.f1angz.tmtb.entity.Task;
import github.f1angz.tmtb.entity.TelegramUser;
import github.f1angz.tmtb.repository.TaskRepository;

import java.util.List;

public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    @Override
        public List<Task> showTasks(String chatId) {
        return taskRepository.showTasks(chatId);
    }
}

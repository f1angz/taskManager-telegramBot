package github.f1angz.tmtb.repository;

import github.f1angz.tmtb.entity.Task;
import github.f1angz.tmtb.entity.TelegramUser;
import github.f1angz.tmtb.util.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {


    @Override
    public void addTask(Task task) {
        String sql = """
                INSERT INTO users_tasks(chat_id, task) 
                VALUES (?, ?)
                """;

        try (var connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, task.getChatId());
            statement.setString(2, task.getText());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Task> showTasks(String chatId) {
        List<Task> tasks = new ArrayList<>();
        String sql = """
                SELECT * FROM users_tasks
                WHERE chat_id = ?
                """;

        try (var connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, chatId);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setChatId(resultSet.getString("chat_id"));
                task.setText(resultSet.getString("task"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return tasks;
    }
}

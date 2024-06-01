package github.f1angz.tmtb.repository;

import github.f1angz.tmtb.entity.TelegramUser;
import github.f1angz.tmtb.util.ConnectionUtil;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelegramUserRepositoryImpl implements TelegramUserRepository {


    @Override
    public List<TelegramUser> findAllByActiveTrue() {
        String sql = """
                SELECT * 
                FROM users
                WHERE active = ?
                """;

        List<TelegramUser> telegramActiveUsersList = new ArrayList();
        try(var connection = ConnectionUtil.getConnection();
            var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, true);

            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TelegramUser telegramUser = new TelegramUser();
                telegramUser.setChatId(resultSet.getString("chat_id"));
                telegramUser.setActive(resultSet.getBoolean("active"));
                telegramActiveUsersList.add(telegramUser);
            }
            return telegramActiveUsersList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(TelegramUser telegramUser) {
        String sql = """
                INSERT INTO users (chat_id, active) 
                VALUES (?, ?)
                ON CONFLICT(chat_id) DO UPDATE SET active = ?
                """;

        try (var connection = ConnectionUtil.getConnection();
            var preparedStatment = connection.prepareStatement(sql)) {

            preparedStatment.setString(1, telegramUser.getChatId());
            preparedStatment.setBoolean(2, telegramUser.getActive());
            preparedStatment.setBoolean(3, telegramUser.getActive());
            preparedStatment.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

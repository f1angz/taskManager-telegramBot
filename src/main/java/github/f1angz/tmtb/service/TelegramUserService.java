package github.f1angz.tmtb.service;

import github.f1angz.tmtb.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserService {

    List<TelegramUser> retrieveAllActiveUser();
    void save(TelegramUser user);
    Optional<TelegramUser> findByChatId(String chatId);

}

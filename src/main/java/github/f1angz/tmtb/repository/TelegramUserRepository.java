package github.f1angz.tmtb.repository;

import github.f1angz.tmtb.entity.TelegramUser;

import java.util.List;

public interface TelegramUserRepository {

    List<TelegramUser> findAllByActiveTrue();
    void saveUser(TelegramUser user);
}

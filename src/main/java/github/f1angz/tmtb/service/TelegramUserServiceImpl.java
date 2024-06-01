package github.f1angz.tmtb.service;

import github.f1angz.tmtb.entity.TelegramUser;
import github.f1angz.tmtb.repository.TelegramUserRepository;

import java.util.List;
import java.util.Optional;

public class TelegramUserServiceImpl implements TelegramUserService {

    private final TelegramUserRepository telegramUserRepository;

    public TelegramUserServiceImpl(TelegramUserRepository telegramUserRepository) {
        this.telegramUserRepository = telegramUserRepository;
    }

    @Override
    public List<TelegramUser> retrieveAllActiveUser() {
        return telegramUserRepository.findAllByActiveTrue();
    }

    @Override
    public void save(TelegramUser user) {
        telegramUserRepository.saveUser(user);
    }

    @Override
    public Optional<TelegramUser> findByChatId(String chatId) {
        return telegramUserRepository.findAllByActiveTrue()
                .stream()
                .filter(element -> element.getChatId().contains(chatId))
                .findFirst();
    }
}

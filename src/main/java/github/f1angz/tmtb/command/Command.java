package github.f1angz.tmtb.command;


import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {

    void execute(Update update);
}

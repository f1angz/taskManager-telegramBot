package github.f1angz.tmtb.entity;

import java.time.LocalDateTime;

public class Task {

    private String chatId;
    private String text;

    public String getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public void setText(String text) {
        this.text = text;
    }
}

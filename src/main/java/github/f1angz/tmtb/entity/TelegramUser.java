package github.f1angz.tmtb.entity;

public class TelegramUser {

    private String chatId;
    private boolean active;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

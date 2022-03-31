package model;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class NewUser {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private List<Integer> friendUserIds;
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public NewUser setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public int getId() {
        return id;
    }

    public NewUser setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public NewUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public Optional<String> getEmailAddressOptional() {
        return Optional.ofNullable(emailAddress);
    }

    public NewUser setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public NewUser setVerified(boolean isVerified) {
        this.isVerified = isVerified;
        return this;
    }

    public List<Integer> getFriendUserIds() {
        return friendUserIds;
    }

    public NewUser setFriendUserIds(List<Integer> friendUserIds) {
        this.friendUserIds = friendUserIds;
        return this;
    }

    @Override
    public String toString() {
        return "NewUser [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
                + (emailAddress != null ? "emailAddress=" + emailAddress + ", " : "") + "isVerified=" + isVerified
                + ", " + (friendUserIds != null ? "friendUserIds=" + friendUserIds : "") + "]";
    }
}

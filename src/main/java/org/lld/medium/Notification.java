package org.lld.medium;

public class Notification {
    private String id;
    private String userId;
    private NotificationType notificationType;
    private String content;
    private Long timestamp;

    public Notification(String id, String userId, NotificationType type, String content, String timestamp) {
        this.id = id;
        this.userId = userId;
        this.notificationType = type;
        this.content = content;
        this.timestamp = Long.valueOf(timestamp);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId() {
        this.userId = userId;
    }

    public NotificationType getType() {
        return notificationType;
    }

    public void setType(NotificationType type) {
        this.notificationType = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", notificationType=" + notificationType +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

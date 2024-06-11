package org.lld.medium;

import java.util.List;

public class Post {
    private String id;
    private String userId;
    private String content;
    private List<String> imageUrls;
    private List<String> videoUrls;
    private long timestamp;
    private List<User> likes;
    private List<Comment> comments;

    public Post(String id, String userId, String content, long timestamp) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;

    }

    public Post() {

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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public List<String> getVideoUrls() {
        return videoUrls;
    }

    public void setVideoUrls(List<String> videoUrls) {
        this.videoUrls = videoUrls;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public List<org.lld.medium.Comment> getComment() {
        return comments;
    }

    public void setComment(List<org.lld.medium.Comment> comment) {
        comments = comment;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", imageUrls=" + imageUrls +
                ", videoUrls=" + videoUrls +
                ", timestamp=" + timestamp +
                ", likes=" + likes +
                ", Comment=" + comments +
                '}';
    }

    public void addLikes(User user) {
        likes.add(user);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}

package models;

import java.util.Objects;
import models.User;

public class Comment {
    private int id;
    private int userId;
    private String content;
    private int hikeId;


    public Comment(int userId, String content, int hikeId) {
        this.userId = userId;
        this.content = content;
        this.hikeId = hikeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHikeId() {
        return hikeId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                userId == comment.userId &&
                hikeId == comment.hikeId &&
                Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, content, hikeId);
    }
}

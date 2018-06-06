package dao;


import models.Comment;

import java.util.List;

public interface CommentDao {
    // LIST
    List<Comment> getAll();

    // CREATE
    void add(Comment comment);

    // READ
    Comment findById(int id);

    // UPDATE
    void update(int id, String content);

    // DELETE
    void deleteById(int id);
    void clearAllComments();

}

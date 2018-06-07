package dao;

import models.Comment;
import models.Hike;
import models.User;

import java.util.List;

public interface UserDao {
    // LIST
    List<User> getAll();

    // CREATE
    void add(User user);

    // READ
    User findById(int id);

    // UPDATE
    void update(int id, String name);

    // DELETE
    void deleteById(int id);


    List<Comment> getAllCommentsByUserByHike(int userId);
    
}

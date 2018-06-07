package dao;

import models.Comment;
import models.Hike;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface HikeDao {
    // LIST
    List<Hike> getAll();

    // CREATE
    void add(Hike hike);

    // READ
    Hike findById(int id);

    // UPDATE
    void update(int id, String name, int length, int elevationGain, String state, String imageUrl);

    // DELETE
    void deleteById(int id);


    List<Comment> getAllCommentsByHike(int hikeId);
    Map<Comment, String> getAllCommentsWithAuthorsByHike(int hikeId);
}

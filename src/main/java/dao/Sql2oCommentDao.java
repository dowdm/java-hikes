package dao;

import models.User;
import org.sql2o.*;
import models.Comment;
import java.util.List;

public class Sql2oCommentDao implements CommentDao{
    private final Sql2o sql2o;

    public Sql2oCommentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Comment comment) {
        String sql = "INSERT INTO comments (content, userId, hikeId) VALUES (:content, :userId, :hikeId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true).bind(comment).executeUpdate().getKey();
            comment.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Comment> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM comments")
                    .executeAndFetch(Comment.class);
        }
    }

    @Override
    public void update(int id, String newContent){
        String sql = "UPDATE comments SET content = :content WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("content", newContent)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Comment findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM comments WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Comment.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from comments WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllComments() {
        String sql = "DELETE from comments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public User getUser(int userId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users WHERE id = :userId")
                    .addParameter("id", userId)
                    .executeAndFetchFirst(User.class);
        }
    }

}

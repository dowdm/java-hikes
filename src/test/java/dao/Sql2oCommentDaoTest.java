package dao;

import models.Comment;

import org.sql2o.*;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oCommentDaoTest {

    private Sql2oCommentDao commentDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        commentDao = new Sql2oCommentDao(sql2o);

        conn = sql2o.open();
    }


    public Comment setupNewComment(){
        return new Comment(1, "Cool hike", 1);
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

//    @Test
//    public void add() {
//        Comment comment =setupNewComment();
//        int originalCommentId = comment.getId();
//        commentDao.add(comment);
//        assertNotEquals(originalCommentId, comment.getId());
//    }
//
//    @Test
//    public void getAll() {
//        Comment comment =setupNewComment();
//        commentDao.add(comment);
//        assertEquals(1, commentDao.getAll().size());
//    }
//
//    @Test
//    public void findById() {
//        Comment comment = setupNewComment();
//        commentDao.add(comment);
//        Comment foundComment = commentDao.findById(comment.getId());
//        assertEquals(comment, foundComment);
//    }
//
//    @Test
//    public void update() {
//        Comment comment =setupNewComment();
//        commentDao.add(comment);
//        int id = comment.getId();
//        commentDao.update(id, "Crappy hike");
//        Comment updatedComment = commentDao.findById(id);
//        assertEquals("Crappy hike", updatedComment.getContent());
//    }
//
//    @Test
//    public void deleteById() {
//        Comment comment1 =setupNewComment();
//        Comment comment2 =setupNewComment();
//        commentDao.add(comment1);
//        commentDao.add(comment2);
//        commentDao.deleteById(1);
//        List<Comment> allComments = commentDao.getAll();
//        assertEquals(1, allComments.size());
//        assertTrue(allComments.contains(comment2));
//        assertFalse(allComments.contains(comment1));
//    }
//
//    @Test
//    public void clearAllComments() {
//        Comment comment1 =setupNewComment();
//        Comment comment2 =setupNewComment();
//        commentDao.add(comment1);
//        commentDao.add(comment2);
//        commentDao.clearAllComments();
//        assertEquals(0, commentDao.getAll().size());
//    }
}
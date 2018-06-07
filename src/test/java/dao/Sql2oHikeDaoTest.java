package dao;

import models.Comment;
import models.Hike;

import models.User;
import org.junit.*;
import org.sql2o.*;


import java.util.List;

import static org.junit.Assert.*;

public class Sql2oHikeDaoTest {

    private Sql2oHikeDao hikeDao;
    private Sql2oCommentDao commentDao;
    private Sql2oUserDao userDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        hikeDao = new Sql2oHikeDao(sql2o);
        commentDao = new Sql2oCommentDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }
    public Hike setupNewHike(){
        return new Hike("Devil's Hike", 2000, 222,"Oregon", "www.google.com");
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }


//    @Test
//    public void add() {
//        Hike hike = setupNewHike();
//        int originalHikeId = hike.getId();
//        hikeDao.add(hike);
//        assertNotEquals(originalHikeId, hike.getId());
//    }
//
//    @Test
//    public void getAll() {
//        Hike hike = setupNewHike();
//        hikeDao.add(hike);
//        assertEquals(1, hikeDao.getAll().size());
//    }
//
//    @Test
//    public void update() {
//        Hike hike = setupNewHike();
//        hikeDao.add(hike);
//        int id = hike.getId();
//        hikeDao.update(id, "Forest Park", 2000, 200, "Oregon", "images.google.com");
//        Hike updatedHike = hikeDao.findById(id);
//        assertEquals("Forest Park", updatedHike.getName());
//    }
//
//    @Test
//    public void findById() {
//        Hike hike = setupNewHike();
//        hikeDao.add(hike);
//        Hike foundHike = hikeDao.findById(hike.getId());
//        assertEquals(foundHike, hike);
//    }
//
//    @Test
//    public void deleteById() {
//        Hike hike1 = setupNewHike();
//        Hike hike2 = setupNewHike();
//        hikeDao.add(hike1);
//        hikeDao.add(hike2);
//        hikeDao.deleteById(2);
//        List<Hike> allHikes = hikeDao.getAll();
//        assertEquals(1, allHikes.size());
//        assertTrue(allHikes.contains(hike1));
//        assertFalse(allHikes.contains(hike2));
//    }
//
//    @Test
//    public void getAllCommentsByHike() {
//        Hike hike = setupNewHike();
//        hikeDao.add(hike);
//        int hikeId = hike.getId();
//        Comment comment1 = new Comment(2, "cooler hike");
//        comment1.setHikeId(hikeId);
//        Comment comment2 = new Comment(1, "cool hike");
//        comment2.setHikeId(hikeId);
//        commentDao.add(comment1);
//        commentDao.add(comment2);
//        assertEquals(2, hikeDao.getAllCommentsByHike(hikeId).size());
//
//    }

    @Test
    public void getAllCommentsWithAuthorsByHike() {
        User testUser = new User("Mike");
        userDao.add(testUser);
        Hike hike = setupNewHike();
        hikeDao.add(hike);
        int hikeId = hike.getId();
        Comment comment1 = new Comment(testUser.getId(), "cooler hike", hikeId);
        Comment comment2 = new Comment(testUser.getId(), "cool hike", hikeId);
        commentDao.add(comment1);
        commentDao.add(comment2);
        assertEquals(2, hikeDao.getAllCommentsWithAuthorsByHike(hikeId).size());
    }

}
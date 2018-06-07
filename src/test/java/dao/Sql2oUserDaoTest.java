package dao;

import org.junit.*;
import models.User;
import org.sql2o.*;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oUserDaoTest {
    private Sql2oUserDao userDao;
    private Sql2oHikeDao hikeDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        userDao = new Sql2oUserDao(sql2o);
        hikeDao = new Sql2oHikeDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }


//    @Test
//    public void add() {
//        User user = new User("Matt");
//        int originalUserId = user.getId();
//        userDao.add(user);
//        assertNotEquals(originalUserId, user.getId());
//    }
//
//    @Test
//    public void getAll() {
//        User user1 = new User("Matt");
//        User user2 = new User("Garnett");
//        userDao.add(user1);
//        userDao.add(user2);
//        assertEquals(2, userDao.getAll().size());
//    }
//
//    @Test
//    public void findById() {
//        User user = new User("matt");
//        userDao.add(user);
//        User foundUser = userDao.findById(user.getId());
//        assertEquals(user, foundUser);
//    }
//
//    @Test
//    public void update() {
//        User user = new User("matt");
//        userDao.add(user);
//        int id = user.getId();
//        userDao.update(id, "Garnett");
//        User updatedUser = userDao.findById(id);
//        assertEquals("Garnett", updatedUser.getName());
//    }
//
//    @Test
//    public void deleteById() {
//        User user = new User("matt");
//        User user2 = new User("bob");
//        User user3 = new User("ashley");
//        userDao.add(user);
//        userDao.add(user2);
//        userDao.add(user3);
//        userDao.deleteById(2);
//        List<User> allUsers = userDao.getAll();
//        assertEquals(2, userDao.getAll().size());
//        assertTrue( allUsers.contains(user));
//        assertTrue( allUsers.contains(user3));
//    }
}
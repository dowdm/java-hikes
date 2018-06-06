package models;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import models.Hike;

public class UserTest {

    @Test
    public void getId() {
        User user = new User("matt");
        user.setId(1);
        assertEquals(1, user.getId());
    }

    @Test
    public void getName() {
        User user = new User("matt");
        user.setName("Brett");
        assertEquals("Brett", user.getName());
    }

    @Test
    public void getCompletedHikes() {
        User user = new User("matt");
        ArrayList<Hike> completeHikes = new ArrayList<>();
        Hike hike1 = new Hike("Devil's Hike", 2000, 222,"Oregon", "www.google.com");
        Hike hike2 = new Hike("Devil's Hike", 2000, 222,"Oregon", "www.google.com");
        completeHikes.add(hike1);
        completeHikes.add(hike2);
        user.setCompletedHikes(completeHikes);
        assertEquals(2, user.getCompletedHikes().size());
    }
}
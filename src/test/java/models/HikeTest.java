package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HikeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void hikeInstatiatesCorrectly() throws Exception{
        Hike testHike = new Hike("Devil's Hike", 2000, 222,"Oregon", "www.google.com");
        assertEquals(true, testHike instanceof Hike);
    }

    @Test
    public void getName() {
        Hike testHike = new Hike("Devil's Hike", 2000, 222,"Oregon", "www.google.com");
        testHike.setName("Devil's Trail");
        assertEquals("Devil's Trail", testHike.getName());
    }

    @Test
    public void getLength() {
        Hike testHike = new Hike("Devil's Hike", 2000, 222,"Oregon", "www.google.com");
        testHike.setLength(3126);
        assertEquals(3126, testHike.getLength());
    }

    @Test
    public void getElevationGain() {
        Hike testHike = new Hike("Devil's Hike", 2000, 222,"Oregon", "www.google.com");
        testHike.setElevationGain(999);
        assertEquals(999, testHike.getElevationGain());
    }

    @Test
    public void getState() {
        Hike testHike = new Hike("Devil's Hike", 2000, 222,"Oregon", "www.google.com");
        testHike.setState("Oregon");
        assertEquals("Oregon", testHike.getState());
    }

    @Test
    public void getImageUrl() {
        Hike testHike = new Hike("Devil's Hike", 2000, 222,"Oregon", "www.google.com");
        testHike.setImageUrl("www.google.com");
        assertEquals("www.google.com", testHike.getImageUrl());
    }

    @Test
    public void getId() {
        Hike testHike = new Hike("Devil's Hike", 2000, 222,"Oregon", "www.google.com");
        testHike.setId(1);
        assertEquals(1, testHike.getId());
    }

}
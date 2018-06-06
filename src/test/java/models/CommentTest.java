package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommentTest {

    @Test
    public void getId() {
        Comment comment = new Comment(1, "Nice hike");
        comment.setId(1);
        assertEquals(1, comment.getId());
    }

    @Test
    public void getUserId() {
        Comment comment = new Comment(1, "Nice hike");
        assertEquals(1, comment.getUserId());
    }

    @Test
    public void getContent() {
        Comment comment = new Comment(1, "Nice hike");
        assertEquals("Nice hike", comment.getContent());
    }
}
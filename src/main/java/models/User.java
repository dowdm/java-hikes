package models;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private ArrayList<Hike> completedHikes = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Hike> getCompletedHikes() {
        return completedHikes;
    }

    public void setCompletedHikes(ArrayList<Hike> completedHikes) {
        this.completedHikes = completedHikes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(completedHikes, user.completedHikes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, completedHikes);
    }
}

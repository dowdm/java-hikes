package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hike {
    private String name;
    private int length;
    private int elevationGain;
    private String state;
    private String imageUrl;
    private int id;


    public Hike(String name, int length, int elevationGain, String state, String imageUrl) {
        this.name = name;
        this.length = length;
        this.elevationGain = elevationGain;
        this.state = state;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getElevationGain() {
        return elevationGain;
    }

    public void setElevationGain(int elevationGain) {
        this.elevationGain = elevationGain;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hike hike = (Hike) o;
        return length == hike.length &&
                elevationGain == hike.elevationGain &&
                id == hike.id &&
                Objects.equals(name, hike.name) &&
                Objects.equals(state, hike.state) &&
                Objects.equals(imageUrl, hike.imageUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, length, elevationGain, state, imageUrl, id);
    }
}

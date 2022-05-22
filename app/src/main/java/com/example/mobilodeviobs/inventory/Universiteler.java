package com.example.mobilodeviobs.inventory;
import java.io.Serializable;

public class Universiteler implements Serializable {

    private String name;
    private int image;

    public Universiteler() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
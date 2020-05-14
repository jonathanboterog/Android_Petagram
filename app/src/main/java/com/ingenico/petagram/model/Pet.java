package com.ingenico.petagram.model;

import java.io.Serializable;

public class Pet implements Serializable {

    private int id;
    private String name;
    private int rating;
    private int photo;

    public Pet(String name, int rating, int photo) {
        this.name = name;
        this.rating = rating;
        this.photo = photo;
    }

    public Pet(int rating, int photo) {
        this.rating = rating;
        this.photo = photo;
    }

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
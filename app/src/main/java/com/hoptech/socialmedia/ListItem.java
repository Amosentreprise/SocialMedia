package com.hoptech.socialmedia;

public class ListItem {

    private String name, firstname, description;
    private int image_post, profile_image;

    public ListItem(String name, String firstname, String description, int image_post, int profile_image) {
        this.name = name;
        this.firstname = firstname;
        this.description = description;
        this.image_post = image_post;
        this.profile_image = profile_image;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getDescription() {
        return description;
    }

    public int getImage_post() {
        return image_post;
    }

    public int getProfile_image() {
        return profile_image;
    }
}

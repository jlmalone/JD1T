package com.jd1t.model;

import java.util.Random;

/**
 * Created by Joseph on 17.05.15.
 */
public class User
{
    int id;
    String username;
    String thumbnailUrl;
    String fullProfileUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getFullProfileUrl() {
        return fullProfileUrl;
    }

    public void setFullProfileUrl(String fullProfileUrl) {
        this.fullProfileUrl = fullProfileUrl;
    }

    public static User getRandomDebug()
    {

        return getRandomDebug(System.currentTimeMillis());

    }

    public static User getRandomDebug(long seed)
    {
        Random r = new Random(seed);
        User user = new User();
        user.id = r.nextInt();
        user.username = "User"+r.nextInt();
        user.thumbnailUrl = "http://lorempixel.com/50/50/";
        user.fullProfileUrl = "http://lorempixel.com/500/500/";
        return user;
    }

}

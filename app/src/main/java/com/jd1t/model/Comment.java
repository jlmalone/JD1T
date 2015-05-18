package com.jd1t.model;

import com.jd1t.util.RandomString;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Joseph on 17.05.15.
 */
public class Comment
{
    int id;
    User author;
    String text;
    long timeCreated;
    ArrayList<User> likes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public ArrayList<User> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<User> likes) {
        this.likes = likes;
    }




    public static Comment getRandomDebug()
    {
        Random r = new Random(System.currentTimeMillis());
        RandomString randomString = new RandomString(160);
        Comment comment = new Comment();
        comment.id = r.nextInt();
        comment.author = User.getRandomDebug();
        comment.text = randomString.nextString();
        comment.setTimeCreated(r.nextLong());
        comment.likes = new ArrayList<>();
        for(int i=0;i<r.nextInt(7);i++)
        {
            User j = User.getRandomDebug();
            comment.likes.add(j);
        }
        return comment;
    }
}

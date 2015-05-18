package com.jd1t.model;

import com.jd1t.util.RandomString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Joseph on 17.05.15.
 */
public class Post
{
    int id;
    String imageUrl;
    String text;
    long dateCreated;
    List<User> likes;
    List<Comment> comments;
    User author;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public static Post getRandomDebug()
    {
        Random random = new Random(System.currentTimeMillis()+80);
        RandomString rs = new RandomString(160);
        Post p = new Post();
        p.id = random.nextInt();
        p.comments = new ArrayList<>();
        p.likes = new ArrayList<>();
        p.text = rs.nextString();
        p.imageUrl = "http://lorempixel.com/500/500/";
        p.dateCreated = random.nextLong();
        p.author = User.getRandomDebug(System.currentTimeMillis()+30);
        for(int c = 0;c<random.nextInt(8);c++)
        {
            Comment comment = Comment.getRandomDebug();
            p.comments.add(comment);

        }
        for(int c=0;c<random.nextInt(20);c++)
        {
            User user = User.getRandomDebug(System.currentTimeMillis()+c+459);
            p.likes.add(user);
        }
        return p;
    }
}

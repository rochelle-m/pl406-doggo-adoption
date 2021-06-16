package com.doggos.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "posts")
public class Post {
    @Id
    private String id;

    @DBRef
    private User user;

    private String caption;

    private List<String> tags;

    private List<Comment> comments;

    @DBRef
    private List<User> favourites;

    @Nullable
    private String imagePath;

    private Date createdDate;

    public Post () {}

    public Post(User user, String caption, List<String> tags, @Nullable String imagePath, Date createdDate) {
        this.user = user;
        this.caption = caption;
        this.tags = tags;
        this.imagePath = imagePath;
        this.createdDate = createdDate;
        this.comments = new ArrayList<>();
        this.favourites = new ArrayList<>();
    }

    public Post(User user, String caption, List<String> tags, List<Comment> comments, List<User> favourites, @Nullable String imagePath, Date createdDate) {
        this.user = user;
        this.caption = caption;
        this.tags = tags;
        this.comments = comments;
        this.favourites = favourites;
        this.imagePath = imagePath;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<User> favourites) {
        this.favourites = favourites;
    }

    @Nullable
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(@Nullable String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

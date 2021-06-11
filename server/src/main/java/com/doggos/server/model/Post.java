package com.doggos.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

@Document(collection = "posts")
public class Post {
    @Id
    private String id;

    @DBRef
    private User user;

    private String comment;

    private List<String> tags;

    @DBRef
    private List<Comment> comments;

    @DBRef
    private List<User> favourites;

    @Nullable
    private String imagePath;

    private Date createdDate;

    public Post(String id, User user, String comment, List<String> tags, List<Comment> comments, List<User> favourites, @Nullable String imagePath, Date createdDate) {
        this.id = id;
        this.user = user;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

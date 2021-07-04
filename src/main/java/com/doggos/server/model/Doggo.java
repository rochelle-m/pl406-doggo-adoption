package com.doggos.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

@Document(collection = "doggo")
public class Doggo {
    @Id
    private String id;
    private String name;
    private String breed;
    private String description;
    private String remarks;
    private String location;
    @Nullable
    private String primaryImg;

    private Boolean isAdopted;
    private Boolean isFostered;

    @DBRef
    private User user;
    public Doggo() {

    }

    public Doggo(String name, String breed, String description, String remarks, String location, @Nullable String primaryImg, User user) {
        this.name = name;
        this.breed = breed;
        this.description = description;
        this.remarks = remarks;
        this.location = location;
        this.primaryImg = primaryImg;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }


    @Nullable
    public String getPrimaryImg() {
        return primaryImg;
    }

    public void setPrimaryImg(@Nullable String primaryImg) {
        this.primaryImg = primaryImg;
    }


    public Boolean getAdopted() {
        return isAdopted;
    }

    public void setAdopted(Boolean adopted) {
        isAdopted = adopted;
    }

    public Boolean getFostered() {
        return isFostered;
    }

    public void setFostered(Boolean fostered) {
        isFostered = fostered;
    }
}

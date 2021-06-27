package com.doggos.server.model;

import org.springframework.data.annotation.Id;
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
    @Nullable
    private String secondaryImg;
    private Boolean isAdopted;
    private Boolean isFostered;
    public Doggo() {

    }

    public Doggo(String id, String name, String breed, String description, String remarks, String location, Boolean isAdopted, Boolean isFostered) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.description = description;
        this.remarks = remarks;
        this.location = location;
        this.isAdopted = isAdopted;
        this.isFostered = isFostered;
    }

    public Doggo(String id, String name, String breed, String description, String remarks, String location, @Nullable String primaryImg, @Nullable String secondaryImg, Boolean isAdopted, Boolean isFostered) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.description = description;
        this.remarks = remarks;
        this.location = location;
        this.primaryImg = primaryImg;
        this.secondaryImg = secondaryImg;
        this.isAdopted = isAdopted;
        this.isFostered = isFostered;
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

    @Nullable
    public String getSecondaryImg() {
        return secondaryImg;
    }

    public void setSecondaryImg(@Nullable String secondaryImg) {
        this.secondaryImg = secondaryImg;
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

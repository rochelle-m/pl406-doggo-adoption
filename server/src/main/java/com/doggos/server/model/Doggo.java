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
    private final String description;
    private String remarks;
    @Nullable
    private final String primaryImg;
    @Nullable
    private final String secondaryImg;
    private final Boolean isAdopted;
    private final Boolean isFostered;

    public Doggo(String id, String name, String breed,
                 String description, String remarks,
                 @Nullable String primaryImg, @Nullable String secondaryImg,
                 Boolean isAdopted, Boolean isFostered) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.description = description;
        this.remarks = remarks;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Nullable
    public String getPrimaryImg() {
        return primaryImg;
    }

    @Nullable
    public String getSecondaryImg() {
        return secondaryImg;
    }

    public Boolean getAdopted() {
        return isAdopted;
    }

    public Boolean getFostered() {
        return isFostered;
    }
}

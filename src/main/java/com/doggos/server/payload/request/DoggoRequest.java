package com.doggos.server.payload.request;

public class DoggoRequest {

    private String name;
    private String breed;
    private String description;
    private String remarks;
    private String location;
    private String primaryImg;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrimaryImg() {
        return primaryImg;
    }

    public void setPrimaryImg(String primaryImg) {
        this.primaryImg = primaryImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

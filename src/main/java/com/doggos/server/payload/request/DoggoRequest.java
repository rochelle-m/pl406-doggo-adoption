package com.doggos.server.payload.request;

public class DoggoRequest {

    private  String username;
    private String name;
    private String breed;
    private String description;
    private String remarks;
    private String location;


    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

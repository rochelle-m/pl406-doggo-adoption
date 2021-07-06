package com.doggos.server.model;

public class Applicant {

    private String dogId;
    private String name;
    private String phoneNumber;
    private String address;
    private String occupation;
    private String ownPet;
    private String allergy;
    private String noOfAdults;
    private String noOfChildren;
    private String typeOfHome;
    private String describeHome;
    private String reasonToAdopt;
    private String haveTime;
    private String agreement;

    public Applicant() {

    }


    public Applicant(String dogId, String name, String phoneNumber, String address, String occupation, String ownPet, String allergy, String noOfAdults, String noOfChildren, String typeOfHome, String describeHome, String reasonToAdopt, String haveTime, String agreement) {
        this.dogId = dogId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.occupation = occupation;
        this.ownPet = ownPet;
        this.allergy = allergy;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.typeOfHome = typeOfHome;
        this.describeHome = describeHome;
        this.reasonToAdopt = reasonToAdopt;
        this.haveTime = haveTime;
        this.agreement = agreement;

    }

    public String getDogId() {
        return dogId;
    }

    public void setDogId(String dogId) {
        this.dogId = dogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOwnPet() {
        return ownPet;
    }

    public void setOwnPet(String ownPet) {
        this.ownPet = ownPet;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(String noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public String getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(String noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public String getTypeOfHome() {
        return typeOfHome;
    }

    public void setTypeOfHome(String typeOfHome) {
        this.typeOfHome = typeOfHome;
    }

    public String getDescribeHome() {
        return describeHome;
    }

    public void setDescribeHome(String describeHome) {
        this.describeHome = describeHome;
    }

    public String getReasonToAdopt() {
        return reasonToAdopt;
    }

    public void setReasonToAdopt(String reasonToAdopt) {
        this.reasonToAdopt = reasonToAdopt;
    }

    public String getHaveTime() {
        return haveTime;
    }

    public void setHaveTime(String haveTime) {
        this.haveTime = haveTime;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }
}
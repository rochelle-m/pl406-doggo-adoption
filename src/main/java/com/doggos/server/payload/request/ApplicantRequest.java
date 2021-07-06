package com.doggos.server.payload.request;

public class ApplicantRequest {
    private String dogId;
    private String username;
    private String applicantName;
    private String phoneNumber;
    private String address;
    private String occupation;
    private String ownPet;
    private String allergy;
    private Integer noOfAdults;
    private Integer noOfChildren;
    private String typeOfHome;
    private String describeHome;
    private String[] reasonToAdopt;
    private String haveTime;
    private String agreement;

    public String getDogId() {
        return dogId;
    }

    public void setDogId(String dogId) {
        this.dogId = dogId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
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

    public Integer getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(Integer noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public Integer getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(Integer noOfChildren) {
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

    public String[] getReasonToAdopt() {
        return reasonToAdopt;
    }

    public void setReasonToAdopt(String[] reasonToAdopt) {
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

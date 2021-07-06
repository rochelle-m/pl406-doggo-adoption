package com.doggos.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "applicant")
public class Applicant {

    private String dogId;
    @DBRef
    private User user;
    @Id
    private String applicantId;
    private String applicantName;
    private String phoneNumber;
    private String address;
    private String occupation;
    private Boolean ownPet;
    private Boolean allergy;
    private Integer noOfAdults;
    private Integer noOfChildren;
    private String typeOfHome;
    private String describeHome;
    private String reasonToAdopt;
    private Boolean haveTime;
    private Boolean agreement;

    public Applicant() {

    }


    public Applicant(String dogId, User user, String applicantId, String applicantName, String phoneNumber, String address, String occupation, Boolean ownPet, Boolean allergy, Integer noOfAdults, Integer noOfChildren, String typeOfHome, String describeHome, String reasonToAdopt, Boolean haveTime, Boolean agreement) {
        this.dogId = dogId;
        this.user= user;
        this.applicantId = applicantId;
        this.applicantName = applicantName;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
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

    public void setOwnPet(Boolean ownPet) {
        this.ownPet = ownPet;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(Boolean allergy) {
        this.allergy = allergy;
    }

    public String getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(Integer noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public String getNoOfChildren() {
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

    public String getReasonToAdopt() {
        return reasonToAdopt;
    }

    public void setReasonToAdopt(String reasonToAdopt) {
        this.reasonToAdopt = reasonToAdopt;
    }

    public String getHaveTime() {
        return haveTime;
    }

    public void setHaveTime(Boolean haveTime) {
        this.haveTime = haveTime;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(Boolean agreement) {
        this.agreement = agreement;
    }

}
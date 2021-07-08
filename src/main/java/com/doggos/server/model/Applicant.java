package com.doggos.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "applicant")
public class Applicant {

    @DBRef
    private Doggo doggo;

    @DBRef
    private User user;

    @Id
    private String applicantId;

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


    public Applicant(Doggo doggo,
                     User user,
                     String applicantName,
                     String phoneNumber,
                     String address,
                     String occupation,
                     String ownPet,
                     String allergy,
                     Integer noOfAdults,
                     Integer noOfChildren,
                     String typeOfHome,
                     String describeHome,
                     String[] reasonToAdopt,
                     String haveTime,
                     String agreement) {
        this.doggo = doggo;
        this.user = user;
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

    public Doggo getDoggo() {
        return doggo;
    }

    public void setDoggo(Doggo doggo) {
        this.doggo = doggo;
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

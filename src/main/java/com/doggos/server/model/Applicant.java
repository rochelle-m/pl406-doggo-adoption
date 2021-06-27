package com.doggos.server.model;

public class Applicant {

    private String dog_id;
    private String name;
    private String phone_number;
    private String address;
    private String occupation;
    private String own_pet;
    private String allergy;
    private String noOfAdults;
    private String noOfChildren;
    private String typeOfHome;
    private String describe_house;
    private String whytoadopt;
    private String have_time;
    private String agreement;

    public Applicant(){

    }



    public Applicant(String dog_id, String name, String phone_number, String address, String occupation, String own_pet, String allergy, String noOfAdults, String noOfChildren, String typeOfHome, String describe_house, String whytoadopt, String have_time, String agreement) {
        this.dog_id = dog_id;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.occupation = occupation;
        this.own_pet =  own_pet;
        this.allergy = allergy;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.typeOfHome = typeOfHome;
        this.describe_house = describe_house;
        this.whytoadopt = whytoadopt;
        this.have_time = have_time;
        this.agreement = agreement;

    }

    public String getDog_id() {
        return dog_id;
    }

    public void setDog_id(String dog_id) {
        this.dog_id = dog_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public String getOwn_pet() {
        return own_pet;
    }

    public void setOwn_pet(String own_pet) {
        this.own_pet = own_pet;
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

    public String getDescribe_house() {
        return describe_house;
    }

    public void setDescribe_house(String describe_house) {
        this.describe_house = describe_house;
    }

    public String getWhytoadopt() {
        return whytoadopt;
    }

    public void setWhytoadopt(String whytoadopt) {
        this.whytoadopt = whytoadopt;
    }

    public String getHave_time() {
        return have_time;
    }

    public void setHave_time(String have_time) {
        this.have_time = have_time;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

}

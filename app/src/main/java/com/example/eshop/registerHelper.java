package com.example.eshop;

public class registerHelper {
    String fullName, gender, idNumber, address;

    public registerHelper() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public registerHelper(String fullName, String gender, String idNumber, String address) {
        this.fullName = fullName;
        this.gender = gender;
        this.idNumber = idNumber;
        this.address = address;
    }
}

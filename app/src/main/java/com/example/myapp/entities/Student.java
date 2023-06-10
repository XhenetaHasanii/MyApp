package com.example.myapp.entities;

import java.util.Date;

public class Student {
    public String firstName;
    public String lastName;

    public String birthDate;
    public int personalNumber;
    public String address;
    public int yearLevel;
    public String email;
    public int phoneNumber;




    public Student() {
    }

    public Student(String firstName, String lastName,String birthDate,
     int personalNumber,
   String address,
  int yearLevel,
   String email,
 int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate=birthDate;
        this.personalNumber=personalNumber;
        this.address=address;
        this.yearLevel = yearLevel;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }


    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", personalNumber=" + personalNumber +
                ", address='" + address + '\'' +
                ", yearLevel=" + yearLevel +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

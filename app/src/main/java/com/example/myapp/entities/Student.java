package com.example.myapp.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Student")
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="firstName")
    public String firstName;
    @ColumnInfo(name="lastName")
    public String lastName;
    @ColumnInfo(name="birthDate")
    public String birthDate;
    @ColumnInfo(name="personalNumber")
    public int personalNumber;
    @ColumnInfo(name="address")
    public String address;
    @ColumnInfo(name="yearLevel")
    public int yearLevel;
    @ColumnInfo(name="email")
    public String email;
    @ColumnInfo(name="phoneNumber")
    public int phoneNumber;
    @ColumnInfo(name="password")
    public String password;

    @ColumnInfo(name="nameOfParent")
    public String nameOfParent;

    public Student() {
    }



    public Student(String firstName, String lastName, String birthDate, int personalNumber, String address, int yearLevel, String email, int phoneNumber, String password, String nameOfParent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.personalNumber = personalNumber;
        this.address = address;
        this.yearLevel = yearLevel;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nameOfParent = nameOfParent;
    }

    public String getNameOfParent() {
        return nameOfParent;
    }

    public void setNameOfParent(String nameOfParent) {
        this.nameOfParent = nameOfParent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

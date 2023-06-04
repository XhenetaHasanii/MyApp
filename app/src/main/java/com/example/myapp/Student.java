package com.example.myapp;

public class Student {


    public String firstName;
    public String lastName;
    public int yearLevel;

public Student()
{}

    public Student(String firstName, String lastName, int yearLevel){
        this.firstName=firstName;
        this.lastName=lastName;
        this.yearLevel=yearLevel;
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

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearLevel=" + yearLevel +
                '}';
    }
}

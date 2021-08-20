package com.sparta.cmy.cvsproject.reader.dto;

import java.sql.Date;

import static java.lang.Integer.parseInt;


public class EmployeesDTO {

    private int empID;
    private String namePrefix;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private char gender;
    private String email;
    private java.sql.Date dob;
    private java.sql.Date joinDate;
    private int salary;

    public EmployeesDTO(String[] info){
        this.empID = Integer.parseInt(info[0]);
        this.namePrefix = info[1];
        this.firstName = info[2];
        this.middleInitial =info[3];
        this.lastName =info[4];
        this.gender = info[5].charAt(0);
        this.email =info[6];

        this.dob = stringToDate(info[7]);
        this.joinDate = stringToDate(info[8]);
        this.salary = Integer.parseInt(info[9]);
    }
    public static Date stringToDate(String date){
        int firstSlash = date.indexOf("/");
        int secondSlash = date.indexOf("/", firstSlash+1);
        String year = date.substring(secondSlash+1);
        String day = date.substring(firstSlash+1,secondSlash);
        String month = date.substring(0,firstSlash);
        if (day.length()==1) day = "0"+day;
        if(month.length()==1) month="0"+month;
        return Date.valueOf(year+"-"+month+"-"+day);
    }


    @Override
    public String toString(){
        return (empID + "," +
                namePrefix + "," +
                firstName + "," +
                middleInitial + "," +
                lastName + "," +
                gender + "," +
                email + "," +
                dob + "," +
                joinDate + "," +
                salary + "\n");
    }


    public int getEmpID() {
        return empID;
    }
    public String getNamePrefix() {
        return namePrefix;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleInitial() {
        return middleInitial;
    }
    public String getLastName() {
        return lastName;
    }
    public char getGender() {
        return gender;
    }
    public String getEmail() {
        return email;
    }
    public Date getDob() {
        return dob;
    }
    public Date getJoinDate() {
        return joinDate;
    }
    public int getSalary() {
        return salary;
    }
}


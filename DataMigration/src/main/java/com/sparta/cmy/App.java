package com.sparta.cmy;


import com.sparta.cmy.cvsproject.reader.reader.CsvFilerReader;
import com.sparta.cmy.cvsproject.reader.util.ConnectionManager;
import com.sparta.cmy.cvsproject.reader.util.dao.UserDAO;

public class App {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO(ConnectionManager.connectToDB());
        //UserDAO.createRecord(1,"Astha", "AShwa@spartaglobal.com");
        //userDAO.printAllUsers();
        ConnectionManager.closeConnection();


        CsvFilerReader.readFromFile("C:\\Users\\Cameron\\IdeaProjects\\FileIO\\src\\main\\resources\\EmployeeRecordsLarge.csv");
    }


    }


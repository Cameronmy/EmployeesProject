
package com.sparta.cmy.cvsproject.reader.util.dao;

import com.sparta.cmy.cvsproject.reader.SQLQueries;
import com.sparta.cmy.cvsproject.reader.dto.EmployeesDTO;
import com.sparta.cmy.cvsproject.reader.util.ConnectionManager;

import java.sql.*;
import java.util.HashMap;

public class UserDAO {

    private static Connection connection;
    private Statement statement;


    public UserDAO(Connection connection) {
       this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllUsers(){
        try {
            ResultSet resultSet = statement.executeQuery("select * from employee_db.employees_table");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
                System.out.println(resultSet.getCharacterStream(5));
                System.out.println(resultSet.getString(6));
                System.out.println(resultSet.getString(7));
                System.out.println(resultSet.getString(8));
                System.out.println(resultSet.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    //INSERT INTO `user_db`.`users` (`id`, `user_name`, `email`) VALUES ('2', 'Astha', 'AShaw@spartaglobal.com');
    //anyone users method theyll pass in the values they want

    public static void createRecord(?,?,?,?,?,?,?,?,?,?){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `employee_db`.`employees_table`");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, namePrefix);
            preparedStatement.setString(3,firstName);
            preparedStatement.setString(4,middleInitial);
            preparedStatement.setString(5,lastName);
            preparedStatement.setString(6,gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static final String SELECT_EMPLOYEES = "SELECT * FROM employees_table;";
}


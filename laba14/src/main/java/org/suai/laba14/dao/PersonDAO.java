package org.suai.laba14.dao;

import org.suai.laba14.model.Person;

import javax.servlet.http.Cookie;
import java.sql.*;

public class PersonDAO {

    private static final String URL = "jdbc:postgresql://localhost/note_board_db";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "<your_password>";


    private static Connection connection;

    public PersonDAO(){
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public synchronized void addPerson(String userName, String password){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Person (user_name, password) VALUES (?, ?)");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate(); // добавили человека в person table

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public synchronized Person findByUserName(String userName){
        Person person = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM person WHERE user_name = ?");
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setUserName(resultSet.getString("user_name"));
                person.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }


}

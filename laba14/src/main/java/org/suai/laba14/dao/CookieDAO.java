package org.suai.laba14.dao;

import org.suai.laba14.model.Person;

import javax.servlet.http.Cookie;
import java.sql.*;

public class CookieDAO {

    private static final String URL = "jdbc:postgresql://localhost/note_board_db";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "<your_password>";


    private static Connection connection;

    private PersonDAO personDAO;

    public CookieDAO(){
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

        this.personDAO = new PersonDAO();

    }

    public void addCookieAndEntryTime(String userName, Cookie cookie) {

        int personId = this.personDAO.findByUserName(userName).getId();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT NOW()::timestamp AS time";
            ResultSet resultSet = statement.executeQuery(SQL);
            resultSet.next();
            Timestamp timestamp = resultSet.getTimestamp("time");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Cookie (person_id, entry_time, cookie_value) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, personId);
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.setString(3, cookie.getValue());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}

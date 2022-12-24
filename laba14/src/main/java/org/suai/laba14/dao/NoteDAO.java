package org.suai.laba14.dao;

import org.suai.laba14.model.Note;
import org.suai.laba14.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

    private static final String URL = "jdbc:postgresql://localhost/note_board_db";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "<your_password>";

    private static Connection connection;

    public NoteDAO(){
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

    public synchronized List<Note> index(){
        List<Note> notes = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT Person.id, Person.user_name, Person.password, Note.id as note_id, Note.note_text, DATE_TRUNC('second', Note.time::timestamp) AS time FROM Person\n" +
                    "INNER JOIN Note ON Person.id = Note.user_id";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){

                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setUserName(resultSet.getString("user_name"));
                person.setPassword(resultSet.getString("password"));

                Note note = new Note();
                note.setId(resultSet.getInt("note_id"));
                note.setCreationTime(resultSet.getTimestamp("time"));
                note.setText(resultSet.getString("note_text"));
                note.setOwner(person);

                notes.add(note);
                person.getNoteList().add(note);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }
    public synchronized void addNote(Person owner, String text){

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT NOW()::timestamp AS time";
            ResultSet resultSet = statement.executeQuery(SQL);
            resultSet.next();
            Timestamp timestamp = resultSet.getTimestamp("time");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Note (user_id, time, note_text) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, owner.getId());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.setString(3, text);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}

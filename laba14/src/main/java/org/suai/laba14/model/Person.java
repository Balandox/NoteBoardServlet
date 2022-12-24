package org.suai.laba14.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private int id;
    private String userName;
    private String password;

    private String cookieValue;
    private Timestamp entryTime;
    private List<Note> noteList;

    public Person(int id, String userName, String password, String cookieValue, Timestamp entryTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.cookieValue = cookieValue;
        this.entryTime = entryTime;
        this.noteList = new ArrayList<>();
    }

    public Person(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.noteList = new ArrayList<>();
    }

    public Person(){
        this.noteList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }
}

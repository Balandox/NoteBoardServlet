package org.suai.laba14.model;

import java.sql.Timestamp;

public class Note {

    private int id;
    private Person owner;
    private Timestamp creationTime;
    private String text;

    public Note(int id, Person owner, Timestamp creationTime, String text) {
        this.id = id;
        this.owner = owner;
        this.creationTime = creationTime;
        this.text = text;
    }

    public Note() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

package com.hope.todo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Entity
public class Todo {
    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createts = new Date();

    @Column(columnDefinition = "INTEGER DEFAULT '0'")
    private boolean completed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatets() {
        return createts;
    }

    public void setCreatets(Date createts) {
        this.createts = createts;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

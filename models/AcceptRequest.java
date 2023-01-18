package com.Obrabotka.IT.models;

import javax.persistence.*;

@Entity
@Table(name = "accept_request")
public class AcceptRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String data;
    private String time;
    private String firstName;
    private String lastName;
    private int operation;

    public AcceptRequest(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
}

package com.Obrabotka.IT.models;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "request")
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String data;
    private String time;
    private int operations;
    private String firstName;

    private String lastName;

    private Long operId;

        public Requests(){}

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

        public int getOperation() {
            return operations;
        }

        public void setOperation(int operations) {
            this.operations = operations;
        }

        public String getFirstName(){
            return firstName;
        }

        public void setFirstName(String firstName){
            this.firstName = firstName;
        }

        public String getLastName(){
        return lastName;
    }

        public void setLastName(String lastName){
        this.lastName = lastName;
    }

        public Long getOperId(){
            return operId;
        }

        public void setOperId(Long operId){
            this.operId = operId;
        }

        public String getData(){
            return data;
        }

        public void setData(String data){
            this.data = data;
        }
    }

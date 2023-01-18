package com.Obrabotka.IT.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String data;
    private String time;
    private int operations;
    private String employment;
    public Operation(){}
    public Operation(Long id, String data, String time, String employment, int operations){
        this.id = id;
        this.data = data;
        this.time = time;
        this.employment = employment;
        this.operations = operations;
    }

    public Operation(long l, String busy) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getEmployment(){
        return employment;
    }

    public void setEmployment(String employment){
        this.employment = employment;
    }
    public int getOperations(){
        return operations;
    }

    public void setOperation(int operations){
        this.operations = operations;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }

}

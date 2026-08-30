package com.Hospital.Management.System.doclogin.entity;
import jakarta.persistence.*;

@Entity
@Table(name="appointments")

public class Appointments  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String age;
    private String symptoms;
    private String number;
    public Appointments() {
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public Appointments(String name, long id, String age, String symptoms, String number) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.symptoms = symptoms;
        this.number = number;

    }
}

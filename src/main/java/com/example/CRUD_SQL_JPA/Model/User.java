package com.example.CRUD_SQL_JPA.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "User")

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id ;
    private String firstName  ;
    private String lastName ;
    private String phone ;
    private String Email ;

    public User(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        Email = email;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

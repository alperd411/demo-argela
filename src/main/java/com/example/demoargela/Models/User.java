package com.example.demoargela.Models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "users")
@Entity
@NoArgsConstructor
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long Id;
    @Column(name = "name")
    private  String Name;
    @Column(name = "surname")
    private  String Surname;
    @Column(name ="email")
    private  String EmailAddr;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    @Column(name = "dob")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dob;
    public User(String name, String surname, String emailAddr, HashSet<Role> roles,Date dateOfBirt) {
        Name = name;
        Surname = surname;
        EmailAddr = emailAddr;
        this.roles = roles;
        this.dob = dateOfBirt;
    }


    public long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmailAddr() {
        return EmailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        EmailAddr = emailAddr;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(HashSet<Role> roles) {
        this.roles = roles;
    }

    public String getDob() {

        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        return targetFormat.format(dob);


    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
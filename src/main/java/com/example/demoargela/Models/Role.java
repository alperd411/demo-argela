package com.example.demoargela.Models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "roles")
@NoArgsConstructor
public class Role {

    @jakarta.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    @Column(name = "role",unique = true)
    private  String Role;

    public Role(String role) {
        Role = role;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}

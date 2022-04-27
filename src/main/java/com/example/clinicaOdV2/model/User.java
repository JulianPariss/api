package com.example.clinicaOdV2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Users")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="UserRoles",
            joinColumns = @JoinColumn(name ="id_user"),
            inverseJoinColumns = @JoinColumn(name="id_rol")
    )
    private Set<Rol> roles = new HashSet<>();

    public void addRol(Rol rol){
        this.roles.add(rol);
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


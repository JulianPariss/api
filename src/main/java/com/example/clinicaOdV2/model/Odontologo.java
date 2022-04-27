package com.example.clinicaOdV2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Odontologo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long ID;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Matricula")
    private String matricula;

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Turno> turnos = new HashSet<>();

    public Odontologo(Long ID, String apellido, String nombre, String matricula, Set<Turno> turnos) {
        this.ID = ID;
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
        this.turnos = turnos;
    }

    public Odontologo(String apellido, String nombre, String matricula, Set<Turno> turnos) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
        this.turnos = turnos;
    }

    public Odontologo(){
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
}

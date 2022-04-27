package com.example.clinicaOdV2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Paciente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long ID;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "E_mail")
    private String email;

    @Column(name = "DNI")
    private int dni;

    @Column(name = "Fecha_de_Ingreso")
    //@Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @OneToOne
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;


    @OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    public Paciente(Long ID, String apellido, String nombre, String email, int dni, Date fechaIngreso, Domicilio domicilio, Set<Turno> turnos) {
        this.ID = ID;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.turnos = turnos;
    }

    public Paciente(String apellido, String nombre, String email, int dni, Date fechaIngreso, Domicilio domicilio, Set<Turno> turnos) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.turnos = turnos;
    }

    public Paciente() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
}

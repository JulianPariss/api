package com.example.clinicaOdV2.model;

import javax.persistence.*;

@Entity
@Table
public class Domicilio {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long ID;

    @Column(name = "Calle")
    private String calle;

    @Column(name = "Numero")
    private String numero;

    @Column(name = "Localidad")
    private String localidad;

    @Column(name = "Provincia")
    private String provincia;


    public Domicilio(Long ID, String calle, String numero, String localidad, String provincia, Paciente paciente) {
        this.ID = ID;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio(String calle, String numero, String localidad, String provincia, Paciente paciente) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio() {}

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}

package com.iesbelen.dam.acdat.springboot.modelos.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "departamentos", schema = "public")
public class Departamento {

    @Id
    @Column(name = "depno", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 14)
    private String nombre;

    @Column(name = "ubicacion", length = 13)
    private String ubicacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
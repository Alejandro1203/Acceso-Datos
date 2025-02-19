package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.entidades;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipos_id_gen")
    @SequenceGenerator(name = "equipos_id_gen", sequenceName = "equipos_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @Column(name = "escudo")
    private String escudo;

    @OneToMany(mappedBy = "equipo")
    private Set<Jugadore> jugadores = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoLocal")
    private Set<Partido> partidos = new LinkedHashSet<>();

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

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public Set<Jugadore> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<Jugadore> jugadores) {
        this.jugadores = jugadores;
    }

    public Set<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(Set<Partido> partidos) {
        this.partidos = partidos;
    }

}
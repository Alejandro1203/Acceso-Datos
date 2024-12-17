package com.iesbelen.dam.acdat.springboot.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 10)
    private String nombre;

    @Column(name = "puesto", length = 15)
    private String puesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depno")
    private Departamento depno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depno_depno")
    private Departamento depnoDepno;

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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Departamento getDepno() {
        return depno;
    }

    public void setDepno(Departamento depno) {
        this.depno = depno;
    }

    public Departamento getDepnoDepno() {
        return depnoDepno;
    }

    public void setDepnoDepno(Departamento depnoDepno) {
        this.depnoDepno = depnoDepno;
    }
}
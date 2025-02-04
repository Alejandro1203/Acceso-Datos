package com.iesbelen.dam.apirest.miprimerspringboot.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class EntidadEmpleados {
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
    private EntidadDepartamentos depno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depno_depno")
    private EntidadDepartamentos depnoDepno;

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

    public EntidadDepartamentos getDepno() {
        return depno;
    }

    public void setDepno(EntidadDepartamentos depno) {
        this.depno = depno;
    }

    public EntidadDepartamentos getDepnoDepno() {
        return depnoDepno;
    }

    public void setDepnoDepno(EntidadDepartamentos depnoDepno) {
        this.depnoDepno = depnoDepno;
    }

}
package com.iesbelen.dam.acdat.springboot.modelos.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados", schema = "public")
public class Empleado {
    @Id
    @Column(name = "empno", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 10)
    private String nombre;

    @Column(name = "puesto", length = 15)
    private String puesto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "depno")
    private Departamento depno;

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


}
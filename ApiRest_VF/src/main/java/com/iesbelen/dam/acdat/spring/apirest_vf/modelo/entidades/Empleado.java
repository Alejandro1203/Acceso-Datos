package com.iesbelen.dam.acdat.spring.apirest_vf.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empleados")
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
    @JsonIgnoreProperties("empleados")
    private Departamento depno;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @NotEmpty(message = "El nombre no puede estar vacío.")
    @Size(min = 2, max = 10, message = "El nombre tiene que tener longitud [2-10]")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @NotEmpty(message = "El puesto no puede estar vacío.")
    @Size(min = 2, max = 15, message = "El departamento tiene que tener longitud [2-15]")
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
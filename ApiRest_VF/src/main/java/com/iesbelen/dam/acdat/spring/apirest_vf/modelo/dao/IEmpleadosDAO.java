package com.iesbelen.dam.acdat.spring.apirest_vf.modelo.dao;

import com.iesbelen.dam.acdat.spring.apirest_vf.modelo.entidades.Empleado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEmpleadosDAO extends CrudRepository<Empleado, Integer> {
    Empleado findByNombreStartingWith(String nombre);
    List<Empleado> findByPuestoContaining(String puesto);
}

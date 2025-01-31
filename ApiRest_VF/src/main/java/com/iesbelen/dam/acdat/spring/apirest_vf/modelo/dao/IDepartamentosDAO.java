package com.iesbelen.dam.acdat.spring.apirest_vf.modelo.dao;

import com.iesbelen.dam.acdat.spring.apirest_vf.modelo.entidades.Departamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDepartamentosDAO extends CrudRepository<Departamento, Integer> {
    Departamento findByNombre(String nombre);
    List<Departamento> findByUbicacion(String ubicacion);

    Departamento findByNombreIgnoreCase(String nombre);
    List<Departamento> findByUbicacionIgnoreCase(String ubicacion);
}

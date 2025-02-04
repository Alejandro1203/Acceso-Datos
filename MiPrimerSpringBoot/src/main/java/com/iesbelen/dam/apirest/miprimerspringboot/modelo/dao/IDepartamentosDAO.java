package com.iesbelen.dam.apirest.miprimerspringboot.modelo.dao;

import com.iesbelen.dam.apirest.miprimerspringboot.modelo.entidades.EntidadDepartamentos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartamentosDAO extends CrudRepository<EntidadDepartamentos, Integer> {

    @Query("SELECT d FROM EntidadDepartamentos d WHERE UPPER(d.nombre) = UPPER(:nombre)")
    EntidadDepartamentos findByNombre(String nombre);

    @Query("SELECT d FROM EntidadDepartamentos d WHERE UPPER(d.ubicacion) = UPPER(:ubicacion)")
    EntidadDepartamentos findByUbicacion(String ubicacion);

//    List<EntidadDepartamentos> findByNombre(String nombre);
//    List<EntidadDepartamentos> findByUbicacion(String ubicacion);
//    List<EntidadDepartamentos> findByNombreIsIgnoreCase(String nombre);
//    List<EntidadDepartamentos> findByUbicacionIsIgnoreCase(String ubicacion);
}
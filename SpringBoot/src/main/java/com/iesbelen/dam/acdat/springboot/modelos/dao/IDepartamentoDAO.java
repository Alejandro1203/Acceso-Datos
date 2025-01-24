package com.iesbelen.dam.acdat.springboot.modelos.dao;

import com.iesbelen.dam.acdat.springboot.modelos.dominio.Departamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IDepartamentoDAO extends CrudRepository<Departamento, Integer> {
    
    @Query("SELECT d FROM Departamento d WHERE UPPER(d.nombre) = UPPER(:nombre)")
    Departamento findByNombre(String nombre);

    @Query("SELECT d FROM Departamento d WHERE UPPER(d.ubicacion) = UPPER(:ubicacion)")
    Departamento findByUbicacion(String ubicacion);
}

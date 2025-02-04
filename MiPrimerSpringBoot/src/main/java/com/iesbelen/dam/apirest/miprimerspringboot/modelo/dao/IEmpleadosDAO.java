package com.iesbelen.dam.apirest.miprimerspringboot.modelo.dao;

import com.iesbelen.dam.apirest.miprimerspringboot.modelo.entidades.EntidadEmpleados;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadosDAO extends CrudRepository<EntidadEmpleados, Integer> {

    @Query("SELECT e FROM EntidadEmpleados e WHERE e.nombre LIKE %:prefijo%")
    EntidadEmpleados findByNombre(String prefijo);

    @Query("SELECT e FROM EntidadEmpleados e WHERE UPPER(e.puesto) = UPPER(:puesto)")
    EntidadEmpleados findByPuesto(String puesto);

//    List<EntidadEmpleados> findByPuesto(String puesto);
//    List<EntidadEmpleados> findByDepnoGreaterThanEquals(int depno);
//
//    @Query("SELECT e FROM EntidadEmpleados e WHERE e.nombre LIKE :prefijo%")
//    List<EntidadEmpleados> findByNombre(@Param("prefijo") String prefijo);
//
//    List<EntidadEmpleados> findByNombreStartingWith(@Param("prefijo") String prefijo);
//    List<EntidadEmpleados> findByPuestoContains(String puesto);
}

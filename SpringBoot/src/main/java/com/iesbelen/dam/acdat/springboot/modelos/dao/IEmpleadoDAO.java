package com.iesbelen.dam.acdat.springboot.modelos.dao;

import com.iesbelen.dam.acdat.springboot.modelos.dominio.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEmpleadoDAO extends CrudRepository<Empleado, Integer> {

    @Query("SELECT e FROM Empleado e WHERE e.nombre LIKE %:prefijo%")
    Empleado findByNombre(String prefijo);

//    @Query("SELECT e FROM Empleado e WHERE UPPER(e.puesto) = UPPER(:puesto)")
    List<Empleado> findByPuestoContains(String string);


    /*Empleado findByDepnoGreaterThanEqual(String depno);*/
}

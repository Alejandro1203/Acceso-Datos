package com.iesbelen.dam.acdat.springboot.dao;

import com.iesbelen.dam.acdat.springboot.dominio.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoDAO extends CrudRepository<Empleado, Integer> {

    @Query("SELECT e FROM Empleado e WHERE e.nombre LIKE %:prefijo%")
    Empleado findByNombre(String prefijo);

    @Query("SELECT e FROM Empleado e WHERE UPPER(e.puesto) = UPPER(:puesto)")
    Empleado findByPuesto(String puesto);

    /*Empleado findByDepnoGreaterThanEqual(String depno);*/
}

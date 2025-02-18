package com.iesbelen.dam.acdat.spring.examen.apirest_thymeleaf.modelo.dao;

import com.iesbelen.dam.acdat.spring.examen.apirest_thymeleaf.modelo.entidades.Departamento;
import com.iesbelen.dam.acdat.spring.examen.apirest_thymeleaf.modelo.entidades.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmpleadosDAO extends CrudRepository<Empleado, Integer> {
    Object findAllByDepno(Optional<Departamento> byId);
}

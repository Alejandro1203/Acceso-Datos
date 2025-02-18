package com.iesbelen.dam.acdat.spring.examen.apirest_thymeleaf.modelo.dao;

import com.iesbelen.dam.acdat.spring.examen.apirest_thymeleaf.modelo.entidades.Departamento;
import org.springframework.data.repository.CrudRepository;

public interface IDepartamentosDAO extends CrudRepository<Departamento, Integer> {
}

package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.dao;

import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.entidades.Equipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoDAO extends CrudRepository<Equipo, Integer> {
}

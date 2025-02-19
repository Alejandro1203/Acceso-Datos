package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.dao;

import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.entidades.Partido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartidoDAO extends CrudRepository<Partido, Integer> {
}

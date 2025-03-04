package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.daos;

import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.entidades.Jugador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJugadorDAO extends CrudRepository<Jugador, Integer> {
}

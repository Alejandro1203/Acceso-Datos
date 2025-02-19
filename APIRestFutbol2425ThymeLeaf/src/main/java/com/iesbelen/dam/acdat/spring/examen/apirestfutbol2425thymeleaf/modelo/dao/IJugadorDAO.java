package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.dao;

import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.entidades.Equipo;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.entidades.Jugadore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJugadorDAO extends CrudRepository<Jugadore, Integer> {
    List<Jugadore> findByEquipo(Equipo equipo);

    List<Jugadore> findByEquipo_Id(Integer id);
}

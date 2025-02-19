package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.controladores;

import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.entidades.Jugador;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.servicios.JugadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/futbol-api/jugador")
public class JugadorControlador {

    @Autowired
    JugadorServicio jugadorServicio;

    @GetMapping("/{nombreEquipo}")
    public Set<Jugador> buscarJugadorByNombreEquipo(@PathVariable(value = "nombreEquipo") String nombreEquipo) {
        return jugadorServicio.buscarJugadorByNombreEquipo(nombreEquipo);
    }
}

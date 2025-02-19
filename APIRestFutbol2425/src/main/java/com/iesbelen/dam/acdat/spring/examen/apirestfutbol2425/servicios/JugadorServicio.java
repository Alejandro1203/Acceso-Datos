package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.servicios;

import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.daos.IEquipoDAO;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.daos.IJugadorDAO;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.entidades.Equipo;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.entidades.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class JugadorServicio {

    @Autowired
    IJugadorDAO jugadorDAO;

    @Autowired
    IEquipoDAO equipoDAO;

    public Set<Jugador> buscarJugadorByNombreEquipo(String nombreEquipo) {
        Equipo equipo = equipoDAO.getEquipoByNombre(nombreEquipo);

        return equipo.getJugadores();
    }
}

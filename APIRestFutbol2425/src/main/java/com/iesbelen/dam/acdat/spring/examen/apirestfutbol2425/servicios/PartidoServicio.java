package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.servicios;

import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.daos.IEquipoDAO;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.daos.IPartidoDAO;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.entidades.Equipo;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.entidades.Partido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PartidoServicio {

    @Autowired
    IPartidoDAO partidoDAO;

    @Autowired
    IEquipoDAO equipoDAO;

    public Set<Partido> mostarPartidosByNombreEquipo(String nombreEquipo) {
        Equipo equipo = equipoDAO.getEquipoByNombre(nombreEquipo);

        return equipo.getPartidos();

    }

//    public Set<Partido> mostrarPartidosGanadosByEquipoLocal(String equipoLocal) {
//        Equipo equipo = equipoDAO.getEquipoByNombre(equipoLocal);
//
//        return equipo.getPartidos();
//    }
}

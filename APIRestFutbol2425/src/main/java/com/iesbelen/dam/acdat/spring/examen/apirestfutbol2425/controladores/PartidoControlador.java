package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.controladores;

import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.entidades.Partido;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.servicios.PartidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/futbol-api/partido")
public class PartidoControlador {

    @Autowired
    PartidoServicio partidoServicio;

    @GetMapping("/{nombreEquipo}")
    public Set<Partido> buscarPartidoByNombreEquipo(@PathVariable(value = "nombreEquipo") String nombreEquipo) {
        return partidoServicio.mostarPartidosByNombreEquipo(nombreEquipo);
    }

//    @GetMapping("/{nombreEquipoLocal}")
//    public Set<Partido> mostrarPartidosGanadosByLocal(@PathVariable(value = "nombreEquipoLocal") String nombreEquipoLocal) {
//        return partidoServicio.mostrarPartidosGanadosByEquipoLocal(nombreEquipoLocal);
//    }
}

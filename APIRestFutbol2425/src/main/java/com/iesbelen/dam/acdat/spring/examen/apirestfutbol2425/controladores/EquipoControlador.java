package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.controladores;

import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.entidades.Equipo;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.servicios.EquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/futbol-api/equipo")
public class EquipoControlador {

    @Autowired
    EquipoServicio equipoServicio;

    @GetMapping
    public List<Equipo> buscarEquipos() {
        return equipoServicio.buscarEquipos();
    }

    @GetMapping("/{id}")
    public Optional<Equipo> buscarEquipoById(@PathVariable(value = "id") Integer id) {
        return equipoServicio.buscarEquipoById(id);
    }

    @PostMapping
    public Equipo crearEquipo(@RequestBody Equipo equipo) {
        return equipoServicio.crearEquipo(equipo);
    }

    @DeleteMapping("/{id}")
    public Optional<Equipo> eliminarEquipo(@PathVariable(value = "id") Integer id) {
        return equipoServicio.eliminarEquipo(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> modificarEquipo(@PathVariable(value = "id") Integer id, @RequestBody Equipo equipo) {
        return equipoServicio.actualizarEquipo(equipo, id);
    }
}
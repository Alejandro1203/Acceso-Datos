package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.servicios;

import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.daos.IEquipoDAO;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425.modelos.entidades.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServicio {

    @Autowired
    IEquipoDAO equipoDAO;

    public List<Equipo> buscarEquipos() {
        return (List<Equipo>) equipoDAO.findAll();
    }

    public Optional<Equipo> buscarEquipoById(Integer id) {
        return equipoDAO.findById(id);
    }

    public Equipo crearEquipo(Equipo equipo) {
        return equipoDAO.save(equipo);
    }

    public Optional<Equipo> eliminarEquipo(Integer id) {
        Optional<Equipo> equipo = equipoDAO.findById(id);

        if (equipo.isPresent()) {
            equipoDAO.delete(equipo.get());
        } else {
            return Optional.empty();
        }

        return equipo;
    }

    public ResponseEntity<Equipo> actualizarEquipo(Equipo nuevoEquipo, Integer id) {
        Optional<Equipo> equipoActual = equipoDAO.findById(id);

        if (equipoActual.isPresent()) {
            equipoActual.get().setNombre(nuevoEquipo.getNombre());
            equipoActual.get().setEscudo(nuevoEquipo.getEscudo());
            equipoDAO.save(equipoActual.get());

            return new ResponseEntity<>(equipoActual.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
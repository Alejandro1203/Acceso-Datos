package com.iesbelen.dam.acdat.spring.apirest_vf.controladores;

import com.iesbelen.dam.acdat.spring.apirest_vf.modelo.dao.IDepartamentosDAO;
import com.iesbelen.dam.acdat.spring.apirest_vf.modelo.entidades.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/departamentos")
public class ControladorDepartamentos {

    @Autowired
    private IDepartamentosDAO departamentosDAO;

    @GetMapping
    public List<Departamento> buscarDepartamentos() {
        return (List<Departamento>) departamentosDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarDepartamentoPorId(@PathVariable(value = "id") Integer id) {
        Optional<Departamento> departamento = departamentosDAO.findById(id);

        return departamento.map(value -> ResponseEntity.ok().body(value)).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Departamento guardarDepartamento(@Validated @RequestBody Departamento departamento) {
        return departamentosDAO.save(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarDepartamento(@PathVariable(value = "id") int id) {
        Optional<Departamento> Departamentxml = departamentosDAO.findById(id);

        if (Departamentxml.isPresent()) {
            departamentosDAO.deleteById(id);

            return ResponseEntity.ok().body("Departamento con id" + id + " eliminado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDepartamento(@PathVariable(value = "id") int id, @RequestBody Departamento nuevoDepartamento) {
        Optional<Departamento> departamento = departamentosDAO.findById(id);

        if (departamento.isPresent()) {
            departamento.get().setNombre(nuevoDepartamento.getNombre());
            departamento.get().setUbicacion(nuevoDepartamento.getUbicacion());
            departamento.get().setEmpleados(nuevoDepartamento.getEmpleados());
            departamentosDAO.save(departamento.get());

            return ResponseEntity.ok().body("Departamento con id " + id + " actualizado correctamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
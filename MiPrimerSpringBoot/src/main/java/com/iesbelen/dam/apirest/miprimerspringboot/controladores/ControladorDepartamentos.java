package com.iesbelen.dam.apirest.miprimerspringboot.controladores;


import com.iesbelen.dam.apirest.miprimerspringboot.modelo.dao.IDepartamentosDAO;
import com.iesbelen.dam.apirest.miprimerspringboot.modelo.entidades.EntidadDepartamentos;
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
    IDepartamentosDAO departamentosDAO;

    @GetMapping
    public List<EntidadDepartamentos> buscarDepartamentos() {
        return (List<EntidadDepartamentos>) departamentosDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadDepartamentos> buscarPorId(@PathVariable(value = "id") int id) {
        Optional<EntidadDepartamentos> departamentos = departamentosDAO.findById(id);

        return departamentos.map(entidadDepartamentos -> ResponseEntity.ok().body(entidadDepartamentos)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EntidadDepartamentos guardarDepartamentos(@Validated @RequestBody EntidadDepartamentos departamento) {
        return departamentosDAO.save(departamento);
    }
}
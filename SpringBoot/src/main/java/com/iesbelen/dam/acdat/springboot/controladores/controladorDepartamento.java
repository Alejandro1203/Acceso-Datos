package com.iesbelen.dam.acdat.springboot.controladores;

import com.iesbelen.dam.acdat.springboot.dao.IDepartamentoDAO;
import com.iesbelen.dam.acdat.springboot.dominio.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class controladorDepartamento {

    @Autowired
    IDepartamentoDAO departamentoDAO;

    @GetMapping
    public List<Departamento> listarDepartamentos() {
        return (List<Departamento>) departamentoDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarDepartamentoPorId(@PathVariable(value = "id") int id) {
        Optional<Departamento> departamento = departamentoDAO.findById(id);

        return departamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Departamento insertarDepartamento(@Validated @RequestBody Departamento departamento) {
        return departamentoDAO.save(departamento);
    }
}
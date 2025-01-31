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
}
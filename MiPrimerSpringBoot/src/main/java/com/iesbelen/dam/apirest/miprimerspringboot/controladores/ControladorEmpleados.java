package com.iesbelen.dam.apirest.miprimerspringboot.controladores;

import com.iesbelen.dam.apirest.miprimerspringboot.modelo.dao.IEmpleadosDAO;
import com.iesbelen.dam.apirest.miprimerspringboot.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/empleados")
public class ControladorEmpleados {

    @Autowired
    IEmpleadosDAO empleadosDAO;

    @GetMapping
    public List<EntidadEmpleados> buscarEmpleados(){
        return (List<EntidadEmpleados>) empleadosDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadEmpleados> buscarEmpleadosPorId(@PathVariable(value = "id") int id){
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);

        return empleado.map(entidadEmpleados -> ResponseEntity.ok().body(entidadEmpleados)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EntidadEmpleados guardarEmpleados (@Validated @RequestBody EntidadEmpleados empleados){
        return empleadosDAO.save(empleados);
    }
}
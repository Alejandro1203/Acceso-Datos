package com.iesbelen.dam.acdat.springboot.controladores;

import com.iesbelen.dam.acdat.springboot.dao.IEmpleadoDAO;
import com.iesbelen.dam.acdat.springboot.dominio.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/empleados")
public class controladorEmpleado {

    @Autowired
    IEmpleadoDAO empleadoDAO;

    @GetMapping
    public List<Empleado> listarEmpleados() {
        return (List<Empleado>) empleadoDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorID(@PathVariable(value="id") int id) {
        Optional<Empleado> empleado = empleadoDAO.findById(id);

        return empleado.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empleado insertarEmpleado(@Validated @RequestBody Empleado empleado) {
        return empleadoDAO.save(empleado);
    }
}
package com.iesbelen.dam.acdat.spring.apirest_vf.controladores;

import com.iesbelen.dam.acdat.spring.apirest_vf.modelo.dao.IEmpleadosDAO;
import com.iesbelen.dam.acdat.spring.apirest_vf.modelo.entidades.Empleado;
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
    public List<Empleado> buscarEmpleados(){
        return (List<Empleado>) empleadosDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadosPorId(@PathVariable(value = "id") int id){
        Optional<Empleado> empleado = empleadosDAO.findById(id);

        return empleado.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empleado guardarEmpleado(@Validated @RequestBody Empleado empleado){
        return empleadosDAO.save(empleado);
    }
}

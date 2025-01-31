package com.iesbelen.dam.acdat.spring.apirest_vf.controladores;

import com.iesbelen.dam.acdat.spring.apirest_vf.modelo.dao.IDepartamentosDAO;
import com.iesbelen.dam.acdat.spring.apirest_vf.modelo.dao.IEmpleadosDAO;
import com.iesbelen.dam.acdat.spring.apirest_vf.modelo.dto.EmpleadosDTO;
import com.iesbelen.dam.acdat.spring.apirest_vf.modelo.entidades.Departamento;
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

    @Autowired
    IDepartamentosDAO departamentosDAO;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEmpleado(@PathVariable(value = "id") int id){
        Optional<Empleado> Employeexml = empleadosDAO.findById(id);

        if(Employeexml.isPresent()){
            empleadosDAO.deleteById(id);

            return ResponseEntity.ok().body("Empleado con id " + id + " borrado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable(value = "id") int id, @Validated @RequestBody Empleado nuevoEmpleado){
        Optional<Empleado> empleado = empleadosDAO.findById(id);

        if(empleado.isPresent()){
            empleado.get().setNombre(nuevoEmpleado.getNombre());
            empleado.get().setPuesto(nuevoEmpleado.getPuesto());
            empleado.get().setDepno(nuevoEmpleado.getDepno());
            empleadosDAO.save(nuevoEmpleado);

            return ResponseEntity.ok().body("Empleado con id " + id + " actualizado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<EmpleadosDTO> buscarEmpleadoDTOPorId(@PathVariable(value = "id") int id){
        Optional<Empleado> empleado = empleadosDAO.findById(id);

        if(empleado.isPresent()){
            Optional<Departamento> departamento = departamentosDAO.findById(empleado.get().getDepno().getId());

            EmpleadosDTO empleadosDTO = new EmpleadosDTO();
            empleadosDTO.setId(empleado.get().getId());
            empleadosDTO.setNombre(empleado.get().getNombre());
            empleadosDTO.setPuesto(empleado.get().getPuesto());
            empleadosDTO.setDepno(empleado.get().getDepno().getId());
            empleadosDTO.setDepartamentoNombre(departamento.get().getNombre());
            empleadosDTO.setDepartamentoUbicacion(departamento.get().getUbicacion());

            return ResponseEntity.ok().body(empleadosDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
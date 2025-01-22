package com.iesbelen.dam.acdat.springboot.controladores;

import com.iesbelen.dam.acdat.springboot.dao.IDepartamentoDAO;
import com.iesbelen.dam.acdat.springboot.dao.IEmpleadoDAO;
import com.iesbelen.dam.acdat.springboot.dominio.Departamento;
import com.iesbelen.dam.acdat.springboot.dominio.Empleado;
import com.iesbelen.dam.acdat.springboot.dto.EmpleadoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class controladorEmpleado {

    @Autowired
    IEmpleadoDAO empleadoDAO;

    @Autowired
    IDepartamentoDAO departamentoDAO;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEmpleado(@PathVariable(value = "id") int id) {
        Optional<Empleado> empleadoXML = empleadoDAO.findById(id);

        if (empleadoXML.isPresent()) {
            empleadoDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarEmpleado(@PathVariable(value = "id") int id, @RequestBody Empleado nuevoEmpleado) {
        Optional<Empleado> empleado = empleadoDAO.findById(id);

        if (empleado.isPresent()) {
            empleado.get().setNombre(nuevoEmpleado.getNombre());
            empleado.get().setPuesto(nuevoEmpleado.getPuesto());
            empleado.get().setDepno(nuevoEmpleado.getDepno());
            empleadoDAO.save(empleado.get());
            return ResponseEntity.ok().body("Modificado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("dto/{id}")
    public ResponseEntity<EmpleadoDTO> buscarEmpleadoDTOById(@PathVariable(value = "id") int id) {
        Optional<Empleado> empleado = empleadoDAO.findById(id);

        if (empleado.isPresent()) {
//            EmpleadoDTO empleadoDTO = new EmpleadoDTO();
//            empleadoDTO.setEmpno(empleado.get().getId());
//            empleadoDTO.setNombre(empleado.get().getNombre());
//            empleadoDTO.setPuesto(empleado.get().getPuesto());
//            empleadoDTO.setDepno(empleado.get().getDepno().getId());
//            empleadoDTO.setDepartamentoNombre(empleado.get().getDepno().getNombre());
//            empleadoDTO.setDepartamentoUbicacion(empleado.get().getDepno().getUbicacion());

            Optional<Departamento> departamento = departamentoDAO.findById(empleado.get().getDepno().getId());

            ModelMapper mapper = new ModelMapper();
            EmpleadoDTO empleadoDTO = mapper.map(empleado.get(), EmpleadoDTO.class);

            mapper.map(departamento.get(), empleadoDTO);

            return ResponseEntity.ok().body(empleadoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
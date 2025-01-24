package com.iesbelen.dam.acdat.springboot.controladores;

import com.iesbelen.dam.acdat.springboot.modelos.dao.IDepartamentoDAO;
import com.iesbelen.dam.acdat.springboot.modelos.dominio.Empleado;
import com.iesbelen.dam.acdat.springboot.modelos.dto.EmpleadoDTO;
import com.iesbelen.dam.acdat.springboot.modelos.servicio.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class ControladorEmpleado {

//    @Autowired
//    IEmpleadoDAO empleadoDAO;

    @Autowired
    ServicioEmpleado servicioEmpleado;

    @Autowired
    IDepartamentoDAO departamentoDAO;

    @GetMapping
    public List<Empleado> listarEmpleados(@RequestParam(name = "puesto", required = false) String puesto) {
        if (puesto == null)
            return servicioEmpleado.buscarEmpleados();
        else
            return servicioEmpleado.buscarEmpleadoporPuesto(puesto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorID(@PathVariable(value="id") int id) {
        Optional<Empleado> empleado = servicioEmpleado.buscarEmpleadoporId(id);

        return empleado.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empleado insertarEmpleado(@Validated @RequestBody Empleado empleado) {
        return servicioEmpleado.guardarEmpleado(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEmpleado(@PathVariable(value = "id") int id) {
        Optional<Empleado> empleadoXML = servicioEmpleado.buscarEmpleadoporId(id);

        if (empleadoXML.isPresent()) {
            servicioEmpleado.borrarEmpleado(id);
            return ResponseEntity.ok().body("Borrado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarEmpleado(@PathVariable(value = "id") int id, @RequestBody Empleado nuevoEmpleado) {
        Optional<Empleado> empleado = servicioEmpleado.buscarEmpleadoporId(id);

        if (empleado.isPresent()) {
            empleado.get().setNombre(nuevoEmpleado.getNombre());
            empleado.get().setPuesto(nuevoEmpleado.getPuesto());
            empleado.get().setDepno(nuevoEmpleado.getDepno());
            servicioEmpleado.guardarEmpleado(empleado.get());
            return ResponseEntity.ok().body("Modificado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("dto/{id}")
    public ResponseEntity<EmpleadoDTO> buscarEmpleadoDTOById(@PathVariable(value = "id") int id) {
        Optional<Empleado> empleado = servicioEmpleado.buscarEmpleadoporId(id);

        if (empleado.isPresent()) {
            EmpleadoDTO empleadoDTO = new EmpleadoDTO();
            empleadoDTO.setEmpno(empleado.get().getId());
            empleadoDTO.setNombre(empleado.get().getNombre());
            empleadoDTO.setPuesto(empleado.get().getPuesto());
            empleadoDTO.setDepno(empleado.get().getDepno().getId());
            empleadoDTO.setDepartamentoNombre(empleado.get().getDepno().getNombre());
            empleadoDTO.setDepartamentoUbicacion(empleado.get().getDepno().getUbicacion());

//            Optional<Departamento> departamento = departamentoDAO.findById(empleado.get().getDepno().getId());
//
//            ModelMapper mapper = new ModelMapper();
//            EmpleadoDTO empleadoDTO = mapper.map(empleado.get(), EmpleadoDTO.class);
//
//            mapper.map(departamento.get(), empleadoDTO);

            return ResponseEntity.ok().body(empleadoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
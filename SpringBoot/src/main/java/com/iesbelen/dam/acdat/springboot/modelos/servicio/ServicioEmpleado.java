package com.iesbelen.dam.acdat.springboot.modelos.servicio;

import com.iesbelen.dam.acdat.springboot.modelos.dao.IEmpleadoDAO;
import com.iesbelen.dam.acdat.springboot.modelos.dominio.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEmpleado {

    @Autowired
    private IEmpleadoDAO empleadoDAO;

    public List<Empleado> buscarEmpleados() {
        return (List<Empleado>) empleadoDAO.findAll();
    }

    public Optional<Empleado> buscarEmpleadoporId(Integer id) {
        return empleadoDAO.findById(id);
    }

    public List<Empleado> buscarEmpleadoporPuesto(String puesto) {
        return empleadoDAO.findByPuestoContains(puesto);
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoDAO.save(empleado);
    }

    public Optional<Empleado> borrarEmpleado(int id) {
        Optional<Empleado> empleado = empleadoDAO.findById(id);

        if (empleado.isPresent()) {
            empleadoDAO.delete(empleado.get());
        } else {
            return Optional.empty();
        }

        return empleado;


    }
}

package com.iesbelen.dam.acdat.spring.examen.apirest_thymeleaf.controladores;


import com.iesbelen.dam.acdat.spring.examen.apirest_thymeleaf.modelo.dao.IDepartamentosDAO;
import com.iesbelen.dam.acdat.spring.examen.apirest_thymeleaf.modelo.dao.IEmpleadosDAO;
import com.iesbelen.dam.acdat.spring.examen.apirest_thymeleaf.modelo.entidades.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewController {

    @Autowired
    IDepartamentosDAO departamentosDAO;

    @Autowired
    IEmpleadosDAO empleadosDAO;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/verdepartamentos")
    public String mostrarDepartamentos(Model model) {
        List<Departamento> departamentos = (List<Departamento>) departamentosDAO.findAll();
        model.addAttribute("departamentos", departamentos);

        return "verdepartamentos";
    }
}

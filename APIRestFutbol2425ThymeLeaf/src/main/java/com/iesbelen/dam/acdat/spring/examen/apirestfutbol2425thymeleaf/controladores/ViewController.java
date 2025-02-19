package com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.controladores;

import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.dao.IEquipoDAO;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.dao.IJugadorDAO;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.dao.IPartidoDAO;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.entidades.Equipo;
import com.iesbelen.dam.acdat.spring.examen.apirestfutbol2425thymeleaf.modelo.entidades.Jugadore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ViewController {

    @Autowired
    IJugadorDAO jugadorDAO;

    @Autowired
    IEquipoDAO equipoDAO;

    @Autowired
    IPartidoDAO partidoDAO;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/verequipos")
    public String verEquipos(Model model) {
        model.addAttribute("equipos", equipoDAO.findAll());
        return "verequipos";
    }

    @GetMapping("/verjugadores")
    public String verJugadores(Model model, @RequestParam(name = "id", required = false) Integer id) {
        List<Equipo> equipos = (List<Equipo>) equipoDAO.findAll();
        model.addAttribute("equipos", equipos);
        List<Jugadore> jugadores;

        if(id == null) {
            jugadores = (List<Jugadore>) jugadorDAO.findAll();
        } else {
            jugadores =  jugadorDAO.findByEquipo_Id(id);
        }
        model.addAttribute("jugadores", jugadores);

        return "verjugadores";
    }

    @GetMapping("/verpartidos")
    public String verPartidos(Model model) {
        model.addAttribute("partidos", partidoDAO.findAll());
        return "verpartidos";
    }

    @GetMapping("/verjugador")
    public String verJugador(Model model, @RequestParam(name = "id", required = true) int id) {
        Optional<Jugadore> jugador = jugadorDAO.findById(id);

        if(!jugador.isPresent()) {
            model.addAttribute("titulo", "Error");
            return "error";
        }

        model.addAttribute("jugador", jugador.get());
        return "verjugador";
    }

    @GetMapping("/altaequipo")
    public String altaEquipo(Model model) {
        model.addAttribute("equipo", new Equipo());

        return "altaequipo";
    }

    @PostMapping("/altaequipo")
    public String crearEquipo(@ModelAttribute Equipo equipo, Model model) {
        if(!equipoDAO.existsById(equipo.getId())) {
            equipoDAO.save(equipo);
            model.addAttribute("tipo_operacion", "ok");
            model.addAttribute("mensaje", "Equipo creado");
        } else {
            model.addAttribute("tipo_operacion", "error");
            model.addAttribute("mensaje", "Error al crear el equipo: clave duplicada");

        }

        return "altaequipo";
    }
}

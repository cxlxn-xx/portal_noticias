package ar.com.portal_noticias.controller;

import ar.com.portal_noticias.entities.*;
import ar.com.portal_noticias.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/portal")
public class VistaController {

    @Autowired private IPublicacionesServices publicacionService;
    @Autowired private ITemasServices temaService;
    @Autowired private IAutoresServices autorService;

    // ==========================================
    // VISTAS PÚBLICAS
    // ==========================================
    @GetMapping("/publico")
    public String verPublico(Model model) {
        model.addAttribute("publicaciones", publicacionService.getAll());
        return "publico/index";
    }

    // ==========================================
    // VISTAS ADMIN (RESTRINGIDAS)
    // ==========================================
    @GetMapping("/admin")
    public String verAdmin(Model model) {
        model.addAttribute("publicaciones", publicacionService.getAll());
        return "admin/lista";
    }

    // --- Formulario de Publicación ---
    @GetMapping("/admin/publicacion/form")
    public String formPublicacion(Model model) {
        model.addAttribute("publicacion", new Publicaciones());
        model.addAttribute("temas", temaService.getAll());
        model.addAttribute("autores", autorService.getAll());
        return "admin/publicacion-form";
    }

    //  Guardar Publicación
    @PostMapping("/admin/publicacion/guardar")
    public String guardarPublicacion(@ModelAttribute Publicaciones publicacion, @RequestParam Integer idAutor) {
        Autores autor = autorService.get(idAutor);

        PublicacionAutores relacion = new PublicacionAutores();
        relacion.setAutor(autor);
        relacion.setEsPrincipal(true);
        relacion.setPublicacion(publicacion);

        publicacion.setAutores(List.of(relacion));
        publicacionService.save(publicacion);

        return "redirect:/portal/admin";
    }
}
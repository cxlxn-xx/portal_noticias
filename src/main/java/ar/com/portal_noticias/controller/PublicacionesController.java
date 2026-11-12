package ar.com.portal_noticias.controller;

import ar.com.portal_noticias.entities.Publicaciones;
import ar.com.portal_noticias.services.IPublicacionesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PublicacionesController {

    @Autowired
    private IPublicacionesServices entityService;

    @GetMapping(path = "/publicaciones")
    public List<Publicaciones> getAll() { return entityService.getAll(); }

    @GetMapping(path = "/publicaciones/{id}")
    public Publicaciones get(@PathVariable Integer id) { return entityService.get(id); }

    @PostMapping(value = "/publicaciones", consumes = "application/json", produces = "application/json")
    public Publicaciones save(@RequestBody Publicaciones entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "/publicaciones/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Publicaciones entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) { return e.getMessage().toString(); }
    }
}
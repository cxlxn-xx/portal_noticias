package ar.com.portal_noticias.controller;

import ar.com.portal_noticias.entities.Autores;
import ar.com.portal_noticias.services.IAutoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AutoresController {

    @Autowired
    private IAutoresServices entityService;

    @GetMapping(path = "/autores")
    public List<Autores> getAll() { return entityService.getAll(); }

    @GetMapping(path = "/autores/{id}")
    public Autores get(@PathVariable Integer id) { return entityService.get(id); }

    @PostMapping(value = "/autores", consumes = "application/json", produces = "application/json")
    public Autores save(@RequestBody Autores entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "/autores/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Autores entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) { return e.getMessage().toString(); }
    }
}
package ar.com.portal_noticias.controller;

import ar.com.portal_noticias.entities.Temas;
import ar.com.portal_noticias.services.ITemasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TemasController {

    @Autowired
    private ITemasServices entityService;


    @GetMapping(path = "/temas")
    public List<Temas> getAll() {
        return entityService.getAll();
    }


    @GetMapping(path = "/temas/{id}")
    public Temas get(@PathVariable Integer id) {
        return entityService.get(id);
    }


    @PostMapping(value = "/temas", consumes = "application/json", produces = "application/json")
    public Temas save(@RequestBody Temas entity) {
        entityService.save(entity);
        return entity;
    }


    @GetMapping(path = "/temas/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Temas entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
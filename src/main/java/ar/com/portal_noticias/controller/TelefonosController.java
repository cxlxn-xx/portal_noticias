package ar.com.portal_noticias.controller;
import ar.com.portal_noticias.entities.Telefonos;
import ar.com.portal_noticias.services.ITelefonosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class TelefonosController {
    @Autowired private ITelefonosServices entityService;
    @GetMapping("/telefonos") public List<Telefonos> getAll() { return entityService.getAll(); }
    @GetMapping("/telefonos/{id}") public Telefonos get(@PathVariable Integer id) { return entityService.get(id); }
    @PostMapping(value = "/telefonos", consumes = "application/json", produces = "application/json")
    public Telefonos save(@RequestBody Telefonos entity) { entityService.save(entity); return entity; }
    @GetMapping("/telefonos/delete/{id}") public String delete(@PathVariable Integer id) {
        Telefonos entity = entityService.get(id); return entityService.delete(entity);
    }
}
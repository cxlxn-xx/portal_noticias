package ar.com.portal_noticias.controller;
import ar.com.portal_noticias.entities.Archivos;
import ar.com.portal_noticias.services.IArchivosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class ArchivosController {
    @Autowired private IArchivosServices entityService;
    @GetMapping("/archivos") public List<Archivos> getAll() { return entityService.getAll(); }
    @GetMapping("/archivos/{id}") public Archivos get(@PathVariable Integer id) { return entityService.get(id); }
    @PostMapping(value = "/archivos", consumes = "application/json", produces = "application/json")
    public Archivos save(@RequestBody Archivos entity) { entityService.save(entity); return entity; }
    @GetMapping("/archivos/delete/{id}") public String delete(@PathVariable Integer id) {
        Archivos entity = entityService.get(id); return entityService.delete(entity);
    }
}
package ar.com.portal_noticias.controller;
import ar.com.portal_noticias.entities.Imagenes;
import ar.com.portal_noticias.services.IImagenesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class ImagenesController {
    @Autowired private IImagenesServices entityService;
    @GetMapping("/imagenes") public List<Imagenes> getAll() { return entityService.getAll(); }
    @GetMapping("/imagenes/{id}") public Imagenes get(@PathVariable Integer id) { return entityService.get(id); }
    @PostMapping(value = "/imagenes", consumes = "application/json", produces = "application/json")
    public Imagenes save(@RequestBody Imagenes entity) { entityService.save(entity); return entity; }
    @GetMapping("/imagenes/delete/{id}") public String delete(@PathVariable Integer id) {
        Imagenes entity = entityService.get(id); return entityService.delete(entity);
    }
}
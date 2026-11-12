package ar.com.portal_noticias.controller;
import ar.com.portal_noticias.entities.Links;
import ar.com.portal_noticias.services.ILinksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class LinksController {
    @Autowired private ILinksServices entityService;
    @GetMapping("/links") public List<Links> getAll() { return entityService.getAll(); }
    @GetMapping("/links/{id}") public Links get(@PathVariable Integer id) { return entityService.get(id); }
    @PostMapping(value = "/links", consumes = "application/json", produces = "application/json")
    public Links save(@RequestBody Links entity) { entityService.save(entity); return entity; }
    @GetMapping("/links/delete/{id}") public String delete(@PathVariable Integer id) {
        Links entity = entityService.get(id); return entityService.delete(entity);
    }
}
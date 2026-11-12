package ar.com.portal_noticias.controller;
import ar.com.portal_noticias.entities.Roles;
import ar.com.portal_noticias.services.IRolesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class RolesController {
    @Autowired private IRolesServices entityService;
    @GetMapping("/roles") public List<Roles> getAll() { return entityService.getAll(); }
    @GetMapping("/roles/{id}") public Roles get(@PathVariable Integer id) { return entityService.get(id); }
    @PostMapping(value = "/roles", consumes = "application/json", produces = "application/json")
    public Roles save(@RequestBody Roles entity) { entityService.save(entity); return entity; }
    @GetMapping("/roles/delete/{id}") public String delete(@PathVariable Integer id) {
        Roles entity = entityService.get(id); return entityService.delete(entity);
    }
}
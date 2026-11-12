package ar.com.portal_noticias.controller;
import ar.com.portal_noticias.entities.Usuarios;
import ar.com.portal_noticias.services.IUsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class UsuariosController {
    @Autowired private IUsuariosServices entityService;
    @GetMapping("/usuarios") public List<Usuarios> getAll() { return entityService.getAll(); }
    @GetMapping("/usuarios/{id}") public Usuarios get(@PathVariable Integer id) { return entityService.get(id); }
    @PostMapping(value = "/usuarios", consumes = "application/json", produces = "application/json")
    public Usuarios save(@RequestBody Usuarios entity) { entityService.save(entity); return entity; }
    @GetMapping("/usuarios/delete/{id}") public String delete(@PathVariable Integer id) {
        Usuarios entity = entityService.get(id); return entityService.delete(entity);
    }
}
package ar.com.portal_noticias.controller;
import ar.com.portal_noticias.entities.Especialidades;
import ar.com.portal_noticias.services.IEspecialidadesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class EspecialidadesController {
    @Autowired private IEspecialidadesServices entityService;
    @GetMapping("/especialidades") public List<Especialidades> getAll() { return entityService.getAll(); }
    @GetMapping("/especialidades/{id}") public Especialidades get(@PathVariable Integer id) { return entityService.get(id); }
    @PostMapping(value = "/especialidades", consumes = "application/json", produces = "application/json")
    public Especialidades save(@RequestBody Especialidades entity) { entityService.save(entity); return entity; }
    @GetMapping("/especialidades/delete/{id}") public String delete(@PathVariable Integer id) {
        Especialidades entity = entityService.get(id); return entityService.delete(entity);
    }
}
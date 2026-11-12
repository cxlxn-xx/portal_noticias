package ar.com.portal_noticias.controller;
import ar.com.portal_noticias.entities.Emails;
import ar.com.portal_noticias.services.IEmailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class EmailsController {
    @Autowired private IEmailsServices entityService;
    @GetMapping("/emails") public List<Emails> getAll() { return entityService.getAll(); }
    @GetMapping("/emails/{id}") public Emails get(@PathVariable Integer id) { return entityService.get(id); }
    @PostMapping(value = "/emails", consumes = "application/json", produces = "application/json")
    public Emails save(@RequestBody Emails entity) { entityService.save(entity); return entity; }
    @GetMapping("/emails/delete/{id}") public String delete(@PathVariable Integer id) {
        Emails entity = entityService.get(id); return entityService.delete(entity);
    }
}
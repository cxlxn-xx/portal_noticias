package ar.com.portal_noticias.controller;
import ar.com.portal_noticias.entities.Tags;
import ar.com.portal_noticias.services.ITagsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class TagsController {
    @Autowired private ITagsServices entityService;
    @GetMapping("/tags") public List<Tags> getAll() { return entityService.getAll(); }
    @GetMapping("/tags/{id}") public Tags get(@PathVariable Integer id) { return entityService.get(id); }
    @PostMapping(value = "/tags", consumes = "application/json", produces = "application/json")
    public Tags save(@RequestBody Tags entity) { entityService.save(entity); return entity; }
    @GetMapping("/tags/delete/{id}") public String delete(@PathVariable Integer id) {
        Tags entity = entityService.get(id); return entityService.delete(entity);
    }
}
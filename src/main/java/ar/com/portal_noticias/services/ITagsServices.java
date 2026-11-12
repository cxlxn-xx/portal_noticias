package ar.com.portal_noticias.services;
import ar.com.portal_noticias.entities.Tags;
import java.util.List;
public interface ITagsServices {
    List<Tags> getAll(); Tags get(Integer id); void save(Tags entity); String delete(Tags entity);
}
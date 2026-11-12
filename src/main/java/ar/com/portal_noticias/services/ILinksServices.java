package ar.com.portal_noticias.services;
import ar.com.portal_noticias.entities.Links;
import java.util.List;
public interface ILinksServices {
    List<Links> getAll(); Links get(Integer id); void save(Links entity); String delete(Links entity);
}
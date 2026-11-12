package ar.com.portal_noticias.services;
import ar.com.portal_noticias.entities.Temas;
import java.util.List;

public interface ITemasServices {
    List<Temas> getAll();
    Temas get(Integer id);
    void save(Temas entity);
    String delete(Temas entity);
}

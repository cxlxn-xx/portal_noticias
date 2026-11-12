package ar.com.portal_noticias.services;
import ar.com.portal_noticias.entities.Imagenes;
import java.util.List;
public interface IImagenesServices {
    List<Imagenes> getAll(); Imagenes get(Integer id); void save(Imagenes entity); String delete(Imagenes entity);
}
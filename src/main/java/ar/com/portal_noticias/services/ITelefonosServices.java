package ar.com.portal_noticias.services;
import ar.com.portal_noticias.entities.Telefonos;
import java.util.List;
public interface ITelefonosServices {
    List<Telefonos> getAll(); Telefonos get(Integer id); void save(Telefonos entity); String delete(Telefonos entity);
}
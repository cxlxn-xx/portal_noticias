package ar.com.portal_noticias.services;

import ar.com.portal_noticias.entities.Publicaciones;
import java.util.List;

public interface IPublicacionesServices {
    List<Publicaciones> getAll();
    Publicaciones get(Integer id);
    void save(Publicaciones entity);
    String delete(Publicaciones entity);
}
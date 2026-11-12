package ar.com.portal_noticias.services;

import ar.com.portal_noticias.entities.Autores;
import java.util.List;

public interface IAutoresServices {
    List<Autores> getAll();
    Autores get(Integer id);
    void save(Autores entity);
    String delete(Autores entity);
}
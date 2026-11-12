package ar.com.portal_noticias.services;

import ar.com.portal_noticias.entities.Especialidades;
import java.util.List;

public interface IEspecialidadesServices {
    List<Especialidades> getAll();
    Especialidades get(Integer id);
    void save(Especialidades entity);
    String delete(Especialidades entity);
}
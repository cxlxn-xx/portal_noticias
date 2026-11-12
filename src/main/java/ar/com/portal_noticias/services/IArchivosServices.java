package ar.com.portal_noticias.services;
import ar.com.portal_noticias.entities.Archivos;
import java.util.List;
public interface IArchivosServices {
    List<Archivos> getAll(); Archivos get(Integer id); void save(Archivos entity); String delete(Archivos entity);
}
package ar.com.portal_noticias.services;
import ar.com.portal_noticias.entities.Usuarios;
import java.util.List;
public interface IUsuariosServices {
    List<Usuarios> getAll(); Usuarios get(Integer id); void save(Usuarios entity); String delete(Usuarios entity);
}
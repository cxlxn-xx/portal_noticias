package ar.com.portal_noticias.services;
import ar.com.portal_noticias.entities.Roles;
import java.util.List;
public interface IRolesServices {
    List<Roles> getAll(); Roles get(Integer id); void save(Roles entity); String delete(Roles entity);
}
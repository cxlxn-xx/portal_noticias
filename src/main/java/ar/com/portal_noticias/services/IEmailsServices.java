package ar.com.portal_noticias.services;
import ar.com.portal_noticias.entities.Emails;
import java.util.List;
public interface IEmailsServices {
    List<Emails> getAll(); Emails get(Integer id); void save(Emails entity); String delete(Emails entity);
}
package ar.com.portal_noticias.servicesimp;

import ar.com.portal_noticias.dao.IPublicacionesDao;
import ar.com.portal_noticias.entities.Publicaciones;
import ar.com.portal_noticias.services.IPublicacionesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PublicacionesServices implements IPublicacionesServices {

    @Autowired
    private IPublicacionesDao entityDao;

    public List<Publicaciones> getAll() { return entityDao.findAll(Sort.by(Sort.Direction.DESC, "fechaPublicacion")); }
    public Publicaciones get(Integer id) { return entityDao.findById(id).orElse(null); }

    @Transactional public void save(Publicaciones entity) { entityDao.save(entity); }

    @Transactional public String delete(Publicaciones entity) {
        try { entityDao.delete(entity); return null; }
        catch (Exception e) { return e.getMessage().toString(); }
    }
}
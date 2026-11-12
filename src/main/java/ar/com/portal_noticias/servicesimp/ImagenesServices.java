package ar.com.portal_noticias.servicesimp;
import ar.com.portal_noticias.dao.IImagenesDao;
import ar.com.portal_noticias.entities.Imagenes;
import ar.com.portal_noticias.services.IImagenesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ImagenesServices implements IImagenesServices {
    @Autowired private IImagenesDao entityDao;
    public List<Imagenes> getAll() { return entityDao.findAll(Sort.by(Sort.Direction.ASC, "descripcion")); }
    public Imagenes get(Integer id) { return entityDao.findById(id).orElse(null); }
    @Transactional public void save(Imagenes entity) { entityDao.save(entity); }
    @Transactional public String delete(Imagenes entity) {
        try { entityDao.delete(entity); return null; } catch (Exception e) { return e.getMessage(); }
    }
}
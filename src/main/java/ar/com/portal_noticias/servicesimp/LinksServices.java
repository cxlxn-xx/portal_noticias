package ar.com.portal_noticias.servicesimp;
import ar.com.portal_noticias.dao.ILinksDao;
import ar.com.portal_noticias.entities.Links;
import ar.com.portal_noticias.services.ILinksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class LinksServices implements ILinksServices {
    @Autowired private ILinksDao entityDao;
    public List<Links> getAll() { return entityDao.findAll(Sort.by(Sort.Direction.ASC, "descripcion")); }
    public Links get(Integer id) { return entityDao.findById(id).orElse(null); }
    @Transactional public void save(Links entity) { entityDao.save(entity); }
    @Transactional public String delete(Links entity) {
        try { entityDao.delete(entity); return null; } catch (Exception e) { return e.getMessage(); }
    }
}
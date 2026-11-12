package ar.com.portal_noticias.servicesimp;
import ar.com.portal_noticias.dao.ITemasDao;
import ar.com.portal_noticias.entities.Temas;
import ar.com.portal_noticias.services.ITemasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TemasServices implements ITemasServices {
    @Autowired private ITemasDao entityDao;
    public List<Temas> getAll() { return entityDao.findAll(Sort.by(Sort.Direction.ASC, "nombre")); }
    public Temas get(Integer id) { return entityDao.findById(id).orElse(null); }
    @Transactional public void save(Temas entity) { entityDao.save(entity); }
    @Transactional public String delete(Temas entity) {
        try { entityDao.delete(entity); return null; } catch (Exception e) { return e.getMessage(); }
    }
}
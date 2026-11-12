package ar.com.portal_noticias.servicesimp;
import ar.com.portal_noticias.dao.ITelefonosDao;
import ar.com.portal_noticias.entities.Telefonos;
import ar.com.portal_noticias.services.ITelefonosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class TelefonosServices implements ITelefonosServices {
    @Autowired private ITelefonosDao entityDao;
    public List<Telefonos> getAll() { return entityDao.findAll(Sort.by(Sort.Direction.ASC, "numero")); }
    public Telefonos get(Integer id) { return entityDao.findById(id).orElse(null); }
    @Transactional public void save(Telefonos entity) { entityDao.save(entity); }
    @Transactional public String delete(Telefonos entity) {
        try { entityDao.delete(entity); return null; } catch (Exception e) { return e.getMessage(); }
    }
}
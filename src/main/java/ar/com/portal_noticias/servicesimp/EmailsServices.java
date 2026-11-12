package ar.com.portal_noticias.servicesimp;
import ar.com.portal_noticias.dao.IEmailsDao;
import ar.com.portal_noticias.entities.Emails;
import ar.com.portal_noticias.services.IEmailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class EmailsServices implements IEmailsServices {
    @Autowired private IEmailsDao entityDao;
    public List<Emails> getAll() { return entityDao.findAll(Sort.by(Sort.Direction.ASC, "email")); }
    public Emails get(Integer id) { return entityDao.findById(id).orElse(null); }
    @Transactional public void save(Emails entity) { entityDao.save(entity); }
    @Transactional public String delete(Emails entity) {
        try { entityDao.delete(entity); return null; } catch (Exception e) { return e.getMessage(); }
    }
}
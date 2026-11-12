package ar.com.portal_noticias.servicesimp;
import ar.com.portal_noticias.dao.IRolesDao;
import ar.com.portal_noticias.entities.Roles;
import ar.com.portal_noticias.services.IRolesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class RolesServices implements IRolesServices {
    @Autowired private IRolesDao entityDao;
    public List<Roles> getAll() { return entityDao.findAll(Sort.by(Sort.Direction.ASC, "descripcion")); }
    public Roles get(Integer id) { return entityDao.findById(id).orElse(null); }
    @Transactional public void save(Roles entity) { entityDao.save(entity); }
    @Transactional public String delete(Roles entity) {
        try { entityDao.delete(entity); return null; } catch (Exception e) { return e.getMessage(); }
    }
}
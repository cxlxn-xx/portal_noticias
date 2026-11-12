package ar.com.portal_noticias.servicesimp;
import ar.com.portal_noticias.dao.IUsuariosDao;
import ar.com.portal_noticias.entities.Usuarios;
import ar.com.portal_noticias.services.IUsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class UsuariosServices implements IUsuariosServices {
    @Autowired private IUsuariosDao entityDao;
    public List<Usuarios> getAll() { return entityDao.findAll(Sort.by(Sort.Direction.ASC, "nombre")); }
    public Usuarios get(Integer id) { return entityDao.findById(id).orElse(null); }
    @Transactional public void save(Usuarios entity) { entityDao.save(entity); }
    @Transactional public String delete(Usuarios entity) {
        try { entityDao.delete(entity); return null; } catch (Exception e) { return e.getMessage(); }
    }
}
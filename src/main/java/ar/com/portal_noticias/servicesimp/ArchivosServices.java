package ar.com.portal_noticias.servicesimp;
import ar.com.portal_noticias.dao.IArchivosDao;
import ar.com.portal_noticias.entities.Archivos;
import ar.com.portal_noticias.services.IArchivosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ArchivosServices implements IArchivosServices {
    @Autowired private IArchivosDao entityDao;
    public List<Archivos> getAll() { return entityDao.findAll(Sort.by(Sort.Direction.ASC, "descripcion")); }
    public Archivos get(Integer id) { return entityDao.findById(id).orElse(null); }
    @Transactional public void save(Archivos entity) { entityDao.save(entity); }
    @Transactional public String delete(Archivos entity) {
        try { entityDao.delete(entity); return null; } catch (Exception e) { return e.getMessage(); }
    }
}
package ar.com.portal_noticias.servicesimp;
import ar.com.portal_noticias.dao.ITagsDao;
import ar.com.portal_noticias.entities.Tags;
import ar.com.portal_noticias.services.ITagsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class TagsServices implements ITagsServices {
    @Autowired private ITagsDao entityDao;
    public List<Tags> getAll() { return entityDao.findAll(Sort.by(Sort.Direction.ASC, "descripcion")); }
    public Tags get(Integer id) { return entityDao.findById(id).orElse(null); }
    @Transactional public void save(Tags entity) { entityDao.save(entity); }
    @Transactional public String delete(Tags entity) {
        try { entityDao.delete(entity); return null; } catch (Exception e) { return e.getMessage(); }
    }
}
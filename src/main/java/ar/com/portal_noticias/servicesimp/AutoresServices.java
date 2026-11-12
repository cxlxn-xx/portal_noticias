package ar.com.portal_noticias.servicesimp;

import ar.com.portal_noticias.dao.IAutoresDao;
import ar.com.portal_noticias.entities.Autores;
import ar.com.portal_noticias.services.IAutoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AutoresServices implements IAutoresServices {

    @Autowired
    private IAutoresDao entityDao;

    @Override
    public List<Autores> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "apellido"));
    }

    @Override
    public Autores get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Autores entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(Autores entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
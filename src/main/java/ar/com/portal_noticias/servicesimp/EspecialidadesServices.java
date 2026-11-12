package ar.com.portal_noticias.servicesimp;

import ar.com.portal_noticias.dao.IEspecialidadesDao;
import ar.com.portal_noticias.entities.Especialidades;
import ar.com.portal_noticias.services.IEspecialidadesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EspecialidadesServices implements IEspecialidadesServices {

    @Autowired
    private IEspecialidadesDao entityDao;

    @Override
    public List<Especialidades> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "descripcion"));
    }

    @Override
    public Especialidades get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Especialidades entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(Especialidades entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
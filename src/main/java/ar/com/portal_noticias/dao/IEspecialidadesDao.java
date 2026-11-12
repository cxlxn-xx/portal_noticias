package ar.com.portal_noticias.dao;
import ar.com.portal_noticias.entities.Especialidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IEspecialidadesDao extends JpaRepository<Especialidades, Integer> {}
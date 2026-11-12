package ar.com.portal_noticias.dao;
import ar.com.portal_noticias.entities.Archivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IArchivosDao extends JpaRepository<Archivos, Integer> {}
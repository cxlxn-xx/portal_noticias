package ar.com.portal_noticias.dao;
import ar.com.portal_noticias.entities.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IImagenesDao extends JpaRepository<Imagenes, Integer> {}
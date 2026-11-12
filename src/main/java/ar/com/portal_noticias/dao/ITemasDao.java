package ar.com.portal_noticias.dao;
import ar.com.portal_noticias.entities.Temas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITemasDao extends JpaRepository<Temas, Integer> {}
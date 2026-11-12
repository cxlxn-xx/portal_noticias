package ar.com.portal_noticias.dao;
import ar.com.portal_noticias.entities.Telefonos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ITelefonosDao extends JpaRepository<Telefonos, Integer> {}
package ar.com.portal_noticias.dao;
import ar.com.portal_noticias.entities.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ILinksDao extends JpaRepository<Links, Integer> {}
package ar.com.portal_noticias.dao;

import ar.com.portal_noticias.entities.Publicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublicacionesDao extends JpaRepository<Publicaciones, Integer> {
}
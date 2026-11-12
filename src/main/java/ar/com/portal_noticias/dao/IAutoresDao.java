package ar.com.portal_noticias.dao;

import ar.com.portal_noticias.entities.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutoresDao extends JpaRepository<Autores, Integer> {
    // Busca autores cuyo apellido contenga el texto ingresado
    @Query("select c from Autores c where c.apellido like ?1")
    public List<Autores> findByApellido(String apellido);
}

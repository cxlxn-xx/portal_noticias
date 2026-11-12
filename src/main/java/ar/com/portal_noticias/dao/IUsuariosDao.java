package ar.com.portal_noticias.dao;

import ar.com.portal_noticias.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuariosDao extends JpaRepository<Usuarios, Integer> {

    Optional<Usuarios> findByUsuario(String usuario);
}
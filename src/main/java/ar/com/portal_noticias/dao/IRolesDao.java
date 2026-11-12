package ar.com.portal_noticias.dao;
import ar.com.portal_noticias.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IRolesDao extends JpaRepository<Roles, Integer> {}
package ar.com.portal_noticias.dao;
import ar.com.portal_noticias.entities.Emails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IEmailsDao extends JpaRepository<Emails, Integer> {}
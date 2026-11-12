package ar.com.portal_noticias.dao;
import ar.com.portal_noticias.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ITagsDao extends JpaRepository<Tags, Integer> {}
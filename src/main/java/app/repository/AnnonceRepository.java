package app.repository;
import app.model.Annonce;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
    public List<Annonce> findByAssociationId(Long associationId);
}
package app.repository;

import app.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssociationRepository extends JpaRepository<Association,Long> {
}

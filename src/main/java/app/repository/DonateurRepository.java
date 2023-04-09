package app.repository;

import app.model.Donateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DonateurRepository extends JpaRepository<Donateur,Long> {
}

package app.repository;

import app.model.Message;
import app.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiverOrSenderOrderByTimeDesc(Utilisateur receiver, Utilisateur sender);

}

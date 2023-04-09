package app.service;

import app.model.Message;
import app.model.Utilisateur;
import app.repository.MessageRepository;
import app.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getMessagesByUser(Utilisateur user) {
        return messageRepository.findByReceiverOrSenderOrderByTimeDesc(user, user);
    }
}


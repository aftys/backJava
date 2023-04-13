package app.controller;

import app.model.Admin;
import app.model.Message;
import app.model.Utilisateur;
import app.service.AdminService;
import app.service.MessageService;
import app.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private  MessageService messageService;


    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        Message savedMessage = messageService.saveMessage(message);
        return savedMessage;
    }

    @GetMapping("/{id}")
    public List<Message> getMessagesByUser(@RequestParam("id") Long userId) {
        UtilisateurService userSer = new UtilisateurService();
        Utilisateur user=userSer.getUtilisateurById(userId);
        List<Message> messages = messageService.getMessagesByUser(user);
        return messages;
    }
    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }
}



package app.controller;

import app.model.Admin;
import app.model.Message;
import app.model.Utilisateur;
import app.service.AdminService;
import app.service.MessageService;
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
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Message savedMessage = messageService.saveMessage(message);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Message>> getMessagesByUser(@RequestParam("userId") Long userId) {
        Utilisateur user = new Utilisateur();
        user.setId(userId);
        List<Message> messages = messageService.getMessagesByUser(user);
        return ResponseEntity.ok(messages);
    }
}



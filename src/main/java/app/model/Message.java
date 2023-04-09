package app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;


@Entity
@Table(name = "message")
@NoArgsConstructor
@Data
public class Message{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "senderId")
    private Utilisateur sender;

    @ManyToOne
    @JoinColumn(name = "receiverId")
    private Utilisateur receiver;

    @Column(name = "messageTime")
    private Date mmessageTime;

    @Column(name = "messageText")
    private String mmessageText;





}

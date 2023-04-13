package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.*;


@Entity
@Table(name ="message")
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

    @CreationTimestamp
    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "text")
    private String text;





}

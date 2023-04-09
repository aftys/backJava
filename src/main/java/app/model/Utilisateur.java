package app.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Data

public  class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "sender")
    private List<Message> Message = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Message",
            joinColumns = @JoinColumn(name = "senderId"),
            inverseJoinColumns = @JoinColumn(name = "receiverId"))
    private List<Utilisateur> friends = new ArrayList<>();

    // Other attributes, constructors, getters and setters
}
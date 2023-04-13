package app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Message> Message = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "message",
            joinColumns = @JoinColumn(name = "senderId"),
            inverseJoinColumns = @JoinColumn(name = "receiverId"))
    private List<Message> messages = new ArrayList<>();

}
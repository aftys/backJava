package app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "admin")
@NoArgsConstructor
@Data
public class Admin extends Utilisateur{
    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

}

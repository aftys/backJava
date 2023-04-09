package app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "donateur")
@NoArgsConstructor
@Data
public class Donateur extends Utilisateur{
    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String desription;

    @Column(name = "localisation")
    private String localisation;

    @Column(name = "type")
    private String type;


}

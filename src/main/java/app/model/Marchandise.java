package app.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marchandise")
@NoArgsConstructor
@Data
public class Marchandise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private  String nom;

    @Column(name = "type")
    private  String type;

    @Column(name = "quantiteMax")
    private int quantiteMax;

    @Column(name = "quantiteCourant")
    private int quantiteCourant;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;



}

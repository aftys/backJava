package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;


@Entity
@Table(name = "association")
@NoArgsConstructor
@Data
public class Association extends Utilisateur{
    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String desription;

    @Column(name = "localisation")
    private String localisation;


    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Annonce> annoce = new ArrayList<>();



}

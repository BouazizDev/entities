package tn.codynet.moduleventes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Client extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String reference;
    private int numero;
    private String email;
    private String website;
    private String image;
    private String adresse1;
    private String adresse2;
    private String ville;
    private String pays;
    private String codePostale;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;
    @UpdateTimestamp
    @Column(name = "modified_at")
    protected Instant modifiedAt;
    //COMMANDE CLIENT
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL)
    private List<CommandeClient> commandeClients;

}

package tn.codynet.moduleventes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Fournisseur extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="reference")
    private String reference;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="numero")
    private int numero;
    private String image;
    @Column(name="email")
    private String email;
    private String adresse1;
    private String adresse2;
    private String ville;
    private String pays;
    private String codePostale;
    @JsonBackReference
    @OneToMany
    private List<CommandeFournisseur> commandeFournisseurs;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;
    @UpdateTimestamp
    @Column(name = "modified_at")
    protected Instant modifiedAt;


}

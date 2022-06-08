package tn.codynet.moduleventes.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reference;
    private String nom;
    private String Description;
    private BigDecimal quantite;
    private String image;
    private BigDecimal prixUnitaireHT;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;
    @UpdateTimestamp
    @Column(name = "modified_at")
    protected Instant modifiedAt;
    //TAXE
    @ManyToMany(cascade=CascadeType.MERGE)
    private List<Taxe> taxes;
    //CATEGORIE
    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;
    @JsonIgnore
    @OneToMany
    private List<DeclinaisonArticle> declinaisonArticle;

}

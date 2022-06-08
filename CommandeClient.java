package tn.codynet.moduleventes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class CommandeClient extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reference;
    private BigDecimal montantTaxe;
    private BigDecimal totaleTTC;
    private Date dateCommande;
    private EtatCommande etatCommande;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "commandeClient")

    private List<LigneCommandeClient> ligneCommandeClients;

    // check if commande livree
    public boolean isCommandeLivree(){
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }




}

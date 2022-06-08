package tn.codynet.moduleventes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class Devis extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private long id;
    private String reference;
    private Date dateCommande;
    private BigDecimal montantTaxe;
    private BigDecimal totaleTTC;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;
    @UpdateTimestamp
    @Column(name = "modified_at")
    protected Instant modifiedAt;
    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull
    private Client client;
    @OneToMany(cascade=CascadeType.PERSIST)
    List<LigneDevisClient> ligneDevisClients;

}

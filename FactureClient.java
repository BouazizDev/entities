package tn.codynet.moduleventes.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class FactureClient extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String refrence;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;
    private EtatFacture etatFacture;

    @OneToOne(cascade = CascadeType.MERGE)
    CommandeClient commandeClient;
    public static AtomicInteger idSequence = new AtomicInteger();
    @PrePersist
    void setRef(){
        setRefrence("CODY".concat(String.valueOf(idSequence.incrementAndGet())));
    }

    public boolean isFactureValide(){
        return EtatCommande.VALIDE.equals(this.etatFacture);
    }

}

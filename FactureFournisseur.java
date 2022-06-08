package tn.codynet.moduleventes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class FactureFournisseur extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String refrence;
    private EtatFacture etatFacture;

    @OneToOne(cascade = CascadeType.MERGE)
    CommandeFournisseur commandeFournisseur;
    public static AtomicInteger idSequence = new AtomicInteger();
    @PrePersist
    void setRef(){
        setRefrence("CODY".concat(String.valueOf(idSequence.incrementAndGet())));
    }

    public boolean isFactureValide(){
        return EtatCommande.VALIDE.equals(this.etatFacture);
    }
}

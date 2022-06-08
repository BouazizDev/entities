package tn.codynet.moduleventes.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reglement extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private Date dateEcheance;
    private Date dateReglement;
    private TypeReglement typeReglement;
    @OneToOne(cascade = CascadeType.ALL)
    private FactureClient factureClient;

}

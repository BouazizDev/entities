package tn.codynet.moduleventes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class LigneCommandeClient extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal quantiteCommande;
    private BigDecimal unitaireHT;

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name="idCommande")
    @JsonBackReference
    private CommandeClient commandeClient;

//    public BigDecimal getUnitaireHT(){
//        return article.getPrixUnitaireHT().multiply(quantiteCommande);
//    }
//
//    public BigDecimal getMontantTaxe(){
//        BigDecimal taxAmount = new BigDecimal("0.0");
//        for(Taxe taxe: article.getTaxes()){
//        taxAmount = taxAmount.add(getUnitaireHT().multiply(taxe.getPourcentage()).divide(new BigDecimal("100")));
//    }
//    return taxAmount;}
//


}

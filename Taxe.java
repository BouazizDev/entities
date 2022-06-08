package tn.codynet.moduleventes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@Builder
public class Taxe extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotNull
    private String nom;
    @JsonBackReference
    @ManyToMany
    private List<Article> articles;

    public Taxe(String nom, String description, BigDecimal pourcentage) {
        this.nom = nom;
        this.description = description;
        this.pourcentage = pourcentage;
    }

    @Column(columnDefinition = "longtext")
    private String description;

    @Column(precision = 48, scale = 2,nullable = false)
    @NotNull
    private BigDecimal pourcentage;
}


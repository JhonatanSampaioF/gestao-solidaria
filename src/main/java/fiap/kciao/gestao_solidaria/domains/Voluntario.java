package fiap.kciao.gestao_solidaria.domains;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String alocacao;
    private String capacidade_motora;

    @OneToOne
    private Abrigado abrigado;

    @ManyToMany
    @JoinTable(
            name = "voluntario_habilidade",
            joinColumns = @JoinColumn(name = "voluntario_id"),
            inverseJoinColumns = @JoinColumn(name = "habilidade_id")
    )
    @JsonManagedReference
    private List<Habilidade> habilidades;
}

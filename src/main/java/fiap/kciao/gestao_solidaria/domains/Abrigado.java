package fiap.kciao.gestao_solidaria.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Abrigado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nome;
    private Integer idade;
    private Double altura;
    private Double peso;
    private String cpf;
    private Boolean voluntario;
    private String ferimento;

    @ManyToOne
    private Local local;

    @ManyToMany
    @JoinTable(
            name = "abrigado_doenca",
            joinColumns = @JoinColumn(name = "abrigado_id"),
            inverseJoinColumns = @JoinColumn(name = "doenca_id")
    )
    @JsonManagedReference
    private List<Doenca> doencas;
}

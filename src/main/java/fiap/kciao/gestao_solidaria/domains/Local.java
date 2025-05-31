package fiap.kciao.gestao_solidaria.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "locais")
public class Local {
    @Id
    private String id;
    private String nome;
    private String endereco;
    private Integer capacidade;
    private Integer qtd_abrigados;
}

package fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.local;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LocalCreateRequestDto {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String endereco;
    @NotNull
    private Integer capacidade;
    @NotNull
    private Integer qtd_abrigados;
}

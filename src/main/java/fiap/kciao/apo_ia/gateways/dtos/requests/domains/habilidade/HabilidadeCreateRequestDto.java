package fiap.kciao.apo_ia.gateways.dtos.requests.domains.habilidade;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HabilidadeCreateRequestDto {
    @NotEmpty
    private String nome;
    @NotNull
    private Integer prioridade;
}

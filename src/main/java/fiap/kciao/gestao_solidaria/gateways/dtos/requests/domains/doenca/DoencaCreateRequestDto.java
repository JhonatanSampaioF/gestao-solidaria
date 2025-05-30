package fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.doenca;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DoencaCreateRequestDto {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String gravidade;
}

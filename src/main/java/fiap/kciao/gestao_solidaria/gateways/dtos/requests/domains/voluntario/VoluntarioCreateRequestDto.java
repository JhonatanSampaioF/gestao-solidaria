package fiap.kciao.gestao_solidaria.gateways.dtos.requests.domains.voluntario;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VoluntarioCreateRequestDto {
    @NotEmpty
    private String capacidade_motora;
    @NotNull
    private Integer abrigadoId;
}

package fiap.kciao.apo_ia.gateways.dtos.responses.domains.voluntario;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VoluntarioFullResponseDto {
    private Integer id;
    private String alocacao;
    private String capacidade_motora;
    private Integer abrigadoId;
    private List<Integer> habilidadesId;
}

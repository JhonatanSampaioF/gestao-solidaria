package fiap.kciao.apo_ia.gateways.dtos.responses.domains.habilidade;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HabilidadeFullResponseDto {
    private Integer id;
    private String nome;
    private Integer prioridade;
    private List<Integer> voluntariosId;
}

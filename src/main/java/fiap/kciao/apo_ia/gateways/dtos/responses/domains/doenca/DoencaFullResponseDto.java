package fiap.kciao.apo_ia.gateways.dtos.responses.domains.doenca;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DoencaFullResponseDto {
    private String id;
    private String nome;
    private String gravidade;
    private List<String> abrigadoIds;
}

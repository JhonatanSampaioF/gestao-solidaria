package fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.local;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocalFullResponseDto {
    private Integer id;
    private String nome;
    private String endereco;
    private Integer capacidade;
    private Integer qtd_abrigados;
}

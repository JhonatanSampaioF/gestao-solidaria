package fiap.kciao.gestao_solidaria.gateways.dtos.responses.domains.usuario;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UsuarioFullResponseDto {
    private Integer id;
    private String nome;
    private String email;
}

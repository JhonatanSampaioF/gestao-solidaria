package fiap.kciao.apo_ia.gateways.dtos.responses.domains.abrigado;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AbrigadoFullResponseDto {
    private Integer id;
    private String nome;
    private Integer idade;
    private Double altura;
    private Double peso;
    private String cpf;
    private Boolean voluntario;
    private String ferimento;
    private Integer localId;
    private List<Integer> doencasId;
}

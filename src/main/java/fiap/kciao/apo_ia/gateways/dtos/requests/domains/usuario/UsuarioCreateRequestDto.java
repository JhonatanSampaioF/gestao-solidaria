package fiap.kciao.apo_ia.gateways.dtos.requests.domains.usuario;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UsuarioCreateRequestDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String senha;
}

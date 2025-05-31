package fiap.kciao.gestao_solidaria.usecases.services.query;

import fiap.kciao.gestao_solidaria.domains.Usuario;
import fiap.kciao.gestao_solidaria.gateways.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioQueryService {

    private final UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findByIdOrThrow(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario not found"));
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}

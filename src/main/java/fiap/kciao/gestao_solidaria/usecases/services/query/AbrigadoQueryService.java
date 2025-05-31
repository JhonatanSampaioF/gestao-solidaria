package fiap.kciao.gestao_solidaria.usecases.services.query;

import fiap.kciao.gestao_solidaria.domains.Abrigado;
import fiap.kciao.gestao_solidaria.gateways.repositories.AbrigadoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AbrigadoQueryService {
    private final AbrigadoRepository abrigadoRepository;

    public Abrigado save(Abrigado abrigado) {
        return abrigadoRepository.save(abrigado);
    }

    public Abrigado findByIdOrThrow(Integer id) {
        return abrigadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Abrigado not found"));
    }

    public List<Abrigado> findAll() {
        return abrigadoRepository.findAll();
    }

    public void deleteById(Integer id) {
        abrigadoRepository.deleteById(id);
    }
}

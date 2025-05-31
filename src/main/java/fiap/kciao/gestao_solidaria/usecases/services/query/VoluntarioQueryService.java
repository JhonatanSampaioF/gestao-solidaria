package fiap.kciao.gestao_solidaria.usecases.services.query;

import fiap.kciao.gestao_solidaria.domains.Voluntario;
import fiap.kciao.gestao_solidaria.gateways.repositories.VoluntarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoluntarioQueryService {

    private final VoluntarioRepository voluntarioRepository;

    public Voluntario save(Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    public Voluntario findByIdOrThrow(Integer id) {
        return voluntarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Voluntario not found"));
    }

    public List<Voluntario> findAll() {
        return voluntarioRepository.findAll();
    }

    public void deleteById(Integer id) {
        voluntarioRepository.deleteById(id);
    }
}

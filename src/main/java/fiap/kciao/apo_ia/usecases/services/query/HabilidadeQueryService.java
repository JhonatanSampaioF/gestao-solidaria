package fiap.kciao.apo_ia.usecases.services.query;

import fiap.kciao.apo_ia.domains.Habilidade;
import fiap.kciao.apo_ia.gateways.repositories.HabilidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabilidadeQueryService {

    private final HabilidadeRepository habilidadeRepository;

    public Habilidade save(Habilidade habilidade) {
        return habilidadeRepository.save(habilidade);
    }

    public Habilidade findByIdOrThrow(Integer id) {
        return habilidadeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Habilidade not found"));
    }

    public List<Habilidade> findAll() {
        return habilidadeRepository.findAll();
    }

    public void deleteById(Integer id) {
        habilidadeRepository.deleteById(id);
    }
}

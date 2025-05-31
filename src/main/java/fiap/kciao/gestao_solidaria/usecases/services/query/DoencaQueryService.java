package fiap.kciao.gestao_solidaria.usecases.services.query;

import fiap.kciao.gestao_solidaria.domains.Doenca;
import fiap.kciao.gestao_solidaria.gateways.repositories.DoencaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoencaQueryService {

    private final DoencaRepository doencaRepository;

    public Doenca save(Doenca doenca) {
        return doencaRepository.save(doenca);
    }

    public Doenca findByIdOrThrow(Integer id) {
        return doencaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doenca not found with id"));
    }

    public List<Doenca> findAll() {
        return doencaRepository.findAll();
    }

    public void deleteById(Integer id) {
        doencaRepository.deleteById(id);
    }
}

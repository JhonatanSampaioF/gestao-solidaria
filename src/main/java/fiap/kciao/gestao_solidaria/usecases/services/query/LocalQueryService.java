package fiap.kciao.gestao_solidaria.usecases.services.query;

import fiap.kciao.gestao_solidaria.domains.Local;
import fiap.kciao.gestao_solidaria.gateways.repositories.LocalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalQueryService {

    private final LocalRepository localRepository;

    public Local save(Local local) {
        return localRepository.save(local);
    }

    public Local findByIdOrThrow(Integer id) {
        return localRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Local not found"));
    }

    public List<Local> findAll() {
        return localRepository.findAll();
    }

    public void deleteById(Integer id) {
        localRepository.deleteById(id);
    }
}

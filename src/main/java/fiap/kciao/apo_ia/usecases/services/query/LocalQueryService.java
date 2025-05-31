package fiap.kciao.apo_ia.usecases.services.query;

import fiap.kciao.apo_ia.domains.Local;
import fiap.kciao.apo_ia.gateways.repositories.LocalRepository;
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

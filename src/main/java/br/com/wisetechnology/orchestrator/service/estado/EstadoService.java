package br.com.wisetechnology.orchestrator.service.estado;

import br.com.wisetechnology.orchestrator.model.cep.EstadoDTO;
import br.com.wisetechnology.orchestrator.repository.EstadoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
public class EstadoService {

    @Autowired
    WebClient webClient;

    @Autowired
    EstadoRepository estadoRepository;

    public void processStateService() {
        saveStates(getAllStates());
    }

    private List<EstadoDTO> getAllStates() {
        log.info("[Estado] - Buscando informações de todos os Estados!");
        String url = "https://brasilapi.com.br/api/ibge/uf/v1";

        var response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(EstadoDTO.class)
                .collectList()
                .block();

        assert response != null;
        return response.stream()
                .sorted(Comparator.comparing(EstadoDTO::getSigla))
                .toList();
    }

    private void saveStates(List<EstadoDTO> pStatesDTO) {
        try {
            log.info("[Estado] - Salvando informações de todos os Estados!");
            saveRegions(pStatesDTO);

            pStatesDTO.forEach(states -> estadoRepository.saveState(states));
            log.info("[Estado] - Estados salvos com sucesso!");
        } catch (Exception ex) {
            throw new RuntimeException("Ocorreu um erro ao tentar salvar os Estados! - Detalhes: ", ex);
        }
    }

    private void saveRegions(List<EstadoDTO> pEstadoDTO) {
        try {
            log.info("[Estado] - Salvando informações de todas as Regiões!");
            var regionsDTO = pEstadoDTO.stream()
                    .map(EstadoDTO::getRegiao)
                    .distinct()
                    .toList();

            regionsDTO.forEach(regiaoDTO -> estadoRepository.saveRegion(regiaoDTO));
            log.info("[Estado] - Regiões salvas com sucesso!");
        } catch (Exception ex) {
            throw new RuntimeException("Ocorreu um erro ao tentar salvar as Regiões! - Detalhes: ", ex);
        }
    }
}
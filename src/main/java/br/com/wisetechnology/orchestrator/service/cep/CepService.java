package br.com.wisetechnology.orchestrator.service.cep;

import br.com.wisetechnology.orchestrator.model.cep.CepDTO;
import br.com.wisetechnology.orchestrator.model.cep.response.CepResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class CepService {

    @Autowired
    WebClient webClient;

    @Autowired
    ModelMapper modelMapper;

    public CepResponseDTO getCep(String pCep) {
        log.info("[CEP] - Buscando informações do CEP: {}", pCep);
        String url = String.format("https://brasilapi.com.br/api/cep/v2/%s", pCep);

        var response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(CepDTO.class)
                .block();

        assert response != null;
        return convertCepResponse(response);
    }

    private CepResponseDTO convertCepResponse(CepDTO pCepDTO) {
        var cepResponseDTO = modelMapper.map(pCepDTO, CepResponseDTO.class);

        cepResponseDTO.setLongitude(pCepDTO.getLocationDTO().getCoordinates().getLongitude());
        cepResponseDTO.setLatitude(pCepDTO.getLocationDTO().getCoordinates().getLatitude());

        return cepResponseDTO;
    }
}
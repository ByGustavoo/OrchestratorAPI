package br.com.wisetechnology.orchestrator.controller;

import br.com.wisetechnology.orchestrator.model.cep.request.CepRequestDTO;
import br.com.wisetechnology.orchestrator.model.cep.response.CepResponseDTO;
import br.com.wisetechnology.orchestrator.service.cep.CepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cep")
public class CepController {

    @Autowired
    CepService cepService;

    @PostMapping
    public ResponseEntity<CepResponseDTO> getCep(@RequestBody @Valid CepRequestDTO pCepRequestDTO) {
        return ResponseEntity.ok(cepService.getCep(pCepRequestDTO.getCep()));
    }
}
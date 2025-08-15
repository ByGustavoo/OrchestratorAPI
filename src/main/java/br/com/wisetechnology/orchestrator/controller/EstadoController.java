package br.com.wisetechnology.orchestrator.controller;

import br.com.wisetechnology.orchestrator.model.cep.EstadoDTO;
import br.com.wisetechnology.orchestrator.service.estado.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/states")
public class EstadoController {

    @Autowired
    EstadoService estadoService;

//    @GetMapping
//    public ResponseEntity<List<EstadoDTO>> getAllStates() {
//        return ResponseEntity.ok(estadoService.getAllStates());
//    }
}
package br.com.wisetechnology.orchestrator.service;

import br.com.wisetechnology.orchestrator.service.estado.EstadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InitializationService {

    @Autowired
    EstadoService estadoService;

    @Scheduled(initialDelay = 60000)
    public void setUp() {
        log.info("Iniciando o serviço de Estados e Regiões!");
        estadoService.processStateService();
    }
}
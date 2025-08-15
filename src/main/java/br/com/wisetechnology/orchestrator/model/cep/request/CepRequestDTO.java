package br.com.wisetechnology.orchestrator.model.cep.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CepRequestDTO {

    @NotNull(message = "CEP é obrigatório")
    @Size(min = 8, max = 8, message = "CEP deve conter exatamente 8 dígitos")
    private String cep;

}
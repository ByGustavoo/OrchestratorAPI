package br.com.wisetechnology.orchestrator.model.cep;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CepDTO {

    private String cep;

    @JsonProperty("state")
    private String estado;

    @JsonProperty("city")
    private String cidade;

    @JsonProperty("neighborhood")
    private String bairro;

    @JsonProperty("street")
    private String rua;

    @JsonProperty("service")
    private String servico;

    @JsonProperty("location")
    private LocationDTO locationDTO;

}
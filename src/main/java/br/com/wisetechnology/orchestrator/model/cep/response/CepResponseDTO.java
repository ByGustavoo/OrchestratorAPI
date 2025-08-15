package br.com.wisetechnology.orchestrator.model.cep.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({ "cep", "state", "city", "neighborhood", "street", "longitude", "latitude" })
public class CepResponseDTO {

    private String cep;

    @JsonProperty("state")
    private String estado;

    @JsonProperty("city")
    private String cidade;

    @JsonProperty("neighborhood")
    private String bairro;

    @JsonProperty("street")
    private String rua;

    private String longitude;

    private String latitude;

}
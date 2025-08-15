package br.com.wisetechnology.orchestrator.model.cep;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationDTO {

    private String type;

    private CoordinatesDTO coordinates;

}
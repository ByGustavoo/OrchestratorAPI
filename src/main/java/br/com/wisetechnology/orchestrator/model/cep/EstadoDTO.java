package br.com.wisetechnology.orchestrator.model.cep;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EstadoDTO {

    @Max(2)
    @NotNull
    private String sigla;

    @Max(20)
    @NotNull
    private String nome;

    @NotNull
    private RegiaoDTO regiao;

}
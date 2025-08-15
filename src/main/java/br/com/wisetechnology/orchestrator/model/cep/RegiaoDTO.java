package br.com.wisetechnology.orchestrator.model.cep;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegiaoDTO {

    @NotNull
    private String sigla;

    @NotNull
    private String nome;

}
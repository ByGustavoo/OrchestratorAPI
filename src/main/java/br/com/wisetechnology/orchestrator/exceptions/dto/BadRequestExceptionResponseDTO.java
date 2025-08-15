package br.com.wisetechnology.orchestrator.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BadRequestExceptionResponseDTO {

    private String campo;
    private String mensagem;

    public BadRequestExceptionResponseDTO(FieldError fieldError) {
        this.campo = fieldError.getField();
        this.mensagem = fieldError.getDefaultMessage();
    }
}
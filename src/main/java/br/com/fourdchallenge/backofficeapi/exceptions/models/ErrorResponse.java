package br.com.fourdchallenge.backofficeapi.exceptions.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private Long timestamp;
    private String message;
}


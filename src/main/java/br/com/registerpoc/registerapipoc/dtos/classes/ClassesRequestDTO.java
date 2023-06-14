package br.com.registerpoc.registerapipoc.dtos.classes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassesRequestDTO {

    private String title;
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate predictedDate;
}

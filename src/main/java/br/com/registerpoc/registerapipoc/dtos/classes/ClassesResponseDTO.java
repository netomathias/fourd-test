package br.com.registerpoc.registerapipoc.dtos.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassesResponseDTO {

    private String id;
    private String title;
    private String description;
    private LocalDate predictedDate;
}

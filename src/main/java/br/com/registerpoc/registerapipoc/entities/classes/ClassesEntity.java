package br.com.registerpoc.registerapipoc.entities.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("classes")
public class ClassesEntity {

    @Id
    private String id;
    private String title;
    private String description;
    private LocalDate predictedDate;
    private String userEmail;
}

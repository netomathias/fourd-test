package br.com.fourdchallenge.backofficeapi.entities.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("classes")
public class ClassesEntity implements Serializable {

    @Id
    private String id;
    private String title;
    private String description;
    private LocalDate predictedDate;
    private String userEmail;
}

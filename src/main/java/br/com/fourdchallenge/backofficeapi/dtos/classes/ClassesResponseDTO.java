package br.com.fourdchallenge.backofficeapi.dtos.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
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

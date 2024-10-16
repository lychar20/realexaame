package fr.charly.mampuyaExam.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoundDTO {

    @NotBlank
    private String gameId;

}

package fr.charly.mampuyaExam.DTO;

import fr.charly.mampuyaExam.entity.Round;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameDTO {

    @NotBlank
    private Integer maximumTime;

    @NotBlank
    private Boolean hasMove;

    @NotBlank
    private Boolean hasPan;

    @NotBlank
    private Boolean hasZoom;

    @NotBlank
    private Long mapId;

    @NotBlank
    private List<Round>  round;

    @NotBlank
    private String userId;

}

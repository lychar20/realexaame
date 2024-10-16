package fr.charly.mampuyaExam.DTO;

import fr.charly.mampuyaExam.entity.Round;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    private Long roundId;

}

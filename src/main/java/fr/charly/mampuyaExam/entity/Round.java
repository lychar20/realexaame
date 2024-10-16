package fr.charly.mampuyaExam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.mampuyaExam.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.RoundShow.class)
    private Long id;

    @JsonView({JsonViews.GameList.class, JsonViews.RoundShow.class})
    private Integer points = null;

    @JsonView(JsonViews.RoundShow.class)
    private  Integer time = null;

    @JsonView(JsonViews.RoundShow.class)
    private Long distance = null;

    @JsonView(JsonViews.RoundShow.class)
    private LocalDateTime createdAt;

    @ManyToOne
    private Game game;

    @ManyToOne
    private Coordinate origin;

    @ManyToOne
    private Coordinate selected;

}
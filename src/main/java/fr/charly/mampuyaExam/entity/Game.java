package fr.charly.mampuyaExam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.mampuyaExam.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(JsonViews.GameList.class)
    private String id;

    @JsonView(JsonViews.GameShow.class)
    private Integer maximumTime;

    @JsonView(JsonViews.GameShow.class)
    private Boolean hasMove;

    @JsonView(JsonViews.GameShow.class)
    private Boolean hasPan;

    private Boolean hasZoom;

    @JsonView(JsonViews.GameList.class)
    private LocalDateTime createdAt;

    @JsonView(JsonViews.GameList.class)
    private Integer nbRounds;

    @ManyToOne
    private Map map ;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "game")
    private List<Round> rounds = new ArrayList<>();


    public int getTotalPoints() {
        return rounds.size();
    }

}
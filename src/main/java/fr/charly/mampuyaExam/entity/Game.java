package fr.charly.mampuyaExam.entity;

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
    private String id;

    private Integer maximumTime;

    private Boolean hasMove;

    private Boolean hasPan;

    private Boolean hasZoom;

    private LocalDateTime createdAt;

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
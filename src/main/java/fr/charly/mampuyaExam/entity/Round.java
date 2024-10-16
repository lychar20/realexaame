package fr.charly.mampuyaExam.entity;

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
    private Long id;

    private Integer points = null;

    private  Integer time = null;

    private Long distance = null;

    private LocalDateTime createdAt;

    @ManyToOne
    private Game game;

    @ManyToOne
    private Coordinate origin;

    @ManyToOne
    private Coordinate selected;

}
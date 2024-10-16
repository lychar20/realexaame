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
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(JsonViews.MapMinimalView.class)
    @Column(nullable = false)
    private String name;

    @JsonView(JsonViews.MapMinimalView.class)
    private LocalDateTime createdAt;

//    @OneToMany(mappedBy = "map")
//    private List<Game> games = new ArrayList<>();

}
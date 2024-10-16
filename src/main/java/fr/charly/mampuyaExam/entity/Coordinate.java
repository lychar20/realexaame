package fr.charly.mampuyaExam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.mampuyaExam.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.CoordinateShow.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViews.CoordinateShow.class)
    private String latitude;

    @Column(nullable = false)
    @JsonView(JsonViews.CoordinateShow.class)
    private String longitude;



}
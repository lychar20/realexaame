package fr.charly.mampuyaExam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.mampuyaExam.DTO.GameDTO;
import fr.charly.mampuyaExam.DTO.MapDTO;
import fr.charly.mampuyaExam.entity.Game;
import fr.charly.mampuyaExam.entity.Map;
import fr.charly.mampuyaExam.json_views.JsonViews;
import fr.charly.mampuyaExam.service.GameService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@AllArgsConstructor
public class GameRestController {

    private GameService gameService;

    @GetMapping
    @JsonView(JsonViews.MapMinimalView.class)
    public List<Game> list() {
        return gameService.list();
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.MapMinimalView.class)
    public Game show(@PathVariable String id) {
        return gameService.findOneById(id);
    }



    @PostMapping
    @JsonView(JsonViews.MapMinimalView.class)
    public Game create(@Valid @RequestBody GameDTO dto) {
        return gameService.create(dto);
    }



}

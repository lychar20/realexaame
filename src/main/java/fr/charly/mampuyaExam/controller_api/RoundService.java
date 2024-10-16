package fr.charly.mampuyaExam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.mampuyaExam.DTO.MapDTO;
import fr.charly.mampuyaExam.DTO.RoundDTO;
import fr.charly.mampuyaExam.entity.Map;
import fr.charly.mampuyaExam.entity.Round;
import fr.charly.mampuyaExam.json_views.JsonViews;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/round")
@AllArgsConstructor
public class RoundService {

    private RoundService roundService;

//    @GetMapping
//    @JsonView(JsonViews.MapMinimalView.class)
//    public List<Round> list() {
//        return roundService.list();
//    }
//
//
//    @PostMapping
//    @JsonView(JsonViews.RoundMinimalView.class)
//    public Round create(@Valid @RequestBody RoundDTO dto) {
//        return roundService.create(dto);
//    }



}

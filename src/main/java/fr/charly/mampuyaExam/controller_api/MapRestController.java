package fr.charly.mampuyaExam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.mampuyaExam.DTO.MapDTO;
import fr.charly.mampuyaExam.entity.Map;
import fr.charly.mampuyaExam.json_views.JsonViews;
import fr.charly.mampuyaExam.service.MapService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/map")
@AllArgsConstructor
public class MapRestController {

    private MapService mapService;

    @GetMapping
    @JsonView(JsonViews.MapMinimalView.class)
    public List<Map> list() {
        return mapService.list();
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.MapMinimalView.class)
    public Map show(@PathVariable Long id) {
        return mapService.findOneById(id);
    }



    @PostMapping
    @JsonView(JsonViews.MapMinimalView.class)
    public Map create(@Valid @RequestBody MapDTO dto) {
        return mapService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.MapMinimalView.class)
    public Map update(@Valid @RequestBody MapDTO dto, @PathVariable Long id ){
        return mapService.update(dto, id);
    }

}

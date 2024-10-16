package fr.charly.mampuyaExam.service;

import fr.charly.mampuyaExam.DTO.MapDTO;
import fr.charly.mampuyaExam.entity.Map;
import fr.charly.mampuyaExam.repository.MapRepository;
import fr.charly.mampuyaExam.service.interfaces.ServiceListInterface;
import fr.charly.mampuyaExam.service.interfaces.ServiceUpdateInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MapService implements ServiceListInterface<Map, Long, MapDTO, MapDTO>, ServiceUpdateInterface<Map, Long, MapDTO> {

    private MapRepository mapRepository;

    @Override
    public List<Map> list() {
        return mapRepository.findAll();
    }

    @Override
    public Map create(MapDTO mapDTO) {
        Map map = new Map();
        map.setName(mapDTO.getName());
        return mapRepository.saveAndFlush(map);
    }

    @Override
    public Map findOneById(Long id) {
        return mapRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Map update(MapDTO o, Long id) {
        Map map = findOneById(id);
        map.setName(o.getName());
        return mapRepository.saveAndFlush(map);
    }
}

package fr.charly.mampuyaExam.service;

import fr.charly.mampuyaExam.DTO.GameDTO;
import fr.charly.mampuyaExam.entity.Game;
import fr.charly.mampuyaExam.entity.Round;
import fr.charly.mampuyaExam.repository.GameRepository;
import fr.charly.mampuyaExam.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService implements ServiceListInterface<Game, String, GameDTO, GameDTO> {

    private GameRepository gameRepository;
    private MapService mapService;
    private UserService userService;

    @Override
    public List<Game> list() {
        return gameRepository.findAll();
    }

    @Override
    public Game create(GameDTO gameDTO) {
        Game game = new Game();
        game.setHasPan(gameDTO.getHasPan());
        game.setHasZoom(gameDTO.getHasZoom());
        game.setHasMove(gameDTO.getHasMove());
        game.setMaximumTime(gameDTO.getMaximumTime());
        game.setMap(mapService.findOneById(gameDTO.getMapId()));
        game.setUser(userService.findOneById(gameDTO.getUserId()));
        game.setRounds(gameDTO.getRound());
        return gameRepository.saveAndFlush(game);
    }

    @Override
    public Game findOneById(String id) {
        return gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

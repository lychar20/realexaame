package fr.charly.mampuyaExam.service;

import fr.charly.mampuyaExam.DTO.RoundDTO;
import fr.charly.mampuyaExam.entity.Round;
import fr.charly.mampuyaExam.repository.RoundRepository;
import fr.charly.mampuyaExam.service.interfaces.ServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoundService implements ServiceInterface <Round, Long, RoundDTO> {

    private RoundRepository roundRepository;
    private GameService gameService;


    @Override
    public Round create(RoundDTO roundDTO) {
        Round round = new Round();
        round.setGame(gameService.findOneById(roundDTO.getGameId()));
        return roundRepository.saveAndFlush(round);
    }

    @Override
    public Round findOneById(Long id) {
        return roundRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

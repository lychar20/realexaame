package fr.charly.mampuyaExam.repository;

import fr.charly.mampuyaExam.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {
}
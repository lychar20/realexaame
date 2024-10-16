package fr.charly.mampuyaExam.repository;

import fr.charly.mampuyaExam.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
}
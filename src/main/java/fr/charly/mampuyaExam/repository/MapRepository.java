package fr.charly.mampuyaExam.repository;

import fr.charly.mampuyaExam.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MapRepository extends JpaRepository<Map, Long> {
}
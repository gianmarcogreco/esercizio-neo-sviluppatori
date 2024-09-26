package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Prenotazione;
import entity.PrenotazioneId;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, PrenotazioneId> {

}

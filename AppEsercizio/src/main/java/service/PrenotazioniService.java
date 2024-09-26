package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.Prenotazione;
import entity.PrenotazioneId;
import repository.PrenotazioneRepository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class PrenotazioniService {

    private final PrenotazioneRepository prenotazioneRepository;

    @Autowired
    public PrenotazioniService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    /**
     * Recupera tutte le prenotazioni.
     * @return lista di prenotazioni.
     */
    @Transactional(readOnly = true)
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    /**
     * Recupera una singola prenotazione tramite l'ID.
     * @param prenotazioneId id composto della prenotazione.
     * @return prenotazione se trovata.
     */
    @Transactional(readOnly = true)
    public Optional<Prenotazione> getPrenotazioneById(PrenotazioneId prenotazioneId) {
        return prenotazioneRepository.findById(prenotazioneId);
    }

    /**
     * Crea una nuova prenotazione.
     * @param prenotazione l'oggetto prenotazione da salvare.
     * @return la prenotazione salvata.
     */
    @Transactional
    public Prenotazione createPrenotazione(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    /**
     * Aggiorna una prenotazione esistente.
     * @param prenotazioneId id composto della prenotazione.
     * @param prenotazione dettagli aggiornati della prenotazione.
     * @return la prenotazione aggiornata.
     * @throws EntityNotFoundException se la prenotazione non esiste.
     */
    @Transactional
    public Prenotazione updatePrenotazione(PrenotazioneId prenotazioneId, Prenotazione prenotazione) {
        Optional<Prenotazione> prenotazioneExistente = prenotazioneRepository.findById(prenotazioneId);
        
        if (prenotazioneExistente.isPresent()) {
            Prenotazione existingPrenotazione = prenotazioneExistente.get();
            // Aggiorna i campi della prenotazione esistente
            existingPrenotazione.setPrenotante(prenotazione.getPrenotante());
            existingPrenotazione.setGelato(prenotazione.getGelato());
            // Altri campi da aggiornare se necessario
            return prenotazioneRepository.save(existingPrenotazione);
        } else {
            throw new EntityNotFoundException("Prenotazione non trovata con ID: " + prenotazioneId);
        }
    }

    /**
     * Elimina una prenotazione esistente.
     * @param prenotazioneId id composto della prenotazione da eliminare.
     * @throws EntityNotFoundException se la prenotazione non esiste.
     */
    @Transactional
    public void deletePrenotazione(PrenotazioneId prenotazioneId) {
        if (prenotazioneRepository.existsById(prenotazioneId)) {
            prenotazioneRepository.deleteById(prenotazioneId);
        } else {
            throw new EntityNotFoundException("Prenotazione non trovata con ID: " + prenotazioneId);
        }
    }
}

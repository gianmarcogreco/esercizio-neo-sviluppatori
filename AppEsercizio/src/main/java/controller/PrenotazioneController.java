package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app1.api.ApiApi;

import entity.Prenotazione;
import repository.PrenotazioneRepository;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController implements ApiApi{
	@Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @GetMapping
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    @PostMapping
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }
	

}

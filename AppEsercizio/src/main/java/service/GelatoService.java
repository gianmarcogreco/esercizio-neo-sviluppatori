package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Gelato;
import repository.GelatoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GelatoService {
	
	@Autowired
	private GelatoRepository gelatoRepository;

	//metodo per salvare un gelato
	
	public Gelato saveGelato(Gelato gelato) {
		return gelatoRepository.save(gelato);
	}
	
	//metodo per recuperare tutti i gelati
	
	public List<Gelato> getAllGelati(){
		return gelatoRepository.findAll();
	}
	
	//metodo per recuperare gelato per id 
	
	public Optional<Gelato> getGelatoById(Integer id){
		return gelatoRepository.findById(id);
	}
	
	//Metodo per aggiornare un gelato
	
	public Gelato updateGelato(Gelato gelato) {
		if (gelatoRepository.existsById(gelato.getId())) {
			return gelatoRepository.save(gelato);
		}else {
			return null;
		}
	}
	
	//Metodo per eliminare un gelato
	
	public void deleteGelato(Integer id) {
		gelatoRepository.deleteById(id);
	}
}

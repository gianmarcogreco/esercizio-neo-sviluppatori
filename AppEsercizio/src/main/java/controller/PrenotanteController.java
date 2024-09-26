package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app1.api.ApiApi;

import service.PrenotanteService;
import entity.Prenotante;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/prenotanti")
public class PrenotanteController implements ApiApi {

	@Autowired
	private PrenotanteService prenotanteService;

	//implemento GET
	@Override
	@GetMapping
	public ResponseEntity<List<Prenotante>> apiPrenotanteGet(){
		List<Prenotante> prenotante = prenotanteService.getAllPrenotanti();
		return new ResponseEntity<>(prenotante, HttpStatus.OK);

	}

	//implemento GET by Id
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Prenotante> apiPrenotanteIdPrenotanteGet(@PathVariable Integer id) {
		Optional<Prenotante> prenotante = prenotanteService.getPrenotanteById(id);
		return prenotante.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}
	
	//implemento Post
	@PostMapping
	public ResponseEntity<Prenotante> apiPrenotantePost(
			 @Parameter(name = "Prenotante", description = "", required = true) @Valid @RequestBody Prenotante prenotante
			 ){
		Prenotante savedPrenotante = prenotanteService.savePrenotante(prenotante);
		return new ResponseEntity<>(savedPrenotante, HttpStatus.CREATED);
	}
	
	//implemento Put by id
	@PutMapping("/{id}")
	public ResponseEntity<Prenotante> apiPrenotanteIdPrenotantePut(
			@PathVariable ("id") Integer idPrenotante, @RequestBody Prenotante prenotante
			){
		prenotante.setIdPrenotante(idPrenotante);
		Prenotante updatedPrenotante = prenotanteService.updatePrenotante(prenotante);
		return updatedPrenotante != null ?
				new ResponseEntity<> (updatedPrenotante, HttpStatus.OK) :
					new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	//implemento Delete by Id
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Prenotante> apiPrenotanteIdPrenotanteDelete(
			@PathVariable("id") Integer idPrenotante){
		prenotanteService.deletePrenotante(idPrenotante);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}

package entity;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Prenotazione
 */

@Entity
@Table(name ="prenotazione")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-25T17:39:20.902187800+02:00[Europe/Rome]", comments = "Generator version: 7.8.0")
public class Prenotazione {

	@EmbeddedId
	private PrenotazioneId id;

	@ManyToOne
	@MapsId("prenotanteId") 
	@JoinColumn(name = "id_prenotante")
	private Prenotante prenotante;

	@ManyToOne
	@MapsId("gelatoId")
	@JoinColumn(name = "id_gelato")
	private Gelato gelato;


	public Prenotazione() {
		super();
	}


	public PrenotazioneId getId() {
		return id;
	}


	public void setId(PrenotazioneId id) {
		this.id = id;
	}


	public Prenotante getPrenotante() {
		return prenotante;
	}


	public void setPrenotante(Prenotante prenotante) {
		this.prenotante = prenotante;
	}


	public Gelato getGelato() {
		return gelato;
	}


	public void setGelato(Gelato gelato) {
		this.gelato = gelato;
	}


}


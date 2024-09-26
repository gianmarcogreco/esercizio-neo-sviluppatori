package com.app1.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Prenotazione
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-26T11:39:40.202204400+02:00[Europe/Rome]", comments = "Generator version: 7.8.0")
public class Prenotazione {

  private Integer idPrenotante;

  private Integer idGelato;

  public Prenotazione() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Prenotazione(Integer idPrenotante, Integer idGelato) {
    this.idPrenotante = idPrenotante;
    this.idGelato = idGelato;
  }

  public Prenotazione idPrenotante(Integer idPrenotante) {
    this.idPrenotante = idPrenotante;
    return this;
  }

  /**
   * ID del prenotante
   * @return idPrenotante
   */
  @NotNull 
  @Schema(name = "id_prenotante", description = "ID del prenotante", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id_prenotante")
  public Integer getIdPrenotante() {
    return idPrenotante;
  }

  public void setIdPrenotante(Integer idPrenotante) {
    this.idPrenotante = idPrenotante;
  }

  public Prenotazione idGelato(Integer idGelato) {
    this.idGelato = idGelato;
    return this;
  }

  /**
   * ID del gelato
   * @return idGelato
   */
  @NotNull 
  @Schema(name = "id_gelato", description = "ID del gelato", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id_gelato")
  public Integer getIdGelato() {
    return idGelato;
  }

  public void setIdGelato(Integer idGelato) {
    this.idGelato = idGelato;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Prenotazione prenotazione = (Prenotazione) o;
    return Objects.equals(this.idPrenotante, prenotazione.idPrenotante) &&
        Objects.equals(this.idGelato, prenotazione.idGelato);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPrenotante, idGelato);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Prenotazione {\n");
    sb.append("    idPrenotante: ").append(toIndentedString(idPrenotante)).append("\n");
    sb.append("    idGelato: ").append(toIndentedString(idGelato)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


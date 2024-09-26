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
 * Prenotante
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-26T11:39:40.202204400+02:00[Europe/Rome]", comments = "Generator version: 7.8.0")
public class Prenotante {

  private Integer idPrenotante;

  private String nome;

  public Prenotante() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Prenotante(Integer idPrenotante, String nome) {
    this.idPrenotante = idPrenotante;
    this.nome = nome;
  }

  public Prenotante idPrenotante(Integer idPrenotante) {
    this.idPrenotante = idPrenotante;
    return this;
  }

  /**
   * ID prenotante
   * @return idPrenotante
   */
  @NotNull 
  @Schema(name = "id_prenotante", description = "ID prenotante", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id_prenotante")
  public Integer getIdPrenotante() {
    return idPrenotante;
  }

  public void setIdPrenotante(Integer idPrenotante) {
    this.idPrenotante = idPrenotante;
  }

  public Prenotante nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome del prenotante
   * @return nome
   */
  @NotNull 
  @Schema(name = "nome", description = "Nome del prenotante", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Prenotante prenotante = (Prenotante) o;
    return Objects.equals(this.idPrenotante, prenotante.idPrenotante) &&
        Objects.equals(this.nome, prenotante.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPrenotante, nome);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Prenotante {\n");
    sb.append("    idPrenotante: ").append(toIndentedString(idPrenotante)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
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


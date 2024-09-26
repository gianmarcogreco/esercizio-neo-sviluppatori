package entity;

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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Gelato
 */

@Entity
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-25T17:39:20.902187800+02:00[Europe/Rome]", comments = "Generator version: 7.8.0")
public class Gelato {

  @Column(name="id")
  @Id
  private Integer id;

  @Column(name="nome")
  private String nome;

  @Column(name="descrizione")
  private String descrizione;
  
  @ManyToMany(mappedBy= "gelati")
  Set<Prenotante> prenotanti = new HashSet<>();

  public Gelato() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Gelato(Integer id, String nome, String descrizione) {
    this.id = id;
    this.nome = nome;
    this.descrizione = descrizione;
  }

  public Gelato id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * ID univoco del gelato
   * @return id
   */
  @NotNull 
  @Schema(name = "id", description = "ID univoco del gelato", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Gelato nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome del gusto di gelato
   * @return nome
   */
  @NotNull 
  @Schema(name = "nome", description = "Nome del gusto di gelato", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Gelato descrizione(String descrizione) {
    this.descrizione = descrizione;
    return this;
  }

  /**
   * Descrizione del gelato
   * @return descrizione
   */
  @NotNull 
  @Schema(name = "descrizione", example = "Gelato al cioccolato realizzato con ingredienti di alta qualità.", description = "Descrizione del gelato", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("descrizione")
  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Gelato gelato = (Gelato) o;
    return Objects.equals(this.id, gelato.id) &&
        Objects.equals(this.nome, gelato.nome) &&
        Objects.equals(this.descrizione, gelato.descrizione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, descrizione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Gelato {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
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


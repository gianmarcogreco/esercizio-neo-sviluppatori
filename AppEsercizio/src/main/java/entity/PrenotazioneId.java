package entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public class PrenotazioneId implements Serializable{
	
	private Integer prenotanteId;
	private Integer gelatoId;
	
	 public PrenotazioneId() {}

	    public PrenotazioneId(Integer prenotanteId, Integer gelatoId) {
	        this.prenotanteId = prenotanteId;
	        this.gelatoId = gelatoId;
	    }

		public Integer getPrenotanteId() {
			return prenotanteId;
		}

		public void setPrenotanteId(Integer prenotanteId) {
			this.prenotanteId = prenotanteId;
		}

		public Integer getGelatoId() {
			return gelatoId;
		}

		public void setGelatoId(Integer gelatoId) {
			this.gelatoId = gelatoId;
		}
	    
		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof PrenotazioneId)) return false;
	        PrenotazioneId that = (PrenotazioneId) o;
	        return Objects.equals(prenotanteId, that.prenotanteId) && Objects.equals(gelatoId, that.gelatoId);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(prenotanteId, gelatoId);
	    }
	    
	

}

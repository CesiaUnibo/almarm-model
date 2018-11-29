/*
 * AlmaRM Model - Java represenation of the model AlmaRM is built on.
 * Copyright (C) 2018  ALMA MATER STUDIORUM - Università di Bologna
 *
 * This file is part of AlmaRM Model.
 *
 * AlmaRM Model is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * AlmaRM Model is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with AlmaRM Model.  If not, see <https://www.gnu.org/licenses/>.
 */
package it.unibo.almarm.model.attori.studenti;

import java.util.HashSet;
import java.util.Set;

import it.unibo.almarm.model.attori.Dipartimento;
import it.unibo.almarm.model.attori.Scuola;
import it.unibo.almarm.model.attori.Usd;
import it.unibo.almarm.model.attori.Vicepresidenza;

public class CorsoView  implements java.io.Serializable, Comparable<CorsoView>{

	private static final long serialVersionUID = 1L;

	private String id;
	private String descrizione;
	private String idFacolta;
	private String descrizioneFacolta;
	private Long idTipoCdsOfferta;
	private String siglaTipoCds;
	private Scuola scuolaCapofila;
	private Vicepresidenza vicepresidenza;
	private Dipartimento dipartimento;
	private Usd usd;
	private String tipoCorso;
	private Integer durata;
	private Set<VicepresidenzaDot> vicepresidenzeDot;
	private Set<CorsoScuola> corsoScuole = new HashSet<CorsoScuola>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIdFacolta() {
		return idFacolta;
	}

	public void setIdFacolta(String idFacolta) {
		this.idFacolta = idFacolta;
	}

	public String getDescrizioneFacolta() {
		return descrizioneFacolta;
	}

	public void setDescrizioneFacolta(String descrizioneFacolta) {
		this.descrizioneFacolta = descrizioneFacolta;
	}

	public Long getIdTipoCdsOfferta() {
		return idTipoCdsOfferta;
	}

	public void setIdTipoCdsOfferta(Long idTipoCdsOfferta) {
		this.idTipoCdsOfferta = idTipoCdsOfferta;
	}

	public String getSiglaTipoCds() {
		return siglaTipoCds;
	}

	public void setSiglaTipoCds(String siglaTipoCds) {
		this.siglaTipoCds = siglaTipoCds;
	}
	
	public Scuola getScuolaCapofila() {
		return scuolaCapofila;
	}

	public void setScuolaCapofila(Scuola scuolaCapofila) {
		this.scuolaCapofila = scuolaCapofila;
	}
	
	public String getDescrizioneScuola() {
		return scuolaCapofila != null ?  scuolaCapofila.getDescrizione() : "";
	}

	public Vicepresidenza getVicepresidenza() {
		return vicepresidenza;
	}

	public void setVicepresidenza(Vicepresidenza vicepresidenza) {
		this.vicepresidenza = vicepresidenza;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public Usd getUsd() {
		return usd;
	}

	public void setUsd(Usd usd) {
		this.usd = usd;
	}

	public Set<CorsoScuola> getCorsoScuole() {
		return corsoScuole;
	}

	public void setCorsoScuole(Set<CorsoScuola> corsoScuole) {
		this.corsoScuole = corsoScuole;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CorsoView))
			return false;
		CorsoView other = (CorsoView) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public int compareTo(CorsoView o) {
		if (descrizione != null)
		{
			if (descrizione.compareTo(o.getDescrizione()) == 0)
				return id.compareTo(o.getId());
			return descrizione.compareTo(o.getDescrizione());
		}
		return 0;
	}

	public Set<VicepresidenzaDot> getVicepresidenzeDot() {
		return vicepresidenzeDot;
	}

	public void setVicepresidenzeDot(Set<VicepresidenzaDot> vicepresidenzeDot) {
		this.vicepresidenzeDot = vicepresidenzeDot;
	}

	public String getTipoCorso() {
		return tipoCorso;
	}

	public void setTipoCorso(String tipoCorso) {
		this.tipoCorso = tipoCorso;
	}

	public Integer getDurata() {
		return durata;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	}
		
}

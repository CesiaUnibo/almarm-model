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
package it.unibo.almarm.model.flussiscambio;

import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Campus;
import it.unibo.almarm.model.attori.Facolta;

public class ScambioEsecuzione	implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private EsecuzioneAccordo esecuzioneAccordo;
	private ScambioAccordo scambioAccordo;
	private SottoProgramma sottoProgramma;
	private Target target;
	private TipoAttivita tipoAttivita;
	private Campus campus;
	private FlussoScambioEsecuzione flussoScambioEsecuzioneIn;
	private FlussoScambioEsecuzione flussoScambioEsecuzioneOut;
	private Facolta facolta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public EsecuzioneAccordo getEsecuzioneAccordo() {
		return esecuzioneAccordo;
	}
	public void setEsecuzioneAccordo(EsecuzioneAccordo esecuzioneAccordo) {
		this.esecuzioneAccordo = esecuzioneAccordo;
	}
	public ScambioAccordo getScambioAccordo() {
		return scambioAccordo;
	}
	public void setScambioAccordo(ScambioAccordo scambioAccordo) {
		this.scambioAccordo = scambioAccordo;
	}
	public SottoProgramma getSottoProgramma() {
		return sottoProgramma;
	}
	public void setSottoProgramma(SottoProgramma sottoProgramma) {
		this.sottoProgramma = sottoProgramma;
	}
	public Target getTarget() {
		return target;
	}
	public void setTarget(Target target) {
		this.target = target;
	}
	public TipoAttivita getTipoAttivita() {
		return tipoAttivita;
	}
	public void setTipoAttivita(TipoAttivita tipoAttivita) {
		this.tipoAttivita = tipoAttivita;
	}
		
	public Campus getCampus() {
		return campus;
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	
	public String getSiglaCampus() {
		return (campus!=null && campus.getId()!=null)? campus.getId():""; 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((esecuzioneAccordo == null) ? 0 : esecuzioneAccordo
						.hashCode());
		result = prime * result
				+ ((scambioAccordo == null) ? 0 : scambioAccordo.hashCode());
		result = prime * result
				+ ((sottoProgramma == null) ? 0 : sottoProgramma.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result
				+ ((tipoAttivita == null) ? 0 : tipoAttivita.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ScambioEsecuzione))
			return false;
		ScambioEsecuzione other = (ScambioEsecuzione) obj;
		if (getEsecuzioneAccordo() == null) {
			if (other.getEsecuzioneAccordo() != null)
				return false;
		} else if (!getEsecuzioneAccordo().equals(other.getEsecuzioneAccordo()))
			return false;
		if (getScambioAccordo() == null) {
			if (other.getScambioAccordo() != null)
				return false;
		} else if (!getScambioAccordo().equals(other.getScambioAccordo()))
			return false;
		if (getSottoProgramma() == null) {
			if (other.getSottoProgramma() != null)
				return false;
		} else if (!getSottoProgramma().equals(other.getSottoProgramma()))
			return false;
		if (getTarget() == null) {
			if (other.getTarget() != null)
				return false;
		} else if (!getTarget().equals(other.getTarget()))
			return false;
		if (getTipoAttivita() == null) {
			if (other.getTipoAttivita() != null)
				return false;
		} else if (!getTipoAttivita().equals(other.getTipoAttivita()))
			return false;
		return true;
	}
	public FlussoScambioEsecuzione getFlussoScambioEsecuzioneIn() {
		return flussoScambioEsecuzioneIn;
	}
	public void setFlussoScambioEsecuzioneIn(
			FlussoScambioEsecuzione flussoScambioEsecuzioneIn) {
		this.flussoScambioEsecuzioneIn = flussoScambioEsecuzioneIn;
	}
	public FlussoScambioEsecuzione getFlussoScambioEsecuzioneOut() {
		return flussoScambioEsecuzioneOut;
	}
	public void setFlussoScambioEsecuzioneOut(
			FlussoScambioEsecuzione flussoScambioEsecuzioneOut) {
		this.flussoScambioEsecuzioneOut = flussoScambioEsecuzioneOut;
	}
	public Facolta getFacolta() {
		return facolta;
	}
	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}
	
	// TODO: l'id del beneficiaro è stato aggiunto nella tabella scambio_esecuzione ma attualmente
	// il campo non è gestito dall'applicativo => per il momento quindi
	// l'ateneo da visualizzare nelle offerte, se trattasi di ateneo beneficiario,
	// viene preso dallo scambio accordo e non dallo scambio esecuzione che potrebbe 
	// essere ancora NON copilato correttamente!!
	public Ateneo getAteneoBeneficiario() {
		if (getScambioAccordo() == null)
			return null;
		return getScambioAccordo().getBeneficiario();
	}
}

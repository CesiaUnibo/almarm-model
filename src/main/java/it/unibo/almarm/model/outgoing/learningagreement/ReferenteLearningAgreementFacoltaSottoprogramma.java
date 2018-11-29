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
package it.unibo.almarm.model.outgoing.learningagreement;

import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.model.attori.Persona;

public class ReferenteLearningAgreementFacoltaSottoprogramma implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String codFac;
	private Persona referente;
	private SottoProgramma sottoProgramma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getReferente() {
		return referente;
	}

	public void setReferente(Persona referente) {
		this.referente = referente;
	}

	public String getCodFac() {
		return codFac;
	}

	public void setCodFac(String codFac) {
		this.codFac = codFac;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codFac == null) ? 0 : codFac.hashCode());
		result = prime * result
				+ ((referente == null) ? 0 : referente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ReferenteLearningAgreementFacoltaSottoprogramma))
			return false;
		ReferenteLearningAgreementFacoltaSottoprogramma other = (ReferenteLearningAgreementFacoltaSottoprogramma) obj;
		if (codFac == null) {
			if (other.codFac != null)
				return false;
		} else if (!codFac.equals(other.codFac))
			return false;
		if (referente == null) {
			if (other.referente != null)
				return false;
		} else if (!referente.equals(other.referente))
			return false;
		return true;
	}

	public SottoProgramma getSottoProgramma() {
		return sottoProgramma;
	}

	public void setSottoProgramma(SottoProgramma sottoProgramma) {
		this.sottoProgramma = sottoProgramma;
	}
}

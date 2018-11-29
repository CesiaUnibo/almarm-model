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

public class ReferenteLearningAgreementVicepresidenzaSottoprogramma implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long idVicepresidenza;
	private Persona referente;
	private SottoProgramma sottoProgramma;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdVicepresidenza() {
		return idVicepresidenza;
	}
	public void setIdVicepresidenza(Long idVicepresidenza) {
		this.idVicepresidenza = idVicepresidenza;
	}
	public Persona getReferente() {
		return referente;
	}
	public void setReferente(Persona referente) {
		this.referente = referente;
	}
	public SottoProgramma getSottoProgramma() {
		return sottoProgramma;
	}
	public void setSottoProgramma(SottoProgramma sottoProgramma) {
		this.sottoProgramma = sottoProgramma;
	}

}

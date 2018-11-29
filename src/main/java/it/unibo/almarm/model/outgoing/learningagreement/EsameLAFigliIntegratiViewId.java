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

public class EsameLAFigliIntegratiViewId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	Long idLearningAgreement;
	Long idAttivitaUniboLA;
	
	public Long getIdLearningAgreement() {
		return idLearningAgreement;
	}
	public void setIdLearningAgreement(Long idLearningAgreement) {
		this.idLearningAgreement = idLearningAgreement;
	}
	public Long getIdAttivitaUniboLA() {
		return idAttivitaUniboLA;
	}
	public void setIdAttivitaUniboLA(Long idAttivitaUniboLA) {
		this.idAttivitaUniboLA = idAttivitaUniboLA;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idAttivitaUniboLA == null) ? 0 : idAttivitaUniboLA
						.hashCode());
		result = prime
				* result
				+ ((idLearningAgreement == null) ? 0 : idLearningAgreement
						.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EsameLAFigliIntegratiViewId))
			return false;
		EsameLAFigliIntegratiViewId other = (EsameLAFigliIntegratiViewId) obj;
		if (idAttivitaUniboLA == null) {
			if (other.idAttivitaUniboLA != null)
				return false;
		} else if (!idAttivitaUniboLA.equals(other.idAttivitaUniboLA))
			return false;
		if (idLearningAgreement == null) {
			if (other.idLearningAgreement != null)
				return false;
		} else if (!idLearningAgreement.equals(other.idLearningAgreement))
			return false;
		return true;
	}
}

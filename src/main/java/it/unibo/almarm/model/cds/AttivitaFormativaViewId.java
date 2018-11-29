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
package it.unibo.almarm.model.cds;

public class AttivitaFormativaViewId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer annoAccademico;
	private Long idComponenteAF;

	public Integer getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(Integer annoAccademico) {
		this.annoAccademico = annoAccademico;
	}

	public Long getIdComponenteAF() {
		return idComponenteAF;
	}

	public void setIdComponenteAF(Long idComponenteAF) {
		this.idComponenteAF = idComponenteAF;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annoAccademico == null) ? 0 : annoAccademico.hashCode());
		result = prime * result
				+ ((idComponenteAF == null) ? 0 : idComponenteAF.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AttivitaFormativaViewId))
			return false;
		AttivitaFormativaViewId other = (AttivitaFormativaViewId) obj;
		if (annoAccademico == null) {
			if (other.annoAccademico != null)
				return false;
		} else if (!annoAccademico.equals(other.annoAccademico))
			return false;
		if (idComponenteAF == null) {
			if (other.idComponenteAF != null)
				return false;
		} else if (!idComponenteAF.equals(other.idComponenteAF))
			return false;
		return true;
	}
}

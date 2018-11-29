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

import it.unibo.almarm.util.Common;

public class EsameLACorsoViewId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer annoAccademico;
	private Integer idPiano;
	private Integer idCompomenteAF;
	private String annoCorso;

	public Integer getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(Integer annoAccademico) {
		this.annoAccademico = annoAccademico;
	}

	public Integer getIdPiano() {
		return idPiano;
	}

	public void setIdPiano(Integer idPiano) {
		this.idPiano = idPiano;
	}

	public Integer getIdCompomenteAF() {
		return idCompomenteAF;
	}

	public void setIdCompomenteAF(Integer idCompomenteAF) {
		this.idCompomenteAF = idCompomenteAF;
	}

	public String getAnnoCorso() {
		return annoCorso;
	}

	public void setAnnoCorso(String annoCorso) {
		this.annoCorso = annoCorso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annoAccademico == null) ? 0 : annoAccademico.hashCode());
		result = prime * result
				+ ((annoCorso == null) ? 0 : annoCorso.hashCode());
		result = prime * result
				+ ((idCompomenteAF == null) ? 0 : idCompomenteAF.hashCode());
		result = prime * result + ((idPiano == null) ? 0 : idPiano.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EsameLACorsoViewId))
			return false;
		EsameLACorsoViewId other = (EsameLACorsoViewId) obj;
		if (annoAccademico == null) {
			if (other.annoAccademico != null)
				return false;
		} else if (!annoAccademico.equals(other.annoAccademico))
			return false;
		if (annoCorso == null) {
			if (other.annoCorso != null)
				return false;
		} else if (!annoCorso.equals(other.annoCorso))
			return false;
		if (idCompomenteAF == null) {
			if (other.idCompomenteAF != null)
				return false;
		} else if (!idCompomenteAF.equals(other.idCompomenteAF))
			return false;
		if (idPiano == null) {
			if (other.idPiano != null)
				return false;
		} else if (!idPiano.equals(other.idPiano))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "id" + Common.idSeparator
				+ annoAccademico + Common.idSeparator
				+ idPiano + Common.idSeparator
				+ idCompomenteAF + Common.idSeparator
				+ annoCorso;
	}
	
	public static EsameLACorsoViewId getIdByString(String sid) {
		EsameLACorsoViewId id = new EsameLACorsoViewId();
		String[] el = sid.split(Common.idSeparator);
		id.setAnnoAccademico(Integer.valueOf(el[1]));
		id.setIdPiano(Integer.valueOf(el[2]));
		id.setIdCompomenteAF(Integer.valueOf(el[3]));
		id.setAnnoCorso(el[4]);
		return id;
	}
}

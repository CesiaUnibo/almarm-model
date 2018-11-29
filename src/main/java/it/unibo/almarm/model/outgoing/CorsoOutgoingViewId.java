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
package it.unibo.almarm.model.outgoing;

public class CorsoOutgoingViewId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codCorso;
	private Long idVicepresidenza;

	public String getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}

	public Long getIdVicepresidenza() {
		return idVicepresidenza;
	}

	public void setIdVicepresidenza(Long idVicepresidenza) {
		this.idVicepresidenza = idVicepresidenza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codCorso == null) ? 0 : codCorso.hashCode());
		result = prime
				* result
				+ ((idVicepresidenza == null) ? 0 : idVicepresidenza.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CorsoOutgoingViewId))
			return false;
		CorsoOutgoingViewId other = (CorsoOutgoingViewId) obj;
		if (codCorso == null) {
			if (other.codCorso != null)
				return false;
		} else if (!codCorso.equals(other.codCorso))
			return false;
		if (idVicepresidenza == null) {
			if (other.idVicepresidenza != null)
				return false;
		} else if (!idVicepresidenza.equals(other.idVicepresidenza))
			return false;
		return true;
	}

}

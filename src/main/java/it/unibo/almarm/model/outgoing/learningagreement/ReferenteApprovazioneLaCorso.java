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

public class ReferenteApprovazioneLaCorso implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String codCorso;
	private Long idAnagrafica;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}

	public Long getIdAnagrafica() {
		return idAnagrafica;
	}

	public void setIdAnagrafica(Long idAnagrafica) {
		this.idAnagrafica = idAnagrafica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codCorso == null) ? 0 : codCorso.hashCode());
		result = prime * result
				+ ((idAnagrafica == null) ? 0 : idAnagrafica.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ReferenteApprovazioneLaCorso))
			return false;
		ReferenteApprovazioneLaCorso other = (ReferenteApprovazioneLaCorso) obj;
		if (codCorso == null) {
			if (other.codCorso != null)
				return false;
		} else if (!codCorso.equals(other.codCorso))
			return false;
		if (idAnagrafica == null) {
			if (other.idAnagrafica != null)
				return false;
		} else if (!idAnagrafica.equals(other.idAnagrafica))
			return false;
		return true;
	}
}

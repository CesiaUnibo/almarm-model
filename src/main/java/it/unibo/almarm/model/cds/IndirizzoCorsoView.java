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

public class IndirizzoCorsoView implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String codCorso;
	private String codInd;
	private String codOri;
	private String descrizione;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}

	public String getCodInd() {
		return codInd;
	}

	public void setCodInd(String codInd) {
		this.codInd = codInd;
	}

	public String getCodOri() {
		return codOri;
	}

	public void setCodOri(String codOri) {
		this.codOri = codOri;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codCorso == null) ? 0 : codCorso.hashCode());
		result = prime * result + ((codInd == null) ? 0 : codInd.hashCode());
		result = prime * result + ((codOri == null) ? 0 : codOri.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IndirizzoCorsoView))
			return false;
		IndirizzoCorsoView other = (IndirizzoCorsoView) obj;
		if (id != null && other.id != null
			&& (!id.equals(other.id)))
				return false;
		if (codCorso == null) {
			if (other.codCorso != null)
				return false;
		} else if (!codCorso.equals(other.codCorso))
			return false;
		if (codInd == null) {
			if (other.codInd != null)
				return false;
		} else if (!codInd.equals(other.codInd))
			return false;
		if (codOri == null) {
			if (other.codOri != null)
				return false;
		} else if (!codOri.equals(other.codOri))
			return false;
		return true;
	}
}

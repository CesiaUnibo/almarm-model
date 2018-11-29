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

import it.unibo.almarm.model.attori.Vicepresidenza;

public class VicepresidenzaDot implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String codCorso;
	private Vicepresidenza vicepresidenza;
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
	public Vicepresidenza getVicepresidenza() {
		return vicepresidenza;
	}
	public void setVicepresidenza(Vicepresidenza vicepresidenza) {
		this.vicepresidenza = vicepresidenza;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof VicepresidenzaDot))
			return false;
		VicepresidenzaDot other = (VicepresidenzaDot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

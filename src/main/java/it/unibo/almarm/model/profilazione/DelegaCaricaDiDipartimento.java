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
package it.unibo.almarm.model.profilazione;

import it.unibo.almarm.model.attori.Persona;

public class DelegaCaricaDiDipartimento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Persona delegato;
	private Persona delegante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getDelegato() {
		return delegato;
	}

	public void setDelegato(Persona delegato) {
		this.delegato = delegato;
	}

	public Persona getDelegante() {
		return delegante;
	}

	public void setDelegante(Persona delegante) {
		this.delegante = delegante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delegante == null) ? 0 : delegante.hashCode());
		result = prime * result + ((delegato == null) ? 0 : delegato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DelegaCaricaDiDipartimento))
			return false;
		DelegaCaricaDiDipartimento other = (DelegaCaricaDiDipartimento) obj;
		if (delegante == null) {
			if (other.delegante != null)
				return false;
		} else if (!delegante.equals(other.delegante))
			return false;
		if (delegato == null) {
			if (other.delegato != null)
				return false;
		} else if (!delegato.equals(other.delegato))
			return false;
		return true;
	}
}

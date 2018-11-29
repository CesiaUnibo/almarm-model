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
package it.unibo.almarm.model.email;

public class DestinatarioEmail implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeVisualizzato;
	private String indirizzoEmail;
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
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
		if (getClass() != obj.getClass())
			return false;
		DestinatarioEmail other = (DestinatarioEmail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setNomeVisualizzato(String nomeVisualizzato) {
		this.nomeVisualizzato = nomeVisualizzato;
	}

	public String getNomeVisualizzato() {
		return nomeVisualizzato;
	}

	public void setIndirizzoEmail(String indirizzoEmail) {
		this.indirizzoEmail = indirizzoEmail;
	}

	public String getIndirizzoEmail() {
		return indirizzoEmail;
	}
}

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

import java.io.Serializable;

public class StudentePerRicerca implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long pincode;
	private String fulltext;
	private String descrizione;
	private Integer numeroCarriera;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFulltext() {
		return fulltext;
	}

	public void setFulltext(String fulltext) {
		this.fulltext = fulltext;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Long getPincode() {
		return pincode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fulltext == null) ? 0 : fulltext.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StudentePerRicerca))
			return false;
		StudentePerRicerca other = (StudentePerRicerca) obj;
		if (fulltext == null) {
			if (other.fulltext != null)
				return false;
		} else if (!fulltext.equals(other.fulltext))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getNumeroCarriera() {
		return numeroCarriera;
	}

	public void setNumeroCarriera(Integer numeroCarriera) {
		this.numeroCarriera = numeroCarriera;
	}
}

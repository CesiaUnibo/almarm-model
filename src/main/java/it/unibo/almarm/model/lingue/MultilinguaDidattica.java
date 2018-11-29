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
package it.unibo.almarm.model.lingue;

public class MultilinguaDidattica implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private MultilinguaDidatticaId id;
	private String descrizione;
	private String descrizioneBreve;
	
	public MultilinguaDidatticaId getId() {
		return id;
	}

	public void setId(MultilinguaDidatticaId id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getDescrizioneBreve() {
		return descrizioneBreve;
	}
	
	public void setDescrizioneBreve(String descrizioneBreve) {
		this.descrizioneBreve = descrizioneBreve;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime
				* result
				+ ((descrizioneBreve == null) ? 0 : descrizioneBreve.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MultilinguaDidattica))
			return false;
		MultilinguaDidattica other = (MultilinguaDidattica) obj;
		if (id != null && other.getId() != null
			&& !id.equals(other.getId()))
			return false;
		if (descrizione == null) {
			if (other.getDescrizione() != null)
				return false;
		} else if (!descrizione.equals(other.getDescrizione()))
			return false;
		if (descrizioneBreve == null) {
			if (other.getDescrizioneBreve() != null)
				return false;
		} else if (!descrizioneBreve.equals(other.getDescrizioneBreve()))
			return false;
		return true;
	}
}

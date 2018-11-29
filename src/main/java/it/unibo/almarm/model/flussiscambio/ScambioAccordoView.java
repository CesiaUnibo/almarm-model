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
package it.unibo.almarm.model.flussiscambio;

import it.unibo.almarm.model.attori.Facolta;

public class ScambioAccordoView implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String Id;
	private Long idEsecuzioneAccordo;
	private String siglaPolo;
	private Facolta facolta;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	public Long getIdEsecuzioneAccordo() {
		return idEsecuzioneAccordo;
	}
	public void setIdEsecuzioneAccordo(Long idEsecuzioneAccordo) {
		this.idEsecuzioneAccordo = idEsecuzioneAccordo;
	}
	
	public String getSiglaPolo() {
		return siglaPolo;
	}
	public void setSiglaPolo(String siglaPolo) {
		this.siglaPolo = siglaPolo;
	}
	/*
	public String getCodFac() {
		return codFac;
	}
	public void setCodFac(String codFac) {
		this.codFac = codFac;
	}
	*/
	public Facolta getFacolta() {
		return facolta;
	}
	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ScambioAccordoView))
			return false;
		ScambioAccordoView other = (ScambioAccordoView) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	
}

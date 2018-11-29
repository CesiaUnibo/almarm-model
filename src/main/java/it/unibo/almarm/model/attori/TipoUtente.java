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
package it.unibo.almarm.model.attori;


import org.regola.util.Ognl;

import it.unibo.almarm.webapp.mvc.Lingua;

public class TipoUtente implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String descrizione;
	private String descrizioneIng;

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescrizioneIng() {
		return descrizioneIng;
	}

	public void setDescrizioneIng(String descrizioneIng) {
		this.descrizioneIng = descrizioneIng;
	}

	public String getLocaleDescrizione() {
		Object propertyValue = Ognl.getValue("descrizione"+Lingua.getSuffissoNomeCampoDiModello(), this);
		if (propertyValue != null)
		{
			String val=(String)propertyValue;
			return val;
		}
		return "";
	}
	public void setLocaleDescrizione(String descrizione) {
		Ognl.setValue("descrizione"+Lingua.getSuffissoNomeCampoDiModello(),  this, descrizione);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descrizione == null) ? 0 : descrizione.hashCode());
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
		final TipoUtente other = (TipoUtente) obj;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		return true;
	}
	
}

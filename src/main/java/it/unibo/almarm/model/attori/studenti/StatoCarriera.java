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

public class StatoCarriera implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final String ATTIVA="AT";
	private static final String PASSAGGIO="PS";
	private static final String LAUREATO="LT";
	private static final String TERMINATO_SENZA_TITOLO="TR";
	

	private String id;
	private String descrizione;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public boolean isAttiva() {
		return this.id.equals(ATTIVA);
	}
	
	public boolean isPassaggio() {
		return this.id.equals(PASSAGGIO);
	}
	
	public boolean isLaureato() {
		return this.id.equals(LAUREATO);
	}
	
	public boolean isTerminatoSenzaTitolo() {
		return this.id.equals(TERMINATO_SENZA_TITOLO);
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
		if (!(obj instanceof StatoCarriera))
			return false;
		StatoCarriera other = (StatoCarriera) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

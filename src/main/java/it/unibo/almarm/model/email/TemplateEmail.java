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

import java.util.Arrays;
import java.util.List;

public class TemplateEmail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SEPARATORE_ALLEGATI = ";";
	
	private Long id;
	private String oggetto;
	private String corpo;
	private String oggettoIng;
	private String corpoIng;
	private String nomeMittente;
	private String indirizzoMittente;
	private String allegati;
	private String allegatiIng;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
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
		TemplateEmail other = (TemplateEmail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getOggettoIng() {
		return oggettoIng;
	}

	public void setOggettoIng(String oggettoIng) {
		this.oggettoIng = oggettoIng;
	}

	public String getCorpoIng() {
		return corpoIng;
	}

	public void setCorpoIng(String corpoIng) {
		this.corpoIng = corpoIng;
	}

	public String getNomeMittente() {
		return nomeMittente;
	}

	public void setNomeMittente(String nomeMittente) {
		this.nomeMittente = nomeMittente;
	}

	public String getIndirizzoMittente() {
		return indirizzoMittente;
	}

	public void setIndirizzoMittente(String indirizzoMittente) {
		this.indirizzoMittente = indirizzoMittente;
	}

	public void setAllegati(String allegati) {
		this.allegati = allegati;
	}

	public String getAllegati() {
		return allegati;
	}

	public List<String> getListaAllegati() {
		if (allegati == null)
			return null;
		return Arrays.asList(allegati.split(SEPARATORE_ALLEGATI));
	}

	public void setAllegatiIng(String allegatiIng) {
		this.allegatiIng = allegatiIng;
	}

	public String getAllegatiIng() {
		return allegatiIng;
	}

	public List<String> getListaAllegatiIng() {
		if (allegatiIng == null)
			return null;
		return Arrays.asList(allegatiIng.split(SEPARATORE_ALLEGATI));
	}
	
}

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

import it.unibo.almarm.webapp.mvc.Lingua;

import org.regola.util.Ognl;

public class AreaDisciplinare implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private CodificaAreaDisciplinare codifica;
	private String codice;
	private String codicePrecedente;
	private String descrizione;
	private String descrizioneIng;
	private Long livello;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CodificaAreaDisciplinare getCodifica() {
		return codifica;
	}
	public void setCodifica(CodificaAreaDisciplinare codifica) {
		this.codifica = codifica;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getCodicePrecedente() {
		return codicePrecedente;
	}
	public void setCodicePrecedente(String codicePrecedente) {
		this.codicePrecedente = codicePrecedente;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDescrizioneIng() {
		return descrizioneIng;
	}
	public void setDescrizioneIng(String descrizioneIng) {
		this.descrizioneIng = descrizioneIng;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		result = prime * result
				+ ((codifica == null) ? 0 : codifica.hashCode());
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
		if (!(obj instanceof AreaDisciplinare))
			return false;
		AreaDisciplinare other = (AreaDisciplinare) obj;
		if (getCodice() == null) {
			if (other.getCodice() != null)
				return false;
		} else if (!getCodice().equals(other.getCodice()))
			return false;
		if (getCodifica() == null) {
			if (other.getCodifica() != null)
				return false;
		} else if (!getCodifica().equals(other.getCodifica()))
			return false;
		if (getDescrizione() == null) {
			if (other.getDescrizione() != null)
				return false;
		} else if (!getDescrizione().equals(other.getDescrizione()))
			return false;
		return true;
	}
	
	public String getLabel() {
		Object propertyValue = Ognl.getValue("descrizione"+Lingua.getSuffissoNomeCampoDiModello(), this);
		String val = "";
		if (propertyValue != null)
			val=(String)propertyValue;
		return this.codice + " " + val;
	}
	public Long getLivello() {
		return livello;
	}
	public void setLivello(Long livello) {
		this.livello = livello;
	}

}

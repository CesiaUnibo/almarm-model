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

import org.apache.commons.lang.StringUtils;


public class Contatto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Persona persona;
	private String cognome;
	private String nome;
	private Character genere;
	private String codiceFiscale;
	private String telefono;
	private String Cellulare;
	private String fax;
	private String email;
	private String titolo;
	private String qualifica;
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Character getGenere() {
		return genere;
	}

	public void setGenere(Character genere) {
		this.genere = genere;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCellulare() {
		return Cellulare;
	}

	public void setCellulare(String cellulare) {
		Cellulare = cellulare;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getQualifica() {
		return qualifica;
	}

	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public String getNomeCognomeQualifica (){
		return StringUtils.defaultIfEmpty(getNome(), "")  
	   + " " + StringUtils.defaultIfEmpty(getCognome(), "")
	   + (!StringUtils.isEmpty(getTitolo()) ? " - " + getTitolo() : "");
	   
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Contatto))
			return false;
		Contatto other = (Contatto) obj;
		if (codiceFiscale == null) {
			if (other.getCodiceFiscale() != null)
				return false;
		} else if (!codiceFiscale.equals(other.getCodiceFiscale()))
			return false;
		if (cognome == null) {
			if (other.getCognome() != null)
				return false;
		} else if (!cognome.equals(other.getCognome()))
			return false;
		if (nome == null) {
			if (other.getNome() != null)
				return false;
		} else if (!nome.equals(other.getNome()))
			return false;
		if (persona == null) {
			if (other.getPersona() != null)
				return false;
		} else if (!persona.equals(other.getPersona()))
			return false;
		return true;
	}
	
	public String getCognomeNome() {
		return getCognome() + " " + getNome();
	}
	
	public String getNomeCognome() {
		return getNome() + " " + getCognome();
	}
}

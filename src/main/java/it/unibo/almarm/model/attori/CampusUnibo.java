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

public class CampusUnibo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String nomeUfficio;
	private String indirizzo;
	private String cap;
	private String citta;
	private String siglaProvincia;
	private String telefono;
	private String fax;
	private String email;
	private String orari;
	private String orariIng;
    private String testoEsteso;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeUfficio() {
		return nomeUfficio;
	}

	public void setNomeUfficio(String nomeUfficio) {
		this.nomeUfficio = nomeUfficio;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getSiglaProvincia() {
		return siglaProvincia;
	}

	public void setSiglaProvincia(String siglaProvincia) {
		this.siglaProvincia = siglaProvincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public String getOrari() {
		return orari;
	}

	public void setOrari(String orari) {
		this.orari = orari;
	}

	public String getOrariIng() {
		return orariIng;
	}

	public void setOrariIng(String orariIng) {
		this.orariIng = orariIng;
	}

    public String getTestoEsteso() {
        return testoEsteso;
    }

    public void setTestoEsteso(String testoEsteso) {
        this.testoEsteso = testoEsteso;
    }
}

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

import it.unibo.almarm.model.attori.Scuola;

public class CorsoScuola implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private java.lang.String codiceAteno;
	private java.lang.String codiceCorso;
	private Scuola scuola;
	private Integer flagCapofila;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public java.lang.String getCodiceAteno() {
		return codiceAteno;
	}
	public void setCodiceAteno(java.lang.String codiceAteno) {
		this.codiceAteno = codiceAteno;
	}
	public java.lang.String getCodiceCorso() {
		return codiceCorso;
	}
	public void setCodiceCorso(java.lang.String codiceCorso) {
		this.codiceCorso = codiceCorso;
	}
	public Scuola getScuola() {
		return scuola;
	}
	public void setScuola(Scuola scuola) {
		this.scuola = scuola;
	}
	public Integer getFlagCapofila() {
		return flagCapofila;
	}
	public void setFlagCapofila(Integer flagCapofila) {
		this.flagCapofila = flagCapofila;
	}
}

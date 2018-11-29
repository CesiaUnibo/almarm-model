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

import it.unibo.almarm.model.accordi.SottoProgramma;

public class ContattoUnibo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private SottoProgramma sottoProgramma;
	private Campus campus;
	private Character flagIncoming;
	private Character flagOutgoing;
	private String nome;
	private String urlSkype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SottoProgramma getSottoProgramma() {
		return sottoProgramma;
	}

	public void setSottoProgramma(SottoProgramma sottoProgramma) {
		this.sottoProgramma = sottoProgramma;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public Character getFlagIncoming() {
		return flagIncoming;
	}

	public void setFlagIncoming(Character flagIncoming) {
		this.flagIncoming = flagIncoming;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlSkype() {
		return urlSkype;
	}

	public void setUrlSkype(String urlSkype) {
		this.urlSkype = urlSkype;
	}

	public Character getFlagOutgoing() {
		return flagOutgoing;
	}

	public void setFlagOutgoing(Character flagOutgoing) {
		this.flagOutgoing = flagOutgoing;
	}
	
}

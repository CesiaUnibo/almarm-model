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
package it.unibo.almarm.model.incoming;

import it.unibo.almarm.model.accordi.SottoProgramma;

public class ElChecklistIncoming implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private SottoProgramma sottoProgramma;
	private String nome;
	private Integer posizione;
	private Integer modificabile;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPosizione() {
		return posizione;
	}
	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}
	public Integer getModificabile() {
		return modificabile;
	}
	public void setModificabile(Integer modificabile) {
		this.modificabile = modificabile;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((posizione == null) ? 0 : posizione.hashCode());
		result = prime * result
				+ ((sottoProgramma == null) ? 0 : sottoProgramma.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ElChecklistIncoming))
			return false;
		ElChecklistIncoming other = (ElChecklistIncoming) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (posizione == null) {
			if (other.posizione != null)
				return false;
		} else if (!posizione.equals(other.posizione))
			return false;
		if (sottoProgramma == null) {
			if (other.sottoProgramma != null)
				return false;
		} else if (!sottoProgramma.equals(other.sottoProgramma))
			return false;
		return true;
	}
}

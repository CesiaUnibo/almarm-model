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

import it.unibo.almarm.model.attori.Struttura;


public class StrutturaStipula implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Struttura struttura;
	private Character flagAttiva;
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Character getFlagAttiva() {
		return flagAttiva;
	}

	public void setFlagAttiva(Character flagAttiva) {
		this.flagAttiva = flagAttiva;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Struttura getStruttura() {
		return struttura;
	}

	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}
	
	public boolean isAttiva() {
		return (new Character('S')).equals(flagAttiva);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((flagAttiva == null) ? 0 : flagAttiva.hashCode());
		result = prime * result
				+ ((struttura == null) ? 0 : struttura.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StrutturaStipula))
			return false;
		StrutturaStipula other = (StrutturaStipula) obj;
		if (flagAttiva == null) {
			if (other.flagAttiva != null)
				return false;
		} else if (!flagAttiva.equals(other.flagAttiva))
			return false;
		if (struttura == null) {
			if (other.struttura != null)
				return false;
		} else if (!struttura.equals(other.struttura))
			return false;
		return true;
	}

}

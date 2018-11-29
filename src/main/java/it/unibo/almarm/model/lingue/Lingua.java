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
package it.unibo.almarm.model.lingue;

public class Lingua implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String codIso639_3;
	private String codIso639_1;
	private String nomeIng;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodIso639_3() {
		return codIso639_3;
	}

	public void setCodIso639_3(String codIso639_3) {
		this.codIso639_3 = codIso639_3;
	}

	public String getCodIso639_1() {
		return codIso639_1;
	}

	public void setCodIso639_1(String codIso639_1) {
		this.codIso639_1 = codIso639_1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codIso639_1 == null) ? 0 : codIso639_1.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Lingua))
			return false;
		Lingua other = (Lingua) obj;
		if (codIso639_1 == null) {
			if (other.codIso639_1 != null)
				return false;
		} else if (!codIso639_1.equals(other.codIso639_1))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.id.toString();
	}

	public String getNomeIng() {
		return nomeIng;
	}

	public void setNomeIng(String nomeIng) {
		this.nomeIng = nomeIng;
	}
}

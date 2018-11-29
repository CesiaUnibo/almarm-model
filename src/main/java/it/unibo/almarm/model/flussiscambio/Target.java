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

import java.util.Set;


public class Target implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final long ID_TARGET_STUDENTI = 1L;
	public static final long ID_TARGET_DOCENTI = 2L;
	
	private Long id;
	private String nome;
	private String sigla;
	private Set<SottoTarget> sottoTarget;
	private Character flagMostraOreDurata;
	private Character flagGestisceOfferta;
	
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}	
	public Character getFlagGestisceOfferta() {
		return flagGestisceOfferta;
	}
	public void setFlagGestisceOfferta(Character flagGestisceOfferta) {
		this.flagGestisceOfferta = flagGestisceOfferta;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Target))
			return false;
		Target other = (Target) obj;
		if (getNome() == null) {
			if (other.getNome() != null)
				return false;
		} else if (!getNome().equals(other.getNome()))
			return false;
		return true;
	}
	public Set<SottoTarget> getSottoTarget() {
		return sottoTarget;
	}
	public void setSottoTarget(Set<SottoTarget> sottoTarget) {
		this.sottoTarget = sottoTarget;
	}
	public Character getFlagMostraOreDurata() {
		return flagMostraOreDurata;
	}
	public void setFlagMostraOreDurata(Character flagMostraOreDurata) {
		this.flagMostraOreDurata = flagMostraOreDurata;
	}

	public boolean isMostraOreDurata() {
		return (new Character('S')).equals(flagMostraOreDurata);
	}
	public boolean isGestisceOfferta() {
		return (new Character('S')).equals(flagGestisceOfferta);
	}
	public boolean isStudenti() {
		return id.equals(ID_TARGET_STUDENTI);
	}
	public boolean isDocenti() {
		return id.equals(ID_TARGET_DOCENTI);
	}
}

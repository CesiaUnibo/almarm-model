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
package it.unibo.almarm.model.outgoing;

import it.unibo.almarm.model.attori.Ateneo;

import java.util.HashSet;
import java.util.Set;

public class OpzioneOfferta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Offerta offerta;
	private String nome;
	private String descrizione;
	private Integer posizione;
	
	private Ateneo ateneo;
	
	private Set<RequisitoOfferta> requisitiOfferta = new HashSet<RequisitoOfferta>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Offerta getOfferta() {
		return offerta;
	}

	public void setOfferta(Offerta offerta) {
		this.offerta = offerta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof OpzioneOfferta))
			return false;
		OpzioneOfferta other = (OpzioneOfferta) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		return true;
	}

	public Set<RequisitoOfferta> getRequisitiOfferta() {
		return requisitiOfferta;
	}

	public void setRequisitiOfferta(Set<RequisitoOfferta> requisitiOfferta) {
		this.requisitiOfferta = requisitiOfferta;
	}

	public Integer getPosizione() {
		return posizione;
	}

	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}

	public void setAteneo(Ateneo ateneo) {
		this.ateneo = ateneo;
	}

	public Ateneo getAteneo() {
		return ateneo;
	}
}

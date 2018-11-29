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

import it.unibo.almarm.util.Common;

public class ReferenteStudenteOutgoingView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long idStudenteOutgoing;
	private Long idPersona;
	private String cognome;
	private String nome;
	private Character flagCoordinatoreCorso;
	
	public Long getIdStudenteOutgoing() {
		return idStudenteOutgoing;
	}
	public void setIdStudenteOutgoing(Long idStudenteOutgoing) {
		this.idStudenteOutgoing = idStudenteOutgoing;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPersona == null) ? 0 : idPersona.hashCode());
		result = prime
				* result
				+ ((idStudenteOutgoing == null) ? 0 : idStudenteOutgoing
						.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ReferenteStudenteOutgoingView))
			return false;
		ReferenteStudenteOutgoingView other = (ReferenteStudenteOutgoingView) obj;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		if (idStudenteOutgoing == null) {
			if (other.idStudenteOutgoing != null)
				return false;
		} else if (!idStudenteOutgoing.equals(other.idStudenteOutgoing))
			return false;
		return true;
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
	public Character getFlagCoordinatoreCorso() {
		return flagCoordinatoreCorso;
	}
	public void setFlagCoordinatoreCorso(Character flagCoordinatoreCorso) {
		this.flagCoordinatoreCorso = flagCoordinatoreCorso;
	}
	public boolean isCoordinatoreCorso() {
		return Common.CH_S.equals(getFlagCoordinatoreCorso());
	}
}

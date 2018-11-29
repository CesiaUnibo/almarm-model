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

public class DisponibilitaAteneoViewId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long idDisponibilita;
	private Long idAteneo;
	
	public Long getIdDisponibilita() {
		return idDisponibilita;
	}
	public void setIdDisponibilita(Long idDisponibilita) {
		this.idDisponibilita = idDisponibilita;
	}
	public Long getIdAteneo() {
		return idAteneo;
	}
	public void setIdAteneo(Long idAteneo) {
		this.idAteneo = idAteneo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idAteneo == null) ? 0 : idAteneo.hashCode());
		result = prime * result
				+ ((idDisponibilita == null) ? 0 : idDisponibilita.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DisponibilitaAteneoViewId))
			return false;
		DisponibilitaAteneoViewId other = (DisponibilitaAteneoViewId) obj;
		if (idAteneo == null) {
			if (other.idAteneo != null)
				return false;
		} else if (!idAteneo.equals(other.idAteneo))
			return false;
		if (idDisponibilita == null) {
			if (other.idDisponibilita != null)
				return false;
		} else if (!idDisponibilita.equals(other.idDisponibilita))
			return false;
		return true;
	}
}

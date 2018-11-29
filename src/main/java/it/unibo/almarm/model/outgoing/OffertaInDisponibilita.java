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

public class OffertaInDisponibilita implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Offerta offerta;
	private Disponibilita disponibilita;
	private Integer postiOfferti;

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

	public Integer getPostiOfferti() {
		return postiOfferti;
	}

	public void setPostiOfferti(Integer postiOfferti) {
		this.postiOfferti = postiOfferti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof OffertaInDisponibilita))
			return false;
		OffertaInDisponibilita other = (OffertaInDisponibilita) obj;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		return true;
	}

	public Disponibilita getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(Disponibilita disponibilita) {
		this.disponibilita = disponibilita;
	}
}

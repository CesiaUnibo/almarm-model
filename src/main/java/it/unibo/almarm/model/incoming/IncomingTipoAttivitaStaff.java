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

import it.unibo.almarm.model.staff.TipoAttivitaStaff;

public class IncomingTipoAttivitaStaff implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private TipoAttivitaStaff tipoAttivitaStaff;
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoAttivitaStaff getTipoAttivitaStaff() {
		return tipoAttivitaStaff;
	}

	public void setTipoAttivitaStaff(TipoAttivitaStaff tipoAttivitaStaff) {
		this.tipoAttivitaStaff = tipoAttivitaStaff;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoAttivitaStaff == null) ? 0 : tipoAttivitaStaff.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IncomingTipoAttivitaStaff))
			return false;
		IncomingTipoAttivitaStaff other = (IncomingTipoAttivitaStaff) obj;
		if (tipoAttivitaStaff == null) {
			if (other.tipoAttivitaStaff != null)
				return false;
		} else if (!tipoAttivitaStaff.equals(other.tipoAttivitaStaff))
			return false;
		return true;
	}

}

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

import it.unibo.almarm.model.staff.IncomingStaffChecklist;

public class NominaStaffChecklistElement implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private IncomingStaffChecklist incomingStaffChecklist;
	private Character valore;
	private String dettaglio;
	
	// campi non persistiti
	private String errorValore;
	private String errorDettaglio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public IncomingStaffChecklist getIncomingStaffChecklist() {
		return incomingStaffChecklist;
	}

	public void setIncomingStaffChecklist(IncomingStaffChecklist incomingStaffChecklist) {
		this.incomingStaffChecklist = incomingStaffChecklist;
	}

	public Character getValore() {
		return valore;
	}

	public void setValore(Character valore) {
		this.valore = valore;
	}

	public String getDettaglio() {
		return dettaglio;
	}

	public void setDettaglio(String dettaglio) {
		this.dettaglio = dettaglio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((incomingStaffChecklist == null) ? 0 : incomingStaffChecklist.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NominaStaffChecklistElement))
			return false;
		NominaStaffChecklistElement other = (NominaStaffChecklistElement) obj;
		if (incomingStaffChecklist == null) {
			if (other.incomingStaffChecklist != null)
				return false;
		} else if (!incomingStaffChecklist.equals(other.incomingStaffChecklist))
			return false;
		return true;
	}

	public String getErrorValore() {
		return errorValore;
	}

	public void setErrorValore(String errorValore) {
		this.errorValore = errorValore;
	}

	public String getErrorDettaglio() {
		return errorDettaglio;
	}

	public void setErrorDettaglio(String errorDettaglio) {
		this.errorDettaglio = errorDettaglio;
	}
}

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

import it.unibo.almarm.model.esterni.SettoreAttivitaNace;

import java.io.Serializable;

public class CandidaturaAziendaSettoreNace implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private CandidaturaDatiPlacement candidaturaDatiPlacement;
	private SettoreAttivitaNace settoreAttivitaNace;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CandidaturaDatiPlacement getCandidaturaDatiPlacement() {
		return candidaturaDatiPlacement;
	}

	public void setCandidaturaDatiPlacement(
			CandidaturaDatiPlacement candidaturaDatiPlacement) {
		this.candidaturaDatiPlacement = candidaturaDatiPlacement;
	}

	public SettoreAttivitaNace getSettoreAttivitaNace() {
		return settoreAttivitaNace;
	}

	public void setSettoreAttivitaNace(SettoreAttivitaNace settoreAttivitaNace) {
		this.settoreAttivitaNace = settoreAttivitaNace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((candidaturaDatiPlacement == null) ? 0
						: candidaturaDatiPlacement.hashCode());
		result = prime
				* result
				+ ((settoreAttivitaNace == null) ? 0 : settoreAttivitaNace
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CandidaturaAziendaSettoreNace))
			return false;
		CandidaturaAziendaSettoreNace other = (CandidaturaAziendaSettoreNace) obj;
		if (candidaturaDatiPlacement == null) {
			if (other.candidaturaDatiPlacement != null)
				return false;
		} else if (!candidaturaDatiPlacement
				.equals(other.candidaturaDatiPlacement))
			return false;
		if (settoreAttivitaNace == null) {
			if (other.settoreAttivitaNace != null)
				return false;
		} else if (!settoreAttivitaNace.equals(other.settoreAttivitaNace))
			return false;
		return true;
	}
}

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
package it.unibo.almarm.model.profilazione;

import it.kion.plitvice.autorizzazioni.model.ProfiloUtente;
import it.kion.plitvice.autorizzazioni.model.Ruolo;

public abstract class ProfiloAlmaRM extends ProfiloUtente {
	
	private static final long serialVersionUID = 1L;
	
	protected boolean impersonato=false;

	public boolean isPresenteDirittoApplicativo(String diritto) {
		for (Ruolo ruolo: getRuoli())
			if (ruolo.isPresenteDirittoApplicativo(diritto))
				return true;
		return false;
	}
	
	public boolean isImpersonato() {
		return impersonato;
	}
	public void setImpersonato(boolean impersonato) {
		this.impersonato = impersonato;
	}
}

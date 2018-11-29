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
package it.unibo.almarm.model.accordi;

import java.util.Date;

import it.unibo.almarm.model.attori.Vicepresidenza;
import it.unibo.almarm.util.Common;

public class AccordoVicepresidenza implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long  id;
	private Vicepresidenza vicepresidenza;
	private Date dataInserimento;
	private Character flagApprovazione; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vicepresidenza getVicepresidenza() {
		return vicepresidenza;
	}

	public void setVicepresidenza(Vicepresidenza vicepresidenza) {
		this.vicepresidenza = vicepresidenza;
	}
	 
	public Character getFlagApprovazione() {
		return flagApprovazione;
	}
	
	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public void setFlagApprovazione(Character flagApprovazione) {
		this.flagApprovazione = flagApprovazione;
	}
	
	public boolean isRichiestaModifica() {
		return Common.CH_M.equals(this.getFlagApprovazione());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((vicepresidenza == null) ? 0 : vicepresidenza.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AccordoVicepresidenza))
			return false;
		AccordoVicepresidenza other = (AccordoVicepresidenza) obj;
		if (vicepresidenza == null) {
			if (other.vicepresidenza != null)
				return false;
		} else if (!vicepresidenza.equals(other.vicepresidenza))
			return false;
		return true;
	}

}

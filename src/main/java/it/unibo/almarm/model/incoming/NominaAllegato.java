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

import java.io.Serializable;

import it.unibo.almarm.util.Common;

public class NominaAllegato implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String idAllegato;
	private String nomeAllegato;
	private String descrizione;
	private Character flagVisibileAStudente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdAllegato() {
		return idAllegato;
	}

	public void setIdAllegato(String idAllegato) {
		this.idAllegato = idAllegato;
	}

	public String getNomeAllegato() {
		return nomeAllegato;
	}

	public void setNomeAllegato(String nomeAllegato) {
		this.nomeAllegato = nomeAllegato;
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
		result = prime * result
				+ ((idAllegato == null) ? 0 : idAllegato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NominaAllegato))
			return false;
		NominaAllegato other = (NominaAllegato) obj;
		if (idAllegato == null) {
			if (other.idAllegato != null)
				return false;
		} else if (!idAllegato.equals(other.idAllegato))
			return false;
		return true;
	}

	public Character getFlagVisibileAStudente() {
		if (flagVisibileAStudente == null)
			return 'N';
		return flagVisibileAStudente;
	}

	public void setFlagVisibileAStudente(Character flagVisibileAStudente) {
		this.flagVisibileAStudente = flagVisibileAStudente;
	}
	
	public boolean isVisibileAStudente() {
		return Common.CH_S.equals(getFlagVisibileAStudente());
	}

}

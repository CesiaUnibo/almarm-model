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
package it.unibo.almarm.model.flussiscambio;

public class ProgrammaCodificaAreeDisciplinari implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private CodificaAreaDisciplinare codifica;
	private Long codificaDidefault;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CodificaAreaDisciplinare getCodifica() {
		return codifica;
	}
	public void setCodifica(CodificaAreaDisciplinare codifica) {
		this.codifica = codifica;
	}
	public Long getCodificaDidefault() {
		return codificaDidefault;
	}
	public void setCodificaDidefault(Long codificaDidefault) {
		this.codificaDidefault = codificaDidefault;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codifica == null) ? 0 : codifica.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProgrammaCodificaAreeDisciplinari))
			return false;
		ProgrammaCodificaAreeDisciplinari other = (ProgrammaCodificaAreeDisciplinari) obj;
		if (codifica == null) {
			if (other.codifica != null)
				return false;
		} else if (!codifica.equals(other.codifica))
			return false;
		return true;
	}	
}

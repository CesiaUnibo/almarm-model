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
package it.unibo.almarm.model.attori.studenti;

public class EsameId implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long progressivo;
	private String matricola;
	private Integer progressivoEsame;
	
	//private Integer pincode;
	//private Integer numeroCarriera;
	
	public EsameId() {
	}

	public java.lang.Long getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(java.lang.Long progressivo) {
		this.progressivo = progressivo;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Integer getProgressivoEsame() {
		return progressivoEsame;
	}

	public void setProgressivoEsame(Integer progressivoEsame) {
		this.progressivoEsame = progressivoEsame;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricola == null) ? 0 : matricola.hashCode());
		result = prime * result
				+ ((progressivo == null) ? 0 : progressivo.hashCode());
		result = prime
				* result
				+ ((progressivoEsame == null) ? 0 : progressivoEsame.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EsameId))
			return false;
		EsameId other = (EsameId) obj;
		if (matricola == null) {
			if (other.getMatricola() != null)
				return false;
		} else if (!matricola.equals(other.getMatricola()))
			return false;
		if (progressivo == null) {
			if (other.getProgressivo() != null)
				return false;
		} else if (!progressivo.equals(other.getProgressivo()))
			return false;
		if (progressivoEsame == null) {
			if (other.getProgressivoEsame() != null)
				return false;
		} else if (!progressivoEsame.equals(other.getProgressivoEsame()))
			return false;
		return true;
	}

}

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
package it.unibo.almarm.model.attori;

public class TipoStruttura implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private MacrotipoStruttura macrotipoStruttura;
	private String descrizioneBreve;
	private String descrizione;
	private String descrizioneStampabile;
	private String codicePerso;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MacrotipoStruttura getMacrotipoStruttura() {
		return macrotipoStruttura;
	}
	public void setMacrotipoStruttura(MacrotipoStruttura macrotipoStruttura) {
		this.macrotipoStruttura = macrotipoStruttura;
	}
	public String getDescrizioneBreve() {
		return descrizioneBreve;
	}
	public void setDescrizioneBreve(String descrizioneBreve) {
		this.descrizioneBreve = descrizioneBreve;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDescrizioneStampabile() {
		return descrizioneStampabile;
	}
	public void setDescrizioneStampabile(String descrizioneStampabile) {
		this.descrizioneStampabile = descrizioneStampabile;
	}
	public String getCodicePerso() {
		return codicePerso;
	}
	public void setCodicePerso(String codicePerso) {
		this.codicePerso = codicePerso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codicePerso == null) ? 0 : codicePerso.hashCode());
		result = prime
				* result
				+ ((descrizioneBreve == null) ? 0 : descrizioneBreve.hashCode());
		result = prime
				* result
				+ ((macrotipoStruttura == null) ? 0 : macrotipoStruttura
						.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipoStruttura))
			return false;
		final TipoStruttura other = (TipoStruttura) obj;
		if (codicePerso == null) {
			if (other.getCodicePerso() != null)
				return false;
		} else if (!codicePerso.equals(other.getCodicePerso()))
			return false;
		if (descrizioneBreve == null) {
			if (other.getDescrizioneBreve() != null)
				return false;
		} else if (!descrizioneBreve.equals(other.getDescrizioneBreve()))
			return false;
		if (macrotipoStruttura == null) {
			if (other.getMacrotipoStruttura() != null)
				return false;
		} else if (!macrotipoStruttura.equals(other.getMacrotipoStruttura()))
			return false;
		return true;
	}

}

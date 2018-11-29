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
package it.unibo.almarm.model.luoghi;

// Generated 18-gen-2008 12.52.20 by Hibernate Tools 3.2.0.CR1


/**
 * Regione generated by hbm2java
 */
public class Regione implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Nazione nazione;
	private String regione;
	private Long codRegAlma;
	private String codReg;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Nazione getNazione() {
		return this.nazione;
	}

	public void setNazione(Nazione nazione) {
		this.nazione = nazione;
	}
	
	public String getRegione() {
		return this.regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public Long getCodRegAlma() {
		return this.codRegAlma;
	}

	public void setCodRegAlma(Long codRegAlma) {
		this.codRegAlma = codRegAlma;
	}

	public String getCodReg() {
		return this.codReg;
	}

	public void setCodReg(String codReg) {
		this.codReg = codReg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regione == null) ? 0 : regione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Regione))
			return false;
		final Regione other = (Regione) obj;
		if (regione == null) {
			if (other.getRegione() != null)
				return false;
		} else if (!regione.equals(other.getRegione()))
			return false;
		return true;
	}

	
}
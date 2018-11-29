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
package it.unibo.almarm.model.lingue;

import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.util.Common;

public class SottoprogrammaLingua implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private Long id;
	private SottoProgramma  sottoProgramma;
	private Lingua	lingua;
	private Character flagAttiva;
	private Character flagLicenzaOlsAttiva;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SottoProgramma getSottoProgramma() {
		return sottoProgramma;
	}
	public void setSottoProgramma(SottoProgramma sottoProgramma) {
		this.sottoProgramma = sottoProgramma;
	}
	public Lingua getLingua() {
		return lingua;
	}
	public void setLingua(Lingua lingua) {
		this.lingua = lingua;
	}
	public Character getFlagAttiva() {
		return flagAttiva;
	}
	public void setFlagAttiva(Character flagAttiva) {
		this.flagAttiva = flagAttiva;
	}
	public boolean isAttiva() {
		return Common.CH_S.equals(getFlagAttiva());
	}
	public Character getFlagLicenzaOlsAttiva() {
		return flagLicenzaOlsAttiva;
	}
	public void setFlagLicenzaOlsAttiva(Character flagLicenzaOlsAttiva) {
		this.flagLicenzaOlsAttiva = flagLicenzaOlsAttiva;
	}
	public boolean isLicenzaOlsAttiva() {
		return Common.CH_S.equals(flagLicenzaOlsAttiva);
	}
}

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

import it.unibo.almarm.util.Common;

public class TipoDocumento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long 	id;
	private String  descrizione;
	private String  sigla;
	private Character flagTipoPassaporto;  
	private Character flagTipoCI;  
	private Character flagAttivo;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Character getFlagTipoPassaporto() {
		return flagTipoPassaporto;
	}
	public void setFlagTipoPassaporto(Character flagTipoPassaporto) {
		this.flagTipoPassaporto = flagTipoPassaporto;
	}
	public Character getFlagTipoCI() {
		return flagTipoCI;
	}
	public void setFlagTipoCI(Character flagTipoCI) {
		this.flagTipoCI = flagTipoCI;
	}
	public Character getFlagAttivo() {
		return flagAttivo;
	}
	public void setFlagAttivo(Character flagAttivo) {
		this.flagAttivo = flagAttivo;
	}  
	public boolean isAttivo() {
		return Common.CH_S.equals(flagAttivo);
	}
}

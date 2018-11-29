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

import it.unibo.almarm.util.Common;

public class DisponibilitaGruppo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private BandoGruppo bandoGruppo;
	private Integer posti;
	private Character flagGruppoAssegnatoCandidatura;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BandoGruppo getBandoGruppo() {
		return bandoGruppo;
	}

	public void setBandoGruppo(BandoGruppo bandoGruppo) {
		this.bandoGruppo = bandoGruppo;
	}

	public Integer getPosti() {
		return posti;
	}

	public void setPosti(Integer posti) {
		this.posti = posti;
	}

	public boolean isAggiungePosti() {
		return bandoGruppo == null || getBandoGruppo().isAggiungePosti();
	}

	public Character getFlagGruppoAssegnatoCandidatura() {
		return flagGruppoAssegnatoCandidatura;
	}

	public void setFlagGruppoAssegnatoCandidatura(
			Character flagGruppoAssegnatoCandidatura) {
		this.flagGruppoAssegnatoCandidatura = flagGruppoAssegnatoCandidatura;
	}	
    
	public boolean isGruppoAssegnatoCandidatura() {
		return Common.CH_S.equals(flagGruppoAssegnatoCandidatura);
	}
	
}

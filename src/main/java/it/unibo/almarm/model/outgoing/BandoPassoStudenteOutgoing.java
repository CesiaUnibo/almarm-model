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

public class BandoPassoStudenteOutgoing implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private static final Character TARGET_TUTTI = Common.CH_T;
	private static final Character TARGET_BANDO = Common.CH_B;
	private static final Character TARGET_GRUPPO = Common.CH_G;

	private Long id;
	private Bando bando;
	private PassoStudenteOutgoing passoStudenteOutgoing;
	private Character flagTarget;
	private BandoGruppo bandoGruppo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bando getBando() {
		return bando;
	}

	public void setBando(Bando bando) {
		this.bando = bando;
	}
	
	public PassoStudenteOutgoing getPassoStudenteOutgoing() {
		return passoStudenteOutgoing;
	}

	public void setPassoStudenteOutgoing(PassoStudenteOutgoing passoStudenteOutgoing) {
		this.passoStudenteOutgoing = passoStudenteOutgoing;
	}
	
	public Character getFlagTarget() {
		return flagTarget;
	}

	public void setFlagTarget(Character flagTarget) {
		this.flagTarget = flagTarget;
	}

	public BandoGruppo getBandoGruppo() {
		return bandoGruppo;
	}

	public void setBandoGruppo(BandoGruppo bandoGruppo) {
		this.bandoGruppo = bandoGruppo;
	}
	
	public boolean isAttivo(Long idBando , Long idGruppo){
		if (TARGET_TUTTI.equals(flagTarget))
			return true;
		
		if (TARGET_GRUPPO.equals(flagTarget)) 
			return idGruppo != null && getBandoGruppo()!= null && idGruppo.equals(getBandoGruppo().getId());
		
		if (TARGET_BANDO.equals(flagTarget)) 
			return idGruppo == null;
		
		return false;
	}
}

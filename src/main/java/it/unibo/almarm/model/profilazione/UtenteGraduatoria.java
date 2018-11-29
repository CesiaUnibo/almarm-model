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
package it.unibo.almarm.model.profilazione;

import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.outgoing.DisponibilitaView;
import it.unibo.almarm.util.Common;

public class UtenteGraduatoria implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Persona persona;
	private DisponibilitaView disponibilitaView;
	private Character diritto;
	private Character flagPuoChiudere;
	private Character flagPresidenteCommissione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public DisponibilitaView getDisponibilitaView() {
		return disponibilitaView;
	}

	public void setDisponibilitaView(DisponibilitaView disponibilita) {
		this.disponibilitaView = disponibilita;
	}

	public Character getDiritto() {
		return diritto;
	}

	public void setDiritto(Character diritto) {
		this.diritto = diritto;
	}
	
	public boolean isSolaLettura() {
		return Common.CH_R.equals(diritto);
	}

	public Character getFlagPuoChiudere() {
		return flagPuoChiudere;
	}

	public void setFlagPuoChiudere(Character flagPuoChiudere) {
		this.flagPuoChiudere = flagPuoChiudere;
	}
	
	public boolean isPuoChiudere() {
		return Common.CH_S.equals(flagPuoChiudere);
	}

	public Character getFlagPresidenteCommissione() {
		return flagPresidenteCommissione;
	}

	public void setFlagPresidenteCommissione(Character flagPresidenteCommissione) {
		this.flagPresidenteCommissione = flagPresidenteCommissione;
	}
}

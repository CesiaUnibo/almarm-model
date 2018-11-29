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

import it.kion.plitvice.autorizzazioni.model.RuoloAggregato;
import it.unibo.almarm.model.attori.Persona;

public class UtenteContesto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Contesto contesto;
	private RuoloAggregato ruolo;
	private Persona persona;
	private Character flagDefault;
	
	// campi non persistiti
	private Character flagAutorizzazioneResponsabile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contesto getContesto() {
		return contesto;
	}

	public void setContesto(Contesto contesto) {
		this.contesto = contesto;
	}

	public RuoloAggregato getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloAggregato ruolo) {
		this.ruolo = ruolo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Character getFlagDefault() {
		if (flagDefault == null)
			return 'N';
		return flagDefault;
	}

	public void setFlagDefault(Character flagDefault) {
		this.flagDefault = flagDefault;
	}
	
	public boolean isDefault() {
		return (new Character('S')).equals(flagDefault);
	}

	public Character getFlagAutorizzazioneResponsabile() {
		return flagAutorizzazioneResponsabile;
	}

	public void setFlagAutorizzazioneResponsabile(
			Character flagAutorizzazioneResponsabile) {
		this.flagAutorizzazioneResponsabile = flagAutorizzazioneResponsabile;
	}
}

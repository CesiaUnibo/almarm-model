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
package it.unibo.almarm.model.configurazione;

import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.util.Common;

public class ConfigurazionePersonale implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Persona persona;
	private Character flagRiceviEmailPresentazioneLAComeCoordinatore = 'S';
	private Character flagRiceviEmailValidazioneLAComeCoordinatore = 'S';
	private Character flagRiceviEmailRichiestaApprovazioneVisiting = 'S';
	private Character flagRiceviEmailApprovazioneRifiutoVisiting = 'S';
	private Character flagRiceviEmailRichiestaApprovazioneProlungamentoVisiting = 'S';
	private Character flagRiceviEmailApprovazioneRifiutoProlungamentoVisiting = 'S';

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

	public Character getFlagRiceviEmailPresentazioneLAComeCoordinatore() {
		return flagRiceviEmailPresentazioneLAComeCoordinatore;
	}

	public void setFlagRiceviEmailPresentazioneLAComeCoordinatore(
			Character flagRiceviEmailPresentazioneLAComeCoordinatore) {
		this.flagRiceviEmailPresentazioneLAComeCoordinatore = flagRiceviEmailPresentazioneLAComeCoordinatore;
	}
	
	public boolean isRiceviEmailPresentazioneLAComeCoordinatore() {
		return Common.CH_S.equals(getFlagRiceviEmailPresentazioneLAComeCoordinatore());
	}

	public Character getFlagRiceviEmailValidazioneLAComeCoordinatore() {
		return flagRiceviEmailValidazioneLAComeCoordinatore;
	}

	public void setFlagRiceviEmailValidazioneLAComeCoordinatore(
			Character flagRiceviEmailValidazioneLAComeCoordinatore) {
		this.flagRiceviEmailValidazioneLAComeCoordinatore = flagRiceviEmailValidazioneLAComeCoordinatore;
	}
	
	public boolean isRiceviEmailValidazioneLAComeCoordinatore() {
		return Common.CH_S.equals(getFlagRiceviEmailValidazioneLAComeCoordinatore());
	}

	public Character getFlagRiceviEmailRichiestaApprovazioneVisiting() {
		return flagRiceviEmailRichiestaApprovazioneVisiting;
	}

	public void setFlagRiceviEmailRichiestaApprovazioneVisiting(Character flagRiceviEmailRichiestaApprovazioneVisiting) {
		this.flagRiceviEmailRichiestaApprovazioneVisiting = flagRiceviEmailRichiestaApprovazioneVisiting;
	}
	
	public boolean isRiceviEmailRichiestaApprovazioneVisiting() {
		return Common.CH_S.equals(getFlagRiceviEmailRichiestaApprovazioneVisiting());
	}

	public Character getFlagRiceviEmailApprovazioneRifiutoVisiting() {
		return flagRiceviEmailApprovazioneRifiutoVisiting;
	}

	public void setFlagRiceviEmailApprovazioneRifiutoVisiting(Character flagRiceviEmailApprovazioneRifiutoVisiting) {
		this.flagRiceviEmailApprovazioneRifiutoVisiting = flagRiceviEmailApprovazioneRifiutoVisiting;
	}
	
	public boolean isRiceviEmailApprovazioneRifiutoVisiting() {
		return Common.CH_S.equals(getFlagRiceviEmailApprovazioneRifiutoVisiting());
	}

	public Character getFlagRiceviEmailRichiestaApprovazioneProlungamentoVisiting() {
		return flagRiceviEmailRichiestaApprovazioneProlungamentoVisiting;
	}

	public void setFlagRiceviEmailRichiestaApprovazioneProlungamentoVisiting(
			Character flagRiceviEmailRichiestaApprovazioneProlungamentoVisiting) {
		this.flagRiceviEmailRichiestaApprovazioneProlungamentoVisiting = flagRiceviEmailRichiestaApprovazioneProlungamentoVisiting;
	}
	
	public boolean isRiceviEmailRichiestaApprovazioneProlungamentoVisiting() {
		return Common.CH_S.equals(getFlagRiceviEmailRichiestaApprovazioneProlungamentoVisiting());
	}

	public Character getFlagRiceviEmailApprovazioneRifiutoProlungamentoVisiting() {
		return flagRiceviEmailApprovazioneRifiutoProlungamentoVisiting;
	}

	public void setFlagRiceviEmailApprovazioneRifiutoProlungamentoVisiting(
			Character flagRiceviEmailApprovazioneRifiutoProlungamentoVisiting) {
		this.flagRiceviEmailApprovazioneRifiutoProlungamentoVisiting = flagRiceviEmailApprovazioneRifiutoProlungamentoVisiting;
	}
	
	public boolean isRiceviEmailApprovazioneRifiutoProlungamentoVisiting() {
		return Common.CH_S.equals(getFlagRiceviEmailApprovazioneRifiutoProlungamentoVisiting());
	}
}

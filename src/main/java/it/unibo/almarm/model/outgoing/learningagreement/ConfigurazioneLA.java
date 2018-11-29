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
package it.unibo.almarm.model.outgoing.learningagreement;

import it.unibo.almarm.model.attori.Facolta;
import it.unibo.almarm.model.attori.Vicepresidenza;
import it.unibo.almarm.model.outgoing.Bando;
import it.unibo.almarm.util.Common;

public class ConfigurazioneLA implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Bando bando;
	private Facolta facolta;
	private String testoAlto;
	private String email;
	private String testoEmailReferente;
	private Character flagAmmetteUpload;
	private String testoAltoModLaApprovato;
	private String testoRicRicoAlto;
	private String testoRicRicoEmailReferente;
	private Character flagTRObbligatorioPerPresentazioneRicR;
	private Vicepresidenza vicepresidenza;
	private String emailCesena;
	private String emailForli;
	private String emailRavenna;
	private String emailRimini;
	private Character flagUploadSuAttivitaEstere;
	private Character flagAvvisoResponsabileScambio;
	private Character flagAvvisoResponsabileScambioRR;
	private Character flagSaltaValidazioneLA;
	private Character flagSaltaValidazioneRR;
	
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

	public Facolta getFacolta() {
		return facolta;
	}

	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}

	public String getTestoAlto() {
		return testoAlto;
	}

	public void setTestoAlto(String testoAlto) {
		this.testoAlto = testoAlto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTestoEmailReferente() {
		return testoEmailReferente;
	}

	public void setTestoEmailReferente(String testoEmailReferente) {
		this.testoEmailReferente = testoEmailReferente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bando == null) ? 0 : bando.hashCode());
		result = prime * result + ((facolta == null) ? 0 : facolta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ConfigurazioneLA))
			return false;
		ConfigurazioneLA other = (ConfigurazioneLA) obj;
		if (bando == null) {
			if (other.bando != null)
				return false;
		} else if (!bando.equals(other.bando))
			return false;
		if (facolta == null) {
			if (other.facolta != null)
				return false;
		} else if (!facolta.equals(other.facolta))
			return false;
		return true;
	}

	public boolean isAmmetteUpload() {
		return Common.CH_S.equals(flagAmmetteUpload);
	}

	public Character getFlagAmmetteUpload() {
		return flagAmmetteUpload;
	}

	public void setFlagAmmetteUpload(Character flagAmmetteUpload) {
		this.flagAmmetteUpload = flagAmmetteUpload;
	}

	public String getTestoAltoModLaApprovato() {
		return testoAltoModLaApprovato;
	}

	public void setTestoAltoModLaApprovato(String testoAltoModLaApprovato) {
		this.testoAltoModLaApprovato = testoAltoModLaApprovato;
	}

	public String getTestoRicRicoAlto() {
		return testoRicRicoAlto;
	}

	public void setTestoRicRicoAlto(String testoRicRicoAlto) {
		this.testoRicRicoAlto = testoRicRicoAlto;
	}

	public String getTestoRicRicoEmailReferente() {
		return testoRicRicoEmailReferente;
	}

	public void setTestoRicRicoEmailReferente(String testoRicRicoEmailReferente) {
		this.testoRicRicoEmailReferente = testoRicRicoEmailReferente;
	}

	public Character getFlagTRObbligatorioPerPresentazioneRicR() {
		return flagTRObbligatorioPerPresentazioneRicR;
	}

	public void setFlagTRObbligatorioPerPresentazioneRicR(
			Character flagTRObbligatorioPerPresentazioneRicR) {
		this.flagTRObbligatorioPerPresentazioneRicR = flagTRObbligatorioPerPresentazioneRicR;
	}
	
	public boolean isTRObbligatorioPerPresentazioneRicR() {
		return Common.CH_S.equals(getFlagTRObbligatorioPerPresentazioneRicR());
	}

	public Vicepresidenza getVicepresidenza() {
		return vicepresidenza;
	}

	public void setVicepresidenza(Vicepresidenza vicepresidenza) {
		this.vicepresidenza = vicepresidenza;
	}

	public String getEmailCesena() {
		return emailCesena;
	}

	public void setEmailCesena(String emailCesena) {
		this.emailCesena = emailCesena;
	}

	public String getEmailForli() {
		return emailForli;
	}

	public void setEmailForli(String emailForli) {
		this.emailForli = emailForli;
	}

	public String getEmailRavenna() {
		return emailRavenna;
	}

	public void setEmailRavenna(String emailRavenna) {
		this.emailRavenna = emailRavenna;
	}

	public String getEmailRimini() {
		return emailRimini;
	}

	public void setEmailRimini(String emailRimini) {
		this.emailRimini = emailRimini;
	}

	public String getEmailPolo(String siglaPolo) {
		if ("CE".equals(siglaPolo))
			return emailCesena;
		if ("FO".equals(siglaPolo))
			return emailForli;
		if ("RA".equals(siglaPolo))
			return emailRavenna;
		if ("RN".equals(siglaPolo))
			return emailRimini;
		return null;
	}

	public Character getFlagUploadSuAttivitaEstere() {
		return flagUploadSuAttivitaEstere;
	}

	public void setFlagUploadSuAttivitaEstere(Character flagUploadSuAttivitaEstere) {
		this.flagUploadSuAttivitaEstere = flagUploadSuAttivitaEstere;
	}
	
	public boolean isUploadSuAttivitaEstereAttivo() {
		return Common.CH_S.equals(getFlagUploadSuAttivitaEstere());
	}

	public Character getFlagAvvisoResponsabileScambio() {
		return flagAvvisoResponsabileScambio;
	}

	public void setFlagAvvisoResponsabileScambio(
			Character flagAvvisoResponsabileScambio) {
		this.flagAvvisoResponsabileScambio = flagAvvisoResponsabileScambio;
	}
	
	public boolean isAvvisoResponsabileScambioAttivo() {
		return Common.CH_S.equals(getFlagAvvisoResponsabileScambio());
	}

	public Character getFlagSaltaValidazioneLA() {
		return flagSaltaValidazioneLA;
	}

	public void setFlagSaltaValidazioneLA(Character flagSaltaValidazioneLA) {
		this.flagSaltaValidazioneLA = flagSaltaValidazioneLA;
	}
	
	public boolean isSaltaValidazioneLA() {
		return Common.CH_S.equals(getFlagSaltaValidazioneLA());
	}

	public Character getFlagSaltaValidazioneRR() {
		return flagSaltaValidazioneRR;
	}

	public void setFlagSaltaValidazioneRR(Character flagSaltaValidazioneRR) {
		this.flagSaltaValidazioneRR = flagSaltaValidazioneRR;
	}
	
	public boolean isSaltaValidazioneRR() {
		return Common.CH_S.equals(getFlagSaltaValidazioneRR());
	}

	public Character getFlagAvvisoResponsabileScambioRR() {
		return flagAvvisoResponsabileScambioRR;
	}

	public void setFlagAvvisoResponsabileScambioRR(Character flagAvvisoResponsabileScambioRR) {
		this.flagAvvisoResponsabileScambioRR = flagAvvisoResponsabileScambioRR;
	}

	public boolean isAvvisoResponsabileScambioRRAttivo() {
		return Common.CH_S.equals(getFlagAvvisoResponsabileScambioRR());
	}
}

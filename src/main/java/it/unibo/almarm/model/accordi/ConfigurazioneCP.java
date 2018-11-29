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
package it.unibo.almarm.model.accordi;

import it.unibo.almarm.model.flussiscambio.PeriodoMobilita;
import it.unibo.almarm.util.Common;

public class ConfigurazioneCP implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	// IDENTIFICAZIONE CONFIGURAZIONE 
	private Integer annoAccademicoInizioValidita; // Permette al contratto  di identificare la configurazione da usare
	private Programma programma;

	// SCELTA DURATA
	private Character flagAmmetteDurataBreve;
	private Integer annoAccademicoFineDurataBreve;
	private Integer annoAccademicoFineDurataIntera;
	
	// EMAIL POSSIBILI
	private String oggettoEmailRinnovo;
	private String testoEmailRinnovo;
	private String oggettoEmailNuovo;
	private String testoEmailNuovo;
	private String oggettoEmailRinnovoSenzaModifiche;
	private String testoEmailRinnovoSenzaModifiche;
	
	// TESTI PER LA PAGINA WEB DEL COINTRATTO 
	private String testoIntroduzioneIniziale;
	private String testoSezDurata;
	private String testoIntroduzioneInizialeNuovo;
	
	// CAMPI NON PERSISTITI
	
	// Se il campo (non persistito) annoAccademicoFineAccordo viene valorizzato la pagina di compilazione del contratto partner
	// tiene in considerazione l'anno di fine dell' anno accademico indicato come anno linmite per la durata lunga purchè tale anno
    // non sia inferiore alla durarta breve. Solo con la funzione di blocco della durata e' possibile forzare un termine 
	// inferiore alla durata breve.
	// I periodi possibili in definitiva sono: durata breve oppure durata lunga, dove la durata lunga termina al minore fra anno fine accordo
	// e anno di fine configurato nella durata lunga.
	 
	private Integer annoAccademicoFineAccordo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Programma getProgramma() {
		return programma;
	}
	public void setProgramma(Programma programma) {
		this.programma = programma;
	}
	public Integer getAnnoAccademicoInizioValidita() {
		return annoAccademicoInizioValidita;
	}
	public void setAnnoAccademicoInizioValidita(Integer annoAccademicoInizioValidita) {
		this.annoAccademicoInizioValidita = annoAccademicoInizioValidita;
	}
	
	public Character getFlagAmmetteDurataBreve() {
		return flagAmmetteDurataBreve;
	}
	public void setFlagAmmetteDurataBreve(Character flagAmmetteDurataBreve) {
		this.flagAmmetteDurataBreve = flagAmmetteDurataBreve;
	}
	public boolean isAmmetteDurataBreve() {
		return Common.CH_S.equals(flagAmmetteDurataBreve);
	}

	public Integer getAnnoAccademicoFineDurataBreve() {
		return annoAccademicoFineDurataBreve;
	}
	public void setAnnoAccademicoFineDurataBreve(
			Integer annoAccademicoFineDurataBreve) {
		this.annoAccademicoFineDurataBreve = annoAccademicoFineDurataBreve;
	}
	
	public Integer getAnnoAccademicoFineDurataIntera() {
		return annoAccademicoFineDurataIntera;
	}
	public void setAnnoAccademicoFineDurataIntera(
			Integer annoAccademicoFineDurataIntera) {
		this.annoAccademicoFineDurataIntera = annoAccademicoFineDurataIntera;
	}
	
	public String getOggettoEmailRinnovo() {
		return oggettoEmailRinnovo;
	}
	public void setOggettoEmailRinnovo(String oggettoEmailRinnovo) {
		this.oggettoEmailRinnovo = oggettoEmailRinnovo;
	}
	public String getTestoEmailRinnovo() {
		return testoEmailRinnovo;
	}
	public void setTestoEmailRinnovo(String testoEmailRinnovo) {
		this.testoEmailRinnovo = testoEmailRinnovo;
	}
	public String getOggettoEmailNuovo() {
		return oggettoEmailNuovo;
	}
	public void setOggettoEmailNuovo(String oggettoEmailNuovo) {
		this.oggettoEmailNuovo = oggettoEmailNuovo;
	}
	public String getTestoEmailNuovo() {
		return testoEmailNuovo;
	}
	public void setTestoEmailNuovo(String testoEmailNuovo) {
		this.testoEmailNuovo = testoEmailNuovo;
	}	
	public String getOggettoEmailRinnovoSenzaModifiche() {
		return oggettoEmailRinnovoSenzaModifiche;
	}
	public void setOggettoEmailRinnovoSenzaModifiche(
			String oggettoEmailRinnovoSenzaModifiche) {
		this.oggettoEmailRinnovoSenzaModifiche = oggettoEmailRinnovoSenzaModifiche;
	}
	public String getTestoEmailRinnovoSenzaModifiche() {
		return testoEmailRinnovoSenzaModifiche;
	}
	public void setTestoEmailRinnovoSenzaModifiche(
			String testoEmailRinnovoSenzaModifiche) {
		this.testoEmailRinnovoSenzaModifiche = testoEmailRinnovoSenzaModifiche;
	}
	public String getTestoIntroduzioneIniziale() {
		return testoIntroduzioneIniziale;
	}
	public void setTestoIntroduzioneIniziale(String testoIntroduzioneIniziale) {
		this.testoIntroduzioneIniziale = testoIntroduzioneIniziale;
	}

	public String getTestoIntroduzioneInizialeNuovo() {
		return testoIntroduzioneInizialeNuovo;
	}
	public void setTestoIntroduzioneInizialeNuovo(String testoIntroduzioneInizialeNuovo) {
		this.testoIntroduzioneInizialeNuovo = testoIntroduzioneInizialeNuovo;
	}
	
	public String getTestoSezDurata() {
		return testoSezDurata;
	}
	public void setTestoSezDurata(String testoSezDurata) {
		this.testoSezDurata = testoSezDurata;
	}

	// Campo non persistito  - serve nel calocoloo per durata intera dell' accordo
	public Integer getAnnoAccademicoFineAccordo() {
		return annoAccademicoFineAccordo;
	}
	
	public void setAnnoAccademicoFineAccordo(Integer annoAccademicoFineAccordo) {
		this.annoAccademicoFineAccordo = annoAccademicoFineAccordo;
	}

	public Integer getAnnoAccademicoLimiteDurataIntera() {
		if (annoAccademicoFineAccordo != null && annoAccademicoFineAccordo.intValue()<annoAccademicoFineDurataIntera.intValue())
		{
			if (isAmmetteDurataBreve() && annoAccademicoFineAccordo.intValue()< annoAccademicoFineDurataBreve.intValue())
				return annoAccademicoFineDurataBreve; // almeno i 3 anni sono da imporre
			return annoAccademicoFineAccordo;
		}	
		return annoAccademicoFineDurataIntera;
	}

	public Integer getAnnoAccademicoLimiteDurataBreve() {
		return annoAccademicoFineDurataBreve;
	}

	public boolean isAmmetteDurataBreveNelLimite(){
		return isAmmetteDurataBreve() && annoAccademicoFineDurataBreve != null && (annoAccademicoFineDurataBreve.intValue() <  getAnnoAccademicoLimiteDurataIntera().intValue());
	}
	
}

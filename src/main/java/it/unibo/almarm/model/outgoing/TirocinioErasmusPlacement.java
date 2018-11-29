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

import it.unibo.almarm.model.lingue.Lingua;
import it.unibo.almarm.model.luoghi.MTRegion;
import it.unibo.almarm.model.luoghi.Nazione;

import java.util.Date;

public class TirocinioErasmusPlacement implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private AziendaPlacement aziendaPlacement;
	private String settoreInserimento;
	private Integer durata;
    private Integer durataMax;
	private Integer oreSettimanali;
	private String periodoIndicativo;
	private Date dataInizioPrevista;
	private Date dataFinePrevista;
	private String sedeOperativa;
	private Character borsaStudio;
	private String nomeTutor;
	private String cognomeTutor;
	private String emailTutor;
	private Lingua linguaTirocinio;
	private String conoscenzeLinguistiche;
	private String conoscenzeInformatiche;
	private String note;
	private String oggetto;
	private String obiettivi;
	private String attivitaFormative;
	private String requisitiStudente;
	private String mansioneTirocinante;
	private String monitoraggioEPianoValutazione;
	private String beneficiTransnazionali;
	private String nomeSupervisore;
	private String cognomeSupervisore;
	private String telefonoSupervisore;
	private String emailSupervisore;
	private String nomeMentore;
	private String cognomeMentore;
	private String telefonoMentore;
	private String emailMentore;
	private String nomeContatto;
	private String cognomeContatto;
	private String telefonoContatto;
	private String emailContatto;
	private String monitoraggio;
	private String pianoDiValutazione;
	private String livelloLinguistico;
	private String capSedeOperativa;
	private String cittaSedeOperativa;
	private MTRegion regionSedeOperativa;
	private Nazione nazioneSedeOperativa;
	private String contestoArea;
	private String indirizzoCandidaturaEnte;
	private String scadenzaCandidaturaEnte;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AziendaPlacement getAziendaPlacement() {
		return aziendaPlacement;
	}

	public void setAziendaPlacement(AziendaPlacement aziendaPlacement) {
		this.aziendaPlacement = aziendaPlacement;
	}

	public String getSettoreInserimento() {
		return settoreInserimento;
	}

	public void setSettoreInserimento(String settoreInserimento) {
		this.settoreInserimento = settoreInserimento;
	}

	public Integer getDurata() {
		return durata;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	}

	public Integer getDurataMax() {
	    return durataMax;
    }

    public void setDurataMax(Integer durataMax) {
        this.durataMax = durataMax;
    }

	public Integer getOreSettimanali() {
		return oreSettimanali;
	}

	public void setOreSettimanali(Integer oreSettimanali) {
		this.oreSettimanali = oreSettimanali;
	}

	public String getPeriodoIndicativo() {
		return periodoIndicativo;
	}

	public void setPeriodoIndicativo(String periodoIndicativo) {
		this.periodoIndicativo = periodoIndicativo;
	}

	public Date getDataInizioPrevista() {
		return dataInizioPrevista;
	}

	public void setDataInizioPrevista(Date dataInizioPrevista) {
		this.dataInizioPrevista = dataInizioPrevista;
	}

	public Date getDataFinePrevista() {
		return dataFinePrevista;
	}

	public void setDataFinePrevista(Date dataFinePrevista) {
		this.dataFinePrevista = dataFinePrevista;
	}

	public String getSedeOperativa() {
		return sedeOperativa;
	}

	public void setSedeOperativa(String sedeOperativa) {
		this.sedeOperativa = sedeOperativa;
	}

	public Character getBorsaStudio() {
		return borsaStudio;
	}

	public void setBorsaStudio(Character borsaStudio) {
		this.borsaStudio = borsaStudio;
	}

	public String getNomeTutor() {
		return nomeTutor;
	}

	public void setNomeTutor(String nomeTutor) {
		this.nomeTutor = nomeTutor;
	}

	public String getCognomeTutor() {
		return cognomeTutor;
	}

	public void setCognomeTutor(String cognomeTutor) {
		this.cognomeTutor = cognomeTutor;
	}

	public String getEmailTutor() {
		return emailTutor;
	}

	public void setEmailTutor(String emailTutor) {
		this.emailTutor = emailTutor;
	}

	public Lingua getLinguaTirocinio() {
		return linguaTirocinio;
	}

	public void setLinguaTirocinio(Lingua linguaTirocinio) {
		this.linguaTirocinio = linguaTirocinio;
	}

	public String getConoscenzeLinguistiche() {
		return conoscenzeLinguistiche;
	}

	public void setConoscenzeLinguistiche(String conoscenzeLinguistiche) {
		this.conoscenzeLinguistiche = conoscenzeLinguistiche;
	}

	public String getConoscenzeInformatiche() {
		return conoscenzeInformatiche;
	}

	public void setConoscenzeInformatiche(String conoscenzeInformatiche) {
		this.conoscenzeInformatiche = conoscenzeInformatiche;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getObiettivi() {
		return obiettivi;
	}

	public void setObiettivi(String obiettivi) {
		this.obiettivi = obiettivi;
	}

	public String getAttivitaFormative() {
		return attivitaFormative;
	}

	public void setAttivitaFormative(String attivitaFormative) {
		this.attivitaFormative = attivitaFormative;
	}

	public String getRequisitiStudente() {
		return requisitiStudente;
	}

	public void setRequisitiStudente(String requisitiStudente) {
		this.requisitiStudente = requisitiStudente;
	}

	public String getMansioneTirocinante() {
		return mansioneTirocinante;
	}

	public void setMansioneTirocinante(String mansioneTirocinante) {
		this.mansioneTirocinante = mansioneTirocinante;
	}

	public String getMonitoraggioEPianoValutazione() {
		return monitoraggioEPianoValutazione;
	}

	public void setMonitoraggioEPianoValutazione(
			String monitoraggioEPianoValutazione) {
		this.monitoraggioEPianoValutazione = monitoraggioEPianoValutazione;
	}

	public String getBeneficiTransnazionali() {
		return beneficiTransnazionali;
	}

	public void setBeneficiTransnazionali(String beneficiTransnazionali) {
		this.beneficiTransnazionali = beneficiTransnazionali;
	}

	public String getNomeSupervisore() {
		return nomeSupervisore;
	}

	public void setNomeSupervisore(String nomeSupervisore) {
		this.nomeSupervisore = nomeSupervisore;
	}

	public String getCognomeSupervisore() {
		return cognomeSupervisore;
	}

	public void setCognomeSupervisore(String cognomeSupervisore) {
		this.cognomeSupervisore = cognomeSupervisore;
	}

	public String getTelefonoSupervisore() {
		return telefonoSupervisore;
	}

	public void setTelefonoSupervisore(String telefonoSupervisore) {
		this.telefonoSupervisore = telefonoSupervisore;
	}

	public String getEmailSupervisore() {
		return emailSupervisore;
	}

	public void setEmailSupervisore(String emailSupervisore) {
		this.emailSupervisore = emailSupervisore;
	}

	public String getNomeMentore() {
		return nomeMentore;
	}

	public void setNomeMentore(String nomeMentore) {
		this.nomeMentore = nomeMentore;
	}

	public String getCognomeMentore() {
		return cognomeMentore;
	}

	public void setCognomeMentore(String cognomeMentore) {
		this.cognomeMentore = cognomeMentore;
	}

	public String getTelefonoMentore() {
		return telefonoMentore;
	}

	public void setTelefonoMentore(String telefonoMentore) {
		this.telefonoMentore = telefonoMentore;
	}

	public String getEmailMentore() {
		return emailMentore;
	}

	public void setEmailMentore(String emailMentore) {
		this.emailMentore = emailMentore;
	}

	public String getNomeContatto() {
		return nomeContatto;
	}

	public void setNomeContatto(String nomeContatto) {
		this.nomeContatto = nomeContatto;
	}

	public String getCognomeContatto() {
		return cognomeContatto;
	}

	public void setCognomeContatto(String cognomeContatto) {
		this.cognomeContatto = cognomeContatto;
	}

	public String getTelefonoContatto() {
		return telefonoContatto;
	}

	public void setTelefonoContatto(String telefonoContatto) {
		this.telefonoContatto = telefonoContatto;
	}

	public String getEmailContatto() {
		return emailContatto;
	}

	public void setEmailContatto(String emailContatto) {
		this.emailContatto = emailContatto;
	}

	public String getMonitoraggio() {
		return monitoraggio;
	}

	public void setMonitoraggio(String monitoraggio) {
		this.monitoraggio = monitoraggio;
	}

	public String getPianoDiValutazione() {
		return pianoDiValutazione;
	}

	public void setPianoDiValutazione(String pianoDiValutazione) {
		this.pianoDiValutazione = pianoDiValutazione;
	}

	public String getLivelloLinguistico() {
		return livelloLinguistico;
	}

	public void setLivelloLinguistico(String livelloLinguistico) {
		this.livelloLinguistico = livelloLinguistico;
	}

	public String getCapSedeOperativa() {
		return capSedeOperativa;
	}

	public void setCapSedeOperativa(String capSedeOperativa) {
		this.capSedeOperativa = capSedeOperativa;
	}

	public String getCittaSedeOperativa() {
		return cittaSedeOperativa;
	}

	public void setCittaSedeOperativa(String cittaSedeOperativa) {
		this.cittaSedeOperativa = cittaSedeOperativa;
	}

	public MTRegion getRegionSedeOperativa() {
		return regionSedeOperativa;
	}

	public void setRegionSedeOperativa(MTRegion regionSedeOperativa) {
		this.regionSedeOperativa = regionSedeOperativa;
	}

	public Nazione getNazioneSedeOperativa() {
		return nazioneSedeOperativa;
	}

	public void setNazioneSedeOperativa(Nazione nazioneSedeOperativa) {
		this.nazioneSedeOperativa = nazioneSedeOperativa;
	}

	public String getContestoArea() {
		return contestoArea;
	}

	public void setContestoArea(String contestoArea) {
		this.contestoArea = contestoArea;
	}

	public String getIndirizzoCandidaturaEnte() {
		return indirizzoCandidaturaEnte;
	}

	public void setIndirizzoCandidaturaEnte(String indirizzoCandidaturaEnte) {
		this.indirizzoCandidaturaEnte = indirizzoCandidaturaEnte;
	}

	public String getScadenzaCandidaturaEnte() {
		return scadenzaCandidaturaEnte;
	}

	public void setScadenzaCandidaturaEnte(String scadenzaCandidaturaEnte) {
		this.scadenzaCandidaturaEnte = scadenzaCandidaturaEnte;
	}
}

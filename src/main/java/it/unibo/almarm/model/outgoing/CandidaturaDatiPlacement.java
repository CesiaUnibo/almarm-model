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

import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.esterni.MTOrganisationType;
import it.unibo.almarm.model.esterni.RangeNumeroDipendenti;
import it.unibo.almarm.model.esterni.TipoEntitaEsterna;
import it.unibo.almarm.model.lingue.Lingua;
import it.unibo.almarm.model.luoghi.MTRegion;
import it.unibo.almarm.model.luoghi.Nazione;
import it.unibo.almarm.util.Common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class CandidaturaDatiPlacement implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Candidatura candidatura;
	// dati azienda
	private String denominazioneAzienda;
	private String identificativoNazionale;
	private String descrizioneAttivitaAzienda;
	private TipoEntitaEsterna tipoAzienda;
	private Set<CandidaturaAziendaSettore> aziendaSettori = new HashSet<CandidaturaAziendaSettore>();
	private Set<CandidaturaAziendaSettoreNace> aziendaSettoriNace = new HashSet<CandidaturaAziendaSettoreNace>();
	private String nomeRappresentanteLegaleAzienda;
	private String cognomeRappresentanteLegaleAzienda;
	private Nazione nazionalitaAzienda;
	private String cittaSedeLegaleAzienda;
	private String capSedeLegaleAzienda;
	private String sedeLegaleAzienda;
	private String telefonoAzienda;
	private String faxAzienda;
	private String emailAzienda;
	private String sitoWebAzienda;
	private String noteAzienda;
	private RangeNumeroDipendenti rangeNumeroDipendenti;
	// dati tirocinio
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
	private String settoreInserimento;
	private Integer durata;
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
	private String monitoraggio;
	private String pianoDiValutazione;
	private Character flagMenoDi250Impiegati;
	private Integer picNumber;
	private MTOrganisationType organisationType;
	private Character flagPublicBody;
	private Character flagNonProfit;
	private MTRegion region;
	private Ateneo ateneo;
	private String erasmusCode;
	private String livelloLinguistico;
	private String capSedeOperativa;
	private String cittaSedeOperativa;
	private MTRegion regionSedeOperativa;
	private Nazione nazioneSedeOperativa;
	private String idMTAzienda;
	private String contestoArea;
	
	// campo utilizzato per le tesi all'estero
	private Double importoBorsa;

	// campi non persistiti
	private List<String> settori;
	private String sceltaCodiceErasmus;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Candidatura getCandidatura() {
		return candidatura;
	}
	
	public void setCandidatura(Candidatura candidatura) {
		this.candidatura = candidatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((candidatura == null) ? 0 : candidatura.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CandidaturaDatiPlacement))
			return false;
		CandidaturaDatiPlacement other = (CandidaturaDatiPlacement) obj;
		if (candidatura == null) {
			if (other.candidatura != null)
				return false;
		} else if (!candidatura.equals(other.candidatura))
			return false;
		return true;
	}

	public String getDenominazioneAzienda() {
		return denominazioneAzienda;
	}

	public void setDenominazioneAzienda(String denominazioneAzienda) {
		this.denominazioneAzienda = denominazioneAzienda;
	}

	public String getIdentificativoNazionale() {
		return identificativoNazionale;
	}

	public void setIdentificativoNazionale(String identificativoNazionale) {
		this.identificativoNazionale = identificativoNazionale;
	}

	public String getDescrizioneAttivitaAzienda() {
		return descrizioneAttivitaAzienda;
	}

	public void setDescrizioneAttivitaAzienda(String descrizioneAttivitaAzienda) {
		this.descrizioneAttivitaAzienda = descrizioneAttivitaAzienda;
	}

	public TipoEntitaEsterna getTipoAzienda() {
		return tipoAzienda;
	}

	public void setTipoAzienda(TipoEntitaEsterna tipoAzienda) {
		this.tipoAzienda = tipoAzienda;
	}

	public Set<CandidaturaAziendaSettore> getAziendaSettori() {
		return aziendaSettori;
	}

	public void setAziendaSettori(Set<CandidaturaAziendaSettore> aziendaSettori) {
		this.aziendaSettori = aziendaSettori;
	}
	
	public List<String> getSettori() {
		if (settori == null)
		{
			settori = new ArrayList<String>();
			if (candidatura.getBando().getSottoProgramma().getProgramma().isErasmusPlus())
				for (CandidaturaAziendaSettoreNace cas: getAziendaSettoriNace())
					settori.add(cas.getSettoreAttivitaNace().getId());
			else
				for (CandidaturaAziendaSettore cas: getAziendaSettori())
					settori.add(cas.getSettoreAttivita().getId().toString());
		}
		return settori;
	}
	
	public void setSettori(List<String> settori) {
		this.settori = settori;
		if (this.settori == null)
			this.settori = new ArrayList<String>();
	}
	
	public String getNomeRappresentanteLegaleAzienda() {
		return nomeRappresentanteLegaleAzienda;
	}

	public void setNomeRappresentanteLegaleAzienda(
			String nomeRappresentanteLegaleAzienda) {
		this.nomeRappresentanteLegaleAzienda = nomeRappresentanteLegaleAzienda;
	}

	public String getCognomeRappresentanteLegaleAzienda() {
		return cognomeRappresentanteLegaleAzienda;
	}

	public void setCognomeRappresentanteLegaleAzienda(
			String cognomeRappresentanteLegaleAzienda) {
		this.cognomeRappresentanteLegaleAzienda = cognomeRappresentanteLegaleAzienda;
	}

	public Nazione getNazionalitaAzienda() {
		return nazionalitaAzienda;
	}

	public void setNazionalitaAzienda(Nazione nazionalitaAzienda) {
		this.nazionalitaAzienda = nazionalitaAzienda;
	}

	public String getSedeLegaleAzienda() {
		return sedeLegaleAzienda;
	}

	public void setSedeLegaleAzienda(String sedeLegaleAzienda) {
		this.sedeLegaleAzienda = sedeLegaleAzienda;
	}

	public String getTelefonoAzienda() {
		return telefonoAzienda;
	}

	public void setTelefonoAzienda(String telefonoAzienda) {
		this.telefonoAzienda = telefonoAzienda;
	}

	public String getFaxAzienda() {
		return faxAzienda;
	}

	public void setFaxAzienda(String faxAzienda) {
		this.faxAzienda = faxAzienda;
	}

	public String getEmailAzienda() {
		return emailAzienda;
	}

	public void setEmailAzienda(String emailAzienda) {
		this.emailAzienda = emailAzienda != null ? emailAzienda.trim() : emailAzienda;
	}

	public String getSitoWebAzienda() {
		return sitoWebAzienda;
	}

	public void setSitoWebAzienda(String sitoWebAzienda) {
		this.sitoWebAzienda = sitoWebAzienda;
	}

	public String getNoteAzienda() {
		return noteAzienda;
	}

	public void setNoteAzienda(String noteAzienda) {
		this.noteAzienda = noteAzienda;
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
	
	public boolean isConBorsaStudio() {
		return Common.CH_S.equals(getBorsaStudio());
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
		this.emailTutor = emailTutor != null ? emailTutor.trim() : emailTutor;
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

	public RangeNumeroDipendenti getRangeNumeroDipendenti() {
		return rangeNumeroDipendenti;
	}

	public void setRangeNumeroDipendenti(RangeNumeroDipendenti rangeNumeroDipendenti) {
		this.rangeNumeroDipendenti = rangeNumeroDipendenti;
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
		if (StringUtils.isNotBlank(emailSupervisore))
			emailSupervisore = emailSupervisore.trim();
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
		if (StringUtils.isNotBlank(emailMentore))
			emailMentore = emailMentore.trim();
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
		if (StringUtils.isNotBlank(emailContatto))
			emailContatto = emailContatto.trim();
		this.emailContatto = emailContatto;
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

	public Set<CandidaturaAziendaSettoreNace> getAziendaSettoriNace() {
		return aziendaSettoriNace;
	}

	public void setAziendaSettoriNace(
			Set<CandidaturaAziendaSettoreNace> aziendaSettoriNace) {
		this.aziendaSettoriNace = aziendaSettoriNace;
	}

	public String getCittaSedeLegaleAzienda() {
		return cittaSedeLegaleAzienda;
	}

	public void setCittaSedeLegaleAzienda(String cittaSedeLegaleAzienda) {
		this.cittaSedeLegaleAzienda = cittaSedeLegaleAzienda;
	}

	public String getCapSedeLegaleAzienda() {
		return capSedeLegaleAzienda;
	}

	public void setCapSedeLegaleAzienda(String capSedeLegaleAzienda) {
		this.capSedeLegaleAzienda = capSedeLegaleAzienda;
	}

	public Character getFlagMenoDi250Impiegati() {
		return flagMenoDi250Impiegati;
	}

	public void setFlagMenoDi250Impiegati(Character flagMenoDi250Impiegati) {
		this.flagMenoDi250Impiegati = flagMenoDi250Impiegati;
	}

	public Integer getPicNumber() {
		return picNumber;
	}

	public void setPicNumber(Integer picNumber) {
		this.picNumber = picNumber;
	}

	public MTOrganisationType getOrganisationType() {
		return organisationType;
	}

	public void setOrganisationType(MTOrganisationType organisationType) {
		this.organisationType = organisationType;
	}

	public Character getFlagPublicBody() {
		return flagPublicBody;
	}

	public void setFlagPublicBody(Character flagPublicBody) {
		this.flagPublicBody = flagPublicBody;
	}

	public Character getFlagNonProfit() {
		return flagNonProfit;
	}

	public void setFlagNonProfit(Character flagNonProfit) {
		this.flagNonProfit = flagNonProfit;
	}

	public MTRegion getRegion() {
		return region;
	}

	public void setRegion(MTRegion region) {
		this.region = region;
	}

	public Ateneo getAteneo() {
		return ateneo;
	}

	public void setAteneo(Ateneo ateneo) {
		this.ateneo = ateneo;
	}

	public String getErasmusCode() {
		return erasmusCode;
	}

	public void setErasmusCode(String erasmusCode) {
		this.erasmusCode = erasmusCode;
	}

	public String getSceltaCodiceErasmus() {
		return sceltaCodiceErasmus;
	}

	public void setSceltaCodiceErasmus(String sceltaCodiceErasmus) {
		this.sceltaCodiceErasmus = sceltaCodiceErasmus;
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

	public String getIdMTAzienda() {
		return idMTAzienda;
	}

	public void setIdMTAzienda(String idMTAzienda) {
		this.idMTAzienda = idMTAzienda;
	}

	public String getContestoArea() {
		return contestoArea;
	}

	public void setContestoArea(String contestoArea) {
		this.contestoArea = contestoArea;
	}

	public String getPartnerErasmusCode() {
		return ateneo!= null ? ateneo.getCodiceErasmus() : erasmusCode;
	}

	public Double getImportoBorsa() {
		return importoBorsa;
	}

	public void setImportoBorsa(Double importoBorsa) {
		this.importoBorsa = importoBorsa;
	}

}

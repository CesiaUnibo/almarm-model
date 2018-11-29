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
package it.unibo.almarm.model.flussiscambio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import edu.emory.mathcs.backport.java.util.Collections;

import it.unibo.almarm.model.accordi.AccordoOperativo;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.incoming.StudenteIncomingAllegato;
import it.unibo.almarm.model.lingue.Lingua;
import it.unibo.almarm.util.Common;

public class EsecuzioneAccordo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private AccordoOperativo accordoOperativo;
	private PeriodoMobilita periodoMobilita;
	private CodificaAreaDisciplinare CodificaAreaDisciplinare;
	private String stato;
	private Character attivazione;
	private Date dataAttivazione;
	private Persona utenteAttivazione;
	private Date dataPresaInCarica;
	private Persona utentePresaInCarica;
	private Date dataStipulaRinnovo;
	private Persona utenteStipulaRinnovo;
	private Date dataInvioAlPartner;
	private Persona utenteInvioAlPartner;
	private Character flagModificato;
	private Date dataUltimaModifica;
	private Persona autoreUltimaModifica;
	private Character flagCCRinnovoSpecifico;
	private String denominazioneContattoRinnovo;
	private String emailContattoRinnovo;
	private String telefonoContattoRinnovo;
	private String faxContattoRinnovo;
	private Persona referenteOperativo;
	private String idDocumentoStipula;
	private String nomeDocumentoStipula;
	private Date dataRifiuto;
	private Persona utenteRifiuto;
	private transient MultipartFile documentoStipula; 
	private Date scadenzaNomineCiclo1;
	private Date scadenzaNomineCiclo2;
	private Date scadenzaRegistrazioneCiclo1;
	private Date scadenzaRegistrazioneCiclo2;
	private Lingua linguaRichiesta;
	private String livelloLinguaRichiesta;
	private String noteAteneoPartner;
	private Lingua linguaSecondaria;
	
	private Character flagAnnualizzatoDaPrecedente;
	private Character flagNomineOnline;
	private Date dataModificaInfoSheet;
	private Character flagRinnovatoTacitamente;
	private String noteOperatore;
	
	private String idDocumentoInfoSheet;
	private String nomeDocumentoInfoSheet;
	
	private String tipoAttivazione;
	private Character flagModDocenteAttiva;
	private Character flagNonRinnovareDocenteAttiva;
	EsecuzioneAccordoView esecuzioneAccordoView;
	private String sitoNomineOnline;
	private Date dataCopiaDatiDaInfoSheet;
	private Date dataControlloAvvisoInfoSheet;
	
	// non persistiti
	private Character flagModificaConcordata;
	//private Character flagProroga;
	
	// transient
	private transient MultipartFile documentoInfoSheet;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AccordoOperativo getAccordoOperativo() {
		return accordoOperativo;
	}
	public void setAccordoOperativo(AccordoOperativo accordoOperativo) {
		this.accordoOperativo = accordoOperativo;
	}
	public PeriodoMobilita getPeriodoMobilita() {
		return periodoMobilita;
	}
	public void setPeriodoMobilita(PeriodoMobilita periodoMobilita) {
		this.periodoMobilita = periodoMobilita;
	}	
	public CodificaAreaDisciplinare getCodificaAreaDisciplinare() {
		return CodificaAreaDisciplinare;
	}
	public void setCodificaAreaDisciplinare(
			CodificaAreaDisciplinare codificaAreaDisciplinare) {
		CodificaAreaDisciplinare = codificaAreaDisciplinare;
	}
	
	public String getStato() {
		if (StringUtils.isBlank(stato))
			return StatoEsecuzioneAccordo.INIZIALE.getValore();
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public Character getAttivazione() {
		return attivazione;
	}
	public void setAttivazione(Character attivazione) {
		this.attivazione = attivazione;
	}
	public Date getDataAttivazione() {
		return dataAttivazione;
	}
	public void setDataAttivazione(Date dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}
	public Persona getUtenteAttivazione() {
		return utenteAttivazione;
	}
	public void setUtenteAttivazione(Persona utenteAttivazione) {
		this.utenteAttivazione = utenteAttivazione;
	}
	public Date getDataPresaInCarica() {
		return dataPresaInCarica;
	}
	public void setDataPresaInCarica(Date dataPresaInCarica) {
		this.dataPresaInCarica = dataPresaInCarica;
	}
	public Persona getUtentePresaInCarica() {
		return utentePresaInCarica;
	}
	public void setUtentePresaInCarica(Persona utentePresaInCarica) {
		this.utentePresaInCarica = utentePresaInCarica;
	}
	public Date getDataStipulaRinnovo() {
		return dataStipulaRinnovo;
	}
	public void setDataStipulaRinnovo(Date dataStipulaRinnovo) {
		this.dataStipulaRinnovo = dataStipulaRinnovo;
	}
	public Persona getUtenteStipulaRinnovo() {
		return utenteStipulaRinnovo;
	}
	public void setUtenteStipulaRinnovo(Persona utenteStipulaRinnovo) {
		this.utenteStipulaRinnovo = utenteStipulaRinnovo;
	}
	public Date getDataInvioAlPartner() {
		return dataInvioAlPartner;
	}
	public void setDataInvioAlPartner(Date dataInvioAlPartner) {
		this.dataInvioAlPartner = dataInvioAlPartner;
	}
	public Persona getUtenteInvioAlPartner() {
		return utenteInvioAlPartner;
	}
	public void setUtenteInvioAlPartner(Persona utenteInvioAlPartner) {
		this.utenteInvioAlPartner = utenteInvioAlPartner;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((accordoOperativo == null) ? 0 : accordoOperativo.hashCode());
		result = prime * result
				+ ((periodoMobilita == null) ? 0 : periodoMobilita.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EsecuzioneAccordo))
			return false;
		EsecuzioneAccordo other = (EsecuzioneAccordo) obj;
		if (accordoOperativo == null) {
			if (other.getAccordoOperativo() != null)
				return false;
		} else if (!accordoOperativo.equals(other.getAccordoOperativo()))
			return false;
		if (periodoMobilita == null) {
			if (other.getPeriodoMobilita() != null)
				return false;
		} else if (!periodoMobilita.equals(other.getPeriodoMobilita()))
			return false;
		return true;
	}
	
	public String getColor() {
		return StatoEsecuzioneAccordo.get(getStato()).getColor();
	}
	
	public String getColorDesc() {
		return StatoEsecuzioneAccordo.get(getStato()).getMessageKey();
	}

	public String getColorAttivazione() {
		return Attivazione.getAttivazione(getAttivazione()).getColorAttivazione();
	}
	
	public String getColorDescAttivazione() {
		return Attivazione.getAttivazione(getAttivazione()).getMessageKey();
	}
	
	public boolean isIniziale() {
		return StatoEsecuzioneAccordo.INIZIALE.getValore().equals(getStato());
	}
	
	public boolean isNonDaRinnovare() {
		return StatoEsecuzioneAccordo.NON_DA_RINNOVARE.getValore().equals(getStato());
	}
	
	public boolean isDaRinnovare() {
		return !(StatoEsecuzioneAccordo.NON_DA_RINNOVARE.getValore().equals(getStato()) || StatoEsecuzioneAccordo.INIZIALE.getValore().equals(getStato())) ;
	}
	
	public Character getFlagModificato() {
		if (flagModificato == null)
			return 'N';
		return flagModificato;
	}
	public void setFlagModificato(Character flagModificato) {
		this.flagModificato = flagModificato;
	}
	 public boolean isModificato() {
		 return Common.CH_S.equals(flagModificato);
	 }
	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}
	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}
	public Persona getAutoreUltimaModifica() {
		return autoreUltimaModifica;
	}
	public void setAutoreUltimaModifica(Persona autoreUltimaModifica) {
		this.autoreUltimaModifica = autoreUltimaModifica;
	}
	public Character getFlagCCRinnovoSpecifico() {
		return flagCCRinnovoSpecifico;
	}
	public void setFlagCCRinnovoSpecifico(Character flagCCRinnovoSpecifico) {
		this.flagCCRinnovoSpecifico = flagCCRinnovoSpecifico;
	}
	public String getDenominazioneContattoRinnovo() {
		return denominazioneContattoRinnovo;
	}
	public void setDenominazioneContattoRinnovo(String denominazioneContattoRinnovo) {
		this.denominazioneContattoRinnovo = denominazioneContattoRinnovo;
	}
	public String getEmailContattoRinnovo() {
		return emailContattoRinnovo;
	}
	public void setEmailContattoRinnovo(String emailContattoRinnovo) {
		this.emailContattoRinnovo = emailContattoRinnovo;
	}
	public String getTelefonoContattoRinnovo() {
		return telefonoContattoRinnovo;
	}
	public void setTelefonoContattoRinnovo(String telefonoContattoRinnovo) {
		this.telefonoContattoRinnovo = telefonoContattoRinnovo;
	}
	public String getFaxContattoRinnovo() {
		return faxContattoRinnovo;
	}
	public void setFaxContattoRinnovo(String faxContattoRinnovo) {
		this.faxContattoRinnovo = faxContattoRinnovo;
	}
	public boolean isCCRinnovoSpecifico() {
		 return Common.CH_S.equals(flagCCRinnovoSpecifico);
	}
	public Persona getReferenteOperativo() {
		return referenteOperativo;
	}
	public void setReferenteOperativo(Persona referenteOperativo) {
		this.referenteOperativo = referenteOperativo;
	}
	public String getIdDocumentoStipula() {
		return idDocumentoStipula;
	}
	public void setIdDocumentoStipula(String idDocumentoStipula) {
		this.idDocumentoStipula = idDocumentoStipula;
	}
	public String getNomeDocumentoStipula() {
		return nomeDocumentoStipula;
	}
	public void setNomeDocumentoStipula(String nomeDocumentoStipula) {
		this.nomeDocumentoStipula = nomeDocumentoStipula;
	}
	public MultipartFile getDocumentoStipula() {
		return documentoStipula;
	}
	public void setDocumentoStipula(MultipartFile documentoStipula) {
		this.documentoStipula = documentoStipula;
	}
	public Date getDataRifiuto() {
		return dataRifiuto;
	}
	public void setDataRifiuto(Date dataRifiuto) {
		this.dataRifiuto = dataRifiuto;
	}
	public Persona getUtenteRifiuto() {
		return utenteRifiuto;
	}
	public void setUtenteRifiuto(Persona utenteRifiuto) {
		this.utenteRifiuto = utenteRifiuto;
	}
	public Date getScadenzaNomineCiclo1() {
		return scadenzaNomineCiclo1;
	}
	public void setScadenzaNomineCiclo1(Date scadenzaNomineCiclo1) {
		this.scadenzaNomineCiclo1 = scadenzaNomineCiclo1;
	}
	public Date getScadenzaNomineCiclo2() {
		return scadenzaNomineCiclo2;
	}
	public void setScadenzaNomineCiclo2(Date scadenzaNomineCiclo2) {
		this.scadenzaNomineCiclo2 = scadenzaNomineCiclo2;
	}
	public Date getScadenzaRegistrazioneCiclo1() {
		return scadenzaRegistrazioneCiclo1;
	}
	public void setScadenzaRegistrazioneCiclo1(Date scadenzaRegistrazioneCiclo1) {
		this.scadenzaRegistrazioneCiclo1 = scadenzaRegistrazioneCiclo1;
	}
	public Date getScadenzaRegistrazioneCiclo2() {
		return scadenzaRegistrazioneCiclo2;
	}
	public void setScadenzaRegistrazioneCiclo2(Date scadenzaRegistrazioneCiclo2) {
		this.scadenzaRegistrazioneCiclo2 = scadenzaRegistrazioneCiclo2;
	}
	public Lingua getLinguaRichiesta() {
		return linguaRichiesta;
	}
	public void setLinguaRichiesta(Lingua linguaRichiesta) {
		this.linguaRichiesta = linguaRichiesta;
	}
	public String getLivelloLinguaRichiesta() {
		return livelloLinguaRichiesta;
	}
	public void setLivelloLinguaRichiesta(String livelloLinguaRichiesta) {
		this.livelloLinguaRichiesta = livelloLinguaRichiesta;
	}
	public String getNoteAteneoPartner() {
		return noteAteneoPartner;
	}
	public void setNoteAteneoPartner(String noteAteneoPartner) {
		this.noteAteneoPartner = noteAteneoPartner;
	}
	public Lingua getLinguaSecondaria() {
		return linguaSecondaria;
	}
	public void setLinguaSecondaria(Lingua linguaSecondaria) {
		this.linguaSecondaria = linguaSecondaria;
	}
	
	public boolean isRinnovato() {
		return StatoEsecuzioneAccordo.RINNOVATO.getValore().equals(getStato());
	}
	public boolean isInRinnovo() {
		return !(   StatoEsecuzioneAccordo.NON_DA_RINNOVARE.getValore().equals(getStato()) 
				 || StatoEsecuzioneAccordo.RIFIUTATO.getValore().equals(getStato()) 
				 || StatoEsecuzioneAccordo.INIZIALE.getValore().equals(getStato())
				 || StatoEsecuzioneAccordo.RINNOVATO.getValore().equals(getStato()));
	}
	public boolean isRifiutato() {
		return StatoEsecuzioneAccordo.RIFIUTATO.getValore().equals(getStato());
	}
	public Character getFlagAnnualizzatoDaPrecedente() {
		return flagAnnualizzatoDaPrecedente;
	}
	
	public void setFlagAnnualizzatoDaPrecedente(
			Character flagAnnualizzatoDaPrecedente) {
		this.flagAnnualizzatoDaPrecedente = flagAnnualizzatoDaPrecedente;
	}
	
	public boolean isAnnualizzatoDaPrecedente() {
		return Common.CH_S.equals(flagAnnualizzatoDaPrecedente);
	}

	public Character getFlagNomineOnline() {
		return flagNomineOnline;
	}
	public void setFlagNomineOnline(Character flagNomineOnline) {
		this.flagNomineOnline = flagNomineOnline;
	}
	public boolean isNomineOnline() {
		return Common.CH_S.equals(flagNomineOnline);
	}
	
	public Date getDataModificaInfoSheet() {
		return dataModificaInfoSheet;
	}
	public void setDataModificaInfoSheet(Date dataModificaInfoSheet) {
		this.dataModificaInfoSheet = dataModificaInfoSheet;
	}
	
	public Character getFlagRinnovatoTacitamente() {
		return flagRinnovatoTacitamente;
	}
	public void setFlagRinnovatoTacitamente(Character flagRinnovatoTacitamente) {
		this.flagRinnovatoTacitamente = flagRinnovatoTacitamente;
	}
	public boolean isRinnovatoTacitamente() {
		return Common.CH_S.equals(flagRinnovatoTacitamente);
	}
	public String getNoteOperatore() {
		return noteOperatore;
	}
	public void setNoteOperatore(String noteOperatore) {
		this.noteOperatore = noteOperatore;
	}
	public Character getFlagModificaConcordata() {
		return flagModificaConcordata;
	}
	public void setFlagModificaConcordata(Character flagModificaConcordata) {
		this.flagModificaConcordata = flagModificaConcordata;
	}
	public String getIdDocumentoInfoSheet() {
		return idDocumentoInfoSheet;
	}
	public void setIdDocumentoInfoSheet(String idDocumentoInfoSheet) {
		this.idDocumentoInfoSheet = idDocumentoInfoSheet;
	}
	public String getNomeDocumentoInfoSheet() {
		return nomeDocumentoInfoSheet;
	}
	public void setNomeDocumentoInfoSheet(String nomeDocumentoInfoSheet) {
		this.nomeDocumentoInfoSheet = nomeDocumentoInfoSheet;
	}
	public MultipartFile getDocumentoInfoSheet() {
		return documentoInfoSheet;
	}
	public void setDocumentoInfoSheet(MultipartFile documentoInfoSheet) {
		this.documentoInfoSheet = documentoInfoSheet;
	}
	
	// 2012
	public String getTipoAttivazione() {
		return tipoAttivazione;
	}
	public void setTipoAttivazione(String tipoAttivazione) {
		this.tipoAttivazione = tipoAttivazione;
	}
	public Character getFlagModDocenteAttiva() {
		return flagModDocenteAttiva;
	}
	public void setFlagModDocenteAttiva(Character flagModDocenteAttiva) {
		this.flagModDocenteAttiva = flagModDocenteAttiva;
	}
	public boolean isModDocenteAttiva() {
		return Common.CH_S.equals(flagModDocenteAttiva);
	}
	public Character getFlagNonRinnovareDocenteAttiva() {
		return flagNonRinnovareDocenteAttiva;
	}
	public void setFlagNonRinnovareDocenteAttiva(
			Character flagNonRinnovareDocenteAttiva) {
		this.flagNonRinnovareDocenteAttiva = flagNonRinnovareDocenteAttiva;
	}
	public boolean isNonRinnovareDocenteAttiva() {
		return Common.CH_S.equals(flagNonRinnovareDocenteAttiva);
	}
	public Character getFlagProroga() {
		return (this.getEsecuzioneAccordoView() == null) ? null : this.getEsecuzioneAccordoView().getFlagProroga();
	}
	public void setFlagProroga(Character flagProroga) {
	}
	public boolean isProroga() {
		return Common.CH_S.equals(getFlagProroga());
	}
	
	public EsecuzioneAccordoView getEsecuzioneAccordoView() {
		return esecuzioneAccordoView;
	}
	public void setEsecuzioneAccordoView(EsecuzioneAccordoView esecuzioneAccordoView) {
		this.esecuzioneAccordoView = esecuzioneAccordoView;
	}
	
	public Date getDataCopiaDatiDaInfoSheet() {
		return dataCopiaDatiDaInfoSheet;
	}
	public void setDataCopiaDatiDaInfoSheet(Date dataCopiaDatiDaInfoSheet) {
		this.dataCopiaDatiDaInfoSheet = dataCopiaDatiDaInfoSheet;
	}
	
	public Date getDataControlloAvvisoInfoSheet() {
		return dataControlloAvvisoInfoSheet;
	}
	public void setDataControlloAvvisoInfoSheet(Date dataControlloAvvisoInfoSheet) {
		this.dataControlloAvvisoInfoSheet = dataControlloAvvisoInfoSheet;
	}
	
	// Indica se l'annualizzazione era valida all'interno periodo a cui riferisce
	public boolean isValidoAnnoAccademicoDelPeriodo() {
		if (StatoEsecuzioneAccordo.NON_DA_RINNOVARE.getValore().equals(getStato()) 
	    		 || StatoEsecuzioneAccordo.RIFIUTATO.getValore().equals(getStato()))
	     return false;
	     
	    if (getAccordoOperativo().getDataFine() == null || getAccordoOperativo().isAccordoInRinnovo())
	    	return true;
	    
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(getAccordoOperativo().getDataFine());
	    int y1=cal.get(Calendar.YEAR);
	    
	    return  getPeriodoMobilita().getAnnoAccademico().compareTo(y1) < 0;
	}

	// Eventualmente isolare questa parte ------------------------------------------
	
	public String getSitoNomineOnline() {
		return sitoNomineOnline;
	}
	public void setSitoNomineOnline(String sitoNomineOnline) {
		this.sitoNomineOnline = sitoNomineOnline;
	}

	private Set<EsecuzioneAccordoAllegato> allegati = new HashSet<EsecuzioneAccordoAllegato>();
	
	public Set<EsecuzioneAccordoAllegato> getAllegati() {
		return allegati;
	}

	public void setAllegati(Set<EsecuzioneAccordoAllegato> allegati) {
		this.allegati = allegati;
	}

	// Campi non persistiti
	// Allegati pubblicabili allo studente
	private transient MultipartFile docAllegatoDaAggiungere;
	private String descrizioneAllegatoDaAggiungere;
	private Character flagVisibileAStudenteAllegatoDaAggiungere=Common.CH_S;

	// Allegati interni
	private transient MultipartFile docAllegatoInternoDaAggiungere;
	private String descrizioneAllegatoInternoDaAggiungere;

	
	public MultipartFile getDocAllegatoInternoDaAggiungere() {
		return docAllegatoInternoDaAggiungere;
	}
	public void setDocAllegatoInternoDaAggiungere(
			MultipartFile docAllegatoInternoDaAggiungere) {
		this.docAllegatoInternoDaAggiungere = docAllegatoInternoDaAggiungere;
	}
	public String getDescrizioneAllegatoInternoDaAggiungere() {
		return descrizioneAllegatoInternoDaAggiungere;
	}
	public void setDescrizioneAllegatoInternoDaAggiungere(
			String descrizioneAllegatoInternoDaAggiungere) {
		this.descrizioneAllegatoInternoDaAggiungere = descrizioneAllegatoInternoDaAggiungere;
	}

	public MultipartFile getDocAllegatoDaAggiungere() {
		return docAllegatoDaAggiungere;
	}

	public void setDocAllegatoDaAggiungere(MultipartFile docAllegatoDaAggiungere) {
		this.docAllegatoDaAggiungere = docAllegatoDaAggiungere;
	}

	public String getDescrizioneAllegatoDaAggiungere() {
		return descrizioneAllegatoDaAggiungere;
	}

	public void setDescrizioneAllegatoDaAggiungere(
			String descrizioneAllegatoDaAggiungere) {
		this.descrizioneAllegatoDaAggiungere = descrizioneAllegatoDaAggiungere;
	}
	
	public Character getFlagVisibileAStudenteAllegatoDaAggiungere() {
		return flagVisibileAStudenteAllegatoDaAggiungere;
	}

	public void setFlagVisibileAStudenteAllegatoDaAggiungere(
			Character flagVisibileAStudenteAllegatoDaAggiungere) {
		this.flagVisibileAStudenteAllegatoDaAggiungere = flagVisibileAStudenteAllegatoDaAggiungere;
	}
	
	public boolean isMaiInseritoAllegatoPubblico() {
		if (!getAllegati().isEmpty())
			for (EsecuzioneAccordoAllegato alle: getAllegati())
				if (alle.isTipoIsheetPubblico())
					return false;
		return true;
	}
	
	public List<EsecuzioneAccordoAllegato> getAllegatiPubbliciList() {
		ArrayList<EsecuzioneAccordoAllegato> l= new ArrayList<EsecuzioneAccordoAllegato>();
		for (EsecuzioneAccordoAllegato alle: getAllegati())
			if (!alle.isRimosso() && alle.isTipoIsheetPubblico())
				l.add(alle);
		return l;
	}
	
	public List<EsecuzioneAccordoAllegato> getAllegatiInterniList() {
		List<EsecuzioneAccordoAllegato> l= new ArrayList<EsecuzioneAccordoAllegato>();
		for (EsecuzioneAccordoAllegato alle: getAllegati())
			if (!alle.isRimosso() && alle.isTipoIsheetInterno())
				l.add(alle);
		return l;
	}

	public List<EsecuzioneAccordoAllegato> getAllegatiVisibiliAStudenteOrdinata() {
		List<EsecuzioneAccordoAllegato> ret = new ArrayList<EsecuzioneAccordoAllegato>();
		for (EsecuzioneAccordoAllegato alle: allegati)
			if (!alle.isRimosso() && alle.isTipoIsheetPubblico() &&  alle.isVisibileAStudente())
				ret.add(alle);
		return ordinaAllegatiPerPosizione(ret);
	}
	
	public List<EsecuzioneAccordoAllegato> ordinaAllegatiPerPosizione(List<EsecuzioneAccordoAllegato> lista) {
		if (!lista.isEmpty()) 
		   Collections.sort(lista, new EsecuzioneAccordoAllegato.EsecuzioneAccordoAllegatoComparatorPosizione());
		return lista;
	}

	public boolean isAllegatiInterniCompleto() {
		List<EsecuzioneAccordoAllegato> l= getAllegatiInterniList();
		return l.size() >= 2;
	}
	
	public boolean isAllegatiPubbliciCompleto() {
		List<EsecuzioneAccordoAllegato> l= getAllegatiPubbliciList();
		return l.size() >= 5;
	}
	public String getColorStatoAttivazione() {
		return StatoEsecuzioneAccordo.get(getStato()).getColorAttivazione();
	}
	
	public String getColorDescStatoAttivazione() {
		return StatoEsecuzioneAccordo.get(getStato()).getMessageKeyAttivazione();
	}

}

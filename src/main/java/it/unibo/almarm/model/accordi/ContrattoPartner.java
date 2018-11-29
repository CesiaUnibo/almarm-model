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

import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.flussiscambio.CodificaAreaDisciplinare;
import it.unibo.almarm.util.Common;
import it.unibo.almarm.webapp.mvc.ContattoDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import edu.emory.mathcs.backport.java.util.Collections;

public class ContrattoPartner implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final Character OUT_NOMINATION_CONCTACT_FAC= new  Character('F');
	public static final Character OUT_NOMINATION_CONCTACT_AMM_GEN= new  Character('G');
	
	private Long id;

	private AccordoOperativo accordoOperativo;
// ----  05/12/2014
//	private PeriodoMobilita periodoMobilita;    // Periodo di inizio applicazione (fisso 5)
	private Integer annoAccademicoInizioValidita; // Scelta Ateneo partner fra le possibili; si potrebbe mettere in alternativa un codice tipo 1 e 2
// ----	
	private Character flagPerStipulaContratto;	// Fisso 'S'
	private String stato;                       
	
	// DATI SEZIONE CONTRATTO
	private Integer annoAccademicoFineValidita; // Scelta Ateneo partner fra le possibili; si potrebbe mettere in alternativa un codice tipo 1 e 2
												// per indicare la scelta effettuata
	// DATI SEZIONE  Info sheet
	private CodificaAreaDisciplinare codificaAreaDisciplinare;  // Fisso : isced
	
	private String sitoWebCatalogoCorsi; // va nella prima parte del contratto nella sezione A. colonna website ma anche nel data-sheet	
	
	private Character flagScadenzaNomine;
	private Character flagScadenzaRegistrazione;
	private String giornoScadenzaNomineCiclo1; 
	private String meseScadenzaNomineCiclo1;
	private String giornoScadenzaNomineCiclo2; 
	private String meseScadenzaNomineCiclo2;
	private String giornoScadenzaRegistrazioneCiclo1;
	private String meseScadenzaRegistrazioneCiclo1;
	private String giornoScadenzaRegistrazioneCiclo2;
	private String meseScadenzaRegistrazioneCiclo2;
	
	private Character flagNomineOnline;
	private String sitoNomineOnline;
	private Character flagOutNominationConctatType;
	
	
	// Testi liberi (la prima parte del nome individua il capitolo in cui sono presenti nel documento)		
	private String additionalRequirementsText;
	private String gradingSystemText;
	private String furtherInformationText;
	
    // altri dati interni
	private String idDocumentoStipulaContratto;
	private String nomeDocumentoStipulaContratto;
	private Date dataDocumentoStipulaContratto;
	private Persona autoreDocumentoStipulaContratto;

	private String idDocInfoSheet;
	private String nomeDocInfoSheet;
	private Date dataInserimento;
	private Date dataBozza;
	private Persona autoreBozza;
	private Date dataDefinitivo;
	private Persona autoreDefinitivo;
	private Date dataInvio;
	private Persona autoreInvio;
	private Date dataValidazione;
	private Persona autoreValidazione;
	private String noteValidazione;
	
	private Character flagDurataBloccata;
	
	// Calendario Accettazione Nomina 
	private String accettazioneNominaTipoDestinatario;
	private String accettazioneNominaTempoMassimo; 
	private String accettazioneNominaTestoFrom;

	// Calendario TOR 
	private String invioTORTempoMassimo; 
	private String invioTORTestoAfter;

	// 
	private Character flagAltroUfficioAccordi;
	
	private Long idCopiatoDa;

	// collegamenti
	private Set<LinguaContrattoPartner> lingueContrattoPartner = new HashSet<LinguaContrattoPartner>();
	private Set<ContattoContrattoPartner> contattiContrattoPartner = new HashSet<ContattoContrattoPartner>();
	
	private Date dataUltimaModDefinitivo;
	private Persona autoreUltimaModDefinitivo;
	
	private Character flagReferenteScritto;
	private Character flagAltroUfficioAccordiScritto;
	private String	noteCalendario;
		
	// TODO : IO NON LI VORREI MA INSISTONO
	private String 	sitoRegistrazioniOnline;
	private Character flagRegistrazioniOnline;
	// -------------------

	//-------------------------------------------------------
	// NON  PERSISTITI - Dto di sola visualizzazione che rimangono statici nel flusso
	private ContattoDto externalCoordinator;
	private ContattoDto internalAcademicConctact;
 
	// NON  PERSISTITI - supporto editing
	private LinguaContrattoPartner nuovaLinguaContrattoPartner;

	//-------------------------------------------------------
	// NON  PERSISTITI - supporto editing - SCELTA DELLA DURATA
	ConfigurazioneCP configurazioneCP;

	//-------------------------------------------------------
	// NON  PERSISTITI - configurazione
	private boolean sceltaPregressaDurata = false;
	
	// NON  PERSISTITI - supporto editing
	private transient MultipartFile documentoFirmato;
	private int	numeroInit = 0;
	
	private String noteAnnullamentoValidazione;

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
	public Character getFlagPerStipulaContratto() {
		return flagPerStipulaContratto;
	}
	public void setFlagPerStipulaContratto(Character flagPerStipulaContratto) {
		this.flagPerStipulaContratto = flagPerStipulaContratto;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public Integer getAnnoAccademicoFineValidita() {
		return annoAccademicoFineValidita;
	}
	public void setAnnoAccademicoFineValidita(Integer annoAccademicoFineValidita) {
		this.annoAccademicoFineValidita = annoAccademicoFineValidita;
	}
	public CodificaAreaDisciplinare getCodificaAreaDisciplinare() {
		return codificaAreaDisciplinare;
	}
	public void setCodificaAreaDisciplinare(
			CodificaAreaDisciplinare codificaAreaDisciplinare) {
		this.codificaAreaDisciplinare = codificaAreaDisciplinare;
	}
	public String getSitoWebCatalogoCorsi() {
		return sitoWebCatalogoCorsi;
	}
	public void setSitoWebCatalogoCorsi(String sitoWebCatalogoCorsi) {
		this.sitoWebCatalogoCorsi = sitoWebCatalogoCorsi;
	}
	
	public Character getFlagNomineOnline() {
		return flagNomineOnline == null ? 'N' : flagNomineOnline;
	}
	public void setFlagNomineOnline(Character flagNomineOnline) {
		this.flagNomineOnline = flagNomineOnline;
	}
	public boolean isNomineOnline() {
		return Common.CH_S.equals(getFlagNomineOnline());
	}
	public String getSitoNomineOnline() {
		return sitoNomineOnline;
	}
	public void setSitoNomineOnline(String sitoNomineOnline) {
		this.sitoNomineOnline = sitoNomineOnline;
	}
	public Character getFlagOutNominationConctatType() { // F=facolta G=amm gen
		return flagOutNominationConctatType;
	}
	public void setFlagOutNominationConctatType(
			Character flagOutNominationConctatType) {
		this.flagOutNominationConctatType = flagOutNominationConctatType;
	}
	public boolean isOutNominationGeneralAmmConctact() {
		return OUT_NOMINATION_CONCTACT_AMM_GEN.equals(flagOutNominationConctatType);
	}
	public boolean isOutNominationFacConctact() {
		return OUT_NOMINATION_CONCTACT_FAC.equals(flagOutNominationConctatType);
	}

	public String getAdditionalRequirementsText() {
		return additionalRequirementsText;
	}
	public void setAdditionalRequirementsText(String additionalRequirementsText) {
		this.additionalRequirementsText = additionalRequirementsText;
	}
	public String getGradingSystemText() {
		return gradingSystemText;
	}
	public void setGradingSystemText(String gradingSystemText) {
		this.gradingSystemText = gradingSystemText;
	}
	public String getFurtherInformationText() {
		return furtherInformationText;
	}
	public void setFurtherInformationText(String furtherInformationText) {
		this.furtherInformationText = furtherInformationText;
	}
	public String getIdDocumentoStipulaContratto() {
		return idDocumentoStipulaContratto;
	}
	public void setIdDocumentoStipulaContratto(String idDocumentoStipulaContratto) {
		this.idDocumentoStipulaContratto = idDocumentoStipulaContratto;
	}
	public String getNomeDocumentoStipulaContratto() {
		return nomeDocumentoStipulaContratto;
	}
	public void setNomeDocumentoStipulaContratto(
			String nomeDocumentoStipulaContratto) {
		this.nomeDocumentoStipulaContratto = nomeDocumentoStipulaContratto;
	}
	
	public Date getDataDocumentoStipulaContratto() {
		return dataDocumentoStipulaContratto;
	}
	public void setDataDocumentoStipulaContratto(Date dataDocumentoStipulaContratto) {
		this.dataDocumentoStipulaContratto = dataDocumentoStipulaContratto;
	}
	public Persona getAutoreDocumentoStipulaContratto() {
		return autoreDocumentoStipulaContratto;
	}
	public void setAutoreDocumentoStipulaContratto(
			Persona autoreDocumentoStipulaContratto) {
		this.autoreDocumentoStipulaContratto = autoreDocumentoStipulaContratto;
	}
	public String getIdDocInfoSheet() {
		return idDocInfoSheet;
	}
	public void setIdDocInfoSheet(String idDocInfoSheet) {
		this.idDocInfoSheet = idDocInfoSheet;
	}
	public String getNomeDocInfoSheet() {
		return nomeDocInfoSheet;
	}
	public void setNomeDocInfoSheet(String nomeDocInfoSheet) {
		this.nomeDocInfoSheet = nomeDocInfoSheet;
	}
	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public Date getDataBozza() {
		return dataBozza;
	}
	public void setDataBozza(Date dataBozza) {
		this.dataBozza = dataBozza;
	}
	public Persona getAutoreBozza() {
		return autoreBozza;
	}
	public void setAutoreBozza(Persona autoreBozza) {
		this.autoreBozza = autoreBozza;
	}
	public Date getDataDefinitivo() {
		return dataDefinitivo;
	}
	public void setDataDefinitivo(Date dataDefinitivo) {
		this.dataDefinitivo = dataDefinitivo;
	}
	public Persona getAutoreDefinitivo() {
		return autoreDefinitivo;
	}
	public void setAutoreDefinitivo(Persona autoreDefinitivo) {
		this.autoreDefinitivo = autoreDefinitivo;
	}
	
	public boolean isDocumentoBozza(){
		return getDataDefinitivo() == null;
	}

	public Set<LinguaContrattoPartner> getLingueContrattoPartner() {
		return lingueContrattoPartner;
	}
	public void setLingueContrattoPartner(
			Set<LinguaContrattoPartner> lingueContrattoPartner) {
		this.lingueContrattoPartner = lingueContrattoPartner;
	}
	public Set<ContattoContrattoPartner> getContattiContrattoPartner() {
		return contattiContrattoPartner;
	}
	public void setContattiContrattoPartner(
			Set<ContattoContrattoPartner> contattiContrattoPartner) {
		this.contattiContrattoPartner = contattiContrattoPartner;
	}
	
	public Character getFlagScadenzaNomine() {
		return flagScadenzaNomine;
	}
	public void setFlagScadenzaNomine(Character flagScadenzaNomine) {
		this.flagScadenzaNomine = flagScadenzaNomine;
	}
	public boolean isScadenzaNomine() {
		return Common.CH_S.equals(flagScadenzaNomine);
	}
	public Character getFlagScadenzaRegistrazione() {
		return flagScadenzaRegistrazione;
	}
	public void setFlagScadenzaRegistrazione(Character flagScadenzaRegistrazione) {
		this.flagScadenzaRegistrazione = flagScadenzaRegistrazione;
	}
	public boolean isScadenzaRegistrazione() {
		return Common.CH_S.equals(flagScadenzaRegistrazione);
	}
	
	public String getGiornoScadenzaNomineCiclo1() {
		return giornoScadenzaNomineCiclo1;
	}
	public void setGiornoScadenzaNomineCiclo1(String giornoScadenzaNomineCiclo1) {
		this.giornoScadenzaNomineCiclo1 = giornoScadenzaNomineCiclo1;
	}
	public String getMeseScadenzaNomineCiclo1() {
		return meseScadenzaNomineCiclo1;
	}
	public void setMeseScadenzaNomineCiclo1(String meseScadenzaNomineCiclo1) {
		this.meseScadenzaNomineCiclo1 = meseScadenzaNomineCiclo1;
	}
	public String getGiornoScadenzaNomineCiclo2() {
		return giornoScadenzaNomineCiclo2;
	}
	public void setGiornoScadenzaNomineCiclo2(String giornoScadenzaNomineCiclo2) {
		this.giornoScadenzaNomineCiclo2 = giornoScadenzaNomineCiclo2;
	}
	public String getMeseScadenzaNomineCiclo2() {
		return meseScadenzaNomineCiclo2;
	}
	public void setMeseScadenzaNomineCiclo2(String meseScadenzaNomineCiclo2) {
		this.meseScadenzaNomineCiclo2 = meseScadenzaNomineCiclo2;
	}
	public String getGiornoScadenzaRegistrazioneCiclo1() {
		return giornoScadenzaRegistrazioneCiclo1;
	}
	public void setGiornoScadenzaRegistrazioneCiclo1(
			String giornoScadenzaRegistrazioneCiclo1) {
		this.giornoScadenzaRegistrazioneCiclo1 = giornoScadenzaRegistrazioneCiclo1;
	}
	public String getMeseScadenzaRegistrazioneCiclo1() {
		return meseScadenzaRegistrazioneCiclo1;
	}
	public void setMeseScadenzaRegistrazioneCiclo1(
			String meseScadenzaRegistrazioneCiclo1) {
		this.meseScadenzaRegistrazioneCiclo1 = meseScadenzaRegistrazioneCiclo1;
	}
	public String getGiornoScadenzaRegistrazioneCiclo2() {
		return giornoScadenzaRegistrazioneCiclo2;
	}
	public void setGiornoScadenzaRegistrazioneCiclo2(
			String giornoScadenzaRegistrazioneCiclo2) {
		this.giornoScadenzaRegistrazioneCiclo2 = giornoScadenzaRegistrazioneCiclo2;
	}
	public String getMeseScadenzaRegistrazioneCiclo2() {
		return meseScadenzaRegistrazioneCiclo2;
	}
	public void setMeseScadenzaRegistrazioneCiclo2(
			String meseScadenzaRegistrazioneCiclo2) {
		this.meseScadenzaRegistrazioneCiclo2 = meseScadenzaRegistrazioneCiclo2;
	}
	public String getScadenzaNomineCiclo1LabelEn() {
		return Common.getGiornoMeseLabel(giornoScadenzaNomineCiclo1, meseScadenzaNomineCiclo1, "en"); 
	}
	public String getScadenzaNomineCiclo2LabelEn() {
		return Common.getGiornoMeseLabel(giornoScadenzaNomineCiclo2, meseScadenzaNomineCiclo2, "en"); 
	}
	public String getScadenzaRegistrazioneCiclo1LabelEn() {
		return Common.getGiornoMeseLabel(giornoScadenzaRegistrazioneCiclo1, meseScadenzaRegistrazioneCiclo1, "en"); 
	}
	public String getScadenzaRegistrazioneCiclo2LabelEn() {
		return Common.getGiornoMeseLabel(giornoScadenzaRegistrazioneCiclo2, meseScadenzaRegistrazioneCiclo2, "en"); 
	}

	public ContattoContrattoPartner getContattoVisa () {
		ContattoContrattoPartner c=getContatto(ContattoContrattoPartner.TIPO_CONTATTO_ISHEET_VISA);
		return c;
	}
	public ContattoContrattoPartner getContattoInsurance () {
		ContattoContrattoPartner c=getContatto(ContattoContrattoPartner.TIPO_CONTATTO_ISHEET_INSURANCE);
		return c;
	}
	public ContattoContrattoPartner getContattoHousing () {
		ContattoContrattoPartner c=getContatto(ContattoContrattoPartner.TIPO_CONTATTO_ISHEET_HOUSING);
		return c;
	}
	public ContattoContrattoPartner getContattoOutNomination () {
		ContattoContrattoPartner c=getContatto(ContattoContrattoPartner.TIPO_CONTATTO_ISHEET_OUT_NOMINATION);
		return c;
	}
	public ContattoContrattoPartner getContattoAltroUfficioAccordi () {
		ContattoContrattoPartner c=getContatto(ContattoContrattoPartner.TIPO_CONTATTO_ALTRO_UFFICIO_ACCORDI);
		return c;
	}
	public ContattoContrattoPartner getNuovoReferenteEsterno () {
		ContattoContrattoPartner c=getContatto(ContattoContrattoPartner.TIPO_CONTATTO_NUOVO_REF_ESTERNO);
		return c;
	}

	public void setContattoVisa (ContattoContrattoPartner c) {};
	public void setContattoInsurance (ContattoContrattoPartner c) {};
	public void setContattoHousing (ContattoContrattoPartner c) {};
	public void setContattoOutNomination(ContattoContrattoPartner c) {};
	public void setContattoAltroUfficioAccordi(ContattoContrattoPartner c) {};
	public void setNuovoReferenteEsterno(ContattoContrattoPartner c) {};
	
	private ContattoContrattoPartner getContatto (String codice) {
		Set<ContattoContrattoPartner>  ccs = getContattiContrattoPartner();
		if (ccs!=null){
			int i=ccs.size();
			if (i>6) {
				int kk=1;
			}
		}
			
		for (ContattoContrattoPartner c : getContattiContrattoPartner())
			if (c.getCodice().equals(codice))
				return c;
		 return null;
	}
	
	public List<LinguaContrattoPartner> getLingueContrattoPartnerList() {
		List<LinguaContrattoPartner> l = new ArrayList<LinguaContrattoPartner>(lingueContrattoPartner);
		Collections.sort(l, new LinguaContrattoPartnerComparator());
		return l;
	}

	public Ateneo getAteneoPartner() {
		return (getAccordoOperativo() != null && getAccordoOperativo().getAteneoPartnerReferente() != null
				&& getAccordoOperativo().getAteneoPartnerReferente().getRagioneSociale() != null) 
				?	getAccordoOperativo().getAteneoPartnerReferente() 
				: null;
	}
	
	public ContattoDto getExternalCoordinator() {
		return externalCoordinator;
	}
	public void setExternalCoordinator(ContattoDto externalCoordinator) {
		this.externalCoordinator = externalCoordinator;
	}
	public ContattoDto getInternalAcademicConctact() {
		return internalAcademicConctact;
	}
	public void setInternalAcademicConctact(ContattoDto internalAcademicConctact) {
		this.internalAcademicConctact = internalAcademicConctact;
	}
	public LinguaContrattoPartner getNuovaLinguaContrattoPartner() {
		return  nuovaLinguaContrattoPartner;
	}
	public void setNuovaLinguaContrattoPartner(
			LinguaContrattoPartner nuovaLinguaContrattoPartner) {
		this.nuovaLinguaContrattoPartner = nuovaLinguaContrattoPartner;
	}
	public Date getDataInvio() {
		return dataInvio;
	}
	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}
	public Persona getAutoreInvio() {
		return autoreInvio;
	}
	public void setAutoreInvio(Persona autoreInvio) {
		this.autoreInvio = autoreInvio;
	}

	public String getAccettazioneNominaTipoDestinatario() {
		return accettazioneNominaTipoDestinatario;
	}
	public void setAccettazioneNominaTipoDestinatario(
			String accettazioneNominaTipoDestinatario) {
		this.accettazioneNominaTipoDestinatario = accettazioneNominaTipoDestinatario;
	}
	public String getAccettazioneNominaTempoMassimo() {
		return accettazioneNominaTempoMassimo;
	}
	public void setAccettazioneNominaTempoMassimo(
			String accettazioneNominaTempoMassimo) {
		this.accettazioneNominaTempoMassimo = accettazioneNominaTempoMassimo;
	}
	public String getAccettazioneNominaTestoFrom() {
		return accettazioneNominaTestoFrom;
	}
	public void setAccettazioneNominaTestoFrom(String accettazioneNominaTestoFrom) {
		this.accettazioneNominaTestoFrom = accettazioneNominaTestoFrom;
	}
	public String getInvioTORTempoMassimo() {
		return invioTORTempoMassimo;
	}
	public void setInvioTORTempoMassimo(String invioTORTempoMassimo) {
		this.invioTORTempoMassimo = invioTORTempoMassimo;
	}
	public String getInvioTORTestoAfter() {
		return invioTORTestoAfter;
	}
	public void setInvioTORTestoAfter(String invioTORTestoAfter) {
		this.invioTORTestoAfter = invioTORTestoAfter;
	}
	public Character getFlagAltroUfficioAccordi() {
		return flagAltroUfficioAccordi == null ? 'N' : flagAltroUfficioAccordi;
	}
	public void setFlagAltroUfficioAccordi(Character flagAltroUfficioAccordi) {
		this.flagAltroUfficioAccordi = flagAltroUfficioAccordi;
	}
	public boolean isAltroUfficioAccordi() {
		return Common.CH_S.equals(getFlagAltroUfficioAccordi());
	}
	public MultipartFile getDocumentoFirmato() {
		return documentoFirmato;
	}
	public void setDocumentoFirmato(MultipartFile documentoFirmato) {
		this.documentoFirmato = documentoFirmato;
	}
	public Long getIdCopiatoDa() {
		return idCopiatoDa;
	}
	public void setIdCopiatoDa(Long idCopiatoDa) {
		this.idCopiatoDa = idCopiatoDa;
	}
	public Date getDataUltimaModDefinitivo() {
		return dataUltimaModDefinitivo;
	}
	public void setDataUltimaModDefinitivo(Date dataUltimaModDefinitivo) {
		this.dataUltimaModDefinitivo = dataUltimaModDefinitivo;
	}
	public Persona getAutoreUltimaModDefinitivo() {
		return autoreUltimaModDefinitivo;
	}
	public void setAutoreUltimaModDefinitivo(Persona autoreUltimaModDefinitivo) {
		this.autoreUltimaModDefinitivo = autoreUltimaModDefinitivo;
	}
	public String getNomeDocStipulaContrattoPerLink(){
		return Common.getPathNameAllegato(getIdDocumentoStipulaContratto(),getNomeDocumentoStipulaContratto(),null);
	}
	public Character getFlagDurataBloccata() {
		if (flagDurataBloccata == null)
			return 'N';
		return flagDurataBloccata;
	}
	public void setFlagDurataBloccata(Character flagDurataBloccata) {
		this.flagDurataBloccata = flagDurataBloccata;
	}
	public boolean isDurataBloccata() {
		return Common.CH_S.equals(getFlagDurataBloccata());
	}
	public int getNumeroInit() {
		return numeroInit;
	}
	public void setNumeroInit(int numeroInit) {
		this.numeroInit = numeroInit;
	}
	public int incrementaInit() {
		numeroInit++;
		return numeroInit; 
	}
	public Date getDataValidazione() {
		return dataValidazione;
	}
	public void setDataValidazione(Date dataValidazione) {
		this.dataValidazione = dataValidazione;
	}
	public Persona getAutoreValidazione() {
		return autoreValidazione;
	}
	public void setAutoreValidazione(Persona autoreValidazione) {
		this.autoreValidazione = autoreValidazione;
	}
	public String getNoteValidazione() {
		return noteValidazione;
	}
	public void setNoteValidazione(String noteValidazione) {
		this.noteValidazione = noteValidazione;
	}
	public Character getFlagReferenteScritto() {
		return flagReferenteScritto;
	}
	public void setFlagReferenteScritto(Character flagReferenteScritto) {
		this.flagReferenteScritto = flagReferenteScritto;
	}
	public Character getFlagAltroUfficioAccordiScritto() {
		return flagAltroUfficioAccordiScritto;
	}
	public void setFlagAltroUfficioAccordiScritto(
			Character flagAltroUfficioAccordiScritto) {
		this.flagAltroUfficioAccordiScritto = flagAltroUfficioAccordiScritto;
	}
	
	// STATI -------------------------------------------------------------
	public boolean isIniziale() {
		return (getStato() == null) || StatoContrattoPartner.INIZIALE.getValore().equals(getStato());
	}
	public boolean isInviato() {
		return StatoContrattoPartner.INVIATO.getValore().equals(getStato());
	}
	public boolean isBozza() {
		return StatoContrattoPartner.BOZZA.getValore().equals(getStato());
	}
	public boolean isCompilato() {
		return StatoContrattoPartner.COMPILATO.getValore().equals(getStato());
	}
	public boolean isFirmato() {
		return StatoContrattoPartner.FIRMATO.getValore().equals(getStato());
	}
	public boolean isValidato() {
		return StatoContrattoPartner.VALIDATO.getValore().equals(getStato());
	}
	//-------------------------------------------------------------------
	
	public String getNoteCalendario() {
		return noteCalendario;
	}
	public void setNoteCalendario(String noteCalendario) {
		this.noteCalendario = noteCalendario;
	}
	public String getNoteAnnullamentoValidazione() {
		return noteAnnullamentoValidazione;
	}
	public void setNoteAnnullamentoValidazione(String noteAnnullamentoValidazione) {
		this.noteAnnullamentoValidazione = noteAnnullamentoValidazione;
	}
	public boolean isDocumentoStipulaContratto(){
		return idDocumentoStipulaContratto != null;
	}
	public boolean isInCorsoDiStipula() {
		return getAccordoOperativo() != null &&	!getAccordoOperativo().isRifiutata() && !getAccordoOperativo().isStipulata();
	}
	// impostato al momento della creazione del record(approvazione accordo)
	public Integer getAnnoAccademicoInizioValidita() {
		return annoAccademicoInizioValidita;
	}
	public void setAnnoAccademicoInizioValidita(Integer annoAccademicoInizioValidita) {
		this.annoAccademicoInizioValidita = annoAccademicoInizioValidita;
	}
	
	// *************** io non li vorrei ma insistono
	public Character getFlagRegistrazioniOnline() {
		return flagRegistrazioniOnline;
	}
	public void setFlagRegistrazioniOnline(Character flagRegistrazioniOnline) {
		this.flagRegistrazioniOnline = flagRegistrazioniOnline;
	}
	public boolean isRegistrazioniOnline() {
		return Common.CH_S.equals(flagRegistrazioniOnline);
	}
	public String getSitoRegistrazioniOnline() {
		return sitoRegistrazioniOnline;
	}
	public void setSitoRegistrazioniOnline(String sitoRegistrazioniOnline) {
		this.sitoRegistrazioniOnline = sitoRegistrazioniOnline;
	}

	// ***************

	// NON PERSISTITI
	private String testoAltoPagPartner;

	public String getTestoAltoPagPartner() {
		return testoAltoPagPartner;
	}
	public void setTestoAltoPagPartner(String testoAltoPagPartner) {
		this.testoAltoPagPartner = testoAltoPagPartner;
	}
	
	// SUPPORTO ALLA GESTIONE 
	// NON PERSISTITI
	public Integer getAnnoAccademicoInizio() {
		return getAccordoOperativo()!=null && getAccordoOperativo().getDataInizio()!=null ? Common.getAnno( getAccordoOperativo().getDataInizio()):null; 
	}
	public String getAnnoAccademicoInizioLabel(){
		return getAnnoAccademicoInizio() != null ? labelAnnoAccademico(getAnnoAccademicoInizio()) : ""; 
	}
	public String getAnnoAccademicoFineValiditaLabel(){
		return getAnnoAccademicoFineValidita() != null ? labelAnnoAccademico(getAnnoAccademicoFineValidita()) : ""; 
	}

	
	public ConfigurazioneCP getConfigurazioneCP() {
		return configurazioneCP;
	}
	public void setConfigurazioneCP(ConfigurazioneCP configurazioneCP) {
		this.configurazioneCP = configurazioneCP;
	}

	public boolean isSceltaPregressaDurata() {
		return sceltaPregressaDurata;
	}
	
	public void setSceltaPregressaDurata(boolean sceltaPregressaDurata) {
		this.sceltaPregressaDurata = sceltaPregressaDurata;
	}
	
	public String getSceltaDurataBreveLabel() {
		return configurazioneCP!= null && configurazioneCP.isAmmetteDurataBreve() ?	getSceltaDurataLabel(getAnnoAccademicoInizio(),configurazioneCP.getAnnoAccademicoFineDurataBreve()) : "";
	}

	public String getSceltaDurataInteraLabel(){
		return configurazioneCP != null ? 
				getSceltaDurataLabel(getAnnoAccademicoInizio(),configurazioneCP.getAnnoAccademicoFineDurataIntera()) : "";
	}
	public String getSceltaBloccaLabel(){
		return isDurataBloccata() ? 
				getSceltaDurataLabel(getAnnoAccademicoInizio(), getAnnoAccademicoFineValidita()) : "";
	}

	public String getSceltaDurataPregressaLabel(){
		return isSceltaPregressaDurata() ? getSceltaDurataLabel(getAnnoAccademicoInizio(), getAnnoAccademicoFineValidita()) : "";
	}
	
	// -- metodi che tengono come limite per la durata lunga del aa fine accordo 
	public String getSceltaLimiteDurataBreveLabel() {
		return configurazioneCP!= null && configurazioneCP.isAmmetteDurataBreveNelLimite() ?	getSceltaDurataLabel(getAnnoAccademicoInizio(),configurazioneCP.getAnnoAccademicoLimiteDurataBreve()) : "";
	}

	public String getSceltaLimiteDurataInteraLabel(){
		return configurazioneCP != null ? 
				getSceltaDurataLabel(getAnnoAccademicoInizio(), configurazioneCP.getAnnoAccademicoLimiteDurataIntera()) : "";
	}
	//
	
	private String getSceltaDurataLabel(Integer anno_acca_da, Integer anno_acca_a){
		if (anno_acca_da == null || anno_acca_a == null)
			return ""; 

		int num_anni = anno_acca_a.intValue() - anno_acca_da.intValue() + 1;

		if (num_anni <= 0)
			return ""; 

		if (num_anni > 3)
			return  "from "+ labelAnnoAccademico(anno_acca_da) + " to " + labelAnnoAccademico(anno_acca_a);

		String s="";
		for (int aa = anno_acca_da.intValue(); aa <= anno_acca_a.intValue(); aa++)
			s += labelAnnoAccademico(aa)+ " - ";
		return  StringUtils.removeEnd(s,  " - ");
	}

	private String labelAnnoAccademico(int annoAccademico){
		return String.valueOf(annoAccademico) + "/" + String.valueOf(annoAccademico + 1 - 2000);
	}

	public String getDurataSelezionataLabel(){
		return  getSceltaDurataLabel(getAnnoAccademicoInizio(), getAnnoAccademicoFineValidita());
	}

	public boolean  isAlmenoBozza() {
		return StatoContrattoPartner.get(this.getStato()).isAlmenoBozza();
	}
	
	public boolean  isAlmenoCompilato() {
		return  getDataDefinitivo() != null ||	StatoContrattoPartner.get(this.getStato()).isAlmenoCompilato();
	}
	
	public boolean  isPartnerPuoModificare() {
		return StatoContrattoPartner.get(this.getStato()).isPartnerPuoModificare();
	}
	
	// TASTI SPECIALI solo PER OPERATORE -----------
	public boolean  isPuoTrornareInIniziale(){
		return isInviato() || (isBozza() && (dataInvio == null));
	}

	public boolean  isPuoTrornareInInviato(){
	  return isBozza() && (dataInvio != null);
	}
	public boolean  isPuoTrornareInBozza() {
		  return isCompilato();
	}
	public boolean  isPuoTrornareCompilato(){
		  return isFirmato();
	}
	public boolean  isDefinitivoModificabile(){
		  return isCompilato() || isFirmato() ;
	}
	// -----------------------------------------
}

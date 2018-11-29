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

import it.unibo.almarm.model.accordi.AccordoOperativo;
import it.unibo.almarm.model.accordi.Coorte;
import it.unibo.almarm.model.accordi.Programma;
import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.ContattoUnibo;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.attori.TipoDocumento;
import it.unibo.almarm.model.attori.studenti.Carriera;
import it.unibo.almarm.model.attori.studenti.Corso;
import it.unibo.almarm.model.flussiscambio.PeriodoMobilita;
import it.unibo.almarm.model.flussiscambio.UnitaMisuraDurata;
import it.unibo.almarm.model.luoghi.Nazione;
import it.unibo.almarm.model.modalitapagamento.ModalitaDiPagamento;
import it.unibo.almarm.model.outgoing.learningagreement.LearningAgreement;
import it.unibo.almarm.util.Common;
import it.unibo.almarm.webapp.mvc.OlsCommand;
import it.unibo.frontieraCia.model.Minicarriera;
import it.unibo.frontieraCia.model.Rata;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.web.multipart.MultipartFile;

public class StudenteOutgoing implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Candidatura candidatura;
	private Date dataCreazione;
	private Date dataPartenzaPrevista;
	private Date dataPartenza;
	private Persona autorePartenza;
	private Date dataRinuncia;
	private Persona autoreRinuncia;
	private Date dataStipulaPatto;
	private Persona autoreStipulaPatto;
	private Date dataRientroPrevista;
	private Date dataRientro;
	private Persona autoreRientro;
	private Character flagProlungamento;
	private String stato;
	private Long pincode;
	private Integer numeroCarriera;
	private Carriera carriera;
	private Date dataInvioNomina;
	private Persona autoreInvioNomina;
	private Date dataAccettazioneNomina;
	private Persona autoreAccettazioneNomina;
	private Integer periodoDiPermanenzaNomina;
	private OpzioneOfferta opzioneOffertaDefinitiva;
	private Integer periodoDiPermanenzaDefinitivo;
	private String idDocumentoAccettazione;
	private String nomeDocumentoAccettazione;
	private String codCorso;
	private String codInd;
	private String codOri;
	private Corso corso;
	private Character flagConBorsa;
	private Character flagContrattoFirmato;
	private Persona autoreCotnrattoFirmato;
	private Date dataContrattoFirmato;
	private ModalitaDiPagamento modalitaDiPagamento;
	private Character flagDivulgazioneEmail;
	private String noteRinuncia;
	private Date dataDichiarazioneArrivo;
	private Persona autoreDichiarazioneArrivo;
	private Date dataValidazioneDichiarazioneArrivo;
	private Persona autoreValidazioneDichiarazioneArrivo;
	private String idDocumentoDiArrivo;
	private String nomeDocumentoDiArrivo;
	private Minicarriera minicarriera;
	private String codiceAnagraficoCia;
	private Ateneo ateneoDestinazione;
	private String noteRifiutoDichiarazioneArrivo;
	private String noteValidazioneDichiarazioneArrivo;
	private String idDocumentoRichiestaProlungamento;
	private String nomeDocumentoRichiestaProlungamento;
	private Integer durataProlungamento;
	private Persona autoreValidazioneRichiestaProlungamento;
	private Date dataValidazioneRichiestaProlungamento;
	private String noteRifiutoProlungamento;
	private Date dataDichiarazioneRientro;
	private Persona autoreDichiarazioneRientro;
	private Date dataValidazioneDichiarazioneRientro;
	private Persona autoreValidazioneDichiarazioneRientro;
	private String idDocumentoRientro;
	private String nomeDocumentoRientro;
	private String noteRifiutoDichiarazioneRientro;
	private String noteValidazioneDichiarazioneRientro;
	private Coorte coorte;
	private Integer durataAbbreviazione;
	private Character flagAbbreviazione;
	private String idDocumentoRichiestaAbbreviazione;
	private String nomeDocumentoRichiestaAbbreviazione;
	private Persona autoreValidazioneRichiestaAbbreviazione;
	private Date dataValidazioneRichiestaAbbreviazione;
	private String noteRifiutoAbbreviazione;
	private Integer durataEffettiva;
	private String idDocumentoTR;
	private String nomeDocumentoTR;
	private Character flagTR;
	private Persona autoreUploadTR;
	private Persona autoreValidazioneTR;
	private Date dataValidazioneTR;
	private String noteRifiutoValidazioneTR;
	private StudenteOutgoingInfo studenteOutgoingInfo;
	private Character flagRelazioneFinaleConsegnata;
	private Persona autoreRelazioneFinaleConsegnata;
	private Date dataRelazioneFinaleConsegnata;
	private Character flagQuestionarioCompilato;
	private Long durataPrevista;
	private UnitaMisuraDurata unitaMisuraDurataPrevista;
	private String noteBorsaStudio;
	private Date dataRevoca;
	private Persona autoreRevoca;
	private String idDocumentoTrainingAgreement;
	private String nomeDocumentoTrainingAgreement;
	private Character flagTrainingAgreement;
	private String idDocumentoRelazioneIndividuale;
	private String nomeDocumentoRelazioneIndividuale;
	private Character flagRelazioneIndividuale;
	private Date dataPresentazioneRichiestaProlungamento;
	private Persona autoreTrainingAgreement;
	private Date dataTrainingAgreement;
	private Persona autoreRelazioneIndividuale;
	private Date dataRelazioneIndividuale;
	private Persona autoreValidazioneTrainingAgreement;
	private Date dataValidazioneTrainingAgreement;
	private Persona autoreValidazioneRelazioneIndividuale;
	private Date dataValidazioneRelazioneIndividuale;
	private String noteRifiutoValidazioneTrainingAgreement;
	private String noteRifiutoValidazioneRelazioneIndividuale;
	private String notePlacement;
	private Character flagEILCRichiesto;
	private Character flagTrainingAgreementPrimaDellaPartenza;
	private String idDocumentoTrainingAgreementPrimaDellaPartenza;
	private String nomeDocumentoTrainingAgreementPrimaDellaPartenza;
	private Persona autoreTrainingAgreementPrimaDellaPartenza;
	private Date dataTrainingAgreementPrimaDellaPartenza;
	private Persona autoreValidazioneTrainingAgreementPrimaDellaPartenza;
	private Date dataValidazioneTrainingAgreementPrimaDellaPartenza;
	private String noteRifiutoValidazioneTrainingAgreementPrimaDellaPartenza;
	private String noteRevoca;
	private String note;
	private Integer durataEffettivaInGiorni;
	private Integer durataPrevistaInGiorni;
	private OutgoingDottorandiVisiting outgoingDottorandiVisiting;
	private Character flagTirocinioLaureato;
	private Date dataRientroPrevistaOrig;
	private StudenteOutgoingDestView studenteOutgoingDestView;
	private Date dataFineErasmus;
	private Integer durataErasmusInGiorni;
	private String idDocumentoContrattoFirmato;
	private String nomeDocumentoContrattoFirmato;
	private String nomeSottoCartellaDocumentoContrattoFirmato;
	private String noteValidazioneContrattoFirmato;
	private Character flagDocOriginaliConsegnati;
	private Persona autoreDocOriginaliConsegnati;
	private Date dataDocOriginaliConsegnati;
	private Nazione nazDocumento;
	private TipoDocumento tipoDocumento;
	private String nrDocumento;
	private Date scadenzaDocumento;
	private SoSchedaAF soSchedaAF;
	
	private Set<LearningAgreement> learningAgreements = new HashSet<LearningAgreement>();
	private Set<ReferenteStudenteOutgoingView> referentiStudenteOutgoing = new HashSet<ReferenteStudenteOutgoingView>();
	private Set<RichiestaRiconoscimento> richiesteRiconoscimento = new HashSet<RichiestaRiconoscimento>();
	
	// Documento allegato
	private transient MultipartFile docDocumentoAccettazione;
	private transient MultipartFile documentoDiArrivo;
	private transient MultipartFile documentoRichiestaProlungamento;
	private transient MultipartFile documentoRientro;
	private transient MultipartFile documentoRichiestaAbbreviazione;
	private transient MultipartFile documentoTR;
	private transient MultipartFile documentoTrainingAgreement;
	private transient MultipartFile documentoRelazioneIndividuale;
	private transient MultipartFile documentoContrattoFirmato;
	private transient MultipartFile documentoSchedaAF;
	
	// Non persistiti
	private List<String> importiIntermediRate;
	private String importoNuovaRata;
	private Long numeroNuovaRata;
	private ContattoUnibo contattoUnibo;
	private Date[] dateScadenzaRate;
	private String descrizioneNuovaRata;
	private Date scadenzaNuovaRata;
	private List<String> descrizioniRate = new ArrayList<String>();
	private String noteAnnullamentoValidazioneTR;
	private Date dataAppoggio;
	private OlsCommand olsCommand;
	
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

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataPartenzaPrevista() {
		return dataPartenzaPrevista;
	}

	public void setDataPartenzaPrevista(Date dataPartenzaPrevista) {
		this.dataPartenzaPrevista = dataPartenzaPrevista;
	}

	public Date getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public Persona getAutorePartenza() {
		return autorePartenza;
	}

	public void setAutorePartenza(Persona autorePartenza) {
		this.autorePartenza = autorePartenza;
	}

	public Date getDataStipulaPatto() {
		return dataStipulaPatto;
	}

	public void setDataStipulaPatto(Date dataStipulaPatto) {
		this.dataStipulaPatto = dataStipulaPatto;
	}

	public Persona getAutoreStipulaPatto() {
		return autoreStipulaPatto;
	}

	public void setAutoreStipulaPatto(Persona autoreStipulaPatto) {
		this.autoreStipulaPatto = autoreStipulaPatto;
	}

	public Date getDataRientroPrevista() {
		return dataRientroPrevista;
	}

	public void setDataRientroPrevista(Date dataRientroPrevista) {
		this.dataRientroPrevista = dataRientroPrevista;
	}

	public Date getDataRientro() {
		return dataRientro;
	}

	public void setDataRientro(Date dataRientro) {
		this.dataRientro = dataRientro;
	}

	public Persona getAutoreRientro() {
		return autoreRientro;
	}

	public void setAutoreRientro(Persona autoreRientro) {
		this.autoreRientro = autoreRientro;
	}

	public Character getFlagProlungamento() {
		if (flagProlungamento == null)
			return 'N';
		return flagProlungamento;
	}

	public void setFlagProlungamento(Character flagProlungamento) {
		this.flagProlungamento = flagProlungamento;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Integer getNumeroCarriera() {
		return numeroCarriera;
	}

	public void setNumeroCarriera(Integer numeroCarriera) {
		this.numeroCarriera = numeroCarriera;
	}

	public Carriera getCarriera() {
		return carriera;
	}

	public void setCarriera(Carriera carriera) {
		this.carriera = carriera;
	}

	public Offerta getOfferta() {
		return getCandidatura().getOffertaInDisponibilita().getOfferta();
	}

	public Date getDataInvioNomina() {
		return dataInvioNomina;
	}

	public void setDataInvioNomina(Date dataInvioNomina) {
		this.dataInvioNomina = dataInvioNomina;
	}

	public Persona getAutoreInvioNomina() {
		return autoreInvioNomina;
	}

	public void setAutoreInvioNomina(Persona autoreInvioNomina) {
		this.autoreInvioNomina = autoreInvioNomina;
	}
	
	// Ateneo destinazione se definito altrimenti Ateneo beneficiario se definito altrimenti ateneo referente
	public Ateneo getAteneo() {
		if (getAteneoDestinazione() != null)
			return getAteneoDestinazione();
		return candidatura.getOffertaInDisponibilita().getOfferta().getAteneo();
	}

	public Date getDataAccettazioneNomina() {
		return dataAccettazioneNomina;
	}

	public void setDataAccettazioneNomina(Date dataAccettazioneNomina) {
		this.dataAccettazioneNomina = dataAccettazioneNomina;
	}

	public Persona getAutoreAccettazioneNomina() {
		return autoreAccettazioneNomina;
	}

	public void setAutoreAccettazioneNomina(Persona autoreAccettazioneNomina) {
		this.autoreAccettazioneNomina = autoreAccettazioneNomina;
	}

	public Integer getPeriodoDiPermanenzaNomina() {
		return periodoDiPermanenzaNomina;
	}

	public void setPeriodoDiPermanenzaNomina(Integer periodoDiPermanenzaNomina) {
		this.periodoDiPermanenzaNomina = periodoDiPermanenzaNomina;
	}

	public OpzioneOfferta getOpzioneOffertaDefinitiva() {
		return opzioneOffertaDefinitiva;
	}

	public void setOpzioneOffertaDefinitiva(OpzioneOfferta opzioneOffertaDefinitiva) {
		this.opzioneOffertaDefinitiva = opzioneOffertaDefinitiva;
	}

	public Integer getPeriodoDiPermanenzaDefinitivo() {
		return periodoDiPermanenzaDefinitivo;
	}

	public void setPeriodoDiPermanenzaDefinitivo(
			Integer periodoDiPermanenzaDefinitivo) {
		this.periodoDiPermanenzaDefinitivo = periodoDiPermanenzaDefinitivo;
	}

	public String getIdDocumentoAccettazione() {
		return idDocumentoAccettazione;
	}

	public void setIdDocumentoAccettazione(String idDocumentoAccettazione) {
		this.idDocumentoAccettazione = idDocumentoAccettazione;
	}

	public String getNomeDocumentoAccettazione() {
		return nomeDocumentoAccettazione;
	}

	public void setNomeDocumentoAccettazione(String nomeDocumentoAccettazione) {
		this.nomeDocumentoAccettazione = nomeDocumentoAccettazione;
	}

	public MultipartFile getDocDocumentoAccettazione() {
		return docDocumentoAccettazione;
	}

	public void setDocDocumentoAccettazione(MultipartFile docDocumentoAccettazione) {
		this.docDocumentoAccettazione = docDocumentoAccettazione;
	}
	
	public Bando getBando() {
		return getCandidatura() != null ? getCandidatura().getBando() : null;
	}
	
	public String getLabelPerStudente() {
		Bando bando = getBando();
		Ateneo ateneo = getAteneo();
		return (bando != null ? bando.getLabel() : "") + " - " + (ateneo != null ? ateneo.getRagioneSociale() : "");  
	}

	public String getAteneoLabel() {
		Ateneo ateneo = getAteneo();
		if (ateneo == null)
			return "";
		return ateneo.getCodiceNazionale() + " - " + ateneo.getRagioneSociale();
	}
	
	public String getAteneoDestinazioneLabel() {
		Ateneo ateneo = getAteneoDestinazione();
		if (ateneo == null)
			return "";
		return ateneo.getCodiceNazionale() + " - " + ateneo.getRagioneSociale();
	}
	
	public String getColor() {
		return StatoStudenteOutgoing.get(stato).getColor();
	}
	
	public String getColorDesc() {
		return StatoStudenteOutgoing.get(stato).getValore();
	}

	public Date getDataRinuncia() {
		return dataRinuncia;
	}

	public void setDataRinuncia(Date dataRinuncia) {
		this.dataRinuncia = dataRinuncia;
	}

	public Persona getAutoreRinuncia() {
		return autoreRinuncia;
	}

	public void setAutoreRinuncia(Persona autoreRinuncia) {
		this.autoreRinuncia = autoreRinuncia;
	}

	public boolean isRinunciato() {
		return StatoStudenteOutgoing.RINUNCIATO.getValore().equals(getStato());
	}
	
	public boolean isRinunciatoDaPartito() {
		return StatoStudenteOutgoing.RINUNCIATO_DA_PARTITO.getValore().equals(getStato());
	}
	
	public boolean isRinunciatoDaRientrato() {
		return StatoStudenteOutgoing.RINUNCIATO_DA_RIENTRATO.getValore().equals(getStato());
	}

	public boolean isRevocato() {
		return StatoStudenteOutgoing.REVOCATO.getValore().equals(getStato());
	}
	
	public Nazione getNazionePartner() {
		if (getCandidatura() != null && getCandidatura().getOffertaInDisponibilita() != null && getCandidatura().getOffertaInDisponibilita().getOfferta() != null)
			return getCandidatura().getOffertaInDisponibilita().getOfferta().getAteneo().getNazionalita();
		return null;
	}

	public Set<LearningAgreement> getLearningAgreements() {
		return learningAgreements;
	}

	public void setLearningAgreements(Set<LearningAgreement> learningAgreements) {
		this.learningAgreements = learningAgreements;
	}
	
	public void addLearningAgreement(LearningAgreement la) {
		if (learningAgreements == null)
			learningAgreements = new HashSet<LearningAgreement>();
		learningAgreements.add(la);
	}
	
	public LearningAgreement getCurrentLearningAgreement() {
		if (learningAgreements == null || learningAgreements.isEmpty())
			return null;
		LearningAgreement la = null;
		for (LearningAgreement l: learningAgreements)
			if (la == null)
				la = l;
			else if (la.getVersione() < l.getVersione()
						|| (la.getVersione().equals(l.getVersione()) && la.getIterazione() < l.getIterazione()))
			{
					if ((!isRientrato() && !isRientroDichiarato()) || l.isPresentato() || l.isValidato() || l.isApprovato())
						la = l;
			}
			else if ((isRientrato() || isRientroDichiarato()) && (la.isDaPresentare() || la.isRifiutato()) && (l.isPresentato() || l.isValidato() || l.isApprovato()))
				la = l;
		return la;
	}
	
	public LearningAgreement getCurrentLearningAgreementPerUploadDocFirmato() {
		if (learningAgreements == null || learningAgreements.isEmpty())
			return null;
//		// nei casi di modifiche di LA di bandi erasmus+ a partire dal 15/16 il documento firmato va allegato solo alla versione 1
//		if (getSottoProgramma().isErasmusPlusStudio() && getBando().getPeriodoMobilita().getAnnoAccademico() >= 2015)
//			for (LearningAgreement l: learningAgreements)
//				if (l.getVersione() != null && l.getVersione().equals(new Integer(1)) && l.isApprovato())
//					return l;
		
		LearningAgreement la = null;
		for (LearningAgreement l: learningAgreements)
			if (la == null)
				la = l;
			else if (la.getVersione() < l.getVersione()
						|| (la.getVersione().equals(l.getVersione()) && la.getIterazione() < l.getIterazione()))
			{
					if ((!isRientrato() && !isRientroDichiarato() && !l.isRifiutato()) || l.isPresentato() || l.isValidato() || l.isApprovato())
						la = l;
			}
			else if ((isRientrato() || isRientroDichiarato()) && (la.isDaPresentare() || la.isRifiutato()) && (l.isPresentato() || l.isValidato() || l.isApprovato()))
				la = l;
		return la;
	}
	
	public boolean isUnLearingAgreementApprovatoConDocumentoDiApprovazione() {
		Set<LearningAgreement> las = getLearningAgreements();
		boolean flag = false;
		if (las!=null) {
			Iterator<LearningAgreement> i = las.iterator();
			while(i.hasNext()) {
				LearningAgreement la = i.next();
				if (la.isApprovato())
					if (la.getIdDocumentoApprovazione()!=null && StringUtils.isNotBlank(la.getIdDocumentoApprovazione()))
						flag = true;
			}
		}
		return flag;
	}

	public String getBandoLbl()	{
		return !StringUtils.isEmpty(getCandidatura().getOffertaInDisponibilita().getDisponibilita().getBando().getTesto()) ? getCandidatura().getOffertaInDisponibilita().getDisponibilita().getBando().getTesto() : "";
	}
	
	public AccordoOperativo getAccordoOperativo() {
		if (getCandidatura() != null && getCandidatura().getOffertaInDisponibilita() != null && getCandidatura().getOffertaInDisponibilita().getOfferta() != null && getCandidatura().getOffertaInDisponibilita().getOfferta().getFlussoScambioEsecuzione() != null)
			return getCandidatura().getOffertaInDisponibilita().getOfferta().getFlussoScambioEsecuzione().getAccordoOperativo();
		return null;
	}
	public PeriodoMobilita getPeriodoMobilita() {
		if (getCandidatura() != null && getCandidatura().getOffertaInDisponibilita() != null && getCandidatura().getOffertaInDisponibilita().getOfferta() != null && getCandidatura().getOffertaInDisponibilita().getOfferta().getFlussoScambioEsecuzione() != null)
			return getCandidatura().getOffertaInDisponibilita().getOfferta().getFlussoScambioEsecuzione().getPeriodoMobilita();
		return null;
	}

	public SottoProgramma getSottoProgramma() {
		return getCandidatura() != null ? getCandidatura().getSottoprogrammaOfferta() : null;
	}

	public Programma getProgramma() {
		return getCandidatura() != null ? getCandidatura().getProgrammaOfferta() : null;
	}
	
	public boolean isConRilevazioneLivLinguistico(){
		SottoProgramma sp = getSottoProgramma() ;
		return  (sp != null) && sp.isRilevaLivLinguistico();
	}

	public String getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}

	public String getCodInd() {
		return codInd;
	}

	public void setCodInd(String codInd) {
		this.codInd = codInd;
	}

	public String getCodOri() {
		return codOri;
	}

	public void setCodOri(String codOri) {
		this.codOri = codOri;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	
	public String getFacCorso() {
		String ret = "";
		if (getCorso() != null)
			ret += (getCorso().getCorsoView() != null ? getCorso().getCorsoView().getDescrizioneFacolta() : "") + " - " + getCorso().getDescrizione();
		return ret;
	}
	
	public String getReferentiLabel() {
		String ret = "";
		for (ReferenteStudenteOutgoingView r: getReferentiStudenteOutgoing())
			if (!r.isCoordinatoreCorso())
				ret += r.getCognome() + " " + r.getNome() + " - ";
		return StringUtils.isNotBlank(ret) ? ret.substring(0, ret.length() - 3) : "";
	}

	public Set<ReferenteStudenteOutgoingView> getReferentiStudenteOutgoing() {
		return referentiStudenteOutgoing;
	}

	public void setReferentiStudenteOutgoing(
			Set<ReferenteStudenteOutgoingView> referentiStudenteOutgoing) {
		this.referentiStudenteOutgoing = referentiStudenteOutgoing;
	}
	
	public boolean isIniziale() {
		return StatoStudenteOutgoing.INIZIALE.getValore().equals(stato);
	}
	
	public Integer getPeriodo() {
		if (getPeriodoDiPermanenzaDefinitivo() != null)
			return getPeriodoDiPermanenzaDefinitivo();
		return getPeriodoDiPermanenzaNomina();
	}
	
	public String getPeriodoMsgKey() {
		return PeriodoPermanenzaOutgoing.get(getPeriodo()).getMessageKey();
	}

	public Character getFlagConBorsa() {
		if (flagConBorsa == null)
			return 'S';
		return flagConBorsa;
	}

	public void setFlagConBorsa(Character flagConBorsa) {
		this.flagConBorsa = flagConBorsa;
	}
	
	public boolean isConBorsa() {
		return Common.CH_S.equals(flagConBorsa);
	}

	public Character getFlagContrattoFirmato() {
		if (flagContrattoFirmato == null)
			return 'N';
		return flagContrattoFirmato;
	}

	public void setFlagContrattoFirmato(Character flagContrattoFirmato) {
		this.flagContrattoFirmato = flagContrattoFirmato;
	}
	
	public boolean isContrattoFirmato() {
		return Common.CH_S.equals(getFlagContrattoFirmato());
	}

	public Persona getAutoreCotnrattoFirmato() {
		return autoreCotnrattoFirmato;
	}

	public void setAutoreCotnrattoFirmato(Persona autoreCotnrattoFirmato) {
		this.autoreCotnrattoFirmato = autoreCotnrattoFirmato;
	}

	public Date getDataContrattoFirmato() {
		return dataContrattoFirmato;
	}

	public void setDataContrattoFirmato(Date dataContrattoFirmato) {
		this.dataContrattoFirmato = dataContrattoFirmato;
	}

	public ModalitaDiPagamento getModalitaDiPagamento() {
		return modalitaDiPagamento;
	}

	public void setModalitaDiPagamento(ModalitaDiPagamento modalitaDiPagamento) {
		this.modalitaDiPagamento = modalitaDiPagamento;
	}

	public Character getFlagDivulgazioneEmail() {
		return flagDivulgazioneEmail;
	}

	public void setFlagDivulgazioneEmail(Character flagDivulgazioneEmail) {
		this.flagDivulgazioneEmail = flagDivulgazioneEmail;
	}
	
	public boolean isDivulgazioneEmailConsentita() {
		return Common.CH_S.equals(getFlagDivulgazioneEmail());
	}
	
	public boolean isDivulgazioneEmailNonConsentita() {
		return Common.CH_N.equals(getFlagDivulgazioneEmail());
	}

	public String getNoteRinuncia() {
		return noteRinuncia;
	}

	public void setNoteRinuncia(String noteRinuncia) {
		this.noteRinuncia = noteRinuncia;
	}

	public boolean isPartito() {
		return StatoStudenteOutgoing.PARTITO.getValore().equals(stato);
	}

	public boolean isAlmenoPartito() {
		return !StatoStudenteOutgoing.INIZIALE.getValore().equals(stato) 
				&& !StatoStudenteOutgoing.ARRIVO_DICHIARATO.getValore().equals(stato)
				&& !StatoStudenteOutgoing.RINUNCIATO.getValore().equals(stato)
				&& !StatoStudenteOutgoing.RINUNCIATO_DA_PARTITO.getValore().equals(stato);
	}
	
	public boolean isAlmenoArrivoDichiarato() {
		return !StatoStudenteOutgoing.INIZIALE.getValore().equals(stato) 
				&& !StatoStudenteOutgoing.RINUNCIATO.getValore().equals(stato)
				&& !StatoStudenteOutgoing.RINUNCIATO_DA_PARTITO.getValore().equals(stato);
	}
	
	public Date getDataDichiarazioneArrivo() {
		return dataDichiarazioneArrivo;
	}

	public void setDataDichiarazioneArrivo(Date dataDichiarazioneArrivo) {
		this.dataDichiarazioneArrivo = dataDichiarazioneArrivo;
	}

	public Persona getAutoreDichiarazioneArrivo() {
		return autoreDichiarazioneArrivo;
	}

	public void setAutoreDichiarazioneArrivo(Persona autoreDichiarazioneArrivo) {
		this.autoreDichiarazioneArrivo = autoreDichiarazioneArrivo;
	}

	public Date getDataValidazioneDichiarazioneArrivo() {
		return dataValidazioneDichiarazioneArrivo;
	}

	public void setDataValidazioneDichiarazioneArrivo(
			Date dataValidazioneDichiarazioneArrivo) {
		this.dataValidazioneDichiarazioneArrivo = dataValidazioneDichiarazioneArrivo;
	}

	public Persona getAutoreValidazioneDichiarazioneArrivo() {
		return autoreValidazioneDichiarazioneArrivo;
	}

	public void setAutoreValidazioneDichiarazioneArrivo(
			Persona autoreValidazioneDichiarazioneArrivo) {
		this.autoreValidazioneDichiarazioneArrivo = autoreValidazioneDichiarazioneArrivo;
	}

	public String getIdDocumentoDiArrivo() {
		return idDocumentoDiArrivo;
	}

	public void setIdDocumentoDiArrivo(String idDocumentoDiArrivo) {
		this.idDocumentoDiArrivo = idDocumentoDiArrivo;
	}

	public String getNomeDocumentoDiArrivo() {
		return nomeDocumentoDiArrivo;
	}

	public void setNomeDocumentoDiArrivo(String nomeDocumentoDiArrivo) {
		this.nomeDocumentoDiArrivo = nomeDocumentoDiArrivo;
	}

	public MultipartFile getDocumentoDiArrivo() {
		return documentoDiArrivo;
	}

	public void setDocumentoDiArrivo(MultipartFile documentoDiArrivo) {
		this.documentoDiArrivo = documentoDiArrivo;
	}

	public boolean isArrivoDichiarato() {
		return StatoStudenteOutgoing.ARRIVO_DICHIARATO.getValore().equals(getStato());
	}
	
	public boolean isRientrato() {
		return StatoStudenteOutgoing.RIENTRATO.getValore().equals(getStato());
	}

	public Minicarriera getMinicarriera() {
		return minicarriera;
	}

	public void setMinicarriera(Minicarriera minicarriera) {
		this.minicarriera = minicarriera;
	}

	public String getCodiceAnagraficoCia() {
		return codiceAnagraficoCia;
	}

	public void setCodiceAnagraficoCia(String codiceAnagraficoCia) {
		this.codiceAnagraficoCia = codiceAnagraficoCia;
	}

	public Ateneo getAteneoDestinazione() {
		return ateneoDestinazione;
	}

	public void setAteneoDestinazione(Ateneo ateneoDestinazione) {
		this.ateneoDestinazione = ateneoDestinazione;
	}

	public boolean isDottorando() {
		Carriera carriera = getCarriera();
		if (carriera != null)
			return carriera.isDottorato();
		return false;
	}

	public String getNoteRifiutoDichiarazioneArrivo() {
		return noteRifiutoDichiarazioneArrivo;
	}

	public void setNoteRifiutoDichiarazioneArrivo(
			String noteRifiutoDichiarazioneArrivo) {
		this.noteRifiutoDichiarazioneArrivo = noteRifiutoDichiarazioneArrivo;
	}

	public String getNoteValidazioneDichiarazioneArrivo() {
		return noteValidazioneDichiarazioneArrivo;
	}

	public void setNoteValidazioneDichiarazioneArrivo(
			String noteValidazioneDichiarazioneArrivo) {
		this.noteValidazioneDichiarazioneArrivo = noteValidazioneDichiarazioneArrivo;
	}
	
	public boolean isProlungato() {
		return Common.CH_S.equals(getFlagProlungamento());
	}
	
	public boolean isProlungamentoRichiesto() {
		return Common.CH_P.equals(getFlagProlungamento());
	}
	
	public boolean isProlungamentoRifiutato() {
		return Common.CH_R.equals(getFlagProlungamento());
	}
	
	public boolean isProlungamentoNonRichiesto() {
		return Common.CH_N.equals(getFlagProlungamento());
	}

	public String getIdDocumentoRichiestaProlungamento() {
		return idDocumentoRichiestaProlungamento;
	}

	public void setIdDocumentoRichiestaProlungamento(
			String idDocumentoRichiestaProlungamento) {
		this.idDocumentoRichiestaProlungamento = idDocumentoRichiestaProlungamento;
	}

	public String getNomeDocumentoRichiestaProlungamento() {
		return nomeDocumentoRichiestaProlungamento;
	}

	public void setNomeDocumentoRichiestaProlungamento(
			String nomeDocumentoRichiestaProlungamento) {
		this.nomeDocumentoRichiestaProlungamento = nomeDocumentoRichiestaProlungamento;
	}

	public Integer getDurataProlungamento() {
		return durataProlungamento;
	}

	public void setDurataProlungamento(Integer durataProlungamento) {
		this.durataProlungamento = durataProlungamento;
	}

	public Persona getAutoreValidazioneRichiestaProlungamento() {
		return autoreValidazioneRichiestaProlungamento;
	}

	public void setAutoreValidazioneRichiestaProlungamento(
			Persona autoreValidazioneRichiestaProlungamento) {
		this.autoreValidazioneRichiestaProlungamento = autoreValidazioneRichiestaProlungamento;
	}

	public Date getDataValidazioneRichiestaProlungamento() {
		return dataValidazioneRichiestaProlungamento;
	}

	public void setDataValidazioneRichiestaProlungamento(
			Date dataValidazioneRichiestaProlungamento) {
		this.dataValidazioneRichiestaProlungamento = dataValidazioneRichiestaProlungamento;
	}

	public MultipartFile getDocumentoRichiestaProlungamento() {
		return documentoRichiestaProlungamento;
	}

	public void setDocumentoRichiestaProlungamento(
			MultipartFile documentoRichiestaProlungamento) {
		this.documentoRichiestaProlungamento = documentoRichiestaProlungamento;
	}
	
	public boolean isStudenteMaster() {
		return getCarriera() == null ? false : (getCarriera().getTipoCorso().getId().equals("M1") || getCarriera().getTipoCorso().getId().equals("M2"));
	}

	public void setImportiIntermediRate(List<String> importiIntermediRate) {
		this.importiIntermediRate = importiIntermediRate;
	}

	public List<String> getImportiIntermediRate() {
		return importiIntermediRate;
	}

	public String getNoteRifiutoProlungamento() {
		return noteRifiutoProlungamento;
	}

	public void setNoteRifiutoProlungamento(String noteRifiutoProlungamento) {
		this.noteRifiutoProlungamento = noteRifiutoProlungamento;
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
		if (!(obj instanceof StudenteOutgoing))
			return false;
		StudenteOutgoing other = (StudenteOutgoing) obj;
		if (candidatura == null) {
			if (other.candidatura != null)
				return false;
		} else if (!candidatura.equals(other.candidatura))
			return false;
		return true;
	}

	public Date getDataDichiarazioneRientro() {
		return dataDichiarazioneRientro;
	}

	public void setDataDichiarazioneRientro(Date dataDichiarazioneRientro) {
		this.dataDichiarazioneRientro = dataDichiarazioneRientro;
	}

	public Persona getAutoreDichiarazioneRientro() {
		return autoreDichiarazioneRientro;
	}

	public void setAutoreDichiarazioneRientro(Persona autoreDichiarazioneRientro) {
		this.autoreDichiarazioneRientro = autoreDichiarazioneRientro;
	}

	public Date getDataValidazioneDichiarazioneRientro() {
		return dataValidazioneDichiarazioneRientro;
	}

	public void setDataValidazioneDichiarazioneRientro(
			Date dataValidazioneDichiarazioneRientro) {
		this.dataValidazioneDichiarazioneRientro = dataValidazioneDichiarazioneRientro;
	}

	public Persona getAutoreValidazioneDichiarazioneRientro() {
		return autoreValidazioneDichiarazioneRientro;
	}

	public void setAutoreValidazioneDichiarazioneRientro(
			Persona autoreValidazioneDichiarazioneRientro) {
		this.autoreValidazioneDichiarazioneRientro = autoreValidazioneDichiarazioneRientro;
	}

	public String getIdDocumentoRientro() {
		return idDocumentoRientro;
	}

	public void setIdDocumentoRientro(String idDocumentoRientro) {
		this.idDocumentoRientro = idDocumentoRientro;
	}

	public String getNomeDocumentoRientro() {
		return nomeDocumentoRientro;
	}

	public void setNomeDocumentoRientro(String nomeDocumentoRientro) {
		this.nomeDocumentoRientro = nomeDocumentoRientro;
	}
	
	public boolean isRientroDichiarato() {
		return StatoStudenteOutgoing.RIENTRO_DICHIARATO.getValore().equals(getStato());
	}

	public MultipartFile getDocumentoRientro() {
		return documentoRientro;
	}

	public void setDocumentoRientro(MultipartFile documentoRientro) {
		this.documentoRientro = documentoRientro;
	}

	public String getNoteRifiutoDichiarazioneRientro() {
		return noteRifiutoDichiarazioneRientro;
	}

	public void setNoteRifiutoDichiarazioneRientro(
			String noteRifiutoDichiarazioneRientro) {
		this.noteRifiutoDichiarazioneRientro = noteRifiutoDichiarazioneRientro;
	}

	public String getNoteValidazioneDichiarazioneRientro() {
		return noteValidazioneDichiarazioneRientro;
	}

	public void setNoteValidazioneDichiarazioneRientro(
			String noteValidazioneDichiarazioneRientro) {
		this.noteValidazioneDichiarazioneRientro = noteValidazioneDichiarazioneRientro;
	}

	public Coorte getCoorte() {
		return coorte;
	}

	public void setCoorte(Coorte coorte) {
		this.coorte = coorte;
	}

	public String getDescrizioneCoorte() {
		return coorte != null ? coorte.getDescrizione() : "";
	}
	
	public boolean isCompilazioneSOAttiva() {
		return getBando().isGestionePeriodoScambioPerStudentiAttiva();
	}

	public Integer getDurataAbbreviazione() {
		return durataAbbreviazione;
	}

	public void setDurataAbbreviazione(Integer durataAbbreviazione) {
		this.durataAbbreviazione = durataAbbreviazione;
	}

	public Character getFlagAbbreviazione() {
		if (flagAbbreviazione == null)
			return 'N';
		return flagAbbreviazione;
	}

	public void setFlagAbbreviazione(Character flagAbbreviazione) {
		this.flagAbbreviazione = flagAbbreviazione;
	}

	public String getIdDocumentoRichiestaAbbreviazione() {
		return idDocumentoRichiestaAbbreviazione;
	}

	public void setIdDocumentoRichiestaAbbreviazione(
			String idDocumentoRichiestaAbbreviazione) {
		this.idDocumentoRichiestaAbbreviazione = idDocumentoRichiestaAbbreviazione;
	}

	public String getNomeDocumentoRichiestaAbbreviazione() {
		return nomeDocumentoRichiestaAbbreviazione;
	}

	public void setNomeDocumentoRichiestaAbbreviazione(
			String nomeDocumentoRichiestaAbbreviazione) {
		this.nomeDocumentoRichiestaAbbreviazione = nomeDocumentoRichiestaAbbreviazione;
	}

	public Persona getAutoreValidazioneRichiestaAbbreviazione() {
		return autoreValidazioneRichiestaAbbreviazione;
	}

	public void setAutoreValidazioneRichiestaAbbreviazione(
			Persona autoreValidazioneRichiestaAbbreviazione) {
		this.autoreValidazioneRichiestaAbbreviazione = autoreValidazioneRichiestaAbbreviazione;
	}

	public Date getDataValidazioneRichiestaAbbreviazione() {
		return dataValidazioneRichiestaAbbreviazione;
	}

	public void setDataValidazioneRichiestaAbbreviazione(
			Date dataValidazioneRichiestaAbbreviazione) {
		this.dataValidazioneRichiestaAbbreviazione = dataValidazioneRichiestaAbbreviazione;
	}

	public String getNoteRifiutoAbbreviazione() {
		return noteRifiutoAbbreviazione;
	}

	public void setNoteRifiutoAbbreviazione(String noteRifiutoAbbreviazione) {
		this.noteRifiutoAbbreviazione = noteRifiutoAbbreviazione;
	}
	
	public boolean isAbbreviato() {
		return Common.CH_S.equals(getFlagAbbreviazione());
	}
	
	public boolean isAbbreviazioneRichiesta() {
		return Common.CH_P.equals(getFlagAbbreviazione());
	}
	
	public boolean isAbbreviazioneRifiutata() {
		return Common.CH_R.equals(getFlagAbbreviazione());
	}
	
	public boolean isAbbreviazioneNonRichiesta() {
		return Common.CH_N.equals(getFlagAbbreviazione());
	}

	public MultipartFile getDocumentoRichiestaAbbreviazione() {
		return documentoRichiestaAbbreviazione;
	}

	public void setDocumentoRichiestaAbbreviazione(
			MultipartFile documentoRichiestaAbbreviazione) {
		this.documentoRichiestaAbbreviazione = documentoRichiestaAbbreviazione;
	}

	public void setImportoNuovaRata(String importoNuovaRata) {
		this.importoNuovaRata = importoNuovaRata;
	}

	public String getImportoNuovaRata() {
		return importoNuovaRata;
	}

	public Set<RichiestaRiconoscimento> getRichiesteRiconoscimento() {
		return richiesteRiconoscimento;
	}

	public void setRichiesteRiconoscimento(
			Set<RichiestaRiconoscimento> richiesteRiconoscimento) {
		this.richiesteRiconoscimento = richiesteRiconoscimento;
	}
	
	public RichiestaRiconoscimento getCurrentRichiestaRiconoscimento() {
		if (richiesteRiconoscimento == null || richiesteRiconoscimento.isEmpty())
			return null;
		RichiestaRiconoscimento rr = null;
		for (RichiestaRiconoscimento l: richiesteRiconoscimento)
			if (rr == null)
				rr = l;
			else
				if (rr.getVersione() < l.getVersione() || (rr.getVersione().equals(l.getVersione()) && rr.getIterazione() < l.getIterazione()))
					rr = l;
		return rr;
	}

	public Integer getDurataEffettiva() {
		return durataEffettiva;
	}

	public void setDurataEffettiva(Integer durataEffettiva) {
		this.durataEffettiva = durataEffettiva;
	}

	public void setNumeroNuovaRata(Long numeroNuovaRata) {
		this.numeroNuovaRata = numeroNuovaRata;
	}

	public Long getNumeroNuovaRata() {
		return numeroNuovaRata;
	}

	public MultipartFile getDocumentoTR() {
		return documentoTR;
	}

	public void setDocumentoTR(MultipartFile documentoTR) {
		this.documentoTR = documentoTR;
	}

	public String getIdDocumentoTR() {
		return idDocumentoTR;
	}

	public void setIdDocumentoTR(String idDocumentoTR) {
		this.idDocumentoTR = idDocumentoTR;
	}

	public String getNomeDocumentoTR() {
		return nomeDocumentoTR;
	}

	public void setNomeDocumentoTR(String nomeDocumentoTR) {
		this.nomeDocumentoTR = nomeDocumentoTR;
	}

	public Character getFlagTR() {
		if (flagTR == null)
			return 'D';
		return flagTR;
	}

	public void setFlagTR(Character flagTR) {
		this.flagTR = flagTR;
	}

	public Persona getAutoreUploadTR() {
		return autoreUploadTR;
	}

	public void setAutoreUploadTR(Persona autoreUploadTR) {
		this.autoreUploadTR = autoreUploadTR;
	}

	public Persona getAutoreValidazioneTR() {
		return autoreValidazioneTR;
	}

	public void setAutoreValidazioneTR(Persona autoreValidazioneTR) {
		this.autoreValidazioneTR = autoreValidazioneTR;
	}

	public Date getDataValidazioneTR() {
		return dataValidazioneTR;
	}

	public void setDataValidazioneTR(Date dataValidazioneTR) {
		this.dataValidazioneTR = dataValidazioneTR;
	}
	
	public boolean isTRDaValidare() {
		return Common.CH_S.equals(getFlagTR());
	}
	
	public boolean isTRValidato() {
		return Common.CH_V.equals(getFlagTR());
	}
	
	public boolean isTRValido() {
		return Common.CH_V.equals(getFlagTR()) || Common.CH_U.equals(getFlagTR());
	}
	
	public boolean isTRRifiutato() {
		return Common.CH_R.equals(getFlagTR());
	}
	
	public boolean isTRAssente() {
		return Common.CH_D.equals(getFlagTR());
	}
	
	public boolean isTRCaricatoDaUffici() {
		return Common.CH_U.equals(getFlagTR());
	}

	public String getNoteRifiutoValidazioneTR() {
		return noteRifiutoValidazioneTR;
	}

	public void setNoteRifiutoValidazioneTR(String noteRifiutoValidazioneTR) {
		this.noteRifiutoValidazioneTR = noteRifiutoValidazioneTR;
	}

	public ContattoUnibo getContattoUnibo() {
		if (contattoUnibo == null)
			throw new RuntimeException("Prima di utilizzare questo e' necessario compilarlo!");
		return contattoUnibo;
	}

	public void setContattoUnibo(ContattoUnibo contattoUnibo) {
		this.contattoUnibo = contattoUnibo;
	}

	public StudenteOutgoingInfo getStudenteOutgoingInfo() {
		return studenteOutgoingInfo;
	}

	public void setStudenteOutgoingInfo(StudenteOutgoingInfo studenteOutgoingInfo) {
		this.studenteOutgoingInfo = studenteOutgoingInfo;
	}

	public Character getFlagRelazioneFinaleConsegnata() {
		/*if (flagRelazioneFinaleConsegnata == null)
			return 'N';*/
		return flagRelazioneFinaleConsegnata;
	}

	public void setFlagRelazioneFinaleConsegnata(
			Character flagRelazioneFinaleConsegnata) {
		this.flagRelazioneFinaleConsegnata = flagRelazioneFinaleConsegnata;
	}
	
	public boolean isRelazioneFinaleConsegnata() {
		return Common.CH_S.equals(getFlagRelazioneFinaleConsegnata());
	}

	public Persona getAutoreRelazioneFinaleConsegnata() {
		return autoreRelazioneFinaleConsegnata;
	}

	public void setAutoreRelazioneFinaleConsegnata(
			Persona autoreRelazioneFinaleConsegnata) {
		this.autoreRelazioneFinaleConsegnata = autoreRelazioneFinaleConsegnata;
	}

	public Date getDataRelazioneFinaleConsegnata() {
		return dataRelazioneFinaleConsegnata;
	}

	public void setDataRelazioneFinaleConsegnata(Date dataRelazioneFinaleConsegnata) {
		this.dataRelazioneFinaleConsegnata = dataRelazioneFinaleConsegnata;
	}

	public Character getFlagQuestionarioCompilato() {
/*		if (flagQuestionarioCompilato == null)
			return 'N';*/
		return flagQuestionarioCompilato;
	}

	public void setFlagQuestionarioCompilato(Character flagQuestionarioCompilato) {
		this.flagQuestionarioCompilato = flagQuestionarioCompilato;
	}
	
	public boolean isQuestionarioCompilato() {
		return Common.CH_S.equals(getFlagQuestionarioCompilato());		
	}
	
	// DURATA TEORICA PREVISTA INIZIALE/CONTRATTUALE con lo studente (Overseas in semestri per gli altri in Mesi).
	// Per Erasmus studio : la durata prevista quando valorizzata (perche' diversa da quella della offerta) puo' 
	// essere modificta solo fino alla creazione della rata di anticipo e in teoria non dovrebbe essere modificabile 
	// neanche se il contratto dello studente e' validato)
	public Long getDurata() {
		if (getDurataPrevista() != null)
			return getDurataPrevista();
		return getDurataPrevistaOfferta();
	}

	public Long getDurataPrevistaOfferta() {
		Long durata = null;
		if (getCandidatura()!=null) {
			durata = getCandidatura().getDurataPrevista();
			if (durata == null) {
				durata = getCandidatura().getDurataPrevistaDaDatiPlacement();
				if (durata == null) {
					durata = getCandidatura().getDurataPrevistaDalFlusso();
				}
			}
		}
		return durata;
	}

	public boolean isDurataPrevistaComeOfferta() {
		return durataPrevista == null ? true : durataPrevista.equals(getDurataPrevistaOfferta());
	}
	
	public Long getDurataPrevista() {
		return durataPrevista;
	}

	public void setDurataPrevista(Long durataPrevista) {
		this.durataPrevista = durataPrevista;
	}

	public UnitaMisuraDurata getUnitaMisuraDurataPrevista() {
		return unitaMisuraDurataPrevista;
	}

	public void setUnitaMisuraDurataPrevista(
			UnitaMisuraDurata unitaMisuraDurataPrevista) {
		this.unitaMisuraDurataPrevista = unitaMisuraDurataPrevista;
	}
	
	public UnitaMisuraDurata getUnitaMisuraDurata() {
		if (getUnitaMisuraDurataPrevista() != null)
			return getUnitaMisuraDurataPrevista();
		return getOfferta() != null && getOfferta().getFlussoScambioEsecuzione() != null ? getOfferta().getFlussoScambioEsecuzione().getUnitaMisuraDurata() : null;
	}

	public Date[] getDateScadenzaRate() {
		return dateScadenzaRate;
	}

	public void setDateScadenzaRate(Date[] dateScadenzaRate) {
		this.dateScadenzaRate = dateScadenzaRate;
	}

	public String getDescrizioneNuovaRata() {
		return descrizioneNuovaRata;
	}

	public void setDescrizioneNuovaRata(String descrizioneNuovaRata) {
		this.descrizioneNuovaRata = descrizioneNuovaRata;
	}

	public Date getScadenzaNuovaRata() {
		return scadenzaNuovaRata;
	}

	public void setScadenzaNuovaRata(Date scadenzaNuovaRata) {
		this.scadenzaNuovaRata = scadenzaNuovaRata;
	}

	public String getNoteBorsaStudio() {
		return noteBorsaStudio;
	}

	public void setNoteBorsaStudio(String noteBorsaStudio) {
		this.noteBorsaStudio = noteBorsaStudio;
	}

	public List<String> getDescrizioniRate() {
		return descrizioniRate;
	}

	public void setDescrizioniRate(List<String> descrizioniRate) {
		this.descrizioniRate = descrizioniRate;
	}

	public Date getDataRevoca() {
		return dataRevoca;
	}

	public void setDataRevoca(Date dataRevoca) {
		this.dataRevoca = dataRevoca;
	}

	public Persona getAutoreRevoca() {
		return autoreRevoca;
	}

	public void setAutoreRevoca(Persona autoreRevoca) {
		this.autoreRevoca = autoreRevoca;
	}
	
	public CandidaturaDatiPlacement getDatiPlacement() {
		return getCandidatura().getCandidaturaDatiPlacement();
	}

	public String getIdDocumentoTrainingAgreement() {
		return idDocumentoTrainingAgreement;
	}

	public void setIdDocumentoTrainingAgreement(String idDocumentoTrainingAgreement) {
		this.idDocumentoTrainingAgreement = idDocumentoTrainingAgreement;
	}

	public String getNomeDocumentoTrainingAgreement() {
		return nomeDocumentoTrainingAgreement;
	}

	public void setNomeDocumentoTrainingAgreement(
			String nomeDocumentoTrainingAgreement) {
		this.nomeDocumentoTrainingAgreement = nomeDocumentoTrainingAgreement;
	}

	public MultipartFile getDocumentoTrainingAgreement() {
		return documentoTrainingAgreement;
	}

	public void setDocumentoTrainingAgreement(
			MultipartFile documentoTrainingAgreement) {
		this.documentoTrainingAgreement = documentoTrainingAgreement;
	}

	public Character getFlagTrainingAgreement() {
		return flagTrainingAgreement;
	}

	public void setFlagTrainingAgreement(Character flagTrainingAgreement) {
		this.flagTrainingAgreement = flagTrainingAgreement;
	}
	
	public boolean isTrainingAgreementValidato() {
		return Common.CH_V.equals(getFlagTrainingAgreement());
	}
	
	public boolean isTrainingAgreementRifiutato() {
		return Common.CH_R.equals(getFlagTrainingAgreement());
	}
	
	public boolean isTrainingAgreementDaValidare() {
		return Common.CH_S.equals(getFlagTrainingAgreement());
	}
	
	public String getIdDocumentoRelazioneIndividuale() {
		return idDocumentoRelazioneIndividuale;
	}

	public void setIdDocumentoRelazioneIndividuale(
			String idDocumentoRelazioneIndividuale) {
		this.idDocumentoRelazioneIndividuale = idDocumentoRelazioneIndividuale;
	}

	public String getNomeDocumentoRelazioneIndividuale() {
		return nomeDocumentoRelazioneIndividuale;
	}

	public void setNomeDocumentoRelazioneIndividuale(
			String nomeDocumentoRelazioneIndividuale) {
		this.nomeDocumentoRelazioneIndividuale = nomeDocumentoRelazioneIndividuale;
	}

	public Character getFlagRelazioneIndividuale() {
		return flagRelazioneIndividuale;
	}

	public void setFlagRelazioneIndividuale(Character flagRelazioneIndividuale) {
		this.flagRelazioneIndividuale = flagRelazioneIndividuale;
	}
	
	public boolean isRelazioneIndividualeValidata() {
		return Common.CH_V.equals(getFlagRelazioneIndividuale());
	}
	
	public boolean isRelazioneIndividualeRifiutata() {
		return Common.CH_R.equals(getFlagRelazioneIndividuale());
	}
	
	public String getNomeDocumentoContratto() {
		BandoGruppo bg = getCandidatura().getBandoGruppoCandidatura(); // fino a marzo 2016 era cosi': getCandidatura().getBandoGruppo();
		if (bg != null && bg.getNomeDocumentoContratto() != null) {
			if ("toBeDefined.pdf".equals(bg.getNomeDocumentoContratto()))
				return null;
			return bg.getNomeDocumentoContratto();
		}
		return getBando().getNomeDocumentoContratto();
	}
	
	public String getNomeDocumentoContrattoSchedaFiscale() {
		BandoGruppo bg = getCandidatura().getBandoGruppoCandidatura(); // fino a marzo 2016 era cosi': getCandidatura().getBandoGruppo();
		if (bg != null && bg.getNomeDocumentoContrattoSchedaFiscale() != null)
			return bg.getNomeDocumentoContrattoSchedaFiscale();
		return getBando().getNomeDocumentoContrattoSchedaFiscale();
	}

	public String getNomeDocInfoOutgoing() {
		BandoGruppo bg = getCandidatura().getBandoGruppoCandidatura(); 
		if (bg != null && StringUtils.isNotBlank(bg.getNomeDocInfoOutgoing()))
			return bg.getNomeDocInfoOutgoing();
		
		return getBando().getNomeAllegatoOutgoing();
	}
	
	public String getCodTestoDocInfoOutgoing() {
		BandoGruppo bg = getCandidatura().getBandoGruppoCandidatura(); 
		if (bg != null && StringUtils.isNotBlank(bg.getCodTestoDocInfoOutgoing()))
			return bg.getCodTestoDocInfoOutgoing();
		
		return null;
	}

	public boolean isGestioneAiPoli() {
		BandoGruppo bg = getCandidatura().getBandoGruppoCandidatura(); 
		if (bg != null && bg.getFlagGestioneAiPoli() != null) 
			return bg.isGestioneAiPoli();
		return getBando().isGestioneAiPoli();
	}

	/*
	 * Data limite fine mobilita' personalizzabile per bandoGruppo.
	 * Ritorna: null se nessun limite, altrimenti la data  
	 */
	public Date getDataLimiteFineMobilita() {
		BandoGruppo bg = getCandidatura().getBandoGruppoCandidatura(); 
		if (bg != null && bg.isDataLimiteFineMobilitaAttiva()) {
			return bg.getDataLimiteFineMobilita();
		}
		return getBando().getDataLimiteFineMobilita();
	}
	
	public boolean isPlacement() {
		return candidatura.isPlacement();
	}
	
	/**
	 * Indica se lo scambio appartiene al sotto programma tesi all'estero
	 * @return
	 */
	public boolean isTesiAllEstero() {
		return candidatura.isTesiAllEstero();
	}

	public Date getDataPresentazioneRichiestaProlungamento() {
		return dataPresentazioneRichiestaProlungamento;
	}

	public void setDataPresentazioneRichiestaProlungamento(
			Date dataPresentazioneRichiestaProlungamento) {
		this.dataPresentazioneRichiestaProlungamento = dataPresentazioneRichiestaProlungamento;
	}

	public MultipartFile getDocumentoRelazioneIndividuale() {
		return documentoRelazioneIndividuale;
	}

	public void setDocumentoRelazioneIndividuale(
			MultipartFile documentoRelazioneIndividuale) {
		this.documentoRelazioneIndividuale = documentoRelazioneIndividuale;
	}

	public Persona getAutoreTrainingAgreement() {
		return autoreTrainingAgreement;
	}

	public void setAutoreTrainingAgreement(Persona autoreTrainingAgreement) {
		this.autoreTrainingAgreement = autoreTrainingAgreement;
	}

	public Date getDataTrainingAgreement() {
		return dataTrainingAgreement;
	}

	public void setDataTrainingAgreement(Date dataTrainingAgreement) {
		this.dataTrainingAgreement = dataTrainingAgreement;
	}

	public Persona getAutoreRelazioneIndividuale() {
		return autoreRelazioneIndividuale;
	}

	public void setAutoreRelazioneIndividuale(Persona autoreRelazioneIndividuale) {
		this.autoreRelazioneIndividuale = autoreRelazioneIndividuale;
	}

	public Date getDataRelazioneIndividuale() {
		return dataRelazioneIndividuale;
	}

	public void setDataRelazioneIndividuale(Date dataRelazioneIndividuale) {
		this.dataRelazioneIndividuale = dataRelazioneIndividuale;
	}

	public Persona getAutoreValidazioneTrainingAgreement() {
		return autoreValidazioneTrainingAgreement;
	}

	public void setAutoreValidazioneTrainingAgreement(
			Persona autoreValidazioneTrainingAgreement) {
		this.autoreValidazioneTrainingAgreement = autoreValidazioneTrainingAgreement;
	}

	public Date getDataValidazioneTrainingAgreement() {
		return dataValidazioneTrainingAgreement;
	}

	public void setDataValidazioneTrainingAgreement(
			Date dataValidazioneTrainingAgreement) {
		this.dataValidazioneTrainingAgreement = dataValidazioneTrainingAgreement;
	}

	public Persona getAutoreValidazioneRelazioneIndividuale() {
		return autoreValidazioneRelazioneIndividuale;
	}

	public void setAutoreValidazioneRelazioneIndividuale(
			Persona autoreValidazioneRelazioneIndividuale) {
		this.autoreValidazioneRelazioneIndividuale = autoreValidazioneRelazioneIndividuale;
	}

	public Date getDataValidazioneRelazioneIndividuale() {
		return dataValidazioneRelazioneIndividuale;
	}

	public void setDataValidazioneRelazioneIndividuale(
			Date dataValidazioneRelazioneIndividuale) {
		this.dataValidazioneRelazioneIndividuale = dataValidazioneRelazioneIndividuale;
	}

	public String getNoteRifiutoValidazioneRelazioneIndividuale() {
		return noteRifiutoValidazioneRelazioneIndividuale;
	}

	public void setNoteRifiutoValidazioneRelazioneIndividuale(
			String noteRifiutoValidazioneRelazioneIndividuale) {
		this.noteRifiutoValidazioneRelazioneIndividuale = noteRifiutoValidazioneRelazioneIndividuale;
	}

	public String getNoteRifiutoValidazioneTrainingAgreement() {
		return noteRifiutoValidazioneTrainingAgreement;
	}

	public void setNoteRifiutoValidazioneTrainingAgreement(
			String noteRifiutoValidazioneTrainingAgreement) {
		this.noteRifiutoValidazioneTrainingAgreement = noteRifiutoValidazioneTrainingAgreement;
	}
	
	public boolean isTADaValidare() {
		return Common.CH_S.equals(getFlagTrainingAgreement());
	}
	
	public boolean isTAValidato() {
		return Common.CH_V.equals(getFlagTrainingAgreement());
	}
	
	public boolean isTAValido() {
		return Common.CH_V.equals(getFlagTrainingAgreement()) || Common.CH_U.equals(getFlagTrainingAgreement());
	}
	
	public boolean isTARifiutato() {
		return Common.CH_R.equals(getFlagTrainingAgreement());
	}
	
	public boolean isRelazioneIndividualeDaValidare() {
		return Common.CH_S.equals(getFlagRelazioneIndividuale());
	}
	
	public boolean isRelazioneIndividualeValidato() {
		return Common.CH_V.equals(getFlagRelazioneIndividuale());
	}
	
	public boolean isRelazioneIndividualeValido() {
		return Common.CH_V.equals(getFlagRelazioneIndividuale()) || Common.CH_U.equals(getFlagRelazioneIndividuale());
	}
	
	public boolean isRelazioneIndividualeRifiutato() {
		return Common.CH_R.equals(getFlagRelazioneIndividuale());
	}

	public String getNotePlacement() {
		return notePlacement;
	}

	public void setNotePlacement(String notePlacement) {
		this.notePlacement = notePlacement;
	}
	
	public String getNomeDocAutocertificazioneOutgoing() {
		String nomeDoc = getBando().getNomeDocAutocertificazioneOutgoing();
		if (StringUtils.isNotBlank(nomeDoc) && !nomeDoc.endsWith(".pdf"))
		{
			if (isConBorsa())
				return nomeDoc + "borsa.pdf";
			return nomeDoc + "noborsa.pdf";
		}
		return nomeDoc; 
	}

	/*
	 * Riforma 240/2010
	 * SE non trova nessuna carriera (non dovrebbe succedere)
	 * Oppure se la carriera e' recente o ancora attiva, 
	 * nelle pagine e nelle stampe, sopratutto per lo studente, 
	 * deve comaprtire la scuola del corso e non la facolta'
	 * Se invece trova una carriera ante 2012 (ULTIMO ANNO DI ISCRIZIONE)
	 * e non risulta attiva si visualizza ancora la Facolta' 
	 */
	public boolean isVisualizzaScuola() {
		return (carriera == null) ?  true : carriera.isVisualizzaScuola();
	}

	public Character getFlagEILCRichiesto() {
		return flagEILCRichiesto;
	}

	public void setFlagEILCRichiesto(Character flagEILCRichiesto) {
		this.flagEILCRichiesto = flagEILCRichiesto;
	}
	
	public boolean isEILCRichiesto()  {
		return Common.CH_S.equals(flagEILCRichiesto);
	}

	public String getNoteAnnullamentoValidazioneTR() {
		return noteAnnullamentoValidazioneTR;
	}

	public void setNoteAnnullamentoValidazioneTR(
			String noteAnnullamentoValidazioneTR) {
		this.noteAnnullamentoValidazioneTR = noteAnnullamentoValidazioneTR;
	}

	public Character getFlagTrainingAgreementPrimaDellaPartenza() {
		if (flagTrainingAgreementPrimaDellaPartenza == null)
			return 'D';
		return flagTrainingAgreementPrimaDellaPartenza;
	}

	public void setFlagTrainingAgreementPrimaDellaPartenza(
			Character flagTrainingAgreementPrimaDellaPartenza) {
		this.flagTrainingAgreementPrimaDellaPartenza = flagTrainingAgreementPrimaDellaPartenza;
	}
	
	public String getIdDocumentoTrainingAgreementPrimaDellaPartenza() {
		return this.idDocumentoTrainingAgreementPrimaDellaPartenza;
	}
	
	public void setIdDocumentoTrainingAgreementPrimaDellaPartenza(
			String idDocumentoTrainingAgreementPrimaDellaPartenza) {
		this.idDocumentoTrainingAgreementPrimaDellaPartenza = idDocumentoTrainingAgreementPrimaDellaPartenza;
	}

	public String getNomeDocumentoTrainingAgreementPrimaDellaPartenza() {
		return nomeDocumentoTrainingAgreementPrimaDellaPartenza;
	}

	public void setNomeDocumentoTrainingAgreementPrimaDellaPartenza(
			String nomeDocumentoTrainingAgreementPrimaDellaPartenza) {
		this.nomeDocumentoTrainingAgreementPrimaDellaPartenza = nomeDocumentoTrainingAgreementPrimaDellaPartenza;
	}

	public Persona getAutoreTrainingAgreementPrimaDellaPartenza() {
		return autoreTrainingAgreementPrimaDellaPartenza;
	}

	public void setAutoreTrainingAgreementPrimaDellaPartenza(
			Persona autoreTrainingAgreementPrimaDellaPartenza) {
		this.autoreTrainingAgreementPrimaDellaPartenza = autoreTrainingAgreementPrimaDellaPartenza;
	}

	public Date getDataTrainingAgreementPrimaDellaPartenza() {
		return dataTrainingAgreementPrimaDellaPartenza;
	}

	public void setDataTrainingAgreementPrimaDellaPartenza(
			Date dataTrainingAgreementPrimaDellaPartenza) {
		this.dataTrainingAgreementPrimaDellaPartenza = dataTrainingAgreementPrimaDellaPartenza;
	}

	public Persona getAutoreValidazioneTrainingAgreementPrimaDellaPartenza() {
		return autoreValidazioneTrainingAgreementPrimaDellaPartenza;
	}

	public void setAutoreValidazioneTrainingAgreementPrimaDellaPartenza(
			Persona autoreValidazioneTrainingAgreementPrimaDellaPartenza) {
		this.autoreValidazioneTrainingAgreementPrimaDellaPartenza = autoreValidazioneTrainingAgreementPrimaDellaPartenza;
	}

	public Date getDataValidazioneTrainingAgreementPrimaDellaPartenza() {
		return dataValidazioneTrainingAgreementPrimaDellaPartenza;
	}

	public void setDataValidazioneTrainingAgreementPrimaDellaPartenza(
			Date dataValidazioneTrainingAgreementPrimaDellaPartenza) {
		this.dataValidazioneTrainingAgreementPrimaDellaPartenza = dataValidazioneTrainingAgreementPrimaDellaPartenza;
	}
	
	public boolean isTAPrimaDellaPartenzaDaValidare() {
		return Common.CH_S.equals(getFlagTrainingAgreementPrimaDellaPartenza());
	}
	
	public boolean isTAPrimaDellaPartenzaValidato() {
		return Common.CH_V.equals(getFlagTrainingAgreementPrimaDellaPartenza());
	}
	
	public boolean isTAPrimaDellaPartenzaValido() {
		return Common.CH_V.equals(getFlagTrainingAgreementPrimaDellaPartenza()) || Common.CH_U.equals(getFlagTrainingAgreementPrimaDellaPartenza());
	}
	
	public boolean isTAPrimaDellaPartenzaRifiutato() {
		return Common.CH_R.equals(getFlagTrainingAgreementPrimaDellaPartenza());
	}

	public String getNoteRifiutoValidazioneTrainingAgreementPrimaDellaPartenza() {
		return noteRifiutoValidazioneTrainingAgreementPrimaDellaPartenza;
	}

	public void setNoteRifiutoValidazioneTrainingAgreementPrimaDellaPartenza(
			String noteRifiutoValidazioneTrainingAgreementPrimaDellaPartenza) {
		this.noteRifiutoValidazioneTrainingAgreementPrimaDellaPartenza = noteRifiutoValidazioneTrainingAgreementPrimaDellaPartenza;
	}
	
	public String getNomeAteneoAzienda() {
		if (getSottoProgramma().isScambioConAzienda() && getDatiPlacement() != null)
			return getDatiPlacement().getDenominazioneAzienda();
		return getAteneoDestinazioneLabel();
	}

	public String getNoteRevoca() {
		return noteRevoca;
	}

	public void setNoteRevoca(String noteRevoca) {
		this.noteRevoca = noteRevoca;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getDurataEffettivaInGiorni() {
		return durataEffettivaInGiorni;
	}

	public void setDurataEffettivaInGiorni(Integer durataEffettivaInGiorni) {
		this.durataEffettivaInGiorni = durataEffettivaInGiorni;
	}
	
	public OutgoingDottorandiVisiting getOutgoingDottorandiVisiting() {
		return outgoingDottorandiVisiting;
	}

	public void setOutgoingDottorandiVisiting(
			OutgoingDottorandiVisiting outgoingDottorandiVisiting) {
		this.outgoingDottorandiVisiting = outgoingDottorandiVisiting;
	}
	
	public boolean isEsisteAnticipoDottorando() {
		if (getBando() != null && !getBando().getSottoProgramma().isVisitingStudents())
			return false;
		if (getMinicarriera() == null)
			return false;
		if (getMinicarriera().getRate() == null || getMinicarriera().getRate().isEmpty())
			return false;
		for (Rata r: getMinicarriera().getRate())
			if ("anticipo".equals(r.getDescrizione()))
				return true;
		return false;
	}
	
	public boolean isEsisteSaldoDottorando() {
		if (getBando() != null && !getBando().getSottoProgramma().isVisitingStudents())
			return false;
		if (getMinicarriera() == null)
			return false;
		if (getMinicarriera().getRate() == null || getMinicarriera().getRate().isEmpty())
			return false;
		for (Rata r: getMinicarriera().getRate())
			if ("saldo".equals(r.getDescrizione()))
				return true;
		return false;
	}

	public Date getDataAppoggio() {
		return dataAppoggio;
	}

	public void setDataAppoggio(Date dataAppoggio) {
		this.dataAppoggio = dataAppoggio;
	}

	public Integer getDurataPrevistaInGiorni() {
		return durataPrevistaInGiorni;
	}

	public void setDurataPrevistaInGiorni(Integer durataPrevistaInGiorni) {
		this.durataPrevistaInGiorni = durataPrevistaInGiorni;
	}

	public boolean isTirocinioPerLaureati() {
		if (!isPlacement() && !isTesiAllEstero())
			return false;
		return Common.CH_S.equals(getFlagTirocinioLaureato());
	}

	public Character getFlagTirocinioLaureato() {
		return flagTirocinioLaureato;
	}

	public void setFlagTirocinioLaureato(Character flagTirocinioLaureato) {
		this.flagTirocinioLaureato = flagTirocinioLaureato;
	}

	public Date getDataRientroPrevistaOrig() {
		return dataRientroPrevistaOrig;
	}

	public void setDataRientroPrevistaOrig(Date dataRientroPrevistaOrig) {
		this.dataRientroPrevistaOrig = dataRientroPrevistaOrig;
	}

	public StudenteOutgoingDestView getStudenteOutgoingDestView() {
		return studenteOutgoingDestView;
	}

	public void setStudenteOutgoingDestView(
			StudenteOutgoingDestView studenteOutgoingDestView) {
		this.studenteOutgoingDestView = studenteOutgoingDestView;
	}

	/*
	 * Etichetta da usare nell'oggetto delle email che vanno agli uffici (direttamente o in copia) 
	 * per agevolare il riconoscimento da parte degli uffici dell'area DIRI competente
	 * del dato. E' stata richiesta principalmente per overseas che nel 2015 si e' organizzata
	 * in 2 aree e ogni area gestisce la mobilita per un elenco di nazioni   
	 */
	public String getEtichettaDestinazioneLabel(){
		SottoProgramma sp = getSottoProgramma();
		// SCAMBIO NON ERASMUS
		if (sp != null && !sp.getProgramma().isErasmus()){ 
			return getStudenteOutgoingDestView() != null ? getStudenteOutgoingDestView().getNazioneAteneoAziendaLabel() : "";
		}
		
		// SCAMBIO PROGRAMMA ERASMUS
		Ateneo ate=getAteneo();
		String lab = (ate != null ? "Cod. Europeo: " + ate.getCodiceErasmus() : "");
		return lab;
	}
	
	public boolean isStudenteDiScuolaDiSpecializzazione() {
		return getCarriera() == null ? false : getCarriera().getTipoCorso().getId().equals("SP");
	}

	public OlsCommand getOlsCommand() {
		return olsCommand;
	}

	public void setOlsCommand(OlsCommand olsCommand) {
		this.olsCommand = olsCommand;
	}
	
	public Long getProgressivoRata(){
		if (getSottoProgramma() != null && getSottoProgramma().isErasmusPlusStudio()) {
			// Per Erasmus studio : sequenziale saltando il 5
			if (minicarriera.getRate().isEmpty())
				return 1L;
			int progr=0;
			for (Rata r : minicarriera.getRate())
				if (r.getNumeroRata().intValue() != 5)
					progr++;
			return  new Long((progr<4) ? progr+1 : progr+2 );  
		}
		return new Long(minicarriera.getRate().size()+1);
	}

	public Long getProgressivoRataRestituzione(){
		if (getSottoProgramma() != null && getSottoProgramma().isErasmusPlusStudio()){
			// Per Erasmus studio : esiste solo la restituzione totale inseribile dagli uffici
			return 5L;
		}
		return new Long(minicarriera.getRate().size()+1);
	}

	public Persona getPersona() {
		return getCandidatura().getPersona();
	}

	public String getAnnoAccademicoSottoprogLabel(){
		String lab = getBando()!=null && getBando().getPeriodoMobilita().getAnnoAccademico() !=null ? "A.A. " + getBando().getPeriodoMobilita().getAnnoAccademicoLabelCorta() + " - " : "";
		lab += getSottoProgramma().getNome();
		return lab;
	}

	public String getSottoprogLabel(){
		SottoProgramma s = this.getSottoProgramma();
		return (s!=null ? s.getNome() : "");
	}

	public boolean isProgrammaErasmusOSwissEU() {
		return candidatura == null ? false : candidatura.isProgrammaErasmusOSwissEU();
	}
	
	public boolean isAttivaCalcolaDurataErasmus() {
		return candidatura.isAttivaCalcolaDurataErasmus();
	}
	
	public Date getDataFineErasmus() {
		return dataFineErasmus;
	}

	public void setDataFineErasmus(Date dataFineErasmus) {
		this.dataFineErasmus = dataFineErasmus;
	}

	public Integer getDurataErasmusInGiorni() {
		return durataErasmusInGiorni;
	}

	public void setDurataErasmusInGiorni(Integer durataErasmusInGiorni) {
		this.durataErasmusInGiorni = durataErasmusInGiorni;
	}
	
	public boolean isDurataErasmusCompilata(){
		return getDataRientro() != null  
				&& durataEffettivaInGiorni != null && durataErasmusInGiorni != null
				&& (   (durataErasmusInGiorni != null && durataErasmusInGiorni.intValue() != durataEffettivaInGiorni.intValue())
					|| (dataFineErasmus !=null && (!DateUtils.isSameDay(dataFineErasmus, dataRientro)))
				);
	}
	
	// dopo la validazione del documento di rientro
	public boolean isDurataErasmusCompilataValidata(){
		return isDurataErasmusCompilata() && dataValidazioneDichiarazioneRientro != null;
	}

	public String getIdDocumentoContrattoFirmato() {
		return idDocumentoContrattoFirmato;
	}

	public void setIdDocumentoContrattoFirmato(String idDocumentoContrattoFirmato) {
		this.idDocumentoContrattoFirmato = idDocumentoContrattoFirmato;
	}

	public MultipartFile getDocumentoContrattoFirmato() {
		return documentoContrattoFirmato;
	}

	public void setDocumentoContrattoFirmato(MultipartFile documentoContrattoFirmato) {
		this.documentoContrattoFirmato = documentoContrattoFirmato;
	}

	public String getNomeDocumentoContrattoFirmato() {
		return nomeDocumentoContrattoFirmato;
	}

	public void setNomeDocumentoContrattoFirmato(String nomeDocumentoContrattoFirmato) {
		this.nomeDocumentoContrattoFirmato = nomeDocumentoContrattoFirmato;
	}

	public String getNomeSottoCartellaDocumentoContrattoFirmato() {
		return nomeSottoCartellaDocumentoContrattoFirmato;
	}

	public void setNomeSottoCartellaDocumentoContrattoFirmato(String nomeSottoCartellaContrattoFirmato) {
		this.nomeSottoCartellaDocumentoContrattoFirmato = nomeSottoCartellaContrattoFirmato;
	}
	
	public String getPathDocumentoContrattoFirmato() {
		return getNomeSottoCartellaDocumentoContrattoFirmato() + "/" + getNomeDocumentoContrattoFirmato();
	}

	public boolean isContrattoFirmatoDaValidare() {
		return Common.CH_A.equals(getFlagContrattoFirmato());
	}

	public boolean isContrattoFirmatoValidato() {
		return Common.CH_S.equals(getFlagContrattoFirmato());
	}
	
	public boolean isContrattoFirmatoRifiutato() {
		return Common.CH_R.equals(getFlagContrattoFirmato());
	}
	
	public boolean isContrattoFirmatoCaricato() {
		return isContrattoFirmatoDaValidare()||isContrattoFirmatoValidato()||isContrattoFirmatoRifiutato();
	}

	public String getNoteValidazioneContrattoFirmato() {
		return noteValidazioneContrattoFirmato;
	}

	public void setNoteValidazioneContrattoFirmato(String noteValidazioneContrattoFirmato) {
		this.noteValidazioneContrattoFirmato = noteValidazioneContrattoFirmato;
	}

	public boolean isRelazioneFinaleConsegnataAttivo() {
		return !Common.CH_I.equals(getFlagRelazioneFinaleConsegnata());
	}

	public boolean isQuestionarioCompilatoAttivo() {
		return !Common.CH_I.equals(getFlagQuestionarioCompilato());		
	}

	/* FlagDocOriginaliConsegnati
	 * S=consegnati, N=non consegnati , I=ignora, funzione/dato non significativa perl'utgoing
	 */
	public Character getFlagDocOriginaliConsegnati() {
		return flagDocOriginaliConsegnati;
	}

	public void setFlagDocOriginaliConsegnati(Character flagDocOriginaliConsegnati) {
		this.flagDocOriginaliConsegnati = flagDocOriginaliConsegnati;
	}
	
	public boolean isDocOriginaliConsegnati(){
		return Common.CH_S.equals(flagDocOriginaliConsegnati);
	}
	public boolean isDocOriginaliConsegnatiAttivo(){
		return flagDocOriginaliConsegnati!=null && (!Common.CH_I.equals(flagDocOriginaliConsegnati));
	}
		
	public Persona getAutoreDocOriginaliConsegnati() {
		return autoreDocOriginaliConsegnati;
	}

	public void setAutoreDocOriginaliConsegnati(Persona autoreDocOriginaliConsegnati) {
		this.autoreDocOriginaliConsegnati = autoreDocOriginaliConsegnati;
	}

	public Date getDataDocOriginaliConsegnati() {
		return dataDocOriginaliConsegnati;
	}

	public void setDataDocOriginaliConsegnati(Date dataDocOriginaliConsegnati) {
		this.dataDocOriginaliConsegnati = dataDocOriginaliConsegnati;
	}

	/* 
	 * Data di rientro prevista dalle regole Erasmus senza tener conto della data limite delle mobilta'
	 * imposta dal bando: 
	 * Data partenza o Data Partenza prevista + Durata dell'offerta o durata impostata su SO
	 */
	public Date getDataRientroPrevistoErasmus () {
		Long durataPrevistaMesi = getDurata();
		Date partenza = (getDataPartenza()!=null ?getDataPartenza() : getDataPartenzaPrevista());
		if (durataPrevistaMesi == null || partenza == null)
			return null;
		return DateUtils.addDays(DateUtils.addMonths(partenza, durataPrevistaMesi.intValue()), -1);
	}
	
	/* 
	 * Data di rientro prevista dalle regole Erasmus, tenendo conto anche della eventuale data limite del bando/bando gruppo
	 * MINIMO FRA: (data partenza o Data Partenza prevista + Durata dell'offerta o durata impostata su SO)
	 *             e data limite se prevista dal bando/bandogruppo
	 */
	public Date getDataRientroPrevistoAmmessaBandoErasmus () {
		Long durataPrevistaMesi = getDurata();
		Date partenza = (getDataPartenza() != null ? getDataPartenza() : getDataPartenzaPrevista());
		Date dataRientroPrevisto = DateUtils.addDays(DateUtils.addMonths(partenza, durataPrevistaMesi.intValue()), -1);
		Date limite = getDataLimiteFineMobilita();
		return (limite != null && limite.before(dataRientroPrevisto)) ? limite : dataRientroPrevisto;			
	}


	public Persona getReferenteInternoSpecifico() {
		return getCandidatura().getReferenteInternoSpecifico();
	}

	public Nazione getNazDocumento() {
		return nazDocumento;
	}

	public void setNazDocumento(Nazione nazDocumento) {
		this.nazDocumento = nazDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNrDocumento() {
		return nrDocumento;
	}

	public void setNrDocumento(String nrDocumento) {
		this.nrDocumento = nrDocumento;
	}

	public Date getScadenzaDocumento() {
		return scadenzaDocumento;
	}

	public void setScadenzaDocumento(Date scadenzaDocumento) {
		this.scadenzaDocumento = scadenzaDocumento;
	}

	public Long getIdBandoGruppo() {
		return candidatura.getBandoGruppoCandidatura() != null ? candidatura.getBandoGruppoCandidatura().getId() : null; 
	}

	public SoSchedaAF getSoSchedaAF() {
		return soSchedaAF;
	}

	public void setSoSchedaAF(SoSchedaAF soSchedaAF) {
		this.soSchedaAF = soSchedaAF;
	}

	public boolean isSchedaAFCaricata() {
		return getSoSchedaAF() != null 
				&& (soSchedaAF.isDaValidare()||soSchedaAF.isValidata()||soSchedaAF.isRifiutata());
	}

	// transient
	public MultipartFile getDocumentoSchedaAF() {
		return documentoSchedaAF;
	}

	public void setDocumentoSchedaAF(MultipartFile documentoSchedaAF) {
		this.documentoSchedaAF = documentoSchedaAF;
	}
	//---
}

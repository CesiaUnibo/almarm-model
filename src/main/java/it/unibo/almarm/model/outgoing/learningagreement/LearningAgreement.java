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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.web.multipart.MultipartFile;

import edu.emory.mathcs.backport.java.util.Collections;
import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.attori.studenti.Corso;
import it.unibo.almarm.model.lingue.Lingua;
import it.unibo.almarm.model.outgoing.StudenteOutgoing;
import it.unibo.almarm.util.Common;

public class LearningAgreement implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String LABEL_PREPARAZIONE_TESI = "Preparation of the final thesis";

	private Long id;
	private Date dataFine;
	private String stato;
	private Corso corso;
	private Integer versione;
	private Integer iterazione;
	private String codInd;
	private String codOri;
	private Persona autoreCreazione; 
	private Date dataCreazione; 
	private Persona autorePresentazione;
	private Date dataPresentazione;
	private Persona autoreValidazione;
	private Date dataValidazione;
	private Persona autoreRifiutoValidazione;
	private Date dataRifiutoValidazione;
	private Persona autoreApprovazione;
	private Date dataApprovazione;
	private String noteValidazione;
	private String noteApprovazione;
	private String noteStudente;
	private Character flagStudio;
	private Character flagTesi;
	private Character flagTirocinio;
	private String noteRifiutoValidazione;
	private String noteValidazionePerCCds;
	private String titoloTesi;
	private String idAllegato;
	private String nomeAllegato;	
	private String noteRifiutoApprovazione;
	private Date dataRifiutoApprovazione;
	private Persona autoreRifiutoApprovazione;
	private String idDocumentoApprovazione;
	private String nomeDocumentoApprovazione;
	private String idDocumentoFirmato;
	private String nomeDocumentoFirmato;
	private Date dataValidazioneDocumentoFirmato;
	private Persona autoreValidazioneDocumentoFirmato;
	private String noteRifiutoValidDocFirmato;
	private Character flagDocumentoFirmatoValidato;
	private Character flagModificaPianoStudi;
	private Character flagSuRichiestaRiconoscimento;
	private Character flagStudioInRR;
	private Character flagTesiInRR;
	private Character flagTirocinioInRR;
	private String datiTirocinio;
	private String idDocumentoLaProgetto;
	private String nomeDocumentoLaProgetto;
	private Character flagDocumentoLaProgettoValidato;
	private Date dataValidazioneDocumentoLaProgetto;
	private Persona autoreValidazioneDocumentoLaProgetto;
	private String noteRifiutoValidDocumentoLaProgetto;
	private String noteValidazioneDocFirmato;
	private String courseCatalog;
	private Lingua linguaPerCompetenzeLinguistiche;
	private String livelloDiCompetenzaLinguistica;
	private Persona responsabileApprovazione;
	private Character flagTesiVersionePrecedente;
	private String titoloTesiVersionePrecedente;
	private Character flagForTraineeship;
	private Integer numeroOreTirocinio;
	private Character flagCreditiAScelta;
	private Integer numeroOreTirocinioInRR;
	private Character flagCreditiASceltaInRR;
	private Integer numeroOreSettimanaliTirocinio;
	
	private SortedSet<BloccoAttivita> blocchiAttivita = new TreeSet<BloccoAttivita>(new BloccoAttivitaComparator());
	
	private StudenteOutgoing studenteOutgoing;
	
	// campi non persistiti
	private Integer posizioneBloccoDaCancellare;
	private Integer posizioneBloccoDaRipristinare;
	private transient MultipartFile allegato;
	private transient MultipartFile documentoApprovazione;
	private transient MultipartFile documentoFirmato;
	private Integer bloccoCorrente;
	private String checkCambioPds1;
	private String checkCambioPds2;
	private HashMap<String, String> elencoIntegrati;
	private transient MultipartFile documentoLaProgetto;
	private List<String> elencoMotivazioniModificheAttEs;
	private List<String> elencoMotivazioniModificheAttUn;
	private List<String> elencoMotivazioniModificheAttEsAltre;
	private List<String> elencoMotivazioniModificheAttUnAltre;
	private String codiciMaterieAttFuoriPianiTirocinio;
	private String codiciMaterieAttFuoriPianiSceltaLibera;
	private List<String> materieStudenteTirocinio;
	private List<String> materieNoCarrieraTirocinio;
	private List<String> materieStudenteSceltaLibera;
	private List<String> materieNoCarrieraSceltaLibera;
	private List<AttivitaUnibo> cfuASceltaList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public Integer getVersione() {
		return versione;
	}

	public void setVersione(Integer versione) {
		this.versione = versione;
	}

	public Integer getIterazione() {
		return iterazione;
	}

	public void setIterazione(Integer iterazione) {
		this.iterazione = iterazione;
	}

	public boolean isTirocinio() {
		return Common.CH_S.equals(flagTirocinio);
	}
	
	public boolean isTesi() {
		return Common.CH_S.equals(flagTesi);
	}
	
	public boolean isStudio() {
		return Common.CH_S.equals(flagStudio);
	}
	
	public boolean isTirocinioInRR() {
		return Common.CH_S.equals(flagTirocinioInRR);
	}
	
	public boolean isTesiInRR() {
		return Common.CH_S.equals(flagTesiInRR);
	}
	
	public boolean isNoTesiInRR() {
		return Common.CH_N.equals(flagTesiInRR);
	}
	
	public boolean isStudioInRR() {
		return Common.CH_S.equals(flagStudioInRR);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((iterazione == null) ? 0 : iterazione.hashCode());
		result = prime * result
				+ ((versione == null) ? 0 : versione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LearningAgreement))
			return false;
		LearningAgreement other = (LearningAgreement) obj;
		if (iterazione == null) {
			if (other.iterazione != null)
				return false;
		} else if (!iterazione.equals(other.iterazione))
			return false;
		if (versione == null) {
			if (other.versione != null)
				return false;
		} else if (!versione.equals(other.versione))
			return false;
		return true;
	}

	public SortedSet<BloccoAttivita> getBlocchiAttivita() {
		return blocchiAttivita;
	}

	public void setBlocchiAttivita(SortedSet<BloccoAttivita> blocchiAttivita) {
		this.blocchiAttivita = blocchiAttivita;
	}
	
	public void addBloccoAttivita(BloccoAttivita bloccoAttivita) {
		if (blocchiAttivita == null)
			blocchiAttivita = new TreeSet<BloccoAttivita>(new BloccoAttivitaComparator());
		blocchiAttivita.add(bloccoAttivita);
	}
	
	public List<BloccoAttivita> getBlocchiAttivitaList() {
		List<BloccoAttivita> l = new ArrayList<BloccoAttivita>(blocchiAttivita);
		Collections.sort(l, new BloccoAttivitaComparator());
		return l;
	}

	public Integer getPosizioneBloccoDaCancellare() {
		return posizioneBloccoDaCancellare;
	}

	public void setPosizioneBloccoDaCancellare(Integer posizioneBloccoDaCancellare) {
		this.posizioneBloccoDaCancellare = posizioneBloccoDaCancellare;
	}
	
	public String getVersioneLabel() {
		return versione + "." + iterazione + (versione.equals(2) ? " - 1" + ((char)176) + " modifica del LA" : versione.equals(3) ? " - 2" + ((char)176) + " modifica del LA" : "");
	}
	
	public String getColor() {
		return StatoLearningAgreement.get(stato).getColor();
	}
	
	public String getColorDesc() {
		return StatoLearningAgreement.get(stato).getMessageKey();
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

	public Persona getAutoreCreazione() {
		return autoreCreazione;
	}

	public void setAutoreCreazione(Persona autoreCreazione) {
		this.autoreCreazione = autoreCreazione;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Persona getAutorePresentazione() {
		return autorePresentazione;
	}

	public void setAutorePresentazione(Persona autorePresentazione) {
		this.autorePresentazione = autorePresentazione;
	}

	public Date getDataPresentazione() {
		return dataPresentazione;
	}

	public void setDataPresentazione(Date dataPresentazione) {
		this.dataPresentazione = dataPresentazione;
	}

	public Persona getAutoreValidazione() {
		return autoreValidazione;
	}

	public void setAutoreValidazione(Persona autoreValidazione) {
		this.autoreValidazione = autoreValidazione;
	}

	public Date getDataValidazione() {
		return dataValidazione;
	}

	public void setDataValidazione(Date dataValidazione) {
		this.dataValidazione = dataValidazione;
	}

	public Persona getAutoreApprovazione() {
		return autoreApprovazione;
	}

	public void setAutoreApprovazione(Persona autoreApprovazione) {
		this.autoreApprovazione = autoreApprovazione;
	}

	public Date getDataApprovazione() {
		return dataApprovazione;
	}

	public void setDataApprovazione(Date dataApprovazione) {
		this.dataApprovazione = dataApprovazione;
	}

	public String getNoteValidazione() {
		return noteValidazione;
	}

	public void setNoteValidazione(String noteValidazione) {
		this.noteValidazione = noteValidazione;
	}

	public String getNoteApprovazione() {
		return noteApprovazione;
	}

	public void setNoteApprovazione(String noteApprovazione) {
		this.noteApprovazione = noteApprovazione;
	}

	public String getNoteStudente() {
		return noteStudente;
	}

	public void setNoteStudente(String noteStudente) {
		this.noteStudente = noteStudente;
	}

	public StudenteOutgoing getStudenteOutgoing() {
		return studenteOutgoing;
	}

	public void setStudenteOutgoing(StudenteOutgoing studenteOutgoing) {
		this.studenteOutgoing = studenteOutgoing;
	}

	public Character getFlagStudio() {
		if (flagStudio == null)
			return 'N';
		return flagStudio;
	}

	public void setFlagStudio(Character flagStudio) {
		this.flagStudio = flagStudio;
	}

	public Character getFlagTesi() {
		if (flagTesi == null)
			return 'N';
		return flagTesi;
	}

	public void setFlagTesi(Character flagTesi) {
		this.flagTesi = flagTesi;
	}

	public Character getFlagTirocinio() {
		if (flagTirocinio == null)
			return 'N';
		return flagTirocinio;
	}

	public void setFlagTirocinio(Character flagTirocinio) {
		this.flagTirocinio = flagTirocinio;
	}
	
	public SottoProgramma getSottoProgramma() {
		return getStudenteOutgoing().getSottoProgramma();
	}
	
	public String getLabelEcts() {
		return getSottoProgramma().getLabelEcts();
	}
	
	public boolean isUsaReferenteScambioPerLA() {
		return getSottoProgramma().isUsaReferenteScambioPerLA();
	}
	
	public boolean isUsaReferenteVicepresidenzaPerLA() {
		return getSottoProgramma().isUsaReferenteVicepresidenzaPerLA();
	}

	public String getNoteRifiutoValidazione() {
		return noteRifiutoValidazione;
	}

	public void setNoteRifiutoValidazione(String noteRifiutoValidazione) {
		this.noteRifiutoValidazione = noteRifiutoValidazione;
	}

	public Persona getAutoreRifiutoValidazione() {
		return autoreRifiutoValidazione;
	}

	public void setAutoreRifiutoValidazione(Persona autoreRifiutoValidazione) {
		this.autoreRifiutoValidazione = autoreRifiutoValidazione;
	}

	public Date getDataRifiutoValidazione() {
		return dataRifiutoValidazione;
	}

	public void setDataRifiutoValidazione(Date dataRifiutoValidazione) {
		this.dataRifiutoValidazione = dataRifiutoValidazione;
	}
	
	public boolean isApprovato() {
		return StatoLearningAgreement.APPROVATO.getValore().equals(stato);
	}
	
	public boolean isDaPresentare() {
		return StatoLearningAgreement.DA_PRESENTARE.getValore().equals(stato);
	}
	
	public boolean isPresentato() {
		return StatoLearningAgreement.PRESENTATO.getValore().equals(stato);
	}
	
	public boolean isValidato() {
		return StatoLearningAgreement.VALIDATO.getValore().equals(stato);
	}

	public boolean isSuRichiestaDiRiconoscimento() {
		return StatoLearningAgreement.SU_RICHIESTA_RICONOSCIMENTO.getValore().equals(stato);
	}
	
	public String getNoteValidazionePerCCds() {
		return noteValidazionePerCCds;
	}

	public void setNoteValidazionePerCCds(String noteValidazionePerCCds) {
		this.noteValidazionePerCCds = noteValidazionePerCCds;
	}

	public String getTitoloTesi() {
		return titoloTesi;
	}

	public void setTitoloTesi(String titoloTesi) {
		this.titoloTesi = titoloTesi;
	}

	public String getIdAllegato() {
		return idAllegato;
	}

	public void setIdAllegato(String idAllegato) {
		this.idAllegato = idAllegato;
	}

	public String getNomeAllegato() {
		return nomeAllegato;
	}

	public void setNomeAllegato(String nomeAllegato) {
		this.nomeAllegato = nomeAllegato;
	}

	public MultipartFile getAllegato() {
		return allegato;
	}

	public void setAllegato(MultipartFile allegato) {
		this.allegato = allegato;
	}

	public String getNoteRifiutoApprovazione() {
		return noteRifiutoApprovazione;
	}

	public void setNoteRifiutoApprovazione(String noteRifiutoApprovazione) {
		this.noteRifiutoApprovazione = noteRifiutoApprovazione;
	}

	public Date getDataRifiutoApprovazione() {
		return dataRifiutoApprovazione;
	}

	public void setDataRifiutoApprovazione(Date dataRifiutoApprovazione) {
		this.dataRifiutoApprovazione = dataRifiutoApprovazione;
	}

	public Persona getAutoreRifiutoApprovazione() {
		return autoreRifiutoApprovazione;
	}

	public void setAutoreRifiutoApprovazione(Persona autoreRifiutoApprovazione) {
		this.autoreRifiutoApprovazione = autoreRifiutoApprovazione;
	}
	
	public boolean isRifiutato() {
		return StatoLearningAgreement.RIFIUTATO.getValore().equals(getStato());
	}

	public String getIdDocumentoApprovazione() {
		return idDocumentoApprovazione;
	}

	public void setIdDocumentoApprovazione(String idDocumentoApprovazione) {
		this.idDocumentoApprovazione = idDocumentoApprovazione;
	}

	public String getNomeDocumentoApprovazione() {
		return nomeDocumentoApprovazione;
	}

	public void setNomeDocumentoApprovazione(String nomeDocumentoApprovazione) {
		this.nomeDocumentoApprovazione = nomeDocumentoApprovazione;
	}

	public MultipartFile getDocumentoApprovazione() {
		return documentoApprovazione;
	}

	public void setDocumentoApprovazione(MultipartFile documentoApprovazione) {
		this.documentoApprovazione = documentoApprovazione;
	}

	public Integer getBloccoCorrente() {
		return bloccoCorrente;
	}

	public void setBloccoCorrente(Integer bloccoCorrente) {
		this.bloccoCorrente = bloccoCorrente;
	}

	public String getIdDocumentoFirmato() {
		return idDocumentoFirmato;
	}

	public void setIdDocumentoFirmato(String idDocumentoFirmato) {
		this.idDocumentoFirmato = idDocumentoFirmato;
	}

	public String getNomeDocumentoFirmato() {
		return nomeDocumentoFirmato;
	}

	public void setNomeDocumentoFirmato(String nomeDocumentoFirmato) {
		this.nomeDocumentoFirmato = nomeDocumentoFirmato;
	}

	public MultipartFile getDocumentoFirmato() {
		return documentoFirmato;
	}

	public void setDocumentoFirmato(MultipartFile documentoFirmato) {
		this.documentoFirmato = documentoFirmato;
	}

	public String getNoteRifiutoValidDocFirmato() {
		return noteRifiutoValidDocFirmato;
	}

	public void setNoteRifiutoValidDocFirmato(String noteRifiutoValidDocFirmato) {
		this.noteRifiutoValidDocFirmato = noteRifiutoValidDocFirmato;
	}

	public Date getDataValidazioneDocumentoFirmato() {
		return dataValidazioneDocumentoFirmato;
	}

	public void setDataValidazioneDocumentoFirmato(
			Date dataValidazioneDocumentoFirmato) {
		this.dataValidazioneDocumentoFirmato = dataValidazioneDocumentoFirmato;
	}

	public Persona getAutoreValidazioneDocumentoFirmato() {
		return autoreValidazioneDocumentoFirmato;
	}

	public void setAutoreValidazioneDocumentoFirmato(
			Persona autoreValidazioneDocumentoFirmato) {
		this.autoreValidazioneDocumentoFirmato = autoreValidazioneDocumentoFirmato;
	}

	public Character getFlagDocumentoFirmatoValidato() {
		return flagDocumentoFirmatoValidato;
	}

	public void setFlagDocumentoFirmatoValidato(
			Character flagDocumentoFirmatoValidato) {
		this.flagDocumentoFirmatoValidato = flagDocumentoFirmatoValidato;
	}
	
	public boolean isDocumentoFirmatoValidato() {
		return Common.CH_S.equals(getFlagDocumentoFirmatoValidato());
	}
	
	public boolean isDocumentoFirmatoNonValidato() {
		return Common.CH_N.equals(getFlagDocumentoFirmatoValidato());
	}

	public Character getFlagModificaPianoStudi() {
		return flagModificaPianoStudi;
	}

	public void setFlagModificaPianoStudi(Character flagModificaPianoStudi) {
		this.flagModificaPianoStudi = flagModificaPianoStudi;
	}
	
	public boolean isModificaPianoStudi() {
		return Common.CH_S.equals(getFlagModificaPianoStudi());
	}

	public String getCheckCambioPds1() {
		if (checkCambioPds1 == null)
			return "S";
		return checkCambioPds1;
	}

	public void setCheckCambioPds1(String checkCambioPds1) {
		this.checkCambioPds1 = checkCambioPds1;
	}

	public String getCheckCambioPds2() {
		if (checkCambioPds2 == null)
			return "S";
		return checkCambioPds2;
	}

	public void setCheckCambioPds2(String checkCambioPds2) {
		this.checkCambioPds2 = checkCambioPds2;
	}

	public Character getFlagSuRichiestaRiconoscimento() {
		if (flagSuRichiestaRiconoscimento == null)
			return 'N';
		return flagSuRichiestaRiconoscimento;
	}

	public void setFlagSuRichiestaRiconoscimento(
			Character flagSuRichiestaRiconoscimento) {
		this.flagSuRichiestaRiconoscimento = flagSuRichiestaRiconoscimento;
	}

	public Character getFlagStudioInRR() {
		return flagStudioInRR;
	}

	public void setFlagStudioInRR(Character flagStudioInRR) {
		this.flagStudioInRR = flagStudioInRR;
	}

	public Character getFlagTesiInRR() {
		return flagTesiInRR;
	}

	public void setFlagTesiInRR(Character flagTesiInRR) {
		this.flagTesiInRR = flagTesiInRR;
	}

	public Character getFlagTirocinioInRR() {
		return flagTirocinioInRR;
	}

	public void setFlagTirocinioInRR(Character flagTirocinioInRR) {
		this.flagTirocinioInRR = flagTirocinioInRR;
	}

	public String getDatiTirocinio() {
		return datiTirocinio;
	}

	public void setDatiTirocinio(String datiTirocinio) {
		this.datiTirocinio = datiTirocinio;
	}
	
	public HashMap<String,String> getElencoIntegrati() {
		if (elencoIntegrati == null)
		{
			elencoIntegrati = new HashMap<String, String>();
			for (BloccoAttivita ba: getBlocchiAttivita())
				for (AttivitaUnibo au: ba.getAttivitaUnibo())
					if (au.getAppartieneAIntegrato() && elencoIntegrati.get(au.getIdCorsoIntegratoPadre()) == null)
						elencoIntegrati.put(au.getIdCorsoIntegratoPadre(), au.getVotoIntegratoPadreLabel());
		}
		return elencoIntegrati;
	}
	
	public Set<String> getElencoIdIntegrati() {
		return getElencoIntegrati().keySet();
	}
	
	public void resetElencoIntegrati() {
		elencoIntegrati = null;
	}

	public String getIdDocumentoLaProgetto() {
		return idDocumentoLaProgetto;
	}

	public void setIdDocumentoLaProgetto(String idDocumentoLaProgetto) {
		this.idDocumentoLaProgetto = idDocumentoLaProgetto;
	}

	public String getNomeDocumentoLaProgetto() {
		return nomeDocumentoLaProgetto;
	}

	public void setNomeDocumentoLaProgetto(String nomeDocumentoLaProgetto) {
		this.nomeDocumentoLaProgetto = nomeDocumentoLaProgetto;
	}

	public Character getFlagDocumentoLaProgettoValidato() {
		return flagDocumentoLaProgettoValidato;
	}

	public void setFlagDocumentoLaProgettoValidato(
			Character flagDocumentoLaProgettoValidato) {
		this.flagDocumentoLaProgettoValidato = flagDocumentoLaProgettoValidato;
	}
	
	public boolean isDocumentoLaProgettoValidato() {
		return Common.CH_S.equals(getFlagDocumentoLaProgettoValidato());
	}
	
	public boolean isDocumentoLaProgettoRifiutato() {
		return Common.CH_N.equals(getFlagDocumentoLaProgettoValidato());
	}
	
	public boolean isDocumentoLaProgettoDaValidare() {
		return getFlagDocumentoLaProgettoValidato() == null && getIdDocumentoLaProgetto() != null;
	}

	public MultipartFile getDocumentoLaProgetto() {
		return documentoLaProgetto;
	}

	public void setDocumentoLaProgetto(MultipartFile documentoLaProgetto) {
		this.documentoLaProgetto = documentoLaProgetto;
	}

	public Date getDataValidazioneDocumentoLaProgetto() {
		return dataValidazioneDocumentoLaProgetto;
	}

	public void setDataValidazioneDocumentoLaProgetto(
			Date dataValidazioneDocumentoLaProgetto) {
		this.dataValidazioneDocumentoLaProgetto = dataValidazioneDocumentoLaProgetto;
	}

	public Persona getAutoreValidazioneDocumentoLaProgetto() {
		return autoreValidazioneDocumentoLaProgetto;
	}

	public void setAutoreValidazioneDocumentoLaProgetto(
			Persona autoreValidazioneDocumentoLaProgetto) {
		this.autoreValidazioneDocumentoLaProgetto = autoreValidazioneDocumentoLaProgetto;
	}

	public String getNoteRifiutoValidDocumentoLaProgetto() {
		return noteRifiutoValidDocumentoLaProgetto;
	}

	public void setNoteRifiutoValidDocumentoLaProgetto(
			String noteRifiutoValidDocumentoLaProgetto) {
		this.noteRifiutoValidDocumentoLaProgetto = noteRifiutoValidDocumentoLaProgetto;
	}

	public String getNoteValidazioneDocFirmato() {
		return noteValidazioneDocFirmato;
	}

	public void setNoteValidazioneDocFirmato(String noteValidazioneDocFirmato) {
		this.noteValidazioneDocFirmato = noteValidazioneDocFirmato;
	}

	// Ritorna una copia identica del LA a meno degli ID. Utilizzato per storicizzazione
	public LearningAgreement clona() {
		LearningAgreement clone = new LearningAgreement();
		clone.setDataFine(this.getDataFine());
		clone.setStato(this.getStato());
		clone.setCorso(this.getCorso());
		clone.setVersione(this.getVersione());
		clone.setIterazione(this.getIterazione());
		clone.setCodInd(this.getCodInd());
		clone.setCodOri(this.getCodOri());
		clone.setAutoreCreazione(this.getAutoreCreazione()); 
		clone.setDataCreazione(this.getDataCreazione()); 
		clone.setAutorePresentazione(this.getAutorePresentazione());
		clone.setDataPresentazione(this.getDataPresentazione());
		clone.setAutoreValidazione(this.getAutoreValidazione());
		clone.setDataValidazione(this.getDataValidazione());
		clone.setAutoreRifiutoValidazione(this.getAutoreRifiutoValidazione());
		clone.setDataRifiutoValidazione(this.getDataRifiutoValidazione());
		clone.setAutoreApprovazione(this.getAutoreApprovazione());
		clone.setDataApprovazione(this.getDataApprovazione());
		clone.setNoteValidazione(this.getNoteValidazione());
		clone.setNoteApprovazione(this.getNoteApprovazione());
		clone.setNoteStudente(this.getNoteStudente());
		clone.setFlagStudio(this.getFlagStudio());
		clone.setFlagTesi(this.getFlagTesi());
		clone.setFlagTirocinio(this.getFlagTirocinio());
		clone.setNoteRifiutoValidazione(this.getNoteRifiutoValidazione());
		clone.setNoteValidazionePerCCds(this.getNoteValidazionePerCCds());
		clone.setTitoloTesi(this.getTitoloTesi());
		clone.setIdAllegato(this.getIdAllegato());
		clone.setNomeAllegato(this.getNomeAllegato());	
		clone.setNoteRifiutoApprovazione(this.getNoteRifiutoApprovazione());
		clone.setDataRifiutoApprovazione(this.getDataRifiutoApprovazione());
		clone.setAutoreRifiutoApprovazione(this.getAutoreRifiutoApprovazione());
		clone.setIdDocumentoApprovazione(this.getIdDocumentoApprovazione());
		clone.setNomeDocumentoApprovazione(this.getNomeDocumentoApprovazione());
		clone.setIdDocumentoFirmato(this.getIdDocumentoFirmato());
		clone.setNomeDocumentoFirmato(this.getNomeDocumentoFirmato());
		clone.setDataValidazioneDocumentoFirmato(this.getDataValidazioneDocumentoFirmato());
		clone.setAutoreValidazioneDocumentoFirmato(this.getAutoreValidazioneDocumentoFirmato());
		clone.setNoteRifiutoValidDocFirmato(this.getNoteRifiutoValidDocFirmato());
		clone.setFlagDocumentoFirmatoValidato(this.getFlagDocumentoFirmatoValidato());
		clone.setFlagModificaPianoStudi(this.getFlagModificaPianoStudi());
		clone.setFlagSuRichiestaRiconoscimento(this.getFlagSuRichiestaRiconoscimento());
		clone.setFlagStudioInRR(this.getFlagStudioInRR());
		clone.setFlagTesiInRR(this.getFlagTesiInRR());
		clone.setFlagTirocinioInRR(this.getFlagTirocinioInRR());
		clone.setDatiTirocinio(this.getDatiTirocinio());
		clone.setIdDocumentoLaProgetto(this.getIdDocumentoLaProgetto());
		clone.setNomeDocumentoLaProgetto(this.getNomeDocumentoLaProgetto());
		clone.setFlagDocumentoLaProgettoValidato(this.getFlagDocumentoLaProgettoValidato());
		clone.setDataValidazioneDocumentoLaProgetto(this.getDataValidazioneDocumentoLaProgetto());
		clone.setAutoreValidazioneDocumentoLaProgetto(this.getAutoreValidazioneDocumentoLaProgetto());
		clone.setNoteRifiutoValidDocumentoLaProgetto(this.getNoteRifiutoValidDocumentoLaProgetto());
		clone.setStudenteOutgoing(this.getStudenteOutgoing());
		clone.setNoteValidazioneDocFirmato(this.getNoteValidazioneDocFirmato());
		clone.setCourseCatalog(this.getCourseCatalog());
		clone.setLinguaPerCompetenzeLinguistiche(this.getLinguaPerCompetenzeLinguistiche());
		clone.setLivelloDiCompetenzaLinguistica(this.getLivelloDiCompetenzaLinguistica());
		clone.setFlagForTraineeship(this.getFlagForTraineeship());
		clone.setNumeroOreTirocinio(this.getNumeroOreTirocinio());
		clone.setFlagCreditiAScelta(this.getFlagCreditiAScelta());
		clone.setNumeroOreTirocinioInRR(this.getNumeroOreTirocinioInRR());
		clone.setFlagCreditiASceltaInRR(this.getFlagCreditiASceltaInRR());
		clone.setNumeroOreSettimanaliTirocinio(this.getNumeroOreSettimanaliTirocinio());
		 
		clone.setBlocchiAttivita(new TreeSet<BloccoAttivita>(new BloccoAttivitaComparator()));
		for (BloccoAttivita ba: this.getBlocchiAttivita())
			clone.getBlocchiAttivita().add(ba.clona());
		
		return clone;
	}
	
	public List<AttivitaEstera> getElencoAttivitaEstere() {
		List<AttivitaEstera> ret = new ArrayList<AttivitaEstera>();
		if (getBlocchiAttivita() != null)
			for (BloccoAttivita ba: getBlocchiAttivita())
				if (ba.getAttivitaEstere() != null)
					for (AttivitaEstera ae: ba.getAttivitaEstere())
						ret.add(ae);
		return ret ;
	}
	
	public List<AttivitaUnibo> getElencoAttivitaUnibo() {
		List<AttivitaUnibo> ret = new ArrayList<AttivitaUnibo>();
		if (getBlocchiAttivita() != null)
			for (BloccoAttivita ba: getBlocchiAttivita())
				if (ba.getAttivitaUnibo() != null)
					for (AttivitaUnibo au: ba.getAttivitaUnibo())
						ret.add(au);
		return ret ;
	}

	public String getCourseCatalog() {
		return courseCatalog;
	}

	public void setCourseCatalog(String courseCatalog) {
		this.courseCatalog = courseCatalog;
	}

	public Lingua getLinguaPerCompetenzeLinguistiche() {
		return linguaPerCompetenzeLinguistiche;
	}

	public void setLinguaPerCompetenzeLinguistiche(
			Lingua linguaPerCompetenzeLinguistiche) {
		this.linguaPerCompetenzeLinguistiche = linguaPerCompetenzeLinguistiche;
	}

	public String getLivelloDiCompetenzaLinguistica() {
		return livelloDiCompetenzaLinguistica;
	}

	public void setLivelloDiCompetenzaLinguistica(
			String livelloDiCompetenzaLinguistica) {
		this.livelloDiCompetenzaLinguistica = livelloDiCompetenzaLinguistica;
	}

	public Integer getPosizioneBloccoDaRipristinare() {
		return posizioneBloccoDaRipristinare;
	}

	public void setPosizioneBloccoDaRipristinare(
			Integer posizioneBloccoDaRipristinare) {
		this.posizioneBloccoDaRipristinare = posizioneBloccoDaRipristinare;
	}
	
	public boolean isModificheDaVersionePrecedenteDaMostrare() {
		return (getVersione() > 1) && getStudenteOutgoing().getBando().isTracciamentoModificheInLaAttivo();
	}
	
	public List<Entry<String, Boolean>> getElencoAttivitaEstereModificate() {
		if (getVersione() == null || getVersione().equals(new Integer(1)))
			return null;
		
		List<Entry<String, Boolean>> ret = new ArrayList<Entry<String, Boolean>>();
		
		List<AttivitaEstera> l = getElencoAttivitaEstereModificateObj();
		for (AttivitaEstera ae: l)
			ret.add(new java.util.AbstractMap.SimpleEntry<String, Boolean>(ae.getLabel() + " " + ae.getSemestreLabel(), ae.isCancellata()));
		
		return ret;
	}
	
	public List<Entry<String, Boolean>> getElencoAttivitaUniboModificate() {
		if (getVersione() == null || getVersione().equals(new Integer(1)))
			return null;
		
		List<Entry<String, Boolean>> ret = new ArrayList<Entry<String, Boolean>>();
		
		List<AttivitaUnibo> l = getElencoAttivitaUniboModificateObj();
		for (AttivitaUnibo au: l)
			ret.add(new java.util.AbstractMap.SimpleEntry<String, Boolean>(au.getLabel(), au.isCancellata()));
		
		return ret;
	}

	public List<String> getElencoMotivazioniModificheAttEs() {
		return elencoMotivazioniModificheAttEs;
	}

	public void setElencoMotivazioniModificheAttEs(
			List<String> elencoMotivazioniModificheAttEs) {
		this.elencoMotivazioniModificheAttEs = elencoMotivazioniModificheAttEs;
	}

	public List<String> getElencoMotivazioniModificheAttUn() {
		return elencoMotivazioniModificheAttUn;
	}

	public void setElencoMotivazioniModificheAttUn(
			List<String> elencoMotivazioniModificheAttUn) {
		this.elencoMotivazioniModificheAttUn = elencoMotivazioniModificheAttUn;
	}
	
	public void inizializzaElenchiMotivazioniModifiche() {
		List<Entry<String, Boolean>> l = getElencoAttivitaEstereModificate();
		if (l != null && !l.isEmpty())
		{
			this.elencoMotivazioniModificheAttEs = new ArrayList<String>(l.size());
			this.elencoMotivazioniModificheAttEsAltre = new ArrayList<String>(l.size());
			for (int i = 0; i < l.size(); i++)
			{
				this.elencoMotivazioniModificheAttEs.add("");
				this.elencoMotivazioniModificheAttEsAltre.add("");
			}
		}
		else
		{
			this.elencoMotivazioniModificheAttEs = new ArrayList<String>(0);
			this.elencoMotivazioniModificheAttEsAltre = new ArrayList<String>(0);
		}
		
		l = getElencoAttivitaUniboModificate();
		if (l != null && !l.isEmpty())
		{
			this.elencoMotivazioniModificheAttUn = new ArrayList<String>(l.size());
			this.elencoMotivazioniModificheAttUnAltre = new ArrayList<String>(l.size());
			for (int i = 0; i < l.size(); i++)
			{
				this.elencoMotivazioniModificheAttUn.add("");
				this.elencoMotivazioniModificheAttUnAltre.add("");
			}
		}
		else
		{
			this.elencoMotivazioniModificheAttUn = new ArrayList<String>(0);
			this.elencoMotivazioniModificheAttUnAltre = new ArrayList<String>(0);
		}
	}

	public List<String> getElencoMotivazioniModificheAttEsAltre() {
		return elencoMotivazioniModificheAttEsAltre;
	}

	public void setElencoMotivazioniModificheAttEsAltre(
			List<String> elencoMotivazioniModificheAttEsAltre) {
		this.elencoMotivazioniModificheAttEsAltre = elencoMotivazioniModificheAttEsAltre;
	}

	public List<String> getElencoMotivazioniModificheAttUnAltre() {
		return elencoMotivazioniModificheAttUnAltre;
	}

	public void setElencoMotivazioniModificheAttUnAltre(
			List<String> elencoMotivazioniModificheAttUnAltre) {
		this.elencoMotivazioniModificheAttUnAltre = elencoMotivazioniModificheAttUnAltre;
	}

	public List<AttivitaEstera> getElencoAttivitaEstereModificateObj() {
		if (getVersione() == null || getVersione().equals(new Integer(1)))
			return null;
		
		List<AttivitaEstera> ret = new ArrayList<AttivitaEstera>();
		
		List<AttivitaEstera> attivitaModificate = new ArrayList<AttivitaEstera>();
		for (BloccoAttivita ba: getBlocchiAttivita())
			for (AttivitaEstera ae: ba.getAttivitaEstere())
				if (ae.isCancellata() || !ae.isCopiataDaVersioneLaPrecedente())
					attivitaModificate.add(ae);
		
		for (AttivitaEstera ae: attivitaModificate)
		{
			boolean esisteGemellaSostitutiva = false;
			for (AttivitaEstera ae2: attivitaModificate)
				if (!ae.getId().equals(ae2.getId()) 
						&& (ae.getLabel().toLowerCase() + " " + ae.getSemestreLabel()).equals(ae2.getLabel().toLowerCase() + " " + ae2.getSemestreLabel()) 
						&& ae.isCancellata() != ae2.isCancellata())
					esisteGemellaSostitutiva = true;
			if (!esisteGemellaSostitutiva)
				ret.add(ae);
		}
		
		return ret;
	}

	public List<AttivitaUnibo> getElencoAttivitaUniboModificateObj() {
		if (getVersione() == null || getVersione().equals(new Integer(1)))
			return null;
		
		List<AttivitaUnibo> ret = new ArrayList<AttivitaUnibo>();
		
		List<AttivitaUnibo> attivitaModificate = new ArrayList<AttivitaUnibo>();
		for (BloccoAttivita ba: getBlocchiAttivita())
			for (AttivitaUnibo au: ba.getAttivitaUnibo())
				if (au.isCancellata() || !au.isCopiataDaVersioneLaPrecedente())
					attivitaModificate.add(au);
		
		for (AttivitaUnibo au: attivitaModificate)
		{
			boolean esisteGemellaSostitutiva = false;
			for (AttivitaUnibo au2: attivitaModificate)
				if (!au.getId().equals(au2.getId()) 
						&& au.getLabel().toLowerCase().equals(au2.getLabel().toLowerCase()) 
						&& au.isCancellata() != au2.isCancellata())
					esisteGemellaSostitutiva = true;
			if (!esisteGemellaSostitutiva)
				ret.add(au);
		}
		
		return ret;
	}
	
	public boolean isEsistonoAttivitaModificate() {
		if ((getElencoAttivitaEstereModificate() == null || getElencoAttivitaEstereModificate().isEmpty()) && (getElencoAttivitaUniboModificate() == null || getElencoAttivitaUniboModificate().isEmpty()))
			return false;
		return true;
	}
	
	public static Date calcolaScadenzaApprovazione(Date dataPresentazione, int giorniApprovazioneModifiche) {
		return DateUtils.addDays(dataPresentazione, giorniApprovazioneModifiche);
	}

	public Persona getResponsabileApprovazione() {
		return responsabileApprovazione;
	}

	public void setResponsabileApprovazione(Persona responsabileApprovazione) {
		this.responsabileApprovazione = responsabileApprovazione;
	}

	public Character getFlagTesiVersionePrecedente() {
		return flagTesiVersionePrecedente;
	}

	public void setFlagTesiVersionePrecedente(Character flagTesiVersionePrecedente) {
		this.flagTesiVersionePrecedente = flagTesiVersionePrecedente;
	}

	public String getTitoloTesiVersionePrecedente() {
		return titoloTesiVersionePrecedente;
	}

	public void setTitoloTesiVersionePrecedente(String titoloTesiVersionePrecedente) {
		this.titoloTesiVersionePrecedente = titoloTesiVersionePrecedente;
	}
	
	public boolean isDatiTesiModificati() {
		if (isTesiAggiunta() || isTesiRimossa() || isTitoloModificato())
			return true;
		return false;
	}
	
	public boolean isTesiAggiunta() {
		if (getVersione() == null || getVersione().equals(1))
			return false;
		if (Common.CH_S.equals(getFlagTesi()) && !Common.CH_S.equals(getFlagTesiVersionePrecedente()))
			return true;
		return false;
	}
	
	public boolean isTesiRimossa() {
		if (getVersione() == null || getVersione().equals(1))
			return false;
		if (!Common.CH_S.equals(getFlagTesi()) && Common.CH_S.equals(getFlagTesiVersionePrecedente()))
			return true;
		return false;
	}
	
	public boolean isTitoloModificato() {
		if (getVersione() == null || getVersione().equals(1))
			return false;
		if ((getTitoloTesi() == null && getTitoloTesiVersionePrecedente() == null) || (getTitoloTesi() != null && getTitoloTesi().equals(getTitoloTesiVersionePrecedente())))
			return false;
		return true;
	}

	public Character getFlagForTraineeship() {
		if (flagForTraineeship == null)
			return 'N';
		return flagForTraineeship;
	}

	public void setFlagForTraineeship(Character flagForTraineeship) {
		this.flagForTraineeship = flagForTraineeship;
	}
	
	public boolean isForTraineeship() {
		return Common.CH_S.equals(getFlagForTraineeship());
	}

	public String getCodiciMaterieAttFuoriPianiTirocinio() {
		if (codiciMaterieAttFuoriPianiTirocinio == null && getBlocchiAttivita() != null) {
			codiciMaterieAttFuoriPianiTirocinio = "";
			for (BloccoAttivita ba: getBlocchiAttivita())
				for (AttivitaUnibo au: ba.getAttivitaUnibo())
					if (au.isTirocinioCurriculare() && au.isMateria() && (!isSuRichiestaDiRiconoscimento() || au.isAggiuntaInRichiestaRiconoscimento()))
						codiciMaterieAttFuoriPianiTirocinio += Common.idSeparator + au.getCodMateria() + "__" + au.getCfu() + Common.idSeparator;
		}			
		return codiciMaterieAttFuoriPianiTirocinio;
	}

	public void setCodiciMaterieAttFuoriPianiTirocinio(String codiciMaterieAttFuoriPianiTirocinio) {
		this.codiciMaterieAttFuoriPianiTirocinio = codiciMaterieAttFuoriPianiTirocinio;
	}

	public String getCodiciMaterieAttFuoriPianiSceltaLibera() {
		if (codiciMaterieAttFuoriPianiSceltaLibera == null && getBlocchiAttivita() != null) {
			codiciMaterieAttFuoriPianiSceltaLibera = "";
			for (BloccoAttivita ba: getBlocchiAttivita())
				for (AttivitaUnibo au: ba.getAttivitaUnibo())
					if (!au.isTirocinioCurriculare() && au.isMateria() && (!isSuRichiestaDiRiconoscimento() || au.isAggiuntaInRichiestaRiconoscimento()))
						codiciMaterieAttFuoriPianiSceltaLibera += Common.idSeparator + au.getCodMateria() + "__" + au.getCfu() + Common.idSeparator;
		}
		return codiciMaterieAttFuoriPianiSceltaLibera;
	}

	public void setCodiciMaterieAttFuoriPianiSceltaLibera(String codiciMaterieAttFuoriPianiSceltaLibera) {
		this.codiciMaterieAttFuoriPianiSceltaLibera = codiciMaterieAttFuoriPianiSceltaLibera;
	}

	public List<String> getMaterieStudenteTirocinio() {
		if (materieStudenteTirocinio == null) {
			materieStudenteTirocinio = new ArrayList<String>();
			if (getBlocchiAttivita() != null)
				for (BloccoAttivita ba: getBlocchiAttivita())
					for (AttivitaUnibo au: ba.getAttivitaUnibo())
						if (au.isTirocinioCurriculare() && au.isEsameStudente() && (!isSuRichiestaDiRiconoscimento() || au.isAggiuntaInRichiestaRiconoscimento()))
							materieStudenteTirocinio.add(au.getIdEsameStudente());
		}
		return materieStudenteTirocinio;
	}

	public void setMaterieStudenteTirocinio(List<String> materieStudenteTirocinio) {
		this.materieStudenteTirocinio = materieStudenteTirocinio;
	}

	public List<String> getMaterieNoCarrieraTirocinio() {
		if (materieNoCarrieraTirocinio == null) {
			materieNoCarrieraTirocinio = new ArrayList<String>();
			if (getBlocchiAttivita() != null)
				for (BloccoAttivita ba: getBlocchiAttivita())
					for (AttivitaUnibo au: ba.getAttivitaUnibo())
						if (au.isTirocinioCurriculare() && au.isEsameCorso() && (!isSuRichiestaDiRiconoscimento() || au.isAggiuntaInRichiestaRiconoscimento()))
							materieNoCarrieraTirocinio.add(au.getIdEsameCorso());
		}
		return materieNoCarrieraTirocinio;
	}

	public void setMaterieNoCarrieraTirocinio(List<String> materieNoCarrieraTirocinio) {
		this.materieNoCarrieraTirocinio = materieNoCarrieraTirocinio;
	}

	public List<String> getMaterieStudenteSceltaLibera() {
		if (materieStudenteSceltaLibera == null) {
			materieStudenteSceltaLibera = new ArrayList<String>();
			if (getBlocchiAttivita() != null)
				for (BloccoAttivita ba: getBlocchiAttivita())
					for (AttivitaUnibo au: ba.getAttivitaUnibo())
						if (!au.isTirocinioCurriculare() && au.isEsameStudente() && (!isSuRichiestaDiRiconoscimento() || au.isAggiuntaInRichiestaRiconoscimento()))
							materieStudenteSceltaLibera.add(au.getIdEsameStudente());
		}
		return materieStudenteSceltaLibera;
	}

	public void setMaterieStudenteSceltaLibera(List<String> materieStudenteSceltaLibera) {
		this.materieStudenteSceltaLibera = materieStudenteSceltaLibera;
	}

	public List<String> getMaterieNoCarrieraSceltaLibera() {
		if (materieNoCarrieraSceltaLibera == null) {
			materieNoCarrieraSceltaLibera = new ArrayList<String>();
			if (getBlocchiAttivita() != null)
				for (BloccoAttivita ba: getBlocchiAttivita())
					for (AttivitaUnibo au: ba.getAttivitaUnibo())
						if (!au.isTirocinioCurriculare() && au.isEsameCorso() && (!isSuRichiestaDiRiconoscimento() || au.isAggiuntaInRichiestaRiconoscimento()))
							materieNoCarrieraSceltaLibera.add(au.getIdEsameCorso());
		}
		return materieNoCarrieraSceltaLibera;
	}

	public void setMaterieNoCarrieraSceltaLibera(List<String> materieNoCarrieraSceltaLibera) {
		this.materieNoCarrieraSceltaLibera = materieNoCarrieraSceltaLibera;
	}

	public Integer getNumeroOreTirocinio() {
		return numeroOreTirocinio;
	}

	public void setNumeroOreTirocinio(Integer numeroOreTirocinio) {
		this.numeroOreTirocinio = numeroOreTirocinio;
	}

	public Character getFlagCreditiAScelta() {
		return flagCreditiAScelta;
	}

	public void setFlagCreditiAScelta(Character flagCreditiAScelta) {
		this.flagCreditiAScelta = flagCreditiAScelta;
	}
	
	public boolean isCreditiAScelta() {
		return Common.CH_S.equals(getFlagCreditiAScelta());
	}

	public List<AttivitaUnibo> getCfuASceltaList() {
		if (this.cfuASceltaList != null)
			return this.cfuASceltaList;
		List<AttivitaUnibo> ret = new ArrayList<AttivitaUnibo>();
		if (getBlocchiAttivita() != null && !getBlocchiAttivita().isEmpty())
			for (AttivitaUnibo au: getBlocchiAttivita().first().getAttivitaUnibo())
				if (au.isSceltaLibera() && au.isNonUtileAlConseguimentoDelTitolo() && (!isSuRichiestaDiRiconoscimento() || au.isAggiuntaInRichiestaRiconoscimento()))
					ret.add(au);
		this.cfuASceltaList = ret;
		return ret;
	}
	
	public void setCfuASceltaList(List<AttivitaUnibo> att) {
		this.cfuASceltaList = att;
	}
	
	public List<AttivitaUnibo> getAttivitaTirocinioCurriculare() {
		if (!isForTraineeship())
			throw new RuntimeException("Tentativo di lettura di attivita' relative a un LAT per un LA non for traineeship");
		List<AttivitaUnibo> ret = new ArrayList<AttivitaUnibo>();
		if (getBlocchiAttivita() != null)
			for (BloccoAttivita ba: getBlocchiAttivita())
				for (AttivitaUnibo au: ba.getAttivitaUnibo())
					if (au.isTirocinioCurriculare())
						ret.add(au);
		return ret;
	}
	
	public List<AttivitaUnibo> getAttivitaSceltaLibera() {
		if (!isForTraineeship())
			throw new RuntimeException("Tentativo di lettura di attivita' relative a un LAT per un LA non for traineeship");
		List<AttivitaUnibo> ret = new ArrayList<AttivitaUnibo>();
		if (getBlocchiAttivita() != null)
			for (BloccoAttivita ba: getBlocchiAttivita())
				for (AttivitaUnibo au: ba.getAttivitaUnibo())
					if (!au.isNonUtileAlConseguimentoDelTitolo() && !au.isTirocinioCurriculare())
						ret.add(au);
		return ret;
	}
	
	public List<AttivitaUnibo> getAttivitaNonUtiliAlConseguimentoTitolo() {
		if (!isForTraineeship())
			throw new RuntimeException("Tentativo di lettura di attivita' relative a un LAT per un LA non for traineeship");
		List<AttivitaUnibo> ret = new ArrayList<AttivitaUnibo>();
		if (getBlocchiAttivita() != null)
			for (BloccoAttivita ba: getBlocchiAttivita())
				for (AttivitaUnibo au: ba.getAttivitaUnibo())
					if (au.isNonUtileAlConseguimentoDelTitolo())
						ret.add(au);
		return ret;
	}

	public Integer getNumeroOreTirocinioInRR() {
		return numeroOreTirocinioInRR;
	}

	public void setNumeroOreTirocinioInRR(Integer numeroOreTirocinioInRR) {
		this.numeroOreTirocinioInRR = numeroOreTirocinioInRR;
	}

	public Character getFlagCreditiASceltaInRR() {
		return flagCreditiASceltaInRR;
	}

	public void setFlagCreditiASceltaInRR(Character flagCreditiASceltaInRR) {
		this.flagCreditiASceltaInRR = flagCreditiASceltaInRR;
	}
	
	public boolean isCreditiASceltaInRR() {
		return Common.CH_S.equals(getFlagCreditiASceltaInRR());
	}
	
	public List<AttivitaEstera> getElencoAttivitaEstereNonEliminate() {
		List<AttivitaEstera> ret = new ArrayList<AttivitaEstera>();
		if (getBlocchiAttivita() != null)
			for (BloccoAttivita ba: getBlocchiAttivita())
				if (!ba.isCancellato() && ba.getAttivitaEstere() != null)
					for (AttivitaEstera ae: ba.getAttivitaEstere()){
						if (!ae.isCancellata())
							ret.add(ae);
					}
		return ret ;
	}

	public List<AttivitaUnibo> getElencoAttivitaUniboNonEliminate() {
		List<AttivitaUnibo> ret = new ArrayList<AttivitaUnibo>();
		if (getBlocchiAttivita() != null)
			for (BloccoAttivita ba: getBlocchiAttivita())
				if (!ba.isCancellato() && ba.getAttivitaUnibo() != null)
					for (AttivitaUnibo au: ba.getAttivitaUnibo()){
						if (!au.isCancellata())
							ret.add(au);
					}
		return ret ;
	}

	public Integer getNumeroOreSettimanaliTirocinio() {
		return numeroOreSettimanaliTirocinio;
	}

	public void setNumeroOreSettimanaliTirocinio(Integer numeroOreSettimanaliTirocinio) {
		this.numeroOreSettimanaliTirocinio = numeroOreSettimanaliTirocinio;
	}

	public boolean isGestioneOreSettimanaliTirocinioAbilitata() {
		// TODO remove when in production
		final int ANNO_CAMBIAMENTO = Common.isTestingEnvironment() ?  TO_DEL_TEST_ANNO_MODIFICHE : 2018;
		if (isForTraineeship()
				&& getStudenteOutgoing() != null
				&& getStudenteOutgoing().getBando() != null
				&& getStudenteOutgoing().getBando().getPeriodoMobilita() != null
				&& getStudenteOutgoing().getBando().getPeriodoMobilita().getAnnoAccademico() >= ANNO_CAMBIAMENTO)
			return true;
		return false;
	}

	private static final int TO_DEL_TEST_ANNO_MODIFICHE = 2017;

	public boolean isGestioneAttivitaALiberaSceltaAbilitata() {
		// TODO remove when in production
		final int ANNO_CAMBIAMENTO = Common.isTestingEnvironment() ?  TO_DEL_TEST_ANNO_MODIFICHE : 2018;
		if (isForTraineeship()
				&& getStudenteOutgoing() != null
				&& getStudenteOutgoing().getBando() != null
				&& getStudenteOutgoing().getBando().getPeriodoMobilita() != null
				&& getStudenteOutgoing().getBando().getPeriodoMobilita().getAnnoAccademico() < ANNO_CAMBIAMENTO)
			return true;
		return false;
	}
}

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
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.studenti.Corso;
import it.unibo.almarm.model.outgoing.learningagreement.StatoLearningAgreement;
import it.unibo.almarm.util.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class StudenteOutgoingView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String stato;
	private String nome;
	private String cognome;
	private Ateneo ateneo;
	private String bandoLbl;
	private AccordoOperativo accordoOperativo;
	private String matricola;
	private String codFac;
	private String descFac;
	private Long idBando;
	private String siglaPolo;
	private String statoLearningAgreement;
	private Corso corso;
	private Date dataPresentazioneLa;
	private Character flagContrattoFirmato;
	private Integer versioneLA;
	private String statoRichiestaRiconoscimento;
	private Long idPeriodoMobilita;
	private Character flagRelazioneFinaleConsegnata;
	private Character flagQuestionarioCompilato;
	private Candidatura candidatura;
	private String nomeAteneoAzienda;
	private Long idNazioneAteneoAzienda;
	private String codiceErasmus;
	private Long idScuola;
	private Long idVicepresidenza;
	private Long idDipartimento;
	private Long idUsd;
	private String descVicepresidenza;
	private Bando bando;
	private Character flagTrainingAgreementPrimaDellaPartenza;
	private String statoDocLAtFirmato;
	private Integer periodoDiPermanenzaNomina;
	private Character flagTrainingAgreement;
	private Long idAreaGeoOrga;
	private String documentoApprovazioneLA;
	private Character flagConBorsa;
	private Character flagTR;
	private Character flagDocOriginaliConsegnati;
    private Long idSottoProgramma;

	private Set<ReferenteStudenteOutgoingView> referentiStudenteOutgoing = new HashSet<ReferenteStudenteOutgoingView>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Ateneo getAteneo() {
		return ateneo;
	}

	public void setAteneo(Ateneo ateneo) {
		this.ateneo = ateneo;
	}

	public String getBandoLbl() {
		return bandoLbl;
	}

	public void setBandoLbl(String bandoLbl) {
		this.bandoLbl = bandoLbl;
	}

	public AccordoOperativo getAccordoOperativo() {
		return accordoOperativo;
	}

	public void setAccordoOperativo(AccordoOperativo accordoOperativo) {
		this.accordoOperativo = accordoOperativo;
	}
	
	public String getAteneoLabel() {
		if (ateneo == null)
			return "";
		return ateneo.getCodiceErasmus() + " - " + ateneo.getRagioneSociale() + " - " + (ateneo.getNazionalita() != null ? ateneo.getNazionalita().getDescrizioneOrig() : "");
	}
	
	public String getColor() {
		return StatoStudenteOutgoing.get(stato).getColor();
	}
	
	public String getColorDesc() {
		return StatoStudenteOutgoing.get(stato).getValore();
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getCodFac() {
		return codFac;
	}

	public void setCodFac(String codFac) {
		this.codFac = codFac;
	}

	public String getDescFac() {
		return descFac;
	}

	public void setDescFac(String descFac) {
		this.descFac = descFac;
	}

	public Long getIdBando() {
		return idBando;
	}

	public void setIdBando(Long idBando) {
		this.idBando = idBando;
	}

	public String getSiglaPolo() {
		return siglaPolo;
	}

	public void setSiglaPolo(String siglaPolo) {
		this.siglaPolo = siglaPolo;
	}
	
	public String getColorLearningAgreement() {
		if ("non presente".equals(statoLearningAgreement))
			return "Grey";
		return StatoLearningAgreement.get(statoLearningAgreement).getColor();
	}
	
	public String getColorLearningAgreementDesc() {
		if ("non presente".equals(statoLearningAgreement))
			return "non presente";
		return StatoLearningAgreement.get(statoLearningAgreement).getValore();
	}

	public String getStatoLearningAgreement() {
		return statoLearningAgreement;
	}

	public void setStatoLearningAgreement(String statoLearningAgreement) {
		this.statoLearningAgreement = statoLearningAgreement;
	}

	public Set<ReferenteStudenteOutgoingView> getReferentiStudenteOutgoing() {
		return referentiStudenteOutgoing;
	}

	public void setReferentiStudenteOutgoing(
			Set<ReferenteStudenteOutgoingView> referentiStudenteOutgoing) {
		this.referentiStudenteOutgoing = referentiStudenteOutgoing;
	}
	
	public String getFacCorso() {
		return StringUtils.defaultIfEmpty(getDescFac(), "") + " - " + (getCorso() != null ? getCorso().getDescrizione() : "");
	}
	
	public String getPoloFacCorso() {
		return StringUtils.defaultIfEmpty(getSiglaPolo(), "") + " - " + getFacCorso();
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	
	// Ordinata cognome, nome ASC
	public String getReferentiLabel() {
		String ref = "";
		if (!getReferentiStudenteOutgoing().isEmpty()){
			List<ReferenteStudenteOutgoingView> l = new ArrayList<ReferenteStudenteOutgoingView>();
			l.addAll(getReferentiStudenteOutgoing());
			Collections.sort(l, new ReferenteStudenteOutgoingViewCognNomeAscComparator());
			for (ReferenteStudenteOutgoingView r: l)
				if (!r.isCoordinatoreCorso())
					ref += r.getCognome() + " " + r.getNome() + "<br/>";
			if (ref.length() >= 5)
				ref = ref.substring(0, ref.length() - 5);
		}
		return ref;
	}

	public Date getDataPresentazioneLa() {
		return dataPresentazioneLa;
	}

	public void setDataPresentazioneLa(Date dataPresentazioneLa) {
		this.dataPresentazioneLa = dataPresentazioneLa;
	}

	public Character getFlagContrattoFirmato() {
		return flagContrattoFirmato;
	}

	public void setFlagContrattoFirmato(Character flagContrattoFirmato) {
		this.flagContrattoFirmato = flagContrattoFirmato;
	}

	public Integer getVersioneLA() {
		return versioneLA;
	}

	public void setVersioneLA(Integer versioneLA) {
		this.versioneLA = versioneLA;
	}

	public String getStatoRichiestaRiconoscimento() {
		return statoRichiestaRiconoscimento;
	}

	public void setStatoRichiestaRiconoscimento(String statoRichiestaRiconoscimento) {
		this.statoRichiestaRiconoscimento = statoRichiestaRiconoscimento;
	}

	public Long getIdPeriodoMobilita() {
		return idPeriodoMobilita;
	}

	public void setIdPeriodoMobilita(Long idPeriodoMobilita) {
		this.idPeriodoMobilita = idPeriodoMobilita;
	}
	
	public String getColorRichiestaRiconoscimento() {
		if ("non presente".equals(statoRichiestaRiconoscimento))
			return "Grey";
		return StatoRichiestaRiconoscimento.get(statoRichiestaRiconoscimento).getColor();
	}
	
	public String getColorRichiestaRiconoscimentoDesc() {
		if ("non presente".equals(statoRichiestaRiconoscimento))
			return "non presente";
		return StatoRichiestaRiconoscimento.get(statoRichiestaRiconoscimento).getValore();
	}

	public Character getFlagRelazioneFinaleConsegnata() {
		return flagRelazioneFinaleConsegnata;
	}

	public void setFlagRelazioneFinaleConsegnata(
			Character flagRelazioneFinaleConsegnata) {
		this.flagRelazioneFinaleConsegnata = flagRelazioneFinaleConsegnata;
	}

	public Character getFlagQuestionarioCompilato() {
		return flagQuestionarioCompilato;
	}

	public void setFlagQuestionarioCompilato(Character flagQuestionarioCompilato) {
		this.flagQuestionarioCompilato = flagQuestionarioCompilato;
	}

	public Candidatura getCandidatura() {
		return candidatura;
	}

	public void setCandidatura(Candidatura candidatura) {
		this.candidatura = candidatura;
	}

	public String getAteneoAziendaLabel() {
		if (bando.getSottoProgramma().isScambioConAzienda())
			return candidatura.getCandidaturaDatiPlacement().getDenominazioneAzienda() + ( candidatura.getCandidaturaDatiPlacement().getNazionalitaAzienda() != null ? " - " + candidatura.getCandidaturaDatiPlacement().getNazionalitaAzienda().getDescrizioneOrig() : "");
		return getAteneoLabel();
	}

	public String getNomeAteneoAzienda() {
		return nomeAteneoAzienda;
	}

	public void setNomeAteneoAzienda(String nomeAteneoAzienda) {
		this.nomeAteneoAzienda = nomeAteneoAzienda;
	}

	public Long getIdNazioneAteneoAzienda() {
		return idNazioneAteneoAzienda;
	}

	public void setIdNazioneAteneoAzienda(Long idNazioneAteneoAzienda) {
		this.idNazioneAteneoAzienda = idNazioneAteneoAzienda;
	}

	public String getCodiceErasmus() {
		return codiceErasmus;
	}

	public void setCodiceErasmus(String codiceErasmus) {
		this.codiceErasmus = codiceErasmus;
	}

	public Long getIdScuola() {
		return idScuola;
	}

	public void setIdScuola(Long idScuola) {
		this.idScuola = idScuola;
	}

	public Long getIdVicepresidenza() {
		return idVicepresidenza;
	}

	public void setIdVicepresidenza(Long idVicepresidenza) {
		this.idVicepresidenza = idVicepresidenza;
	}

	public Long getIdDipartimento() {
		return idDipartimento;
	}

	public void setIdDipartimento(Long idDipartimento) {
		this.idDipartimento = idDipartimento;
	}

	public Long getIdUsd() {
		return idUsd;
	}

	public void setIdUsd(Long idUsd) {
		this.idUsd = idUsd;
	}

	public String getDescVicepresidenza() {
		return descVicepresidenza;
	}

	public void setDescVicepresidenza(String descVicepresidenza) {
		this.descVicepresidenza = descVicepresidenza;
	}
	public String getPoloVicepresidenzaCorso() {
		return StringUtils.defaultIfEmpty(getSiglaPolo(), "") 
				+ " - " + StringUtils.defaultIfEmpty(getDescVicepresidenza(), "") 
				+ " - " + (getCorso() != null ? getCorso().getDescrizione() : "");
	}

	public Bando getBando() {
		return bando;
	}

	public void setBando(Bando bando) {
		this.bando = bando;
	}

	public boolean isCompilazioneSOAttiva() {
		return getBando().isGestionePeriodoScambioPerStudentiAttiva();
	}

	public Character getFlagTrainingAgreementPrimaDellaPartenza() {
		return flagTrainingAgreementPrimaDellaPartenza;
	}

	public void setFlagTrainingAgreementPrimaDellaPartenza(
			Character flagTrainingAgreementPrimaDellaPartenza) {
		this.flagTrainingAgreementPrimaDellaPartenza = flagTrainingAgreementPrimaDellaPartenza;
	}
	
	public String getStatoDocLAtFirmato() {
		return statoDocLAtFirmato;
	}

	public void setStatoDocLAtFirmato(String statoDocLAtFirmato) {
		this.statoDocLAtFirmato = statoDocLAtFirmato;
	}

	public Integer getPeriodoDiPermanenzaNomina() {
		return periodoDiPermanenzaNomina;
	}

	public void setPeriodoDiPermanenzaNomina(Integer periodoDiPermanenzaNomina) {
		this.periodoDiPermanenzaNomina = periodoDiPermanenzaNomina;
	}

	public Character getFlagTrainingAgreement() {
		return flagTrainingAgreement;
	}

	public void setFlagTrainingAgreement(Character flagTrainingAgreement) {
		this.flagTrainingAgreement = flagTrainingAgreement;
	}

	public Long getIdAreaGeoOrga() {
		return idAreaGeoOrga;
	}

	public void setIdAreaGeoOrga(Long idAreaGeoOrga) {
		this.idAreaGeoOrga = idAreaGeoOrga;
	}

    public Long getIdSottoProgramma() {
        return idSottoProgramma;
    }

    public void setIdSottoProgramma(Long idSottoProgramma) {
        this.idSottoProgramma = idSottoProgramma;
    }

	public static class ReferenteStudenteOutgoingViewCognNomeAscComparator  implements Comparator<ReferenteStudenteOutgoingView>
	{
		public int compare(ReferenteStudenteOutgoingView o1, ReferenteStudenteOutgoingView o2) {
				if (o1 == null && o2 == null)
					return 0;
				if (o1 == null || o1.getCognome() == null || o1.getNome() == null)
					return 1;
				if (o2 == null || o2.getCognome() == null || o2.getNome() == null)
					return -1;
				if (o1.getCognome().equals(o2.getCognome()))
					return o1.getNome().compareTo(o2.getNome());
				return o1.getCognome().compareTo(o2.getCognome());
		}
	}

	public String getDocumentoApprovazioneLA() {
		return documentoApprovazioneLA;
	}

	public void setDocumentoApprovazioneLA(String documentoApprovazioneLA) {
		this.documentoApprovazioneLA = documentoApprovazioneLA;
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

	public Character getFlagTR() {
		return flagTR;
	}

	public void setFlagTR(Character flagTR) {
		this.flagTR = flagTR;
	}

	public Character getFlagDocOriginaliConsegnati() {
		return flagDocOriginaliConsegnati;
	}

	public void setFlagDocOriginaliConsegnati(Character flagDocOriginaliConsegnati) {
		this.flagDocOriginaliConsegnati = flagDocOriginaliConsegnati;
	}
}

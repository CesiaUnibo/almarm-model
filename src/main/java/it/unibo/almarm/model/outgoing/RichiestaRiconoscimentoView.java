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
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.attori.studenti.Corso;
import it.unibo.almarm.model.outgoing.learningagreement.ReferenteLearningAgreementView;
import it.unibo.almarm.util.Common;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.DateUtils;

public class RichiestaRiconoscimentoView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String cognomeStudente;
	private String nomeStudente;
	private Bando bando;
	private Corso corso;
	private Persona referenteInterno;
	private String stato;
	private Date dataPresentazione;
	private Long idStudenteOutgoing;
	private Ateneo ateneo;
	private Long idLearningAgreement;
	private Integer giorniApprovazione;
	private String siglaPolo;
	private Long idScuola;
	private Long idVicepresidenza;
	private Long idDipartimento;
	private Long idUsd;
	private String nomePartner;
	
	private Set<ReferenteLearningAgreementView> referentiInterni = new HashSet<ReferenteLearningAgreementView>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCognomeStudente() {
		return cognomeStudente;
	}

	public void setCognomeStudente(String cognomeStudente) {
		this.cognomeStudente = cognomeStudente;
	}

	public String getNomeStudente() {
		return nomeStudente;
	}

	public void setNomeStudente(String nomeStudente) {
		this.nomeStudente = nomeStudente;
	}

	public Bando getBando() {
		return bando;
	}

	public void setBando(Bando bando) {
		this.bando = bando;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public Persona getReferenteInterno() {
		return referenteInterno;
	}

	public void setReferenteInterno(Persona referenteInterno) {
		this.referenteInterno = referenteInterno;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDataPresentazione() {
		return dataPresentazione;
	}

	public void setDataPresentazione(Date dataPresentazione) {
		this.dataPresentazione = dataPresentazione;
	}

	public Long getIdStudenteOutgoing() {
		return idStudenteOutgoing;
	}

	public void setIdStudenteOutgoing(Long idStudenteOutgoing) {
		this.idStudenteOutgoing = idStudenteOutgoing;
	}

	public Ateneo getAteneo() {
		return ateneo;
	}

	public void setAteneo(Ateneo ateneo) {
		this.ateneo = ateneo;
	}

	public Set<ReferenteLearningAgreementView> getReferentiInterni() {
		return referentiInterni;
	}

	public void setReferentiInterni(
			Set<ReferenteLearningAgreementView> referentiInterni) {
		this.referentiInterni = referentiInterni;
	}

	public Long getIdLearningAgreement() {
		return idLearningAgreement;
	}

	public void setIdLearningAgreement(Long idLearningAgreement) {
		this.idLearningAgreement = idLearningAgreement;
	}
	
	public String getColor() {
		return StatoRichiestaRiconoscimento.get(stato).getColor();
	}
	
	public String getColorDesc() {
		return StatoRichiestaRiconoscimento.get(stato).getMessageKey();
	}
	
	public String getColorScadenza() {
		Float percentuale = getPercentualeScadenza(); 
		if (percentuale < 12.5)
			return "#009900";
		if (percentuale < 37.5)
			return "#009900";
		if (percentuale < 62.5)
			return "#009900";
		if (percentuale < 87.5)
			return "#009900";
		return "#009900";
	}
	
	public Float getPercentualeScadenza() {
		Long giorni = getGiorniResidui();
		if (giorni == null)
			return 100F;
		float perc = ((getGiorniApprovazione() - giorni) * 100) / getGiorniApprovazione();
		if (perc < 0 || perc > 100)
			return 100F;
		return perc;
	}
	
	public Long getGiorniResidui() {
		if (getDataPresentazione() == null)
			return null;
		long mill = (new Date()).getTime() - getDataPresentazione().getTime();
		Long gg = getGiorniApprovazione() - TimeUnit.DAYS.convert(mill, TimeUnit.MILLISECONDS);
		return (gg >= 0 ? gg : null);
	}
	
	public Date getDataScadenza() {
		return DateUtils.addDays(getDataPresentazione(), getGiorniApprovazione());
	}
	
	public String getDataScadenzaLabel() {
		return Common.getDataOraFormattata(getDataScadenza());
	}

	public Integer getGiorniApprovazione() {
		return giorniApprovazione;
	}

	public void setGiorniApprovazione(Integer giorniApprovazione) {
		this.giorniApprovazione = giorniApprovazione;
	}

	public String getSiglaPolo() {
		return siglaPolo;
	}

	public void setSiglaPolo(String siglaPolo) {
		this.siglaPolo = siglaPolo;
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

	public String getNomePartner() {
		return nomePartner;
	}

	public void setNomePartner(String nomePartner) {
		this.nomePartner = nomePartner;
	}
	
	public boolean isErasmusPlacement() {
		return getBando().isErasmusPlacement();
	}
}

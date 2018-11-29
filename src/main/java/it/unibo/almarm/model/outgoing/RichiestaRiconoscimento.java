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

import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.outgoing.learningagreement.AttivitaEstera;
import it.unibo.almarm.model.outgoing.learningagreement.AttivitaUnibo;
import it.unibo.almarm.model.outgoing.learningagreement.BloccoAttivita;
import it.unibo.almarm.model.outgoing.learningagreement.LearningAgreement;
import it.unibo.almarm.util.Common;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

public class RichiestaRiconoscimento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private StudenteOutgoing studenteOutgoing;
	private LearningAgreement learningAgreement;
	private Integer versione;
	private Integer iterazione;
	private String stato;
	private String noteStudente;
	private Date dataCreazione;
	private Persona autoreCreazione;
	private Date dataFine;
	private Date dataPresentazione;
	private Persona autorePresentazione;
	private String noteValidazione;
	private Date dataValidazione;
	private Persona autoreValidazione;
	private String noteRifiutoValidazione;
	private Date dataApprovazione;
	private Persona autoreApprovazione;
	private String noteRifiutoApprovazione;
	private Persona autoreRifiutoApprovazione;
	private Date dataCcds;
	private Date dataRifiutoApprovazione;
	private String noteApprovazione;
	private Integer idPratica;
	private String idDocumentoApprovazione;
	private String nomeDocumentoApprovazione;
	private Persona autoreDocApprovazione;
	private Date dataDocApprovazione;
	private Character flagNoPratica;
	private String noPraticaDesc;
	private Persona autoreArchiviazione;
	private Date dataArchiviazione;
	
	private Set<RichiestaRiconoscimentoAnnullamentoApprovazione> annullamenti = new HashSet<RichiestaRiconoscimentoAnnullamentoApprovazione>();
	
	// campi non persistiti
	private transient MultipartFile documentoApprovazione;
	private String noteTornaAPresentata;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudenteOutgoing getStudenteOutgoing() {
		return studenteOutgoing;
	}

	public void setStudenteOutgoing(StudenteOutgoing studenteOutgoing) {
		this.studenteOutgoing = studenteOutgoing;
	}

	public LearningAgreement getLearningAgreement() {
		return learningAgreement;
	}

	public void setLearningAgreement(LearningAgreement learningAgreement) {
		this.learningAgreement = learningAgreement;
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

	public boolean isApprovata() {
		return StatoRichiestaRiconoscimento.APPROVATA.getValore().equals(getStato());
	}
	
	public boolean isRifiutata() {
		return StatoRichiestaRiconoscimento.RIFIUTATA_PRESENTATA.getValore().equals(getStato()) 
			|| StatoRichiestaRiconoscimento.RIFIUTATA_VALIDATA.getValore().equals(getStato())
			|| StatoRichiestaRiconoscimento.RIFIUTATA_DEFINITIVAMENTE.getValore().equals(getStato());
	}
	
	public boolean isRifiutataDefinitivamente() {
		return StatoRichiestaRiconoscimento.RIFIUTATA_DEFINITIVAMENTE.getValore().equals(getStato());
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getNoteStudente() {
		return noteStudente;
	}

	public void setNoteStudente(String noteStudente) {
		this.noteStudente = noteStudente;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Persona getAutoreCreazione() {
		return autoreCreazione;
	}

	public void setAutoreCreazione(Persona autoreCreazione) {
		this.autoreCreazione = autoreCreazione;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataPresentazione() {
		return dataPresentazione;
	}

	public void setDataPresentazione(Date dataPresentazione) {
		this.dataPresentazione = dataPresentazione;
	}

	public Persona getAutorePresentazione() {
		return autorePresentazione;
	}

	public void setAutorePresentazione(Persona autorePresentazione) {
		this.autorePresentazione = autorePresentazione;
	}
	
	public String getColor() {
		return StatoRichiestaRiconoscimento.get(stato).getColor();
	}
	
	public String getColorDesc() {
		return StatoRichiestaRiconoscimento.get(stato).getMessageKey();
	}
	
	public String getVersioneLabel() {
		return versione + "." + iterazione;
	}

	public boolean isAlmenoPresentata() {
		return !StatoRichiestaRiconoscimento.DA_PRESENTARE.getValore().equals(getStato());
	}
	
	public boolean isAlmenoValidata() {
		return isAlmenoPresentata() && !StatoRichiestaRiconoscimento.PRESENTATA.getValore().equals(getStato());
	}

	public String getNoteValidazione() {
		return noteValidazione;
	}

	public void setNoteValidazione(String noteValidazione) {
		this.noteValidazione = noteValidazione;
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

	public String getNoteRifiutoValidazione() {
		return noteRifiutoValidazione;
	}

	public void setNoteRifiutoValidazione(String noteRifiutoValidazione) {
		this.noteRifiutoValidazione = noteRifiutoValidazione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((iterazione == null) ? 0 : iterazione.hashCode());
		result = prime
				* result
				+ ((studenteOutgoing == null) ? 0 : studenteOutgoing.hashCode());
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
		if (!(obj instanceof RichiestaRiconoscimento))
			return false;
		RichiestaRiconoscimento other = (RichiestaRiconoscimento) obj;
		if (iterazione == null) {
			if (other.iterazione != null)
				return false;
		} else if (!iterazione.equals(other.iterazione))
			return false;
		if (studenteOutgoing == null) {
			if (other.studenteOutgoing != null)
				return false;
		} else if (!studenteOutgoing.equals(other.studenteOutgoing))
			return false;
		if (versione == null) {
			if (other.versione != null)
				return false;
		} else if (!versione.equals(other.versione))
			return false;
		return true;
	}

	public Date getDataApprovazione() {
		return dataApprovazione;
	}

	public void setDataApprovazione(Date dataApprovazione) {
		this.dataApprovazione = dataApprovazione;
	}

	public Persona getAutoreApprovazione() {
		return autoreApprovazione;
	}

	public void setAutoreApprovazione(Persona autoreApprovazione) {
		this.autoreApprovazione = autoreApprovazione;
	}

	public String getNoteRifiutoApprovazione() {
		return noteRifiutoApprovazione;
	}

	public void setNoteRifiutoApprovazione(String noteRifiutoApprovazione) {
		this.noteRifiutoApprovazione = noteRifiutoApprovazione;
	}

	public Persona getAutoreRifiutoApprovazione() {
		return autoreRifiutoApprovazione;
	}

	public void setAutoreRifiutoApprovazione(Persona autoreRifiutoApprovazione) {
		this.autoreRifiutoApprovazione = autoreRifiutoApprovazione;
	}

	public Date getDataCcds() {
		return dataCcds;
	}

	public void setDataCcds(Date dataCcds) {
		this.dataCcds = dataCcds;
	}

	public Date getDataRifiutoApprovazione() {
		return dataRifiutoApprovazione;
	}

	public void setDataRifiutoApprovazione(Date dataRifiutoApprovazione) {
		this.dataRifiutoApprovazione = dataRifiutoApprovazione;
	}

	public String getNoteApprovazione() {
		return noteApprovazione;
	}

	public void setNoteApprovazione(String noteApprovazione) {
		this.noteApprovazione = noteApprovazione;
	}

	public Integer getIdPratica() {
		return idPratica;
	}

	public void setIdPratica(Integer idPratica) {
		this.idPratica = idPratica;
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

	public Persona getAutoreDocApprovazione() {
		return autoreDocApprovazione;
	}

	public void setAutoreDocApprovazione(Persona autoreDocApprovazione) {
		this.autoreDocApprovazione = autoreDocApprovazione;
	}

	public Date getDataDocApprovazione() {
		return dataDocApprovazione;
	}

	public void setDataDocApprovazione(Date dataDocApprovazione) {
		this.dataDocApprovazione = dataDocApprovazione;
	}
	
	public boolean isPresentata() {
		return StatoRichiestaRiconoscimento.PRESENTATA.getValore().equals(getStato());
	}
	
	public boolean isValidata() {
		return StatoRichiestaRiconoscimento.VALIDATA.getValore().equals(getStato());
	}

	public Character getFlagNoPratica() {
		return flagNoPratica;
	}

	public void setFlagNoPratica(Character flagNoPratica) {
		this.flagNoPratica = flagNoPratica;
	}
	
	public boolean isNoPratica() {
		return Common.CH_S.equals(getFlagNoPratica());
	}

	public String getNoPraticaDesc() {
		return noPraticaDesc;
	}

	public void setNoPraticaDesc(String noPraticaDesc) {
		this.noPraticaDesc = noPraticaDesc;
	}
	
	public boolean isDaArchiviare() {
		if (!isAlmenoPresentata())
			return false;
		if (getLearningAgreement() == null)
			return false;
		if ((!getLearningAgreement().isStudioInRR() || getLearningAgreement().isTirocinioInRR() || getLearningAgreement().isTesiInRR()) && !isForTraineeship())
			return false;
		if (isForTraineeship() && getLearningAgreement().isTesiInRR())
			return false;
		if (!isForTraineeship()) {
			for (BloccoAttivita ba: getLearningAgreement().getBlocchiAttivita()) 
				for (AttivitaEstera ae: ba.getAttivitaEstere())
					if (ae.isDaRiconoscere())
						return false;
		}
		else if (isForTraineeship()) {
			for (BloccoAttivita ba: getLearningAgreement().getBlocchiAttivita()) 
				for (AttivitaUnibo au: ba.getAttivitaUnibo())
					if (au.isDaRiconoscere())
						return false;
		}
			
		return true;
	}

	public Persona getAutoreArchiviazione() {
		return autoreArchiviazione;
	}

	public void setAutoreArchiviazione(Persona autoreArchiviazione) {
		this.autoreArchiviazione = autoreArchiviazione;
	}

	public Date getDataArchiviazione() {
		return dataArchiviazione;
	}

	public void setDataArchiviazione(Date dataArchiviazione) {
		this.dataArchiviazione = dataArchiviazione;
	}

	public Set<RichiestaRiconoscimentoAnnullamentoApprovazione> getAnnullamenti() {
		return annullamenti;
	}

	public void setAnnullamenti(
			Set<RichiestaRiconoscimentoAnnullamentoApprovazione> annullamenti) {
		this.annullamenti = annullamenti;
	}
	
	public RichiestaRiconoscimentoAnnullamentoApprovazione getUltimoAnnullamento() {
		RichiestaRiconoscimentoAnnullamentoApprovazione rraa = null;
		for (RichiestaRiconoscimentoAnnullamentoApprovazione r: getAnnullamenti())
			if (rraa == null || rraa.getDataAnnullamento().before(r.getDataAnnullamento()))
				rraa = r;
		return rraa;
	}

	public String getNoteTornaAPresentata() {
		return noteTornaAPresentata;
	}

	public void setNoteTornaAPresentata(String noteTornaAPresentata) {
		this.noteTornaAPresentata = noteTornaAPresentata;
	}
	
	public boolean isForTraineeship() {
		if (getLearningAgreement() != null)
			return getLearningAgreement().isForTraineeship();
		if (getStudenteOutgoing() != null)
			return getStudenteOutgoing().isPlacement();
		return false;
	}

    public boolean isContieneIntegratiRiconosciuti() {
		for (AttivitaUnibo au: getLearningAgreement().getElencoAttivitaUnibo())
			if (au.isRiconosiuta() && au.isAFAppartieneAIntegrato())
				return true;
        return false;
    }

	public boolean isGestioneAttivitaALiberaSceltaAbilitata() {
		return this.getLearningAgreement() != null ? this.getLearningAgreement().isGestioneAttivitaALiberaSceltaAbilitata() : false;
	}
}

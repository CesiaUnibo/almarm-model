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
import it.unibo.almarm.model.outgoing.learningagreement.LearningAgreement;

import java.util.Date;

public class RichiestaRiconoscimentoAnnullamentoApprovazione implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataAnnullamento;
	private Persona autoreAnnullamento;
	private String noteAnnullamento;
	private String noteValidazione;
	private Date dataValidazione;
	private Persona autoreValidazione;
	private Date dataApprovazione;
	private Persona autoreApprovazione;
	private Date dataCcds;
	private String noteApprovazione;
	private Integer idPratica;
	private String idDocumentoApprovazione;
	private String nomeDocumentoApprovazione;
	private Persona autoreDocApprovazione;
	private Date dataDocApprovazione;
	private LearningAgreement learningAgreement;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAnnullamento() {
		return dataAnnullamento;
	}

	public void setDataAnnullamento(Date dataAnnullamento) {
		this.dataAnnullamento = dataAnnullamento;
	}

	public Persona getAutoreAnnullamento() {
		return autoreAnnullamento;
	}

	public void setAutoreAnnullamento(Persona autoreAnnullamento) {
		this.autoreAnnullamento = autoreAnnullamento;
	}

	public String getNoteAnnullamento() {
		return noteAnnullamento;
	}

	public void setNoteAnnullamento(String noteAnnullamento) {
		this.noteAnnullamento = noteAnnullamento;
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

	public Date getDataCcds() {
		return dataCcds;
	}

	public void setDataCcds(Date dataCcds) {
		this.dataCcds = dataCcds;
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

	public LearningAgreement getLearningAgreement() {
		return learningAgreement;
	}

	public void setLearningAgreement(LearningAgreement learningAgreement) {
		this.learningAgreement = learningAgreement;
	}
}

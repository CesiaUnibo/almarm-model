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

import java.io.Serializable;

import java.util.Date;

import it.unibo.almarm.model.attori.Persona;

public class CompletamentoDisponibilita implements Serializable, Comparable<CompletamentoDisponibilita> {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * nome di default del documento con la graduatoria.
	 */
	public static final String NOME_DOC_VERBALE_DEFAULT = "verbale.pdf";
	
	private Long id; // chiave primaria surrogata
	private Disponibilita disponibilita; // disponibilita a cui si riferisce questo completamento
	private Long numeroCompletamento; // numero sequenziale di completamento (unico per disponibilita)
	private String idDocVerbale; // id del documento in cui e' memorizzato il verbale
	private String nomeDocVerbale; // nome del documento di graduatoria.
	private String pathDirDocVerbale; // path relativo della directory in cui e' memorizzato il documento con il verbale
	private String sha1DocVerbale; // sha1 del documento di graduatoria
	private Date dataCompletamento; // data completamento disponibilita'
	private Persona autoreCompletamento; // persona che ha dichiarato completata la disponibilita'
	private String noteValutazione; // note inserite in fase di valutazione
	private Character modalitaValutazione; // modalita di valutazione.
	private String hashMetadati; // hash calcolato sui metadati

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Disponibilita getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(Disponibilita disponibilita) {
		this.disponibilita = disponibilita;
	}

	public Long getNumeroCompletamento() {
		return numeroCompletamento;
	}
	public void setNumeroCompletamento(Long numeroCompletamento) {
		this.numeroCompletamento = numeroCompletamento;
	}

	public String getIdDocVerbale() {
		return idDocVerbale;
	}
	public void setIdDocVerbale(String idDocVerbale) {
		this.idDocVerbale = idDocVerbale;
	}

	public String getNomeDocVerbale() {
		return nomeDocVerbale;
	}
	public void setNomeDocVerbale(String nomeDocVerbale) {
		this.nomeDocVerbale = nomeDocVerbale;
	}

	public String getPathDirDocVerbale() {
		return pathDirDocVerbale;
	}
	public void setPathDirDocVerbale(String pathDirDocVerbale) {
		this.pathDirDocVerbale = pathDirDocVerbale;
	}

	public String getSha1DocVerbale() {
		return sha1DocVerbale;
	}
	public void setSha1DocVerbale(String sha1DocVerbale) {
		this.sha1DocVerbale = sha1DocVerbale;
	}

	public Date getDataCompletamento() {
		return dataCompletamento;
	}
	public void setDataCompletamento(Date dataCompletamento) {
		this.dataCompletamento = dataCompletamento;
	}

	public Persona getAutoreCompletamento() {
		return autoreCompletamento;
	}
	public void setAutoreCompletamento(Persona autoreCompletamento) {
		this.autoreCompletamento = autoreCompletamento;
	}

	public String getNoteValutazione() {
		return noteValutazione;
	}
	public void setNoteValutazione(String noteValutazione) {
		this.noteValutazione = noteValutazione;
	}

	public Character getModalitaValutazione() {
		return modalitaValutazione;
	}
	public void setModalitaValutazione(Character modalitaValutazione) {
		this.modalitaValutazione = modalitaValutazione;
	}

	public String getHashMetadati() {
		return hashMetadati;
	}
	public void setHashMetadati(String hashMetadati) {
		this.hashMetadati = hashMetadati;
	}
	
	@Override
	public int compareTo(CompletamentoDisponibilita o) {
		if (o == null)
			throw new NullPointerException();
		if (getNumeroCompletamento()==null && o.getNumeroCompletamento()==null)
			return 0;
		if (getNumeroCompletamento() == null)
			return -1;
		if (o.getNumeroCompletamento() == null)
			return 1;
		return getNumeroCompletamento().compareTo(o.getNumeroCompletamento());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getIdDocVerbale() == null) ? 0 : getIdDocVerbale().hashCode());
		result = prime * result + ((getNomeDocVerbale() == null) ? 0 : getNomeDocVerbale().hashCode());
		result = prime * result + ((getNumeroCompletamento() == null) ? 0 : getNumeroCompletamento().hashCode());
		result = prime * result + ((getPathDirDocVerbale() == null) ? 0 : getPathDirDocVerbale().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CompletamentoDisponibilita))
			return false;
		CompletamentoDisponibilita other = (CompletamentoDisponibilita) obj;
		if (getIdDocVerbale() == null) {
			if (other.getIdDocVerbale() != null)
				return false;
		} else if (!getIdDocVerbale().equals(other.getIdDocVerbale()))
			return false;
		if (getNomeDocVerbale() == null) {
			if (other.getNomeDocVerbale() != null)
				return false;
		} else if (!getNomeDocVerbale().equals(other.getNomeDocVerbale()))
			return false;
		if (getNumeroCompletamento() == null) {
			if (other.getNumeroCompletamento() != null)
				return false;
		} else if (!getNumeroCompletamento().equals(other.getNumeroCompletamento()))
			return false;
		if (getPathDirDocVerbale() == null) {
			if (other.getPathDirDocVerbale() != null)
				return false;
		} else if (!getPathDirDocVerbale().equals(other.getPathDirDocVerbale()))
			return false;
		return true;
	}
	
}

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
package it.unibo.almarm.model.modalitapagamento;

import it.unibo.almarm.model.attori.Attore;
import it.unibo.almarm.util.Common;

import java.util.Date;

public class ModalitaDiPagamento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String intestatario;
	private String iban;
	private String swift;
	private Date dataInizio;
	private Date dataFine;
	private Character stato;
	private CausalePagamento causalePagamento;
	private TipologiaPagamento tipologiaPagamento;
	private Attore attore; // la relazione è biunivoca perchè l'inserimento viene fatto tramite una procedura quindi non dovrebbe dare problemi
	private String note;
	private String altroCC;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Character getStato() {
		return stato;
	}

	public void setStato(Character stato) {
		this.stato = stato;
	}

	public Attore getAttore() {
		return attore;
	}

	public void setAttore(Attore attore) {
		this.attore = attore;
	}

	public CausalePagamento getCausalePagamento() {
		return causalePagamento;
	}

	public void setCausalePagamento(CausalePagamento causalePagamento) {
		this.causalePagamento = causalePagamento;
	}

	public TipologiaPagamento getTipologiaPagamento() {
		return tipologiaPagamento;
	}

	public void setTipologiaPagamento(TipologiaPagamento tipologiaPagamento) {
		this.tipologiaPagamento = tipologiaPagamento;
	}
	
	public boolean isAttivo() {
		return Common.CH_A.equals(stato);
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attore == null) ? 0 : attore.hashCode());
		result = prime
				* result
				+ ((causalePagamento == null) ? 0 : causalePagamento.hashCode());
		result = prime * result
				+ ((dataFine == null) ? 0 : dataFine.hashCode());
		result = prime * result
				+ ((dataInizio == null) ? 0 : dataInizio.hashCode());
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		result = prime * result
				+ ((intestatario == null) ? 0 : intestatario.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((swift == null) ? 0 : swift.hashCode());
		result = prime
				* result
				+ ((tipologiaPagamento == null) ? 0 : tipologiaPagamento
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ModalitaDiPagamento))
			return false;
		ModalitaDiPagamento other = (ModalitaDiPagamento) obj;
		if (attore == null) {
			if (other.attore != null)
				return false;
		} else if (!attore.equals(other.attore))
			return false;
		if (causalePagamento == null) {
			if (other.causalePagamento != null)
				return false;
		} else if (!causalePagamento.equals(other.causalePagamento))
			return false;
		if (dataFine == null) {
			if (other.dataFine != null)
				return false;
		} else if (!dataFine.equals(other.dataFine))
			return false;
		if (dataInizio == null) {
			if (other.dataInizio != null)
				return false;
		} else if (!dataInizio.equals(other.dataInizio))
			return false;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		if (intestatario == null) {
			if (other.intestatario != null)
				return false;
		} else if (!intestatario.equals(other.intestatario))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (swift == null) {
			if (other.swift != null)
				return false;
		} else if (!swift.equals(other.swift))
			return false;
		if (tipologiaPagamento == null) {
			if (other.tipologiaPagamento != null)
				return false;
		} else if (!tipologiaPagamento.equals(other.tipologiaPagamento))
			return false;
		return true;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAltroCC() {
		return altroCC;
	}

	public void setAltroCC(String altroCC) {
		this.altroCC = altroCC;
	}

}

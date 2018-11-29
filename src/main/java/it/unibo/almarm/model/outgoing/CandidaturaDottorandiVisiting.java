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

import it.unibo.almarm.model.modalitapagamento.ClasseTipoEnteSovDotto;
import it.unibo.almarm.util.Common;

import java.util.Date;

public class CandidaturaDottorandiVisiting implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Candidatura candidatura;
	private Character aumentoBorsaDottoratoRichiesto;
	private Character anticipoAumentoBorsaDottoratoRichiesto;
	private Date dataInizioPrevista;
	private Date dataFinePrevista;
	private Integer numeroProtocollo;
	private Date dataProtocollo;
	private ClasseTipoEnteSovDotto classeTipoEnteSovDotto; 
	private Integer giorniPrevisti;
	private Integer giorniPagatiPrevisti;
	private Date dataInizioPagamentoPrevista;
	private Date dataFinePagamentoPrevista;
	private Date dataAutorizzazionePagamento;
	private Character flagPeriodoPagatoDiversoDaPerdiodoScambio;
	private Character flagCotutela;
	
	public CandidaturaDottorandiVisiting() {
		
	}
	
	public CandidaturaDottorandiVisiting(Candidatura candidatura) {
		this.candidatura = candidatura;
	}

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
	
	public Character getAumentoBorsaDottoratoRichiesto() {
		return aumentoBorsaDottoratoRichiesto;
	}

	public void setAumentoBorsaDottoratoRichiesto(
			Character aumentoBorsaDottoratoRichiesto) {
		this.aumentoBorsaDottoratoRichiesto = aumentoBorsaDottoratoRichiesto;
	}

	public Character getAnticipoAumentoBorsaDottoratoRichiesto() {
		return anticipoAumentoBorsaDottoratoRichiesto;
	}

	public void setAnticipoAumentoBorsaDottoratoRichiesto(
			Character anticipoAumentoBorsaDottoratoRichiesto) {
		this.anticipoAumentoBorsaDottoratoRichiesto = anticipoAumentoBorsaDottoratoRichiesto;
	}

	public Date getDataInizioPrevista() {
		return dataInizioPrevista;
	}

	public void setDataInizioPrevista(Date dataInizioPrevista) {
		this.dataInizioPrevista = dataInizioPrevista;
	}

	public Date getDataFinePrevista() {
		return dataFinePrevista;
	}

	public void setDataFinePrevista(Date dataFinePrevista) {
		this.dataFinePrevista = dataFinePrevista;
	}

	public Integer getNumeroProtocollo() {
		return numeroProtocollo;
	}

	public void setNumeroProtocollo(Integer numeroProtocollo) {
		this.numeroProtocollo = numeroProtocollo;
	}

	public Date getDataProtocollo() {
		return dataProtocollo;
	}

	public void setDataProtocollo(Date dataProtocollo) {
		this.dataProtocollo = dataProtocollo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CandidaturaDottorandiVisiting))
			return false;
		CandidaturaDottorandiVisiting other = (CandidaturaDottorandiVisiting) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public ClasseTipoEnteSovDotto getClasseTipoEnteSovDotto() {
		return classeTipoEnteSovDotto;
	}

	public void setClasseTipoEnteSovDotto(
			ClasseTipoEnteSovDotto classeTipoEnteSovDotto) {
		this.classeTipoEnteSovDotto = classeTipoEnteSovDotto;
	}

	public Integer getGiorniPrevisti() {
		return giorniPrevisti;
	}

	public void setGiorniPrevisti(Integer giorniPrevisti) {
		this.giorniPrevisti = giorniPrevisti;
	}

	public Integer getGiorniPagatiPrevisti() {
		return giorniPagatiPrevisti;
	}

	public void setGiorniPagatiPrevisti(Integer giorniPagatiPrevisti) {
		this.giorniPagatiPrevisti = giorniPagatiPrevisti;
	}

	public Date getDataInizioPagamentoPrevista() {
		return dataInizioPagamentoPrevista;
	}

	public void setDataInizioPagamentoPrevista(Date dataInizioPagamentoPrevista) {
		this.dataInizioPagamentoPrevista = dataInizioPagamentoPrevista;
	}

	public Date getDataFinePagamentoPrevista() {
		return dataFinePagamentoPrevista;
	}

	public void setDataFinePagamentoPrevista(Date dataFinePagamentoPrevista) {
		this.dataFinePagamentoPrevista = dataFinePagamentoPrevista;
	}

	public Date getDataAutorizzazionePagamento() {
		return dataAutorizzazionePagamento;
	}

	public void setDataAutorizzazionePagamento(Date dataAutorizzazionePagamento) {
		this.dataAutorizzazionePagamento = dataAutorizzazionePagamento;
	}

	public Character getFlagPeriodoPagatoDiversoDaPerdiodoScambio() {
		if (flagPeriodoPagatoDiversoDaPerdiodoScambio == null)
			return 'N';
		return flagPeriodoPagatoDiversoDaPerdiodoScambio;
	}

	public void setFlagPeriodoPagatoDiversoDaPerdiodoScambio(
			Character flagPeriodoPagatoDiversoDaPerdiodoScambio) {
		this.flagPeriodoPagatoDiversoDaPerdiodoScambio = flagPeriodoPagatoDiversoDaPerdiodoScambio;
	}
	
	public boolean isPeriodoPagatoDiversoDaPerdiodoScambio() {
		return Common.CH_S.equals(getFlagPeriodoPagatoDiversoDaPerdiodoScambio());
	}

	public Character getFlagCotutela() {
		return flagCotutela;
	}

	public void setFlagCotutela(Character flagCotutela) {
		this.flagCotutela = flagCotutela;
	}
}

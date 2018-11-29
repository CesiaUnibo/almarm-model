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

public class OutgoingDottorandiVisiting implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private StudenteOutgoing studenteOutgoing;
	private Character anticipoAumentoBorsaDottoratoRichiesto;
	private ClasseTipoEnteSovDotto classeTipoEnteSovDotto; 
	private Integer giorniPagatiPrevisti;
	private Date dataInizioPagamentoPrevista;
	private Date dataFinePagamentoPrevista;
	private Character flagPeriodoPagatoDiversoDaPerdiodoScambio;
	private Character flagCotutela;

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
	
	public Character getAnticipoAumentoBorsaDottoratoRichiesto() {
		return anticipoAumentoBorsaDottoratoRichiesto;
	}

	public void setAnticipoAumentoBorsaDottoratoRichiesto(
			Character anticipoAumentoBorsaDottoratoRichiesto) {
		this.anticipoAumentoBorsaDottoratoRichiesto = anticipoAumentoBorsaDottoratoRichiesto;
	}
	
	public boolean isAnticipoAumentoBorsaDottoratoStatoRichiesto() {
		return Common.CH_S.equals(getAnticipoAumentoBorsaDottoratoRichiesto());
	}

	public ClasseTipoEnteSovDotto getClasseTipoEnteSovDotto() {
		return classeTipoEnteSovDotto;
	}

	public void setClasseTipoEnteSovDotto(
			ClasseTipoEnteSovDotto classeTipoEnteSovDotto) {
		this.classeTipoEnteSovDotto = classeTipoEnteSovDotto;
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

	public Character getFlagPeriodoPagatoDiversoDaPerdiodoScambio() {
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

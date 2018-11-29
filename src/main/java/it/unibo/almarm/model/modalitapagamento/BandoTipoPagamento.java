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

import it.unibo.almarm.model.outgoing.Bando;
import it.unibo.almarm.util.Common;

public class BandoTipoPagamento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Bando bando;
	private TipologiaPagamento tipologiaPagamento;
	private Character flagAttivoStudente;
	private Character flagAttivoModificaStudente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Bando getBando() {
		return bando;
	}
	public void setBando(Bando bando) {
		this.bando = bando;
	}	
	public TipologiaPagamento getTipologiaPagamento() {
		return tipologiaPagamento;
	}
	public void setTipologiaPagamento(TipologiaPagamento tipologiaPagamento) {
		this.tipologiaPagamento = tipologiaPagamento;
	}
	
	public Character getFlagAttivoStudente() {
		return flagAttivoStudente;
	}
	public void setFlagAttivoStudente(Character flagAttivoStudente) {
		this.flagAttivoStudente = flagAttivoStudente;
	}
	public Character getFlagAttivoModificaStudente() {
		return flagAttivoModificaStudente;
	}
	public void setFlagAttivoModificaStudente(Character flagAttivoModificaStudente) {
		this.flagAttivoModificaStudente = flagAttivoModificaStudente;
	}
	
	public boolean isAttivoStudente() {
		return Common.CH_S.equals(flagAttivoStudente);
	}
	
	public boolean isAttivoModificaStudente() {
		return Common.CH_S.equals(flagAttivoModificaStudente);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bando == null) ? 0 : bando.hashCode());
		result = prime
				* result
				+ ((tipologiaPagamento == null) ? 0 : tipologiaPagamento.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BandoTipoPagamento))
			return false;
		BandoTipoPagamento other = (BandoTipoPagamento) obj;
		// Oggetto not mutable
		if (id != null && other.getId() != null) 
			return id.equals(other.getId());
		if (bando == null) {
			if (other.getBando() != null)
				return false;
		} else if (!bando.equals(other.getBando()))
			return false;
		if (tipologiaPagamento == null) {
			if (other.tipologiaPagamento != null)
				return false;
		} else if (!tipologiaPagamento.equals(other.tipologiaPagamento))
			return false;
		return true;
	}

}

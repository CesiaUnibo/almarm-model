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

import java.util.HashSet;
import java.util.Set;

import it.unibo.almarm.model.attori.studenti.TipoCorso;
import it.unibo.almarm.util.Common;

public class TipoCdsOfferta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final Long ID_TIPOCDSOFF_DOTTORATO = 8L;
	public static final Long ID_TIPOCDSOFF_LVO = 6L;

	private Long id;
	private String sigla;
	private String descrizione;
	private TipoCorso tipoCorso;
	private Integer durata;
	private Integer	posizione;
	private Character flagAmmettePrimoAnno; // CHG 12955
	
	private Set<TipoCdsOffertaSottoTarget> tipiCdsOffertaSottoTarget = new HashSet<TipoCdsOffertaSottoTarget>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public TipoCorso getTipoCorso() {
		return tipoCorso;
	}
	public void setTipoCorso(TipoCorso tipoCorso) {
		this.tipoCorso = tipoCorso;
	}
	public Integer getDurata() {
		return durata;
	}
	public void setDurata(Integer durata) {
		this.durata = durata;
	}
	public Integer getPosizione() {
		return posizione;
	}
	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result
				+ ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result
				+ ((tipoCorso == null) ? 0 : tipoCorso.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipoCdsOfferta))
			return false;
		TipoCdsOfferta other = (TipoCdsOfferta) obj;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (tipoCorso == null) {
			if (other.tipoCorso != null)
				return false;
		} else if (!tipoCorso.equals(other.tipoCorso))
			return false;
		return true;
	}
	
	public Character getFlagAmmettePrimoAnno() {
		return flagAmmettePrimoAnno;
	}
	public void setFlagAmmettePrimoAnno(Character flagAmmettePrimoAnno) {
		this.flagAmmettePrimoAnno = flagAmmettePrimoAnno;
	}	
	public boolean isAmmettePrimoAnno() {
		return !Common.CH_N.equals(flagAmmettePrimoAnno);
	}
	public Set<TipoCdsOffertaSottoTarget> getTipiCdsOffertaSottoTarget() {
		return tipiCdsOffertaSottoTarget;
	}
	public void setTipiCdsOffertaSottoTarget(
			Set<TipoCdsOffertaSottoTarget> tipiCdsOffertaSottoTarget) {
		this.tipiCdsOffertaSottoTarget = tipiCdsOffertaSottoTarget;
	}
	
	public boolean isDottorato() {
		return id.equals(ID_TIPOCDSOFF_DOTTORATO);
	}
}

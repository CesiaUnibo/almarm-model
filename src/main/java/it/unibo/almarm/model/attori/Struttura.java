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
package it.unibo.almarm.model.attori;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.StringUtils;


public class Struttura extends Attore implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Integer TIPO_DIPARTIMENTO = 118;
	private static final Integer TIPO_VICEPRESID = 122;
	
	private Date dataCreazione;
	private Date dataInizio;
	private Date dataFine;
	private Integer idTipoStruttura;
	//private TipoStruttura tipoStruttura;
	private Integer codicePersonale;
	//private Dipartimento dipartimentoAssociato;
	private Set<DescrizioneStruttura> descrizioniStruttura;
	
	public Date getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
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
/*	public TipoStruttura getTipoStruttura() {
		return tipoStruttura;
	}
	public void setTipoStruttura(TipoStruttura tipoStruttura) {
		this.tipoStruttura = tipoStruttura;
	}*/
	public Set<DescrizioneStruttura> getDescrizioniStruttura() {
		return descrizioniStruttura;
	}
	public void setDescrizioniStruttura(
			Set<DescrizioneStruttura> descrizioniStruttura) {
		this.descrizioniStruttura = descrizioniStruttura;
	}
	public Integer getCodicePersonale() {
		return codicePersonale;
	}
	public void setCodicePersonale(Integer codicePersonale) {
		this.codicePersonale = codicePersonale;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codicePersonale == null) ? 0 : codicePersonale.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Struttura))
			return false;
		final Struttura other = (Struttura) obj;
		if (codicePersonale == null) {
			if (other.getCodicePersonale() != null)
				return false;
		} else if (!codicePersonale.equals(other.getCodicePersonale()))
			return false;
		return true;
	}
	
	@Override
	public String getCodiceAttore() {
		
		return String.valueOf(id);
	}
	
	@Override
	public String getNomeAttore() {
		if ((descrizioniStruttura != null) && (descrizioniStruttura.size() > 0))
		{
			for (DescrizioneStruttura ds: descrizioniStruttura)
				if (ds.getDataFine() == null)
					return StringUtils.defaultIfEmpty(ds.getDescrizione(), ds.getNome());
			return descrizioniStruttura.iterator().next().getDescrizione();
		}
		return super.getNomeAttore();
	}
/*	public Dipartimento getDipartimentoAssociato() {
		return dipartimentoAssociato;
	}
	public void setDipartimentoAssociato(Dipartimento dipartimentoAssociato) {
		this.dipartimentoAssociato = dipartimentoAssociato;
	}*/

	public boolean isDipartimento() {
		return (idTipoStruttura !=null) && (TIPO_DIPARTIMENTO == idTipoStruttura.intValue());
	}
	
	public DescrizioneStruttura getDescrizioneStrutturaAttiva() {
		if ((descrizioniStruttura != null) && (descrizioniStruttura.size() > 0)) {
			for (DescrizioneStruttura ds: descrizioniStruttura)
				if (ds.getDataFine() == null || ds.getDataFine().after(new Date()))
					return ds;
		}
		return null;
	}
	public Integer getIdTipoStruttura() {
		return idTipoStruttura;
	}
	public void setIdTipoStruttura(Integer idTipoStruttura) {
		this.idTipoStruttura = idTipoStruttura;
	}
}

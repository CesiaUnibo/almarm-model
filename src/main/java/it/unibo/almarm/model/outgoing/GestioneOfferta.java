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

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import it.unibo.almarm.model.attori.Persona;

public class GestioneOfferta  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Offerta offerta;
	private String notaOffFutura;
	private String infoDocOffFutura;
	private Character flagNotaOffFutura;
	private java.util.Date dataInserimento;
	private Persona autoreInserimento;
	private Date dataAttivazione;
	private Persona autoreUltimaModifica;
	private Date dataUltimaModifica;
	// dati non persistiti
	private Long idOffertaEdit;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Offerta getOfferta() {
		return offerta;
	}
	public void setOfferta(Offerta offerta) {
		this.offerta = offerta;
	}
	public String getNotaOffFutura() {
		return notaOffFutura;
	}
	public void setNotaOffFutura(String notaOffFutura) {
		this.notaOffFutura = notaOffFutura;
	}
	public Character getFlagNotaOffFutura() {
		return flagNotaOffFutura;
	}
	public void setFlagNotaOffFutura(Character flagNotaOffFutura) {
		this.flagNotaOffFutura = flagNotaOffFutura;
	}
	public String getInfoDocOffFutura() {
		return infoDocOffFutura;
	}
	public void setInfoDocOffFutura(String infoDocOffFutura) {
		this.infoDocOffFutura = infoDocOffFutura;
	}
	public java.util.Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(java.util.Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public Persona getAutoreInserimento() {
		return autoreInserimento;
	}
	public void setAutoreInserimento(Persona autoreInserimento) {
		this.autoreInserimento = autoreInserimento;
	}
	public Date getDataAttivazione() {
		return dataAttivazione;
	}
	public void setDataAttivazione(Date dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}
	public Persona getAutoreUltimaModifica() {
		return autoreUltimaModifica;
	}
	public void setAutoreUltimaModifica(Persona autoreUltimaModifica) {
		this.autoreUltimaModifica = autoreUltimaModifica;
	}
	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}
	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}
	
	public boolean isDatiGestioneValorizzati() {
		return (StringUtils.isNotBlank(getNotaOffFutura()) ||
				    StringUtils.isNotBlank(getInfoDocOffFutura()));
	}
	
	public Long getIdOffertaEdit() {
		return idOffertaEdit;
	}
	public void setIdOffertaEdit(Long idOffertaEdit) {
		this.idOffertaEdit = idOffertaEdit;
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
		if (getClass() != obj.getClass())
			return false;
		GestioneOfferta other = (GestioneOfferta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

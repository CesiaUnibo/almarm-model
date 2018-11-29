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
package it.unibo.almarm.model.incoming;

import java.util.Comparator;
import java.util.Date;

import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.flussiscambio.UnitaMisuraDurata;
import it.unibo.almarm.util.Common;

public class IncomingProlungamento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private StudenteIncoming studenteIncoming;
	private Date dataPartenzaPrevista;
	private Long durata;
	private UnitaMisuraDurata unitaMisuraDurata;
	private Date dataRichiesta;
	private Persona autoreRichiesta;
	private Date dataApprovazione;
	private Persona autoreApprovazione;
	private Date dataRifiuto;
	private Persona autoreRifiuto;
	private String note;
	private String stato;
	
	// campi non persistiti
	private Character flagUsaDataFineAlPostoDiPeriodoPerProlungamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudenteIncoming getStudenteIncoming() {
		return studenteIncoming;
	}

	public void setStudenteIncoming(StudenteIncoming studenteIncoming) {
		this.studenteIncoming = studenteIncoming;
	}
	
	public Date getDataPartenzaPrevista() {
		return dataPartenzaPrevista;
	}

	public void setDataPartenzaPrevista(Date dataPartenzaPrevista) {
		this.dataPartenzaPrevista = dataPartenzaPrevista;
	}

	public Long getDurata() {
		return durata;
	}

	public void setDurata(Long durata) {
		this.durata = durata;
	}

	public UnitaMisuraDurata getUnitaMisuraDurata() {
		return unitaMisuraDurata;
	}

	public void setUnitaMisuraDurata(UnitaMisuraDurata unitaMisuraDurata) {
		this.unitaMisuraDurata = unitaMisuraDurata;
	}

	public Date getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public Persona getAutoreRichiesta() {
		return autoreRichiesta;
	}

	public void setAutoreRichiesta(Persona autoreRichiesta) {
		this.autoreRichiesta = autoreRichiesta;
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

	public Date getDataRifiuto() {
		return dataRifiuto;
	}

	public void setDataRifiuto(Date dataRifiuto) {
		this.dataRifiuto = dataRifiuto;
	}

	public Persona getAutoreRifiuto() {
		return autoreRifiuto;
	}

	public void setAutoreRifiuto(Persona autoreRifiuto) {
		this.autoreRifiuto = autoreRifiuto;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRichiesta == null) ? 0 : dataRichiesta.hashCode());
		result = prime * result + ((studenteIncoming == null) ? 0 : studenteIncoming.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IncomingProlungamento))
			return false;
		IncomingProlungamento other = (IncomingProlungamento) obj;
		if (dataRichiesta == null) {
			if (other.dataRichiesta != null)
				return false;
		} else if (!dataRichiesta.equals(other.dataRichiesta))
			return false;
		if (studenteIncoming == null) {
			if (other.studenteIncoming != null)
				return false;
		} else if (!studenteIncoming.equals(other.studenteIncoming))
			return false;
		return true;
	}
	
	public static class IncomingProlungamentoComparator implements Comparator<IncomingProlungamento> {

		@Override
		public int compare(IncomingProlungamento arg0, IncomingProlungamento arg1) {
			if (arg0 == null && arg1 == null)
				return 0;
			if (arg0 == null)
				return 1;
			if (arg1 == null)
				return -1;
			if (arg0.getId() == null)
				return 1;
			if (arg1.getId() == null)
				return -1;
			if (arg0.getDataRichiesta() == null)
				return 1;
			if (arg1.getDataRichiesta() == null)
				return -1;
			return arg0.getDataRichiesta().compareTo(arg1.getDataRichiesta());
		}
		
	}
	
	public Character getFlagUsaDataFineAlPostoDiPeriodoPerProlungamento() {
		if (flagUsaDataFineAlPostoDiPeriodoPerProlungamento == null) {
			if (dataPartenzaPrevista != null)
				flagUsaDataFineAlPostoDiPeriodoPerProlungamento = 'S';
			else
				flagUsaDataFineAlPostoDiPeriodoPerProlungamento = 'N';
		}
		return flagUsaDataFineAlPostoDiPeriodoPerProlungamento;
	}

	public void setFlagUsaDataFineAlPostoDiPeriodoPerProlungamento(
			Character flagUsaDataFineAlPostoDiPeriodoPerProlungamento) {
		this.flagUsaDataFineAlPostoDiPeriodoPerProlungamento = flagUsaDataFineAlPostoDiPeriodoPerProlungamento;
	}
	
	public boolean isUsaDataFineAlPostoDiPeriodoPerProlungamento() {
		return Common.CH_S.equals(getFlagUsaDataFineAlPostoDiPeriodoPerProlungamento());
	}

	public boolean isApprovato() {
		return "approvato".equals(getStato());
	}
	
	public boolean isRifiutato() {
		return "rifiutato".equals(getStato());
	}
	
	public String getLabel() {
		if (isUsaDataFineAlPostoDiPeriodoPerProlungamento())
			return "fino al " + Common.getDataFormattata(getDataPartenzaPrevista());
		return "ulteriori " + getDurata() + " " + getUnitaMisuraDurata().getUnita();
	}
}

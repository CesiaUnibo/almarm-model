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
package it.unibo.almarm.model.accordi;

import it.unibo.almarm.model.attori.Attore;

import java.io.Serializable;
import java.util.Comparator;

public class AccordoAttoreStorico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Attore attore;
	private TipoRuoloAccordo tipoRuoloAccordo;
	private Long idRuoloSpecifico; 
	private String descrizioneRuolo;  
	private Long idTitoloRichiesto;  
	private String partitaIva;
	private java.util.Date dataInizio;
	private java.util.Date dataFine;
	private java.util.Date dataInserimento;
	private boolean nuovo;
	
	// non persistiti
	private AccordoAttore accordoAttore;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Attore getAttore() {
		return attore;
	}
	public void setAttore(Attore attore) {
		this.attore = attore;
	}
	public TipoRuoloAccordo getTipoRuoloAccordo() {
		return tipoRuoloAccordo;
	}
	public void setTipoRuoloAccordo(TipoRuoloAccordo tipoRuoloAccordo) {
		this.tipoRuoloAccordo = tipoRuoloAccordo;
	}
	public Long getIdRuoloSpecifico() {
		return idRuoloSpecifico;
	}
	public void setIdRuoloSpecifico(Long idRuoloSpecifico) {
		this.idRuoloSpecifico = idRuoloSpecifico;
	}
	public String getDescrizioneRuolo() {
		return descrizioneRuolo;
	}
	public void setDescrizioneRuolo(String descrizioneRuolo) {
		this.descrizioneRuolo = descrizioneRuolo;
	}
	public Long getIdTitoloRichiesto() {
		return idTitoloRichiesto;
	}
	public void setIdTitoloRichiesto(Long idTitoloRichiesto) {
		this.idTitoloRichiesto = idTitoloRichiesto;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public java.util.Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(java.util.Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public java.util.Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(java.util.Date dataFine) {
		this.dataFine = dataFine;
	}
	public AccordoAttore getAccordoAttore() {
		return accordoAttore;
	}
	public void setAccordoAttore(AccordoAttore accordoAttore) {
		this.accordoAttore = accordoAttore;
	}
	
	public boolean isNuovo() {
		return nuovo;
	}
	public void setNuovo(boolean nuovo) {
		this.nuovo = nuovo;
	}


	public static class AccordoAttoreStoricoComparator implements Comparator<AccordoAttoreStorico>
	{
		public int compare(AccordoAttoreStorico o1, AccordoAttoreStorico o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null || o1.getDataInizio() == null)
				return 1;
			if (o2 == null || o2.getDataInizio() == null)
				return -1;
			return o1.getDataInizio().compareTo(o2.getDataInizio());
		}
	}


	public java.util.Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(java.util.Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

}

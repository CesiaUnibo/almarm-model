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

public class AccordoAttore implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Attore attore;
	private TipoRuoloAccordo tipoRuoloAccordo;
	private Long idRuoloSpecifico; 
	private String descrizioneRuolo;  
	private Long idTitoloRichiesto;  
	private String partitaIva;  
	
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
	public boolean isPersonaleBeneficiario() {
		return RuoloSpecifico.ID_RS_PERSONALE_BENEFICIARIO.equals(idRuoloSpecifico);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idRuoloSpecifico == null) ? 0 : idRuoloSpecifico.hashCode());
		result = prime
				* result
				+ ((tipoRuoloAccordo == null) ? 0 : tipoRuoloAccordo.hashCode());
		result = prime * result + ((attore == null) ? 0 : attore.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AccordoAttore))
			return false;
		AccordoAttore other = (AccordoAttore) obj;
		if (idRuoloSpecifico == null) {
			if (other.idRuoloSpecifico != null)
				return false;
		} else if (!idRuoloSpecifico.equals(other.getIdRuoloSpecifico()))
			return false;
		if (tipoRuoloAccordo == null) {
			if (other.tipoRuoloAccordo != null)
				return false;
		} else if (!tipoRuoloAccordo.equals(other.getTipoRuoloAccordo()))
			return false;
		if (attore == null) {
			if (other.attore != null)
				return false;
		} else if (!attore.equals(other.getAttore()))
			return false;
		return true;
	}
	
}

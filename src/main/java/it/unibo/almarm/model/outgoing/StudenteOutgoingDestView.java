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

import it.unibo.almarm.model.filtri.AreaGeoOrga;

public class StudenteOutgoingDestView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private AreaGeoOrga areaGeoOrga;
	private Long idNazioneAteneoAzienda;
	private String nazioneAteneoAzienda;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdNazioneAteneoAzienda() {
		return idNazioneAteneoAzienda;
	}
	public void setIdNazioneAteneoAzienda(Long idNazioneAteneoAzienda) {
		this.idNazioneAteneoAzienda = idNazioneAteneoAzienda;
	}
	public AreaGeoOrga getAreaGeoOrga() {
		return areaGeoOrga;
	}
	public void setAreaGeoOrga(AreaGeoOrga areaGeoOrga) {
		this.areaGeoOrga = areaGeoOrga;
	}
	public String getNazioneAteneoAzienda() {
		return nazioneAteneoAzienda;
	}
	public void setNazioneAteneoAzienda(String nazioneAteneoAzienda) {
		this.nazioneAteneoAzienda = nazioneAteneoAzienda;
	}
	public String getNazioneAteneoAziendaLabel() {
		return nazioneAteneoAzienda==null?"":nazioneAteneoAzienda;
	}
}

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

import java.util.Date;

import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.flussiscambio.UnitaMisuraDurata;
import it.unibo.frontieraCia.model.Rata;

public class VoceRata  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Rata rata;
	private Long numVoce;
	private String idTipoVoce;
	private Double ammVoce;
	private UnitaMisuraDurata umd;
	private Long durata;
	private Double ammxUmd;
	private Double valoreIsee;
	private Date dataIns;
	private Persona autoreIns;
	private String descrVoce;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Rata getRata() {
		return rata;
	}
	public void setRata(Rata rata) {
		this.rata = rata;
	}
	public Long getNumVoce() {
		return numVoce;
	}
	public void setNumVoce(Long numVoce) {
		this.numVoce = numVoce;
	}
	public String getIdTipoVoce() {
		return idTipoVoce;
	}
	public void setIdTipoVoce(String idTipoVoce) {
		this.idTipoVoce = idTipoVoce;
	}
	public Double getAmmVoce() {
		return ammVoce;
	}
	public void setAmmVoce(Double ammVoce) {
		this.ammVoce = ammVoce;
	}
	public UnitaMisuraDurata getUmd() {
		return umd;
	}
	public void setUmd(UnitaMisuraDurata umd) {
		this.umd = umd;
	}
	public Long getDurata() {
		return durata;
	}
	public void setDurata(Long durata) {
		this.durata = durata;
	}
	public Double getAmmxUmd() {
		return ammxUmd;
	}
	public void setAmmxUmd(Double ammxUmd) {
		this.ammxUmd = ammxUmd;
	}
	public Double getValoreIsee() {
		return valoreIsee;
	}
	public void setValoreIsee(Double valoreIsee) {
		this.valoreIsee = valoreIsee;
	}
	public Date getDataIns() {
		return dataIns;
	}
	public void setDataIns(Date dataIns) {
		this.dataIns = dataIns;
	}
	public Persona getAutoreIns() {
		return autoreIns;
	}
	public void setAutoreIns(Persona autoreIns) {
		this.autoreIns = autoreIns;
	}
	public String getDescrVoce() {
		return descrVoce;
	}
	public void setDescrVoce(String descrVoce) {
		this.descrVoce = descrVoce;
	}
}

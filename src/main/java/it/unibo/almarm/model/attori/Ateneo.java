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

import org.apache.commons.lang.StringUtils;

import it.unibo.almarm.model.esterni.TipoAteneo;
import it.unibo.almarm.model.luoghi.Localita;
import it.unibo.almarm.util.Common;


public class Ateneo extends Esterno {

	private static final long serialVersionUID = 1L;
	
	public static final Long ID_UNIBO = 687307L;

	private Character tipoProfiloGiuridico;
	private String codiceErasmus;
	private String sitoWeb;
	private TipoAteneo tipoAteneo;
	private AteneoView ateneoView;

	public Character getTipoProfiloGiuridico() {
		return tipoProfiloGiuridico;
	}

	public void setTipoProfiloGiuridico(Character tipoProfiloGiuridico) {
		this.tipoProfiloGiuridico = tipoProfiloGiuridico;
	}

	public String getCodiceErasmus() {
		return codiceErasmus;
	}

	public void setCodiceErasmus(String codiceErasmus) {
		this.codiceErasmus = codiceErasmus;
	}

	public String getSitoWeb() {
		return sitoWeb;
	}

	public void setSitoWeb(String sitoWeb) {
		this.sitoWeb = sitoWeb;
	}

	public String getSitoWebHTTP()
	{
		return Common.getIndirizzoHTTP(sitoWeb);
	}
	
	public TipoAteneo getTipoAteneo() {
		return tipoAteneo;
	}

	public void setTipoAteneo(TipoAteneo tipoAteneo) {
		this.tipoAteneo = tipoAteneo;
	}

	public Ateneo() {
	}

	public Ateneo(long id) {
		super(id);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result 
				+ ((codiceErasmus == null) ? 0 : codiceErasmus.hashCode());
		result = prime * result + super.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Ateneo))
			return false;
		final Ateneo other = (Ateneo) obj;
		if (codiceErasmus == null) { 
			if (other.getCodiceErasmus() != null)
				return false;
		} else if (!codiceErasmus.equals(other.getCodiceErasmus()))
			return false;
		
		return super.equals((Esterno)obj);
	}

	public String getLabel() {
		if (getNazionalita() != null)
			return getRagioneSociale() + " - " + getNazionalita().getNazione();
		else
			return getRagioneSociale();
	}
	
	public String getDescr() {
		return getCodiceErasmus() + " - " + getLabel();
	}

	public Ufficio getUfficio(Long idTipoUfficio) {
		if (!getUffici().isEmpty())
			for (Ufficio ufficio:getUffici())
				if (ufficio.getTipoUfficio().getId().equals(idTipoUfficio))
					return ufficio;
		return null;
	}

	//  Evita la visualizzazione della città per l'università della Californa
	// TODO: il controllo dovrebbe basarsi su altri dati
	public String getNazioneProvinciaFiltrata()
	{
		String nazioneProvincia=getNazionalita().getNazione();
		if(getSedeLegale()!= null)
			if (getNazionalita().isItalia())
			{
				if (getSedeLegale().getTerritorio()!= null)
					nazioneProvincia+= "<br />" +getSedeLegale().getTerritorio().getTerritorio();
			}
			else
			{	
				if (!isCalifornia() && (getSedeLegale().getLocalita() != null))
					nazioneProvincia+= "<br />" +getSedeLegale().getLocalita().getLocalita();
			}			
		
		return nazioneProvincia;
	}
	
	public boolean isCalifornia()	
	{
		return (new Long(686945)).equals(getId());
	}

	public String getDescrizioneCampusAteneo(){
		AttoreIndirizzo sedeLegale = this.getSedeLegale();
		if (sedeLegale != null ){
			Localita loc = sedeLegale.getLocalita();
			if (loc != null && StringUtils.isNotBlank(loc.getLocalita()))
				return  loc.getLocalita();
		}
    	return null; 
    }
	
	public boolean isEntitaConvenzionale() {
		return getTipoAteneo() != null ? getTipoAteneo().isTipoEntitaConvenzionale() : false;
	}

	public AteneoView getAteneoView() {
		return ateneoView;
	}

	public void setAteneoView(AteneoView ateneoView) {
		this.ateneoView = ateneoView;
	}
}

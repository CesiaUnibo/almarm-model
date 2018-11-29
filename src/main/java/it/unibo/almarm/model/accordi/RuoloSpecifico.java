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


import it.unibo.almarm.webapp.mvc.Lingua;

import org.regola.util.Ognl;

public class RuoloSpecifico implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	// MASCHERA PARTY
	public static final int PARTY_PERSONALE = 1;
	public static final int PARTY_PERSONE_ESTERNE = 2;
	public static final int PARTY_STRUTTURE = 4;
	public static final int PARTY_ENTITA_ESTERNE = 8;
	
	public static final Long ID_RS_PERSONALE_BENEFICIARIO = 529L;

	private Long id;
	private TipoRuoloAccordo tipoRuoloAccordo;
	private Integer minimo;
	private Integer massimo;
	private Integer mascheraParty;
	private String descrizioneRuolo;
	private int posizione;
	private Long idTipoAccordo;
	
	private String descrizioneRuoloIng;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoRuoloAccordo getTipoRuoloAccordo() {
		return tipoRuoloAccordo;
	}
	public void setTipoRuoloAccordo(TipoRuoloAccordo tipoRuoloAccordo) {
		this.tipoRuoloAccordo = tipoRuoloAccordo;
	}
	public Integer getMinimo() {
		return minimo;
	}
	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}
	public Integer getMassimo() {
		return massimo;
	}
	public void setMassimo(Integer massimo) {
		this.massimo = massimo;
	}
	public String getDescrizioneRuolo() {
		return descrizioneRuolo;
	}
	public void setDescrizioneRuolo(String descrizioneRuolo) {
		this.descrizioneRuolo = descrizioneRuolo;
	}
	public int getPosizione() {
		return posizione;
	}
	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}
	public Integer getMascheraParty() {
		return mascheraParty;
	}
	public void setMascheraParty(Integer mascheraParty) {
		this.mascheraParty = mascheraParty;
	}
	public boolean isTipoPersonale()
	{
		if ((mascheraParty != null) && ((mascheraParty & PARTY_PERSONALE) == PARTY_PERSONALE))
			return true;
		return false;
	}
	public boolean isTipoPersoneEsterne()
	{
		if ((mascheraParty != null) && ((mascheraParty & PARTY_PERSONE_ESTERNE) == PARTY_PERSONE_ESTERNE))
			return true;
		return false;
	}
	public boolean isTipoStrutture()
	{
		if ((mascheraParty != null) && ((mascheraParty & PARTY_STRUTTURE) == PARTY_STRUTTURE))
			return true;
		return false;
	}
	public boolean isTipoEntitaEsterne()
	{
		if ((mascheraParty != null) && ((mascheraParty & PARTY_ENTITA_ESTERNE) == PARTY_ENTITA_ESTERNE))
			return true;
		return false;
	}
	
	public Long getIdTipoAccordo() {
		return idTipoAccordo;
	}
	public void setIdTipoAccordo(Long idTipoAccordo) {
		this.idTipoAccordo = idTipoAccordo;
	}
	public String getDescrizioneRuoloIng() {
		return descrizioneRuoloIng;
	}
	public void setDescrizioneRuoloIng(String descrizioneRuoloIng) {
		this.descrizioneRuoloIng = descrizioneRuoloIng;
	}

	public String getLocaleDescrizioneRuolo() {
		Object propertyValue = Ognl.getValue("descrizioneRuolo"+Lingua.getSuffissoNomeCampoDiModello(), this);
		if (propertyValue != null)
		{
			String val=(String)propertyValue;
			return val;
		}
		return "";
	}
	public void setLocaleDescrizioneRuolo(String descrizioneRuolo) {
		Ognl.setValue("descrizioneRuolo"+Lingua.getSuffissoNomeCampoDiModello(),  this, descrizioneRuolo);
	}

	public boolean isRsPersonaleBeneficiario() {
	  return ID_RS_PERSONALE_BENEFICIARIO.equals(id);
	}
}

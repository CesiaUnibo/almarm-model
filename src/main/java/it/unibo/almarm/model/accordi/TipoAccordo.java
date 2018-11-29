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
import it.unibo.almarm.model.profilazione.AmbitoAccordo;

import java.util.HashSet;
import java.util.Set;

import org.regola.util.Ognl;

public class TipoAccordo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final long ID_TIROCINIO = 3L;
	public static final long ID_MOBILITA_INTERNAZIONALE = 4L;
	public static final long ID_RICERCA = 2L;

	private Long id;
	private String codiceContratto;
	private String capitoloCofi;
	private String cdr;
	private String descrizione;
	private String cdc;
	private String natura;
	private String funzioneObiettivo;
	private String macroCategoria;
	private String descrizioneIng;
	private Set<RuoloSpecifico> ruoliSpecifici = new HashSet<RuoloSpecifico>();
	private AmbitoAccordo ambito;
	
	/**
	 * 	Questo flag indica che l'accordo che ha questa tipologia
	 *  di accordo deve essere automaticamente approvato se il 
	 *  suo valore e' 'S'.
	 */
	private Character flagAutoApprova = 'N';
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodiceContratto() {
		return this.codiceContratto;
	}

	public void setCodiceContratto(String codiceContratto) {
		this.codiceContratto = codiceContratto;
	}

	public String getCapitoloCofi() {
		return this.capitoloCofi;
	}

	public void setCapitoloCofi(String capitoloCofi) {
		this.capitoloCofi = capitoloCofi;
	}

	public String getCdr() {
		return this.cdr;
	}

	public void setCdr(String cdr) {
		this.cdr = cdr;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCdc() {
		return this.cdc;
	}

	public void setCdc(String cdc) {
		this.cdc = cdc;
	}

	public String getNatura() {
		return this.natura;
	}

	public void setNatura(String natura) {
		this.natura = natura;
	}

	public String getFunzioneObiettivo() {
		return this.funzioneObiettivo;
	}

	public void setFunzioneObiettivo(String funzioneObiettivo) {
		this.funzioneObiettivo = funzioneObiettivo;
	}

	public String getMacroCategoria() {
		return this.macroCategoria;
	}

	public void setMacroCategoria(String macroCategoria) {
		this.macroCategoria = macroCategoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdr == null) ? 0 : cdr.hashCode());
		result = prime * result
				+ ((codiceContratto == null) ? 0 : codiceContratto.hashCode());
		result = prime * result
				+ ((descrizione == null) ? 0 : descrizione.hashCode());
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
		final TipoAccordo other = (TipoAccordo) obj;
		if (cdr == null) {
			if (other.cdr != null)
				return false;
		} else if (!cdr.equals(other.cdr))
			return false;
		if (codiceContratto == null) {
			if (other.codiceContratto != null)
				return false;
		} else if (!codiceContratto.equals(other.codiceContratto))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		return true;
	}
	public Set<RuoloSpecifico> getRuoliSpecifici() {
		return ruoliSpecifici;
	}
	public void setRuoliSpecifici(Set<RuoloSpecifico> ruoliSpecifici) {
		this.ruoliSpecifici = ruoliSpecifici;
	}
	public String getDescrizioneIng() {
		return descrizioneIng;
	}
	public void setDescrizioneIng(String descrizioneIng) {
		this.descrizioneIng = descrizioneIng;
	}
	public String getLocaleDescrizione() {
		Object propertyValue = Ognl.getValue("descrizione"+Lingua.getSuffissoNomeCampoDiModello(), this);
		if (propertyValue != null)
		{
			String val=(String)propertyValue;
			return val;
		}
		return "";
	}
	public void setLocaleDescrizione(String descrizione) {
		Ognl.setValue("descrizione"+Lingua.getSuffissoNomeCampoDiModello(),  this, descrizione);
	}
	public AmbitoAccordo getAmbito() {
		return ambito;
	}
	public void setAmbito(AmbitoAccordo ambito) {
		this.ambito = ambito;
	}
	
	public Character getFlagAutoApprova() {
		return flagAutoApprova;
	}
	
	public void setFlagAutoApprova(Character flagAutoApprova) {
		this.flagAutoApprova = flagAutoApprova;
	}
	
	/**
	 * Verifica se il tipo di accordo ammette l'approvazione
	 * automatica.
	 * 
	 * @return	ritorna true, se e solo se il flag auto-approva e'
	 * 			settato, false altrimenti.
	 * 
	 */
	public boolean isAutoApprova(){
		return (new Character('S')).equals(getFlagAutoApprova());
	}
	
}

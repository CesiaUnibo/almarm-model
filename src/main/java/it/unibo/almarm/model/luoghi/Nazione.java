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
package it.unibo.almarm.model.luoghi;

// Generated 18-gen-2008 12.52.20 by Hibernate Tools 3.2.0.CR1

import it.unibo.almarm.service.NazioneManager;
import it.unibo.almarm.util.Common;
import it.unibo.almarm.webapp.mvc.Lingua;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.regola.util.Ognl;

/**
 * Nazione generated by hbm2java
 */
public class Nazione implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nazione;
	private String descrizioneOrig;
	private String cittadinanza;
	private Long attivo;
	private Character flagInViaSvil;
	private Character flagComunitario;
	private String codMinisteriale;
	private String etichettaTerritorio;
	private String etichettaLocalita;
	private Character altriTerritori;
	private String codiceIso;
	private Long codNazAlma;
	private Date dataInizio;
	private Date dataFine;
	private Long attualeCodifica;
	private String nazioneIng;

	public boolean isItalia ()
    {
    	if (id != NazioneManager.ID_ITALIA)
    		return false;
    	return true;
    }
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNazione() {
		return this.nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getDescrizioneOrig() {
		return this.descrizioneOrig;
	}

	public void setDescrizioneOrig(String descrizioneOrig) {
		this.descrizioneOrig = descrizioneOrig;
	}

	public String getCittadinanza() {
		return this.cittadinanza;
	}

	public void setCittadinanza(String cittadinanza) {
		this.cittadinanza = cittadinanza;
	}

	public Long getAttivo() {
		return this.attivo;
	}

	public void setAttivo(Long attivo) {
		this.attivo = attivo;
	}

	public Character getFlagInViaSvil() {
		return this.flagInViaSvil;
	}

	public void setFlagInViaSvil(Character flagInViaSvil) {
		this.flagInViaSvil = flagInViaSvil;
	}

	public Character getFlagComunitario() {
		return this.flagComunitario;
	}

	public void setFlagComunitario(Character flagComunitario) {
		this.flagComunitario = flagComunitario;
	}

	public String getCodMinisteriale() {
		return this.codMinisteriale;
	}

	public void setCodMinisteriale(String codMinisteriale) {
		this.codMinisteriale = codMinisteriale;
	}

	public String getEtichettaTerritorio() {
		return this.etichettaTerritorio;
	}

	public void setEtichettaTerritorio(String etichettaTerritorio) {
		this.etichettaTerritorio = etichettaTerritorio;
	}

	public String getEtichettaLocalita() {
		return this.etichettaLocalita;
	}

	public void setEtichettaLocalita(String etichettaLocalita) {
		this.etichettaLocalita = etichettaLocalita;
	}

	public Character getAltriTerritori() {
		return this.altriTerritori;
	}

	public void setAltriTerritori(Character altriTerritori) {
		this.altriTerritori = altriTerritori;
	}

	public String getCodiceIso() {
		return this.codiceIso;
	}

	public void setCodiceIso(String codiceIso) {
		this.codiceIso = codiceIso;
	}

	public Long getCodNazAlma() {
		return this.codNazAlma;
	}

	public void setCodNazAlma(Long codNazAlma) {
		this.codNazAlma = codNazAlma;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Long getAttualeCodifica() {
		return this.attualeCodifica;
	}

	public void setAttualeCodifica(Long attualeCodifica) {
		this.attualeCodifica = attualeCodifica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codiceIso == null) ? 0 : codiceIso.hashCode());
		result = prime * result + ((nazione == null) ? 0 : nazione.hashCode());
		result = prime * result + ((dataInizio == null) ? 0 : dataInizio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Nazione))
			return false;
		final Nazione other = (Nazione) obj;
		if (codiceIso == null) {
			if (other.getCodiceIso() != null)
				return false;
		} else if (!codiceIso.equals(other.getCodiceIso()))
			return false;
		if (nazione == null) {
			if (other.getNazione() != null)
				return false;
		} else if (!nazione.equals(other.getNazione()))
			return false;
		if (getDataInizio() == null) {
			if (other.getDataInizio() != null)
				return false;
		} else if (!dataInizio.equals(other.getDataInizio()))
			return false;
		return true;
	}

	public boolean getIsItalia ()
	{
		return isItalia();
	}

	public String getNazioneIng() {
		return nazioneIng;
	}

	public void setNazioneIng(String nazioneIng) {
		this.nazioneIng = nazioneIng;
	}
	
	public String getLocaleNazione() {
		Object propertyValue = Ognl.getValue("nazione"+Lingua.getSuffissoNomeCampoDiModello(), this);
		if (propertyValue != null)
		{
			String val=(String)propertyValue;
			return val;
		}
		return "";
	}

	public String getNazioneIngUlabel() {
		return nazioneIng != null ? StringUtils.upperCase((nazioneIng)) : "";
	}
	
	public String getNazioneValiditaLabel() {
		boolean ita = StringUtils.isBlank(Lingua.getSuffissoNomeCampoDiModello());
		String dal = ita ? "dal " : "from ";
		String al = ita ? " al " : " to ";
		String dataInizio = dal + Common.getDataFormattata(this.dataInizio);
		if ("01/01/1900".equals(Common.getDataFormattata(this.dataInizio)) || "01/01/1965".equals(Common.getDataFormattata(this.dataInizio)))
			dataInizio = "";
		return getLocaleNazione() + " " + dataInizio + (dataFine != null ? al + Common.getDataFormattata(dataFine) : "");
	}
}
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
package it.unibo.almarm.model.flussiscambio;
import java.util.Comparator;

import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.util.Common;

public class EsecuzioneAccordoAllegato implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String TIPO_ISHEET_PUBBLICO="ISHEET_PUBBLICO";
	public static final String TIPO_ISHEET_INTERNO="ISHEET_INTERNO";

	private Long id;
	private Integer posizione;
	private String tipoAllegato;
	private String idAllegato;
	private String nomeAllegato;
	private String descrizione;
	private Character flagVisibileAStudente;
	private java.util.Date dataInserimento;
	private Persona autoreInserimento;
	private Character flagRimosso;
	private java.util.Date dataRimozione;
	private Persona autoreRimozione;
	
	// Non persistiti
	private boolean nuovoAllegato;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getPosizione() {
		return posizione;
	}

	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}

	public String getTipoAllegato() {
		return tipoAllegato;
	}

	public void setTipoAllegato(String tipoAllegato) {
		this.tipoAllegato = tipoAllegato;
	}

	public String getIdAllegato() {
		return idAllegato;
	}

	public void setIdAllegato(String idAllegato) {
		this.idAllegato = idAllegato;
	}

	public String getNomeAllegato() {
		return nomeAllegato;
	}

	public void setNomeAllegato(String nomeAllegato) {
		this.nomeAllegato = nomeAllegato;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public java.util.Date getDataInserimento() {
		return dataInserimento;
	}

	public Character getFlagVisibileAStudente() {
		if (flagVisibileAStudente == null)
			return 'N';
		return flagVisibileAStudente;
	}

	public void setFlagVisibileAStudente(Character flagVisibileAStudente) {
		this.flagVisibileAStudente = flagVisibileAStudente;
	}
	
	public boolean isVisibileAStudente() {
		return Common.CH_S.equals(getFlagVisibileAStudente());
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

	public Character getFlagRimosso() {
		return flagRimosso;
	}

	public void setFlagRimosso(Character flagRimosso) {
		this.flagRimosso = flagRimosso;
	}

	public boolean isRimosso(){
		return Common.CH_S.equals(flagRimosso) ;	
	}
	public java.util.Date getDataRimozione() {
		return dataRimozione;
	}

	public void setDataRimozione(java.util.Date dataRimozione) {
		this.dataRimozione = dataRimozione;
	}

	public Persona getAutoreRimozione() {
		return autoreRimozione;
	}

	public void setAutoreRimozione(Persona autoreRimozione) {
		this.autoreRimozione = autoreRimozione;
	}
	
	
	public boolean isNuovoAllegato() {
		return nuovoAllegato;
	}

	public void setNuovoAllegato(boolean nuovoAllegato) {
		this.nuovoAllegato = nuovoAllegato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idAllegato == null) ? 0 : idAllegato.hashCode());
		result = prime * result
				+ ((nomeAllegato == null) ? 0 : nomeAllegato.hashCode());
		return result;
	}

	public boolean isTipoIsheetInterno(){
		return EsecuzioneAccordoAllegato.TIPO_ISHEET_INTERNO.equals(tipoAllegato);
	}
	public boolean isTipoIsheetPubblico(){
		return EsecuzioneAccordoAllegato.TIPO_ISHEET_PUBBLICO.equals(tipoAllegato);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EsecuzioneAccordoAllegato))
			return false;
		EsecuzioneAccordoAllegato other = (EsecuzioneAccordoAllegato) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else  {	
			return id.equals(other.getId());
		}
		if (idAllegato == null) {
			if (other.getIdAllegato() != null)
				return false;
		} else if (!idAllegato.equals(other.getIdAllegato()))
			return false;
		if (nomeAllegato == null) {
			if (other.nomeAllegato != null)
				return false;
		} else if (!nomeAllegato.equals(other.nomeAllegato))
			return false;
		return true;
	}

	// ordine naturale inverso
	public static class EsecuzioneAccordoAllegatoComparatorPosizione implements Comparator<EsecuzioneAccordoAllegato>
	{
		public int compare(EsecuzioneAccordoAllegato o1, EsecuzioneAccordoAllegato o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null)
				return 1;
			if (o2 == null)
				return -1;

			if (o1.getPosizione() == null && o2.getPosizione() == null)
				return 0;
			if (o1.getPosizione() == null)
				return 1;
			if (o2.getPosizione() == null)
				return -1;

			return (-1 * o1.getPosizione().compareTo(o2.getPosizione()));
		}
	}

}

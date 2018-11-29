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

import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.esterni.MTOrganisationType;
import it.unibo.almarm.model.esterni.RangeNumeroDipendenti;
import it.unibo.almarm.model.esterni.TipoEntitaEsterna;
import it.unibo.almarm.model.luoghi.MTRegion;
import it.unibo.almarm.model.luoghi.Nazione;

import java.util.HashSet;
import java.util.Set;

public class AziendaPlacement implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String denominazioneAzienda;
	private String identificativoNazionale;
	private String descrizioneAttivitaAzienda;
	private TipoEntitaEsterna tipoAzienda;
	private Set<AziendaSettore> aziendaSettori = new HashSet<AziendaSettore>();
	private Set<AziendaSettoreNace> aziendaSettoriNace = new HashSet<AziendaSettoreNace>();
	private String nomeRappresentanteLegaleAzienda;
	private String cognomeRappresentanteLegaleAzienda;
	private Nazione nazionalitaAzienda;
	private String sedeLegaleAzienda;
	private String telefonoAzienda;
	private String faxAzienda;
	private String emailAzienda;
	private String sitoWebAzienda;
	private String noteAzienda;
	private RangeNumeroDipendenti rangeNumeroDipendenti;
	private String cittaSedeLegaleAzienda;
	private String capSedeLegaleAzienda;
	private Character flagMenoDi250Impiegati;
	private Integer picNumber;
	private MTOrganisationType organisationType;
	private Character flagPublicBody;
	private Character flagNonProfit;
	private MTRegion region;
	private Ateneo ateneo;
	private String erasmusCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominazioneAzienda() {
		return denominazioneAzienda;
	}

	public void setDenominazioneAzienda(String denominazioneAzienda) {
		this.denominazioneAzienda = denominazioneAzienda;
	}

	public String getIdentificativoNazionale() {
		return identificativoNazionale;
	}

	public void setIdentificativoNazionale(String identificativoNazionale) {
		this.identificativoNazionale = identificativoNazionale;
	}

	public String getDescrizioneAttivitaAzienda() {
		return descrizioneAttivitaAzienda;
	}

	public void setDescrizioneAttivitaAzienda(String descrizioneAttivitaAzienda) {
		this.descrizioneAttivitaAzienda = descrizioneAttivitaAzienda;
	}

	public TipoEntitaEsterna getTipoAzienda() {
		return tipoAzienda;
	}

	public void setTipoAzienda(TipoEntitaEsterna tipoAzienda) {
		this.tipoAzienda = tipoAzienda;
	}

	public Set<AziendaSettore> getAziendaSettori() {
		return aziendaSettori;
	}

	public void setAziendaSettori(Set<AziendaSettore> aziendaSettori) {
		this.aziendaSettori = aziendaSettori;
	}

	public String getNomeRappresentanteLegaleAzienda() {
		return nomeRappresentanteLegaleAzienda;
	}

	public void setNomeRappresentanteLegaleAzienda(
			String nomeRappresentanteLegaleAzienda) {
		this.nomeRappresentanteLegaleAzienda = nomeRappresentanteLegaleAzienda;
	}

	public String getCognomeRappresentanteLegaleAzienda() {
		return cognomeRappresentanteLegaleAzienda;
	}

	public void setCognomeRappresentanteLegaleAzienda(
			String cognomeRappresentanteLegaleAzienda) {
		this.cognomeRappresentanteLegaleAzienda = cognomeRappresentanteLegaleAzienda;
	}

	public Nazione getNazionalitaAzienda() {
		return nazionalitaAzienda;
	}

	public void setNazionalitaAzienda(Nazione nazionalitaAzienda) {
		this.nazionalitaAzienda = nazionalitaAzienda;
	}

	public String getSedeLegaleAzienda() {
		return sedeLegaleAzienda;
	}

	public void setSedeLegaleAzienda(String sedeLegaleAzienda) {
		this.sedeLegaleAzienda = sedeLegaleAzienda;
	}

	public String getTelefonoAzienda() {
		return telefonoAzienda;
	}

	public void setTelefonoAzienda(String telefonoAzienda) {
		this.telefonoAzienda = telefonoAzienda;
	}

	public String getFaxAzienda() {
		return faxAzienda;
	}

	public void setFaxAzienda(String faxAzienda) {
		this.faxAzienda = faxAzienda;
	}

	public String getEmailAzienda() {
		return emailAzienda;
	}

	public void setEmailAzienda(String emailAzienda) {
		this.emailAzienda = emailAzienda;
	}

	public String getSitoWebAzienda() {
		return sitoWebAzienda;
	}

	public void setSitoWebAzienda(String sitoWebAzienda) {
		this.sitoWebAzienda = sitoWebAzienda;
	}

	public String getNoteAzienda() {
		return noteAzienda;
	}

	public void setNoteAzienda(String noteAzienda) {
		this.noteAzienda = noteAzienda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AziendaPlacement))
			return false;
		AziendaPlacement other = (AziendaPlacement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public RangeNumeroDipendenti getRangeNumeroDipendenti() {
		return rangeNumeroDipendenti;
	}

	public void setRangeNumeroDipendenti(RangeNumeroDipendenti rangeNumeroDipendenti) {
		this.rangeNumeroDipendenti = rangeNumeroDipendenti;
	}

	public Set<AziendaSettoreNace> getAziendaSettoriNace() {
		return aziendaSettoriNace;
	}

	public void setAziendaSettoriNace(Set<AziendaSettoreNace> aziendaSettoriNace) {
		this.aziendaSettoriNace = aziendaSettoriNace;
	}

	public String getCittaSedeLegaleAzienda() {
		return cittaSedeLegaleAzienda;
	}

	public void setCittaSedeLegaleAzienda(String cittaSedeLegaleAzienda) {
		this.cittaSedeLegaleAzienda = cittaSedeLegaleAzienda;
	}

	public String getCapSedeLegaleAzienda() {
		return capSedeLegaleAzienda;
	}

	public void setCapSedeLegaleAzienda(String capSedeLegaleAzienda) {
		this.capSedeLegaleAzienda = capSedeLegaleAzienda;
	}

	public Character getFlagMenoDi250Impiegati() {
		return flagMenoDi250Impiegati;
	}

	public void setFlagMenoDi250Impiegati(Character flagMenoDi250Impiegati) {
		this.flagMenoDi250Impiegati = flagMenoDi250Impiegati;
	}

	public Integer getPicNumber() {
		return picNumber;
	}

	public void setPicNumber(Integer picNumber) {
		this.picNumber = picNumber;
	}

	public MTOrganisationType getOrganisationType() {
		return organisationType;
	}

	public void setOrganisationType(MTOrganisationType organisationType) {
		this.organisationType = organisationType;
	}

	public Character getFlagPublicBody() {
		return flagPublicBody;
	}

	public void setFlagPublicBody(Character flagPublicBody) {
		this.flagPublicBody = flagPublicBody;
	}

	public Character getFlagNonProfit() {
		return flagNonProfit;
	}

	public void setFlagNonProfit(Character flagNonProfit) {
		this.flagNonProfit = flagNonProfit;
	}

	public MTRegion getRegion() {
		return region;
	}

	public void setRegion(MTRegion region) {
		this.region = region;
	}

	public Ateneo getAteneo() {
		return ateneo;
	}

	public void setAteneo(Ateneo ateneo) {
		this.ateneo = ateneo;
	}

	public String getErasmusCode() {
		return erasmusCode;
	}

	public void setErasmusCode(String erasmusCode) {
		this.erasmusCode = erasmusCode;
	}
}

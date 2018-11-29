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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.unibo.almarm.model.accordi.AccordoOperativo;
import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.model.attori.Campus;
import it.unibo.almarm.model.attori.Facolta;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.util.Common;

public class PropostaAccordo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private AccordoOperativo accordoOperativoOrig;
	private Long idAccordoOperativoDest;
	private String stato;
	private Date dataCreazione;
	private Persona autoreCreazione;
	private Character flagCreazioneDaProfiloPersonale;
	private Date dataApprovazione;
	private Persona autoreApprovazione;
	private Character esitoApprovazione;
	private Character flagAutoApprovazione;
	private List<it.unibo.almarm.model.flussiscambio.PropostaScambio> propostaScambi=new ArrayList<it.unibo.almarm.model.flussiscambio.PropostaScambio>();
	private Long idEsecuzioneAccordoOrig;
	
	// Campi non persistiti
	private Date dataInizio;
	private Date dataFine;
	private Facolta facoltaDefault;
	private Campus campusDefault;
	private SottoProgramma sottoProgDefaultStudenti;
	private SottoProgramma sottoProgDefaultDocenti;
	private TipoAttivita tipoAttivitaDefaultStudenti;
	private TipoAttivita tipoAttivitaDefaultDocenti;
	private UnitaMisuraDurata unitaMisuraDurataDefaultStudenti;
	private UnitaMisuraDurata unitaMisuraDurataDefaultDocenti;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AccordoOperativo getAccordoOperativoOrig() {
		return accordoOperativoOrig;
	}
	public void setAccordoOperativoOrig(AccordoOperativo accordoOperativoOrig) {
		this.accordoOperativoOrig = accordoOperativoOrig;
	}
	public Long getIdAccordoOperativoDest() {
		return idAccordoOperativoDest;
	}
	public void setIdAccordoOperativoDest(Long idAccordoOperativoDest) {
		this.idAccordoOperativoDest = idAccordoOperativoDest;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public Date getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public Persona getAutoreCreazione() {
		return autoreCreazione;
	}
	public void setAutoreCreazione(Persona autoreCreazione) {
		this.autoreCreazione = autoreCreazione;
	}
	public Character getFlagCreazioneDaProfiloPersonale() {
		return flagCreazioneDaProfiloPersonale;
	}
	public void setFlagCreazioneDaProfiloPersonale(
			Character flagCreazioneDaProfiloPersonale) {
		this.flagCreazioneDaProfiloPersonale = flagCreazioneDaProfiloPersonale;
	}
	public void setCreazioneDaProfiloPersonale(boolean creazioneDaProfiloPersonale) {
		this.flagCreazioneDaProfiloPersonale = creazioneDaProfiloPersonale ? Common.CH_S : Common.CH_N;
	}
	public Date getDataApprovazione() {
		return dataApprovazione;
	}
	public void setDataApprovazione(Date dataApprovazione) {
		this.dataApprovazione = dataApprovazione;
	}
	public Persona getAutoreApprovazione() {
		return autoreApprovazione;
	}
	public void setAutoreApprovazione(Persona autoreApprovazione) {
		this.autoreApprovazione = autoreApprovazione;
	}
	public Character getEsitoApprovazione() {
		return esitoApprovazione;
	}
	public void setEsitoApprovazione(Character esitoApprovazione) {
		this.esitoApprovazione = esitoApprovazione;
	}
	public Character getFlagAutoApprovazione() {
		return flagAutoApprovazione;
	}
	public void setFlagAutoApprovazione(Character flagAutoApprovazione) {
		this.flagAutoApprovazione = flagAutoApprovazione;
	}
	public Long getIdEsecuzioneAccordoOrig() {
		return idEsecuzioneAccordoOrig;
	}
	public void setIdEsecuzioneAccordoOrig(Long idEsecuzioneAccordoOrig) {
		this.idEsecuzioneAccordoOrig = idEsecuzioneAccordoOrig;
	}
	public List<it.unibo.almarm.model.flussiscambio.PropostaScambio> getPropostaScambi() {
		return propostaScambi;
	}
	public void setPropostaScambi(
			List<it.unibo.almarm.model.flussiscambio.PropostaScambio> propostaScambi) {
		this.propostaScambi = propostaScambi;
	}
	
	public void removePropostaScambioById(Long id) {
		if (getPropostaScambi() == null  || getPropostaScambi().isEmpty())
			return;
		boolean trovato = false; 
		int ind = 0;	
		for (PropostaScambio p : getPropostaScambi()) {
			if (p.getId().equals(id)) {
				trovato = true;
				break;
			}
			ind ++;
		}		
		if (trovato)
			getPropostaScambi().remove(ind);
	}
	
	public PropostaScambio getPropostaScambio (Long id) {
		if (getPropostaScambi () == null  || getPropostaScambi().isEmpty())
			return null;
		for (PropostaScambio p : getPropostaScambi())
			if (p.getId().equals(id)) 
				return p; 
		return null;
	}
	
	// CAMPI NON PERSISTITI
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Facolta getFacoltaDefault() {
		return facoltaDefault;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public void setFacoltaDefault(Facolta facoltaDefault) {
		this.facoltaDefault = facoltaDefault;
	}
	public Campus getCampusDefault() {
		return campusDefault;
	}
	public void setCampusDefault(Campus campusDefault) {
		this.campusDefault = campusDefault;
	}
	public SottoProgramma getSottoProgDefaultStudenti() {
		return sottoProgDefaultStudenti;
	}
	public void setSottoProgDefaultStudenti(SottoProgramma sottoProgDefaultStudenti) {
		this.sottoProgDefaultStudenti = sottoProgDefaultStudenti;
	}
	public SottoProgramma getSottoProgDefaultDocenti() {
		return sottoProgDefaultDocenti;
	}
	public void setSottoProgDefaultDocenti(SottoProgramma sottoProgDefaultDocenti) {
		this.sottoProgDefaultDocenti = sottoProgDefaultDocenti;
	}
	public TipoAttivita getTipoAttivitaDefaultStudenti() {
		return tipoAttivitaDefaultStudenti;
	}
	public void setTipoAttivitaDefaultStudenti(
			TipoAttivita tipoAttivitaDefaultStudenti) {
		this.tipoAttivitaDefaultStudenti = tipoAttivitaDefaultStudenti;
	}
	public TipoAttivita getTipoAttivitaDefaultDocenti() {
		return tipoAttivitaDefaultDocenti;
	}
	public void setTipoAttivitaDefaultDocenti(
			TipoAttivita tipoAttivitaDefaultDocenti) {
		this.tipoAttivitaDefaultDocenti = tipoAttivitaDefaultDocenti;
	}
	public UnitaMisuraDurata getUnitaMisuraDurataDefaultStudenti() {
		return unitaMisuraDurataDefaultStudenti;
	}
	public void setUnitaMisuraDurataDefaultStudenti(
			UnitaMisuraDurata unitaMisuraDurataDefaultStudenti) {
		this.unitaMisuraDurataDefaultStudenti = unitaMisuraDurataDefaultStudenti;
	}
	public UnitaMisuraDurata getUnitaMisuraDurataDefaultDocenti() {
		return unitaMisuraDurataDefaultDocenti;
	}
	public void setUnitaMisuraDurataDefaultDocenti(
			UnitaMisuraDurata unitaMisuraDurataDefaultDocenti) {
		this.unitaMisuraDurataDefaultDocenti = unitaMisuraDurataDefaultDocenti;
	}
}

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

import java.util.Date;

import it.unibo.almarm.model.attori.Facolta;
import it.unibo.almarm.model.attori.Scuola;
import it.unibo.almarm.model.attori.studenti.Carriera;
import it.unibo.almarm.model.attori.studenti.StatoCarriera;
import it.unibo.almarm.model.attori.studenti.TipoCorso;

public class CandidaturaInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	/* private Candidatura candidatura; */
	private Character flagIscrizioneAACorrente;
	private Float mediaAritmetica;
	private Float mediaPonderata;
	private Float mediaNormalizzata;
	private Integer numeroCrediti;
	private Integer annoCorso;
	private Integer annoImmatricolazione;
	private TipoCorso tipoCorso;
	private Integer durata;
	private String sessioneLaurea;
	private String tipoCorsoErgo;
	private Facolta facolta;
	private Date dataUltimoAggiornamento;
	private Character flagPrimoAnnoMagistrale;
	private Long pincode;
	private Integer numeroCarriera; 
	private String votoLaurea;
	private StatoCarriera statoCarriera;
	private Carriera carriera;
	private Scuola scuola;
	private String baseVotoLaurea;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
/*
	public Candidatura getCandidatura() {
		return candidatura;
	}

	public void setCandidatura(Candidatura candidatura) {
		this.candidatura = candidatura;
	}
*/
	public Character getFlagIscrizioneAACorrente() {
		return flagIscrizioneAACorrente;
	}

	public void setFlagIscrizioneAACorrente(Character flagIscrizioneAACorrente) {
		this.flagIscrizioneAACorrente = flagIscrizioneAACorrente;
	}

	public Float getMediaAritmetica() {
		return mediaAritmetica;
	}

	public void setMediaAritmetica(Float mediaAritmetica) {
		this.mediaAritmetica = mediaAritmetica;
	}

	public Float getMediaPonderata() {
		return mediaPonderata;
	}

	public void setMediaPonderata(Float mediaPonderata) {
		this.mediaPonderata = mediaPonderata;
	}

	public Float getMediaNormalizzata() {
		return mediaNormalizzata;
	}

	public void setMediaNormalizzata(Float mediaNormalizzata) {
		this.mediaNormalizzata = mediaNormalizzata;
	}

	public Integer getNumeroCrediti() {
		return numeroCrediti;
	}

	public void setNumeroCrediti(Integer numeroCrediti) {
		this.numeroCrediti = numeroCrediti;
	}

	public Integer getAnnoCorso() {
		return annoCorso;
	}

	public void setAnnoCorso(Integer annoCorso) {
		this.annoCorso = annoCorso;
	}

	public Integer getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}

	public void setAnnoImmatricolazione(Integer annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}

	public TipoCorso getTipoCorso() {
		return tipoCorso;
	}

	public void setTipoCorso(TipoCorso tipoCorso) {
		this.tipoCorso = tipoCorso;
	}

	public Integer getDurata() {
		return durata;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	}

	public String getSessioneLaurea() {
		return sessioneLaurea;
	}

	public void setSessioneLaurea(String sessioneLaurea) {
		this.sessioneLaurea = sessioneLaurea;
	}

	public String getTipoCorsoErgo() {
		return tipoCorsoErgo;
	}

	public void setTipoCorsoErgo(String tipoCorsoErgo) {
		this.tipoCorsoErgo = tipoCorsoErgo;
	}

	public Facolta getFacolta() {
		return facolta;
	}

	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}

	public Date getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}

	public void setDataUltimoAggiornamento(Date dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}

	public Character getFlagPrimoAnnoMagistrale() {
		return flagPrimoAnnoMagistrale;
	}

	public void setFlagPrimoAnnoMagistrale(Character flagPrimoAnnoMagistrale) {
		this.flagPrimoAnnoMagistrale = flagPrimoAnnoMagistrale;
	}

	// 2012-05-07
	
	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	
	public Integer getNumeroCarriera() {
		return numeroCarriera;
	}

	public void setNumeroCarriera(Integer numeroCarriera) {
		this.numeroCarriera = numeroCarriera;
	}

	public String getVotoLaurea() {
		return votoLaurea;
	}

	public void setVotoLaurea(String votoLaurea) {
		this.votoLaurea = votoLaurea;
	}

	public StatoCarriera getStatoCarriera() {
		return statoCarriera;
	}

	public void setStatoCarriera(StatoCarriera statoCarriera) {
		this.statoCarriera = statoCarriera;
	}
	public boolean isStatoCarrieraAttivo() {
		return (getStatoCarriera()!=null && getStatoCarriera().isAttiva());
	}

	public Carriera getCarriera() {
		return carriera;
	}

	public void setCarriera(Carriera carriera) {
		this.carriera = carriera;
	}

	public Scuola getScuola() {
		return scuola;
	}

	public void setScuola(Scuola scuola) {
		this.scuola = scuola;
	}

	public String getBaseVotoLaurea() {
		return baseVotoLaurea;
	}

	public void setBaseVotoLaurea(String baseVotoLaurea) {
		this.baseVotoLaurea = baseVotoLaurea;
	}
}

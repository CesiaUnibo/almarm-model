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
import java.util.HashSet;
import java.util.Set;

import it.unibo.almarm.model.accordi.AccordoOperativo;
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.lingue.Lingua;

public class OffertaInDisponibilitaView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long idOfferta;
	private Long idBando;
	private Ateneo ateneo;
	private String bandoLabel;
	private String sottoProgrammaLabel;
	private AccordoOperativo accordoOperativo;
	private Integer postiOfferti;
	private String nazione;
	private String ragioneSociale;
	private String lingue;
	private Lingua linguaPrimaria;
	private Lingua linguaSecondaria;
	private Date dataInizio;
	private Date dataFine;
	private Character flagSospeso;
	private Date dataInizioPubblicazione;
	private Date dataFinePubblicazione;
	private String areaDisciplinareLbl;
	private Long idAreaDisciplinare;
	private Character flagL;
	private Character flagLS;
	private Character flagLM;
	private Character flagLS_CU;
	private Character flagLM_CU;
	private Character flagLVO;
	private Character flagSP;
	private Character flagDOTT;
	private Date dataInizioPubblicazioneOpen;
	private Date dataFinePubblicazioneOpen;
	private String descrizioneDisponibilita;
	private TirocinioErasmusPlacement tirocinioErasmusPlacement;
	private Character flagPredefinita;
	
	private Set<RegolaOfferta> regole = new HashSet<RegolaOfferta>();
	private Set<OffertaScuolaVicepresidenzaView> offertaScuoleVicepresidenze = new HashSet<OffertaScuolaVicepresidenzaView>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(Long idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getBandoLabel() {
		return bandoLabel;
	}

	public void setBandoLabel(String bandoLabel) {
		this.bandoLabel = bandoLabel;
	}

	public String getSottoProgrammaLabel() {
		return sottoProgrammaLabel;
	}

	public void setSottoProgrammaLabel(String sottoProgrammaLabel) {
		this.sottoProgrammaLabel = sottoProgrammaLabel;
	}
	
	public Long getIdBando() {
		return idBando;
	}

	public void setIdBando(Long idBando) {
		this.idBando = idBando;
	}

	public Ateneo getAteneo() {
		return ateneo;
	}

	public void setAteneo(Ateneo ateneo) {
		this.ateneo = ateneo;
	}

	public String getAteneoLabel() {
		if (ateneo == null)
			return "";
		return ateneo.getCodiceErasmus() + " - " + ateneo.getRagioneSociale() + "<br/>" + ateneo.getProvincia();
	}
	
	public String getAteneoCodiceErasmusLabel() {
		if (ateneo == null)
			return "";
		return ateneo.getCodiceErasmus() + " - " + ateneo.getRagioneSociale() + "<br/>" + ateneo.getProvincia();
	}
	
	public String getNazioneAteneo() {
		if (ateneo == null || ateneo.getNazionalita() == null)
			return "";
		return ateneo.getNazionalita().getDescrizioneOrig();
	}

	public AccordoOperativo getAccordoOperativo() {
		return accordoOperativo;
	}

	public void setAccordoOperativo(AccordoOperativo accordoOperativo) {
		this.accordoOperativo = accordoOperativo;
	}

	public Integer getPostiOfferti() {
		return postiOfferti;
	}

	public void setPostiOfferti(Integer postiOfferti) {
		this.postiOfferti = postiOfferti;
	}

	public Set<RegolaOfferta> getRegole() {
		return regole;
	}

	public void setRegole(Set<RegolaOfferta> regole) {
		this.regole = regole;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getLingue() {
		return lingue;
	}

	public void setLingue(String lingue) {
		this.lingue = lingue;
	}

	public Lingua getLinguaPrimaria() {
		return linguaPrimaria;
	}

	public void setLinguaPrimaria(Lingua linguaPrimaria) {
		this.linguaPrimaria = linguaPrimaria;
	}

	public Lingua getLinguaSecondaria() {
		return linguaSecondaria;
	}

	public void setLinguaSecondaria(Lingua linguaSecondaria) {
		this.linguaSecondaria = linguaSecondaria;
	}
	
	public String getLingueLbl() {
		String ret = "";
		if (linguaPrimaria != null)
			ret = linguaPrimaria.getNome();
		if (linguaSecondaria != null)
			ret += (linguaPrimaria != null ? "<br/>" : "") + linguaSecondaria.getNome();
		return ret;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Character getFlagSospeso() {
		return flagSospeso;
	}

	public void setFlagSospeso(Character flagSospeso) {
		this.flagSospeso = flagSospeso;
	}
	
	public String getReferenteInternoLabel() {
		if (getAccordoOperativo() != null && getAccordoOperativo().getReferenteInterno() != null)
			return getAccordoOperativo().getReferenteInterno().getNomeCognome();
		return "";
	}

	public Date getDataInizioPubblicazione() {
		return dataInizioPubblicazione;
	}

	public void setDataInizioPubblicazione(Date dataInizioPubblicazione) {
		this.dataInizioPubblicazione = dataInizioPubblicazione;
	}

	public Date getDataFinePubblicazione() {
		return dataFinePubblicazione;
	}

	public void setDataFinePubblicazione(Date dataFinePubblicazione) {
		this.dataFinePubblicazione = dataFinePubblicazione;
	}

	public String getAreaDisciplinareLbl() {
		return areaDisciplinareLbl;
	}

	public void setAreaDisciplinareLbl(String areaDisciplinareLbl) {
		this.areaDisciplinareLbl = areaDisciplinareLbl;
	}

	public Long getIdAreaDisciplinare() {
		return idAreaDisciplinare;
	}

	public void setIdAreaDisciplinare(Long idAreaDisciplinare) {
		this.idAreaDisciplinare = idAreaDisciplinare;
	}

	public Character getFlagL() {
		return flagL;
	}

	public void setFlagL(Character flagL) {
		this.flagL = flagL;
	}

	public Character getFlagLS() {
		return flagLS;
	}

	public void setFlagLS(Character flagLS) {
		this.flagLS = flagLS;
	}

	public Character getFlagLM() {
		return flagLM;
	}

	public void setFlagLM(Character flagLM) {
		this.flagLM = flagLM;
	}

	public Character getFlagLS_CU() {
		return flagLS_CU;
	}

	public void setFlagLS_CU(Character flagLS_CU) {
		this.flagLS_CU = flagLS_CU;
	}

	public Character getFlagLM_CU() {
		return flagLM_CU;
	}

	public void setFlagLM_CU(Character flagLM_CU) {
		this.flagLM_CU = flagLM_CU;
	}

	public Character getFlagLVO() {
		return flagLVO;
	}

	public void setFlagLVO(Character flagLVO) {
		this.flagLVO = flagLVO;
	}

	public Character getFlagSP() {
		return flagSP;
	}

	public void setFlagSP(Character flagSP) {
		this.flagSP = flagSP;
	}

	public Character getFlagDOTT() {
		return flagDOTT;
	}

	public void setFlagDOTT(Character flagDOTT) {
		this.flagDOTT = flagDOTT;
	}

	public Date getDataInizioPubblicazioneOpen() {
		return dataInizioPubblicazioneOpen;
	}

	public void setDataInizioPubblicazioneOpen(Date dataInizioPubblicazioneOpen) {
		this.dataInizioPubblicazioneOpen = dataInizioPubblicazioneOpen;
	}

	public Date getDataFinePubblicazioneOpen() {
		return dataFinePubblicazioneOpen;
	}

	public void setDataFinePubblicazioneOpen(Date dataFinePubblicazioneOpen) {
		this.dataFinePubblicazioneOpen = dataFinePubblicazioneOpen;
	}

	public void setDescrizioneDisponibilita(String descrizioneDisponibilita) {
		this.descrizioneDisponibilita = descrizioneDisponibilita;
	}

	public String getDescrizioneDisponibilita() {
		return descrizioneDisponibilita;
	}

	public String getAteneoLabelFiltrata() {
		if (ateneo == null)
			return "";
		return ateneo.getCodiceErasmus() + " - " + ateneo.getRagioneSociale() 
				+ (ateneo.isCalifornia()? "" : "<br/>" + ateneo.getProvincia());
	}

	public TirocinioErasmusPlacement getTirocinioErasmusPlacement() {
		return tirocinioErasmusPlacement;
	}

	public void setTirocinioErasmusPlacement(
			TirocinioErasmusPlacement tirocinioErasmusPlacement) {
		this.tirocinioErasmusPlacement = tirocinioErasmusPlacement;
	}

	public Set<OffertaScuolaVicepresidenzaView> getOffertaScuoleVicepresidenze() {
		return offertaScuoleVicepresidenze;
	}

	public void setOffertaScuoleVicepresidenze(
			Set<OffertaScuolaVicepresidenzaView> offertaScuoleVicepresidenze) {
		this.offertaScuoleVicepresidenze = offertaScuoleVicepresidenze;
	}

	public Character getFlagPredefinita() {
		return this.flagPredefinita;
	}

	public void setFlagPredefinita(Character flagPredefinita) {
		this.flagPredefinita = flagPredefinita;
	}
}

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

import it.unibo.almarm.model.accordi.AccordoOperativo;
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.luoghi.Nazione;
import it.unibo.almarm.util.Common;

import java.util.Date;

public class CandidaturaView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String stato;
	private Date dataInserimento;
	private Date dataPresentazione;
	private Ateneo ateneo;
	private String nome;
	private String cognome;
	private Bando bando;
	private Integer priorita;
	private Character flagEsitoAccettazione;
	private Character flagStatoInGraduatoria;
	private String cognomeReferenteInterno;
	private String codFac;
	private AccordoOperativo accordoOperativo;
	private String siglaPolo;
	private Nazione nazione;
	private String descAteneoAzienda;
	private Long idPersona;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDataPresentazione() {
		return dataPresentazione;
	}
	
	public String getDataInserimentoPresentazioneLbl() {
		String ret = "";
		if (dataInserimento != null)
			ret += Common.getDataOraFormattata(dataInserimento) + "<br/>";
		if (dataPresentazione != null)
			ret += Common.getDataOraFormattata(dataPresentazione); 
		return ret;
	}

	public void setDataPresentazione(Date dataPresentazione) {
		this.dataPresentazione = dataPresentazione;
	}

	public Ateneo getAteneo() {
		return ateneo;
	}

	public void setAteneo(Ateneo ateneo) {
		this.ateneo = ateneo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Bando getBando() {
		return bando;
	}

	public void setBando(Bando bando) {
		this.bando = bando;
	}
	
	public String getColor() {
		return StatoCandidatura.get(stato).getColor();
	}
	
	public String getColorDesc() {
		return StatoCandidatura.get(stato).getValore();
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Integer getPriorita() {
		return priorita;
	}

	public void setPriorita(Integer priorita) {
		this.priorita = priorita;
	}

	public Character getFlagEsitoAccettazione() {
		return flagEsitoAccettazione;
	}

	public void setFlagEsitoAccettazione(Character flagEsitoAccettazione) {
		this.flagEsitoAccettazione = flagEsitoAccettazione;
	}
	
	public String getColorAccettazione(){
		if (Common.CH_S.equals(flagEsitoAccettazione))
			return "Green";
		if (Common.CH_N.equals(flagEsitoAccettazione))
			return "Red";
		return "White";
	}
	
	public String getColorAccettazioneDesc(){
		if (Common.CH_S.equals(flagEsitoAccettazione))
			return "Accettata";
		if (Common.CH_N.equals(flagEsitoAccettazione))
			return "Rifiutata";
		return "Da accettare";
	}

	public String getCognomeReferenteInterno() {
		return cognomeReferenteInterno;
	}

	public void setCognomeReferenteInterno(String cognomeReferenteInterno) {
		this.cognomeReferenteInterno = cognomeReferenteInterno;
	}

	public String getCodFac() {
		return codFac;
	}

	public void setCodFac(String codFac) {
		this.codFac = codFac;
	}

	public AccordoOperativo getAccordoOperativo() {
		return accordoOperativo;
	}

	public void setAccordoOperativo(AccordoOperativo accordoOperativo) {
		this.accordoOperativo = accordoOperativo;
	}

	public String getSiglaPolo() {
		return siglaPolo;
	}

	public void setSiglaPolo(String siglaPolo) {
		this.siglaPolo = siglaPolo;
	}

	public void setFlagStatoInGraduatoria(Character flagStatoInGraduatoria) {
		this.flagStatoInGraduatoria = flagStatoInGraduatoria;
	}

	public Character getFlagStatoInGraduatoria() {
		return flagStatoInGraduatoria;
	}
	
	public boolean isAlmenoAmmessa() {
		return StatoCandidatura.AMMESSA.getValore().equals(stato) || StatoCandidatura.VALUTATA.getValore().equals(stato); 
	}
	
	public String getColorInGraduatoria() {
		if (!isAlmenoAmmessa())
			return "Grey";
		return StatoCandidaturaInGraduatoria.get(getFlagStatoInGraduatoria()).getColor();
	}

	public String getStatoInGraduatoria() {
		if (StatoCandidatura.INSERITA.getValore().equals(stato) || StatoCandidatura.PRESENTATA.getValore().equals(stato))
			return StatoCandidaturaInGraduatoria.NON_VALUTATO.getValore();
		if (!isAlmenoAmmessa())
			return "non ammessa";
		return StatoCandidaturaInGraduatoria.get(getFlagStatoInGraduatoria()).getValore();
	}

	public Nazione getNazione() {
		return nazione;
	}

	public void setNazione(Nazione nazione) {
		this.nazione = nazione;
	}

	public String getDescAteneoAzienda() {
		return descAteneoAzienda;
	}

	public void setDescAteneoAzienda(String descAteneoAzienda) {
		this.descAteneoAzienda = descAteneoAzienda;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	
	public boolean isTesiAllEstero() {
		return getBando().isTesiAllEstero();
	}
}

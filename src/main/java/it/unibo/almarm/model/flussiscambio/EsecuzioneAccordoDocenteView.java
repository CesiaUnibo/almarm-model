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

import it.unibo.almarm.model.accordi.StatoAccordo;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class EsecuzioneAccordoDocenteView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long idPersona;
	private Long idAccordoOperativo;
	private Long idPeriodo;
	private Long idAteneo;
	private String codiceErasmus;
	private String nomeAteneo;
	private Long idReferenteInterno;
	private String cognomeReferenteInterno;
	private String nomeReferenteInterno;
	private Long idReferenteEsterno;
	private String cognomeReferenteEsterno;
	private String nomeReferenteEsterno;
	//private String siglaPolo;
	private Long idProgramma;
	private String nomeProgramma;
	private Character flagAttivazione;
	private String stato;
	private Set<ScambioAccordoView> scambiAccordoView=new HashSet<ScambioAccordoView>();
	private String statoOfferta;
	private Long postiTeoOfferta;
	private Long postiOfferti;
	private String statoAccOp;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Long getIdAccordoOperativo() {
		return idAccordoOperativo;
	}

	public void setIdAccordoOperativo(Long idAccordoOperativo) {
		this.idAccordoOperativo = idAccordoOperativo;
	}

	public Long getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Long idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public Long getIdAteneo() {
		return idAteneo;
	}

	public void setIdAteneo(Long idAteneo) {
		this.idAteneo = idAteneo;
	}

	public String getCodiceErasmus() {
		return codiceErasmus;
	}

	public void setCodiceErasmus(String codiceErasmus) {
		this.codiceErasmus = codiceErasmus;
	}

	public String getNomeAteneo() {
		return nomeAteneo;
	}

	public void setNomeAteneo(String nomeAteneo) {
		this.nomeAteneo = nomeAteneo;
	}

	public Long getIdReferenteInterno() {
		return idReferenteInterno;
	}

	public void setIdReferenteInterno(Long idReferenteInterno) {
		this.idReferenteInterno = idReferenteInterno;
	}

	public String getCognomeReferenteInterno() {
		return cognomeReferenteInterno;
	}

	public void setCognomeReferenteInterno(String cognomeReferenteInterno) {
		this.cognomeReferenteInterno = cognomeReferenteInterno;
	}

	public String getNomeReferenteInterno() {
		return nomeReferenteInterno;
	}

	public void setNomeReferenteInterno(String nomeReferenteInterno) {
		this.nomeReferenteInterno = nomeReferenteInterno;
	}

	public Long getIdReferenteEsterno() {
		return idReferenteEsterno;
	}

	public void setIdReferenteEsterno(Long idReferenteEsterno) {
		this.idReferenteEsterno = idReferenteEsterno;
	}

	public String getCognomeReferenteEsterno() {
		return cognomeReferenteEsterno;
	}

	public void setCognomeReferenteEsterno(String cognomeReferenteEsterno) {
		this.cognomeReferenteEsterno = cognomeReferenteEsterno;
	}

	public String getNomeReferenteEsterno() {
		return nomeReferenteEsterno;
	}

	public void setNomeReferenteEsterno(String nomeReferenteEsterno) {
		this.nomeReferenteEsterno = nomeReferenteEsterno;
	}
/*
	public String getSiglaPolo() {
		return siglaPolo;
	}

	public void setSiglaPolo(String siglaPolo) {
		this.siglaPolo = siglaPolo;
	}
*/
	public Long getIdProgramma() {
		return idProgramma;
	}

	public void setIdProgramma(Long idProgramma) {
		this.idProgramma = idProgramma;
	}

	public String getNomeProgramma() {
		return nomeProgramma;
	}

	public void setNomeProgramma(String nomeProgramma) {
		this.nomeProgramma = nomeProgramma;
	}

	public Character getFlagAttivazione() {
		return flagAttivazione;
	}

	public void setFlagAttivazione(Character flagAttivazione) {
		this.flagAttivazione = flagAttivazione;
	}

	public String getStato() {
		if (StringUtils.isBlank(stato))
			return StatoEsecuzioneAccordo.INIZIALE.getValore();
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
	
	public String getColor() {
		return StatoEsecuzioneAccordo.get(getStato()).getColor();
	}
	
	public String getColorDesc() {
		return StatoEsecuzioneAccordo.get(getStato()).getMessageKey();
	}
	
	public String getColorAttivazione() {
		return StatoEsecuzioneAccordo.get(getStato()).getColorAttivazione();
	}
	
	public String getColorDescAttivazione() {
		return StatoEsecuzioneAccordo.get(getStato()).getMessageKeyAttivazione();
	}

	public Set<ScambioAccordoView> getScambiAccordoView() {
		return scambiAccordoView;
	}

	public void setScambiAccordoView(Set<ScambioAccordoView> scambiAccordoView) {
		this.scambiAccordoView = scambiAccordoView;
	}
	public String getSiglePolo() {
		if (getScambiAccordoView()==null || getScambiAccordoView().isEmpty())
			return "";
		
		Set<String> cods=new HashSet<String>();
		for(ScambioAccordoView s: getScambiAccordoView())
			if (!StringUtils.isEmpty(s.getSiglaPolo()))
					cods.add(s.getSiglaPolo());
		
		String sigle="";
		for(String s : cods)
			sigle+=s+" ";
		return sigle.trim().replace(" ", ",");
	}

	public String getStatoOfferta() {
		if (StringUtils.isBlank(statoOfferta))
			return StatoOffertaEsecuzioneAccordo.INIZIALE.getValore();
		return statoOfferta;
	}

	public void setStatoOfferta(String statoOfferta) {
		this.statoOfferta = statoOfferta;
	}
	
	public String getColorStatoOfferta() {
		return StatoOffertaEsecuzioneAccordo.get(getStatoOfferta()).getColor();
	}
	
	public String getColorDescStatoOfferta() {
		return StatoOffertaEsecuzioneAccordo.get(getStatoOfferta()).getMessageKey();
	}

	public Long getPostiTeoOfferta() {
		return postiTeoOfferta;
	}

	public void setPostiTeoOfferta(Long postiTeoOfferta) {
		this.postiTeoOfferta = postiTeoOfferta;
	}

	public Long getPostiOfferti() {
		return postiOfferti;
	}

	public void setPostiOfferti(Long postiOfferti) {
		this.postiOfferti = postiOfferti;
	}

	public String getStatoAccOp() {
		return statoAccOp;
	}

	public void setStatoAccOp(String statoAccOp) {
		this.statoAccOp = statoAccOp;
	}
	public String getStatoAccOpColor() {
		return StatoAccordo.get(getStatoAccOp()).getColor();
	}
	
	public String getStatoAccOpColorDesc() {
		return StatoAccordo.get(getStatoAccOp()).getMessageKey();
	}
}

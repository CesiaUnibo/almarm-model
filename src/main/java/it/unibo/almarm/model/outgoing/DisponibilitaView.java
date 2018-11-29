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
import it.unibo.almarm.model.accordi.AccordoVicepresidenza;
import it.unibo.almarm.model.attori.Scuola;
import it.unibo.almarm.model.profilazione.UtenteGraduatoria;

import java.util.HashSet;
import java.util.Set;

public class DisponibilitaView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Bando bando;
	private Integer postiDisponibili;
	private String codFac;
	private String facolta;
	private String descrizione;
	private String stato;
	private Integer numeroCandidature;
	private Integer numeroCandidatureNonAmmesse;
	private String siglaPolo;
	private String cognomeResponsabileInterno;
	private AccordoOperativo accordoOperativo;
	private String codiceErasmus;
	private Scuola scuola;
	private String nomeDocumentoAggregato;
	private String nomeDocumentoToDownload;
	
	private Set<DisponibilitaAteneoView> disponbilitaAtenei = new HashSet<DisponibilitaAteneoView>();
	private Set<UtenteGraduatoria> utentiGraduatoria = new HashSet<UtenteGraduatoria>();
	private Set<DisponibilitaVicepresidenzaView> disponibilitaVicepresidenze = new HashSet<DisponibilitaVicepresidenzaView>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bando getBando() {
		return bando;
	}

	public void setBando(Bando bando) {
		this.bando = bando;
	}

	public Integer getPostiDisponibili() {
		return postiDisponibili;
	}

	public void setPostiDisponibili(Integer postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	public String getCodFac() {
		return codFac;
	}

	public void setCodFac(String codFac) {
		this.codFac = codFac;
	}

	public String getFacolta() {
		return facolta;
	}

	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Integer getNumeroCandidature() {
		return numeroCandidature;
	}

	public void setNumeroCandidature(Integer numeroCandidature) {
		this.numeroCandidature = numeroCandidature;
	}
	
	public String getColor() {
		return StatoDisponibilita.get(stato).getColor();
	}

	public Set<DisponibilitaAteneoView> getDisponbilitaAtenei() {
		return disponbilitaAtenei;
	}

	public void setDisponbilitaAtenei(
			Set<DisponibilitaAteneoView> disponbilitaAtenei) {
		this.disponbilitaAtenei = disponbilitaAtenei;
	}

	public String getNazioniLbl() {
		if (bando.isErasmusPlacement())
			return "";
		String ret = "";
		if (disponbilitaAtenei != null && !disponbilitaAtenei.isEmpty())
		{
			if (disponbilitaAtenei.size() == 1)
				return disponbilitaAtenei.iterator().next().getAteneo().getNazionalita().getNazione();
			else
			{
				ret = "<ul>";
				for (DisponibilitaAteneoView dav : disponbilitaAtenei)
					if (dav.getAteneo() != null && dav.getAteneo().getNazionalita() != null && dav.getAteneo().getNazionalita().getNazione() != null)
					ret += "<li>" + dav.getAteneo().getNazionalita().getNazione() + "</li>";
				ret += "</ul>";
			}
		}
		return ret;
	}

	public Integer getNumeroCandidatureNonAmmesse() {
		return numeroCandidatureNonAmmesse;
	}

	public void setNumeroCandidatureNonAmmesse(Integer numeroCandidatureNonAmmesse) {
		this.numeroCandidatureNonAmmesse = numeroCandidatureNonAmmesse;
	}

	public Set<UtenteGraduatoria> getUtentiGraduatoria() {
		return utentiGraduatoria;
	}

	public void setUtentiGraduatoria(Set<UtenteGraduatoria> utentiGraduatoria) {
		this.utentiGraduatoria = utentiGraduatoria;
	}

	public String getSiglaPolo() {
		return siglaPolo;
	}

	public void setSiglaPolo(String siglaPolo) {
		this.siglaPolo = siglaPolo;
	}

	public String getCognomeResponsabileInterno() {
		return cognomeResponsabileInterno;
	}

	public void setCognomeResponsabileInterno(String cognomeResponsabileInterno) {
		this.cognomeResponsabileInterno = cognomeResponsabileInterno;
	}

	public AccordoOperativo getAccordoOperativo() {
		return accordoOperativo;
	}

	public void setAccordoOperativo(AccordoOperativo accordoOperativo) {
		this.accordoOperativo = accordoOperativo;
	}

	public String getCodiceErasmus() {
		return codiceErasmus;
	}

	public void setCodiceErasmus(String codiceErasmus) {
		this.codiceErasmus = codiceErasmus;
	}

	
	public String getVicepresidenzeDesc() {
		String ret = "";
		for (DisponibilitaVicepresidenzaView dvv: getDisponibilitaVicepresidenze())
			if (dvv.getVicepresidenza() != null)
				ret += dvv.getVicepresidenza().getDescrizione() + "<br/>";
		if (ret.length() > 0)
			ret = ret.substring(0,  ret.length() - 5);
		return ret;
	}
	
	public String getScuolaVicepresidenzeDesc() {
		if (getScuola() != null)
			return getScuola().getDescrizione();
		String ret = "";
		for (DisponibilitaVicepresidenzaView dvv: getDisponibilitaVicepresidenze())
			if (dvv.getVicepresidenza() != null)
				ret += dvv.getVicepresidenza().getDescrizione() + "<br/>";
		if (ret.length() > 0)
			ret = ret.substring(0,  ret.length() - 5);
		return ret;
	}

	public Scuola getScuola() {
		return scuola;
	}

	public void setScuola(Scuola scuola) {
		this.scuola = scuola;
	}

	public Set<DisponibilitaVicepresidenzaView> getDisponibilitaVicepresidenze() {
		return disponibilitaVicepresidenze;
	}

	public void setDisponibilitaVicepresidenze(
			Set<DisponibilitaVicepresidenzaView> disponibilitaVicepresidenze) {
		this.disponibilitaVicepresidenze = disponibilitaVicepresidenze;
	}

	public String getNomeDocumentoAggregato() {
		return nomeDocumentoAggregato;
	}

	public void setNomeDocumentoAggregato(String nomeDocumentoAggregato) {
		this.nomeDocumentoAggregato = nomeDocumentoAggregato;
	}

	public String getNomeDocumentoToDownload() {
		return nomeDocumentoToDownload;
	}

	public void setNomeDocumentoToDownload(String nomeDocumentoToDownload) {
		this.nomeDocumentoToDownload = nomeDocumentoToDownload;
	}

}

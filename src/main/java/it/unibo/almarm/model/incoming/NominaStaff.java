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
package it.unibo.almarm.model.incoming;

import java.util.HashSet;
import java.util.Set;

import it.unibo.almarm.model.attori.SedeView;
import it.unibo.almarm.model.attori.Struttura;
import it.unibo.almarm.model.staff.AreaCunVqr;
import it.unibo.almarm.model.staff.Qualifica;
import it.unibo.almarm.util.Common;

public class NominaStaff implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Nomina nomina;
	private Struttura dipartimentoDiRiferimento;
	private String qualificaDiOrigine;
	private Qualifica qualificaItalianaCorrispondente;
	private String codiceOrcid;
	private AreaCunVqr areaCunVqr;
	private Character flagRimborsoSpese; // non ancora persistito perche' non utilizzato
	private SedeView sede;
	private String dettaglioAttivitaSvolta;
	private String dettaglioAttivitaSvoltaIng;
	private String webSite;
	private Character flagPubblicabileSuPortale;
	private Character flagHaGiaAssicurazione;
	private String noteAssicurazione;

	private Set<NominaTipoAttivitaStaff> nominaTipiAttivitaStaff = new HashSet<NominaTipoAttivitaStaff>();
	private Set<NominaStaffChecklistElement> nominaStaffChecklistElements = new HashSet<NominaStaffChecklistElement>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Nomina getNomina() {
		return nomina;
	}

	public void setNomina(Nomina nomina) {
		this.nomina = nomina;
	}

	public Struttura getDipartimentoDiRiferimento() {
		return dipartimentoDiRiferimento;
	}

	public void setDipartimentoDiRiferimento(Struttura dipartimentoDiRiferimento) {
		this.dipartimentoDiRiferimento = dipartimentoDiRiferimento;
	}

	public String getQualificaDiOrigine() {
		return qualificaDiOrigine;
	}

	public void setQualificaDiOrigine(String qualificaDiOrigine) {
		this.qualificaDiOrigine = qualificaDiOrigine;
	}

	public Qualifica getQualificaItalianaCorrispondente() {
		return qualificaItalianaCorrispondente;
	}

	public void setQualificaItalianaCorrispondente(Qualifica qualificaItalianaCorrispondente) {
		this.qualificaItalianaCorrispondente = qualificaItalianaCorrispondente;
	}

	public String getCodiceOrcid() {
		return codiceOrcid;
	}

	public void setCodiceOrcid(String codiceOrcid) {
		this.codiceOrcid = codiceOrcid;
	}

	public AreaCunVqr getAreaCunVqr() {
		return areaCunVqr;
	}

	public void setAreaCunVqr(AreaCunVqr areaCunVqr) {
		this.areaCunVqr = areaCunVqr;
	}

	public Character getFlagRimborsoSpese() {
		return flagRimborsoSpese;
	}

	public void setFlagRimborsoSpese(Character flagRimborsoSpese) {
		this.flagRimborsoSpese = flagRimborsoSpese;
	}

	public Set<NominaTipoAttivitaStaff> getNominaTipiAttivitaStaff() {
		return nominaTipiAttivitaStaff;
	}

	public void setNominaTipiAttivitaStaff(Set<NominaTipoAttivitaStaff> nominaTipiAttivitaStaff) {
		this.nominaTipiAttivitaStaff = nominaTipiAttivitaStaff;
	}

	public SedeView getSede() {
		return sede;
	}

	public void setSede(SedeView sede) {
		this.sede = sede;
	}

	public String getDettaglioAttivitaSvolta() {
		return dettaglioAttivitaSvolta;
	}

	public void setDettaglioAttivitaSvolta(String dettaglioAttivitaSvolta) {
		this.dettaglioAttivitaSvolta = dettaglioAttivitaSvolta;
	}

	public String getDettaglioAttivitaSvoltaIng() {
		return dettaglioAttivitaSvoltaIng;
	}

	public void setDettaglioAttivitaSvoltaIng(String dettaglioAttivitaSvoltaIng) {
		this.dettaglioAttivitaSvoltaIng = dettaglioAttivitaSvoltaIng;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Set<NominaStaffChecklistElement> getNominaStaffChecklistElements() {
		return nominaStaffChecklistElements;
	}

	public void setNominaStaffChecklistElements(Set<NominaStaffChecklistElement> nominaStaffChecklistElements) {
		this.nominaStaffChecklistElements = nominaStaffChecklistElements;
	}

	public Character getFlagPubblicabileSuPortale() {
		return flagPubblicabileSuPortale;
	}

	public void setFlagPubblicabileSuPortale(Character flagPubblicabileSuPortale) {
		this.flagPubblicabileSuPortale = flagPubblicabileSuPortale;
	}
	
	public boolean isPubblicabileSuPortale() {
		return Common.CH_S.equals(getFlagPubblicabileSuPortale());
	}

	public Character getFlagHaGiaAssicurazione() {
		return flagHaGiaAssicurazione;
	}

	public void setFlagHaGiaAssicurazione(Character flagHaGiaAssicurazione) {
		this.flagHaGiaAssicurazione = flagHaGiaAssicurazione;
	}

	public boolean isHaGiaAssicurazione() {
		return Common.CH_S.equals(getFlagHaGiaAssicurazione());
	}

	public String getNoteAssicurazione() {
		return noteAssicurazione;
	}

	public void setNoteAssicurazione(String noteAssicurazione) {
		this.noteAssicurazione = noteAssicurazione;
	}

}

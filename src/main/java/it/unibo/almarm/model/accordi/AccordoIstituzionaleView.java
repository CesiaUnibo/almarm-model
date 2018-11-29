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
package it.unibo.almarm.model.accordi;

import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Struttura;
import it.unibo.almarm.util.Common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccordoIstituzionaleView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
    
	private Ateneo  ateneoPartner;
	private Struttura struttura;
	
	private Long idAteneoPartner;
	private Long idStruttura;
	private Long idProgramma;
	private Long idNazionePartner;
	private String nomeAteneo;
	private String codiceErasmus;
	private String descrizioneProgramma; 
	
	private Date dataInizio;
	private Date dataFine;
	private Date dataStipula;
	private String stato;
	private String descrizioneAccordo;
	
	private Character validita;
	
	private Set<AccordoProgramma> accordoProgrammi = new HashSet<AccordoProgramma>();
	private Set<AccordoIstituzionaleAteneoView> ateneiPerFiltri = new HashSet<AccordoIstituzionaleAteneoView>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public Ateneo getAteneoPartner() {
		return ateneoPartner;
	}

	public void setAteneoPartner(Ateneo ateneoPartner) {
		this.ateneoPartner = ateneoPartner;
	}

	public String getNomeAteneo() {
		return nomeAteneo;
	}

	public void setNomeAteneo(String nomeAteneo) {
		this.nomeAteneo = nomeAteneo;
	}

	public String getDescrizioneProgramma() {
		return descrizioneProgramma;
	}

	public void setDescrizioneProgramma(String descrizioneProgramma) {
		this.descrizioneProgramma = descrizioneProgramma;
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

	public Date getDataStipula() {
		return dataStipula;
	}

	public void setDataStipula(Date dataStipula) {
		this.dataStipula = dataStipula;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Long getIdNazionePartner() {
		return idNazionePartner;
	}

	public void setIdNazionePartner(Long idNazionePartner) {
		this.idNazionePartner = idNazionePartner;
	}
	
	public Long getIdProgramma() {
		return idProgramma;
	}

	public void setIdProgramma(Long idProgramma) {
		this.idProgramma = idProgramma;
	}

	public Long getIdAteneoPartner() {
		return idAteneoPartner;
	}

	public void setIdAteneoPartner(Long idAteneoPartner) {
		this.idAteneoPartner = idAteneoPartner;
	}
	
	public Long getIdStruttura() {
		return idStruttura;
	}

	public void setIdStruttura(Long idStruttura) {
		this.idStruttura = idStruttura;
	}

	public String getCodiceErasmus() {
		return codiceErasmus;
	}

	public void setCodiceErasmus(String codiceErasmus) {
		this.codiceErasmus = codiceErasmus;
	}

	public String getDescrizioneAccordo() {
		return descrizioneAccordo;
	}

	public void setDescrizioneAccordo(String descrizioneAccordo) {
		this.descrizioneAccordo = descrizioneAccordo;
	}

	public Struttura getStruttura() {
		return struttura;
	}

	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}

	public String getAteneoAccordoDesc()
	{
		return ateneoPartner.getRagioneSociale() + "<br/>" + descrizioneAccordo;
	}
	
	public String getInizioFineDesc() {
		return Common.getDataFormattata(dataInizio) + "<br/>" + Common.getDataFormattata(dataFine);
	}
	
	public String getColor() {
		return StatoAccordo.get(stato).getColor();
	}

	public String getColorDesc() {
		return StatoAccordo.get(stato).getValore();
	}

	public Character getValidita() {
		return validita;
	}

	public void setValidita(Character validita) {
		this.validita = validita;
	}
	
	public String getValiditaColor() {
		return StatoValiditaAccordo.get(validita).getColor();
	}
	
	public String getValiditaColorDesc() {
		return StatoValiditaAccordo.get(validita).getDescrizione();
	}

	public Set<AccordoProgramma> getAccordoProgrammi() {
		return accordoProgrammi;
	}

	public void setAccordoProgrammi(Set<AccordoProgramma> accordoProgrammi) {
		this.accordoProgrammi = accordoProgrammi;
	}
	
	public List<Programma> getProgrammi() {
		List<Programma> programmi = new ArrayList<Programma>();
		for (AccordoProgramma ap: getAccordoProgrammi())
			programmi.add(ap.getProgramma());
		return programmi;
	}
	
	public String getProgrammiDesc() {
		String s = "";
		for (Programma p: getProgrammi())
			s += p.getNome() + "<br/>";
		return s;
	}
	
	public String getSedeDesc() {
		if (ateneoPartner != null)
			return ateneoPartner.getNazioneProvincia();
		return "";
	}
	
	public String getStrutturaDesc() {
		Struttura struttura = getStruttura();
		if (struttura != null)
			return struttura.getNomeAttore();
		return "";
	}

	public Set<AccordoIstituzionaleAteneoView> getAteneiPerFiltri() {
		return ateneiPerFiltri;
	}

	public void setAteneiPerFiltri(
			Set<AccordoIstituzionaleAteneoView> ateneiPerFiltri) {
		this.ateneiPerFiltri = ateneiPerFiltri;
	}
}

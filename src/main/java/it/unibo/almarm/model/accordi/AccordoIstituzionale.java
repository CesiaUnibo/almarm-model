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
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AccordoIstituzionale extends Accordo {

	private static final long serialVersionUID = 1L;
	
	private Set<AccordoProgramma> accordoProgrammi = new HashSet<AccordoProgramma>();
	private Ateneo ateneoPartnerReferente;
	private Struttura struttura;
	private Character inRinnovo = 'N';
	private Character validita;
	private Set<Ateneo> ateneiBeneficiari = new HashSet<Ateneo>();
	private Character flagPossiedeEche; // campo valido solo per il programma erasmus plus che indica se l'ateneo possiede la carta ECHE (Erasmus Charter for Higher Education) di abilitazione alla partecipazione al programma
	
	public Set<AccordoProgramma> getAccordoProgrammi() {
		return accordoProgrammi;
	}

	public void setAccordoProgrammi(Set<AccordoProgramma> accordoProgrammi) {
		this.accordoProgrammi = accordoProgrammi;
	}
	
	public String getStrutturaDesc() {
		Struttura struttura = getStruttura();
		if (struttura != null)
			return struttura.getNomeAttore();
		return "";
	}

	public String getUniversitaPartnerDesc() {
		if (ateneoPartnerReferente != null)
			return ateneoPartnerReferente.getRagioneSociale();
		return "";
	}
	
	public String getSedeDesc() {
		if (ateneoPartnerReferente != null)
			return ateneoPartnerReferente.getNazioneProvincia();
		return "";
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

	public void addProgramma(Programma programma) {
		AccordoProgramma accordoProgramma=new AccordoProgramma();
		accordoProgramma.setProgramma(programma);
		getAccordoProgrammi().add(accordoProgramma);
	}
	
	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}

	public Struttura getStruttura() {
		return struttura;
	}

	public Ateneo getAteneoPartnerReferente() {
		return ateneoPartnerReferente;
	}

	public void setAteneoPartnerReferente(Ateneo ateneoPartnerReferente) {
		this.ateneoPartnerReferente = ateneoPartnerReferente;
	}

	public String getCodiciErasmusDesc() {
		if (getAteneoPartnerReferente() != null)
			return getAteneoPartnerReferente().getCodiceErasmus();
		return "";
	}
	public String getAteneoAccordoDesc()
	{
		return ((getAteneoPartnerReferente()!=null)?getAteneoPartnerReferente().getRagioneSociale(): "") 
				+ "<br/>" + getDescrizione();
	}
	public String getInizioFineDesc() {
		return getLabelValidita();
	}

	public Character getInRinnovo() {
		if (inRinnovo == null)
			return 'N';
		return inRinnovo;
	}

	public void setInRinnovo(Character inRinnovo) {
		this.inRinnovo = inRinnovo;
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
	
	public boolean isRinnovoAttivo() {
		return (new Character('S')).equals(inRinnovo);
	}

	public Set<Ateneo> getAteneiBeneficiari() {
		return ateneiBeneficiari;
	}

	public void setAteneiBeneficiari(Set<Ateneo> ateneiBeneficiari) {
		this.ateneiBeneficiari = ateneiBeneficiari;
	}

	public Character getFlagPossiedeEche() {
		return flagPossiedeEche;
	}

	public void setFlagPossiedeEche(Character flagPossiedeEche) {
		this.flagPossiedeEche = flagPossiedeEche;
	}

	public boolean isPossiedeEche() {
		return Common.CH_S.equals(getFlagPossiedeEche());
	}
	
	public boolean isErasmusPlus() {
		for (Programma p: getProgrammi())
			if (p.isErasmusPlus())
				return true;
		return false;
	}
}

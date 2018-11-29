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

import org.apache.commons.lang.StringUtils;

import it.unibo.almarm.model.flussiscambio.AreaDisciplinare;
import it.unibo.almarm.model.lingue.Lingua;
import it.unibo.almarm.util.Common;

public class LinguaContrattoPartner implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private AreaDisciplinare areaDisciplinare;
	private Lingua lingua1; 
	private String livelloLingua1Studies;
	private String livelloLingua1Teaching;
	private Lingua lingua2;
	private String livelloLingua2Studies;
	private String livelloLingua2Teaching;
	private Character flagAltraLingua1;
	private Character flagAltraLingua2;
	private String nomeAltraLingua1;
	private String nomeAltraLingua2;
	private TipoSottotargetLinguaContratto cicloLingua1Studies;
	private TipoSottotargetLinguaContratto cicloLingua2Studies;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AreaDisciplinare getAreaDisciplinare() {
		return areaDisciplinare;
	}
	public void setAreaDisciplinare(AreaDisciplinare areaDisciplinare) {
		this.areaDisciplinare = areaDisciplinare;
	}
	public Lingua getLingua1() {
		return lingua1;
	}
	public void setLingua1(Lingua lingua1) {
		this.lingua1 = lingua1;
	}
	public String getLivelloLingua1Studies() {
		return livelloLingua1Studies;
	}
	public void setLivelloLingua1Studies(String livelloLingua1Studies) {
		this.livelloLingua1Studies = livelloLingua1Studies;
	}
	public String getLivelloLingua1Teaching() {
		return livelloLingua1Teaching;
	}
	public void setLivelloLingua1Teaching(String livelloLingua1Teaching) {
		this.livelloLingua1Teaching = livelloLingua1Teaching;
	}
	public Lingua getLingua2() {
		return lingua2;
	}
	public void setLingua2(Lingua lingua2) {
		this.lingua2 = lingua2;
	}
	public String getLivelloLingua2Studies() {
		return livelloLingua2Studies;
	}
	public void setLivelloLingua2Studies(String livelloLingua2Studies) {
		this.livelloLingua2Studies = livelloLingua2Studies;
	}
	public String getLivelloLingua2Teaching() {
		return livelloLingua2Teaching;
	}
	public void setLivelloLingua2Teaching(String livelloLingua2Teaching) {
		this.livelloLingua2Teaching = livelloLingua2Teaching;
	}
	public String getNomeAltraLingua1() {
		return nomeAltraLingua1;
	}
	public void setNomeAltraLingua1(String nomeAltraLingua1) {
		this.nomeAltraLingua1 = nomeAltraLingua1;
	}
	public String getNomeAltraLingua2() {
		return nomeAltraLingua2;
	}
	public void setNomeAltraLingua2(String nomeAltraLingua2) {
		this.nomeAltraLingua2 = nomeAltraLingua2;
	}
	public Character getFlagAltraLingua1() {
		return flagAltraLingua1;
	}
	public void setFlagAltraLingua1(Character flagAltraLingua1) {
		this.flagAltraLingua1 = flagAltraLingua1;
	}
	public Character getFlagAltraLingua2() {
		return flagAltraLingua2;
	}
	public void setFlagAltraLingua2(Character flagAltraLingua2) {
		this.flagAltraLingua2 = flagAltraLingua2;
	}
	public boolean  isAltraLingua1(){
		return Common.CH_S.equals(flagAltraLingua1);
	}
	
	public boolean  isAltraLingua2(){
		return Common.CH_S.equals(flagAltraLingua2);
	}
	// usare questo per prendere la descrizione lingua
	public String getLingua1LabelIng(){
		return isAltraLingua1() ? ((nomeAltraLingua1 == null) ? "" : nomeAltraLingua1) 
					: ((getLingua1() == null) ? "" : getLingua1().getNomeIng());
	}
	public String getLingua1Label(){
		return isAltraLingua1() ? ((nomeAltraLingua1 == null) ? "" : nomeAltraLingua1) 
					: ((getLingua1() == null) ? "" : getLingua1().getNome());
	}
	// usare questo per prendere la descrizione lingua
	public String getLingua2LabelIng(){
		return isAltraLingua2() ? ((nomeAltraLingua2 == null) ? "" : nomeAltraLingua2) 
					: ((getLingua2() == null) ? "" : getLingua2().getNomeIng());
	}
	public String getLingua2Label(){
		return isAltraLingua2() ? ((nomeAltraLingua2 == null) ? "" : nomeAltraLingua2) 
					: ((getLingua2() == null) ? "" : getLingua2().getNome());
	}
	
	public LinguaContrattoPartner clona(){
		LinguaContrattoPartner c=new LinguaContrattoPartner();
		c.setAreaDisciplinare(this.getAreaDisciplinare());
		c.setLingua1(this.getLingua1()); 
		c.setLivelloLingua1Studies(this.getLivelloLingua1Studies());
		c.setLivelloLingua1Teaching(this.getLivelloLingua1Teaching());
		c.setLingua2(this.getLingua2());
		c.setLivelloLingua2Studies(this.getLivelloLingua2Studies());
		c.setLivelloLingua2Teaching(this.getLivelloLingua2Teaching());
		c.setFlagAltraLingua1(this.getFlagAltraLingua1());
		c.setFlagAltraLingua2(this.getFlagAltraLingua2());
		c.setNomeAltraLingua1(this.getNomeAltraLingua1());
		c.setNomeAltraLingua2(this.getNomeAltraLingua2());
		c.setCicloLingua1Studies(this.getCicloLingua1Studies());
		c.setCicloLingua2Studies(this.getCicloLingua2Studies());
		return c;
	}
	public TipoSottotargetLinguaContratto getCicloLingua1Studies() {
		return cicloLingua1Studies;
	}
	public void setCicloLingua1Studies(
			TipoSottotargetLinguaContratto cicloLingua1Studies) {
		this.cicloLingua1Studies = cicloLingua1Studies;
	}
	public TipoSottotargetLinguaContratto getCicloLingua2Studies() {
		return cicloLingua2Studies;
	}
	public void setCicloLingua2Studies(
			TipoSottotargetLinguaContratto cicloLingua2Studies) {
		this.cicloLingua2Studies = cicloLingua2Studies;
	}

	public String getLivelloLingua1StudiesLabel() {
		if (StringUtils.isBlank(livelloLingua1Studies))
			return "";
		return livelloLingua1Studies + (getCicloLingua1Studies() == null ? "" : " for " + getCicloLingua1Studies().getDescrizione());
	}
	
	public String getLivelloLingua2StudiesLabel() {
		if (StringUtils.isBlank(livelloLingua2Studies))
			return "";
		return livelloLingua2Studies + (getCicloLingua2Studies() == null ? "" : " for " + getCicloLingua2Studies().getDescrizione());
	}

}

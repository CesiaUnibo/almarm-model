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
package it.unibo.almarm.model.outgoing.learningagreement;

public class EsameLAFigliIntegratiView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private EsameLAFigliIntegratiViewId id;
	private String nomeFiglioShort;
	private String codCorsoPadre;
	private String codIndPadre;
	private String codOriPadre;
	private String codMateriaPadre;
	// nome del corso integrato padre
	private String nomePadre;
	// indica se nel LA cui l'attivita' appartiene sono presenti tutti i moduli del corso integrato padre
	private Character flagTutti;
	
	public EsameLAFigliIntegratiViewId getId() {
		return id;
	}
	public void setId(EsameLAFigliIntegratiViewId id) {
		this.id = id;
	}
	public String getNomeFiglioShort() {
		return nomeFiglioShort;
	}
	public void setNomeFiglioShort(String nomeFiglioShort) {
		this.nomeFiglioShort = nomeFiglioShort;
	}
	public String getCodCorsoPadre() {
		return codCorsoPadre;
	}
	public void setCodCorsoPadre(String codCorsoPadre) {
		this.codCorsoPadre = codCorsoPadre;
	}
	public String getCodIndPadre() {
		return codIndPadre;
	}
	public void setCodIndPadre(String codIndPadre) {
		this.codIndPadre = codIndPadre;
	}
	public String getCodOriPadre() {
		return codOriPadre;
	}
	public void setCodOriPadre(String codOriPadre) {
		this.codOriPadre = codOriPadre;
	}
	public String getCodMateriaPadre() {
		return codMateriaPadre;
	}
	public void setCodMateriaPadre(String codMateriaPadre) {
		this.codMateriaPadre = codMateriaPadre;
	}
	public String getNomePadre() {
		return nomePadre;
	}
	public void setNomePadre(String nomePadre) {
		this.nomePadre = nomePadre;
	}
	public Character getFlagTutti() {
		return flagTutti;
	}
	public void setFlagTutti(Character flagTutti) {
		this.flagTutti = flagTutti;
	}
}

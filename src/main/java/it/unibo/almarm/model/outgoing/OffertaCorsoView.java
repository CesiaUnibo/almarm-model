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

public class OffertaCorsoView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Long idOfferta;
	private String codCorso;
	private String descCorso;
	private String struttura;
	private Character anno1;
	private Character anno2;
	private Character anno3;
	private Character anno4;
	private Character anno5;
	private Character anno6;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(Long idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}

	public String getDescCorso() {
		return descCorso;
	}

	public void setDescCorso(String descCorso) {
		this.descCorso = descCorso;
	}

	public Character getAnno1() {
		return anno1;
	}

	public void setAnno1(Character anno1) {
		this.anno1 = anno1;
	}

	public Character getAnno2() {
		return anno2;
	}

	public void setAnno2(Character anno2) {
		this.anno2 = anno2;
	}

	public Character getAnno3() {
		return anno3;
	}

	public void setAnno3(Character anno3) {
		this.anno3 = anno3;
	}

	public Character getAnno4() {
		return anno4;
	}

	public void setAnno4(Character anno4) {
		this.anno4 = anno4;
	}

	public Character getAnno5() {
		return anno5;
	}

	public void setAnno5(Character anno5) {
		this.anno5 = anno5;
	}

	public Character getAnno6() {
		return anno6;
	}

	public void setAnno6(Character anno6) {
		this.anno6 = anno6;
	}

	public String getStruttura() {
		return struttura;
	}

	public void setStruttura(String struttura) {
		this.struttura = struttura;
	}
}

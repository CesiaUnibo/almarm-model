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

import java.math.BigDecimal;

public class RegoleOfferteDiff implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private BigDecimal IDREGOLA;
	private String CODCORSO;
	private String DESCCORSO;
	private BigDecimal ANNO1;
	private BigDecimal ANNO2;
	private BigDecimal ANNO3;
	private BigDecimal ANNO4;
	private BigDecimal ANNO5;
	private BigDecimal ANNO6;

	public BigDecimal getIDREGOLA() {
		return IDREGOLA;
	}

	public void setIDREGOLA(BigDecimal iDREGOLA) {
		IDREGOLA = iDREGOLA;
	}

	public String getCODCORSO() {
		return CODCORSO;
	}

	public void setCODCORSO(String cODCORSO) {
		CODCORSO = cODCORSO;
	}

	public String getDESCCORSO() {
		return DESCCORSO;
	}

	public void setDESCCORSO(String dESCCORSO) {
		DESCCORSO = dESCCORSO;
	}

	public BigDecimal getANNO1() {
		return ANNO1;
	}

	public void setANNO1(BigDecimal aNNO1) {
		ANNO1 = aNNO1;
	}

	public BigDecimal getANNO2() {
		return ANNO2;
	}

	public void setANNO2(BigDecimal aNNO2) {
		ANNO2 = aNNO2;
	}

	public BigDecimal getANNO3() {
		return ANNO3;
	}

	public void setANNO3(BigDecimal aNNO3) {
		ANNO3 = aNNO3;
	}

	public BigDecimal getANNO4() {
		return ANNO4;
	}

	public void setANNO4(BigDecimal aNNO4) {
		ANNO4 = aNNO4;
	}

	public BigDecimal getANNO5() {
		return ANNO5;
	}

	public void setANNO5(BigDecimal aNNO5) {
		ANNO5 = aNNO5;
	}

	public BigDecimal getANNO6() {
		return ANNO6;
	}

	public void setANNO6(BigDecimal aNNO6) {
		ANNO6 = aNNO6;
	}

	
	
}

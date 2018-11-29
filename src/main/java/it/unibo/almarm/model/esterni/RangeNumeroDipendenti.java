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
package it.unibo.almarm.model.esterni;


public class RangeNumeroDipendenti implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer rangeDa;
	private Integer rangeA;
	private String range;
	private String rangeIng;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRangeDa() {
		return rangeDa;
	}

	public void setRangeDa(Integer rangeDa) {
		this.rangeDa = rangeDa;
	}

	public Integer getRangeA() {
		return rangeA;
	}

	public void setRangeA(Integer rangeA) {
		this.rangeA = rangeA;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rangeA == null) ? 0 : rangeA.hashCode());
		result = prime * result + ((rangeDa == null) ? 0 : rangeDa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RangeNumeroDipendenti))
			return false;
		RangeNumeroDipendenti other = (RangeNumeroDipendenti) obj;
		if (rangeA == null) {
			if (other.getRangeA() != null)
				return false;
		} else if (!rangeA.equals(other.getRangeA()))
			return false;
		if (rangeDa == null) {
			if (other.getRangeDa() != null)
				return false;
		} else if (!rangeDa.equals(other.getRangeDa()))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.id);
	}

	public String getRangeIng() {
		return rangeIng;
	}

	public void setRangeIng(String rangeIng) {
		this.rangeIng = rangeIng;
	}
}

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

import it.unibo.almarm.util.Common;

import java.io.Serializable;

public class UnitaMisuraDurata implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static Long ID_ORE = 3L;
	public static Long ID_GIORNI = 1L;
	public static Long ID_MESI = 2L;
	public static Long ID_SETTIMANE = 4L;
	public static Long ID_SEMESTRI = 5L;
	
	private Long id;
	private String unita;
	private String unitaIng;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUnita() {
		return unita;
	}

	public void setUnita(String unita) {
		this.unita = unita;
	}

	public String getUnitaIng() {
		return unitaIng;
	}

	public void setUnitaIng(String unitaIng) {
		this.unitaIng = unitaIng;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UnitaMisuraDurata))
			return false;
		UnitaMisuraDurata other = (UnitaMisuraDurata) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public boolean isOre()
	{
		return this.id.equals(ID_ORE);
	}
	
	public boolean isGiorni()
	{
		return this.id.equals(ID_GIORNI);
	}
	
	public boolean isSettimane()
	{
		return this.id.equals(ID_SETTIMANE);
	}
	
	public boolean isMesi()
	{
		return this.id.equals(ID_MESI);
	}
	
	public boolean isSemstri()
	{
		return this.id.equals(ID_SEMESTRI);
	}
	
	public Float getGiorniCorrispondenti() {
		if (isGiorni())
			return new Float(1);
		if (isMesi())
			return new Float(30);
		if (isSettimane())
			return new Float(7);
		if (isSemstri())
			return new Float(180);
		if (isOre())
			return new Float(1/24);
		return new Float(0);
	}
}

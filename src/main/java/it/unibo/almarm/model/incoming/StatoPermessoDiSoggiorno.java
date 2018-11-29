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

public enum StatoPermessoDiSoggiorno {
	SCADUTO(0,"Red"),
	REGOLARE_O_NON_NECESSARIO(1,"Green"),
	IN_ATTESA_DI_RINNOVO(2,"Yellow");
	
	private Integer value;
	private String color;
	
	private StatoPermessoDiSoggiorno(Integer value, String color) {
		this.value = value;
		this.color = color;
	}

	public Integer getValue() {
		return value;
	}

	public String getColor() {
		return color;
	}
	
	public static StatoPermessoDiSoggiorno get(Integer i) {
		for (StatoPermessoDiSoggiorno s: values())
			if (s.value.equals(i))
				return s;
		return null;
	}
}

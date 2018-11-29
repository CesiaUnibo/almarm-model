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

public enum StatoValiditaAccordo {
	ATTIVO('A',"attivo","green"),
	IN_RINNOVO('I',"in rinnovo","yellow"),
	PROROGATO('P',"attivo in proroga","green"),
	SCADUTO('S',"scaduto", "red");
	
	private Character value;
	private String descrizione;
	private String color;
	
	private StatoValiditaAccordo(Character value, String descrizione, String color) {
		this.value = value;
		this.descrizione = descrizione;
		this.color = color;
	}

	public Character getValue() { return value; }
	
	public String getColor() { return color; }
	
	public String getDescrizione() { return descrizione; }
	
	public static StatoValiditaAccordo get(Character c) {
		for (StatoValiditaAccordo s: values())
			if (s.getValue().equals(c))
				return s;
		return null;
	}
}

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
package it.unibo.almarm.model.attori;


public class Studente extends Persona {

	private static final long serialVersionUID = 1L;
	
	private Integer pincode;
	private Character indirizzoPostaPreferito;
	
	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Character getIndirizzoPostaPreferito() {
		return indirizzoPostaPreferito;
	}

	public void setIndirizzoPostaPreferito(Character indirizzoPostaPreferito) {
		this.indirizzoPostaPreferito = indirizzoPostaPreferito;
	}

	@Override
	public AttoreIndirizzo getIndirizzoPrincipale()
	{
		for (AttoreIndirizzo ai: this.getAttoreIndirizzos())
			if (ai.getTipo().equals(indirizzoPostaPreferito.toString()))
				return ai;
		if ((getAttoreIndirizzos() != null) && (getAttoreIndirizzos().size() > 0))
			return getAttoreIndirizzos().iterator().next();
		return null;
	}
}

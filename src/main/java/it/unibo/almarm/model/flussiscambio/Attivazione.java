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

public enum Attivazione {

	DA_ESAMINARE ('E')
	{
		@Override
		public String getColorAttivazione() {
			return "White";
		}
	},
	DA_RINNOVARE  ('S')
	{
		@Override
		public String getColorAttivazione() {
			return "Green";
		}
	},
	DA_NON_RINNOVARE  ('N')
	{
		@Override
		public String getColorAttivazione() {
			return "Red";
		}
	};
	
	private Character valore;
	private Attivazione(Character a) {
		valore=a;
	}

	public Character getValore() {
		return valore;
	}
	
	public static Attivazione getAttivazione(Character c)
	{
		if (c!=null)
			for (Attivazione el: Attivazione.values())
				if (el.getValore().equals(c))
					return el;
		return null;
	}
	
	public String getMessageKey(){return getMessageKey(this.getValore());}
	public String getColorAttivazione() {return "Gray";}

	
	static public String getMessageKey(Character attivazione){
		if (attivazione==null)
			return "esecuzioneAccordo.attivazione.E"; 
		else 
			return "esecuzioneAccordo.attivazione."+attivazione.toString().toUpperCase().replace(" ", "");
	}
}

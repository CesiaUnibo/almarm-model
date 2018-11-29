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

public enum FlagLAIncoming {
	DOC_LA_DA_VALIDARE('A') ,
	DOC_LA_RIFIUTATO('R'),
	DOC_LA_VALIDATO('V'), 
	ASSENTE('N')
	;

	private Character valore;
	FlagLAIncoming(Character c){this.valore=c;}
	public Character getValore() {return valore;}
	public void setValore(Character valore) {this.valore = valore;}
	
	public static boolean isDocLADaValidare(Character val) {
		return (val != null) && (DOC_LA_DA_VALIDARE.getValore().equals(val));
	}
	public static boolean isDocLARifiutato(Character val) {
		return (val != null) && (DOC_LA_RIFIUTATO.getValore().equals(val));
	}
	public static boolean isDocLAValidato(Character val) {
		return (val != null) && (DOC_LA_VALIDATO.getValore().equals(val));
	}
}

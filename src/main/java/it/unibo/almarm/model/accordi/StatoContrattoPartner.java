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

public enum StatoContrattoPartner {
	INIZIALE("iniziale") {
		@Override
		public boolean isPartnerPuoModificare() {return true;}
		@Override
		public boolean isAlmenoBozza() {return false;}
	},
	INVIATO("inviato") {
		@Override
		public boolean isPartnerPuoModificare() {return true;}
		@Override
		public boolean isAlmenoBozza() {return false;}
	},
	BOZZA("bozza"){
		@Override
		public boolean isPartnerPuoModificare() {return true;}
	},
	COMPILATO("compilato"){
		@Override
		public boolean isAlmenoCompilato() {return true;}
	},
	FIRMATO("firmato"){
		@Override
		public boolean isAlmenoCompilato() {return true;}
	},
	VALIDATO("validato"){
		@Override
		public boolean isAlmenoCompilato() {return true;}
	};
	
	private String valore;
	public boolean isPartnerPuoModificare() {return false;}
	public boolean isAlmenoCompilato() {return false;}
    // --------------------------------------------
	public boolean isAlmenoBozza() {return true;}
	
	StatoContrattoPartner(String v) {valore = v;}

	public String getValore() {
		return valore;
	}

	static public StatoContrattoPartner get(String stato) {return valueOf(stato.toUpperCase().replace(" ", "_"));}
}

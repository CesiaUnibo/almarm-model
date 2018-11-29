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
package it.unibo.almarm.model.staff;

import org.apache.commons.lang.StringUtils;

public enum StatoIncomingStaff {
	BOZZA("bozza") {
		@Override
		public String getColor() {
			return "Grey";
		}
	},
	DA_VALIDARE("da validare") {
		@Override
		public String getColor() {
			return "Yellow";
		}
	},
	DA_APPROVARE("da approvare") {
		@Override
		public String getColor() {
			return "Yellow";
		}
	},
	APPROVATO("approvato") {
		@Override
		public String getColor() {
			return "GreenYellow";
		}
	},
	ARRIVATO("arrivato"){
		@Override
		public String getColor() {
			return "Orange";
		}
		@Override
		public boolean isCreazioneCarriera(){
			return true;
		}
	},
	PROLUNGAMENTO_DA_APPROVARE("prolungamento da approvare") {
		@Override
		public String getColor() {
			return "Yellow";
		}
	},
	PARTITO("partito"){
		@Override
		public String getColor() {
			return "Green";
		}
	},
	RINUNCIATO("rinunciato") {
		@Override
		public String getColor() {
			return "Red";
		}
	},
	RIFIUTATO("rifiutato") {
		@Override
		public String getColor() {
			return "Red";
		}
	};
	
	private String valore;
	
	StatoIncomingStaff(String v) {valore = v;}

	public String getValore() {
		return valore;
	}
	
	public String getMessageKey(){return getMessageKey(this.getValore());}
	public String getColor() {return null;}
	public boolean isCreazioneCarriera(){return false;}
	
	static public String getMessageKey(String stato){
		if (StringUtils.isEmpty(stato))
			return "incomingStaff.stato.bozza"; 
		else 
			return "incomingStaff.stato."+stato.toLowerCase().replace(" ", "");
	}
	
	static public StatoIncomingStaff get(String stato) {return valueOf(stato.toUpperCase().replace(" ", "_"));}
}

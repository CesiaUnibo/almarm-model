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

import org.apache.commons.lang.StringUtils;

public enum StatoApprovazioneNomina {
	DA_NON_APPROVARE("") {
		@Override
		public String getColor() {
			return "Grey";
		}
	},
	BOZZA("bozza"){
		@Override
		public String getColor() {
			return "White";
		}
	},
	DA_VALIDARE("da validare") {
		@Override
		public String getColor() {
			return "Yellow";
		}
	},
	DA_APPROVARE("da approvare"){
		@Override
		public String getColor() {
			return "Yellow";
		}
	},
	APPROVATO("approvato"){
		@Override
		public String getColor() {
			return "Green";
		}
	},
	RIFIUTATO("rifiutato"){
		@Override
		public String getColor() {
			return "Red";
		}
	};
	
	private String valore;
	
	StatoApprovazioneNomina(String v) {valore = v;}

	public String getValore() {
		return valore;
	}
	
	public String getMessageKey(){return getMessageKey(this.getValore());}
	public String getColor() {return null;}
	
	static public String getMessageKey(String stato){
		if (StringUtils.isEmpty(stato))
			return "nomina.stato.danonapprovare"; 
		else 
			return "nomina.stato."+stato.toLowerCase().replace(" ", "");
	}
	
	static public StatoApprovazioneNomina get(String stato) {
		if (StringUtils.isBlank(stato)) 
			return DA_NON_APPROVARE; 
		return valueOf(stato.toUpperCase().replace(" ", "_"));
	}

}

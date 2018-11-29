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

public enum StatoStudenteIncoming {
	INIZIALE("iniziale") {
		@Override
		public String getColor() {
			return "White";
		}
	},
	ARRIVATO("arrivato"){
		@Override
		public String getColor() {
			return "Yellow";
		}
		@Override
		public boolean isCreazioneCarriera(){
			return true;
		}
	},
	PROLUNGAMENTO_DA_APPROVARE("prolungamento da approvare"){
		@Override
		public String getColor() {
			return "Orange";
		}
		@Override
		public boolean isCreazioneCarriera(){
			return true;
		}
	},
	PARTITO("partito"){
		@Override
		public String getColor() {
			return "GreenYellow";
		}
	},
	TERMINATO("terminato"){
		@Override
		public String getColor() {
			return "Green";
		}
	};
	
	private String valore;
	
	StatoStudenteIncoming(String v) {valore = v;}

	public String getValore() {
		return valore;
	}
	
	public String getMessageKey(){return getMessageKey(this.getValore());}
	public String getColor() {return null;}
	public boolean isCreazioneCarriera(){return false;}
	
	static public String getMessageKey(String stato){
		if (StringUtils.isEmpty(stato))
			return "studenteIncoming.stato.iniziale"; 
		else 
			return "studenteIncoming.stato."+stato.toLowerCase().replace(" ", "");
	}
	
	static public StatoStudenteIncoming get(String stato) {return valueOf(stato.toUpperCase().replace(" ", "_"));}
}

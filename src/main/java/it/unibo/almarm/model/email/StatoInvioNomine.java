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
package it.unibo.almarm.model.email;

import org.apache.commons.lang.StringUtils;

public enum StatoInvioNomine {
	
	DA_INVIARE("da inviare") {
		@Override
		public String getColor() {
			return "white";
		}
	},
	INVIATA("inviata") {
		@Override
		public String getColor() {
			return "Yellow";
		}
	},
	RISCONTRATA("riscontrata") {
		@Override
		public String getColor() {
			return "Green";
		}
	},
	DA_NON_INVIARE("da non inviare") {
		@Override
		public String getColor() {
			return "Gray";
		}
	};

	private String valore;
	
	StatoInvioNomine(String v) {valore = v;}

	public String getValore() {
		return valore;
	}
	public String getColor() {return null;}
	public String getMessageKey(){return getMessageKey(this.getValore());}
	static public StatoInvioNomine get(String stato) {return valueOf(stato.toUpperCase().replace(" ", "_"));}

	static public String getMessageKey(String stato){
		if (StringUtils.isEmpty(stato))
			return "invioNomine.stato.daInviare"; 
		else 
			return "invioNomine.stato."+stato.toLowerCase().replace(" ", "");
	}
	
	static public String[] getElencoStati() {
		StatoInvioNomine[] stb = StatoInvioNomine.values();
		String[] stati=new String[stb.length];
		for (int i=0; i<stb.length; i++)
			stati[i]=stb[i].getValore();
		return stati;
	}
}

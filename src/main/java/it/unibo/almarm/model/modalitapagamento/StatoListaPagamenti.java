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
package it.unibo.almarm.model.modalitapagamento;

import org.apache.commons.lang.StringUtils;

public enum StatoListaPagamenti {
	
	INIZIALE("iniziale") {
		@Override
		public String getColor() {
			return "White";
		}
	},
	EMESSA("emessa") {
		@Override
		public String getColor() {
			return "Green";
		}
	},
	ANNULLATA("annullata") {
		@Override
		public String getColor() {
			return "Red";
		}
	};

	private String valore;
	
	StatoListaPagamenti(String v) {valore = v;}

	public String getValore() {
		return valore;
	}
	public String getColor() {return null;}
	public String getMessageKey(){return getMessageKey(this.getValore());}
	static public StatoListaPagamenti get(String stato) {return valueOf(stato.toUpperCase().replace(" ", "_"));}

	static public String getMessageKey(String stato){
		if (StringUtils.isEmpty(stato))
			return "listaPagamenti.stato.iniziale"; 
		else 
			return "listaPagamenti.stato."+stato.toLowerCase().replace(" ", "");
	}
	
	static public String[] getElencoStati() {
		StatoListaPagamenti[] stb = StatoListaPagamenti.values();
		String[] stati=new String[stb.length];
		for (int i=0; i<stb.length; i++)
			stati[i]=stb[i].getValore();
		return stati;
	}
}

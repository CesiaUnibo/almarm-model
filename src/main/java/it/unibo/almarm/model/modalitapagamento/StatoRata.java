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

public enum StatoRata {
	
	DA_PAGARE("da pagare") {
		@Override
		public String getColor() {
			return "White";
		}
	},
	RICHIESTA_RESTITUZIONE("richiesta restituzione") {
		@Override
		public String getColor() {
			return "Yellow";
		}
	},
	PAGATA("pagata") {
		@Override
		public String getColor() {
			return "Green";
		}
	},
	SOSPESA("sospesa") {
		@Override
		public String getColor() {
			return "Red";
		}
	};

	private String valore;
	
	StatoRata(String v) {valore = v;}

	public String getValore() {
		return valore;
	}
	public String getColor() {return null;}
	public String getMessageKey(){return getMessageKey(this.getValore());}
	static public StatoRata get(String stato) {return valueOf(stato.toUpperCase().replace(" ", "_"));}

	static public String getMessageKey(String stato){
		if (StringUtils.isEmpty(stato))
			return "rata.stato.daPagare"; 
		else 
			return "rata.stato."+stato.toLowerCase().replace(" ", "");
	}
	
	static public String[] getElencoStati() {
		StatoRata[] stb = StatoRata.values();
		String[] stati=new String[stb.length];
		for (int i=0; i<stb.length; i++)
			stati[i]=stb[i].getValore();
		return stati;
	}
}

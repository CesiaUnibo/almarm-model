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

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

public enum StatoOffertaEsecuzioneAccordo {
	TUTTI("tutti") {
		@Override
		public String getColor() {
			return "light Green";
		}
		@Override
		public boolean isStatoDb(){return false;};
	},
	INIZIALE("iniziale") {
		@Override
		public String getColor() {
			return "White";
		}
	},
	DA_INSERIRE("da inserire") {
		@Override
		public String getColor() {
			return "Yellow";
		}
	},
	DA_COMPLETARE("da completare") {
		@Override
		public String getColor() {
			return "GreenYellow";
		}
	},
	COMPLETO("completo") {
		@Override
		public String getColor() {
			return "Green";
		}
	},
	NON_PREVISTO("non previsto") {
		@Override
		public String getColor() {
			return "light Green";
		}
		@Override
		public boolean perFiltrOperatore() {return true;}
	};
	private String valore;
	StatoOffertaEsecuzioneAccordo(String v) {valore = v;}

	public String getValore() {
		return valore;
	}

	public String getMessageKey(){return getMessageKey(this.getValore());}
	public String getColor() {return "White";}
	public boolean isStatoDb() {return true;}
	public boolean perFiltrOperatore() {return true;}
	public static  StatoOffertaEsecuzioneAccordo get(String stato) 
	{
		if (stato == null) 
			return INIZIALE;
		StatoOffertaEsecuzioneAccordo st=valueOf(stato.toUpperCase().replace(" ", "_"));
		return  (st == null)? INIZIALE : st;
	}

	static public String getMessageKey(String stato){
		if (StringUtils.isEmpty(stato))
			return "esecuzioneAccordo.statoOfferta.iniziale"; 
		else 
			return "esecuzioneAccordo.statoOfferta."+stato.toLowerCase().replace(" ", "");
	}

	static public StatoOffertaEsecuzioneAccordo[] getElencoStatiOffertaPerFiltroOperatore() {
		ArrayList<StatoOffertaEsecuzioneAccordo> sf = new ArrayList<StatoOffertaEsecuzioneAccordo>();
		for (StatoOffertaEsecuzioneAccordo st : StatoOffertaEsecuzioneAccordo.values())	
			if (st.perFiltrOperatore())
				sf.add(st);
		
		StatoOffertaEsecuzioneAccordo[] stati= new StatoOffertaEsecuzioneAccordo[sf.size()];
		int i=0;
		for (StatoOffertaEsecuzioneAccordo st : sf)
			stati[i++]=st;
		
		return stati;
	}
}

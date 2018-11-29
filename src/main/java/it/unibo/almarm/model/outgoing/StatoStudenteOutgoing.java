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
package it.unibo.almarm.model.outgoing;

import org.apache.commons.lang.StringUtils;

public enum StatoStudenteOutgoing {
	INIZIALE("iniziale") {
		@Override
		public String getColor() {
			return "White";
		}
		@Override
		public boolean puoCreareMiniCarriera (){return true;}
	},
	ARRIVO_DICHIARATO("arrivo dichiarato"){
		@Override
		public String getColor() {
			return "Yellow";
		}
		@Override
		public boolean puoCreareMiniCarriera (){return true;}
	},
	PARTITO("partito"){
		@Override
		public String getColor() {
			return "GreenYellow";
		}
		@Override
		public boolean puoCreareMiniCarriera (){return true;}
	},
	RIENTRO_DICHIARATO("rientro dichiarato"){
		@Override
		public String getColor() {
			return "GoldenRod";
		}
	},
	RIENTRATO("rientrato"){
		@Override
		public String getColor() {
			return "Green";
		}
	},
	RINUNCIATO("rinunciato"){
		@Override
		public String getColor() {
			return "Red";
		}
	// TODO : eventuale stato RESPINTO, al momento lo studente outgoing respinto viene cancellato manualmente dal db.
	// se invece lo si vorra tenere come storicizzazione, occorrerà aggiungere un campo data_respingimento e autore 
	// e farla gestire alle viste che si basano solo sulla data di rinuncia per scartare gli outgoing 
	// non validi (ad esempio per l'invio nomine) e al requisito per le candidature del ribando (il respinto erasmus
	// puo'ricandidarsi per erasmus). 
	},
	RINUNCIATO_DA_PARTITO("rinunciato da partito"){
		@Override
		public String getColor() {
			return "Red";
		}
	},
	RINUNCIATO_DA_RIENTRATO("rinunciato da rientrato"){
		@Override
		public String getColor() {
			return "Red";
		}
	},
	REVOCATO("revocato"){
		@Override
		public String getColor() {
			return "Red";
		}
	}
	;
	
	private String valore;
	
	StatoStudenteOutgoing(String v) {valore = v;}

	public String getValore() {
		return valore;
	}
	
	public String getMessageKey(){return getMessageKey(this.getValore());}
	public String getColor() {return null;}
	
	static public String getMessageKey(String stato){
		if (StringUtils.isEmpty(stato))
			return "studenteOutgoing.stato.iniziale"; 
		else 
			return "studenteOutgoing.stato."+stato.toLowerCase().replace(" ", "");
	}
	public boolean puoCreareMiniCarriera (){return false;}
	
	static public StatoStudenteOutgoing get(String stato) {return valueOf(stato.toUpperCase().replace(" ", "_"));}
}

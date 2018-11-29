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

import it.unibo.almarm.util.Common;

public enum StatoCandidaturaInGraduatoria {
	
	NON_VALUTATO("non valutato", null){
		@Override
		public String getColor() {
			return "White";
		}
	},
	VINCITORE("vincitore", 'V'){
		@Override
		public String getColor() {
			return "Green";
		}
		@Override
		public String getColor(Character flagSubentro) {
			return Common.CH_S.equals(flagSubentro)? "lightgreen" : "Green";
		}
		@Override
		public String getColor(Character flagSubentro, Character flagRiassegnazione) {
			return Common.CH_O.equals(flagRiassegnazione)? "#9DC209" : getColor(flagSubentro);
		}
	},
	IDONEO("idoneo", 'I'){
		@Override
		public String getColor() {
			return "Yellow";
		}
	},
	ESCLUSO("non idoneo", 'E'){
		@Override
		public String getColor() {
			return "Red";
		}
	},
	RIFIUTATO("rifiutato", 'R'){
		@Override
		public String getColor() {
			return "Red";
		}
	},
	NON_ACCETTATO("non accettato", 'N'){
		@Override
		public String getColor() {
			return "Red";
		}
	},
	RINUNCIATO("rinunciato", 'C'){
		@Override
		public String getColor() {
			return "Red";
		}
	},
	// respinto dall'università partner dopo l'accettazione della nomina 
	// lo stato attualmente viene inserito manualmente e lo studente
	// outgoing relativo viene cancellato manualmnete. 
	RESPINTO("respinto", 'T'){ 
		@Override
		public String getColor() {
			return "Red";
		}
	},
	SUBENTRATO_VOLONTARIO_SENZA_CONTRIBUTO("zero grant", 'O'){ 
		@Override
		public String getColor() {
			return "Orange";
		}
	};
	
	private String valore;
	private Character statoDB;
	StatoCandidaturaInGraduatoria(String v, Character s) {valore = v;statoDB = s;}

	public String getValore() {
		return valore;
	}
	
	public Character getStatoDB(){return this.statoDB;}
	
	public String getColor() {return null;}
	public String getColor(Character flagSubentro) {
		return getColor();
	}
	public String getColor(Character flagSubentro, Character flagRiassegnazione) {
		return getColor();
	}
	static public StatoCandidaturaInGraduatoria get(Character sstatoDB) {if (sstatoDB == null) return NON_VALUTATO;for (StatoCandidaturaInGraduatoria s: values()) if (sstatoDB.equals(s.statoDB)) return s; return null;}
}

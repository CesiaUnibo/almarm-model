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

import org.apache.commons.lang.StringUtils;

public enum StatoEsecuzioneAccordo {
	INIZIALE("iniziale") {
		@Override
		public String getColorAttivazione() {
			return "White";
		}
		@Override
		public boolean isAttivazione() {
			return true;
		}
		@Override
		public boolean isAssimilatoStatoInizialeInFiltroStatiRinnovo() {
			return true;
		}
		@Override
		public boolean isGestisceOfferta() {
			return false;
		}
	},
	DA_RINNOVARE("da rinnovare") {
		@Override
		public boolean isAttivazione() {
			return true;
		}
		@Override
		public boolean isVisibleInFiltroStatiRinnovo() {
			return false;
		}
		@Override
		public boolean isAssimilatoStatoInizialeInFiltroStatiRinnovo() {
			return true;
		}
		@Override
		public boolean isPerDocentePresoInCaricoDaUfficio() {
			return true;
		}
	},
	PRESO_IN_CARICO("preso in carico"){
		@Override
		public String getColor() {
			return "Yellow";
		}
		@Override
		public boolean isAttivazione() {
			return false;
		}
		@Override
		public boolean isPerDocentePresoInCaricoDaUfficio() {
			return true;
		}
	},
	INVIATO("inviato") {
		@Override
		public String getColor() {
			return "GreenYellow";
		}
		@Override
		public boolean isAttivazione() {
			return false;
		}
		@Override
		public boolean isPerDocentePresoInCaricoDaUfficio() {
			return true;
		}
	},
	RINNOVATO("rinnovato") {
		@Override
		public String getColor() {
			return "Green";
		}
		@Override
		public boolean isAttivazione() {
			return false;
		}
		@Override
		public boolean isPerDocentePresoInCaricoDaUfficio() {
			return true;
		}
	},
	RIFIUTATO("rifiutato") {
		@Override
		public String getColor() {
			return "DarkRed";
		}
		@Override
		public boolean isAttivazione() {
			return false;
		}
		@Override
		public boolean isPerDocentePresoInCaricoDaUfficio() {
			return false;
		}
		@Override
		public boolean isGestisceOfferta() {
			return false;
		}
		@Override
		public String getColorAttivazione() {
			return "Maroon";
		}
	},
	NON_DA_RINNOVARE("non da rinnovare") {
		@Override
		public String getColor() {
			return "Red";
		}
		@Override
		public String getColorAttivazione() {
			return "Red";
		}
		@Override
		public boolean isAttivazione() {
			return true;
		}
		@Override
		public boolean isGestisceOfferta() {
			return false;
		}
	};
	
	private String valore;
	
	StatoEsecuzioneAccordo(String v) {valore = v;}

	public String getValore() {
		return valore;
	}
	
	public String getColor() {return "White";}
	public String getColorAttivazione() {return "Green";}
	public String getMessageKey(){return getMessageKey(this.getValore());}
	public String getMessageKeyAttivazione(){return getMessageKeyAttivazione(this.getValore());}
	public abstract boolean isAttivazione();
	public boolean isPerDocentePresoInCaricoDaUfficio() {return false;}
	public boolean isVisibleInFiltroStatiRinnovo() {return true;}
	public boolean isAssimilatoStatoInizialeInFiltroStatiRinnovo() {return false;}
	public boolean isGestisceOfferta() {return true;}

	static public StatoEsecuzioneAccordo get(String stato) {return valueOf(stato.toUpperCase().replace(" ", "_"));}

	static public String getMessageKey(String stato){
		if (StringUtils.isEmpty(stato))
			return "esecuzioneAccordo.stato.iniziale"; 
		else 
			return "esecuzioneAccordo.stato."+stato.toLowerCase().replace(" ", "");
	}
	
	static public String getMessageKeyAttivazione(String stato){
		return getMessageKey(stato) + ".attivazione";
	}
}

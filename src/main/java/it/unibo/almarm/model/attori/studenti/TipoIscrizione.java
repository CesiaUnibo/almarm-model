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
package it.unibo.almarm.model.attori.studenti;

public enum TipoIscrizione {
	IN_CORSO('C') {
		@Override
		public String getMessageKey() {
			return "tipoIscrizione.label.inCorso";
		}
	},
	FUORI_CORSO('F') {
		@Override
		public String getMessageKey() {
			return "tipoIscrizione.label.fuoriCorso";
		}
	},
	RIPETENTE('R') {
		@Override
		public String getMessageKey() {
			return "tipoIscrizione.label.ripetente";
		}
	},
	CONDIZIONATO('S') {
		@Override
		public String getMessageKey() {
			return "tipoIscrizione.label.condizionato";
		}
	},
	NON_DEFINITO('U') {
		@Override
		public String getMessageKey() {
			return "tipoIscrizione.label.nonDefinto";
		}
	};
	
	private Character tipo;
	
	private TipoIscrizione(Character isc) {
		tipo=isc;
	}
	
	public static TipoIscrizione getTipoIscrizione(Character c)
	{
		if (c!=null)
			for (TipoIscrizione el: TipoIscrizione.values())
				if (el.tipo.equals(c))
					return el;
		return NON_DEFINITO;
	}

	public abstract String getMessageKey();
}

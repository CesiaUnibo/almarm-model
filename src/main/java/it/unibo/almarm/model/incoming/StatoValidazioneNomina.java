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

public enum StatoValidazioneNomina {
	DA_VALIDARE {

		@Override
		public boolean isValidato() {
			return false;
		}

		@Override
		public boolean isRifiutato() {
			return false;
		}

		@Override
		public String getValore() {
			return "da validare";
		}

		@Override
		public boolean isDaValidare() {
			return true;
		}
		
	},
	VALIDATO {
		@Override
		public boolean isValidato() {
			return true;
		}

		@Override
		public boolean isRifiutato() {
			return false;
		}

		@Override
		public String getValore() {
			return "validato";
		}

		@Override
		public boolean isDaValidare() {
			return false;
		}
	},
	RIFIUTATO {

		@Override
		public boolean isValidato() {
			return false;
		}

		@Override
		public boolean isRifiutato() {
			return true;
		}

		@Override
		public String getValore() {
			return "rifiutato";
		}

		@Override
		public boolean isDaValidare() {
			return false;
		}
		
	}
	;
	
	public abstract boolean isDaValidare();

	public abstract boolean isValidato();

	public abstract boolean isRifiutato();

	public abstract String getValore();

}

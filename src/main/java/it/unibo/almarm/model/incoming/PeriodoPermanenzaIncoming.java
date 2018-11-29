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

public enum PeriodoPermanenzaIncoming {
	DA_DEFINIRE(null, true){
		@Override
		public String getMessageKey() {
			return "periodoPermanenzaIncoming.label.daDefinire";
		}
	},
	PRIMO_SEMESTRE(1, true){
		@Override
		public String getMessageKey() {
			return "periodoPermanenzaIncoming.label.primoSemestre";
		}
	},
	SECONDO_SEMESTRE(2, true){
		@Override
		public String getMessageKey() {
			return "periodoPermanenzaIncoming.label.secondoSemestre";
		}
	},
	ANNO_INTERO(9, true){
		@Override
		public String getMessageKey() {
			return "periodoPermanenzaIncoming.label.annoIntero";
		}
	},
	INTERO_CORSO(10, false){
		@Override
		public String getMessageKey() {
			return "periodoPermanenzaIncoming.label.interoCorso";
		}
	};
	
	private Integer value;
	private Boolean selezionabileDaStudente;
	
	private PeriodoPermanenzaIncoming(Integer value, Boolean selezionabileDaStudente) { this.value = value; this.selezionabileDaStudente = selezionabileDaStudente;}
	
	public abstract String getMessageKey();
	
	public Integer getValue() { return this.value; }
	
	public static PeriodoPermanenzaIncoming get(Integer i) {
		if (i != null)
			for (PeriodoPermanenzaIncoming p: values())
				if (i.equals(p.getValue()))
					return p;
		return DA_DEFINIRE;
	}

	public Boolean getSelezionabileDaStudente() {
		return selezionabileDaStudente;
	}
}

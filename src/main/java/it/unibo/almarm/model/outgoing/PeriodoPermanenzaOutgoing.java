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

public enum PeriodoPermanenzaOutgoing {
	DA_DEFINIRE(null){
		@Override
		public String getMessageKey() {
			return "periodoPermanenzaOutgoing.label.daDefinire";
		}
		
		@Override
		public String getLabelStampa() {
			return "";
		}
		
		@Override
		public String getLabelStampaIng(){
			return "";
		}
		
		@Override
		public String getLabelStampaSpa(){
			return "";
		}
	},
	PRIMO_SEMESTRE(1){
		@Override
		public String getMessageKey() {
			return "periodoPermanenzaOutgoing.label.primoSemestre";
		}
		
		@Override
		public String getLabelStampa() {
			return "un semestre";
		}
		
		@Override
		public String getLabelStampaIng() {
			return "one semester";
		}
		
		@Override
		public String getLabelStampaSpa(){
			return "un semestre";
		}
	},
	SECONDO_SEMESTRE(2){
		@Override
		public String getMessageKey() {
			return "periodoPermanenzaOutgoing.label.secondoSemestre";
		}
		
		@Override
		public String getLabelStampa() {
			return "un semestre";
		}
		
		@Override
		public String getLabelStampaIng(){
			return "one semester";
		}
		
		@Override
		public String getLabelStampaSpa(){
			return "un semestre";
		}
	},
	ANNO_INTERO(9){
		@Override
		public String getMessageKey() {
			return "periodoPermanenzaOutgoing.label.annoIntero";
		}
		
		@Override
		public String getLabelStampa() {
			return "un anno accademico";
		}
		
		@Override
		public String getLabelStampaIng(){
			return "one academic year";
		}
		
		@Override
		public String getLabelStampaSpa(){
			return "un año academico";
		}
	};
	
	private Integer value;
	
	private PeriodoPermanenzaOutgoing(Integer value) { this.value = value; }
	
	public abstract String getMessageKey();
	
	public Integer getValue() { return this.value; }
	
	public abstract String getLabelStampa();
	
	public abstract String getLabelStampaIng();
	
	public abstract String getLabelStampaSpa();
	
	public static PeriodoPermanenzaOutgoing get(Integer i) {
		if (i != null)
			for (PeriodoPermanenzaOutgoing p: values())
				if (i.equals(p.getValue()))
					return p;
		return DA_DEFINIRE;
	}
}

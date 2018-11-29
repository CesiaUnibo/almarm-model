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
package it.unibo.almarm.model.outgoing.learningagreement;

import org.apache.commons.lang.StringUtils;

public enum StatoLearningAgreement {
	DA_PRESENTARE("da presentare") {
		@Override
		public String getColor() {
			return "White";
		}
	},
	PRESENTATO("presentato") {
		@Override
		public String getColor() {
			return "Yellow";
		}
	},
	VALIDATO("validato") {
		@Override
		public String getColor() {
			return "GreenYellow";
		}
	},
	APPROVATO("approvato") {
		@Override
		public String getColor() {
			return "Green";
		}
	},
	RIFIUTATO("rifiutato") {
		@Override
		public String getColor() {
			return "Red";
		}
	},
	SU_RICHIESTA_RICONOSCIMENTO("su richiesta riconoscimento") {
		@Override
		public String getColor() {
			return "Black";
		}
	};
	
	private String valore;
	
	StatoLearningAgreement(String v) {valore = v;}

	public String getValore() {
		return valore;
	}
	
	public String getColor() {return null;}
	public String getMessageKey(){return getMessageKey(this.getValore());}
	static public StatoLearningAgreement get(String stato) {return valueOf(stato.toUpperCase().replace(" ", "_"));}

	static public String getMessageKey(String stato){
		if (StringUtils.isEmpty(stato))
			return "learningAgreement.stato.dapresentare"; 
		else 
			return "learningAgreement.stato."+stato.toLowerCase().replace(" ", "");
	}
	
	static public String[] getElencoStati() {
		StatoLearningAgreement[] sts=StatoLearningAgreement.values();
		String[] stati=new String[sts.length - 1];
		for (int i=0; i<sts.length; i++)
			if (!sts[i].equals(SU_RICHIESTA_RICONOSCIMENTO))
				stati[i]=sts[i].getValore();
		return stati;
	}
}

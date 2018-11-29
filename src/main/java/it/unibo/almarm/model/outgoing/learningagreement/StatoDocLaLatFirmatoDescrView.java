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

public enum StatoDocLaLatFirmatoDescrView {
	NON_PRESENTE("non presente") {
	},
	DA_VALIDARE("da validare") {
	},
	VALIDATO("validato") {
	},
	CARICATO_DA_UFFICI("caricato da uffici") {
	},
	VALIDAZIONE_RIFIUTATA("validazione rifiutata") {
	};

	private String valore;
	
	StatoDocLaLatFirmatoDescrView(String v) {valore = v;}

	public String getValore() {
		return valore;
	}
		
	static public StatoDocLaLatFirmatoDescrView get(String stato) {return valueOf(stato.toUpperCase().replace(" ", "_"));}

	static public String[] getElencoStati() {
		StatoDocLaLatFirmatoDescrView[] sts=StatoDocLaLatFirmatoDescrView.values();
		String[] stati=new String[sts.length];
		for (int i=0; i<sts.length; i++)
			stati[i]=sts[i].getValore();
		return stati;
	}
}

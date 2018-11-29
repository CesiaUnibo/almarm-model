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

import java.util.ArrayList;
import java.util.List;

import it.unibo.almarm.webapp.mvc.CodiceDescrizione;

/*
 * Codici da usare per filtrare la colonna "flagTR" della vista StudenteOutgoingView.
 * Implementa anche i seguenti codici fittizi che poi nell'uso nel pattern 
 * di ricerca vengono trasformati nella lista dei codici singoli:
 * 		X= Validato(V) + caricato dagli uffici quindi valido(U)
 */

public enum  SoFlagToRCoW {

	F_D ('D',"non inserito",false) {
		
	},
	F_S ('S',"da validare",false) {
		
	},
	F_V ('V',"validato",false) {
		
	},
	F_U ('U',"caricato uffici",false) {
		
	},
	F_R ('R',"rifiutato",false) {
		
	},
	// valore fittizio per filtro
	F_X ('X',"valido",true) {
		@Override
		public List<Character> getCodiciFiltro() {
			List<Character> l=new ArrayList<Character>();
			l.add(F_U.getCodice());
			l.add(F_V.getCodice());
			return l;
		}
		
	}	
	;
	
	private String descrizione;
	private Character codice;
	private boolean codiceFittizio;

	SoFlagToRCoW(Character c, String d, boolean p) {codice=c;descrizione=d;codiceFittizio=p;}
	public Character getCodice() {return codice;}
	public String getDescrizione() {return descrizione;}
	public boolean isCodiceFittizio(){return codiceFittizio;}
	public List<Character> getCodiciFiltro() {
		List<Character> l=new ArrayList<Character>();
		l.add(codice);
		return l;
	}
	static public  List<CodiceDescrizione> getListaFiltroToRCoW(){
		 List<CodiceDescrizione> l= new ArrayList<CodiceDescrizione>();
		 l.add(new CodiceDescrizione(F_D.getCodice(), F_D.getDescrizione()));
		 l.add(new CodiceDescrizione(F_S.getCodice(), F_S.getDescrizione()));
		 l.add(new CodiceDescrizione(F_X.getCodice(), F_X.getDescrizione()));
		 l.add(new CodiceDescrizione(F_R.getCodice(), F_R.getDescrizione()));
		 return l;
	}

	static public  List<CodiceDescrizione> getCodDescrValoriFlagToRCoW(){
		SoFlagToRCoW vals[]= SoFlagToRCoW.values();
		List<CodiceDescrizione> l= new ArrayList<CodiceDescrizione>();
		for (SoFlagToRCoW v:vals)
			if (!v.isCodiceFittizio())
				 l.add(new CodiceDescrizione(v.getCodice(), v.getDescrizione()));
				
		 return l;
	}

	static public SoFlagToRCoW get(Character c) {
		if (c==null)
			return null;
		return valueOf("F_"+c.toString().toUpperCase());
	}
}

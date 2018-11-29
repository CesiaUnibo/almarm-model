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
package it.unibo.almarm.model.accordi;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.text.DateFormatter;

import org.apache.commons.lang.StringUtils;

public enum StatoAccordo 
{
	INIZIALE("iniziale") {
		@Override
		public String getColor() {
			return "White";
		}
	},
	PRESA_IN_CARICO("presa in carico"){
		@Override
		public String getColor() {
			return "Yellow";
		}
	},
	APPROVATA("approvata"){
		@Override
		public String getColor() {
			return "GreenYellow";
		}
	},
	STIPULATA("stipulata"){
		@Override
		public String getColor() {
			return "Green";
		}
		@Override
		public String getData(Accordo accordo) {
			DateFormatter df = new DateFormatter();
			df.setFormat(new SimpleDateFormat("dd/MM/yyyy")); 
			try
			{
				return df.valueToString(accordo.getDataStipula());
			}
			catch (ParseException e)
			{
				return "";
			}
		}
	},
	RIFIUTATA("rifiutata"){
		@Override
		public String getColor() {
			return "Red";
		}
	};
	
	private String valore;
	
	StatoAccordo(String v) {valore = v;}

	public String getValore() {
		return valore;
	}
	
	public String getColor() {return null;}
	public String getMessageKey(){return getMessageKey(this.getValore());}
	static public StatoAccordo get(String stato) {return valueOf(stato.toUpperCase().replace(" ", "_"));}

	public String getData(Accordo accordo) {
		DateFormatter df = new DateFormatter();
		df.setFormat(new SimpleDateFormat("dd/MM/yyyy")); 
		try
		{
			return df.valueToString(accordo.getDataInserimento());
		}
		catch (ParseException e)
		{
			return "";
		}
	}
	static public String getMessageKey(String stato){
		if (StringUtils.isEmpty(stato))
			return "accordo.stato.iniziale"; 
		else 
			return "accordo.stato."+stato.toLowerCase().replace(" ", "");
	}
	
	static public String[] getElencoStati() {
		StatoAccordo[] sts=StatoAccordo.values();
		String[] stati=new String[sts.length];
		for (int i=0; i<sts.length; i++)
			stati[i]=sts[i].getValore();
		return stati;
	}

}

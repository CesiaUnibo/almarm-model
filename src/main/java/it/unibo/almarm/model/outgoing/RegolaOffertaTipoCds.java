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


public class RegolaOffertaTipoCds implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private TipoCdsOfferta tipoCdsOfferta;
	private Character flagAnno1;
	private Character flagAnno2;
	private Character flagAnno3;
	private Character flagAnno4;
	private Character flagAnno5;
	private Character flagAnno6;
	
	private Character scelto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoCdsOfferta getTipoCdsOfferta() {
		return tipoCdsOfferta;
	}
	public void setTipoCdsOfferta(TipoCdsOfferta tipoCdsOfferta) {
		this.tipoCdsOfferta = tipoCdsOfferta;
	}
	public Character getFlagAnno1() {
		return leggiFlagSN(flagAnno1);
	}
	public void setFlagAnno1(Character flagAnno1) {
		this.flagAnno1 = flagAnno1;
	}
	public Character getFlagAnno2() {
		return leggiFlagSN(flagAnno2);
	}
	public void setFlagAnno2(Character flagAnno2) {
		this.flagAnno2 = flagAnno2;
	}
	public Character getFlagAnno3() {
		return leggiFlagSN(flagAnno3);
	}
	public void setFlagAnno3(Character flagAnno3) {
		this.flagAnno3 = flagAnno3;
	}
	public Character getFlagAnno4() {
		return leggiFlagSN(flagAnno4);
	}
	public void setFlagAnno4(Character flagAnno4) {
		this.flagAnno4 = flagAnno4;
	}
	public Character getFlagAnno5() {
		return leggiFlagSN(flagAnno5);
	}
	public void setFlagAnno5(Character flagAnno5) {
		this.flagAnno5 = flagAnno5;
	}
	public Character getFlagAnno6() {
		return leggiFlagSN(flagAnno6);
	}
	
	public void setFlagAnno6(Character flagAnno6) {
		this.flagAnno6 = flagAnno6;
	}
	
	public void setScelto(Character scelto) {
		this.scelto=scelto;
		/*
		if (!( new Character('S')).equals(scelto))
		{
			setFlagAnno1('N');
			setFlagAnno2('N');
			setFlagAnno3('N');
			setFlagAnno4('N');
			setFlagAnno5('N');
			setFlagAnno6('N');
		}*/
	}
	
	public Character getScelto() {
		return leggiFlagSN(scelto);
	}	
	
	public boolean isNullScelto() {
		return scelto==null; 	 
	}
	
	public boolean isSelezionato() {
	  return new Character('S').equals(getScelto()); 	 
	}
	
	public boolean isValid() {
		Character si=new Character('S');
		return((tipoCdsOfferta!=null)
			&& (si.equals(flagAnno1)||si.equals(flagAnno2)||si.equals(flagAnno3)
  			    ||si.equals(flagAnno4)||si.equals(flagAnno5)||si.equals(flagAnno6)));
	}
	
	private Character leggiFlagSN(Character flagSN)
	{
		return (flagSN==null) ? 'N' : flagSN;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((tipoCdsOfferta == null) ? 0 : tipoCdsOfferta.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RegolaOffertaTipoCds))
			return false;
		RegolaOffertaTipoCds other = (RegolaOffertaTipoCds) obj;
		if (tipoCdsOfferta == null) {
			if (other.tipoCdsOfferta != null)
				return false;
		} else if (!tipoCdsOfferta.equals(other.tipoCdsOfferta))
			return false;
		return true;
	}
	
	public String getLabel() {
		String txt = "";
		if (Common.CH_S.equals(getFlagAnno1()))
			txt += "1 ";
		if (Common.CH_S.equals(getFlagAnno2()))
			txt += "2 ";
		if (Common.CH_S.equals(getFlagAnno3()))
			txt += "3 ";
		if (Common.CH_S.equals(getFlagAnno4()))
			txt += "4 ";
		if (Common.CH_S.equals(getFlagAnno5()))
			txt += "5 ";
		if (Common.CH_S.equals(getFlagAnno6()))
			txt += "6 ";
		return txt;
	}
	
}

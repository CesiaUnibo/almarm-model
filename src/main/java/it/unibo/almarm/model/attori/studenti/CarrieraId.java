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

public class CarrieraId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	//NOTE: 
	// per creare la realzione many-to-one tra esami e carriera in hiberante la carriera ed esami devono 
	// condividere la chiave primaria (ho fatto alcune prove e sembra che hibernate accetti solo la primaria)
	// , o piu precisamente: i campi della chiave primaria carriera devono essere nella chiave primaria di esami.
	// La tab esami attualmente non e' in join con anagrafica e quindi non puo' esporre idanagrafica e non espone
	// nemmeno tipoCarriera.
	// ==>al momento visto che non sussiste ancora il problema di gestire carriere di attori che NON possiedono pincode
	// e che non siano studenti  usero' pincode nella chiave primaria e faro' a meno di idAnagrafica e tipoCarriera; 
	// Successivamente se nascera' la necessita' occorrera' forse che esami abbia un Join con Anagrafica oppure rinunciare ù
	// a descrivere in carriera la relazione con esami! cioe'fare le query applicativamente qundo necessaria
	
	private Integer pincode;
	private Integer numeroCarriera;
	//private String tipoCarriera; // TODO : ora la vista estrae solo tipo 'ST'(carr studente) quindi tipoCarriera potrebbe essere tolta dalla chiave
	
	public CarrieraId() {
	}
	
	public CarrieraId(Integer pincode, Integer numeroCarriera)
	{
		//this.idAnagrafica = idAnagrafica;
		this.pincode=pincode;
		this.numeroCarriera = numeroCarriera;
		//this.tipoCarriera = tipoCarriera;
	}
	
	public Integer getNumeroCarriera() {
		return numeroCarriera;
	}
	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public void setNumeroCarriera(Integer numeroCarriera) {
		this.numeroCarriera = numeroCarriera;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numeroCarriera == null) ? 0 : numeroCarriera.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CarrieraId))
			return false;
		CarrieraId other = (CarrieraId) obj;
		if (numeroCarriera == null) {
			if (other.numeroCarriera != null)
				return false;
		} else if (!numeroCarriera.equals(other.numeroCarriera))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		return true;
	}
}

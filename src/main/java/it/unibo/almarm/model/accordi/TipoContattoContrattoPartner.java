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

public enum  TipoContattoContrattoPartner {

	ISCHEET_VISA(ContattoContrattoPartner.TIPO_CONTATTO_ISHEET_VISA)
	{},
	ISCHEET_INSURANCE(ContattoContrattoPartner.TIPO_CONTATTO_ISHEET_INSURANCE)
	{},
	ISHEET_HOUSING (ContattoContrattoPartner.TIPO_CONTATTO_ISHEET_HOUSING)
	{},
	ISHEET_OUT_NOMINATION_FAC (ContattoContrattoPartner.TIPO_CONTATTO_ISHEET_OUT_NOMINATION)
	{},
	ALTRO_UFFICIO_ACCORDI (ContattoContrattoPartner.TIPO_CONTATTO_ALTRO_UFFICIO_ACCORDI)
	{},
	TIPO_CONTATTO_NUOVO_REF_ESTERNO (ContattoContrattoPartner.TIPO_CONTATTO_NUOVO_REF_ESTERNO) {
		@Override
		public boolean isRequired (){return false;}
	}
	;

	private String valore;
	public String getValore() {
		return valore;
	}
	TipoContattoContrattoPartner(String v) {valore = v;}

	public boolean isRequired (){return true;}
/*
	static public String[] getElencoTipi() {
		TipoContattoContrattoPartner[] tipi=TipoContattoContrattoPartner.values();
		String[] lista=new String[tipi.length];
		for (int i=0; i<tipi.length; i++)
			lista[i]=tipi[i].getValore();
		return lista;
	}*/
}

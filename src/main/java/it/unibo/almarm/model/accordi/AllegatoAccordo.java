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

import java.util.Objects;

public class AllegatoAccordo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String DESCRIZIONE_DOCUMENTO_STIPULA = "Documento stipula";
	
	private Long id;
	private String allegato;
	private String descrizione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAllegato() {
		return allegato;
	}

	public void setAllegato(String allegato) {
		this.allegato = allegato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, allegato);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AllegatoAccordo that = (AllegatoAccordo) o;
		if (getId()!=null) {
			if (that.getId()!=null) {
				return Objects.equals(getId(), that.getId());
			} else {
				return false;
			}
		} else {
			if (that.getId()!=null) {
				return false;
			} else {
				return Objects.equals(getAllegato(), that.getAllegato());
			}
		}
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Boolean isDocumentoStipula()
	{
		return DESCRIZIONE_DOCUMENTO_STIPULA.equals(descrizione);
	}

}

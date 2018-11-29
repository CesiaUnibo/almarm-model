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

import java.util.Date;

import it.unibo.almarm.model.attori.Dipartimento;
import it.unibo.almarm.util.Common;

public class AccordoDipartimento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long  id;	
	private Dipartimento dipartimento;
	private Date dataInserimento;
//	private AccordoOperativo accordoOperativo; // al momento il mapping inverso non serve:
	
	// Al momento l'informazione "responsabile" non e' persistita, 
	// la valorizzo dal manager nei casi in cui ne ho bisogno nella pagina
	private boolean responsabile; 
	
	public AccordoDipartimento (){
	}
	
	public AccordoDipartimento (AccordoOperativo ao, Dipartimento dip ){
	//	this.accordoOperativo = ao;
		this.dipartimento = dip;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	
	public boolean isResponsabile() {
		return responsabile;
	}

	public void setResponsabile(boolean responsabile) {
		this.responsabile = responsabile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dipartimento == null) ? 0 : dipartimento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AccordoDipartimento))
			return false;
		AccordoDipartimento other = (AccordoDipartimento) obj;
		if (dipartimento == null) {
			if (other.dipartimento != null)
				return false;
		} else if (!dipartimento.equals(other.dipartimento))
			return false;
		return true;
	}
}

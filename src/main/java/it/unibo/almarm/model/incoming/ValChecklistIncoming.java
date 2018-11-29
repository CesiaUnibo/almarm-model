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
package it.unibo.almarm.model.incoming;

import it.unibo.almarm.model.ValChecklist;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class ValChecklistIncoming implements ValChecklist, java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private ElChecklistIncoming elementoChecklist;
	private Integer completato = 0;
	private Date data;
	private String note;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ElChecklistIncoming getElementoChecklist() {
		return elementoChecklist;
	}

	public void setElementoChecklist(ElChecklistIncoming elementoChecklist) {
		this.elementoChecklist = elementoChecklist;
	}

	public Integer getCompletato() {
		
		return (completato==null) ? new Integer(0) :completato;
	}

	public void setCompletato(Integer completato) {
		this.completato = completato;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getCompleto()
	{
		if (this.completato != null)
			return this.completato.equals(1);
		return false;
	}
	
	public Boolean isValid()
	{
		 return (data!=null || StringUtils.isNotBlank(note) || ((completato!=null) && !completato.equals(new Integer(0))));
	}
	
	public Integer getPosizione()
	{
		return getElementoChecklist().getPosizione(); 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((elementoChecklist == null) ? 0 : elementoChecklist
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ValChecklistIncoming))
			return false;
		ValChecklistIncoming other = (ValChecklistIncoming) obj;
		if (elementoChecklist == null) {
			if (other.elementoChecklist != null)
				return false;
		} else if (!elementoChecklist.equals(other.elementoChecklist))
			return false;
		return true;
	}
}

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
package it.unibo.almarm.model.email;

import it.unibo.almarm.model.accordi.Coorte;

public class DestinatarioEmailCoorte implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Coorte coorte;
	private DestinatarioEmail destinatarioEmail;
	private TemplateEmail templateEmail;
	private Long ordine;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DestinatarioEmailCoorte other = (DestinatarioEmailCoorte) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setCoorte(Coorte coorte) {
		this.coorte = coorte;
	}

	public Coorte getCoorte() {
		return coorte;
	}

	public void setDestinatarioEmail(DestinatarioEmail destinatarioEmail) {
		this.destinatarioEmail = destinatarioEmail;
	}

	public DestinatarioEmail getDestinatarioEmail() {
		return destinatarioEmail;
	}

	public void setTemplateEmail(TemplateEmail templateEmail) {
		this.templateEmail = templateEmail;
	}

	public TemplateEmail getTemplateEmail() {
		return templateEmail;
	}

	public void setOrdine(Long ordine) {
		this.ordine = ordine;
	}

	public Long getOrdine() {
		return ordine;
	}

}

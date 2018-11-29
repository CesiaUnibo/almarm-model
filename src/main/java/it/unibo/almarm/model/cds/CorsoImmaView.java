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
package it.unibo.almarm.model.cds;



public class CorsoImmaView implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;	
	private Long codScuola;
	private String codCorso;
	private String descrizione;
	private TipoCds tipoCds;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCodCorso() {
		return codCorso;
	}
	
	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public TipoCds getTipoCds() {
		return tipoCds;
	}

	public void setTipoCds(TipoCds tipoCds) {
		this.tipoCds = tipoCds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codCorso == null) ? 0 : codCorso.hashCode());
		result = prime * result + ((codScuola == null) ? 0 : codScuola.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CorsoImmaView))
			return false;
		CorsoImmaView other = (CorsoImmaView) obj;
		if (id != null && other.id != null
			&& (!id.equals(other.id)))
			return false;
		if (codCorso == null) {
			if (other.codCorso != null)
				return false;
		} else if (!codCorso.equals(other.codCorso))
			return false;
		if (codScuola == null) {
			if (other.codScuola != null)
				return false;
		} else if (!codScuola.equals(other.codScuola))
			return false;
		return true;
	}

	public Long getCodScuola() {
		return codScuola;
	}

	public void setCodScuola(Long codScuola) {
		this.codScuola = codScuola;
	}
	
	public String getLabel() {
		return codCorso + " - " + descrizione;
	}
}

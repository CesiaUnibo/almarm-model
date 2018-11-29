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

public class MediaFacoltaId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long idBando;
	private Integer annoAccademico;
	private String codFac;

	public Long getIdBando() {
		return idBando;
	}

	public void setIdBando(Long idBando) {
		this.idBando = idBando;
	}

	public Integer getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(Integer annoAccademico) {
		this.annoAccademico = annoAccademico;
	}

	public String getCodFac() {
		return codFac;
	}

	public void setCodFac(String codFac) {
		this.codFac = codFac;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annoAccademico == null) ? 0 : annoAccademico.hashCode());
		result = prime * result + ((codFac == null) ? 0 : codFac.hashCode());
		result = prime * result + ((idBando == null) ? 0 : idBando.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MediaFacoltaId))
			return false;
		MediaFacoltaId other = (MediaFacoltaId) obj;
		if (annoAccademico == null) {
			if (other.annoAccademico != null)
				return false;
		} else if (!annoAccademico.equals(other.annoAccademico))
			return false;
		if (codFac == null) {
			if (other.codFac != null)
				return false;
		} else if (!codFac.equals(other.codFac))
			return false;
		if (idBando == null) {
			if (other.idBando != null)
				return false;
		} else if (!idBando.equals(other.idBando))
			return false;
		return true;
	}
}

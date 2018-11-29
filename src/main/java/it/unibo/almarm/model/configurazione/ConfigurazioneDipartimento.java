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
package it.unibo.almarm.model.configurazione;

import it.unibo.almarm.model.attori.Dipartimento;

public class ConfigurazioneDipartimento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Dipartimento dipartimento;
	private String nomeParametro;
	private String valore;

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

	public String getNomeParametro() {
		return nomeParametro;
	}

	public void setNomeParametro(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dipartimento == null) ? 0 : dipartimento.hashCode());
		result = prime * result + ((nomeParametro == null) ? 0 : nomeParametro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ConfigurazioneDipartimento))
			return false;
		ConfigurazioneDipartimento other = (ConfigurazioneDipartimento) obj;
		if (dipartimento == null) {
			if (other.dipartimento != null)
				return false;
		} else if (!dipartimento.equals(other.dipartimento))
			return false;
		if (nomeParametro == null) {
			if (other.nomeParametro != null)
				return false;
		} else if (!nomeParametro.equals(other.nomeParametro))
			return false;
		return true;
	}
}

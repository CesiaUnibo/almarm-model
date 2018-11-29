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

public class DomandaRegistrazioneIncoming implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String testo;
	private String testoIng;
	private Character flagAttiva;
	private Character flagObbligatoria;
	private Integer ordinamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getTestoIng() {
		return testoIng;
	}

	public void setTestoIng(String testoIng) {
		this.testoIng = testoIng;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((testo == null) ? 0 : testo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DomandaRegistrazioneIncoming))
			return false;
		DomandaRegistrazioneIncoming other = (DomandaRegistrazioneIncoming) obj;
		if (testo == null) {
			if (other.testo != null)
				return false;
		} else if (!testo.equals(other.testo))
			return false;
		return true;
	}

	public Character getFlagAttiva() {
		return flagAttiva;
	}

	public void setFlagAttiva(Character flagAttiva) {
		this.flagAttiva = flagAttiva;
	}

	public Character getFlagObbligatoria() {
		return flagObbligatoria;
	}

	public void setFlagObbligatoria(Character flagObbligatoria) {
		this.flagObbligatoria = flagObbligatoria;
	}

	public Integer getOrdinamento() {
		return ordinamento;
	}

	public void setOrdinamento(Integer ordinamento) {
		this.ordinamento = ordinamento;
	}
	
	public boolean isObbligatoria() {
		return (new Character('S')).equals(flagObbligatoria);
	}
}

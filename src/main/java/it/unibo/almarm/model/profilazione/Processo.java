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
package it.unibo.almarm.model.profilazione;

import it.unibo.almarm.model.flussiscambio.PeriodoMobilita;

import java.util.Date;

public class Processo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private PeriodoMobilita periodoMobilita;
	private Date dataFinePeriodoMobilitaPrecedente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Processo))
			return false;
		Processo other = (Processo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public PeriodoMobilita getPeriodoMobilita() {
		return periodoMobilita;
	}

	public void setPeriodoMobilita(PeriodoMobilita periodoMobilita) {
		this.periodoMobilita = periodoMobilita;
	}

	public Date getDataFinePeriodoMobilitaPrecedente() {
		return dataFinePeriodoMobilitaPrecedente;
	}

	public void setDataFinePeriodoMobilitaPrecedente(
			Date dataFinePeriodoMobilitaPrecedente) {
		this.dataFinePeriodoMobilitaPrecedente = dataFinePeriodoMobilitaPrecedente;
	}
}

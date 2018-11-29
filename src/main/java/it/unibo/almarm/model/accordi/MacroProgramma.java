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

import java.util.HashSet;
import java.util.Set;

public class MacroProgramma  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Long annoInizioValidita;
	private Long annoFineValidita;
	private String sigla;
	private String descrizione;

	private Set<Programma> programmi = new HashSet<Programma>();

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
	public Long getAnnoInizioValidita() {
		return annoInizioValidita;
	}
	public void setAnnoInizioValidita(Long annoInizioValidita) {
		this.annoInizioValidita = annoInizioValidita;
	}
	public Long getAnnoFineValidita() {
		return annoFineValidita;
	}
	public void setAnnoFineValidita(Long annoFineValidita) {
		this.annoFineValidita = annoFineValidita;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Set<Programma> getProgrammi() {
		return programmi;
	}

	public void setProgrammi(Set<Programma> programmi) {
		this.programmi = programmi;
	}

	public MacroProgramma()	{
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((annoInizioValidita == null) ? 0 : annoInizioValidita.hashCode());
		result = prime
				* result
				+ ((annoFineValidita == null) ? 0 : annoFineValidita.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MacroProgramma))
			return false;
		MacroProgramma other = (MacroProgramma) obj;
		if (nome == null) {
			if (other.getNome() != null)
				return false;
		} else if (!nome.equals(other.getNome()))
			return false;
		if (annoInizioValidita == null) {
			if (other.getAnnoInizioValidita() != null)
				return false;
		} else if (!annoInizioValidita.equals(other.getAnnoInizioValidita()))
			return false;
		if (annoFineValidita == null) {
			if (other.getAnnoFineValidita() != null)
				return false;
		} else if (!annoFineValidita.equals(other.getAnnoFineValidita()))
			return false;
		return true;
	}
}

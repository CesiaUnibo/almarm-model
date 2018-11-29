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

import java.util.Date;

import it.unibo.almarm.model.attori.Persona;

public class NominaApprovazione implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Nomina nomina;
	private String statoApprovazione;
	private Persona autoreRichiestaApprovazione;
	private Date dataRichiestaApprovazione;
	private Persona autoreApprovazione;
	private Date dataApprovazione;
	private Persona autoreRifiuto;
	private Date dataRifiuto;
	private String noteRifiuto;
	private String noteApprovazione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Nomina getNomina() {
		return nomina;
	}

	public void setNomina(Nomina nomina) {
		this.nomina = nomina;
	}

	public String getStatoApprovazione() {
		return statoApprovazione;
	}

	public void setStatoApprovazione(String statoApprovazione) {
		this.statoApprovazione = statoApprovazione;
	}

	public Persona getAutoreRichiestaApprovazione() {
		return autoreRichiestaApprovazione;
	}

	public void setAutoreRichiestaApprovazione(Persona autoreRichiestaApprovazione) {
		this.autoreRichiestaApprovazione = autoreRichiestaApprovazione;
	}

	public Date getDataRichiestaApprovazione() {
		return dataRichiestaApprovazione;
	}

	public void setDataRichiestaApprovazione(Date dataRichiestaApprovazione) {
		this.dataRichiestaApprovazione = dataRichiestaApprovazione;
	}

	public Persona getAutoreApprovazione() {
		return autoreApprovazione;
	}

	public void setAutoreApprovazione(Persona autoreApprovazione) {
		this.autoreApprovazione = autoreApprovazione;
	}

	public Date getDataApprovazione() {
		return dataApprovazione;
	}

	public void setDataApprovazione(Date dataApprovazione) {
		this.dataApprovazione = dataApprovazione;
	}

	public Persona getAutoreRifiuto() {
		return autoreRifiuto;
	}

	public void setAutoreRifiuto(Persona autoreRifiuto) {
		this.autoreRifiuto = autoreRifiuto;
	}

	public Date getDataRifiuto() {
		return dataRifiuto;
	}

	public void setDataRifiuto(Date dataRifiuto) {
		this.dataRifiuto = dataRifiuto;
	}

	public String getNoteRifiuto() {
		return noteRifiuto;
	}

	public void setNoteRifiuto(String noteRifiuto) {
		this.noteRifiuto = noteRifiuto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomina == null) ? 0 : nomina.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NominaApprovazione))
			return false;
		NominaApprovazione other = (NominaApprovazione) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomina == null) {
			if (other.nomina != null)
				return false;
		} else if (!nomina.equals(other.nomina))
			return false;
		return true;
	}

	public String getNoteApprovazione() {
		return noteApprovazione;
	}

	public void setNoteApprovazione(String noteApprovazione) {
		this.noteApprovazione = noteApprovazione;
	}
}

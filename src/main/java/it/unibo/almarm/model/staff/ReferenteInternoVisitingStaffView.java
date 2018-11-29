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
package it.unibo.almarm.model.staff;

import it.unibo.almarm.util.Common;

public class ReferenteInternoVisitingStaffView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer matricola;
	private String cognome;
	private String nome;
	private String codiceFiscale;
	private Long idUnitaOrg;
	private String descrizioneUnitaOrg;
	private Character flagDipartimento;
	private Long idSede;
	private String fulltext;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMatricola() {
		return matricola;
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Long getIdUnitaOrg() {
		return idUnitaOrg;
	}

	public void setIdUnitaOrg(Long idUnitaOrg) {
		this.idUnitaOrg = idUnitaOrg;
	}

	public String getDescrizioneUnitaOrg() {
		return descrizioneUnitaOrg;
	}

	public void setDescrizioneUnitaOrg(String descrizioneUnitaOrg) {
		this.descrizioneUnitaOrg = descrizioneUnitaOrg;
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
		if (!(obj instanceof ReferenteInternoVisitingStaffView))
			return false;
		ReferenteInternoVisitingStaffView other = (ReferenteInternoVisitingStaffView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getFulltext() {
		return fulltext;
	}

	public void setFulltext(String fulltext) {
		this.fulltext = fulltext;
	}

	public Long getIdSede() {
		return idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}

	public Character getFlagDipartimento() {
		return flagDipartimento;
	}

	public void setFlagDipartimento(Character flagDipartimento) {
		this.flagDipartimento = flagDipartimento;
	}
	
	public boolean isDipartimento() {
		return Common.CH_S.equals(getFlagDipartimento());
	}
}

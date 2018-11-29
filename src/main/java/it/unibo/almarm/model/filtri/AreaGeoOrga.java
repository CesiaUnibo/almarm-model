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
package it.unibo.almarm.model.filtri;

import java.util.HashSet;
import java.util.Set;

import it.unibo.almarm.model.attori.StrutturaAmministrativa;
import it.unibo.almarm.model.luoghi.Nazione;

public class AreaGeoOrga implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String descrizione;
	private StrutturaAmministrativa strutturaAmministrativa;
	private Set<Nazione> nazioni = new HashSet<Nazione>();
	
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
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public StrutturaAmministrativa getStrutturaAmministrativa() {
		return strutturaAmministrativa;
	}
	public void setStrutturaAmministrativa(StrutturaAmministrativa strutturaAmministrativa) {
		this.strutturaAmministrativa = strutturaAmministrativa;
	}
	public Set<Nazione> getNazioni() {
		return nazioni;
	}
	public void setNazioni(Set<Nazione> nazioni) {
		this.nazioni = nazioni;
	}
}

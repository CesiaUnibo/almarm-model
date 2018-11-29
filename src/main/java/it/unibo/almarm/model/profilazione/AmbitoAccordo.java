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

import java.io.Serializable;


public class AmbitoAccordo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final long 	ID_TIROCINIO = 1L;
	public static final long  	ID_RICERCA = 2L;
	public static final long 	ID_ALTA_FORMAZIONE = 3L;
	public static final long 	ID_ELENCO_FORNITORI = 4L;
	public static final long 	ID_ACCREDITAMENTO = 5L;
	public static final long 	ID_MOBILITA_INTERNAZIONALE = 6L;
	
	private Long id;
	private String nome;
	private String nomeIng;
	
	// campo utilizzato a livello di presentazione per disabilitare in modo selettivo gli ambiti
	private boolean disabled;
	
	public AmbitoAccordo()
	{
		
	}
	
	public AmbitoAccordo(Long id)
	{
		this.id=id;
	}

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
	
	public String getNomeIng() {
		return nomeIng;
	}

	public void setNomeIng(String nomeIng) {
		this.nomeIng = nomeIng;
	}

	public String toString()
	{
		return String.valueOf(id);
	}
	
	public boolean isTirocinio(){
		return getId().equals(ID_TIROCINIO);
	}
	
	public boolean isRicerca(){
		return getId().equals(ID_RICERCA);
	}
	
	public boolean isAltaFormazione(){
		return getId().equals(ID_ALTA_FORMAZIONE);
	}

	public boolean isMobilitaInternazionale(){
		return getId().equals(ID_MOBILITA_INTERNAZIONALE);
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
		if (!(obj instanceof AmbitoAccordo))
			return false;
		final AmbitoAccordo other = (AmbitoAccordo) obj;
		if (nome == null) {
			if (other.getNome() != null)
				return false;
		} else if (!nome.equals(other.getNome()))
			return false;
		return true;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
}

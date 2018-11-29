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
package it.unibo.almarm.model.esterni;

import java.util.Comparator;

import it.unibo.almarm.model.profilazione.AmbitoAccordo;
import it.unibo.almarm.util.Common;

public class TipoUfficio implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Long ID_TIPO_ACCORDI_CONVENZIONI = 2L;

	@SuppressWarnings("unused")
	private static final Long ID_MACROTIPO_INCOMING = 1L; 					// OUTGOING x UNIBO
	@SuppressWarnings("unused")
	private static final Long ID_MACROTIPO_ACCORDI_CONVENZIONI = 2L;
	@SuppressWarnings("unused")
	private static final Long ID_MACROTIPO_MOBILITA_INTERNAZIONALE = 3L;
	@SuppressWarnings("unused")
	private static final Long ID_MACROTIPO_OUTGOING = 4L;					// INCOMIG x UNIBO
	
	protected Long id;
	private AmbitoAccordo ambito;
	private String 	nome;
	private String	descrizione;
	private Integer	posizione;
	private Integer	idMacrotipoUfficio;
	private Character categoria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AmbitoAccordo getAmbito() {
		return ambito;
	}
	public void setAmbito(AmbitoAccordo ambito) {
		this.ambito = ambito;
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
	
	public TipoUfficio() {
	}

	public TipoUfficio(Long id) {
		this.id = id;
	}
	public boolean isAccordiConvenzioni(){
		return ID_TIPO_ACCORDI_CONVENZIONI.equals(id);
	}	

	public Integer getIdMacrotipoUfficio() {
		return idMacrotipoUfficio;
	}
	public void setIdMacrotipoUfficio(Integer idMacrotipoUfficio) {
		this.idMacrotipoUfficio = idMacrotipoUfficio;
	}
	public Character getCategoria() {
		return categoria;
	}
	public void setCategoria(Character categoria) {
		this.categoria = categoria;
	}
	public boolean isCategoriaSottoarea(){
		return Common.CH_S.equals(categoria);
	}
	public boolean isCategoriGenerale(){
		return !Common.CH_S.equals(categoria);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (id != null)
			return prime * result + id.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipoUfficio))
			return false;
		TipoUfficio other = (TipoUfficio) obj;
		if (id != null) 
			return id.equals(other.id);
		else
			return other == null;
	}
	public Integer getPosizione() {
		return posizione;
	}
	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}
	public static class TipoUfficioComparator implements Comparator<TipoUfficio>
	{
		public int compare(TipoUfficio o1, TipoUfficio o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null || o1.getPosizione() == null)
				return 1;
			if (o2 == null || o2.getPosizione() == null)
				return -1;
			return o1.getPosizione().compareTo(o2.getPosizione());
		}
	}
}

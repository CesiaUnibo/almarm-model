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
package it.unibo.almarm.model.attori;

import java.util.Comparator;

public class ContattoUfficio implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private Contatto contatto;
	private Integer flagResponsabile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contatto getContatto() {
		return contatto;
	}

	public void setContatto(Contatto contatto) {
		this.contatto = contatto;
	}

	public Integer getFlagResponsabile() {
		return flagResponsabile;
	}

	public void setFlagResponsabile(Integer flagResponsabile) {
		this.flagResponsabile = flagResponsabile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contatto == null) ? 0 : contatto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ContattoUfficio))
			return false;
		ContattoUfficio other = (ContattoUfficio) obj;
		if (contatto == null) {
			if (other.getContatto() != null)
				return false;
		} else if (!contatto.equals(other.getContatto()))
			return false;
		return true;
	}
	
	public boolean isResponsabile() {
		return !(new Integer(0)).equals(flagResponsabile);
	}
	
	/** disabilita il flag responsabile **/
	public void setNoResponsabile() {
		this.flagResponsabile = 0;
	}
	
	/** abilita il flag responsabile **/
	public void setSiResponsabile() {
		this.flagResponsabile = 1;
	}
	
	public static class ContattoUfficioComparator implements Comparator<ContattoUfficio>
	{
		public int compare(ContattoUfficio o1, ContattoUfficio o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null || o1.getContatto() == null)
				return 1;
			if (o2 == null || o2.getContatto() == null)
				return -1;
			if (o1.getContatto().getCognome().equals(o2.getContatto().getCognome()))
				return o1.getContatto().getNome().compareTo(o2.getContatto().getNome());
			return o1.getContatto().getCognome().compareTo(o2.getContatto().getCognome());
		}
	}
	
}

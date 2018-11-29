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

import it.unibo.almarm.util.Common;

public class StrutturaAmministrativa implements java.io.Serializable {
	private final static Long ID_STRUTTURA_AMMINISTRATIVA_DIRI_AREA_2_O_3 = 18L;

	public static class StrutturaAmministrativaComparator implements Comparator<StrutturaAmministrativa> {

		@Override
		public int compare(StrutturaAmministrativa o1, StrutturaAmministrativa o2) {
			if (o1 != null && o1.getStruttura() != null && o1.getStruttura().getDescrizioneStrutturaAttiva() != null
					&& o2 != null && o2.getStruttura() != null && o2.getStruttura().getDescrizioneStrutturaAttiva() != null)
				return o1.getStruttura().getDescrizioneStrutturaAttiva().getDescrizione().compareTo(o2.getStruttura().getDescrizioneStrutturaAttiva().getDescrizione());
			return 0;
		}

	}

	private static final long serialVersionUID = 1L;

	private Long id;
	private Struttura struttura;
	private String email;
	private Character flagAttiva;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Struttura getStruttura() {
		return struttura;
	}

	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getFlagAttiva() {
		return flagAttiva;
	}

	public void setFlagAttiva(Character flagAttiva) {
		this.flagAttiva = flagAttiva;
	}
	
	public boolean isAttiva() {
		return Common.CH_S.equals(getFlagAttiva());
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
		if (!(obj instanceof StrutturaAmministrativa))
			return false;
		StrutturaAmministrativa other = (StrutturaAmministrativa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean isAreaDueOTre() {
		return ID_STRUTTURA_AMMINISTRATIVA_DIRI_AREA_2_O_3.equals(getId());
	}
}

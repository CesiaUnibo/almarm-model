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
package it.unibo.almarm.model.lingue;

public class MultilinguaDidatticaId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String PER_FACOLTA="FACOLTA";
	public static final String PER_CLASSI_CORSO="CLASSI_CORSO";
	public static final String PER_CLASSI_TIPO_CORSO="CLASSI_TIPO_CORSO";
	
	public static final String LINGUA_INGLESE="en";
	
	
	private String tabRiferimento;
	private String chiave;
	private String lingua;
	
	public String getTabRiferimento() {
		return tabRiferimento;
	}
	
	public void setTabRiferimento(String tabRiferimento) {
		this.tabRiferimento = tabRiferimento;
	}
	
	public String getChiave() {
		return chiave;
	}
	
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	
	public String getLingua() {
		return lingua;
	}
	
	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public static MultilinguaDidatticaId makeIdPerFacolta(String codFac) {
		MultilinguaDidatticaId multilinguaDidatticaId = new	MultilinguaDidatticaId();
		multilinguaDidatticaId.setTabRiferimento(PER_FACOLTA);
		multilinguaDidatticaId.setLingua(LINGUA_INGLESE);
		multilinguaDidatticaId.setChiave(codFac);
		return multilinguaDidatticaId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chiave == null) ? 0 : chiave.hashCode());
		result = prime * result + ((lingua == null) ? 0 : lingua.hashCode());
		result = prime * result
				+ ((tabRiferimento == null) ? 0 : tabRiferimento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MultilinguaDidatticaId))
			return false;
		MultilinguaDidatticaId other = (MultilinguaDidatticaId) obj;
		if (chiave == null) {
			if (other.getChiave() != null)
				return false;
		} else if (!chiave.equals(other.getChiave()))
			return false;
		if (lingua == null) {
			if (other.getLingua() != null)
				return false;
		} else if (!lingua.equals(other.getLingua()))
			return false;
		if (tabRiferimento == null) {
			if (other.getTabRiferimento() != null)
				return false;
		} else if (!tabRiferimento.equals(other.getTabRiferimento()))
			return false;
		return true;
	}

}

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

import it.unibo.almarm.util.Common;

public class Vicepresidenza implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long  id;
	private String descrizione;
	private String sede;
	private Scuola scuola;
	private StrutturaAmministrativa strutturaAmministrativa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDescrizioneEscaped() {
    	return Common.escapeTestoPerInput(getDescrizione());
    }
	public String getDescrizioneEscapedJs() {
    	return Common.escapeTestoPerInput(getDescrizione());
    }

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public Scuola getScuola() {
		return scuola;
	}

	public void setScuola(Scuola scuola) {
		this.scuola = scuola;
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
		if (!(obj instanceof Vicepresidenza))
			return false;
		Vicepresidenza other = (Vicepresidenza) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public static enum SedeVicepresidenza {
		BOLOGNA("Bologna", "BO"),
		RIMINI("Rimini", "RN"),
		CESENA("Cesena", "CE"),
		OZZANO("Ozzano", "BO"),
		FORLI("Forli'", "FO"),
		RAVENNA("Ravenna", "RA");
		
		private String nomeSede;
		private String siglaPolo;
		
		private SedeVicepresidenza(String n, String s) {
			nomeSede = n;
			siglaPolo = s;
		}
		
		public static String getSiglaPolo(String sede) { return get(sede).siglaPolo;}
		
		public String getNome() { return nomeSede;}
		
		public static SedeVicepresidenza get(String nome) { 
			for (SedeVicepresidenza sv: values())
				if (sv.getNome().equals(nome))
					return sv;
			return null;
		}
	}

	public boolean isCampusBologna() {
		return SedeVicepresidenza.getSiglaPolo(getSede()).equals(Campus.ID_BOLOGNA);
	}

	public StrutturaAmministrativa getStrutturaAmministrativa() {
		return strutturaAmministrativa;
	}

	public void setStrutturaAmministrativa(StrutturaAmministrativa strutturaAmministrativa) {
		this.strutturaAmministrativa = strutturaAmministrativa;
	}
}

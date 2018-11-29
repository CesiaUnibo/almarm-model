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
package it.unibo.almarm.model.attori.studenti;

import it.unibo.almarm.model.flussiscambio.AreaDisciplinare;

import org.apache.commons.lang.StringUtils;

public class Corso  implements java.io.Serializable {
	private static final long serialVersionUID = 2L;
	
	public static final String CORSO_ERASMUS="1900";
	
	private String id;
	private String descrizione;
	private String descrizioneAbbreviata;
	private Long idCorso;
	private CorsoView corsoView;
	private AreaDisciplinare codiceIsced;
	private AreaDisciplinare codiceIscedF;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = StringUtils.upperCase(descrizione);
	}
	public String getDescrizioneAbbreviata() {
		return descrizioneAbbreviata;
	}
	public void setDescrizioneAbbreviata(String descrizioneAbbreviata) {
       this.descrizioneAbbreviata = StringUtils.upperCase(descrizioneAbbreviata);
	}
	public Long getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(Long idCorso) {
		this.idCorso = idCorso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((descrizione == null) ? 0 : descrizione.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Corso))
			return false;
		Corso other = (Corso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		return true;
	}
	public CorsoView getCorsoView() {
		return corsoView;
	}
	public void setCorsoView(CorsoView corsoView) {
		this.corsoView = corsoView;
	}
	
	public boolean isErasmus()	{
		return (id != null) ? id.equals(CORSO_ERASMUS) : false;
	}
	public AreaDisciplinare getCodiceIsced() {
		return codiceIsced;
	}
	public void setCodiceIsced(AreaDisciplinare codiceIsced) {
		this.codiceIsced = codiceIsced;
	}
	public AreaDisciplinare getCodiceIscedF() {
		return codiceIscedF;
	}
	public void setCodiceIscedF(AreaDisciplinare codiceIscedF) {
		this.codiceIscedF = codiceIscedF;
	}
	public AreaDisciplinare getCodiceIshedFoIshedSeNull(){
		AreaDisciplinare adIF = getCodiceIscedF();
		return adIF == null ? getCodiceIsced() : adIF;
	}
}

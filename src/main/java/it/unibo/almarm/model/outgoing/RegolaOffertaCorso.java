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
package it.unibo.almarm.model.outgoing;

import it.unibo.almarm.model.attori.studenti.CorsoView;
import it.unibo.almarm.util.Common;

import org.apache.commons.lang.StringUtils;

public class RegolaOffertaCorso implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	//private Corso corso;
	private CorsoView corso;
	
	// non persistita
	private String flagRiordinatoAggiunto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CorsoView getCorso() {
		return corso;
	}
	public void setCorso(CorsoView corso) {
		this.corso = corso;
	}
	
	public String getCorsoDesc() {
		return (corso!=null)? corso.getId() + " " +corso.getDescrizione() : "";
	}
	
	// Flag NON PERSISTITA
	public String getFlagRiordinatoAggiunto() {
		return flagRiordinatoAggiunto;
	}
	public void setFlagRiordinatoAggiunto(String flagRiordinatoAggiunto) {
		this.flagRiordinatoAggiunto = flagRiordinatoAggiunto;
	}

	public boolean isRiordinatoAggiunto() {
		return StringUtils.isNotBlank(flagRiordinatoAggiunto) &&  Common.CH_S.equals(flagRiordinatoAggiunto.charAt(0));
	}
	// --
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RegolaOffertaCorso))
			return false;
		RegolaOffertaCorso other = (RegolaOffertaCorso) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		return true;
	}
	
}

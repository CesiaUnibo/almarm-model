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
package it.unibo.almarm.model.outgoing.learningagreement;

import it.unibo.almarm.util.Common;
import it.unibo.almarm.webapp.flow.mvc.ConversionService;

public class EsameLACorsoView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private EsameLACorsoViewId id;
	private String codCorso;
	private String codInd;
	private String codOri;
	private Integer progPiano;
	private String codMateria;
	private String descMateria;
	private Float cfu;
	private Character flagObbligatorio;

	public EsameLACorsoViewId getId() {
		return id;
	}

	public void setId(EsameLACorsoViewId id) {
		this.id = id;
	}

	public String getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}

	public String getCodInd() {
		return codInd;
	}

	public void setCodInd(String codInd) {
		this.codInd = codInd;
	}

	public String getCodOri() {
		return codOri;
	}

	public void setCodOri(String codOri) {
		this.codOri = codOri;
	}

	public Integer getProgPiano() {
		return progPiano;
	}

	public void setProgPiano(Integer progPiano) {
		this.progPiano = progPiano;
	}

	public String getCodMateria() {
		return codMateria;
	}

	public void setCodMateria(String codMateria) {
		this.codMateria = codMateria;
	}

	public String getDescMateria() {
		return descMateria;
	}

	public void setDescMateria(String descMateria) {
		this.descMateria = descMateria;
	}

	public Float getCfu() {
		return cfu;
	}

	public void setCfu(Float cfu) {
		this.cfu = cfu;
	}

	public Character getFlagObbligatorio() {
		return flagObbligatorio;
	}

	public void setFlagObbligatorio(Character flagObbligatorio) {
		this.flagObbligatorio = flagObbligatorio;
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
		if (!(obj instanceof EsameLACorsoView))
			return false;
		EsameLACorsoView other = (EsameLACorsoView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public String getLabel() {
		String ects = "";
		try
		{
			ects = " - " + ((new ConversionService.MyStringToFloatConverter()).toString(getCfu())) + " CFU";
		}
		catch (Exception e) {
			
		}
		return getDescMateria() + ects;
	}
	
	public boolean isObbligatorio() {
		return Common.CH_S.equals(flagObbligatorio);
	}
}

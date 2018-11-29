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

import java.util.Objects;

public class EsameLAStudenteView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private EsameLAStudenteViewId id;
	private String descMateria;
	private Character flagInPiano;
	private Character flagSuperato;
	private Character flagObbligatorio;

	public EsameLAStudenteViewId getId() {
		return id;
	}

	public void setId(EsameLAStudenteViewId id) {
		this.id = id;
	}

	public String getDescMateria() {
		return descMateria;
	}

	public void setDescMateria(String descMateria) {
		this.descMateria = descMateria;
	}

	public Character getFlagInPiano() {
		return flagInPiano;
	}

	public void setFlagInPiano(Character flagInPiano) {
		this.flagInPiano = flagInPiano;
	}

	public Character getFlagSuperato() {
		return flagSuperato;
	}

	public void setFlagSuperato(Character flagSuperato) {
		this.flagSuperato = flagSuperato;
	}

	public Character getFlagObbligatorio() {
		return flagObbligatorio;
	}

	public void setFlagObbligatorio(Character flagObbligatorio) {
		this.flagObbligatorio = flagObbligatorio;
	}

	public boolean isInPiano() {
		return Common.CH_S.equals(flagInPiano);
	}
	
	public boolean isObbligatorio() {
		return Common.CH_S.equals(flagObbligatorio);
	}

	public Float getCfu() {
        return getId().getCfu();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EsameLAStudenteView that = (EsameLAStudenteView) o;
        return Objects.equals(getDescMateria(), that.getDescMateria()) &&
                Objects.equals(getCfu(), that.getCfu());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDescMateria(), getCfu());
    }
}

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

public class CorsoOutgoingView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private CorsoOutgoingViewId id;
	private String descCorso;

	public CorsoOutgoingViewId getId() {
		return id;
	}

	public void setId(CorsoOutgoingViewId id) {
		this.id = id;
	}

	public String getDescCorso() {
		return descCorso;
	}

	public void setDescCorso(String descCorso) {
		this.descCorso = descCorso;
	}
		
	public String getCorsoLabel() {
		return id.getCodCorso() + " " + descCorso;
	}
}

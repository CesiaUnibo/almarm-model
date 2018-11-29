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

public class EsternoPersonaTelefono implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private RecapitoTelefonico recapitoTelefonico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RecapitoTelefonico getRecapitoTelefonico() {
		return recapitoTelefonico;
	}

	public void setRecapitoTelefonico(RecapitoTelefonico recapitoTelefonico) {
		this.recapitoTelefonico = recapitoTelefonico;
	}
	
	
}

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
package it.unibo.almarm.model.cds;

import it.unibo.almarm.model.attori.Facolta;

public class MediaFacolta implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private MediaFacoltaId id;
	private Float media;
	private Facolta facolta;

	public MediaFacoltaId getId() {
		return id;
	}

	public void setId(MediaFacoltaId id) {
		this.id = id;
	}

	public Float getMedia() {
		return media;
	}

	public void setMedia(Float media) {
		this.media = media;
	}

	public Facolta getFacolta() {
		return facolta;
	}

	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}
}

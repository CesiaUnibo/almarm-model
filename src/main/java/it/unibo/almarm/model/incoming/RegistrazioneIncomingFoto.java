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
package it.unibo.almarm.model.incoming;

import java.io.Serializable;
import java.util.Arrays;

public class RegistrazioneIncomingFoto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private RegistrazioneIncoming registrazioneIncoming;
	private byte[] img;
	private String estensione;
	private String mime;
	private Foto fotoDaSistema;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RegistrazioneIncoming getRegistrazioneIncoming() {
		return registrazioneIncoming;
	}
	public void setRegistrazioneIncoming(RegistrazioneIncoming registrazioneIncoming) {
		this.registrazioneIncoming = registrazioneIncoming;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public String getEstensione() {
		return estensione;
	}
	public void setEstensione(String estensione) {
		this.estensione = estensione;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public void setFotoDaSistema(Foto fotoDaSistema) {
		this.fotoDaSistema = fotoDaSistema;
	}
	public Foto getFotoDaSistema() {
		return fotoDaSistema;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getEstensione() == null) ? 0 : getEstensione().hashCode());
		result = prime * result + Arrays.hashCode(getImg());
		result = prime * result + ((getMime()== null) ? 0 : getMime().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RegistrazioneIncomingFoto))
			return false;
		RegistrazioneIncomingFoto other = (RegistrazioneIncomingFoto) obj;
		if (getEstensione() == null) {
			if (other.getEstensione()!= null)
				return false;
		} else if (!getEstensione().equals(other.getEstensione()))
			return false;
		if (!Arrays.equals(getImg(), other.getImg()))
			return false;
		if (getMime()== null) {
			if (other.getMime()!= null)
				return false;
		} else if (!getMime().equals(other.getMime()))
			return false;
		return true;
	}

}

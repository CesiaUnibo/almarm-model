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
package it.unibo.almarm.model.modalitapagamento;

public class ClasseEnteSovDotto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String descrizione;
	private String descrizioneShort;
	private String indirizzo;
	private String cap;
	private Integer codiceIstat;
	private ClasseTipoEnteSovDotto classeTipoEnteSovDotto;

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
		this.descrizione = descrizione;
	}

	public String getDescrizioneShort() {
		return descrizioneShort;
	}

	public void setDescrizioneShort(String descrizioneShort) {
		this.descrizioneShort = descrizioneShort;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public Integer getCodiceIstat() {
		return codiceIstat;
	}

	public void setCodiceIstat(Integer codiceIstat) {
		this.codiceIstat = codiceIstat;
	}

	public ClasseTipoEnteSovDotto getClasseTipoEnteSovDotto() {
		return classeTipoEnteSovDotto;
	}

	public void setClasseTipoEnteSovDotto(
			ClasseTipoEnteSovDotto classeTipoEnteSovDotto) {
		this.classeTipoEnteSovDotto = classeTipoEnteSovDotto;
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
		if (!(obj instanceof ClasseEnteSovDotto))
			return false;
		ClasseEnteSovDotto other = (ClasseEnteSovDotto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

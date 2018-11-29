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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import it.unibo.almarm.util.Common;

public class TipoRequisito implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Long ID_TIPO_VOTO_LAUREA = 205L;
	private static final Long ID_TIPO_BASE_VOTO_LAUREA = 207L;
	
	private Long id;
	private String nome;
	private Character tipoValori;
	private String range;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Character getTipoValori() {
		return tipoValori;
	}

	public void setTipoValori(Character tipoValori) {
		this.tipoValori = tipoValori;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipoRequisito))
			return false;
		TipoRequisito other = (TipoRequisito) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public boolean isRichiedeValore() {
		return !Common.CH_N.equals(tipoValori);
	}
	
	public boolean isTipoEnumerazione() {
		return Common.CH_E.equals(tipoValori);
	}
	
	public boolean isTipoEnumerazioneRadio() {
		return Common.CH_R.equals(tipoValori);
	}
	
	public boolean isTipoIntervallo() {
		return Common.CH_I.equals(tipoValori);
	}
	
	public boolean isTipoStringa() {
		return Common.CH_S.equals(tipoValori);
	}
	
	public boolean isTipoLabel() {
		return Common.CH_L.equals(tipoValori);
	}
	
	public List<String> getValori() {
		if (isTipoIntervallo())
		{
			String[] s = range.split(":");
			List<String> l = new ArrayList<String>();
			CollectionUtils.addAll(l, s);
			return l;
		}
		else if (isTipoEnumerazione() || isTipoEnumerazioneRadio())
		{
			String[] s = range.split(",");
			List<String> l = new ArrayList<String>();
			CollectionUtils.addAll(l, s);
			return l;
		}
		return null;
	}

	public Integer getRangeMax() {
		if (StringUtils.isNotBlank(range))
		{
			String[] s = range.split(":");
			if (s.length == 2)
				return new Integer(s[1]);
		}
		return null;
	}

	public static Long getIdTipoVotoLaurea() {
		return ID_TIPO_VOTO_LAUREA;
	}
	
	public static Long getIdTipoBaseVotoLaurea() {
		return ID_TIPO_BASE_VOTO_LAUREA;
	}
}

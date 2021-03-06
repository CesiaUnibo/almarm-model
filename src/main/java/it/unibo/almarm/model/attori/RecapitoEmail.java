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

import org.apache.commons.lang.StringUtils;

// Generated 19-feb-2008 15.24.59 by Hibernate Tools 3.2.0.CR1

/**
 * RecapitoEmail generated by hbm2java
 */
public class RecapitoEmail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Attore attore;
	private String indirizzo;
	private String nota;
	private String tipoVcard;
	private String tipo;
	private Long   privato;
	private Long   priorita;
	private String fonte;
	
	public RecapitoEmail() {
	}

	public RecapitoEmail(Long id, String indirizzo) {
		this.id = id;
		this.indirizzo = indirizzo;
	}

	public RecapitoEmail(Long id, Attore attore, String indirizzo, String nota,
			String tipoVcard) {
		this.id = id;
		this.attore = attore;
		this.indirizzo = indirizzo;
		this.nota = nota;
		this.tipoVcard = tipoVcard;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Attore getAttore() {
		return this.attore;
	}

	public void setAttore(Attore attore) {
		this.attore = attore;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getTipoVcard() {
		return this.tipoVcard;
	}

	public void setTipoVcard(String tipoVcard) {
		this.tipoVcard = tipoVcard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((indirizzo == null) ? 0 : indirizzo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RecapitoEmail))
			return false;
		final RecapitoEmail other = (RecapitoEmail) obj;
		if (indirizzo == null) {
			if (other.getIndirizzo() != null)
				return false;
		} else if (!indirizzo.equals(other.getIndirizzo()))
			return false;
		//
		if (getId()!=null && other.getId()!=null
			&& (!getId().equals(other.getId())))
			return false;
		if (getPriorita()!=null && other.getPriorita()!=null
				&& (!getPriorita().equals(other.getPriorita())))
				return false;
		//
		
		return true;
	}

	public Long getPrivato() {
		return privato;
	}

	public void setPrivato(Long privato) {
		this.privato = privato;
	}

	public Long getPriorita() {
		return priorita;
	}

	public void setPriorita(Long priorita) {
		this.priorita = priorita;
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo utilizzato nel caso in cui il recapito è il link del sito dell'attore. 
	 * Alcuni attori inseriscono il link includendo http:// altri no. Questo metodo ritorna
	 * sempre l'indirizzo preceduto da http:// 
	 * 
	 */
	public String getIndirizzoHTTP()
	{
		if (StringUtils.isNotBlank(indirizzo))
		{
			if (indirizzo.contains("://"))
				return indirizzo;
			else
				return "http://" + indirizzo;
		}
		return indirizzo;
	}
}

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

public class SedeView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long idAnagraficaStruttura;
	private Long idAnagraficaSede;
	private Long idIndirizzo;
	private String descrizione;
	private String descrizioneLunga;
	private String indirizzo;
	private String cap;
	private Long idLocalita;
	private String localita;
	private Character flagSedePrincipale;
	private String codPolo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdAnagraficaStruttura() {
		return idAnagraficaStruttura;
	}

	public void setIdAnagraficaStruttura(Long idAnagraficaStruttura) {
		this.idAnagraficaStruttura = idAnagraficaStruttura;
	}

	public Long getIdAnagraficaSede() {
		return idAnagraficaSede;
	}

	public void setIdAnagraficaSede(Long idAnagraficaSede) {
		this.idAnagraficaSede = idAnagraficaSede;
	}

	public Long getIdIndirizzo() {
		return idIndirizzo;
	}

	public void setIdIndirizzo(Long idIndirizzo) {
		this.idIndirizzo = idIndirizzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizioneLunga() {
		return descrizioneLunga;
	}

	public void setDescrizioneLunga(String descrizioneLunga) {
		this.descrizioneLunga = descrizioneLunga;
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

	public Long getIdLocalita() {
		return idLocalita;
	}

	public void setIdLocalita(Long idLocalita) {
		this.idLocalita = idLocalita;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public Character getFlagSedePrincipale() {
		return flagSedePrincipale;
	}

	public void setFlagSedePrincipale(Character flagSedePrincipale) {
		this.flagSedePrincipale = flagSedePrincipale;
	}

	public String getCodPolo() {
		return codPolo;
	}

	public void setCodPolo(String codPolo) {
		this.codPolo = codPolo;
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
		if (!(obj instanceof SedeView))
			return false;
		SedeView other = (SedeView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public String getLabelShort() {
		return indirizzo + " - " + localita;
	}
}

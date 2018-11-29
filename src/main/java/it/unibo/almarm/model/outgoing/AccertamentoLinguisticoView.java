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

import java.io.Serializable;
import java.util.Date;

public class AccertamentoLinguisticoView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String codiceFiscale;
	private String lingua;
	private String livello;
	private String struttura;
	private Date dataAccertamento;
	private Float percentuale;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setDataAccertamento(Date dataAccertamento) {
		this.dataAccertamento = dataAccertamento;
	}

	public Date getDataAccertamento() {
		return dataAccertamento;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public String getLingua() {
		return lingua;
	}

	public void setStruttura(String struttura) {
		this.struttura = struttura;
	}

	public String getStruttura() {
		return struttura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AccertamentoLinguisticoView))
			return false;
		AccertamentoLinguisticoView other = (AccertamentoLinguisticoView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setLivello(String livello) {
		this.livello = livello;
	}

	public String getLivello() {
		return livello;
	}

	public void setPercentuale(Float percentuale) {
		this.percentuale = percentuale;
	}

	public Float getPercentuale() {
		return percentuale;
	}

}

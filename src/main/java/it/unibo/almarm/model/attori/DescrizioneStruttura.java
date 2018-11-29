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

import it.unibo.almarm.util.Common;

import java.util.Date;


public class DescrizioneStruttura implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	private String sigla;
	private String descrizione;
	private String descrizioneBreve;
	private String descrizioneIng;
	private String missione;
	private Date dataInizio;
	private Date dataFine;
	private Character flagScuolaODipartimento;
	private Character flagScaduta;
	
	private Struttura struttura;
	
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDescrizioneBreve() {
		return descrizioneBreve;
	}
	public void setDescrizioneBreve(String descrizioneBreve) {
		this.descrizioneBreve = descrizioneBreve;
	}
	public String getMissione() {
		return missione;
	}
	public void setMissione(String missione) {
		this.missione = missione;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		/*
		result = prime * result
				+ ((dataInizio == null) ? 0 : dataInizio.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		*/
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DescrizioneStruttura))
			return false;
		final DescrizioneStruttura other = (DescrizioneStruttura) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Struttura getStruttura() {
		return struttura;
	}
	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}
	
	public Long getIdStruttura() {
		return getStruttura() != null ? getStruttura().getId() : null;
	}
	
	public Character getFlagScuolaODipartimento() {
		return flagScuolaODipartimento;
	}
	
	public void setFlagScuolaODipartimento(Character flagScuolaODipartimento) {
		this.flagScuolaODipartimento = flagScuolaODipartimento;
	}
	
	public boolean isScuolaODipartimento() {
		return Common.CH_S.equals(getFlagScuolaODipartimento());
	}
	public String getDescrizioneIng() {
		return descrizioneIng;
	}
	public void setDescrizioneIng(String descrizioneIng) {
		this.descrizioneIng = descrizioneIng;
	}
	public Character getFlagScaduta() {
		return flagScaduta;
	}
	public void setFlagScaduta(Character flagScaduta) {
		this.flagScaduta = flagScaduta;
	}
	public boolean isScaduta(){
		return Common.CH_S.equals(flagScaduta);
	}
	public String getLabelValidita(){
		return isScaduta()? "Scaduta":"";
	}
}

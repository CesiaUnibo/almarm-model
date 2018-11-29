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

public class PersonaleDottorando implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Long id;
	private String cognome;
	private String nome;
	private String codiceFiscale;
	private String numeroDiMatricola; //di carriera
	private Dipartimento dipartimento;
	private String descrizioneTipoCarriera;
	private String descrizioneCorso;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNumeroDiMatricola() {
		return numeroDiMatricola;
	}
	public void setNumeroDiMatricola(String numeroDiMatricola) {
		this.numeroDiMatricola = numeroDiMatricola;
	}
	public Dipartimento getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	public String getCodiceAttore() {
		return this.codiceFiscale;
	}
	public String getNomeAttore() {
		return cognome + " " + nome;
	}
	public String getDescrizioneTipoCarriera() {
		return descrizioneTipoCarriera;
	}
	public void setDescrizioneTipoCarriera(String descrizioneTipoCarriera) {
		this.descrizioneTipoCarriera = descrizioneTipoCarriera;
	}
	public String getDescrizioneCorso() {
		return descrizioneCorso;
	}
	public void setDescrizioneCorso(String descrizioneCorso) {
		this.descrizioneCorso = descrizioneCorso;
	}
	public String getTipoCarrieraCorsoLabel()	{
		return (descrizioneTipoCarriera != null ? descrizioneTipoCarriera : "" ) + " " +  (descrizioneCorso != null ? descrizioneCorso : "");
	}
}

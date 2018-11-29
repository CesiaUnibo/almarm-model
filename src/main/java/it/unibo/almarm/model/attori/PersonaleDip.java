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

public class PersonaleDip  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Long id;
	private Integer matricola;
	private String cognome;
	private String nome;
	private String upn;
	private String email;
	private String codiceRuolo;
	private String descrizioneRuolo;
	private String codiceFiscale;
	private Long idUnitaOrg;
	private String descrizioneUnitaOrg;
	
	public Long getId() {
		return id;
	}	
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getMatricola() {
		return matricola;
	}
	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
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
	/*
	public String getCodiceAttore() {
		return String.valueOf(matricola);
	}
	*/
	public String getCodiceAttore() {
		return this.codiceFiscale;
	}
	public String getNomeAttore() {
		return cognome + " " + nome;
	}
	public Long getIdUnitaOrg() {
		return idUnitaOrg;
	}
	public void setIdUnitaOrg(Long idUnitaOrg) {
		this.idUnitaOrg = idUnitaOrg;
	}
	public String getDescrizioneUnitaOrg() {
		return descrizioneUnitaOrg;
	}
	public void setDescrizioneUnitaOrg(String descrizioneUnitaOrg) {
		this.descrizioneUnitaOrg = descrizioneUnitaOrg;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getUpn() {
		return upn;
	}
	private void setUpn(String upn) {
		this.upn = upn;
	}
	public String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	/**
	 * ritorna l'email. Se non presente ritorna l'upn
	 * @return Una stringa corrispondente alla proprieta' email o upn
	 */
	public String getAccountUnibo() {
		if (email != null && !StringUtils.EMPTY.equals(email))
			return email;
		else
			return upn;
	}
	public String getCodiceRuolo() {
		return codiceRuolo;
	}
	private void setCodiceRuolo(String codiceRuolo) {
		this.codiceRuolo = codiceRuolo;
	}
	public String getDescrizioneRuolo() {
		return descrizioneRuolo;
	}
	private void setDescrizioneRuolo(String descrizioneRuolo) {
		this.descrizioneRuolo = descrizioneRuolo;
	}
}

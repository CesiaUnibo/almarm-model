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

import org.apache.commons.lang.StringUtils;

import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.flussiscambio.PeriodoMobilita;
import it.unibo.almarm.model.lingue.Lingua;

public class OlsLicenzaSO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Long id;
	PeriodoMobilita periodoMobilita;
	Lingua lingua;
	Persona persona;
	StudenteOutgoing studenteOutgoing;
	Character flagLicenzaCorso;
	Date dataLicenzaCorso;
	Character flagSecondaAssegnazione;
	String livello1;
	Date dataLivello1;
	String livello2;
	Date dataLivello2;
	Date dataInserimento;
	Persona autoreInserimento;
	Date dataModifica;
	Persona autoreModifica;
	String note;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Character getFlagLicenzaCorso() {
		return flagLicenzaCorso;
	}
	public void setFlagLicenzaCorso(Character flagLicenzaCorso) {
		this.flagLicenzaCorso = flagLicenzaCorso;
	}
	public PeriodoMobilita getPeriodoMobilita() {
		return periodoMobilita;
	}
	public void setPeriodoMobilita(PeriodoMobilita periodoMobilita) {
		this.periodoMobilita = periodoMobilita;
	}
	public Lingua getLingua() {
		return lingua;
	}
	public void setLingua(Lingua lingua) {
		this.lingua = lingua;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public StudenteOutgoing getStudenteOutgoing() {
		return studenteOutgoing;
	}
	public void setStudenteOutgoing(StudenteOutgoing studenteOutgoing) {
		this.studenteOutgoing = studenteOutgoing;
	}
	public Date getDataLicenzaCorso() {
		return dataLicenzaCorso;
	}
	public void setDataLicenzaCorso(Date dataLicenzaCorso) {
		this.dataLicenzaCorso = dataLicenzaCorso;
	}
	public Character getFlagSecondaAssegnazione() {
		return flagSecondaAssegnazione;
	}
	public void setFlagSecondaAssegnazione(Character flagSecondaAssegnazione) {
		this.flagSecondaAssegnazione = flagSecondaAssegnazione;
	}
	public String getLivello1() {
		return livello1;
	}
	public void setLivello1(String livello1) {
		this.livello1 = livello1;
	}
	public Date getDataLivello1() {
		return dataLivello1;
	}
	public void setDataLivello1(Date dataLivello1) {
		this.dataLivello1 = dataLivello1;
	}
	public String getLivello2() {
		return livello2;
	}
	public void setLivello2(String livello2) {
		this.livello2 = livello2;
	}
	public Date getDataLivello2() {
		return dataLivello2;
	}
	public void setDataLivello2(Date dataLivello2) {
		this.dataLivello2 = dataLivello2;
	}
	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public Persona getAutoreInserimento() {
		return autoreInserimento;
	}
	public void setAutoreInserimento(Persona autoreInserimento) {
		this.autoreInserimento = autoreInserimento;
	}
	public Date getDataModifica() {
		return dataModifica;
	}
	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}
	public Persona getAutoreModifica() {
		return autoreModifica;
	}
	public void setAutoreModifica(Persona autoreModifica) {
		this.autoreModifica = autoreModifica;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}

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


import it.unibo.almarm.model.luoghi.Nazione;

import java.util.Date;

public class ReferenteAccordo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Persona persona;

	// Campi fittizi
	private String cfProvvisorio;
	private Nazione nazioneNascita;
	private Date dataNascita;
	private String codiceFiscaleItaliano;
	private Nazione nazioneIndirizzo;
	private Long idAteneo;
	
	public Long getIdAteneo() {
		return idAteneo;
	}
	public void setIdAteneo(Long idAteneo) {
		this.idAteneo = idAteneo;
	}
	public String getCfProvvisorio() {
		if (cfProvvisorio==null)
		{
			 if (persona.getStatoCodiceFiscale()==null
				 ||  persona.getStatoCodiceFiscale().equals('F'))
				return "S";
			 else 
				 return "N";
		}
		return cfProvvisorio;
			
	}
	public void setCfProvvisorio(String cfProvvisorio) {
		this.cfProvvisorio = cfProvvisorio;
	}
	public Nazione getNazioneNascita() {
		return nazioneNascita;
	}
	public void setNazioneNascita(Nazione nazioneNascita) {
		this.nazioneNascita = nazioneNascita;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public String getCodiceFiscaleItaliano() {
		return codiceFiscaleItaliano;
	}
	public void setCodiceFiscaleItaliano(String codiceFiscaleItaliano) {
		this.codiceFiscaleItaliano = codiceFiscaleItaliano;
	}
	
	public Nazione getNazioneIndirizzo() {
		return nazioneIndirizzo;
	}
	public void setNazioneIndirizzo(Nazione nazioneIndirizzo) {
		this.nazioneIndirizzo = nazioneIndirizzo;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public ReferenteAccordo(Persona persona)
	{
		this.persona=persona;
	}
	public ReferenteAccordo()
	{}
}

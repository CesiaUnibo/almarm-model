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
package it.unibo.almarm.model.accordi;

import it.unibo.almarm.model.attori.Persona;

import java.util.Date;

public class AccordoEventoNote 	 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String CP_PRESA_IN_CARICO_MOD_DA_PARTNER = "CP_PRESA_IN_CARICO_MOD_DA_PARTNER"; 
	
	private Long id;
    private Long idAccordoOperativo;
    private Long idContrattoPartner; // opzionale
    private String tipo; // PRESA_IN_CARICO_MOD_DA_PRTNER  
    private String testo;
   	private Date dataInserimento; // prima segnalazione evento
	private Persona autoreInserimento;
	private Date dataUltimaModifica; // del testo
	private Persona autoreUltimaModifica;// del testo
	private Date dataUltimoEvento; // ultima segnalazione evento
	private Persona autoreUltimoEvento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdAccordoOperativo() {
		return idAccordoOperativo;
	}
	public void setIdAccordoOperativo(Long idAccordoOperativo) {
		this.idAccordoOperativo = idAccordoOperativo;
	}
	public Long getIdContrattoPartner() {
		return idContrattoPartner;
	}
	public void setIdContrattoPartner(Long idContrattoPartner) {
		this.idContrattoPartner = idContrattoPartner;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
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
	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}
	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}
	public Persona getAutoreUltimaModifica() {
		return autoreUltimaModifica;
	}
	public void setAutoreUltimaModifica(Persona autoreUltimaModifica) {
		this.autoreUltimaModifica = autoreUltimaModifica;
	}
	
	public Date getDataUltimoEvento() {
		return dataUltimoEvento;
	}
	public void setDataUltimoEvento(Date dataUltimoEvento) {
		this.dataUltimoEvento = dataUltimoEvento;
	}
	public Persona getAutoreUltimoEvento() {
		return autoreUltimoEvento;
	}
	public void setAutoreUltimoEvento(Persona autoreUltimoEvento) {
		this.autoreUltimoEvento = autoreUltimoEvento;
	}
	public boolean isPresenteUltimoEvento(){
		return getDataInserimento() != null && getDataUltimoEvento() != null &&  getDataUltimoEvento().after(getDataInserimento());
	}
	
}

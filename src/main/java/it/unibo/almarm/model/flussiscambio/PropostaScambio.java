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
package it.unibo.almarm.model.flussiscambio;

import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Campus;
import it.unibo.almarm.model.attori.Facolta;

public class PropostaScambio implements java.io.Serializable {
	private static final long serialVersionUID = 2L;

	private Long id;
	private SottoProgramma sottoProgramma;
	private Target target;
	private TipoAttivita tipoAttivita;
	private Ateneo beneficiario;
	private String note;
	private Campus campus;
	private Facolta facolta;
	private PropostaFlusso flussoIn;
	private PropostaFlusso flussoOut;
	private Long idPropostaAccordo;
	
	// campi non persistiti
	private boolean flussoInAttivo;
	private boolean flussoOutAttivo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SottoProgramma getSottoProgramma() {
		return sottoProgramma;
	}
	public void setSottoProgramma(SottoProgramma sottoProgramma) {
		this.sottoProgramma = sottoProgramma;
	}
	public Target getTarget() {
		return target;
	}
	public void setTarget(Target target) {
		this.target = target;
	}
	public PropostaFlusso getFlussoIn() {
		return flussoIn;
	}
	public void setFlussoIn(PropostaFlusso flussoIn) {
		this.flussoIn = flussoIn;
	}
	public PropostaFlusso getFlussoOut() {
		return flussoOut;
	}
	public void setFlussoOut(PropostaFlusso flussoOut) {
		this.flussoOut = flussoOut;
	}
	public TipoAttivita getTipoAttivita() {
		return tipoAttivita;
	}
	public void setTipoAttivita(TipoAttivita tipoAttivita) {
		this.tipoAttivita = tipoAttivita;
	}
	public Ateneo getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Ateneo beneficiario) {
		this.beneficiario = beneficiario;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Campus getCampus() {
		return campus;
	}
	public String getSiglaCampus() {
		return (campus!=null && campus.getId()!=null)? campus.getId():""; 
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	public Facolta getFacolta() {
		return facolta;
	}
	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}
	public String getDescFac() {
		return (facolta!=null && facolta.getId()!=null)? facolta.getDescFac():""; 
	}
	public Long getIdPropostaAccordo() {
		return idPropostaAccordo;
	}
	public void setIdPropostaAccordo(Long idPropostaAccordo) {
		this.idPropostaAccordo = idPropostaAccordo;
	}
	public boolean isFlussoInAttivo() {
		return flussoInAttivo;
	}
	public void setFlussoInAttivo(boolean flussoInAttivo) {
		this.flussoInAttivo = flussoInAttivo;
	}
	public boolean isFlussoOutAttivo() {
		return flussoOutAttivo;
	}
	public void setFlussoOutAttivo(boolean flussoOutAttivo) {
		this.flussoOutAttivo = flussoOutAttivo;
	}

	public boolean isAreaDisciplareObbilgatoria()
	{
		if (sottoProgramma == null || sottoProgramma.getProgramma() == null)
			return false;
		// TODO: configurare in qualche modo l'obbligatorieta' dell'area di un dato programma!!
		//       possibilmente a livello della classe programma
		return (sottoProgramma.getProgramma().getId() != 21L && sottoProgramma.getProgramma().getId()!=22L);
	}
}

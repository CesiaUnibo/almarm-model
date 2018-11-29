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

import it.unibo.almarm.model.accordi.AccordoOperativo;
import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Campus;
import it.unibo.almarm.model.attori.Facolta;

public class ScambioAccordo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private AccordoOperativo accordoOperativo;
	private SottoProgramma sottoProgramma;
	private Target target;
	private FlussoAccordo flussoAccordoIn;
	private FlussoAccordo flussoAccordoOut;
	private TipoAttivita tipoAttivita;
	private Ateneo beneficiario;
	private String note;
	private Campus campus;
	private Facolta facolta;
	private Long idSAPredecessore;
	private String campusPartner; // Solo testo, indica eventuale campus prtner specificamente indicato nel contratto (viene usato solo nelle visualizzazioni e per la stampa contratto)
	
	// campi non persistiti
	private boolean flussoInAttivo;
	private boolean flussoOutAttivo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AccordoOperativo getAccordoOperativo() {
		return accordoOperativo;
	}
	public void setAccordoOperativo(AccordoOperativo accordoOperativo) {
		this.accordoOperativo = accordoOperativo;
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
	public TipoAttivita getTipoAttivita() {
		return tipoAttivita;
	}
	public void setTipoAttivita(TipoAttivita tipoAttivita) {
		this.tipoAttivita = tipoAttivita;
	}
	
	public boolean isAreaDisciplareObbilgatoria()
	{
		if (sottoProgramma == null || sottoProgramma.getProgramma() == null)
			return false;
		// TODO: configurare in qualche modo l'obbligatorieta' dell'area di un dato programma!!
		//       possibilmente a livello della classe programma
		return (sottoProgramma.getProgramma().getId() != 21L && sottoProgramma.getProgramma().getId()!=22L);
	}
	
	public Campus getCampus() {
		return campus;
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	
	public String getSiglaCampus() {
		return (campus!=null && campus.getId()!=null)? campus.getId():""; 
	}
	
	public String getDescrizioneCampus() {
		return (campus!=null && campus.getId()!=null)? campus.getDescrizione() :""; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((accordoOperativo == null) ? 0 : accordoOperativo.hashCode());
		result = prime * result
				+ ((sottoProgramma == null) ? 0 : sottoProgramma.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result
				+ ((tipoAttivita == null) ? 0 : tipoAttivita.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ScambioAccordo))
			return false;
		ScambioAccordo other = (ScambioAccordo) obj;
		if (getId() != null && other.getId() != null)
			return getId().equals(other.getId());
		if (accordoOperativo == null) {
			if (other.accordoOperativo != null)
				return false;
		} else if (!accordoOperativo.equals(other.accordoOperativo))
			return false;
		if (sottoProgramma == null) {
			if (other.sottoProgramma != null)
				return false;
		} else if (!sottoProgramma.equals(other.sottoProgramma))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		if (tipoAttivita == null) {
			if (other.tipoAttivita != null)
				return false;
		} else if (!tipoAttivita.equals(other.tipoAttivita))
			return false;
		return true;
	}
	public FlussoAccordo getFlussoAccordoIn() {
		return flussoAccordoIn;
	}
	public void setFlussoAccordoIn(FlussoAccordo flussoAccordoIn) {
		this.flussoAccordoIn = flussoAccordoIn;
	}
	public FlussoAccordo getFlussoAccordoOut() {
		return flussoAccordoOut;
	}
	public void setFlussoAccordoOut(FlussoAccordo flussoAccordoOut) {
		this.flussoAccordoOut = flussoAccordoOut;
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
	public Facolta getFacolta() {
		return facolta;
	}
	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}	
	public String getDescFac() {
		return (facolta!=null && facolta.getId()!=null)? facolta.getDescFac():""; 
	}
	public String getCampusPartner() {
		return campusPartner;
	}
	public void setCampusPartner(String campusPartner) {
		this.campusPartner = campusPartner;
	}
	
	public boolean isPostiValidi(){
		return  (flussoAccordoIn != null && flussoAccordoIn.isPostiValidi()) || (flussoAccordoOut != null && flussoAccordoOut.isPostiValidi());  
	}
	public Long getIdSAPredecessore() {
		return idSAPredecessore;
	}
	public void setIdSAPredecessore(Long idSAPredecessore) {
		this.idSAPredecessore = idSAPredecessore;
	}
	
	public boolean isScambioErasmusPlusExtraUE(){
		return this.getSottoProgramma() !=null && getSottoProgramma().isAnyErasmusPlusExtraUE();
	}
}

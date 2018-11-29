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

public class StudenteOutgoingInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private StudenteOutgoing studenteOutgoing;
	private String livelloDiStudio;
	private Integer eta;
	private Integer annoDiFrequenza;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudenteOutgoing getStudenteOutgoing() {
		return studenteOutgoing;
	}

	public void setStudenteOutgoing(StudenteOutgoing studenteOutgoing) {
		if (studenteOutgoing != null && studenteOutgoing.getId() != null)
			this.id = studenteOutgoing.getId();
		this.studenteOutgoing = studenteOutgoing;
	}

	public String getLivelloDiStudio() {
		return livelloDiStudio;
	}

	public void setLivelloDiStudio(String livelloDiStudio) {
		this.livelloDiStudio = livelloDiStudio;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public Integer getAnnoDiFrequenza() {
		return annoDiFrequenza;
	}

	public void setAnnoDiFrequenza(Integer annoDiFrequenza) {
		this.annoDiFrequenza = annoDiFrequenza;
	}
	
	public boolean isPrimoLivello() {
		return "L".equals(getLivelloDiStudio());
	}
	
	public boolean isSecondoLivello() {
		return "LM/LS".equals(getLivelloDiStudio());
	}
	
	public boolean isTerzoLivello() {
		return "PHD".equals(getLivelloDiStudio());
	}
	
}

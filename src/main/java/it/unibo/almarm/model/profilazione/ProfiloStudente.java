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
package it.unibo.almarm.model.profilazione;

import it.unibo.almarm.util.Common;

public class ProfiloStudente extends ProfiloAlmaRM {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cognome;
	private String email; 
	private Long idPersona;
	private boolean isIncoming;
	private boolean candidaturaSuCdsCorrente;
	private boolean candidaturaSuCdsFuturo;
	private Integer carrieraAttiva;
	private Integer carrieraMerito;

	private Integer carrieraScelta;

	private String codCorsoScelto;
	private String codIndScelto;
	private String codOriScelto;
	
	private boolean isOutgoing;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNomeCognome() {
		return Common.getNomeCognomeCapitalized(nome, cognome);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public boolean isIncoming() {
		return isIncoming;
	}

	public void setIncoming(boolean isIncoming) {
		this.isIncoming = isIncoming;
	}

	public boolean isCandidaturaSuCdsCorrente() {
		return candidaturaSuCdsCorrente;
	}

	public void setCandidaturaSuCdsCorrente(boolean candidaturaSuCdsCorrente) {
		this.candidaturaSuCdsCorrente = candidaturaSuCdsCorrente;
	}

	public boolean isCandidaturaSuCdsFuturo() {
		return candidaturaSuCdsFuturo;
	}

	public void setCandidaturaSuCdsFuturo(boolean candidaturaSuCdsFuturo) {
		this.candidaturaSuCdsFuturo = candidaturaSuCdsFuturo;
	}

	public Integer getCarrieraAttiva() {
		return carrieraAttiva;
	}

	public void setCarrieraAttiva(Integer carrieraAttiva) {
		this.carrieraAttiva = carrieraAttiva;
	}

	public Integer getCarrieraMerito() {
		return carrieraMerito;
	}

	public void setCarrieraMerito(Integer carrieraMerito) {
		this.carrieraMerito = carrieraMerito;
	}

	public Integer getCarrieraScelta() {
		return carrieraScelta;
	}

	public void setCarrieraScelta(Integer carrieraScelta) {
		this.carrieraScelta = carrieraScelta;
	}

	public boolean isOutgoing() {
		return isOutgoing;
	}

	public void setOutgoing(boolean isOutgoing) {
		this.isOutgoing = isOutgoing;
	}

	public String getCodCorsoScelto() {
		return codCorsoScelto;
	}

	public void setCodCorsoScelto(String codCorsoScelto) {
		this.codCorsoScelto = codCorsoScelto;
	}

	public String getCodIndScelto() {
		return codIndScelto;
	}

	public void setCodIndScelto(String codIndScelto) {
		this.codIndScelto = codIndScelto;
	}

	public String getCodOriScelto() {
		return codOriScelto;
	}

	public void setCodOriScelto(String codOriScelto) {
		this.codOriScelto = codOriScelto;
	}

	public boolean isDaScegliereCarrieraPerCandidatura() {
		return carrieraScelta == null && codCorsoScelto == null && isCandidaturaSuCdsCorrente() &&  isCandidaturaSuCdsFuturo();
	}
	
	public boolean isDaScegliereCorsoPerCandidatura() {
		return  carrieraScelta == null && codCorsoScelto == null  &&  isCandidaturaSuCdsFuturo();
	}
}

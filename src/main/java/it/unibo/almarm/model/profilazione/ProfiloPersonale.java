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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.kion.plitvice.autorizzazioni.model.Contesto;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.util.Common;

public class ProfiloPersonale extends ProfiloAlmaRM {

	private static final long serialVersionUID = 1L;
	
	private Long idContestoCorrente;
	private String nome;
	private String cognome;
	private Persona persona;
	private boolean docente;
	private boolean dottorando;
	private boolean assegnista;
	private boolean deveCambiarePassword;
	private boolean coordinatoreDiCorso;
	private Long idDipartimentoCorrente;
	private List<Long> idsDipartimentiDiCuiEDirettoreODelegato = new ArrayList<Long>();
	private List<Long> idsDipartimentiDiCuiEVicedirettoreODelegato = new ArrayList<Long>();
	private List<Long> idsDipartimentiDiCuiEResponsabileAmministrativoODelegato = new ArrayList<Long>();

	public ProfiloPersonale() {
		if (true)
			return;
	}

	public Long getIdContestoCorrente() {
		return idContestoCorrente;
	}

	public void setIdContestoCorrente(Long idContestoCorrente) {
		this.idContestoCorrente = idContestoCorrente;
	}

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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean isDocente() {
		return docente;
	}

	public void setDocente(boolean docente) {
		this.docente = docente;
	}

	public boolean isDeveCambiarePassword() {
		return deveCambiarePassword;
	}

	public void setDeveCambiarePassword(boolean deveCambiarePassword) {
		this.deveCambiarePassword = deveCambiarePassword;
	}
	
	public it.unibo.almarm.model.profilazione.Contesto getContestoCorrente() {
		if (getContesti() == null)
			return null;
		for (Contesto contesto: getContesti())
			if (contesto.getId().equals(idContestoCorrente))
				return (it.unibo.almarm.model.profilazione.Contesto) contesto;
		return null;
	}

	public boolean isCoordinatoreDiCorso() {
		return coordinatoreDiCorso;
	}

	public void setCoordinatoreDiCorso(boolean coordinatoreDiCorso) {
		this.coordinatoreDiCorso = coordinatoreDiCorso;
	}

	public boolean isDirettoreDiDipartimento() {
		return getIdsDipartimentiDiCuiEDirettoreODelegato() != null && !getIdsDipartimentiDiCuiEDirettoreODelegato().isEmpty();
	}
	
	public boolean isDirettoreDiDipartimento(Long idDipartimento) {
		return getIdsDipartimentiDiCuiEDirettoreODelegato() != null && getIdsDipartimentiDiCuiEDirettoreODelegato().contains(idDipartimento);
	}

	public boolean isVicedirettoreDiDipartimento() {
		return getIdsDipartimentiDiCuiEVicedirettoreODelegato() != null && !getIdsDipartimentiDiCuiEVicedirettoreODelegato().isEmpty();
	}
	
	public boolean isVicedirettoreDiDipartimento(Long idDipartimento) {
		return getIdsDipartimentiDiCuiEVicedirettoreODelegato() != null && getIdsDipartimentiDiCuiEVicedirettoreODelegato().contains(idDipartimento);
	}
	
	public boolean isDirettoreOViceDiDipartimento() {
		return isDirettoreDiDipartimento() || isVicedirettoreDiDipartimento();
	}
	
	public boolean isDirettoreOViceDiDipartimento(Long idDipartimento) {
		return isDirettoreDiDipartimento(idDipartimento) || isVicedirettoreDiDipartimento(idDipartimento);
	}

	public boolean isResponsabileAmministrativoDiDipartimento() {
		return getIdsDipartimentiDiCuiEResponsabileAmministrativoODelegato() != null && !getIdsDipartimentiDiCuiEResponsabileAmministrativoODelegato().isEmpty();
	}

	public boolean isResponsabileAmministrativoODelegatoDiDipartimentoCorrente() {
		return getIdDipartimentoCorrente() != null && isResponsabileAmministrativoDiDipartimento(getIdDipartimentoCorrente());
	}
	
	public boolean isResponsabileAmministrativoDiDipartimento(Long idDipartimento) {
		return getIdsDipartimentiDiCuiEResponsabileAmministrativoODelegato() != null && getIdsDipartimentiDiCuiEResponsabileAmministrativoODelegato().contains(idDipartimento);
	}

	public List<Long> getIdsDipartimentiDiCuiEDirettoreODelegato() {
		return idsDipartimentiDiCuiEDirettoreODelegato;
	}

	public void setIdsDipartimentiDiCuiEDirettoreODelegato(List<Long> idsDipartimentiDiCuiEDirettoreODelegato) {
		this.idsDipartimentiDiCuiEDirettoreODelegato = idsDipartimentiDiCuiEDirettoreODelegato;
	}

	public List<Long> getIdsDipartimentiDiCuiEVicedirettoreODelegato() {
		return idsDipartimentiDiCuiEVicedirettoreODelegato;
	}

	public void setIdsDipartimentiDiCuiEVicedirettoreODelegato(List<Long> idsDipartimentiDiCuiEVicedirettoreODelegato) {
		this.idsDipartimentiDiCuiEVicedirettoreODelegato = idsDipartimentiDiCuiEVicedirettoreODelegato;
	}

	public List<Long> getIdsDipartimentiDiCuiEResponsabileAmministrativoODelegato() {
		return idsDipartimentiDiCuiEResponsabileAmministrativoODelegato;
	}

	public void setIdsDipartimentiDiCuiEResponsabileAmministrativoODelegato(
			List<Long> idsDipartimentiDiCuiEResponsabileAmministrativoODelegato) {
		this.idsDipartimentiDiCuiEResponsabileAmministrativoODelegato = idsDipartimentiDiCuiEResponsabileAmministrativoODelegato;
	}

	public Long getIdDipartimentoCorrente() {
		return idDipartimentoCorrente;
	}

	public void setIdDipartimentoCorrente(Long idDipartimentoCorrente) {
		this.idDipartimentoCorrente = idDipartimentoCorrente;
	}

	public List<Long> getIdsDipartimenti() {
		Set<Long> ids = new HashSet<Long>();
		ids.addAll(idsDipartimentiDiCuiEDirettoreODelegato);
		ids.addAll(idsDipartimentiDiCuiEVicedirettoreODelegato);
		ids.addAll(idsDipartimentiDiCuiEResponsabileAmministrativoODelegato);
		if (getContestoCorrente() != null && getContestoCorrente().isDipartimentoImpostato())
			ids.addAll(getContestoCorrente().getIdsAnagraficheDipartimenti());
		return new ArrayList<Long>(ids);
	}
	
	public boolean haCaricheSuDipartimento() {
		return isResponsabileAmministrativoDiDipartimento() || isDirettoreOViceDiDipartimento();
	}

	public boolean isDottorando() {
		return dottorando;
	}

	public void setDottorando(boolean dottorando) {
		this.dottorando = dottorando;
	}

	public boolean isAssegnista() {
		return assegnista;
	}

	public void setAssegnista(boolean assegnista) {
		this.assegnista = assegnista;
	}

	public boolean puoEseguireJob() {
		return isPresenteDirittoApplicativo(Diritti.DirittiGestioneGenerale.ESECUZIONE_JOB.name());
	}
}

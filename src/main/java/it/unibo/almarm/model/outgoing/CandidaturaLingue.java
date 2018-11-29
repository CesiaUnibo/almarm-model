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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import it.unibo.almarm.model.lingue.Lingua;
import it.unibo.almarm.model.lingue.SottoprogrammaLingua;
import it.unibo.almarm.util.Common;
import it.unibo.almarm.webapp.mvc.CodiceDescrizione;

public class CandidaturaLingue implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Candidatura candidatura;
	private Lingua lingua1;
	private String livelloLingua1;
	private Character flagMadrelinguaLingua1;
	private Character tipoInserimentoLingua1;
	private Lingua lingua2;
	private String livelloLingua2;
	private Character flagMadrelinguaLingua2;
	private Character tipoInserimentoLingua2;
	private Integer numeroLinguaPrincipale;
	private String note;
	private Character flagInteressaLicenza;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Candidatura getCandidatura() {
		return candidatura;
	}

	public void setCandidatura(Candidatura candidatura) {
		this.candidatura = candidatura;
	}

	public Lingua getLingua1() {
		return lingua1;
	}

	public void setLingua1(Lingua lingua1) {
		this.lingua1 = lingua1;
	}

	public String getLivelloLingua1() {
		return livelloLingua1;
	}

	public void setLivelloLingua1(String livelloLingua1) {
		this.livelloLingua1 = livelloLingua1;
	}

	public Character getFlagMadrelinguaLingua1() {
		return flagMadrelinguaLingua1;
	}

	public void setFlagMadrelinguaLingua1(Character flagMadrelinguaLingua1) {
		this.flagMadrelinguaLingua1 = flagMadrelinguaLingua1;
	}

	public Character getTipoInserimentoLingua1() {
		return tipoInserimentoLingua1;
	}

	public void setTipoInserimentoLingua1(Character tipoInserimentoLingua1) {
		this.tipoInserimentoLingua1 = tipoInserimentoLingua1;
	}

	public Lingua getLingua2() {
		return lingua2;
	}

	public void setLingua2(Lingua lingua2) {
		this.lingua2 = lingua2;
	}

	public String getLivelloLingua2() {
		return livelloLingua2;
	}

	public void setLivelloLingua2(String livelloLingua2) {
		this.livelloLingua2 = livelloLingua2;
	}

	public Character getFlagMadrelinguaLingua2() {
		return flagMadrelinguaLingua2;
	}

	public void setFlagMadrelinguaLingua2(Character flagMadrelinguaLingua2) {
		this.flagMadrelinguaLingua2 = flagMadrelinguaLingua2;
	}

	public Character getTipoInserimentoLingua2() {
		return tipoInserimentoLingua2;
	}

	public void setTipoInserimentoLingua2(Character tipoInserimentoLingua2) {
		this.tipoInserimentoLingua2 = tipoInserimentoLingua2;
	}

	public Integer getNumeroLinguaPrincipale() {
		return numeroLinguaPrincipale;
	}

	public void setNumeroLinguaPrincipale(Integer numeroLinguaPrincipale) {
		this.numeroLinguaPrincipale = numeroLinguaPrincipale;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public Character getFlagInteressaLicenza() {
		return flagInteressaLicenza;
	}

	public void setFlagInteressaLicenza(Character flagInteressaLicenza) {
		this.flagInteressaLicenza = flagInteressaLicenza;
	}
	
	public boolean isInteressaLicenza() {
		return Common.CH_S.equals(flagInteressaLicenza);
	}

	private boolean isSelezionaLinguaConLivelloInAccettazione() {
		return candidatura!= null && candidatura.getBando() != null && candidatura.getBando().isSelezionaLinguaConLivelloInAccettazione();
	}

	private Integer getNumeroLinguaPrincipaleOUnicaLingua(){
		
		Integer nr = getNumeroLinguaPrincipale();
		if (nr != null) 
			return nr;
		
		// se non e' stata scelta una lingua principale e c'e' una sola lingua valida restituisco quella
		boolean isMliv = isSelezionaLinguaConLivelloInAccettazione();// mandatory liv?
		if (    (getLingua1() != null && ((!isMliv) || StringUtils.isNotBlank(getLivelloLingua1()))) 
			 && (getLingua2() == null || (isMliv && StringUtils.isBlank(getLivelloLingua2()))) )
				return new Integer(1);
		if (    (getLingua2() != null &&  ((!isMliv) || StringUtils.isNotBlank(getLivelloLingua2())))
			 && (getLingua1() == null || (isMliv && StringUtils.isBlank(getLivelloLingua1()))) )
				return new Integer(2);
		
		return null;
	}

	public Lingua getLinguaPrincipale() {
		Integer nr = getNumeroLinguaPrincipale() != null ? getNumeroLinguaPrincipale() : getNumeroLinguaPrincipaleOUnicaLingua();
		if (nr != null)	{
			if (nr.intValue() == 1)
				return getLingua1();
			if (nr.intValue() == 2)
				return getLingua2();
			throw new RuntimeException("Errore nella configurazione di candidatura lingue per la candidatura: " + getCandidatura().getId().toString() + " - numero lingua principale = " + nr.toString());
		}
		
		return null;
	}
	
	public String getLivelloLinguaPrincipale() {
		Integer nr = getNumeroLinguaPrincipale() != null ? getNumeroLinguaPrincipale() : getNumeroLinguaPrincipaleOUnicaLingua();
		if (nr != null)	{
			if (nr.intValue() == 1)
				return getLivelloLingua1();
			if (nr.intValue() == 2)
				return getLivelloLingua2();
			throw new RuntimeException("Errore nella configurazione di candidatura lingue per la candidatura: " + getCandidatura().getId().toString() + " - numero lingua principale = " + nr.toString());
		}
		
		return null;
	}

	public Character getFlagMadrelinguaLinguaPrincipale() {
		Integer nr = getNumeroLinguaPrincipale() != null ? getNumeroLinguaPrincipale() : getNumeroLinguaPrincipaleOUnicaLingua();
		if (nr != null)	{
			if (nr.intValue() == 1)
				return getFlagMadrelinguaLingua1();
			if (nr.intValue() == 2)
				return getFlagMadrelinguaLingua2();
			throw new RuntimeException("Errore nella configurazione di candidatura lingue per la candidatura: " + getCandidatura().getId().toString() + " - numero lingua principale = " + nr.toString());
		}
		
		return null;
	}
	
	public boolean isLingua1Selezionabile() {
		if (isSelezionaLinguaConLivelloInAccettazione()) {
			// Lingua 1  se ha livello o se la 2 è assente o altrettanto senza livello  
			return getLingua1() != null 
				   && ( StringUtils.isNotBlank(getLivelloLingua1()) 
					    || getLingua2() == null 
					    || StringUtils.isBlank(getLivelloLingua2()) );
		}
		return getLingua1() != null;
	}

	public boolean isLingua2Selezionabile() {
		if (isSelezionaLinguaConLivelloInAccettazione()) {
			// Lingua 2  se ha livello o se la 1 è assente o altrettanto senza livello  
			return getLingua2() != null 
				   && ( StringUtils.isNotBlank(getLivelloLingua2()) 
					    || getLingua1() == null 
					    || StringUtils.isBlank(getLivelloLingua1()) );
		}
		return getLingua2() != null;
	}
	
	// =======================================================================================================
	
	// Campo non persistito : usato nel form di accettazione per l'elenco delle lingue
	private List<SottoprogrammaLingua> listaLingueInAccettazione = new ArrayList<SottoprogrammaLingua>();
	
	// Campi non persistiti : usato nel form di accettazione per la dichiarazione di essere o meno madrelingua
	private Character flagSonoMadrelingua;
	
	public List<SottoprogrammaLingua> getListaLingueInAccettazione() {
		return listaLingueInAccettazione;
	}

	public void setListaLingueInAccettazione(
			List<SottoprogrammaLingua> listaLingueInAccettazione) {
		this.listaLingueInAccettazione = listaLingueInAccettazione;
	}

	public Character getFlagSonoMadrelingua() {
		return flagSonoMadrelingua;
	}

	public void setFlagSonoMadrelingua(Character flagSonoMadrelingua) {
		this.flagSonoMadrelingua = flagSonoMadrelingua;
	}
	
	// USATO SOLO NEL FORM DI ACCETTAZIONE PER LA SCELTA DELLA LINGUA 
	public void setLinguaPrincipaleScelta_x_idLingua(Long idLingua) {
		if (idLingua == null)
			return;
		if (getLingua2() != null && idLingua.equals(getLingua2().getId()))
			setNumeroLinguaPrincipale(new Integer(2));
		else 
			setNumeroLinguaPrincipale(new Integer(1));
		
	}

	// USATO SOLO NEL FORM DI ACCETTAZIONE PER LA SCELTA DELLA LINGUA 
	public Long  getLinguaPrincipaleScelta_x_idLingua() {
		if (getNumeroLinguaPrincipale() == null)
			return null;
		Lingua l = getLinguaPrincipale();
		return l == null ? null : l.getId(); 
	}
	
	// USATO SOLO NEL FORM DI ACCETTAZIONE PER LA SCELTA DELLA LINGUA 
	public boolean isPresenteLinguaAccettazioneConLicenzaOlsAttiva(){	
		if (listaLingueInAccettazione != null && !listaLingueInAccettazione.isEmpty())
			for (SottoprogrammaLingua sl : listaLingueInAccettazione)
				if (sl.isLicenzaOlsAttiva())
					return true;
		return false;
	}
	
	// =======================================================================================================
}

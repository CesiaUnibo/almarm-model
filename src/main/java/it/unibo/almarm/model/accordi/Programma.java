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


import it.unibo.almarm.model.flussiscambio.CodificaAreaDisciplinare;
import it.unibo.almarm.model.flussiscambio.ProgrammaCodificaAreeDisciplinari;
import it.unibo.almarm.util.Common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programma implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final Long ID_ERASMUS = 11L;
	public static final Long ID_ERASMUS_PLUS = 51L;
	public static final Long ID_CONVENZIONI_COTUTELA = 28L;
	public static final Long ID_ACCORDO_QUADRO_COTUTELE = 29L;
	public static final Long ID_SUISSE_ERASMUS = 23L;
	public static final Long ID_ACCORDI_DI_ATENEO = 21L;
	
	// Erasmus Plus,  erasmus(cessato 2014) e swiss erasmus(cessato nel 2012)
	public static final Long[] IDS_PROG_ERASMUS_RINNOVO_DOCENTI =new Long[]{ID_ERASMUS, 23L, 51L};
	
	private Long id;
	private MacroProgramma macroProgramma;
	private String nome;
	private Long annoInizioValidita;
	private Long annoFineValidita;
	private String sigla;
	private String descrizione;
	private Character flagMostraDescrizioneAccordo;
	private Character flagAnnualizzaDaPrecedente;
	private Character flagNascondiTacitoRinnovo;
	private Character defaultTacitoRinnovo;
	
	private Set<ProgrammaCodificaAreeDisciplinari> codificaAreeDisciplinari = new HashSet<ProgrammaCodificaAreeDisciplinari>();;
	private Set<SottoProgramma> sottoProgrammi = new HashSet<SottoProgramma>();
	
	// non persistito, viene passato al ProgramamManager per il
	// salvataggio delle codifiche
	private List<Long> idsCodificheAreaDisciplinare = null;
	
	// non persistito, viene passato al ProgramamManager per il
	// salvataggio della codifica di default
	private Long idCodificaDiDefault = null;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MacroProgramma getMacroProgramma() {
		return macroProgramma;
	}

	public void setMacroProgramma(MacroProgramma macroProgramma) {
		this.macroProgramma = macroProgramma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getAnnoInizioValidita() {
		return annoInizioValidita;
	}

	public void setAnnoInizioValidita(Long annoInizioValidita) {
		this.annoInizioValidita = annoInizioValidita;
	}

	public Long getAnnoFineValidita() {
		return annoFineValidita;
	}

	public void setAnnoFineValidita(Long annoFineValidita) {
		this.annoFineValidita = annoFineValidita;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Set<ProgrammaCodificaAreeDisciplinari> getCodificaAreeDisciplinari() {
		return codificaAreeDisciplinari;
	}

	public void setCodificaAreeDisciplinari(
			Set<ProgrammaCodificaAreeDisciplinari> codificaAreeDisciplinari) {
		this.codificaAreeDisciplinari = codificaAreeDisciplinari;
	}
	
	public List<CodificaAreaDisciplinare> getCodificheAreaDisciplinare() {
		List<CodificaAreaDisciplinare> codifiche = new ArrayList<CodificaAreaDisciplinare>();
		for (ProgrammaCodificaAreeDisciplinari pcad: codificaAreeDisciplinari)
			codifiche.add(pcad.getCodifica());
		return codifiche;
	}
	
	public List<Long> getIdsCodificheAreaDisciplinare() {

		if (idsCodificheAreaDisciplinare == null) {
			idsCodificheAreaDisciplinare = new ArrayList<Long>();
			for (CodificaAreaDisciplinare cad: getCodificheAreaDisciplinare())
				idsCodificheAreaDisciplinare.add(cad.getId());
		}

		return idsCodificheAreaDisciplinare;
	}
	
	public void setIdsCodificheAreaDisciplinare(String[] ids) {

		if (idsCodificheAreaDisciplinare == null)
			idsCodificheAreaDisciplinare = new ArrayList<Long>();
		
		idsCodificheAreaDisciplinare.clear();
		if (ids != null){
			for (String id: ids)
				idsCodificheAreaDisciplinare.add(Long.parseLong((id)));
		}
	}

	public void setIdCodificaDiDefault(Long idCodificaDiDefault) {
		this.idCodificaDiDefault = idCodificaDiDefault;
	}

	public Long getIdCodificaDiDefault() {
		if (idCodificaDiDefault == null) {
			for (ProgrammaCodificaAreeDisciplinari pcad: codificaAreeDisciplinari) {
				if (pcad.getCodificaDidefault() != null && 1L == pcad.getCodificaDidefault()) {
					idCodificaDiDefault = pcad.getCodifica().getId();
				}
			}
		}
		return idCodificaDiDefault;
	}

	public Set<SottoProgramma> getSottoProgrammi() {
		return sottoProgrammi;
	}

	public void setSottoProgrammi(Set<SottoProgramma> sottoProgrammi) {
		this.sottoProgrammi = sottoProgrammi;
	}
	
	public Programma(){
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((macroProgramma == null) ? 0 : macroProgramma.hashCode());
		result = prime
				* result
				+ ((annoInizioValidita == null) ? 0 : annoInizioValidita.hashCode());
		result = prime
				* result
				+ ((annoFineValidita == null) ? 0 : annoFineValidita.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Programma))
			return false;
		Programma other = (Programma) obj;
		if (this.id != null && other.getId() != null)
			return this.id.equals(other.getId()); 
		if (nome == null) {
			if (other.getNome() != null)
				return false;
		} else if (!nome.equals(other.getNome()))
			return false;
		if (getMacroProgramma() == null) {
			if (other.getMacroProgramma() != null)
				return false;
		} else if (!getMacroProgramma().equals(other.getMacroProgramma()))
			return false;
		if (annoInizioValidita == null) {
			if (other.getAnnoInizioValidita() != null)
				return false;
		} else if (!annoInizioValidita.equals(other.getAnnoInizioValidita()))
			return false;
		if (annoFineValidita == null) {
			if (other.getAnnoFineValidita() != null)
				return false;
		} else if (!annoFineValidita.equals(other.getAnnoFineValidita()))
			return false;
		return true;
	}

	public Character getFlagMostraDescrizioneAccordo() {
		if (flagMostraDescrizioneAccordo == null)
			return 'N';
		return flagMostraDescrizioneAccordo;
	}

	public void setFlagMostraDescrizioneAccordo(
			Character flagMostraDescrizioneAccordo) {
		this.flagMostraDescrizioneAccordo = flagMostraDescrizioneAccordo;
	}
	
	public boolean isMostraDescrizioneAccordo() {
		return Common.CH_S.equals(getFlagMostraDescrizioneAccordo());
	}

	public Character getFlagAnnualizzaDaPrecedente() {
		if (flagAnnualizzaDaPrecedente == null)
			return 'N';
		return flagAnnualizzaDaPrecedente;
	}

	public void setFlagAnnualizzaDaPrecedente(Character flagAnnualizzaDaPrecedente) {
		this.flagAnnualizzaDaPrecedente = flagAnnualizzaDaPrecedente;
	}
	
	public boolean isAnnualizzaDaPrecedente() {
		return Common.CH_S.equals(flagAnnualizzaDaPrecedente);
	}
	// Agosto 2013 : aggiunto eplus 
	// Luglio 2014 : aggiunto Suisse erasmus 
	// Il metodo identifica la "Famiglia comportamentale" con la logica applicativa erasmus
	public boolean isErasmus() {
		return id.equals(ID_ERASMUS) || id.equals(ID_ERASMUS_PLUS) || isSuisseErasmus();
	}
	
	public boolean isErasmusPlus() {
		return id.equals(ID_ERASMUS_PLUS);
	}
	
	public Character getFlagNascondiTacitoRinnovo() {
		if (flagNascondiTacitoRinnovo == null)
			return 'N';
		return flagNascondiTacitoRinnovo;
	}

	public void setFlagNascondiTacitoRinnovo(Character flagNascondiTacitoRinnovo) {
		this.flagNascondiTacitoRinnovo = flagNascondiTacitoRinnovo;
	}

	public boolean isNascondiTacitoRinnovo() {
		return Common.CH_S.equals(flagNascondiTacitoRinnovo);
	}
	
	public Character getDefaultTacitoRinnovo() {
		if (defaultTacitoRinnovo == null)
			return 'N';
		return defaultTacitoRinnovo;
	}

	public void setDefaultTacitoRinnovo(Character defaultTacitoRinnovo) {
		this.defaultTacitoRinnovo = defaultTacitoRinnovo;
	}
	
	public boolean isConvenzioneCotutela() {
		return ID_CONVENZIONI_COTUTELA.equals(id);
	}
	
	public boolean isAccordoQuadroCotutele() {
		return ID_ACCORDO_QUADRO_COTUTELE.equals(id);
	}
	
	public boolean isPerCotutela() {
		return isConvenzioneCotutela() || isAccordoQuadroCotutele();
	}
	
	public boolean isSuisseErasmus() {
		return id.equals(ID_SUISSE_ERASMUS);
	}
	
	public boolean isAccordiDiAteneo(){
		return id.equals(ID_ACCORDI_DI_ATENEO);
	}
}

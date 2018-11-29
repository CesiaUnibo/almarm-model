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
package it.unibo.almarm.model.outgoing.learningagreement;

import it.unibo.almarm.util.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class BloccoAttivita implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer posizione;
	private SortedSet<AttivitaEstera> attivitaEstere = new TreeSet<AttivitaEstera>(new AttivitaEsteraComparator());
	private SortedSet<AttivitaUnibo> attivitaUnibo = new TreeSet<AttivitaUnibo>(new AttivitaUniboComparator());
	private Character flagAggiuntoInRichiestaRiconoscimento;
	private Character flagCopiatoDaVersioneLaPrecedente;
	private BloccoAttivita bloccoPrecedente;
	private Character flagCancellato;
	
	private LearningAgreement learningAgreement;
	
	// campi non persistiti
	private String codiciMaterieAttFuoriPiani;
	private List<String> materieStudente = new ArrayList<String>();
	private List<String> materieNoCarriera = new ArrayList<String>();
	private String elencoCfuExtra;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPosizione() {
		return posizione;
	}

	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}

	public SortedSet<AttivitaEstera> getAttivitaEstere() {
		// controllo che tutte le attivita estere abbiano il campo order compilato
		boolean ricalcolaOrdine = false;
		int max = 0;
		for (AttivitaEstera ae: attivitaEstere)
		{
			if (ae.getOrder() == null)
				ricalcolaOrdine = true;
			else if (ae.getOrder() > max)
				max = ae.getOrder();
		}
		if (ricalcolaOrdine)
			for (AttivitaEstera ae: attivitaEstere)
				if (ae.getOrder() == null)
					ae.setOrder(++max);
		return attivitaEstere;
	}

	public void setAttivitaEstere(SortedSet<AttivitaEstera> attivitaEstere) {
		this.attivitaEstere = attivitaEstere;
	}

	public SortedSet<AttivitaUnibo> getAttivitaUnibo() {
		// controllo che tutte le attivita abbiano il campo order compilato
		boolean ricalcolaOrdine = false;
		int max = 0;
		for (AttivitaUnibo au: attivitaUnibo)
		{
			if (au.getOrder() == null)
				ricalcolaOrdine = true;
			else if (au.getOrder() > max)
				max = au.getOrder();
		}
		if (ricalcolaOrdine)
			for (AttivitaUnibo au: attivitaUnibo)
				if (au.getOrder() == null)
					au.setOrder(++max);
		return attivitaUnibo;
	}

	public void setAttivitaUnibo(SortedSet<AttivitaUnibo> attivitaUnibo) {
		this.attivitaUnibo = attivitaUnibo;
	}

	public void addAttivitaEstera(AttivitaEstera attivitaEstera) {
		if (attivitaEstere == null)
			attivitaEstere = new TreeSet<AttivitaEstera>(new AttivitaEsteraComparator());
		if (attivitaEstera.getOrder() == null)
		{
			int max = 0;
			for (AttivitaEstera ae: attivitaEstere)
				if (ae.getOrder() != null && ae.getOrder() > max)
					max = ae.getOrder();
			attivitaEstera.setOrder(max + 1);
		}
		attivitaEstere.add(attivitaEstera);
	}
	
	
	public void addAttivitaUnibo(AttivitaUnibo attivitaUnibo) {
		if (this.attivitaUnibo == null)
			this.attivitaUnibo = new TreeSet<AttivitaUnibo>(new AttivitaUniboComparator());
		if (attivitaUnibo.getOrder() == null)
		{
			int max = 0;
			for (AttivitaUnibo au: this.attivitaUnibo)
				if (au.getOrder() != null && au.getOrder() > max)
					max = au.getOrder();
			attivitaUnibo.setOrder(max + 1);
		}
		this.attivitaUnibo.add(attivitaUnibo);
	}
	
	public List<AttivitaEstera> getAttivitaEstereList() {
		return new ArrayList<AttivitaEstera>(getAttivitaEstere());
	}
	
	public List<AttivitaUnibo> getAttivitaUniboList() {
		return new ArrayList<AttivitaUnibo>(attivitaUnibo);
	}
	
	public List<AttivitaEstera> getAttivitaEstereNonModificabiliList() {
		if (!getLearningAgreement().getStudenteOutgoing().getBando().isTracciamentoModificheInLaAttivo())
			return null;
		ArrayList<AttivitaEstera> ret = new ArrayList<AttivitaEstera>();
		for (AttivitaEstera ae: getAttivitaEstere())
			if (ae.isCopiataDaVersioneLaPrecedente() || (this.isCancellato() && ae.isAttiva()))
				ret.add(ae);
		return ret;
	}
	
	public List<AttivitaUnibo> getAttivitaUniboNonModificabiliList() {
		if (!getLearningAgreement().getStudenteOutgoing().getBando().isTracciamentoModificheInLaAttivo())
			return null;
		if (this.isCancellato())
			return new ArrayList<AttivitaUnibo>(attivitaUnibo);
		ArrayList<AttivitaUnibo> ret = new ArrayList<AttivitaUnibo>();
		for (AttivitaUnibo au: getAttivitaUnibo())
			if (au.isCopiataDaVersioneLaPrecedente())
				ret.add(au);
		return ret;
	}
	
	public List<AttivitaEstera> getAttivitaEstereModificabiliList() {
		if (!getLearningAgreement().getStudenteOutgoing().getBando().isTracciamentoModificheInLaAttivo())
			return new ArrayList<AttivitaEstera>(getAttivitaEstere());
		if (this.isCancellato())
			return null;
		ArrayList<AttivitaEstera> ret = new ArrayList<AttivitaEstera>();
		for (AttivitaEstera ae: getAttivitaEstere())
			if (!ae.isCopiataDaVersioneLaPrecedente())
				ret.add(ae);
		return ret;
	}
	
	public List<AttivitaUnibo> getAttivitaUniboModificabiliList() {
		if (!getLearningAgreement().getStudenteOutgoing().getBando().isTracciamentoModificheInLaAttivo())
			return new ArrayList<AttivitaUnibo>(attivitaUnibo);
		if (this.isCancellato())
			return null;
		ArrayList<AttivitaUnibo> ret = new ArrayList<AttivitaUnibo>();
		for (AttivitaUnibo au: getAttivitaUnibo())
			if (!au.isCopiataDaVersioneLaPrecedente())
				ret.add(au);
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (getId() != null)
			result = prime * result
				+ ((getId() == null) ? 0 : getId().hashCode());
		else
			result = prime * result
				+ ((posizione == null) ? 0 : posizione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BloccoAttivita))
			return false;
		BloccoAttivita other = (BloccoAttivita) obj;
		if (getId() != null) {
			if (getId().equals(other.getId()))
				return true;
		} 
		if (posizione == null) {
			if (other.posizione != null)
				return false;
		} else if (!posizione.equals(other.posizione))
			return false;
		return true;
	}

	public String getCodiciMaterieAttFuoriPiani() {
		if (codiciMaterieAttFuoriPiani == null)
			return "";
		return codiciMaterieAttFuoriPiani;
	}

	public void setCodiciMaterieAttFuoriPiani(
			String codiciMaterieAttFuoriPiani) {
		this.codiciMaterieAttFuoriPiani = codiciMaterieAttFuoriPiani;
	}

	public List<String> getMaterieStudente() {
		return materieStudente;
	}

	public void setMaterieStudente(List<String> materieStudente) {
		this.materieStudente = materieStudente;
	}

	public List<String> getMaterieNoCarriera() {
		return materieNoCarriera;
	}

	public void setMaterieNoCarriera(List<String> materieNoCarriera) {
		this.materieNoCarriera = materieNoCarriera;
	}

	public Integer getCfuTotaliProposti() {
		int ret = 0;
		for (AttivitaUnibo au: attivitaUnibo)
			if (!au.isDaNonRiconoscere() && !au.isRiconoscimentoNegato() && !au.isCancellata())
				ret += au.getCfuRiconosciuti() != null ? au.getCfuRiconosciuti() : (au.getCfuProposti() != null ? au.getCfuProposti() : au.getCfu() != null ? au.getCfu() : 0);
		return ret;
	}
	
	public Float getEctsTotaliProposti() {
		Float ret = 0F;
		for (AttivitaEstera ae: attivitaEstere)
			if (!ae.isNonSvolta() && !ae.isDaNonRiconoscere() && !ae.isCancellata())
				ret += ae.getEctsProposti() != null ? ae.getEctsProposti() : 0;
		return ret;
	}
	
	public String getEctsTotaliPropostiLbl() {
		Float ret = getEctsTotaliProposti();
		return Common.convertFloatToString(ret);
	}

	public LearningAgreement getLearningAgreement() {
		return learningAgreement;
	}

	public void setLearningAgreement(LearningAgreement learningAgreement) {
		this.learningAgreement = learningAgreement;
	}
	
	public String getLabelEcts() {
		return getLearningAgreement().getLabelEcts();
	}
	
	public BloccoAttivita copy() {
		BloccoAttivita ba = new BloccoAttivita();
		ba.setPosizione(posizione);
		for (AttivitaEstera ae: attivitaEstere)
		{
			if (!(this.getLearningAgreement().isApprovato() && ae.isCancellata()))
			{
				AttivitaEstera newAe = ae.copy();
				newAe.setBloccoAttivita(ba);
				ba.addAttivitaEstera(newAe);
			}
		}
		if (!(getLearningAgreement().isForTraineeship() && getLearningAgreement().getStudenteOutgoing().isTirocinioPerLaureati()))
			for (AttivitaUnibo au: attivitaUnibo)
			{
				if (!(this.getLearningAgreement().isApprovato() && au.isCancellata()))
				{
					AttivitaUnibo newAu = au.copy();
					ba.addAttivitaUnibo(newAu);
				}
			}
		ba.setFlagAggiuntoInRichiestaRiconoscimento(flagAggiuntoInRichiestaRiconoscimento);
		ba.setBloccoPrecedente(this); 
		if (this.getLearningAgreement().isApprovato())
			ba.setFlagCopiatoDaVersioneLaPrecedente('S');
		else
		{
			ba.setFlagCopiatoDaVersioneLaPrecedente(this.getFlagCopiatoDaVersioneLaPrecedente());
			ba.setFlagCancellato(this.getFlagCancellato());
		}
		return ba;
	}

	public String getElencoCfuExtra() {
		return elencoCfuExtra;
	}

	public void setElencoCfuExtra(String elencoCfuExtra) {
		this.elencoCfuExtra = elencoCfuExtra;
	}
	
	public List<AttivitaEstera> getAttivitaEstereDaLAList() {
		List<AttivitaEstera> l = new ArrayList<AttivitaEstera>();
		for (AttivitaEstera ae: getAttivitaEstereList())
			if (!ae.isAggiuntaInRichiestaRiconoscimento())
				l.add(ae);
		return l;
	}
	
	public List<AttivitaEstera> getAttivitaEstereNonDaLAList() {
		List<AttivitaEstera> l = new ArrayList<AttivitaEstera>();
		for (AttivitaEstera ae: getAttivitaEstereList())
			if (ae.isAggiuntaInRichiestaRiconoscimento())
				l.add(ae);
		return l;
	}

	public Character getFlagAggiuntoInRichiestaRiconoscimento() {
		if (flagAggiuntoInRichiestaRiconoscimento == null)
			return 'N';
		return flagAggiuntoInRichiestaRiconoscimento;
	}

	public void setFlagAggiuntoInRichiestaRiconoscimento(
			Character flagAggiuntoInRichiestaRiconoscimento) {
		this.flagAggiuntoInRichiestaRiconoscimento = flagAggiuntoInRichiestaRiconoscimento;
	}
	
	public boolean isAggiuntoInRichiestaRiconoscimento() {
		return Common.CH_S.equals(getFlagAggiuntoInRichiestaRiconoscimento());
	}
	
	public List<AttivitaUnibo> getAttivitaUniboDaLAList() {
		List<AttivitaUnibo> l = new ArrayList<AttivitaUnibo>();
		for (AttivitaUnibo au: getAttivitaUniboList())
			if (!au.isAggiuntaInRichiestaRiconoscimento())
				l.add(au);
		return l;
	}
	
	public List<AttivitaUnibo> getAttivitaUniboNonDaLAList() {
		List<AttivitaUnibo> l = new ArrayList<AttivitaUnibo>();
		for (AttivitaUnibo au: getAttivitaUniboList())
			if (au.isAggiuntaInRichiestaRiconoscimento())
				l.add(au);
		return l;
	}
	
	public boolean isCompletamenteSoddisfatto() {
		for (AttivitaEstera ae: attivitaEstere)
			if (ae.isAggiuntaInRichiestaRiconoscimento() || !ae.isDaRiconoscere())
				return false;
		for (AttivitaUnibo au: attivitaUnibo)
			if (au.isAggiuntaInRichiestaRiconoscimento() || !au.isDaRiconoscere())
				return false;
		return true;
	}

	// Ritorna una copia identica del blocco a meno degli ID. Utilizzato per storicizzazione
	public BloccoAttivita clona() {
		BloccoAttivita clone = new BloccoAttivita();
		
		clone.setPosizione(this.getPosizione());
		clone.setFlagAggiuntoInRichiestaRiconoscimento(this.getFlagAggiuntoInRichiestaRiconoscimento());
		clone.setLearningAgreement(this.getLearningAgreement());
		clone.setFlagCopiatoDaVersioneLaPrecedente(this.getFlagCopiatoDaVersioneLaPrecedente());
		clone.setBloccoPrecedente(this.getBloccoPrecedente());
		clone.setFlagCancellato(this.getFlagCancellato());
		
		clone.setAttivitaEstere(new TreeSet<AttivitaEstera>(new AttivitaEsteraComparator()));
		clone.setAttivitaUnibo(new TreeSet<AttivitaUnibo>(new AttivitaUniboComparator()));
		for (AttivitaEstera ae: getAttivitaEstere())
			clone.getAttivitaEstere().add(ae.clona());
		for (AttivitaUnibo au: getAttivitaUnibo())
			clone.getAttivitaUnibo().add(au.clona());
		
		return clone;
	}

	public Character getFlagCopiatoDaVersioneLaPrecedente() {
		return flagCopiatoDaVersioneLaPrecedente;
	}

	public void setFlagCopiatoDaVersioneLaPrecedente(
			Character flagCopiatoDaVersioneLaPrecedente) {
		this.flagCopiatoDaVersioneLaPrecedente = flagCopiatoDaVersioneLaPrecedente;
	}
	
	public boolean isCopiatoDaVersioneLaPrecedente() {
		return Common.CH_S.equals(getFlagCopiatoDaVersioneLaPrecedente());
	}

	public BloccoAttivita getBloccoPrecedente() {
		return bloccoPrecedente;
	}

	public void setBloccoPrecedente(BloccoAttivita bloccoPrecedente) {
		this.bloccoPrecedente = bloccoPrecedente;
	}

	public Character getFlagCancellato() {
		if (flagCancellato == null)
			return 'N';
		return flagCancellato;
	}

	public void setFlagCancellato(Character flagCancellato) {
		
		this.flagCancellato = flagCancellato;
	}
	
	public boolean isCancellato() {
		return Common.CH_S.equals(getFlagCancellato());
	}
}

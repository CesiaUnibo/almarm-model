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
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.outgoing.Offerta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlussoScambioEsecuzione implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long posti;
	private Character direzione;
	private Long durata;
	private UnitaMisuraDurata unitaMisuraDurata;
	private Long orePerDurata;
	private ScambioEsecuzione scambioEsecuzione;
	private AreaDisciplinare areaDisciplinare;
	private Set<FlussoEsecuzioneSottoTarget> sottoTarget;
	private Long durataTotale;
	private Character flagDurataTotaleAttiva;
	private Long varianteAnnualePosti;
	
	private Set<Offerta> offerte = new HashSet<Offerta>();
	
	// campi non persistiti
	private List<String> idsSottoTarget;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPosti() {
		return posti;
	}

	public void setPosti(Long posti) {
		this.posti = posti;
	}

	public Character getDirezione() {
		return direzione;
	}

	public void setDirezione(Character direzione) {
		this.direzione = direzione;
	}

	public Long getDurata() {
		return durata;
	}

	public void setDurata(Long durata) {
		this.durata = durata;
	}
	
	public UnitaMisuraDurata getUnitaMisuraDurata() {
		return unitaMisuraDurata;
	}

	public void setUnitaMisuraDurata(UnitaMisuraDurata unitaMisuraDurata) {
		this.unitaMisuraDurata = unitaMisuraDurata;
	}

	public ScambioEsecuzione getScambioEsecuzione() {
		return scambioEsecuzione;
	}

	public void setScambioEsecuzione(ScambioEsecuzione scambioEsecuzione) {
		this.scambioEsecuzione = scambioEsecuzione;
	}

	public AreaDisciplinare getAreaDisciplinare() {
		return areaDisciplinare;
	}

	public void setAreaDisciplinare(AreaDisciplinare areaDisciplinare) {
		this.areaDisciplinare = areaDisciplinare;
	}

	public Set<FlussoEsecuzioneSottoTarget> getSottoTarget() {
		return sottoTarget;
	}

	public void setSottoTarget(Set<FlussoEsecuzioneSottoTarget> sottoTarget) {
		this.sottoTarget = sottoTarget;
	}
	
	public Persona getReferenteInterno() {
		return getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo().getReferenteInterno();
	}
	public Persona getReferenteOperativo() {
		return getScambioEsecuzione().getEsecuzioneAccordo().getReferenteOperativo();
	}

	public HashMap<Long, Boolean> getMapSottoTargetAbilitati() {
		HashMap<Long, Boolean> map = new HashMap<Long, Boolean>();
		if (scambioEsecuzione.getTarget() == null || scambioEsecuzione.getTarget().getSottoTarget() == null)
			return map;
		for (SottoTarget st: scambioEsecuzione.getTarget().getSottoTarget())
		{
			boolean esiste = false;
			for (FlussoEsecuzioneSottoTarget fas: sottoTarget)
				if (fas.getAmmesso().equals(st))
				{
					esiste = true;
					break;
				}
			if (esiste)
				map.put(st.getId(), true);
			else
				map.put(st.getId(), false);
		}
				
		return map;
	}
	
	public void setMapSottoTargetAbilitati(HashMap<Long, Boolean> map) {
		// rimuovo
		for (FlussoEsecuzioneSottoTarget fas: sottoTarget)
			if (!map.get(fas.getAmmesso().getId()))
					sottoTarget.remove(fas);
		// aggiungo
		HashMap<Long, Boolean> omap = getMapSottoTargetAbilitati();
		for (Long id: map.keySet())
			if (map.get(id) && !omap.get(id))
			{
				FlussoEsecuzioneSottoTarget fest = new FlussoEsecuzioneSottoTarget();
				for (SottoTarget st: scambioEsecuzione.getTarget().getSottoTarget())
					if (st.getId().equals(id))
					{
						fest.setAmmesso(st);
						fest.setRiconosciuto(st);
						break;
					}
				sottoTarget.add(fest );
			}
	}

	public Long getDurataTotale() {
		return durataTotale;
	}

	public void setDurataTotale(Long durataTotale) {
		this.durataTotale = durataTotale;
	}

	public Character getFlagDurataTotaleAttiva() {
		return flagDurataTotaleAttiva;
	}

	public void setFlagDurataTotaleAttiva(Character flagDurataTotaleAttiva) {
		this.flagDurataTotaleAttiva = flagDurataTotaleAttiva;
	}

	public Long getOrePerDurata() {
		return orePerDurata;
	}

	public void setOrePerDurata(Long orePerDurata) {
		this.orePerDurata = orePerDurata;
	}
	
	public String getLabelReferentiAccordo () {
		if (getScambioEsecuzione()!= null && getScambioEsecuzione().getEsecuzioneAccordo() != null && getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo() != null)
		{
			String referenti = "";
			if (getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo().getReferenteInterno() != null)
				referenti += getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo().getReferenteInterno().getCognomeNome() + " - ";
			if (getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo().getReferenteEsterno() != null)
				referenti += getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo().getReferenteEsterno().getCognomeNome();
			return referenti;
		}
		return "";		
	}
	
	public AccordoOperativo getAccordoOperativo () {
		if (getScambioEsecuzione()!= null && getScambioEsecuzione().getEsecuzioneAccordo() != null && getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo() != null)
			return getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo();
		return null;
	}

	public PeriodoMobilita getPeriodoMobilita () {
		if (getScambioEsecuzione()!= null && getScambioEsecuzione().getEsecuzioneAccordo() != null && getScambioEsecuzione().getEsecuzioneAccordo().getPeriodoMobilita() != null)
			return getScambioEsecuzione().getEsecuzioneAccordo().getPeriodoMobilita();
		return null;
	}

	public String getSiglaCampus () {
		if (getScambioEsecuzione()!= null )
			return getScambioEsecuzione().getSiglaCampus();
		return "";		
	}
	
	public static class FlussoScambioEsecuzioneComparator implements Comparator<FlussoScambioEsecuzione>
	{
		public int compare(FlussoScambioEsecuzione o1, FlussoScambioEsecuzione o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null || o1.getLabelReferentiAccordo() == null)
				return 1;
			if (o2 == null || o2.getLabelReferentiAccordo() == null)
				return -1;
			return o1.getLabelReferentiAccordo().compareTo(o2.getLabelReferentiAccordo());
		}
	}

	public List<String> getIdsSottoTarget() {
		if (idsSottoTarget == null)
		{
			idsSottoTarget = new ArrayList<String>();
			idsSottoTarget.clear();
			for (FlussoEsecuzioneSottoTarget st:sottoTarget)
				idsSottoTarget.add(st.getAmmesso().getId().toString());
		}
		return idsSottoTarget;
	}

	public void setIdsSottoTarget(List<String> idsSottoTarget) {
		if (idsSottoTarget == null)
			idsSottoTarget = new ArrayList<String>();
		this.idsSottoTarget = idsSottoTarget;
	}

	public Set<Offerta> getOfferte() {
		return offerte;
	}

	public void setOfferte(Set<Offerta> offerte) {
		this.offerte = offerte;
	}
	
	public Set<Offerta> getOffertePredefinite() {
		if (offerte == null)
			return null;
		Set<Offerta> ret = new HashSet<Offerta>();
		for (Offerta o: offerte)
			if (o.isPredefinita())
				ret.add(o);
		return ret;
	}
	
	public Set<Offerta> getOfferteNonPredefinite() {
		if (offerte == null)
			return null;
		Set<Offerta> ret = new HashSet<Offerta>();
		for (Offerta o: offerte)
			if (!o.isPredefinita())
				ret.add(o);
		return ret;
	}
	
	public long getPostiDaOffrire()
	{
		Long postiOfferti=0L;
		if (!offerte.isEmpty())
			for (Offerta o: offerte)
				postiOfferti+=(o.getPosti() != null && (!o.isProposta())) ? o.getPosti() : 0L;

		// Dal 2012-13
		Long postiEffettivi=getPostiEffettivi();
		return (postiEffettivi>postiOfferti) ? (postiEffettivi - postiOfferti) : 0L;
	}
	
	public long getPostiSuOfferte()
	{
		Long postiOfferti=0L;
		if (!offerte.isEmpty())
			for (Offerta o: offerte)
				postiOfferti+=(o.getPosti()!=null)? o.getPosti() : 0L;
		
		return postiOfferti; 
	}

	public Ateneo getAteneoReferente() {
		if (getAccordoOperativo() == null)
			return null;
		return getAccordoOperativo().getAteneoPartnerReferente();
	}
	
	public Ateneo getAteneoBeneficiario() {
		if (getScambioEsecuzione() == null)
			return null;
		return getScambioEsecuzione().getAteneoBeneficiario();
	}
	
	public Ateneo getAteneo() {
		Ateneo ateneo = getAteneoBeneficiario();
		if (ateneo == null)
			return getAteneoReferente();
		return ateneo;
	}

	public Long getVarianteAnnualePosti() {
		return varianteAnnualePosti == null ? 0L : varianteAnnualePosti;
	}

	public void setVarianteAnnualePosti(Long varianteAnnualePosti) {
		this.varianteAnnualePosti = varianteAnnualePosti;
	}
	
	public Long getPostiEffettivi() {
		Long postiEffettivi = (this.posti == null ? 0 : this.posti) + (this.varianteAnnualePosti == null? 0 : this.varianteAnnualePosti);
		return postiEffettivi >= 0L ? postiEffettivi : 0L;
	}
	
	public boolean isAlmenoUnaOffertaAttiva(){
		if (!getOfferte().isEmpty())
			for (Offerta o:offerte)
				if(!"proposta".equals(o.getStato()))
						return true;
		return false;
	}
	
	public boolean isAlmenoUnaOffertaProposta(){
		if (!getOfferte().isEmpty())
			for (Offerta o:offerte)
				if("proposta".equals(o.getStato()))
						return true;
		return false;
	}

	public long getPostiSuOfferteAttive()
	{
		Long postiOfferti=0L;
		if (!offerte.isEmpty())
			for (Offerta o: offerte)
				postiOfferti+=(o.getPosti()!=null && (!o.isProposta()))? o.getPosti() : 0L;
		
		return postiOfferti; 
	}

	public int getOfferteAttiveCount()
	{
		int cnt=0;
		if (!offerte.isEmpty())
			for (Offerta o: offerte)
				if(!o.isProposta())
					cnt++;
		
		return cnt; 
	}

	public boolean isHaVariazioneAnnualePosti(){
		return getVarianteAnnualePosti().intValue() != 0;
	}

	public boolean isAperturaOffertaLiberaATutteLeVicepresidenze(){
		return getScambioEsecuzione().getSottoProgramma().isAperturaOffertaLiberaATutteLeVicepresidenze();
	}

	public boolean isNoteInterneOffertaVisibili(){
		return getScambioEsecuzione().getSottoProgramma().isNoteInterneOffertaVisibili();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaDisciplinare == null) ? 0 : areaDisciplinare.hashCode());
		result = prime * result + ((direzione == null) ? 0 : direzione.hashCode());
		result = prime * result + ((durata == null) ? 0 : durata.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idsSottoTarget == null) ? 0 : idsSottoTarget.hashCode());
		result = prime * result + ((scambioEsecuzione == null) ? 0 : scambioEsecuzione.hashCode());
		result = prime * result + ((sottoTarget == null) ? 0 : sottoTarget.hashCode());
		result = prime * result + ((unitaMisuraDurata == null) ? 0 : unitaMisuraDurata.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FlussoScambioEsecuzione))
			return false;
		FlussoScambioEsecuzione other = (FlussoScambioEsecuzione) obj;
		if (getAreaDisciplinare() == null) {
			if (other.getAreaDisciplinare() != null)
				return false;
		} else if (!getAreaDisciplinare().equals(other.getAreaDisciplinare()))
			return false;
		if (getDirezione() == null) {
			if (other.getDirezione() != null)
				return false;
		} else if (!getDirezione().equals(other.getDirezione()))
			return false;
		if (getDurata() == null) {
			if (other.getDurata() != null)
				return false;
		} else if (!getDurata().equals(other.getDurata()))
			return false;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (getIdsSottoTarget() == null) {
			if (other.getIdsSottoTarget() != null)
				return false;
		} else if (!getIdsSottoTarget().equals(other.getIdsSottoTarget()))
			return false;
		if (getScambioEsecuzione() == null) {
			if (other.getScambioEsecuzione() != null)
				return false;
		} else if (!getScambioEsecuzione().equals(other.getScambioEsecuzione()))
			return false;
		if (getSottoTarget() == null) {
			if (other.getSottoTarget() != null)
				return false;
		} else if (!getSottoTarget().equals(other.getSottoTarget()))
			return false;
		if (getUnitaMisuraDurata() == null) {
			if (other.getUnitaMisuraDurata() != null)
				return false;
		} else if (!getUnitaMisuraDurata().equals(other.getUnitaMisuraDurata()))
			return false;
		return true;
	}

}

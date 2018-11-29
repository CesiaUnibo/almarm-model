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

import it.unibo.almarm.util.Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class FlussoAccordo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private ScambioAccordo scambioAccordo;
	private AreaDisciplinare areaDisciplinare;
	private Character direzione;
	private Long posti;
	private UnitaMisuraDurata unitaMisuraDurata;
	private Long durata;
	private Long orePerDurata;
	private Set<FlussoAccordoSottoTarget> sottoTarget;
	private Long durataTotale;
	private Character flagDurataTotaleAttiva;
	
	// campi non persistiti
	private List<String> idsSottoTarget;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ScambioAccordo getScambioAccordo() {
		return scambioAccordo;
	}
	public void setScambioAccordo(ScambioAccordo scambioAccordo) {
		this.scambioAccordo = scambioAccordo;
	}
	public AreaDisciplinare getAreaDisciplinare() {
		return areaDisciplinare;
	}
	public void setAreaDisciplinare(AreaDisciplinare areaDisciplinare) {
		this.areaDisciplinare = areaDisciplinare;
	}
	public Character getDirezione() {
		return direzione;
	}
	public void setDirezione(Character direzione) {
		this.direzione = direzione;
	}
	public Long getPosti() {
		return posti;
	}
	public void setPosti(Long posti) {
		this.posti = posti;
	}	
	public UnitaMisuraDurata getUnitaMisuraDurata() {
		return unitaMisuraDurata;
	}
	public void setUnitaMisuraDurata(UnitaMisuraDurata unitaMisuraDurata) {
		this.unitaMisuraDurata = unitaMisuraDurata;
	}
	public Long getDurata() {
		return durata;
	}
	public void setDurata(Long durata) {
		this.durata = durata;
	}
	public Set<FlussoAccordoSottoTarget> getSottoTarget() {
		return sottoTarget;
	}
	public void setSottoTarget(Set<FlussoAccordoSottoTarget> sottoTarget) {
		this.sottoTarget = sottoTarget;
	}
	public Long getOrePerDurata() {
		return orePerDurata;
	}
	public void setOrePerDurata(Long orePerDurata) {
		this.orePerDurata = orePerDurata;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((areaDisciplinare == null) ? 0 : areaDisciplinare.hashCode());
		result = prime * result
				+ ((direzione == null) ? 0 : direzione.hashCode());
		result = prime * result
				+ ((scambioAccordo == null) ? 0 : scambioAccordo.hashCode());
		result = prime * result
				+ ((sottoTarget == null) ? 0 : sottoTarget.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FlussoAccordo))
			return false;
		FlussoAccordo other = (FlussoAccordo) obj;
		if (areaDisciplinare == null) {
			if (other.areaDisciplinare != null)
				return false;
		} else if (!areaDisciplinare.equals(other.areaDisciplinare))
			return false;
		if (direzione == null) {
			if (other.direzione != null)
				return false;
		} else if (!direzione.equals(other.direzione))
			return false;
		if (scambioAccordo == null) {
			if (other.scambioAccordo != null)
				return false;
		} else if (!scambioAccordo.equals(other.scambioAccordo))
			return false;
		if (sottoTarget == null) {
			if (other.sottoTarget != null)
				return false;
		} else if (!sottoTarget.equals(other.sottoTarget))
			return false;
		return true;
	}
	
	public String getResponsabiliDesc() {
		// TODO
		return "";
	}
	
	public String getDurataDesc() {
		return (durata != null ? durata.toString() : "") 
				+ " " 
				+ (unitaMisuraDurata != null ? unitaMisuraDurata.getUnita() : "");
	}
    // 2014 agosto: aggiunto per contratto partner
	public String getDurataDescIng() {
		return (durata != null ? durata.toString() : "") 
				+ " " 
				+ (unitaMisuraDurata != null ? unitaMisuraDurata.getUnitaIng() : "");
	}
	
	public HashMap<Long, Boolean> getMapSottoTargetAbilitati() {
		HashMap<Long, Boolean> map = new HashMap<Long, Boolean>();
		if (scambioAccordo.getTarget() == null || scambioAccordo.getTarget().getSottoTarget() == null)
			return map;
		for (SottoTarget st: scambioAccordo.getTarget().getSottoTarget())
		{
			boolean esiste = false;
			for (FlussoAccordoSottoTarget fas: sottoTarget)
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
	public List<Long> getSottoTargetAbilitati() {
		List<Long> l=new ArrayList<Long>();
		if (scambioAccordo.getTarget() == null || scambioAccordo.getTarget().getSottoTarget() == null)
			return l;
		for (SottoTarget st: scambioAccordo.getTarget().getSottoTarget())
		{
			boolean esiste = false;
			for (FlussoAccordoSottoTarget fas: sottoTarget)
				if (fas.getAmmesso().equals(st))
				{
					esiste = true;
					break;
				}
			if (esiste)
				l.add(st.getId());
		}
				
		return l;
	}
	public void SottoTargetAbilitati(List<Long> l) {
	}
	
	public List<String> getIdsSottoTarget() {
		return idsSottoTarget;
	}
	public void setIdsSottoTarget(List<String> idsSottoTarget) {
		this.idsSottoTarget = idsSottoTarget;
	}
	public Long getDurataTotale() {
		if (durataTotale == null && durata != null && posti != null)
			return durata * posti;
		return durataTotale;
	}
	public void setDurataTotale(Long durataTotale) {
		this.durataTotale = durataTotale;
	}
	public Character getFlagDurataTotaleAttiva() {
		if (flagDurataTotaleAttiva == null)
			return 'N';
		return flagDurataTotaleAttiva;
	}
	public void setFlagDurataTotaleAttiva(Character flagDurataTotaleAttiva) {
		this.flagDurataTotaleAttiva = flagDurataTotaleAttiva;
	}
	public boolean isDurataTotaleAttiva() {
		return Common.CH_S.equals(getFlagDurataTotaleAttiva());
	}
	
	public String getlivelliLabelEng() {
		String livelli = "";
		try{
		livelli += this.getMapSottoTargetAbilitati().get(11L) ? "1st " : "";
		livelli += this.getMapSottoTargetAbilitati().get(12L) ? "2nd " : "";
		livelli += this.getMapSottoTargetAbilitati().get(13L) ? "3rd " : "";
		}
		catch  (Exception e) {
			int i=0;
			
		}
		return livelli.trim();
	}

	public boolean isPostiValidi() {
		return (posti != null && posti.intValue()>0);
	}
}

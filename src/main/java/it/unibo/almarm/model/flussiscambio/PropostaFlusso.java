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

public class PropostaFlusso  implements java.io.Serializable {
	private static final long serialVersionUID = 2L;
	
	private Long id;
	private PropostaScambio propostaScambio;
	private AreaDisciplinare areaDisciplinare;
	private Character direzione;
	private Long posti;
	private UnitaMisuraDurata unitaMisuraDurata;
	private Long durata;
	private Long orePerDurata;
	private Set<PropostaFlussoSottoTarget> sottoTarget;
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
	public Long getOrePerDurata() {
		return orePerDurata;
	}
	public void setOrePerDurata(Long orePerDurata) {
		this.orePerDurata = orePerDurata;
	}	
	public Set<PropostaFlussoSottoTarget> getSottoTarget() {
		return sottoTarget;
	}
	public void setSottoTarget(Set<PropostaFlussoSottoTarget> sottoTarget) {
		this.sottoTarget = sottoTarget;
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
	
	public PropostaScambio getPropostaScambio() {
		return propostaScambio;
	}
	public void setPropostaScambio(PropostaScambio propostaScambio) {
		this.propostaScambio = propostaScambio;
	}
	
	public HashMap<Long, Boolean> getMapSottoTargetAbilitati() {
		HashMap<Long, Boolean> map = new HashMap<Long, Boolean>();
		if (propostaScambio.getTarget() == null || propostaScambio.getTarget().getSottoTarget() == null)
			return map;
		for (SottoTarget st: propostaScambio.getTarget().getSottoTarget())
		{
			boolean esiste = false;
			for (PropostaFlussoSottoTarget fas: sottoTarget)
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
		if (propostaScambio.getTarget() == null || propostaScambio.getTarget().getSottoTarget() == null)
			return l;
		for (SottoTarget st: propostaScambio.getTarget().getSottoTarget())
		{
			boolean esiste = false;
			for (PropostaFlussoSottoTarget fas: sottoTarget)
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
	
	public HashMap<Long, Boolean> getMapSottoTargetAbilByIds() {
		HashMap<Long, Boolean> map = new HashMap<Long, Boolean>();
		if (propostaScambio.getTarget() == null || propostaScambio.getTarget().getSottoTarget() == null)
			return map;
		List<Long>idsAttivi= new ArrayList<Long>();
		for (String idSt : idsSottoTarget)
			idsAttivi.add(Long.valueOf(idSt));
		
		for (SottoTarget st: propostaScambio.getTarget().getSottoTarget())
		{
			boolean esiste = false;
			if (idsSottoTarget != null && !idsSottoTarget.isEmpty())
			{
				for (Long idSt : idsAttivi)
					if (idSt.equals(st.getId())) {
/*						for (PropostaFlussoSottoTarget fas: sottoTarget)
							if (fas.getAmmesso().equals(st))
							{
								esiste = true;
								break;
							}*/
						esiste = true;
						break;
					}
			}
			if (esiste)
				map.put(st.getId(), true);
			else
				map.put(st.getId(), false);
		}
				
		return map;
	}

	
	public void SottoTargetAbilitati(List<Long> l) {
	}
	
	public List<String> getIdsSottoTarget() {
		return idsSottoTarget;
	}
	public void setIdsSottoTarget(List<String> idsSottoTarget) {
		this.idsSottoTarget = idsSottoTarget;
	}
	public boolean isDurataTotaleAttiva() {
		return Common.CH_S.equals(getFlagDurataTotaleAttiva());
	}
}

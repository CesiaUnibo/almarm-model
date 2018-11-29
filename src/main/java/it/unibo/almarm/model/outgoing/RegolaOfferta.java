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

import it.unibo.almarm.model.attori.Dipartimento;
import it.unibo.almarm.model.attori.Facolta;
import it.unibo.almarm.model.attori.Vicepresidenza;
import it.unibo.almarm.model.attori.studenti.CorsoView;
import it.unibo.almarm.util.Common;
import it.unibo.almarm.util.RegolaOffertaTipoCdsComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class RegolaOfferta implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Facolta facolta;
	private Character flagTuttiCorsi;
	private Integer	posizione;
	private Vicepresidenza vicepresidenza;
	private Dipartimento dipartimento;
	private Character tipoRegola;
	private Long copiataDa;
	
	private SortedSet<RegolaOffertaTipoCds> tipiCds = new TreeSet<RegolaOffertaTipoCds>(new RegolaOffertaTipoCdsComparator());
	private Set<RegolaOffertaCorso> corsi = new HashSet<RegolaOffertaCorso>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Facolta getFacolta() {
		return facolta;
	}
	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}
	public Character getFlagTuttiCorsi() {
		return flagTuttiCorsi;
	}
	public void setFlagTuttiCorsi(Character flagTuttiCorsi) {
		this.flagTuttiCorsi = flagTuttiCorsi;
	}
	public Integer getPosizione() {
		return posizione;
	}
	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}
	public SortedSet<RegolaOffertaTipoCds> getTipiCds() {
		return tipiCds;
	}
	public void setTipiCds(SortedSet<RegolaOffertaTipoCds> tipiCds) {
		this.tipiCds = tipiCds;
	}
	public Set<RegolaOffertaCorso> getCorsi() {
		return corsi;
	}
	public void setCorsi(Set<RegolaOffertaCorso> corsi) {
		this.corsi = corsi;
	}

	public void addCorso(CorsoView corso) {
		RegolaOffertaCorso r=new RegolaOffertaCorso();
		r.setCorso(corso);
		corsi.add(r);
	}
	
	public void addCorsoRiordinato(CorsoView corso) {
		RegolaOffertaCorso r=new RegolaOffertaCorso();
		// flag non persistita
		r.setFlagRiordinatoAggiunto(Common.CH_S.toString());
		// ---
		r.setCorso(corso);
		corsi.add(r);
	}
	
	// solo relativamente  ultima sessione edit - il dato non permane su db
	public boolean isAlmenoUnCorsoAggiuntoPerRiordiono(){
		if (corsi != null && !corsi.isEmpty()) {
			for (RegolaOffertaCorso corso: corsi)
				if ((corso.getCorso()!=null) && corso.isRiordinatoAggiunto())
					return true;
		}
		return false;
	}
	
	public String getCsvCorsiRiordinatiAggiunti(){
		String corsiRiordinatiAggiunti="";
		String virgola="";
		if (corsi != null && !corsi.isEmpty()) {
			for (RegolaOffertaCorso corso: corsi)
				if ((corso.getCorso()!=null) && corso.isRiordinatoAggiunto())
				{
					corsiRiordinatiAggiunti += virgola +corso.getCorso().getId();
					virgola=",";
				}
		}
		return corsiRiordinatiAggiunti;
	}
	
	public void removeCorso(String codCorso)
	{
		if (!corsi.isEmpty()) 
		{
			RegolaOffertaCorso corsoToRemove=null;;
			for (RegolaOffertaCorso corso: corsi)
				if ((corso.getCorso()!=null) && corso.getCorso().getId().equals(codCorso))
				{
					corsoToRemove=corso;
					break;
				}
			if (corsoToRemove!=null)
				corsi.remove(corsoToRemove);
		}
	}
	
	public void removeCorsiPerTipoCdsOfferta(Long idTipoCdsOfferta)
	{
		if ((idTipoCdsOfferta==null) || corsi.isEmpty())
			return;
		
		List<RegolaOffertaCorso> daTenere=new ArrayList<RegolaOffertaCorso>();
		for (RegolaOffertaCorso corso: corsi)
		{
			if (!idTipoCdsOfferta.equals( corso.getCorso().getIdTipoCdsOfferta()))
				daTenere.add(corso);
		}
		corsi.clear();
		corsi.addAll(daTenere);
	}
	
	
	public boolean isAlmenoUnCorsoPerTipoCds(Long idTipoCdsOfferta) {
		if ((idTipoCdsOfferta==null) || corsi.isEmpty() || tipiCds.isEmpty()) 
			return false;
		
		for (RegolaOffertaCorso corso: corsi)
		{
			try{
			if (corso.getCorso().getIdTipoCdsOfferta().equals(idTipoCdsOfferta))
				return true;
			}
			catch (Exception e) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isTuttiCorsi()
	{
		return (new Character('S').equals(flagTuttiCorsi));
	}
	
	public static class RegolaOffertaComparator implements Comparator<RegolaOfferta>
	{
		public int compare(RegolaOfferta o1, RegolaOfferta o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null)
				return 1;
			if (o2 == null)
				return -1;
			return (o1.getPosizione().compareTo(o2.getPosizione()));
		}
	}

	public Vicepresidenza getVicepresidenza() {
		return vicepresidenza;
	}
	public void setVicepresidenza(Vicepresidenza vicepresidenza) {
		this.vicepresidenza = vicepresidenza;
	}
	public Dipartimento getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corsi == null) ? 0 : corsi.hashCode());
		result = prime * result
				+ ((dipartimento == null) ? 0 : dipartimento.hashCode());
		result = prime * result + ((facolta == null) ? 0 : facolta.hashCode());
		result = prime * result
				+ ((flagTuttiCorsi == null) ? 0 : flagTuttiCorsi.hashCode());
		result = prime * result
				+ ((posizione == null) ? 0 : posizione.hashCode());
		result = prime * result + ((tipiCds == null) ? 0 : tipiCds.hashCode());
		result = prime * result
				+ ((vicepresidenza == null) ? 0 : vicepresidenza.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RegolaOfferta))
			return false;
		RegolaOfferta other = (RegolaOfferta) obj;
		if (corsi == null) {
			if (other.corsi != null)
				return false;
		} else if (!corsi.equals(other.corsi))
			return false;
		if (dipartimento == null) {
			if (other.dipartimento != null)
				return false;
		} else if (!dipartimento.equals(other.dipartimento))
			return false;
		if (facolta == null) {
			if (other.facolta != null)
				return false;
		} else if (!facolta.equals(other.facolta))
			return false;
		if (flagTuttiCorsi == null) {
			if (other.flagTuttiCorsi != null)
				return false;
		} else if (!flagTuttiCorsi.equals(other.flagTuttiCorsi))
			return false;
		if (posizione == null) {
			if (other.posizione != null)
				return false;
		} else if (!posizione.equals(other.posizione))
			return false;
		if (tipiCds == null) {
			if (other.tipiCds != null)
				return false;
		} else if (!tipiCds.equals(other.tipiCds))
			return false;
		if (vicepresidenza == null) {
			if (other.vicepresidenza != null)
				return false;
		} else if (!vicepresidenza.equals(other.vicepresidenza))
			return false;
		return true;
	}
	public Character getTipoRegola() {
		if (tipoRegola == null)
			return 'V';
		return tipoRegola;
	}
	public void setTipoRegola(Character tipoRegola) {
		this.tipoRegola = tipoRegola;
	}
	public boolean isTipoFacolta() {
		return Common.CH_F.equals(getTipoRegola());
	}
	public boolean isTipoVicepresidenza() {
		return Common.CH_V.equals(getTipoRegola());
	}
	public boolean isTipoDipartimento() {
		return Common.CH_D.equals(getTipoRegola());
	}
	public Long getCopiataDa() {
		return copiataDa;
	}
	public void setCopiataDa(Long copiataDa) {
		this.copiataDa = copiataDa;
	}
	public boolean isRegolaCopiataDa() {
		return getCopiataDa() != null;
	}
}

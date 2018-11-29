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
package it.unibo.almarm.model.attori;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import edu.emory.mathcs.backport.java.util.Collections;

import it.unibo.almarm.model.esterni.TipoUfficio;

public class Ufficio implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Esterno esterno;  
	private TipoUfficio tipoUfficio;
	private String indirizzo;
	private String cap;
	private String citta;
	private String paese;
	private String telefono;
	private String fax;
	private String denominazione;
	private String email;
	private String email2;
	private String sitoWeb;
	private String linkWeb;
	private String note;
	private Set<ContattoUfficio> contattiUfficio = new HashSet<ContattoUfficio>();
	
	// campi non persistiti
	private Long idResponsabile;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoUfficio getTipoUfficio() {
		return tipoUfficio;
	}
	public void setTipoUfficio(TipoUfficio tipoUfficio) {
		this.tipoUfficio = tipoUfficio;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPaese() {
		return paese;
	}
	public void setPaese(String paese) {
		this.paese = paese;
	}
	public String getSitoWeb() {
		return sitoWeb;
	}
	public void setSitoWeb(String sitoWeb) {
		this.sitoWeb = sitoWeb;
	}
	public String getLinkWeb() {
		return linkWeb;
	}
	public void setLinkWeb(String linkWeb) {
		this.linkWeb = linkWeb;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public boolean isAccordiConvenzioni(){
		return getTipoUfficio()!=null && getTipoUfficio().isAccordiConvenzioni(); 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((denominazione == null) ? 0 : denominazione.hashCode());
		result = prime * result
				+ ((tipoUfficio == null) ? 0 : tipoUfficio.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ufficio))
			return false;
		Ufficio other = (Ufficio) obj;
		if (denominazione == null) {
			if (other.getDenominazione() != null)
				return false;
		} else if (!denominazione.equals(other.getDenominazione()))
			return false;
		if (tipoUfficio == null) {
			if (other.getTipoUfficio() != null)
				return false;
		} else if (!tipoUfficio.equals(other.getTipoUfficio()))
			return false;
		return true;
	}
	public Esterno getEsterno() {
		return esterno;
	}
	public void setEsterno(Esterno esterno) {
		this.esterno = esterno;
	}
	
	public List<ContattoUfficio> getContattiUfficioOrdinati () {
		List<ContattoUfficio> lO = new ArrayList<ContattoUfficio>(getContattiUfficio());
		Collections.sort(lO, new ContattoUfficio.ContattoUfficioComparator());
		// metto il responsabile in testa
		for (ContattoUfficio epu: lO)
			if (epu.isResponsabile())
			{
				lO.remove(epu);
				lO.add(0, epu);
				break;
			}
		return lO;
	}
	
	public Long getIdResponsabile() {
		if (idResponsabile != null)
			return idResponsabile;
		for (ContattoUfficio epu: contattiUfficio)
			if (epu.isResponsabile())
				return epu.getContatto().getId();
		return null;
	}
	
	public void setIdResponsabile(Long id) {
		idResponsabile = id;
	}

	public static class UfficioComparator implements Comparator<Ufficio>
	{
		public int compare(Ufficio arg0, Ufficio arg1) {
			if (arg0 == null && arg1 == null)
				return 0;
			if (arg0 == null || arg0.getTipoUfficio() == null)
				return 1;
			if (arg1 == null || arg1.getTipoUfficio() == null)
				return -1;
			if (arg0.getTipoUfficio().getPosizione() == null)
				return 1;
			return arg0.getTipoUfficio().getPosizione().compareTo(arg1.getTipoUfficio().getPosizione());
		}
		
	}

	public Set<ContattoUfficio> getContattiUfficio() {
		return contattiUfficio;
	}
	public void setContattiUfficio(Set<ContattoUfficio> contattiUfficio) {
		this.contattiUfficio = contattiUfficio;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public boolean isCategoriaSottoarea(){
		return this.getTipoUfficio().isCategoriaSottoarea();
	}
	public boolean isCategoriaGenerale(){
		return this.getTipoUfficio().isCategoriGenerale();
	}
	
	public String getLabel(){
		return getTipoUfficio() != null ? StringUtils.defaultIfEmpty(getTipoUfficio().getNome(),"" ) + " - " + StringUtils.defaultIfEmpty(getDenominazione(),"") : StringUtils.defaultIfEmpty(getDenominazione(),"");
	}
}

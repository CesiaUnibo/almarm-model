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
import it.unibo.almarm.model.accordi.AccordoVicepresidenza;
import it.unibo.almarm.model.accordi.Programma;
import it.unibo.almarm.model.attori.Vicepresidenza;
import it.unibo.almarm.util.Common;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

public class EsecuzioneAccordoView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private PeriodoMobilita periodo;
	private Programma programma;
//	private Long idAccordoOperativo;
	private Long idAteneo;
	private String codiceErasmusAteneo;
	private String nomeAteneo;
	private String cognomeReferenteInterno;
	private String nomeReferenteInterno;
	private String cognomeReferenteEsterno;
	private String nomeReferenteEsterno;
	private Long idNazioneAteneo;
	private String stato;
	private Character flagModificato;
	private Character tacitoRinnovo;
	private Character attivazione;
	private Character flagProroga;
	private String statoOfferta;
	private Character flagHaProposta;
	private Integer numeroScambiStaff;
	private AccordoOperativo accordoOperativo;
	
	private Set<ScambioAccordoView> scambiAccordoView=new HashSet<ScambioAccordoView>();
	private Set<AccordoVicepresidenza> accordoVicepresidenze = new HashSet<AccordoVicepresidenza>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PeriodoMobilita getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoMobilita periodo) {
		this.periodo = periodo;
	}

	public Programma getProgramma() {
		return programma;
	}

	public void setProgramma(Programma programma) {
		this.programma = programma;
	}
	public Long getIdAccordoOperativo() {
		//return idAccordoOperativo;
		return getAccordoOperativo()!=null ? getAccordoOperativo().getId() : null;
	}

	/*
	public void setIdAccordoOperativo(Long idAccordoOperativo) {
		this.idAccordoOperativo = idAccordoOperativo;
	}*/

	public Long getIdAteneo() {
		return idAteneo;
	}

	public void setIdAteneo(Long idAteneo) {
		this.idAteneo = idAteneo;
	}

	public String getCodiceErasmusAteneo() {
		return codiceErasmusAteneo;
	}

	public void setCodiceErasmusAteneo(String codiceErasmusAteneo) {
		this.codiceErasmusAteneo = codiceErasmusAteneo;
	}

	public String getNomeAteneo() {
		return nomeAteneo;
	}

	public void setNomeAteneo(String nomeAteneo) {
		this.nomeAteneo = nomeAteneo;
	}

	public String getCognomeReferenteInterno() {
		return cognomeReferenteInterno;
	}

	public void setCognomeReferenteInterno(String cognomeReferenteInterno) {
		this.cognomeReferenteInterno = cognomeReferenteInterno;
	}

	public String getNomeReferenteInterno() {
		return nomeReferenteInterno;
	}

	public void setNomeReferenteInterno(String nomeReferenteInterno) {
		this.nomeReferenteInterno = nomeReferenteInterno;
	}

	public String getCognomeReferenteEsterno() {
		return cognomeReferenteEsterno;
	}

	public void setCognomeReferenteEsterno(String cognomeReferenteEsterno) {
		this.cognomeReferenteEsterno = cognomeReferenteEsterno;
	}

	public String getNomeReferenteEsterno() {
		return nomeReferenteEsterno;
	}

	public void setNomeReferenteEsterno(String nomeReferenteEsterno) {
		this.nomeReferenteEsterno = nomeReferenteEsterno;
	}

	public Long getIdNazioneAteneo() {
		return idNazioneAteneo;
	}

	public void setIdNazioneAteneo(Long idNazioneAteneo) {
		this.idNazioneAteneo = idNazioneAteneo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EsecuzioneAccordoView))
			return false;
		EsecuzioneAccordoView other = (EsecuzioneAccordoView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
	
	public String getReferenteInterno() {
		return StringUtils.defaultIfEmpty(cognomeReferenteInterno, "") + " " + StringUtils.defaultIfEmpty(nomeReferenteInterno, "");
	}
	
	public String getReferenteEsterno() {
		return StringUtils.defaultIfEmpty(cognomeReferenteEsterno, "") + " " + StringUtils.defaultIfEmpty(nomeReferenteEsterno, "");
	}
	
	public String getColor() {
		return StatoEsecuzioneAccordo.get(getStato()).getColor();
	}
	
	public String getColorDesc() {
		return StatoEsecuzioneAccordo.get(getStato()).getMessageKey();
	}

	public String getColorAttivazione() {
		return Attivazione.getAttivazione(getAttivazione()).getColorAttivazione();
	}
	
	public String getColorDescAttivazione() {
		return Attivazione.getAttivazione(getAttivazione()).getMessageKey();
	}
	public Character getFlagModificato() {
		return flagModificato;
	}

	public void setFlagModificato(Character flagModificato) {
		this.flagModificato = flagModificato;
	}

	public Character getTacitoRinnovo() {
		return tacitoRinnovo;
	}

	public void setTacitoRinnovo(Character tacitoRinnovo) {
		this.tacitoRinnovo = tacitoRinnovo;
	}

	public Character getCharTacitoRinnovo() {
		return Common.CH_S.equals(tacitoRinnovo)?  tacitoRinnovo: new Character(' ');
	}
	
	public boolean isTacitoRinnovoAttivo() {
		 return Common.CH_S.equals(tacitoRinnovo);
	}

	public Character getAttivazione() {
		return attivazione;
	}

	public void setAttivazione(Character attivazione) {
		this.attivazione = attivazione;
	}
	public Set<ScambioAccordoView> getScambiAccordoView() {
		return scambiAccordoView;
	}
	
	public void setScambiAccordoView(Set<ScambioAccordoView> scambiAccordoView) {
		this.scambiAccordoView = scambiAccordoView;
	}
	
	public String getSiglePolo() {
		if (getScambiAccordoView()==null || getScambiAccordoView().isEmpty())
			return "";
		
		Set<String> cods=new HashSet<String>();
		for(ScambioAccordoView s: getScambiAccordoView())
			if (!StringUtils.isEmpty(s.getSiglaPolo()))
					cods.add(s.getSiglaPolo());
		
		String sigle="";
		for(String s : cods)
			sigle+=s+" ";
		return sigle.trim().replace(" ", ",");
	}

	public String getCodiciFacolta() {
		if (getScambiAccordoView()==null || getScambiAccordoView().isEmpty())
			return "";
		
		Set<String> cods=new HashSet<String>();
		for(ScambioAccordoView s: getScambiAccordoView())
			if (s.getFacolta()!=null)
					cods.add(s.getId());
					
		String codici="";
		for(String s: cods)
			codici+=s+" ";
		return codici.trim().replace(" ", ",");
	}

	public String getLabelAteneo() {
		return codiceErasmusAteneo + " - " + nomeAteneo;
	}

	public String getLabelResponsabili() {
		String resp = Common.getNomeCognome(nomeReferenteInterno,cognomeReferenteInterno)+ "<br/>"
				+ Common.getNomeCognome(nomeReferenteEsterno,cognomeReferenteEsterno);
		return resp;
	}
	
	public String getLabelPoliFacolta() {
		if (getScambiAccordoView()==null || getScambiAccordoView().isEmpty())
			return "";
		
		TreeSet<String> cods=new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		TreeSet<String> facs=new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		for(ScambioAccordoView s: getScambiAccordoView())
		{	
			if (StringUtils.isNotBlank(s.getSiglaPolo()))
				cods.add(s.getSiglaPolo());
			if (s.getFacolta()!=null && StringUtils.isNotBlank(s.getFacolta().getDescFac()))
				facs.add(s.getFacolta().getDescFac());
		}
		
		String sigle="";
		if (!cods.isEmpty())
		{	
			for(String s : cods)
				sigle+=s+" ";
			sigle=sigle.trim();
			sigle=sigle.replace(" ", ",");
		}
		
		String nomifac="";
		if (!facs.isEmpty())
		{
			boolean primo=true;
			for(String f : facs)
			{
				nomifac+=(!primo)? "<br/>"+ f.trim(): f.trim();
				primo=false;
			}
		}		
		return sigle + (StringUtils.isNotBlank(sigle) && StringUtils.isNotBlank(nomifac)? "<br/>":"") + nomifac;
	}

	public Character getFlagProroga() {
		return flagProroga;
	}

	public void setFlagProroga(Character flagProroga) {
		this.flagProroga = flagProroga;
	}

	public String getStatoOfferta() {
		if (StringUtils.isBlank(statoOfferta))
			return StatoOffertaEsecuzioneAccordo.INIZIALE.getValore();
		return statoOfferta;
	}

	public void setStatoOfferta(String statoOfferta) {
		this.statoOfferta = statoOfferta;
	}
	public boolean getIsStatoOffertaIniziale() {
		return (StringUtils.isBlank(statoOfferta) || StatoOffertaEsecuzioneAccordo.INIZIALE.getValore().equals(statoOfferta));
	}
	
	public boolean getIsStatoOffertaDaInserire() {
		return (StatoOffertaEsecuzioneAccordo.DA_INSERIRE.getValore().equals(statoOfferta));
	}
	public boolean getIsStatoOffertaDaCompletare() {
		return (StatoOffertaEsecuzioneAccordo.DA_COMPLETARE.getValore().equals(statoOfferta));
	}
	
	public boolean getIsStatoOffertaCompleto() {
		return (StatoOffertaEsecuzioneAccordo.COMPLETO.getValore().equals(statoOfferta));
	}

	public Character getFlagHaProposta() {
		return flagHaProposta;
	}

	public void setFlagHaProposta(Character flagHaProposta) {
		this.flagHaProposta = flagHaProposta;
	}

	public Set<AccordoVicepresidenza> getAccordoVicepresidenze() {
		return accordoVicepresidenze;
	}

	public void setAccordoVicepresidenze(
			Set<AccordoVicepresidenza> accordoVicepresidenze) {
		this.accordoVicepresidenze = accordoVicepresidenze;
	}
	
	public String getLabelPoliVicepresidenze() {
		String sigle="";
		if (getScambiAccordoView()!=null && !getScambiAccordoView().isEmpty())
		{
			TreeSet<String> cods=new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
			for(ScambioAccordoView s: getScambiAccordoView())
			{	
				if (StringUtils.isNotBlank(s.getSiglaPolo()))
					cods.add(s.getSiglaPolo());
			}
			
			if (!cods.isEmpty())
			{	
				for(String s : cods)
					sigle+=s+" ";
				sigle=sigle.trim();
				sigle=sigle.replace(" ", ",");
			}
		}
			
		String vicepresidenze = "";
		
		if(getAccordoOperativo()!=null && getAccordoOperativo().getAccordoVicepresidenze() != null && (! getAccordoOperativo().getAccordoVicepresidenze().isEmpty()))
		{
			for (AccordoVicepresidenza av: getAccordoOperativo().getAccordoVicepresidenze())
				vicepresidenze += av.getVicepresidenza().getDescrizione() + "<br/>";
			vicepresidenze = vicepresidenze.substring(0, vicepresidenze.length() - 5);
		}
		return sigle + (StringUtils.isNotBlank(sigle) && StringUtils.isNotBlank(vicepresidenze)? "<br/>":"") + vicepresidenze;
	}
	
	public Integer getNumeroScambiStaff() {
		return numeroScambiStaff;
	}

	public void setNumeroScambiStaff(Integer numeroScambiStaff) {
		this.numeroScambiStaff = numeroScambiStaff;
	}

	private Set<Vicepresidenza> accordoVice = new HashSet<Vicepresidenza>();

	public Set<Vicepresidenza> getAccordoVice() {
		return accordoVice;
	}

	public void setAccordoVice(Set<Vicepresidenza> accordoVice) {
		this.accordoVice = accordoVice;
	}

	public AccordoOperativo getAccordoOperativo() {
		return accordoOperativo;
	}

	public void setAccordoOperativo(AccordoOperativo accordoOperativo) {
		this.accordoOperativo = accordoOperativo;
	}

}

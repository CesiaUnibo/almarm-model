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

import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Dipartimento;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.attori.Scuola;
import it.unibo.almarm.model.attori.Struttura;
import it.unibo.almarm.model.attori.Vicepresidenza;
import it.unibo.almarm.model.flussiscambio.CodificaAreaDisciplinare;
import it.unibo.almarm.util.Common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class AccordoOperativo extends Accordo {

	private static final long serialVersionUID = 1L;
	public static final int CAL_GIORNO_CONVENZIONALE_INIZIO = 1;
	public static final int CAL_MESE_CONVENZIONALE_INIZIO = Calendar.OCTOBER;

	private Programma programma;
	private AccordoOperativoView accordoOperativoView;
	private Ateneo ateneoPartnerReferente;
	private Struttura struttura;
	private Persona referenteInterno;
	private Persona referenteEsterno;
	private CodificaAreaDisciplinare codificaAreaDisciplinare;
	private Character inRinnovo = 'N';
	private Character validita;
	private Set<Ateneo> ateneiBeneficiari = new HashSet<Ateneo>();
	private Character flagCCRinnovoSpecifico;
	private String denominazioneContattoRinnovo;
	private String emailContattoRinnovo;
	private String telefonoContattoRinnovo;
	private String faxContattoRinnovo;
	private String indirizzoContattoRinnovo;
	private String websiteContattoRinnovo;
	private Character flagRinnovoUsaUfficioSpecifico;
	private Long idUfficioSpecificoRinnovo;
	private Persona referenteOperativo;
	private Character tacitoRinnovo;
	private Scuola scuolaCapofila;
	private Set<Ateneo> ateneiDiProvenienza = new HashSet<Ateneo>();
	private Set<AccordoVicepresidenza> accordoVicepresidenze = new HashSet<AccordoVicepresidenza>();
	private Set<AccordoDipartimento> accordoDipartimenti = new HashSet<AccordoDipartimento>();

	// flagInNegoziazioneModifica: se "S" nella fase di conivolgimento dei Partner per la
	// stipula di nuovi accordi con il 
	// processo di "Stipula Contratto Partner" come la prima stipula erasmus plus),
	// indica che e' in corso una fase di negoziazione interna di una modifica recepita del partner;
	// la modifica deve essere avvallata per arrivare alla stipula del contratto e 
	// con questa flag accesa, il flusso del contratto partner deve bloccare l'upload del contratto firmato
	private Character flagInApprovazioneModificaDaPartner;

	// Oggetti non persistiti 
	private List<Proroga> prorogheList = new ArrayList<Proroga>();
	
	public AccordoOperativo () {
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((programma == null) ? 0 : programma.hashCode());
		result = prime * result
				+ super.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AccordoOperativo))
			return false;
		AccordoOperativo other = (AccordoOperativo) obj;
		if (this.getId() != null && other.getId() != null)
			return this.getId().equals(other.getId());
		if (!super.equals(obj))
			return false;
		if (programma == null) {
			if (other.programma != null)
				return false;
		} else if (!programma.equals(other.programma))
			return false;
		return super.equals((Accordo)obj);
	}
	
	public Programma getProgramma() {
		return programma;
	}

	public void setProgramma(Programma programma) {
		this.programma = programma;
	}
	public AccordoOperativoView getAccordoOperativoView() {
		return accordoOperativoView;
	}

	public void setAccordoOperativoView(AccordoOperativoView accordoOperativoView) {
		this.accordoOperativoView = accordoOperativoView;
	}

	public Ateneo getAteneoPartnerReferente() {
		return ateneoPartnerReferente;
	}

	public void setAteneoPartnerReferente(Ateneo ateneoPartnerReferente) {
		this.ateneoPartnerReferente = ateneoPartnerReferente;
	}

	public Struttura getStruttura() {
		return struttura;
	}

	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}

	public Persona getReferenteInterno() {
		return referenteInterno;
	}

	public void setReferenteInterno(Persona referenteInterno) {
		this.referenteInterno = referenteInterno;
	}

	public Persona getReferenteEsterno() {
		return referenteEsterno;
	}

	public void setReferenteEsterno(Persona referenteEsterno) {
		this.referenteEsterno = referenteEsterno;
	}
	
	public CodificaAreaDisciplinare getCodificaAreaDisciplinare() {
		return codificaAreaDisciplinare;
	}

	public void setCodificaAreaDisciplinare(
			CodificaAreaDisciplinare codificaAreaDisciplinare) {
		this.codificaAreaDisciplinare = codificaAreaDisciplinare;
	}


	public String getLabelResponsabili() {
		String resp = "";
		if (getReferenteInterno() != null)
			resp += getReferenteInterno().getNomeCognome() + "<br/>";
		if (getReferenteEsterno() != null)
			resp += getReferenteEsterno().getNomeCognome();
		return resp;
	}

	public String getDestinatarioEmailRinnovo(){
		if (getReferenteEsterno() == null 
				|| getReferenteEsterno().getEmailUfficiale() == null 
				|| StringUtils.isBlank(getReferenteEsterno().getEmailUfficiale().getIndirizzo()))
			return null;
	    return getReferenteEsterno().getEmailUfficiale().getIndirizzo();
	}

	public Character getInRinnovo() {
		if (inRinnovo == null)
			return 'N';
		return inRinnovo;
	}


	public void setInRinnovo(Character inRinnovo) {
		this.inRinnovo = inRinnovo;
	}


	public Character getValidita() {
		return validita;
	}

	public boolean isAccordoInRinnovo() {
		return Common.CH_S.equals(this.inRinnovo);
	}

	public void setValidita(Character validita) {
		this.validita = validita;
	}
	
	public String getValiditaColor() {
		return StatoValiditaAccordo.get(validita).getColor();
	}
	
	public String getValiditaColorDesc() {
		return StatoValiditaAccordo.get(validita).getDescrizione();
	}
	
	public boolean isRinnovoAttivo() {
		return (new Character('S')).equals(inRinnovo);
	}


	public Set<Ateneo> getAteneiBeneficiari() {
		return ateneiBeneficiari;
	}

	public void setAteneiBeneficiari(Set<Ateneo> ateneiBeneficiari) {
		this.ateneiBeneficiari = ateneiBeneficiari;
	}


	public Character getFlagCCRinnovoSpecifico() {
		return flagCCRinnovoSpecifico;
	}

	public boolean isCCRinnovoSpecifico() {
		 return Common.CH_S.equals(flagCCRinnovoSpecifico);
	}

	public void setFlagCCRinnovoSpecifico(Character flagCCRinnovoSpecifico) {
		this.flagCCRinnovoSpecifico = flagCCRinnovoSpecifico;
	}


	public String getDenominazioneContattoRinnovo() {
		return denominazioneContattoRinnovo;
	}


	public void setDenominazioneContattoRinnovo(String denominazioneContattoRinnovo) {
		this.denominazioneContattoRinnovo = denominazioneContattoRinnovo;
	}


	public String getEmailContattoRinnovo() {
		return emailContattoRinnovo;
	}


	public void setEmailContattoRinnovo(String emailContattoRinnovo) {
		this.emailContattoRinnovo = emailContattoRinnovo;
	}


	public String getTelefonoContattoRinnovo() {
		return telefonoContattoRinnovo;
	}


	public void setTelefonoContattoRinnovo(String telefonoContattoRinnovo) {
		this.telefonoContattoRinnovo = telefonoContattoRinnovo;
	}


	public String getFaxContattoRinnovo() {
		return faxContattoRinnovo;
	}


	public void setFaxContattoRinnovo(String faxContattoRinnovo) {
		this.faxContattoRinnovo = faxContattoRinnovo;
	}


	public String getIndirizzoContattoRinnovo() {
		return indirizzoContattoRinnovo;
	}


	public void setIndirizzoContattoRinnovo(String indirizzoContattoRinnovo) {
		this.indirizzoContattoRinnovo = indirizzoContattoRinnovo;
	}


	public Persona getReferenteOperativo() {
		return referenteOperativo;
	}

	public void setReferenteOperativo(Persona referenteOperativo) {
		this.referenteOperativo = referenteOperativo;
	}


	public Character getTacitoRinnovo() {
		return tacitoRinnovo;
	}

	public void setTacitoRinnovo(Character tacitoRinnovo) {
		this.tacitoRinnovo = tacitoRinnovo;
	}	
	
	public boolean isTacitoRinnovoAttivo() {
		 return Common.CH_S.equals(tacitoRinnovo);
	}


	public Set<Ateneo> getAteneiDiProvenienza() {
		return ateneiDiProvenienza;
	}


	public void setAteneiDiProvenienza(Set<Ateneo> ateneiDiProvenienza) {
		this.ateneiDiProvenienza = ateneiDiProvenienza;
	}

	
	public List<Proroga> getProrogheList() {
		return prorogheList;
	}


	public void setProrogheList(List<Proroga> prorogheList) {
	}


	public void prorogheListOrdinateAsc()
	{
		List<Proroga> l = new ArrayList<Proroga>(this.getProroghe());
		if (l.size() > 1)
			Collections.sort(l, new ProrogaComparator());
		prorogheList=l;
	}


	public Set<AccordoVicepresidenza> getAccordoVicepresidenze() {
		return accordoVicepresidenze;
	}


	public void setAccordoVicepresidenze(
			Set<AccordoVicepresidenza> accordoVicepresidenze) {
		this.accordoVicepresidenze = accordoVicepresidenze;
	}
	
	public void addVicepresidenza(Vicepresidenza v, java.util.Date dataInserimento)	{
		AccordoVicepresidenza av = new AccordoVicepresidenza();
		av.setVicepresidenza(v);
		av.setDataInserimento(dataInserimento == null ? new java.util.Date() : dataInserimento);
		this.getAccordoVicepresidenze().add(av);
	}

	public void addDipartimento(Dipartimento d, java.util.Date dataInserimento)	{
		AccordoDipartimento ad = getNuovoAccordoDipartimento(d);
		ad.setDataInserimento(dataInserimento == null ? new java.util.Date() : dataInserimento);
		this.getAccordoDipartimenti().add(ad);
	}

	public Persona getBeneficiarioInterno () {
	  Persona beneficiario = null;
	  if (getAccordoAttori() != null && (!getAccordoAttori().isEmpty()))
		for (AccordoAttore aa : getAccordoAttori())
			if (aa.isPersonaleBeneficiario()) {
				try {
					beneficiario = (Persona)aa.getAttore();
				} catch (Exception e) {}
			}
	  return beneficiario;
	}

	public Character getFlagInApprovazioneModificaDaPartner() {
		return flagInApprovazioneModificaDaPartner;
	}

	public void setFlagInApprovazioneModificaDaPartner(
			Character flagInApprovazioneModificaDaPartner) {
		this.flagInApprovazioneModificaDaPartner = flagInApprovazioneModificaDaPartner;
	}

	public boolean isInApprovazioneModificaDaPartner(){
		return Common.CH_S.equals(flagInApprovazioneModificaDaPartner);
	}


	public String getWebsiteContattoRinnovo() {
		return websiteContattoRinnovo;
	}


	public void setWebsiteContattoRinnovo(String websiteContattoRinnovo) {
		this.websiteContattoRinnovo = websiteContattoRinnovo;
	}

	public Character getFlagRinnovoUsaUfficioSpecifico() {
		return flagRinnovoUsaUfficioSpecifico == null ? Common.CH_N : flagRinnovoUsaUfficioSpecifico;
	}


	public void setFlagRinnovoUsaUfficioSpecifico(
			Character flagRinnovoUsaUfficioSpecifico) {
		this.flagRinnovoUsaUfficioSpecifico = flagRinnovoUsaUfficioSpecifico;
	}
	
	public boolean isRinnovoUsaUfficioSpecifico(){
		return Common.CH_S.equals(flagRinnovoUsaUfficioSpecifico) && (idUfficioSpecificoRinnovo != null);
	}	

	public Long getIdUfficioSpecificoRinnovo() {
		return idUfficioSpecificoRinnovo;
	}


	public void setIdUfficioSpecificoRinnovo(Long idUfficioSpecificoRinnovo) {
		this.idUfficioSpecificoRinnovo = idUfficioSpecificoRinnovo;
	}

	public List<Long> getIdsVicepresidenze() {
		List<Long> ret = new ArrayList<Long>();
		if (getAccordoVicepresidenze() != null)
			for (AccordoVicepresidenza av: getAccordoVicepresidenze())
				if (av.getVicepresidenza() != null)
					ret.add(av.getVicepresidenza().getId());
		return ret; 
	}

	public Scuola getScuolaCapofila() {
		return scuolaCapofila;
	}


	public void setScuolaCapofila(Scuola scuolaCapofila) {
		this.scuolaCapofila = scuolaCapofila;
	}
	
	public List<Vicepresidenza> getListaVicepresidenze() {
		List<Vicepresidenza> l= new ArrayList<Vicepresidenza>();
		if (!getAccordoVicepresidenze().isEmpty()){
			for (AccordoVicepresidenza av : getAccordoVicepresidenze())
				l.add(av.getVicepresidenza());
		}
		return l;
	}

	public List<Vicepresidenza> getListaVicepresidenzeOrdinata() {
		List<Vicepresidenza> l = getListaVicepresidenze();
	
		if (!l.isEmpty()) {
	         Collections.sort(l, new java.util.Comparator<Vicepresidenza>() {
		        public int compare(Vicepresidenza c1, Vicepresidenza c2) {
		            //You should ensure that list doesn't contain null values!
		            return StringUtils.defaultIfEmpty(c1.getDescrizione(), " ").compareTo(StringUtils.defaultIfEmpty(c2.getDescrizione()," "));
		        }
	         });
		}
		return l;
	}
	
	public 	List<AccordoVicepresidenza> getListaAccordoVicepresidenzeOrdinata() {
		List<AccordoVicepresidenza> l =new ArrayList<AccordoVicepresidenza>();
	
		if (this.getAccordoVicepresidenze()!=null && !getAccordoVicepresidenze().isEmpty()){
			for (AccordoVicepresidenza av : getAccordoVicepresidenze())
				if (av.getVicepresidenza()!=null)
					l.add(av);
	
	         Collections.sort(l, new java.util.Comparator<AccordoVicepresidenza>() {
		        public int compare(AccordoVicepresidenza c1, AccordoVicepresidenza c2) {
		            //You should ensure that list doesn't contain null values!
		            return StringUtils.defaultIfEmpty(c1.getVicepresidenza().getDescrizione(), " ").compareTo(StringUtils.defaultIfEmpty(c2.getVicepresidenza().getDescrizione()," "));
		        }
	         });
		}
		return l;
	}


	public Set<AccordoDipartimento> getAccordoDipartimenti() {
		return accordoDipartimenti;
	}


	public void setAccordoDipartimenti(Set<AccordoDipartimento> accordoDipartimenti) {
		this.accordoDipartimenti = accordoDipartimenti;
	}

	public AccordoDipartimento getAccordoDipartimentoEsistente(Long idDipartimento){
		for (AccordoDipartimento ad : getAccordoDipartimenti())
			if (ad.getDipartimento().getId().equals(idDipartimento))
				return ad;
		return null;	
	}

	public AccordoDipartimento getNuovoAccordoDipartimento(Dipartimento dip){
		AccordoDipartimento ad = new AccordoDipartimento(this, dip);
		return ad;
	}
	
}

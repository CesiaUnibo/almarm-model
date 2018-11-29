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
package it.unibo.almarm.model.attori.studenti;

import it.unibo.almarm.model.attori.Dipartimento;
import it.unibo.almarm.model.attori.Facolta;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.attori.Scuola;
import it.unibo.almarm.model.attori.Struttura;
import it.unibo.almarm.model.attori.Usd;
import it.unibo.almarm.model.attori.Vicepresidenza;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Carriera implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String COD_IND_VUOTO="000";
	public static final String COD_ORI_VUOTO="000";
	
	private CarrieraId id;
	private Integer idAnagrafica;  
	private String numeroDiMatricola;
	private Integer annoDiImmatricolazione;
	private String codiceIndirizzo;
	private String codiceOrientamento;
	private StatoCarriera stato;
	private String tipoCarriera; 
	private Facolta facolta;
	private Corso corso;
	private TipoCorso tipoCorso;
	private Integer durataCorso;
	private Integer annoDiCorso;
	private Character tipoIscrizione;
	private Integer annoAccademico;
	private Scuola scuolaCapofila;
	private Vicepresidenza vicepresidenza;
	private Dipartimento dipartimento;
	private Usd usd;
	private Integer ciclo;
	private Integer annoFuoriCorso;
	private Struttura dipDotto;
	private Persona tutorDotto;
	private Date dataLaurea;
	
	private Set<Esame> esami = new HashSet<Esame>();
	
	public CarrieraId getId() {
		return id;
	}

	public void setId(CarrieraId id) {
		this.id = id;
	}
	public String getTipoCarriera() {
		return tipoCarriera;
	}

	public Integer getIdAnagrafica() {
		return idAnagrafica;
	}
	public void setIdAnagrafica(Integer pincode) {
		this.idAnagrafica = pincode;
	}
	
	public void setTipoCarriera(String tipoCarriera) {
		this.tipoCarriera = tipoCarriera;
	}

	public String getNumeroDiMatricola() {
		return numeroDiMatricola;
	}

	public void setNumeroDiMatricola(String numeroDiMatricola) {
		this.numeroDiMatricola = numeroDiMatricola;
	}	

	public Facolta getFacolta() {
		return facolta;
	}

	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	public void setAnnoDiImmatricolazione(Integer annoDiImmatricolazione) {
		this.annoDiImmatricolazione = annoDiImmatricolazione;
	}
	public Integer getAnnoDiImmatricolazione() {
		return annoDiImmatricolazione;
	}

	public void setCodiceIndirizzo(String codiceIndirizzo) {
		this.codiceIndirizzo = codiceIndirizzo;
	}

	public String getCodiceIndirizzo() {
		return codiceIndirizzo;
	}

	public void setCodiceOrientamento(String codiceOrientamento) {
		this.codiceOrientamento = codiceOrientamento;
	}

	public String getCodiceOrientamento() {
		return codiceOrientamento;
	}
	
	public String getDescrizioneCorso()
	{
		return "( " + corso.getId() + " " + codiceIndirizzo + " " + codiceOrientamento + " )  " + corso.getDescrizione(); 
	}
	
	public String getDescrizioneBreveCorso()
	{
		return  corso.getId() + " " + corso.getDescrizione(); 
	}

	public Set<Esame> getEsami() {
		return esami;
	}

	public void setEsami(Set<Esame> esami) {
		this.esami = esami;
	}
	
	public boolean getHasEsami() {
		return esami!=null && (!esami.isEmpty());
	}
	
	public Boolean isStudente()
	{
		return getTipoCarriera().equals("ST");
	}
	
	public Boolean isDottorato()
	{
		return getTipoCarriera().equals("DT");
	}
	
	public Boolean isScuolaDiSpecializzazione()
	{
		return getTipoCorso().isScuolaDiSpecializzazione();
	}
	
	public StatoCarriera getStato() {
		return stato;
	}

	public void setStato(StatoCarriera stato) {
		this.stato = stato;
	}

	public TipoCorso getTipoCorso() {
		return tipoCorso;
	}

	public void setTipoCorso(TipoCorso tipoCorso) {
		this.tipoCorso = tipoCorso;
	}

	public Integer getDurataCorso() {
		return durataCorso;
	}

	public void setDurataCorso(Integer durataCorso) {
		this.durataCorso = durataCorso;
	}

	public Integer getAnnoDiCorso() {
		return annoDiCorso;
	}

	public void setAnnoDiCorso(Integer annoDiCorso) {
		this.annoDiCorso = annoDiCorso;
	}

	public Character getTipoIscrizione() {
		return tipoIscrizione;
	}

	public void setTipoIscrizione(Character tipoIscrizione) {
		this.tipoIscrizione = tipoIscrizione;
	}
	
	public String getTipoIscrizioneMessageKey()	{
		return TipoIscrizione.getTipoIscrizione(tipoIscrizione).getMessageKey();
	}

	public boolean isStatoCarrieraAttivo()
	{
		return (getStato().getId().equals("AT"));
	}
	
	public boolean isLaureato() {
		return getStato().isLaureato();
	}
	
	public String getStatoCarrieraDescr()
	{
		return getStato().getDescrizione();
	}
	
	public String getStatoCarriera()
	{
		if (getStato().getId().equals("AT"))
		{
			// SE LO STUDENTE E' ATTIVO RITORNO IL TIPO ISCRIZIONE
			// ASSOCIATO  ALLA CARRIERA che stiamo visulaizzando
			// il dato e' in isc_ana_car e credo che lo leggero' con una select
			// al momento uso il tipoIscrizione che ho gia' a disposizione.
			/*
			 * nei tirocini era:
			for (IscrizioneCorrente ic: getIscrizioniCorrenti())
				if (ic.getId().getNumeroCarriera().equals(carriera.getId().getNumeroCarriera()))
					return ic.getTipoIscrizioneString();
			*/
			
			// Ritorno il tipo di iscrizione
			return TipoIscrizione.getTipoIscrizione(tipoIscrizione).getMessageKey();
		}
		
		return getStato().getDescrizione();
	}

	/*
	 * Anno accademico untima iscrizione per la carriera
	 */
	public Integer getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(Integer annoAccademico) {
		this.annoAccademico = annoAccademico;
	}
	
	public boolean isCarrieraDottorato() {
		return  getTipoCarriera().equals("DT");
	}
	

	/*
	// Riforma 240/2010
	  Se la facolta' mostrata riguarda uno studente,  il dato verra' sostituito 
	  con la scuola se la carriera dello studente e' attiva 
	 				carriera ATTIVA -> scuola
	 				
	 oppure se la carriera non e' attiva si guarda l'ultima iscrizione della carriera dello studente
	 e se questa non e' antecedente al 2012 si visualizza la scuola  
	 				ultimo AA carriera non attiva >= 2012  -> scuola
	 
	 per le carriere concluse  e con ultimo anno di iscrizione antecedente al 2012 
	 continueremo a mostrare la facolta'
	 */
	public boolean isVisualizzaScuola() {
		if (!isStatoCarrieraAttivo())
          if (annoAccademico != null) { 
        	  if (annoAccademico.intValue() < 2012)
	        	 return false;
          }
          else if (annoDiImmatricolazione.intValue() < 2012)
	        	 return false;

		return true;
	}

	public Scuola getScuolaCapofila() {
		return scuolaCapofila;
	}

	public void setScuolaCapofila(Scuola scuolaCapofila) {
		this.scuolaCapofila = scuolaCapofila;
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

	public Usd getUsd() {
		return usd;
	}

	public void setUsd(Usd usd) {
		this.usd = usd;
	}
	
	public String getDescrizioneFacOScuolaCarriera() {
		return isVisualizzaScuola() ?
			  (getScuolaCapofila() != null ? getScuolaCapofila().getDescrizione() : "") 
			: (getFacolta() != null ? getFacolta().getDescFac() : "");		
	}

	public Integer getCiclo() {
		return ciclo;
	}

	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	public Integer getAnnoFuoriCorso() {
		return annoFuoriCorso;
	}

	public void setAnnoFuoriCorso(Integer annoFuoriCorso) {
		this.annoFuoriCorso = annoFuoriCorso;
	}

	public Struttura getDipDotto() {
		return dipDotto;
	}

	public void setDipDotto(Struttura dipDotto) {
		this.dipDotto = dipDotto;
	}

	public Persona getTutorDotto() {
		return tutorDotto;
	}

	public void setTutorDotto(Persona tutorDotto) {
		this.tutorDotto = tutorDotto;
	}

	public Date getDataLaurea() {
		return dataLaurea;
	}

	public void setDataLaurea(Date dataLaurea) {
		this.dataLaurea = dataLaurea;
	}
}

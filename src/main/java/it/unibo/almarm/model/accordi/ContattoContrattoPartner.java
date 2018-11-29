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

import java.util.Date;

import it.unibo.almarm.model.luoghi.Nazione;
import it.unibo.almarm.util.Common;

import org.apache.commons.lang.StringUtils;

public class ContattoContrattoPartner implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	// Al momento usato per i contatti genrici INTESI COME UFFICIO/email/telefono/sitiweb

	// ----------------------------------------------------------------------------------
    // TIPOLOGIE CONTATTI RICONOSCIUTE
	
	// UFFICIO VISA
	public static String TIPO_CONTATTO_ISHEET_VISA = "ISHEET.VISA";
	
	// UFFICIO INSURANCE
	public static String TIPO_CONTATTO_ISHEET_INSURANCE = "ISHEET.INSURANCE";
	
	// UFFICIO HOUSING
	public static String TIPO_CONTATTO_ISHEET_HOUSING = "ISHEET.HOUSING";
	
	// UFFICIO ATENEO PER INVIO NOMINE - TODO : QUESTO E' UN PROBLEMA PERCHè DEVE ESSERE RICONDOTTO AD UNA UNICA INFORMAZIONE PER ATENEO 
	public static String TIPO_CONTATTO_ISHEET_OUT_NOMINATION = "ISHEET.OUT_NOMINATION";
	
	// CONTATTO AGGIUNTIVO PER L'INVIO DEI RINNOVI DEI CONTRATTI - VALEVOLE A LIVELLO DI ACCORDO
	public static String TIPO_CONTATTO_ALTRO_UFFICIO_ACCORDI = "ALTRO_UFFICIO_ACCORDI";
	
	// CONTATTO PREVISTO PER RECEPIRE LA MODIFICA DEL REFERENTE ESTERNO  - VALEVOLE A LIVELLO DI ACCORDO
	public static String TIPO_CONTATTO_NUOVO_REF_ESTERNO = "NUOVO_REF_ESTERNO";
	
	// ----------------------------------------------------------------------------------
	
	private Long id;
    private String codice;         // codice tipologia contatto 
	private Integer progressivo;
	private String ufficio;        	
	private String telefono;        // testo che non controlliamo , possono essere 0-N
	private String email;		  	// testo che non controlliamo , possono essere 0-N
	private String sitoWeb;	  		// testo che non controlliamo , possono essere 0-N
	private String nome;
	private String cognome;
	private String fax;     		
	private String indirizzo;
	private String email2;		  	
	private String facolta;

	
	private String titolo;
	private Character genere;
	private Nazione nazionalita;
	private Nazione nazioneIndirizzo;
	private String cittaIndirizzo;	
	private String frazioneIndirizzo;	
	private String capIndirizzo;
	private Date dataUltimaModifica;
	private Long autoreUltimaModifica;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public Integer getProgressivo() {
		return progressivo;
	}
	public void setProgressivo(Integer progressivo) {
		this.progressivo = progressivo;
	}
	public String getUfficio() {
		return ufficio;
	}
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSitoWeb() {
		return sitoWeb;
	}
	public void setSitoWeb(String sitoWeb) {
		this.sitoWeb = sitoWeb;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public boolean isContattoISheetVisa(){
		return TIPO_CONTATTO_ISHEET_VISA.equals(this.getCodice());
	}
	
	public boolean isContattoISheetInsurance(){
		return TIPO_CONTATTO_ISHEET_INSURANCE.equals(this.getCodice());
	}
	public boolean isContattoISheetHousing(){
		return TIPO_CONTATTO_ISHEET_HOUSING.equals(this.getCodice());
	}
	public boolean isContattoISheetOutNomination(){
		return TIPO_CONTATTO_ISHEET_OUT_NOMINATION.equals(this.getCodice());
	}
	public boolean isContattoAltroUfficioAccordi(){
		return TIPO_CONTATTO_ALTRO_UFFICIO_ACCORDI.equals(this.getCodice());
	}
	public boolean isContattoNuovoReferenteEsterno(){
		return TIPO_CONTATTO_NUOVO_REF_ESTERNO.equals(this.getCodice());
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getFacolta() {
		return facolta;
	}
	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Character getGenere() {
		return genere;
	}
	public void setGenere(Character genere) {
		this.genere = genere;
	}
	public Nazione getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(Nazione nazionalita) {
		this.nazionalita = nazionalita;
	}
	public Nazione getNazioneIndirizzo() {
		return nazioneIndirizzo;
	}
	public void setNazioneIndirizzo(Nazione nazioneIndirizzo) {
		this.nazioneIndirizzo = nazioneIndirizzo;
	}
	public String getCittaIndirizzo() {
		return cittaIndirizzo;
	}
	public void setCittaIndirizzo(String cittaIndirizzo) {
		this.cittaIndirizzo = cittaIndirizzo;
	}
	public String getFrazioneIndirizzo() {
		return frazioneIndirizzo;
	}
	public void setFrazioneIndirizzo(String frazioneIndirizzo) {
		this.frazioneIndirizzo = frazioneIndirizzo;
	}
	public String getCapIndirizzo() {
		return capIndirizzo;
	}
	public void setCapIndirizzo(String capIndirizzo) {
		this.capIndirizzo = capIndirizzo;
	}
	
	/* DATI DI SOLA GESTIONE - NON VANNO REPLICATI IN CLONAZIONE */
	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}
	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}
	public Long getAutoreUltimaModifica() {
		return autoreUltimaModifica;
	}
	public void setAutoreUltimaModifica(Long autoreUltimaModifica) {
		this.autoreUltimaModifica = autoreUltimaModifica;
	}
	/* ----------------------------------------------------------- */
	
	public String getIndirizzoDescrizione() {
		String  indirizzo =  StringUtils.defaultIfEmpty(getIndirizzo(),"") + "
" 
		+ StringUtils.defaultIfEmpty(getFrazioneIndirizzo(),"") + "
" 
		+ StringUtils.defaultIfEmpty(getCapIndirizzo(),"") + " "
		+ StringUtils.defaultIfEmpty(getCittaIndirizzo(),"");
		String nazio = getNazioneIndirizzo() != null && StringUtils.isNotBlank(getNazioneIndirizzo().getNazione()) 
					   && (!getNazioneIndirizzo().getNazione().toUpperCase().contains("NON DEFINIT"))
					    ? (StringUtils.isNotBlank(getNazioneIndirizzo().getNazioneIng()) ? getNazioneIndirizzo().getNazioneIng() : getNazioneIndirizzo().getNazione() )  
					    : "";
		indirizzo  = indirizzo + " " + Common.getNominativoCapitalized(nazio);
		return indirizzo;
	}

	public ContattoContrattoPartner  clona(){
		ContattoContrattoPartner c= new ContattoContrattoPartner ();
		clonaIn(c);
		return c;
	}

	public void  clonaIn(ContattoContrattoPartner c){
		c.setCodice(this.getCodice());
		c.setProgressivo(this.getProgressivo());
		c.setUfficio(this.getUfficio());        	
		c.setTelefono(this.getTelefono());      
		c.setEmail(this.getEmail());		  
		c.setSitoWeb(this.getSitoWeb());	  
		c.setNome(this.getNome());
		c.setCognome(this.getCognome());
		c.setFax(this.getFax());     		
		c.setIndirizzo(this.getIndirizzo());
		c.setEmail2(this.getEmail2());		  	
		c.setFacolta(this.getFacolta());
		c.setTitolo(this.getTitolo());
		c.setGenere(this.getGenere());
		c.setNazionalita(this.getNazionalita());
		c.setNazioneIndirizzo(this.getNazioneIndirizzo());
		c.setCittaIndirizzo(this.getCittaIndirizzo());	
		c.setFrazioneIndirizzo(this.getFrazioneIndirizzo());	
		c.setCapIndirizzo(this.getCapIndirizzo());
	}
}

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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

// Generated 19-feb-2008 15.24.59 by Hibernate Tools 3.2.0.CR1

import it.unibo.almarm.model.luoghi.Localita;
import it.unibo.almarm.model.luoghi.Nazione;
import it.unibo.almarm.model.luoghi.Territorio;
import it.unibo.almarm.service.PersonaManager.TipoIndirizzo;
import it.unibo.almarm.service.RecapitoEmailManager;
import it.unibo.almarm.service.RecapitoTelefonicoManager;
import it.unibo.almarm.util.Common;

public class Persona extends Attore implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cognome;
	private String nome;
	private Date dataNascita;
	private Character genere;
	private String codiceFiscale;
	private Localita nascita;
	private Nazione nazionalita;
	private Character statoCodiceFiscale;
	private String titolo;
	private String nomeIntermedio;
	private String suffisso;
	private String nomeVisualizzato;
	private Long statoCivile;
	private String cognomeAcquisito;
	
	// campi non persistiti
	private boolean domicilioInserito;
	private AttoreIndirizzo backupDomicilio;
	
	private Nazione nazioneNascitaDraft;
	private Territorio territorioNascitaDraft;
	private String comuneNascitaDraft;
	private Localita nascitaDraft;
	private Character possiedeCfItalianoDraft;
	private Character dichiaraDomicilioEstero;
	private AttoreIndirizzo backupDomicilioEstero;
	
	public Persona() {
	}

	public Persona(Long id, String cognome, String nome,
			Date dataNascita, Character genere, String codiceFiscale,
			Nazione nazionalita) {
		super(id);
		this.cognome = cognome;
		this.nome = nome;
		this.dataNascita = dataNascita;
		this.genere = genere;
		this.codiceFiscale = codiceFiscale;
		this.nazionalita = nazionalita;
	}

	public Persona(Long id, String cognome, String nome,
			Date dataNascita, Character genere, String codiceFiscale,
			Localita nascita, Nazione nazionalita, Character statoCodiceFiscale,
			String titolo, String nomeIntermedio, String suffisso,
			String nomeVisualizzato, Long statoCivile, String cognomeAcquisito) {
		super(id);
		this.cognome = cognome;
		this.nome = nome;
		this.dataNascita = dataNascita;
		this.genere = genere;
		this.codiceFiscale = codiceFiscale;
		this.nascita = nascita;
		this.nazionalita = nazionalita;
		this.statoCodiceFiscale = statoCodiceFiscale;
		this.titolo = titolo;
		this.nomeIntermedio = nomeIntermedio;
		this.suffisso = suffisso;
		this.nomeVisualizzato = nomeVisualizzato;
		this.statoCivile = statoCivile;
		this.cognomeAcquisito = cognomeAcquisito;
	}
	
	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Character getGenere() {
		return this.genere;
	}

	public void setGenere(Character genere) {
		this.genere = genere;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Localita getNascita() {
		return this.nascita;
	}

	public void setNascita(Localita nascita) {
		this.nascita = nascita;
	}

	public Nazione getNazionalita() {
		return this.nazionalita;
	}

	public void setNazionalita(Nazione nazionalita) {
		this.nazionalita = nazionalita;
	}

	public Character getStatoCodiceFiscale() {
		return this.statoCodiceFiscale;
	}

	public void setStatoCodiceFiscale(Character statoCodiceFiscale) {
		this.statoCodiceFiscale = statoCodiceFiscale;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getNomeIntermedio() {
		return this.nomeIntermedio;
	}

	public void setNomeIntermedio(String nomeIntermedio) {
		this.nomeIntermedio = nomeIntermedio;
	}

	public String getSuffisso() {
		return this.suffisso;
	}

	public void setSuffisso(String suffisso) {
		this.suffisso = suffisso;
	}

	public String getNomeVisualizzato() {
		return this.nomeVisualizzato;
	}

	public void setNomeVisualizzato(String nomeVisualizzato) {
		this.nomeVisualizzato = nomeVisualizzato;
	}

	public Long getStatoCivile() {
		return this.statoCivile;
	}

	public void setStatoCivile(Long statoCivile) {
		this.statoCivile = statoCivile;
	}

	public String getCognomeAcquisito() {
		return this.cognomeAcquisito;
	}

	public void setCognomeAcquisito(String cognomeAcquisito) {
		this.cognomeAcquisito = cognomeAcquisito;
	}

	public String getNomeCognome() {
		return Common.getNomeCognomeCapitalized(nome, cognome);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Persona))
			return false;
		final Persona other = (Persona) obj;
		if (codiceFiscale == null) {
			if (other.getCodiceFiscale() != null)
				return false;
		} else if (!codiceFiscale.equals(other.getCodiceFiscale()))
			return false;
		return true;
	}

	
	// Funzioni di supporto per le pagine web per la  compilazione della 
	// relazione Esterno-Settoriattivita nel modello
	
	public void completaTelefono(RecapitoTelefonico telefono,  RecapitoTelefonicoManager.TipoTelefono tipoTelefono)
	{
		telefono.setAttore(this);
		telefono.setTipo(tipoTelefono.getValore());
	}
	public void completaEmailUfficiale(RecapitoEmail email)
	{
		email.setTipo(RecapitoEmailManager.TipoIndirizzo.EMAIL.getValore());
		email.setAttore(this);
	}

	public RecapitoTelefonico getTelefonoUfficiale()
	{
		return getTelefono(RecapitoTelefonicoManager.TipoTelefono.FISSO);
	}
	
	public void setTelefonoUfficiale(RecapitoTelefonico telefono)
	{
		setTelefono(telefono, RecapitoTelefonicoManager.TipoTelefono.FISSO);
	}

	public RecapitoTelefonico getFaxUfficiale()
	{
		return getTelefono(RecapitoTelefonicoManager.TipoTelefono.FAX);
	}
	
	public void setFaxUfficiale(RecapitoTelefonico telefono)
	{
		setTelefono(telefono, RecapitoTelefonicoManager.TipoTelefono.FAX);
	}
	
	public RecapitoTelefonico getCellulareUfficiale()
	{
		return getTelefono(RecapitoTelefonicoManager.TipoTelefono.CELLULARE);
	}
	
	public void setCellulareUfficiale(RecapitoTelefonico telefono)
	{
		setTelefono(telefono, RecapitoTelefonicoManager.TipoTelefono.CELLULARE);
	}

	public RecapitoTelefonico getTelefonoEstero()
	{
		return getTelefono(RecapitoTelefonicoManager.TipoTelefono.CONTATTO_ESTERO);
	}
	
	public void setTelefonoEstero(RecapitoTelefonico telefono)
	{
		setTelefono(telefono, RecapitoTelefonicoManager.TipoTelefono.CONTATTO_ESTERO);
	}
	
	public void setTelefono(RecapitoTelefonico telefono, RecapitoTelefonicoManager.TipoTelefono tipoTelefono)
	{
		RecapitoTelefonico r = getTelefono(tipoTelefono);
		if (r == null && telefono == null)
			return;
		if (r != null && telefono != null)
		{
			r.setTipo(tipoTelefono.getValore());
			r.setNota(telefono.getNota());
			r.setPrefissoInt(telefono.getPrefissoInt());
			r.setTelefono(telefono.getTelefono());
			completaTelefono(r, tipoTelefono);
		}
		else if (r != null && telefono == null)
		{
			recapitoTelefonicos.remove(r);
		}
		else
		{
			if (recapitoTelefonicos==null)
				recapitoTelefonicos=new HashSet<RecapitoTelefonico>();
			
			completaTelefono(telefono, tipoTelefono);
			this.recapitoTelefonicos.add(telefono);
		}
	}
	
	public RecapitoTelefonico getFax() {
		return this.getTelefono(RecapitoTelefonicoManager.TipoTelefono.FAX);
	}

	private RecapitoTelefonico getTelefono(RecapitoTelefonicoManager.TipoTelefono tipoTelefono)
	{
		if (recapitoTelefonicos==null)
			return null;
		
		for (RecapitoTelefonico r:recapitoTelefonicos)
		{
			String tipo=r.getTipo();
			
			if ((tipo!=null) && (tipo.equalsIgnoreCase(tipoTelefono.getValore())))
				return r;
		}
		
		if (tipoTelefono.equals(RecapitoTelefonicoManager.TipoTelefono.FISSO))
		{
			for (RecapitoTelefonico r:recapitoTelefonicos)
			{
				String tipo=r.getTipo();
				
				if (	(tipo!=null) 
					 && (!(tipo.equalsIgnoreCase(RecapitoTelefonicoManager.TipoTelefono.FAX.getValore())))
					 && (!(tipo.equalsIgnoreCase(RecapitoTelefonicoManager.TipoTelefono.CELLULARE.getValore())))
				)
				return r;
			}
		}
		return null;
	}
	
	public RecapitoEmail getEmailUfficiale()
	{
		for (RecapitoEmail e:recapitoEmails)
		{
			String tipo=e.getTipo();
			if ((tipo==null) || (tipo.equalsIgnoreCase(RecapitoEmailManager.TipoIndirizzo.EMAIL.getValore())))
				return e;
		}
		return null;
	}

	public Set<RecapitoEmail> getRecapitiTipoEmail() {
		Set<RecapitoEmail> recapitiTipoEmail = new HashSet<>();
		if (getRecapitoEmails()!=null) {
			for (RecapitoEmail recapito : getRecapitoEmails()) {
				if (recapito!=null) {
					String tipo = recapito.getTipo();
					if (tipo ==null || tipo.equalsIgnoreCase(RecapitoEmailManager.TipoIndirizzo.EMAIL.getValore())) {
						String indirizzo = recapito.getIndirizzo();
						if (StringUtils.isNotBlank(indirizzo)) {
							recapitiTipoEmail.add(recapito);
						}

					}
				}
			}
		}
		return recapitiTipoEmail;
	}

	public RecapitoEmail getEmailUfficiale_1()
	{
		RecapitoEmail primaSenzaPriorita=null;
		for (RecapitoEmail e: recapitoEmails)
		{
			String tipo=e.getTipo();
			if ((tipo==null) || (tipo.equalsIgnoreCase(RecapitoEmailManager.TipoIndirizzo.EMAIL.getValore())))
			{
				if ((e.getPriorita()!=null) && e.getPriorita().equals(1L))
					return e;
				else if ((e.getPriorita()==null) && primaSenzaPriorita==null)
					primaSenzaPriorita=e;
			}
		}
		if (primaSenzaPriorita!=null)
			primaSenzaPriorita.setPriorita(1L);
		return primaSenzaPriorita;
	}
	public RecapitoEmail getEmailUfficiale_2()
	{
		RecapitoEmail primaSenzaPriorita=null;
		for (RecapitoEmail e: recapitoEmails)
		{
			String tipo=e.getTipo();
			if ((tipo==null) || (tipo.equalsIgnoreCase(RecapitoEmailManager.TipoIndirizzo.EMAIL.getValore())))
			{
				if ((e.getPriorita()!=null) && e.getPriorita().equals(2L))
					return e;
				else if ((e.getPriorita()==null) && primaSenzaPriorita==null)
					primaSenzaPriorita=e;
			}
		}
		if (primaSenzaPriorita!=null)
			primaSenzaPriorita.setPriorita(2L);
		return primaSenzaPriorita;
	}
	public void setEmailUfficiale_1(RecapitoEmail email)
	{
		RecapitoEmail e = getEmailUfficiale_1();
		if (e == null  && email == null)
			return;
		if (e != null  && email != null)
		{
			e.setTipo(RecapitoEmailManager.TipoIndirizzo.EMAIL.getValore());
			e.setIndirizzo(email.getIndirizzo());
			e.setNota(email.getNota());
			completaEmailUfficiale(e);
		}
		else if (e != null  && email == null)
		{
			recapitoEmails.remove(e);
		}
		else 
		{
			if (recapitoEmails==null)
				recapitoEmails=new HashSet<RecapitoEmail>();

			completaEmailUfficiale(email);
			this.recapitoEmails.add(email);
		}
	}
	public void setEmailUfficiale_2(RecapitoEmail email)
	{
		RecapitoEmail e = getEmailUfficiale_2();
		if (e == null  && email == null)
			return;
		if (e != null  && email != null)
		{
			e.setTipo(RecapitoEmailManager.TipoIndirizzo.EMAIL.getValore());
			e.setIndirizzo(email.getIndirizzo());
			e.setNota(email.getNota());
			completaEmailUfficiale(e);
		}
		else if (e != null  && email == null)
		{
			recapitoEmails.remove(e);
		}
		else 
		{
			if (recapitoEmails==null)
				recapitoEmails=new HashSet<RecapitoEmail>();

			completaEmailUfficiale(email);
			this.recapitoEmails.add(email);
		}
	}
	
	public void setEmailUfficiale(RecapitoEmail email)
	{
		RecapitoEmail e = getEmailUfficiale();
		if (e == null  && email == null)
			return;
		if (e != null  && email != null)
		{
			e.setTipo(RecapitoEmailManager.TipoIndirizzo.EMAIL.getValore());
			e.setIndirizzo(email.getIndirizzo());
			e.setNota(email.getNota());
		}
		else if (e != null  && email == null)
		{
			recapitoEmails.remove(e);
		}
		else 
		{
			if (recapitoEmails==null)
				recapitoEmails=new HashSet<RecapitoEmail>();

			completaEmailUfficiale(email);
			this.recapitoEmails.add(email);
		}
	}

	@Override
	public String getNomeAttore() {
		return cognome + " " + nome;
	}
	
	@Override
	public String getCodiceAttore() {
		return codiceFiscale;
	}
	
	public AttoreIndirizzo getIndirizzoPrincipale()
	{
		for (AttoreIndirizzo ai: this.getAttoreIndirizzos())
			if (ai.getTipo().equals("R"))
				return ai;
		if ((getAttoreIndirizzos() != null) && (getAttoreIndirizzos().size() > 0))
			return getAttoreIndirizzos().iterator().next();
		return null;
	}
	
	public String getCognomeNome()
	{
		return new StringBuilder(this.cognome).append(" ").append(this.nome).toString();
	}
	
	public String getNazioneLuogoNascita () {
		return new StringBuilder(this.nascita.getTerritorio().getRegione().getNazione().getNazione()).append(", ").append(this.nascita.getLocalita()).toString();
	}
	
	public String getIndirizzoDesc() {
		AttoreIndirizzo ai = getIndirizzoPrincipale();
		if (ai != null)
			return StringUtils.defaultIfEmpty(ai.getIndirizzo(),"") + "
" + StringUtils.defaultIfEmpty(ai.getFrazione(),"") + "
" + StringUtils.defaultIfEmpty(ai.getCap(),"") + " " + (ai.getLocalita() != null ? ai.getLocalita().getLocalita() : "") + " " + (ai.getNazione() != null ? ai.getNazione().getNazione() : "");
		return "";
	}
	
	public String getIndirizzoDescrizione() {
		/*
		AttoreIndirizzo ai = getIndirizzoPrincipale();
		if (ai != null)
			return StringUtils.defaultIfEmpty(ai.getIndirizzo(),"") + "
" 
			+ StringUtils.defaultIfEmpty(ai.getFrazione(),"") + "
" 
			+ StringUtils.defaultIfEmpty(ai.getCap(),"") + " " 
			+ (ai.getLocalita() != null && (!ai.getLocalita().getLocalita().toUpperCase().contains("NON DEFINIT"))  
					? ai.getLocalita().getLocalita() : "") + " " 
			+ (ai.getNazione()!=null && (!ai.getNazione().getNazione().toUpperCase().contains("NON DEFINIT"))  ? ai.getNazione().getNazione() : "");
		return "";
		*/
		return compilaIndirizzoDescrizione(false, false);
	}

	public String getIndirizzoDescrizioneIng() {
		return compilaIndirizzoDescrizione(true,true);
	}

	private String compilaIndirizzoDescrizione(boolean usaInglese, boolean capitalizzato) {
		AttoreIndirizzo ai = getIndirizzoPrincipale();
		if (ai != null) {
			String indi = StringUtils.defaultIfEmpty(ai.getIndirizzo(),"") + "
" 
			+ StringUtils.defaultIfEmpty(ai.getFrazione(),"") + "
" 
			+ StringUtils.defaultIfEmpty(ai.getCap(),"");
			
			String loca = ai.getLocalita() != null && (!ai.getLocalita().getLocalita().toUpperCase().contains("NON DEFINIT"))  
					      ? ai.getLocalita().getLocalita() : ""; 
			if (capitalizzato)
				loca = Common.getNominativoCapitalized(loca);
			
			String nazio = ai.getNazione() !=null 
					       && StringUtils.isNotBlank(ai.getNazione().getNazione())  
					       && (!ai.getNazione().getNazione().toUpperCase().contains("NON DEFINIT"))
					        ? (usaInglese && StringUtils.isNotBlank(ai.getNazione().getNazioneIng()) ? ai.getNazione().getNazioneIng() : ai.getNazione().getNazione()) : "";
			if (capitalizzato)
				nazio = Common.getNominativoCapitalized(nazio);
			
			indi = indi +  " " + loca + " " + nazio;
			return indi;
		}
		return "";
	}
	
	public void removeRecapitoTelefonico(RecapitoTelefonico recapitoTelefonico)
	{
		if ((recapitoTelefonicos==null) || recapitoTelefonicos.isEmpty())
			return;
		
		// L'UTENTE HA BLANKATO IL NUMERO  -> DEVO FAR RIMUOVERE IL RECORD
		if (recapitoTelefonico.getId() == null)
			recapitoTelefonicos.remove(recapitoTelefonico);
		else
			removeRecapitoTelefonicoById(recapitoTelefonico.getId());
		
	}
	private void removeRecapitoTelefonicoById(Long id)
	{
		if ((recapitoTelefonicos==null) || recapitoTelefonicos.isEmpty())
			return;
		
		Set<RecapitoTelefonico>recapitiRimasti =new HashSet<RecapitoTelefonico>();
		for (RecapitoTelefonico recapito:  recapitoTelefonicos)
		{
			if (recapito.getId() == null || !recapito.getId().equals(id))
				recapitiRimasti.add(recapito);
		}
		
		recapitoTelefonicos.clear();
		for (RecapitoTelefonico recapito :recapitiRimasti)
			recapitoTelefonicos.add(recapito);
	}
	public void removeRecapitoEmail(RecapitoEmail recapitoEmail)
	{
		if ((recapitoEmails==null) || recapitoEmails.isEmpty())
			return;
		
		// L'UTENTE HA BLANKATO IL NUMERO  -> DEVO FAR RIMUOVERE IL RECORD
		if (recapitoEmail.getId() == null)
			recapitoEmails.remove(recapitoEmail);
		else
			removeRecapitoEmailById(recapitoEmail.getId());
		
	}
	private void removeRecapitoEmailById(Long id)
	{
		if ((recapitoEmails==null) || recapitoEmails.isEmpty())
			return;
		
		Set<RecapitoEmail>recapitiRimasti =new HashSet<RecapitoEmail>();
		for (RecapitoEmail recapito:  recapitoEmails)
		{
			if (recapito.getId() == null || 
			    (!recapito.getId().equals(id)))
				recapitiRimasti.add(recapito);
		}
		
		recapitoEmails.clear();
		for (RecapitoEmail recapito :recapitiRimasti)
			recapitoEmails.add(recapito);
	}
	
	public boolean isCodiceFiscaleCalcolato() {
		return (new Character('C').equals(statoCodiceFiscale));
	}
	
	public AttoreIndirizzo getDomicilio() {
		for (AttoreIndirizzo ai: this.getAttoreIndirizzos())
			if (ai.getTipo().equals("D"))
				return ai;
		return null;
	}
	
	public boolean isDomicilioInserito() {
		return domicilioInserito;
	}
	
	public void setDomicilioInserito(boolean domicilioInserito) {
		this.domicilioInserito = domicilioInserito;
	}
	
	public AttoreIndirizzo getDomicilioEstero() {
		for (AttoreIndirizzo ai: this.getAttoreIndirizzos())
			if (ai.getTipo().equals(TipoIndirizzo.DOMICILIO_ESTERO.getValore()))
				return ai;
		return null;
	}
	
	public AttoreIndirizzo getIndirizzoTipo(String tipo)
	{
		if (tipo!=null)
		for (AttoreIndirizzo ai: this.getAttoreIndirizzos())
			if (ai.getTipo().equals(tipo))
				return ai;
		return null;
	}

	public void removeTipoIndirizzo(String tipo) {
		int cntRm=0;
		List<AttoreIndirizzo> l= new ArrayList<AttoreIndirizzo>();  
		for (AttoreIndirizzo ai: this.getAttoreIndirizzos())
			if (!ai.getTipo().equals(tipo))
				l.add(ai);
			else 
				cntRm++;
		if (cntRm>0){
			this.getAttoreIndirizzos().clear();
			if (!l.isEmpty())
				this.getAttoreIndirizzos().addAll(l);
		}
	}

	public static class PersonaComparatorCognomeNome implements Comparator<Persona>
	{
		public int compare(Persona o1, Persona o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null || o1.getCognome() == null)
				return 1;
			if (o2 == null || o2.getCognome() == null)
				return -1;
			int res=o1.getCognome().compareTo(o2.getCognome());
			if (res!=0)
				return res;
			if (o1.getNome() == null)
				return 1;
			if (o2.getNome() == null)
				return -1;
			return o1.getNome().compareTo(o2.getNome());
		}
	}

	public AttoreIndirizzo getBackupDomicilio() {
		return backupDomicilio;
	}

	public void setBackupDomicilio(AttoreIndirizzo backupDomicilio) {
		this.backupDomicilio = backupDomicilio;
	}

	public Character getPossiedeCfItalianoDraft() {
		if (possiedeCfItalianoDraft == null)
			return 'S';
		return possiedeCfItalianoDraft;
	}
	
	public boolean isCfItalianoDraft() {
		return new Character ('S').equals(getPossiedeCfItalianoDraft());
	}

	public void setPossiedeCfItalianoDraft(Character possiedeCfItalianoDraft) {
		this.possiedeCfItalianoDraft = possiedeCfItalianoDraft;
	}

	public Nazione getNazioneNascitaDraft() {
		return nazioneNascitaDraft;
	}

	public void setNazioneNascitaDraft(Nazione nazioneNascitaDraft) {
		this.nazioneNascitaDraft = nazioneNascitaDraft;
	}

	public Territorio getTerritorioNascitaDraft() {
		return territorioNascitaDraft;
	}

	public void setTerritorioNascitaDraft(Territorio territorioNascitaDraft) {
		this.territorioNascitaDraft = territorioNascitaDraft;
	}

	public String getComuneNascitaDraft() {
		return comuneNascitaDraft;
	}

	public void setComuneNascitaDraft(String comuneNascitaDraft) {
		this.comuneNascitaDraft = comuneNascitaDraft;
	}

	public RecapitoTelefonico getTelefonoResidenzaStudente() {
		for (RecapitoTelefonico rt: getRecapitoTelefonicos())
			if ("R".equals(rt.getTipoVcard()))
				return rt;
		return null;
	}
	
	public RecapitoTelefonico getTelefonoDomicilioStudente() {
		for (RecapitoTelefonico rt: getRecapitoTelefonicos())
			if ("D".equals(rt.getTipoVcard()))
				return rt;
		return null;
	}
	
	public RecapitoTelefonico getTelefonoAltroStudente() {
		for (RecapitoTelefonico rt: getRecapitoTelefonicos())
			if ("A".equals(rt.getTipoVcard()))
				return rt;
		return null;
	}

	public boolean isDomicilioEsteroInserito() {
		return Common.CH_S.equals(getDichiaraDomicilioEstero());
	}

	public void setDomicilioEsteroInserito(boolean domicilioEsteroInserito) {
		setDichiaraDomicilioEstero(domicilioEsteroInserito ? Common.CH_S:Common.CH_N);
	}

	public AttoreIndirizzo getBackupDomicilioEstero() {
		return backupDomicilioEstero;
	}

	public void setBackupDomicilioEstero(AttoreIndirizzo backupDomicilioEstero) {
		this.backupDomicilioEstero = backupDomicilioEstero;
	}

	public Localita getNascitaDraft() {
		return nascitaDraft;
	}

	public void setNascitaDraft(Localita nascitaDraft) {
		this.nascitaDraft = nascitaDraft;
	}

	public Character getDichiaraDomicilioEstero() {
		return dichiaraDomicilioEstero;
	}

	public void setDichiaraDomicilioEstero(Character dichiaraDomicilioEstero) {
		this.dichiaraDomicilioEstero = dichiaraDomicilioEstero;
	}
}

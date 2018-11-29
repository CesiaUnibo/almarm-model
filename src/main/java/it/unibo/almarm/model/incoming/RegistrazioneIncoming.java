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
package it.unibo.almarm.model.incoming;

import it.unibo.almarm.model.luoghi.Localita;
import it.unibo.almarm.model.luoghi.Nazione;
import it.unibo.almarm.model.luoghi.Territorio;
import it.unibo.almarm.util.Common;
import it.unibo.almarm.webapp.flow.mvc.RegistrazioneIncomingModel;
import it.unibo.almarm.webapp.mvc.FlagPolicy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import edu.emory.mathcs.backport.java.util.Collections;

public class RegistrazioneIncoming implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cognome;
	private Character sesso;
	private Date dataNascita;
	private Nazione nazioneNascita;
	private Localita localitaNascita;
	private String comuneNascita;
	private Nazione nazionalita;
	private String email;
	private String cellulare;
	private String codiceFiscale;
	private Character flagCfCalcolato;
	private Nazione nazioneResidenza;
	private Localita localitaResidenza;
	private String comuneResidenza;
	private String indirizzoResidenza;
	private String capResidenza;
	private String telefonoResidenza;
	private String presso;
	private Integer periodoPermanenza;
	private byte[] fototessera;
	private RegistrazioneIncomingFoto foto;
	private String passaporto;
	private String idDocPassaporto;
	private String nomeDocPassaporto;
	private String sottocartellaDocPassaporto;
	private String idDocLA;
	private String nomeDocLA;	
	private String sottocartellaDocLA;
	
	private Set<RispostaRegistrazioneIncoming> risposteRegistrazioneIncoming = new HashSet<RispostaRegistrazioneIncoming>();
	
	private StudenteIncoming studenteIncoming;
	
	// campi non persistiti
	private Territorio territorioNascita;
	private Territorio territorioResidenza;
	private Map<Integer,String> risposteMap;
	private Character flagDatiPersonali;
	private FlagPolicy policyPassaporto;
	private FlagPolicy policyDocPassaporto;
	private FlagPolicy policyDocLA;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = Common.normalizzaDatiAnagrafici(nome);
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = Common.normalizzaDatiAnagrafici(cognome);
	}

	public Character getSesso() {
		return sesso;
	}

	public void setSesso(Character sesso) {
		this.sesso = sesso;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Nazione getNazionalita() {
		return nazionalita;
	}

	public boolean isNazionalitaNonUE() {
		boolean nonUE = false;
		if (getNazionalita()!=null) {
			if (getNazionalita().getFlagComunitario()!=null) {
				nonUE = Common.CH_N.equals(getNazionalita().getFlagComunitario());
			}
		}
		return nonUE;
	}

	public void setNazionalita(Nazione nazionalita) {
		this.nazionalita = nazionalita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = StringUtils.trim(email);
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = StringUtils.trim(cellulare);
	}

	public String getCodiceFiscale() {
		if (StringUtils.isNotBlank(codiceFiscale))
			return codiceFiscale.toUpperCase();
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = StringUtils.trim(codiceFiscale);
	}

	public Nazione getNazioneResidenza() {
		return nazioneResidenza;
	}

	public void setNazioneResidenza(Nazione nazioneResidenza) {
		this.nazioneResidenza = nazioneResidenza;
	}

	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}

	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = StringUtils.trim(indirizzoResidenza);
	}

	public String getCapResidenza() {
		return capResidenza;
	}

	public void setCapResidenza(String capResidenza) {
		this.capResidenza = StringUtils.trim(capResidenza);
	}

	public String getTelefonoResidenza() {
		return telefonoResidenza;
	}

	public void setTelefonoResidenza(String telefonoResidenza) {
		this.telefonoResidenza = StringUtils.trim(telefonoResidenza);
	}

	public String getPresso() {
		return presso;
	}

	public void setPresso(String presso) {
		this.presso = StringUtils.trim(presso);
	}

	public Set<RispostaRegistrazioneIncoming> getRisposteRegistrazioneIncoming() {
		return risposteRegistrazioneIncoming;
	}

	public void setRisposteRegistrazioneIncoming(
			Set<RispostaRegistrazioneIncoming> risposteRegistrazioneIncoming) {
		this.risposteRegistrazioneIncoming = risposteRegistrazioneIncoming;
	}

	public Character getFlagCfCalcolato() {
		if (flagCfCalcolato == null)
			return 'S';
		return flagCfCalcolato;
	}

	public void setFlagCfCalcolato(Character flagCfCalcolato) {
		this.flagCfCalcolato = flagCfCalcolato;
	}

	public Nazione getNazioneNascita() {
		return nazioneNascita;
	}

	public void setNazioneNascita(Nazione nazioneNascita) {
		this.nazioneNascita = nazioneNascita;
	}

	public Localita getLocalitaNascita() {
		return localitaNascita;
	}

	public void setLocalitaNascita(Localita localitaNascita) {
		if (nazioneNascita != null && !nazioneNascita.isItalia())
			return;
		if (localitaNascita != null && nazioneNascita != null && nazioneNascita.isItalia())
			this.comuneNascita = null;
		this.localitaNascita = localitaNascita;
	}

	public String getComuneNascita() {
		return comuneNascita;
	}

	public void setComuneNascita(String comuneNascita) {
		if (nazioneNascita != null && nazioneNascita.isItalia())
			return;
		if (StringUtils.isNotBlank(comuneNascita))
			this.localitaNascita = null;
		this.comuneNascita = StringUtils.trim(comuneNascita);
	}

	public Localita getLocalitaResidenza() {
		return localitaResidenza;
	}

	public void setLocalitaResidenza(Localita localitaResidenza) {
		if (nazioneResidenza != null && !nazioneResidenza.isItalia())
			return;
		if (localitaResidenza != null && nazioneResidenza != null && nazioneResidenza.isItalia())
			this.comuneResidenza = null;
		this.localitaResidenza = localitaResidenza;
	}

	public String getComuneResidenza() {
		return comuneResidenza;
	}

	public void setComuneResidenza(String comuneResidenza) {
		if (nazioneResidenza != null && nazioneResidenza.isItalia())
			return;
		if (StringUtils.isNotBlank(comuneResidenza))
			this.localitaResidenza = null;
		this.comuneResidenza = StringUtils.trim(comuneResidenza);
	}

	public StudenteIncoming getStudenteIncoming() {
		return studenteIncoming;
	}

	public void setStudenteIncoming(StudenteIncoming studenteIncoming) {
		this.studenteIncoming = studenteIncoming;
	}

	public Territorio getTerritorioNascita() {
		return territorioNascita;
	}

	public void setTerritorioNascita(Territorio territorioNascita) {
		this.territorioNascita = territorioNascita;
	}

	public Territorio getTerritorioResidenza() {
		return territorioResidenza;
	}

	public void setTerritorioResidenza(Territorio territorioResidenza) {
		this.territorioResidenza = territorioResidenza;
	}
	
	public Map<Long, RispostaRegistrazioneIncoming> getRisposte() {
		Map<Long, RispostaRegistrazioneIncoming> risposte = new HashMap<Long, RispostaRegistrazioneIncoming>();
		for (RispostaRegistrazioneIncoming r: getRisposteRegistrazioneIncoming())
			risposte.put(r.getDomandaRegistrazioneIncoming().getId(), r);
		return risposte;
	}
	
	/**
	 * E' stato necessario per riuscire a fare il binding delle risposte nella jsp
	 * @return
	 */
	public Map<Integer,String> getRisposteMap() {
		if (risposteMap == null || (risposteMap.size() < risposteRegistrazioneIncoming.size()))
		{
			risposteMap = new HashMap<Integer, String>();
			for (RispostaRegistrazioneIncoming risposta: getRisposteRegistrazioneIncoming())
				risposteMap.put(risposta.getDomandaRegistrazioneIncoming().getId().intValue(), risposta.getRisposta() != null ? risposta.getRisposta().toString() : "");
		}
		return risposteMap;
	}
	
	public List<RispostaRegistrazioneIncoming> getRisposteRegistrazioneIncomingOrdinate(){
		List<RispostaRegistrazioneIncoming> l = new ArrayList<RispostaRegistrazioneIncoming>(getRisposteRegistrazioneIncoming());
		Collections.sort(l, new RispostaRegistrazioneIncomingComparator());
		return l;
	}

	public Character getFlagDatiPersonali() {
		return flagDatiPersonali;
	}

	public void setFlagDatiPersonali(Character flagDatiPersonali) {
		this.flagDatiPersonali = flagDatiPersonali;
	}

	public Integer getPeriodoPermanenza() {
		return periodoPermanenza;
	}

	public void setPeriodoPermanenza(Integer periodoPermanenza) {
		this.periodoPermanenza = periodoPermanenza;
	}
	
	public String getPeriodoPermanenzaMsgKey() {
		//if (periodoPermanenza != null)
			return PeriodoPermanenzaIncoming.get(periodoPermanenza).getMessageKey();
		//return "";
	}

	public byte[] getFototessera() {
		return fototessera;
	}

	public void setFototessera(byte[] fototessera) {
		this.fototessera = fototessera;
	}

	public RegistrazioneIncomingFoto getFoto() {
		return foto;
	}

	public void setFoto(RegistrazioneIncomingFoto foto) {
		this.foto = foto;
	}

	
	public String getIdDocPassaporto() {
		return idDocPassaporto;
	}

	public void setIdDocPassaporto(String idDocPassaporto) {
		this.idDocPassaporto = idDocPassaporto;
	}

	public String getPassaporto() {
		return passaporto;
	}

	public void setPassaporto(String passaporto) {
		this.passaporto = passaporto;
	}

	public String getNomeDocPassaporto() {
		return nomeDocPassaporto;
	}

	public void setNomeDocPassaporto(String nomeDocPassaporto) {
		this.nomeDocPassaporto = nomeDocPassaporto;
	}

	public String getSottocartellaDocPassaporto() {
		return sottocartellaDocPassaporto;
	}

	public void setSottocartellaDocPassaporto(String sottocartellaDocPassaporto) {
		this.sottocartellaDocPassaporto = sottocartellaDocPassaporto;
	}

	public String getPathNameDocPassaporto() {
		return Common.getPathNameAllegato(getIdDocPassaporto(), getNomeDocPassaporto(), getSottocartellaDocPassaporto());
	}
	
	public boolean isAlmenoUnDatoPassaportoCompilato(){
		return  StringUtils.isNotBlank(passaporto) || StringUtils.isNotBlank(idDocPassaporto);
	}
	
	public void removeDocPassaporto(){
		setIdDocPassaporto(null);
		setNomeDocPassaporto(null);
		setSottocartellaDocPassaporto(null);
	}
	
	public String getIdDocLA() {
		return idDocLA;
	}

	public void setIdDocLA(String idDocLA) {
		this.idDocLA = idDocLA;
	}

	public String getNomeDocLA() {
		return nomeDocLA;
	}

	public void setNomeDocLA(String nomeDocLA) {
		this.nomeDocLA = nomeDocLA;
	}
	
	public String getSottocartellaDocLA() {
		return sottocartellaDocLA;
	}

	public void setSottocartellaDocLA(String sottocartellaDocLA) {
		this.sottocartellaDocLA = sottocartellaDocLA;
	}

	public String getPathNameDocLA() {
		return Common.getPathNameAllegato(getIdDocLA(), getNomeDocLA(), getSottocartellaDocLA());
	}

	public void removeDocLA(){
		setIdDocLA(null);
		setNomeDocLA(null);
		setSottocartellaDocLA(null);
	}

	// -------- Campi NON persistiti --------------------------------------------------------------------

	private RegistrazioneIncomingModel registrazioneModel;
	
	public RegistrazioneIncomingModel getRegistrazioneModel() {
		return registrazioneModel;
	}

	public void setRegistrazioneModel(RegistrazioneIncomingModel registrazioneModel) {
		this.registrazioneModel = registrazioneModel;
	}

	public FlagPolicy getPolicyPassaporto() {
		return policyPassaporto;
	}

	public void setPolicyPassaporto(FlagPolicy policyPassaporto) {
		this.policyPassaporto = policyPassaporto;
	}

	public FlagPolicy getPolicyDocPassaporto() {
		return policyDocPassaporto;
	}

	public void setPolicyDocPassaporto(FlagPolicy policyDocPassaporto) {
		this.policyDocPassaporto = policyDocPassaporto;
	}

	public FlagPolicy getPolicyDocLA() {
		return policyDocLA;
	}

	public void setPolicyDocLA(FlagPolicy policyDocLA) {
		this.policyDocLA = policyDocLA;
	}

	// ---------------------------------------------------------------------------------------------- 
}

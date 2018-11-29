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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import it.unibo.almarm.dao.storedprocedure.IncomingModificabileDaApp;
import it.unibo.almarm.model.accordi.AccordoOperativo;
import it.unibo.almarm.model.accordi.Coorte;
import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Campus;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.attori.Struttura;
import it.unibo.almarm.model.attori.StrutturaAmministrativa;
import it.unibo.almarm.model.attori.studenti.Carriera;
import it.unibo.almarm.model.flussiscambio.UnitaMisuraDurata;
import it.unibo.almarm.model.luoghi.Localita;
import it.unibo.almarm.model.luoghi.Nazione;
import it.unibo.almarm.model.luoghi.Territorio;
import it.unibo.almarm.model.modalitapagamento.ModalitaDiPagamento;
import it.unibo.almarm.model.staff.StatoIncomingStaff;
import it.unibo.almarm.util.Common;
import it.unibo.almarm.webapp.flow.mvc.FototesseraModel;
import it.unibo.almarm.webapp.flow.mvc.ModelMap;
import it.unibo.frontieraCia.model.Minicarriera;

public class StudenteIncoming implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Persona persona;
	private Nomina nomina;
	private RegistrazioneIncoming registrazioneIncoming;
	private Date dataRegistrazione;
	private Date dataArrivoPrevista;
	private Date dataArrivo;
	private Date dataWelcomeSession;
	private Date dataPartenzaPrevista;
	private Date dataPartenza;
	private Date dataTerminato;
	private Character flagProlungamento;
	private String stato;
	private Persona utenteArrivo;
	private Persona utenteStipula;
	private Persona utentePartenza;
	private Persona utenteTerminato;
	private Date dataFineProlungamento;
	private Ateneo ateneoDiProvenienza;
	private Integer periodoPermanenza;
	private TipoMobilita tipoMobilita;
	private String note;
	private Integer numeroCarriera;
	private Integer pincode;
	private Carriera carriera;
	private String upn;
	private String puk;
	private Long durataProlungamento;
	private Character flagRinuncia;
	private Character flagDottorato;
	private String indirizzoEmailInvioTR;
	private Date dataInvioEmailTR;
	private Character flagNecessitaPermessoSoggiorno;
	private String codiceAnagraficoCia;
	private ModalitaDiPagamento modalitaDiPagamento;
	private Minicarriera minicarriera;
	private Coorte coorte;
	private Struttura strutturaAppartenenza;
	private Persona referenteInterno;
	private Persona autoreRinuncia;
	private Date dataRinuncia;
	private Long durata;
	private UnitaMisuraDurata unitaMisuraDurata;
	private UnitaMisuraDurata unitaMisuraDurataProlungamento;
	private Character flagNuovoPartner;
	private String nomeNuovoPartner;
	private Nazione nazioneNuovoPartner;
	private Date dataSegnalazioneArrivo;
	private Date dataSegnalazionePartenza;
	private String app;
	private String passaporto;
	private String idDocPassaporto;
	private String nomeDocPassaporto;
	private String sottocartellaDocPassaporto;
	private String idDocLA;
	private String nomeDocLA;	
	private String sottocartellaDocLA;	

	private String noteRifiutoDocLA;
	private String idDocLAFirmato;
	private String nomeDocLAFirmato;	
	private String sottocartellaDocLAFirmato;
	private Date dataLAFirmato;
	private Persona autoreLAFirmato;

	private Character flagLA; // flagDocLA: 'R' rifiutato il documento LA studente , 'S'=documento LA firmato
	private Date dataValidazioneLA;
	private Persona autoreValidazioneLA;
	
	private IncomingStaff incomingStaff;
	
	private Set<StudenteIncomingAllegato> allegati = new HashSet<StudenteIncomingAllegato>();
	private Set<IncomingProlungamento> richiesteDiProlungamento = new HashSet<IncomingProlungamento>();
	
	// Campi NON persistiti ---------------------------------------------------------------------------
	private String idNomina;
	private String password;
	private boolean nuovoAccount=false;
    private Character flagCfForzato;
	private boolean cfEsteroInvalidoForzato=false;
	private transient MultipartFile docAllegatoDaAggiungere;
	private String descrizioneAllegatoDaAggiungere;
	private Character flagVisibileAStudenteAllegatoDaAggiungere;
	private Character flagInviaConfirmationMessage;
	private List<String> importiIntermediRate;
	private String importoNuovaRata;
	private Long numeroNuovaRata;
	private List<Date> dateScadenzaRate;
	private String descrizioneNuovaRata;
	private List<String> descrizioniRate = new ArrayList<String>();
	private Date scadenzaNuovaRata;
	private List<String> tipiAttivitaStaffSelected;
	private ModelMap descrizioniAttivitaStaffSelected;
	private Character flagUsaDataFineAlPostoDiPeriodo;
	private Character flagUsaDataFineAlPostoDiPeriodoPerProlungamento;
	private List<IncomingStaffChecklistElement> staffChecklistElements;
	
	private java.util.List<String>  stampePerAggregato;
	
	// Campi NON persistiti per la gestione della modifica dell'anagrafica
	private String cognomeTmp;
	private String nomeTmp;
	private Date dataNascitaTmp;
	private Character genereTmp;
	private String codiceFiscaleTmp;
	private Localita nascitaTmp;
	private Nazione nazionalitaTmp;
	private Character statoCodiceFiscaleTmp;
	private Nazione nazioneNascitaTmp;
	private Territorio territorioNascitaTmp;
	private String comuneNascitaTmp;
	private String emailTmp;
	private String badgeRfid;
	
	// campo non persistito usato per la foto che sara' memorizzata nella registrazione e nelle tabelle di unico
	private byte[] fototessera;
	
	private FototesseraModel fototesseraModel;

	private StrutturaAmministrativa strutturaAmministrativa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Nomina getNomina() {
		return nomina;
	}

	public void setNomina(Nomina nomina) {
		this.nomina = nomina;
	}

	public RegistrazioneIncoming getRegistrazioneIncoming() {
		return registrazioneIncoming;
	}

	public void setRegistrazioneIncoming(RegistrazioneIncoming registrazioneIncoming) {
		this.registrazioneIncoming = registrazioneIncoming;
	}

	public String getIdNomina() {
		return idNomina;
	}

	public void setIdNomina(String idNomina) {
		this.idNomina = idNomina;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public Date getDataArrivoPrevista() {
		return dataArrivoPrevista;
	}

	public void setDataArrivoPrevista(Date dataArrivoPrevista) {
		this.dataArrivoPrevista = dataArrivoPrevista;
	}

	public Date getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public Date getDataPartenzaPrevista() {
		return dataPartenzaPrevista;
	}

	public void setDataPartenzaPrevista(Date dataPartenzaPrevista) {
		this.dataPartenzaPrevista = dataPartenzaPrevista;
	}

	public Date getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public Character getFlagProlungamento() {
		if (flagProlungamento == null)
			return 'N';
		return flagProlungamento;
	}

	public void setFlagProlungamento(Character flagProlungamento) {
		this.flagProlungamento = flagProlungamento;
	}
	
	public boolean isProlungamento() {
		return Common.CH_S.equals(flagProlungamento);
	}
	
	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
	
	public StatoIncomingStaff getStatoStaff() {
		if (isRinuncia())
			return StatoIncomingStaff.RINUNCIATO;
		if (getNomina() != null && getNomina().isRifiutato())
			return StatoIncomingStaff.RIFIUTATO;
		if (StatoStudenteIncoming.INIZIALE.getValore().equals(getStato()))
			return StatoIncomingStaff.get(getNomina().getStatoMobilita());
		if (StatoStudenteIncoming.TERMINATO.getValore().equals(getStato()))
			return StatoIncomingStaff.PARTITO;
		return StatoIncomingStaff.get(getStato());
	}
	
	public Persona getUtenteArrivo() {
		return utenteArrivo;
	}

	public void setUtenteArrivo(Persona utenteArrivo) {
		this.utenteArrivo = utenteArrivo;
	}

	public Persona getUtenteStipula() {
		return utenteStipula;
	}

	public void setUtenteStipula(Persona utenteStipula) {
		this.utenteStipula = utenteStipula;
	}

	public Persona getUtentePartenza() {
		return utentePartenza;
	}

	public void setUtentePartenza(Persona utentePartenza) {
		this.utentePartenza = utentePartenza;
	}
	public Ateneo getAteneoDiProvenienza() {
		return ateneoDiProvenienza;
	}

	public void setAteneoDiProvenienza(Ateneo ateneoDiProvenienza) {
		this.ateneoDiProvenienza = ateneoDiProvenienza;
	}

	public Integer getPeriodoPermanenza() {
		return periodoPermanenza;
	}

	public void setPeriodoPermanenza(Integer periodoPermanenza) {
		this.periodoPermanenza = periodoPermanenza;
	}
	
	public Date getDataFineProlungamento() {
		return dataFineProlungamento;
	}

	public void setDataFineProlungamento(Date dataFineProlungamento) {
		this.dataFineProlungamento = dataFineProlungamento;
	}

	public String getAteneoDescr()
	{
		Ateneo ateneo=(getNomina()!=null)?getNomina().getAteneo() : getAteneoDiProvenienza();
		return (ateneo != null)? ateneo.getCodiceErasmus() + " - " + ateneo.getLabel() :"";
	}

	public String getAteneoDiProvenienzaDescr()
	{
		return (ateneoDiProvenienza != null)? ateneoDiProvenienza.getDescr() : "";
	}

	public TipoMobilita getTipoMobilita() {
		return tipoMobilita;
	}

	public void setTipoMobilita(TipoMobilita tipoMobilita) {
		this.tipoMobilita = tipoMobilita;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getNumeroCarriera() {
		return numeroCarriera;
	}

	public void setNumeroCarriera(Integer numeroCarriera) {
		this.numeroCarriera = numeroCarriera;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	public boolean isCarrieraPresente() {
		return (pincode!=null) && (numeroCarriera!=null);
	}

	public Carriera getCarriera() {
		return carriera;
	}

	public void setCarriera(Carriera carriera) {
		this.carriera = carriera;
	}

	public String getUpn() {
		return upn;
	}

	public void setUpn(String upn) {
		this.upn = upn;
	}

	public String getPuk() {
		return puk;
	}

	public void setPuk(String puk) {
		this.puk = puk;
	}
	
	public boolean isNuovoAccount() {
		return nuovoAccount;
	}

	public void setNuovoAccount(boolean nuovoAccount) {
		this.nuovoAccount = nuovoAccount;
	}

	public boolean isCredenzialiPresenti() {
		return StringUtils.isNotBlank(upn);
	}
	
	public Object[] getCredenziali() {
		Object[] ret = new Object[3];
		ret[0] = upn;
		ret[1] = puk;
		ret[2] = (nuovoAccount)? true:false;
		return ret;	
	}

	public java.util.List<String> getStampePerAggregato() {
		return stampePerAggregato;
	}

	public void setStampePerAggregato(java.util.List<String> stampePerAggregato) {
		this.stampePerAggregato = stampePerAggregato;
	}
	
	public Date getDataWelcomeSession() {
		return dataWelcomeSession;
	}
	
	public void setDataWelcomeSession(Date dataWelcomeSession) {
		this.dataWelcomeSession = dataWelcomeSession;
	}
	
	public boolean isCreazioneCarriera()
	{
		return (!isCarrieraPresente()) && StatoStudenteIncoming.get(stato).isCreazioneCarriera()
				&& (!tipoMobilita.getIscrizioneCdsAttiva() || tipoMobilita.isDottoratoInCotutela()); // Lodolo(09-12-2010): solo per gli studenti incoming cha hanno un tipo moblità che non prevede l'iscrizione (FLAG_ISCRIZIONE_CDS=N in TIPI MOBILITA) ad eccezione dei dottorandi in cotutela incoming.
	}

	public Long getDurataProlungamento() {
		if (durataProlungamento == null)
			return 0L;
		return durataProlungamento;
	}

	public void setDurataProlungamento(Long durataProlungamento) {
		this.durataProlungamento = durataProlungamento;
	}
	
	public Long getDurataComplessiva() {
		if ((nomina==null || nomina.getDurata()==null) && (getDurata() == null))
			return null;
		// TODO : attualmente la durata in SI e' gestita solo da applicazione STAFF
		//        quando estenderemo bisogna adattare questa procedura
		Long dur = "Staff".equals(getApp()) && getDurata() != null ? getDurata() : nomina.getDurata();
		return (dur != null) && isProlungamento() ? dur + getDurataProlungamento() : dur;
	}

	public Long getDurataSenzaProlungamento() {
		if ((nomina==null || nomina.getDurata()==null) && (getDurata() == null))
			return null;
		// TODO : attualmente la durata in SI e' gestita solo da applicazione STAFF
		//        quando estenderemo bisogna adattare questa procedura
		Long dur = "Staff".equals(getApp()) && getDurata() != null ? getDurata() : nomina.getDurata();
		return dur;
	}

	public Character getFlagRinuncia() {
		if (flagRinuncia == null)
			return 'N';
		return flagRinuncia;
	}
	
	public void setFlagRinuncia(Character flagRinuncia) {
		this.flagRinuncia = flagRinuncia;
	}
	
	public boolean isRinuncia() {
		return (new Character('S')).equals(flagRinuncia);
	}
	
	// TODO : chiedere se serve un controllo
	public boolean isDatiCodiceFiscaleModificabili()
	{
		return 	(id==null || getPersona()==null || getPersona().getId()==null  
				|| getPersona().getStatoCodiceFiscale()==null 
				|| getPersona().getStatoCodiceFiscale().equals('C')
				|| getPersona().getStatoCodiceFiscale().equals('A'));
	}

	/**
	 * Lo studente deve avere gia' carriera erasmus attiva
	 */
	public Integer getAnnoAccademicoSuccessivoPerIscrizioneErasmus()
	{
		if (getCarriera() != null 
			&& getCarriera().getAnnoAccademico() != null
			&& getCarriera().getCorso().isErasmus()
			&& (getCarriera().getStato().getId().equals("AT") 
					|| getCarriera().getStato().getId().equals("PS")))
			return new Integer(getCarriera().getAnnoAccademico()+1);
		
		return null; 	
	}
	
	public Date getDataTerminato() {
		return dataTerminato;
	}

	public void setDataTerminato(Date dataTerminato) {
		this.dataTerminato = dataTerminato;
	}

	public Persona getUtenteTerminato() {
		return utenteTerminato;
	}

	public void setUtenteTerminato(Persona utenteTerminato) {
		this.utenteTerminato = utenteTerminato;
	}
	
	public boolean isIscrizioneOTitoloCongiunto() {
		return  tipoMobilita !=null ? tipoMobilita.isIscrizioneOTitoloCongiunto() : false; 
	}
	
	// 21-02-2013 : la facolta' di interesse nella nomina non esiste piu' da ottobre 2012, 
	//              per la riorganzzazione in Scuole
	// TODO: il campo FLAG_MOD_FAC_NOMINA nel sottoprogramma, indica se lo studente 
	//       di scambio poteva modificare la facolta' di interesse; ora, con le scuole 
	//       non viene piu' utilizzato --> prima o poi rimuoverlo!
	public boolean isPuoModificareFacoltaNomina() {
		return false; 
		//return (nomina!=null && tipoMobilita!=null)?  tipoMobilita.isStudenteDiScambio() && nomina.getSottoProgramma().isModificaFacoltaNomina() :  false;
	}
	
	public Character getFlagDottorato() {
		if (flagDottorato == null)
			return 'N';
		return flagDottorato;
	}
	
	public void setFlagDottorato(Character flagDottorato) {
		this.flagDottorato = flagDottorato;
	}
	
	public boolean isDottorato() {
		return Common.CH_S.equals(getFlagDottorato());
	}
	
	public Ateneo getAteneo() {
		return getNomina() != null ? getNomina().getAteneo() : getAteneoDiProvenienza();
	}

	public String getIndirizzoEmailInvioTR() {
		return indirizzoEmailInvioTR;
	}

	public void setIndirizzoEmailInvioTR(String indirizzoEmailInvioTR) {
		this.indirizzoEmailInvioTR = indirizzoEmailInvioTR;
	}

	public Date getDataInvioEmailTR() {
		return dataInvioEmailTR;
	}

	public void setDataInvioEmailTR(Date dataInvioEmailTR) {
		this.dataInvioEmailTR = dataInvioEmailTR;
	}

	public Character getFlagNecessitaPermessoSoggiorno() {
		return flagNecessitaPermessoSoggiorno;
	}

	public void setFlagNecessitaPermessoSoggiorno(
			Character flagNecessitaPermessoSoggiorno) {
		this.flagNecessitaPermessoSoggiorno = flagNecessitaPermessoSoggiorno;
	}

	// TODO 2013
	public Character getFlagCfForzato() {
		return flagCfForzato;
	}

	public void setFlagCfForzato(Character flagCfForzato) {
		this.flagCfForzato = flagCfForzato;
	}
	
	public boolean isCfForzato() {
		return Common.CH_S.equals(getFlagCfForzato());
	}

	public boolean isCfEsteroInvalidoForzato() {
		return cfEsteroInvalidoForzato;
	}

	public void setCfEsteroInvalidoForzato(boolean cfEsteroInvalidoForzato) {
		this.cfEsteroInvalidoForzato = cfEsteroInvalidoForzato;
	}

	public Set<StudenteIncomingAllegato> getAllegati() {
		return allegati;
	}

	public void setAllegati(Set<StudenteIncomingAllegato> allegati) {
		this.allegati = allegati;
	}

	public MultipartFile getDocAllegatoDaAggiungere() {
		return docAllegatoDaAggiungere;
	}

	public void setDocAllegatoDaAggiungere(MultipartFile docAllegatoDaAggiungere) {
		this.docAllegatoDaAggiungere = docAllegatoDaAggiungere;
	}

	public String getDescrizioneAllegatoDaAggiungere() {
		return descrizioneAllegatoDaAggiungere;
	}

	public void setDescrizioneAllegatoDaAggiungere(
			String descrizioneAllegatoDaAggiungere) {
		this.descrizioneAllegatoDaAggiungere = descrizioneAllegatoDaAggiungere;
	}
	
	public List<StudenteIncomingAllegato> getAllegatiList() {
		return new ArrayList<StudenteIncomingAllegato>(getAllegati());
	}

	public Character getFlagVisibileAStudenteAllegatoDaAggiungere() {
		return flagVisibileAStudenteAllegatoDaAggiungere;
	}

	public void setFlagVisibileAStudenteAllegatoDaAggiungere(
			Character flagVisibileAStudenteAllegatoDaAggiungere) {
		this.flagVisibileAStudenteAllegatoDaAggiungere = flagVisibileAStudenteAllegatoDaAggiungere;
	}
	
	public List<StudenteIncomingAllegato> getAllegatiVisibiliAStudente() {
		List<StudenteIncomingAllegato> ret = new ArrayList<StudenteIncomingAllegato>();
		for (StudenteIncomingAllegato a: allegati)
			if (a.isVisibileAStudente())
				ret.add(a);
		return ret;
	}
	
	public List<StudenteIncomingAllegato> getAllegatiStudenteDaNotificare() {
		List<StudenteIncomingAllegato> ret = new ArrayList<StudenteIncomingAllegato>();
		for (StudenteIncomingAllegato a: allegati)
			if (a.isVisibileAStudente() && a.isDaNotificare())
				ret.add(a);
		return ret;
	}

	public Coorte getCoorte() {
		return coorte;
	}

	public void setCoorte(Coorte coorte) {
		this.coorte = coorte;
	}

	public Minicarriera getMinicarriera() {
		return minicarriera;
	}

	public void setMinicarriera(Minicarriera minicarriera) {
		this.minicarriera = minicarriera;
	}

	public ModalitaDiPagamento getModalitaDiPagamento() {
		return modalitaDiPagamento;
	}

	public void setModalitaDiPagamento(ModalitaDiPagamento modalitaDiPagamento) {
		this.modalitaDiPagamento = modalitaDiPagamento;
	}

	public String getCodiceAnagraficoCia() {
		return codiceAnagraficoCia;
	}

	public void setCodiceAnagraficoCia(String codiceAnagraficoCia) {
		this.codiceAnagraficoCia = codiceAnagraficoCia;
	}
	
	public Struttura getStrutturaAppartenenza() {
		return strutturaAppartenenza;
	}
	
	public void setStrutturaAppartenenza(Struttura strutturaAppartenenza) {
		this.strutturaAppartenenza = strutturaAppartenenza;
	}
	public Persona getReferenteInterno() {
		return referenteInterno;
	}
	public void setReferenteInterno(Persona referenteInterno) {
		this.referenteInterno = referenteInterno;
	}

	public Character getFlagInviaConfirmationMessage() {
		return flagInviaConfirmationMessage;
	}

	public void setFlagInviaConfirmationMessage(
			Character flagInviaConfirmationMessage) {
		this.flagInviaConfirmationMessage = flagInviaConfirmationMessage;
	}
	
	public boolean isStudente() {
        return getTipoMobilita() == null || getTipoMobilita().isStudenteODottorando();
	}

	public List<String> getImportiIntermediRate() {
		return importiIntermediRate;
	}

	public void setImportiIntermediRate(List<String> importiIntermediRate) {
		this.importiIntermediRate = importiIntermediRate;
	}

	public String getImportoNuovaRata() {
		return importoNuovaRata;
	}

	public void setImportoNuovaRata(String importoNuovaRata) {
		this.importoNuovaRata = importoNuovaRata;
	}

	public Long getNumeroNuovaRata() {
		return numeroNuovaRata;
	}

	public void setNumeroNuovaRata(Long numeroNuovaRata) {
		this.numeroNuovaRata = numeroNuovaRata;
	}

	public List<Date> getDateScadenzaRate() {
		return dateScadenzaRate;
	}

	public void setDateScadenzaRate(List<Date> dateScadenzaRate) {
		this.dateScadenzaRate = dateScadenzaRate;
	}

	public String getDescrizioneNuovaRata() {
		return descrizioneNuovaRata;
	}

	public void setDescrizioneNuovaRata(String descrizioneNuovaRata) {
		this.descrizioneNuovaRata = descrizioneNuovaRata;
	}

	public Date getScadenzaNuovaRata() {
		return scadenzaNuovaRata;
	}

	public void setScadenzaNuovaRata(Date scadenzaNuovaRata) {
		this.scadenzaNuovaRata = scadenzaNuovaRata;
	}

	public List<String> getDescrizioniRate() {
		return descrizioniRate;
	}

	public void setDescrizioniRate(List<String> descrizioniRate) {
		this.descrizioniRate = descrizioniRate;
	}

	public Persona getAutoreRinuncia() {
		return autoreRinuncia;
	}

	public void setAutoreRinuncia(Persona autoreRinuncia) {
		this.autoreRinuncia = autoreRinuncia;
	}

	public Date getDataRinuncia() {
		return dataRinuncia;
	}

	public void setDataRinuncia(Date dataRinuncia) {
		this.dataRinuncia = dataRinuncia;
	}

	public IncomingStaff getIncomingStaff() {
		return incomingStaff;
	}

	public void setIncomingStaff(IncomingStaff incomingStaff) {
		this.incomingStaff = incomingStaff;
	}

	public Long getDurata() {
		return durata;
	}

	public void setDurata(Long durata) {
		this.durata = durata;
	}

	public UnitaMisuraDurata getUnitaMisuraDurata() {
		return unitaMisuraDurata;
	}

	public void setUnitaMisuraDurata(UnitaMisuraDurata unitaMisuraDurata) {
		this.unitaMisuraDurata = unitaMisuraDurata;
	}

	public Character getFlagUsaDataFineAlPostoDiPeriodo() {
		if (flagUsaDataFineAlPostoDiPeriodo == null) {
			if (dataPartenzaPrevista != null)
				flagUsaDataFineAlPostoDiPeriodo = 'S';
			else
				flagUsaDataFineAlPostoDiPeriodo = 'N';
		}
		return flagUsaDataFineAlPostoDiPeriodo;
	}

	public void setFlagUsaDataFineAlPostoDiPeriodo(Character flagUsaDataFineAlPostoDiPeriodo) {
		this.flagUsaDataFineAlPostoDiPeriodo = flagUsaDataFineAlPostoDiPeriodo;
	}

	public boolean isUsaDataFineAlPostoDiPeriodo() {
		return Common.CH_S.equals(getFlagUsaDataFineAlPostoDiPeriodo());
	}

	public Character getFlagNuovoPartner() {
		if (flagNuovoPartner == null) {
			if (getAteneoDiProvenienza() == null && (StringUtils.isNotBlank(getNomeNuovoPartner()) || getNazioneNuovoPartner() != null))
				flagNuovoPartner = 'S';
			else
				flagNuovoPartner = 'N';
		}
			
		return flagNuovoPartner;
	}

	public void setFlagNuovoPartner(Character flagNuovoPartner) {
		this.flagNuovoPartner = flagNuovoPartner;
	}

	public boolean isNuovoPartner() {
		return Common.CH_S.equals(getFlagNuovoPartner());
	}
	
	public String getNomeNuovoPartner() {
		return nomeNuovoPartner;
	}

	public void setNomeNuovoPartner(String nomeNuovoPartner) {
		this.nomeNuovoPartner = nomeNuovoPartner;
	}

	public Nazione getNazioneNuovoPartner() {
		return nazioneNuovoPartner;
	}

	public void setNazioneNuovoPartner(Nazione nazioneNuovoPartner) {
		this.nazioneNuovoPartner = nazioneNuovoPartner;
	}

	public Date getDataSegnalazioneArrivo() {
		return dataSegnalazioneArrivo;
	}

	public void setDataSegnalazioneArrivo(Date dataSegnalazioneArrivo) {
		this.dataSegnalazioneArrivo = dataSegnalazioneArrivo;
	}

	public Date getDataSegnalazionePartenza() {
		return dataSegnalazionePartenza;
	}

	public void setDataSegnalazionePartenza(Date dataSegnalazionePartenza) {
		this.dataSegnalazionePartenza = dataSegnalazionePartenza;
	}

	public List<String> getTipiAttivitaStaffSelected() {
		return tipiAttivitaStaffSelected;
	}

	public void setTipiAttivitaStaffSelected(List<String> tipiAttivitaStaffSelected) {
		this.tipiAttivitaStaffSelected = tipiAttivitaStaffSelected;
	}

	public ModelMap getDescrizioniAttivitaStaffSelected() {
		return descrizioniAttivitaStaffSelected;
	}

	public void setDescrizioniAttivitaStaffSelected(ModelMap descrizioniAttivitaStaffSelected) {
		this.descrizioniAttivitaStaffSelected = descrizioniAttivitaStaffSelected;
	}

	public Character getFlagUsaDataFineAlPostoDiPeriodoPerProlungamento() {
		if (flagUsaDataFineAlPostoDiPeriodoPerProlungamento == null) {
			if (dataFineProlungamento != null)
				flagUsaDataFineAlPostoDiPeriodoPerProlungamento = 'S';
			else
				flagUsaDataFineAlPostoDiPeriodoPerProlungamento = 'N';
		}
		return flagUsaDataFineAlPostoDiPeriodoPerProlungamento;
	}

	public void setFlagUsaDataFineAlPostoDiPeriodoPerProlungamento(
			Character flagUsaDataFineAlPostoDiPeriodoPerProlungamento) {
		this.flagUsaDataFineAlPostoDiPeriodoPerProlungamento = flagUsaDataFineAlPostoDiPeriodoPerProlungamento;
	}
	
	public boolean isUsaDataFineAlPostoDiPeriodoPerProlungamento() {
		return Common.CH_S.equals(getFlagUsaDataFineAlPostoDiPeriodoPerProlungamento());
	}

	public UnitaMisuraDurata getUnitaMisuraDurataProlungamento() {
		return unitaMisuraDurataProlungamento;
	}

	public void setUnitaMisuraDurataProlungamento(UnitaMisuraDurata unitaMisuraDurataProlungamento) {
		this.unitaMisuraDurataProlungamento = unitaMisuraDurataProlungamento;
	}
	
	public boolean isIniziale() {
		return StatoStudenteIncoming.INIZIALE.getValore().equals(getStato());
	}
	
	public boolean isPartito() {
		return StatoStudenteIncoming.PARTITO.getValore().equals(getStato());
	}
	
	public boolean isTerminato() {
		return StatoStudenteIncoming.TERMINATO.getValore().equals(getStato());
	}

	public boolean isArrivato() {
		return StatoStudenteIncoming.ARRIVATO.getValore().equals(getStato());
	}
	
	public String getCognomeTmp() {
		return cognomeTmp;
	}

	public void setCognomeTmp(String cognomeTmp) {
		this.cognomeTmp = cognomeTmp;
	}

	public String getNomeTmp() {
		return nomeTmp;
	}

	public void setNomeTmp(String nomeTmp) {
		this.nomeTmp = nomeTmp;
	}

	public Date getDataNascitaTmp() {
		return dataNascitaTmp;
	}

	public void setDataNascitaTmp(Date dataNascitaTmp) {
		this.dataNascitaTmp = dataNascitaTmp;
	}

	public Character getGenereTmp() {
		return genereTmp;
	}

	public void setGenereTmp(Character genereTmp) {
		this.genereTmp = genereTmp;
	}

	public String getCodiceFiscaleTmp() {
		return codiceFiscaleTmp;
	}

	public void setCodiceFiscaleTmp(String codiceFiscaleTmp) {
		this.codiceFiscaleTmp = codiceFiscaleTmp;
	}

	public Localita getNascitaTmp() {
		return nascitaTmp;
	}

	public void setNascitaTmp(Localita nascitaTmp) {
		this.nascitaTmp = nascitaTmp;
	}

	public Nazione getNazionalitaTmp() {
		return nazionalitaTmp;
	}

	public void setNazionalitaTmp(Nazione nazionalitaTmp) {
		this.nazionalitaTmp = nazionalitaTmp;
	}

	public Character getStatoCodiceFiscaleTmp() {
		return statoCodiceFiscaleTmp;
	}

	public void setStatoCodiceFiscaleTmp(Character statoCodiceFiscaleTmp) {
		this.statoCodiceFiscaleTmp = statoCodiceFiscaleTmp;
	}

	public Nazione getNazioneNascitaTmp() {
		return nazioneNascitaTmp;
	}

	public void setNazioneNascitaTmp(Nazione nazioneNascitaTmp) {
		this.nazioneNascitaTmp = nazioneNascitaTmp;
	}

	public Territorio getTerritorioNascitaTmp() {
		return territorioNascitaTmp;
	}

	public void setTerritorioNascitaTmp(Territorio territorioNascitaTmp) {
		this.territorioNascitaTmp = territorioNascitaTmp;
	}

	public String getComuneNascitaTmp() {
		return comuneNascitaTmp;
	}

	public void setComuneNascitaTmp(String comuneNascitaTmp) {
		this.comuneNascitaTmp = comuneNascitaTmp;
	}

	public String getEmailTmp() {
		return emailTmp;
	}

	public void setEmailTmp(String emailTmp) {
		this.emailTmp = emailTmp;
	}

	public List<IncomingStaffChecklistElement> getStaffChecklistElements() {
		return staffChecklistElements;
	}

	public void setStaffChecklistElements(List<IncomingStaffChecklistElement> staffChecklistElements) {
		this.staffChecklistElements = staffChecklistElements;
	}
	
	public String getStaffChecklistElementsJson() {
		if (getStaffChecklistElements() == null || getStaffChecklistElements().isEmpty())
			return null;
		
		try {
			JSONArray els = new JSONArray(); 
			for (IncomingStaffChecklistElement r: getStaffChecklistElements())
			{
				JSONObject obj = new JSONObject();
				obj.put("id", r.getIncomingStaffChecklist().getId());
				obj.put("label", r.getIncomingStaffChecklist().getTesto());
				obj.put("descrizione", r.getIncomingStaffChecklist().getDescrizione());
				obj.put("obbligatorio", r.getIncomingStaffChecklist().isObbligatorio());
				obj.put("testoAvvisoSi", r.getIncomingStaffChecklist().getTestoAvvisoSi());
				obj.put("testoAvvisoNo", r.getIncomingStaffChecklist().getTestoAvvisoNo());
				obj.put("dettaglioNonRichiesto", r.getIncomingStaffChecklist().isDettaglioNonRichiesto());
				obj.put("dettaglioObbligatorio", r.getIncomingStaffChecklist().isDettaglioObbligatorio());
				obj.put("dettaglioOpzionale", r.getIncomingStaffChecklist().isDettaglioOpzionale());
				obj.put("dettaglioObbligatorioConSi", r.getIncomingStaffChecklist().isDettaglioObbligatorioConSi());
				obj.put("dettaglioOpzionaleConSi", r.getIncomingStaffChecklist().isDettaglioOpzionaleConSi());
				obj.put("dettaglioObbligatorioConNo", r.getIncomingStaffChecklist().isDettaglioObbligatorioConNo());
				obj.put("dettaglioOpzionaleConNo", r.getIncomingStaffChecklist().isDettaglioOpzionaleConNo());
				obj.put("valore", r.getValore());
				obj.put("dettaglio", r.getDettaglio());
				obj.put("erroreValore", r.getErrorValore());
				obj.put("erroreDettaglio", r.getErrorDettaglio());
				obj.put("blocca", r.isBlocca());
				els.put(obj);
			}
			
			return els.toString();
		}
		catch (JSONException je) {
			throw new RuntimeException(je);
		}
	}
	
	public Date getDataPartenzaAttualmenteConosciuta() {
		Date dataArr = getDataArrivo() != null ? getDataArrivo() : getDataArrivoPrevista();
		if (getDataPartenza() != null)
    		return getDataPartenza();
		else if (isProlungamento() && getDataFineProlungamento() != null)
			return getDataFineProlungamento();
		else if (isProlungamento() && getDurataComplessiva() != null && dataArr != null)
			return Common.addDaysToDate(dataArr, new Float(getDurataComplessiva() * getUnitaMisuraDurata().getGiorniCorrispondenti()).intValue());
    	else if (getDataPartenzaPrevista() != null)
    		return getDataPartenzaPrevista();
    	else if (dataArr != null && getDurata() != null && getUnitaMisuraDurata() != null)
    		return Common.addDaysToDate(dataArr, new Float(getDurata() * getUnitaMisuraDurata().getGiorniCorrispondenti()).intValue());
		return null;
	}
	
	public boolean isAlmenoPartito() {
		return StatoStudenteIncoming.PARTITO.getValore().equals(getStato()) || StatoStudenteIncoming.TERMINATO.getValore().equals(getStato()); 
	}

	public String getApp() {
		if (StringUtils.isBlank(app))
			return IncomingModificabileDaApp.ElencoApp.ALMARM.getNome();
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}
	
	public boolean isAppAlmaRM() {
		return IncomingModificabileDaApp.ElencoApp.ALMARM.getNome().equals(getApp());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomina == null) ? 0 : nomina.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StudenteIncoming))
			return false;
		StudenteIncoming other = (StudenteIncoming) obj;
		if (nomina == null) {
			if (other.nomina != null)
				return false;
		} else if (!nomina.equals(other.nomina))
			return false;
		return true;
	}

	public Set<IncomingProlungamento> getRichiesteDiProlungamento() {
		return richiesteDiProlungamento;
	}

	public void setRichiesteDiProlungamento(Set<IncomingProlungamento> richiesteDiProlungamento) {
		this.richiesteDiProlungamento = richiesteDiProlungamento;
	}
	
	public List<IncomingProlungamento> getRichiesteDiProlungamentoOrdinate() {
		ArrayList<IncomingProlungamento> ret = new ArrayList<IncomingProlungamento>(getRichiesteDiProlungamento());
		Collections.sort(ret, new IncomingProlungamento.IncomingProlungamentoComparator());
		return ret;
	}
	
	public IncomingProlungamento getUltimaRichiestaDiProlungamento() {
		List<IncomingProlungamento> l = getRichiesteDiProlungamentoOrdinate();
		return l != null && !l.isEmpty() ? l.get(l.size() - 1) : null;
	}
	
	public boolean isProlungamentoDaApprovare() {
		return StatoStudenteIncoming.PROLUNGAMENTO_DA_APPROVARE.getValore().equals(getStato());
	}
	
	public boolean isPuoUsareDurataPerProlungamento() {
		if (!isProlungamento())
			return true;
		for (IncomingProlungamento ip: getRichiesteDiProlungamento())
			if (ip.isApprovato() && ip.isUsaDataFineAlPostoDiPeriodoPerProlungamento())
				return false;
		return true;
				
	}
	
	public SottoProgramma getSottoProgramma() {
		if (getNomina() != null)
			return getNomina().getSottoProgramma();
		return null;
	}
	
	public boolean isVisiting() {
		if (getNomina() != null)
			return getNomina().isVisiting();
		SottoProgramma sp = getSottoProgramma();
		if (sp != null)
			return sp.isVisiting();
		return false;
	}

	public FototesseraModel getFototesseraModel() {
		return fototesseraModel;
	}

	public void setFototesseraModel(FototesseraModel fototesseraModel) {
		this.fototesseraModel = fototesseraModel;
	}
	
	public Struttura getDipartimentoDiRiferimento() {
		if (getStrutturaAppartenenza() != null
				&& getStrutturaAppartenenza().isDipartimento())
			return getStrutturaAppartenenza();
		if (getIncomingStaff() != null && getIncomingStaff().getDipartimentoDiRiferimento() != null)
			return getIncomingStaff().getDipartimentoDiRiferimento();
		return null;
	}

	public String getBadgeRfid() {
		return badgeRfid;
	}

	public void setBadgeRfid(String badgeRfid) {
		this.badgeRfid = badgeRfid;
	}

	public String getPassaporto() {
		return passaporto;
	}

	public void setPassaporto(String passaporto) {
		this.passaporto = passaporto;
	}

	public String getIdDocPassaporto() {
		return idDocPassaporto;
	}

	public void setIdDocPassaporto(String idDocPassaporto) {
		this.idDocPassaporto = idDocPassaporto;
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

	
	public Campus getCampus() {
		return getNomina() != null ? getNomina().getCampus() : null;
	}

	public AccordoOperativo getAccordoOperativo() {
		if (getNomina() != null)
			return getNomina().getAccordoOperativo();
		return null;
	}

	public void setStrutturaAmministrativa(StrutturaAmministrativa strutturaAmministrativa) {
		this.strutturaAmministrativa = strutturaAmministrativa;
	}
	public StrutturaAmministrativa getStrutturaAmministrativa() {
		return strutturaAmministrativa;
	}

	// -----------------------------------------------------------
	// DOCUMENTO LA
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
		setSottocartellaDocLA(null);
		setNomeDocLA(null);
	}

	public String getIdDocLAFirmato() {
		return idDocLAFirmato;
	}

	public void setIdDocLAFirmato(String idDocLAFirmato) {
		this.idDocLAFirmato = idDocLAFirmato;
	}

	public String getNomeDocLAFirmato() {
		return nomeDocLAFirmato;
	}

	public void setNomeDocLAFirmato(String nomeDocLAFirmato) {
		this.nomeDocLAFirmato = nomeDocLAFirmato;
	}

	public String getSottocartellaDocLAFirmato() {
		return sottocartellaDocLAFirmato;
	}

	public void setSottocartellaDocLAFirmato(String sottocartellaDocLAFirmato) {
		this.sottocartellaDocLAFirmato = sottocartellaDocLAFirmato;
	}

	public String getPathNameDocLAFirmato() {
		return Common.getPathNameAllegato(getIdDocLAFirmato(), getNomeDocLAFirmato(), getSottocartellaDocLAFirmato());
	}
	
	public Character getFlagLA() {
		return flagLA;
	}

	public void setFlagLA(Character flagLA) {
		this.flagLA = flagLA;
	}

	public boolean isDocLAFirmatoValido(){
		return getIdDocLAFirmato() != null;
	}
	
	public boolean isDocLADaValidare(){
		return idDocLA != null && FlagLAIncoming.isDocLADaValidare(getFlagLA());
	}

	public boolean isDocLARifiutato(){
		return FlagLAIncoming.isDocLARifiutato(getFlagLA());
	}

	public boolean isDocLAValidato(){
		return idDocLA != null && FlagLAIncoming.isDocLAValidato(getFlagLA());
	}

	public Date getDataValidazioneLA() {
		return dataValidazioneLA;
	}

	public void setDataValidazioneLA(Date dataValidazioneLA) {
		this.dataValidazioneLA = dataValidazioneLA;
	}

	public Persona getAutoreValidazioneLA() {
		return autoreValidazioneLA;
	}

	public void setAutoreValidazioneLA(Persona autoreValidazioneLA) {
		this.autoreValidazioneLA = autoreValidazioneLA;
	}

	public String getNoteRifiutoDocLA() {
		return noteRifiutoDocLA;
	}

	public void setNoteRifiutoDocLA(String noteRifiutoDocLA) {
		this.noteRifiutoDocLA = noteRifiutoDocLA;
	}

	public Date getDataLAFirmato() {
		return dataLAFirmato;
	}

	public void setDataLAFirmato(Date dataLAFirmato) {
		this.dataLAFirmato = dataLAFirmato;
	}

	public Persona getAutoreLAFirmato() {
		return autoreLAFirmato;
	}

	public void setAutoreLAFirmato(Persona autoreLAFirmato) {
		this.autoreLAFirmato = autoreLAFirmato;
	}

	public String getAnnoAccademicoSottoprogLabel(){
		if (getSottoProgramma() == null)
			return "";
		String lab = getNomina().getPeriodoMobilita().getAnnoAccademico() !=null ? "A.A. " + getNomina().getPeriodoMobilita().getAnnoAccademicoLabelCorta() + " - " : "";
		lab += getSottoProgramma().getNome();
		return lab;
	}

	// -----------------------------------------------------------
	// TRANSIENT FILE PER UPLOAD PASSAPORTO
	private transient MultipartFile docPassaporto;
	
	public MultipartFile getDocPassaporto() {
		return docPassaporto;
	}

	public void setDocPassaporto(MultipartFile docPassaporto) {
		this.docPassaporto = docPassaporto;
	}

	// -----------------------------------------------------------
	// TRANSIENT FILE PER UPLOAD DOC LA
	private transient MultipartFile docLA;
	public MultipartFile getDocLA() {
		return docLA;
	}

	public void setDocLA(MultipartFile docLA) {
		this.docLA = docLA;
	}
	// --

}

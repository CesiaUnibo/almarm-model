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

import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import it.unibo.almarm.dao.storedprocedure.IncomingModificabileDaApp;
import it.unibo.almarm.model.accordi.Accordo;
import it.unibo.almarm.model.accordi.AccordoOperativo;
import it.unibo.almarm.model.accordi.Programma;
import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Campus;
import it.unibo.almarm.model.attori.Facolta;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.attori.Struttura;
import it.unibo.almarm.model.attori.StrutturaAmministrativa;
import it.unibo.almarm.model.flussiscambio.EsecuzioneAccordo;
import it.unibo.almarm.model.flussiscambio.FlussoScambioEsecuzione;
import it.unibo.almarm.model.flussiscambio.PeriodoMobilita;
import it.unibo.almarm.model.flussiscambio.UnitaMisuraDurata;
import it.unibo.almarm.model.luoghi.Nazione;
import it.unibo.almarm.model.staff.StatoIncomingStaff;
import it.unibo.almarm.util.Common;
import it.unibo.almarm.util.ValChecklistNominaComparator;
import it.unibo.almarm.webapp.flow.mvc.ModelMap;


public class Nomina implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

    public enum StatoNomina {

		BOZZA("bozza", "Grey"),

		DA_VALIDARE("da validare", "Yellow"),

		DA_APPROVARE("da approvare", "Gold"),

		APPROVATO("approvato", "LightGreen"),

		REGISTRATO("registrato", "Green"),

		RIFIUTATO("rifiutato", "Red"),

		RINUNCIATO("rinunciato", "Red"),
		
		CANCELLATO("cancellato", "Red");

		private final String valore;

		private final String color;
		
		StatoNomina(String valore, String color) {
			this.valore = valore;
			this.color = color;
		}

        public static StatoNomina getBy(String valore) {
            for (StatoNomina statoNomina : Arrays.asList(StatoNomina.values())) {
                if (statoNomina.getValore().equals(valore)) {
                    return statoNomina;
                }
            }
            return StatoNomina.APPROVATO;
        }

        public String getValore() {
			return valore;
		}

		public String getColor() { return color; }

		public String getMessageKey(){
			String stato = "null";
			if (StringUtils.isNotBlank(valore))
				stato = valore.toLowerCase().replace(" ", "");
			return "nomina.stato." + stato;
		}

	}
	
	private Long id;
	private String cognome;
	private String nome;
	private Date dataNascita;
	private Character genere;
	private Nazione cittadinanza;
	private Nazione nazioneNascita;
	private String codiceFiscale;
	private String email;
	private String telefono;
	private String cellulare;
	private String passaporto;
	private String idDocPassaporto;
	private String nomeDocPassaporto;
	private String sottocartellaDocPassaporto;
	private Date dataArrivoPrevista;
	private Date dataPartenzaPrevista;
	private String ciclo;

	private Long durata;
	private String esigenzeParticolari;
	private TipoMobilita tipoMobilita; 
	
	private String qualificaReferente;
	private String nomeReferente;
	private String cognomeReferente;
	private String telefonoReferente;
	private String faxReferente;
	private String emailReferente;
	
	private String token;
	private Date scadenzaToken;
	
	private String note;
	private SortedSet<ValChecklistNomina> checklistNomina = new TreeSet<ValChecklistNomina>(new ValChecklistNominaComparator());
	
	private Date dataInvioMail;
	
	private Date dataInserimento;
	private Persona utenteInserimento;
	private Date dataUltimaModifica;
	private Persona utenteUltimaModifica;

	private FlussoScambioEsecuzione flussoScambioEsecuzione;
	private Ateneo ateneoProvenienza;
	private StudenteIncoming studenteIncoming;
	private Character flagRinuncia;
	private Integer periodoPermanenza;
	private Campus campus;
	private Facolta facolta;
	private String codiceCorso;
	private Character flagDottorato;
	private Long idReferenteInterno;
	private Character flagNecessitaPermessoSoggiorno;
	private Struttura strutturaAppartenenza;
	private Persona referenteInterno;
	
	private Character flagTipoNomina;
	private String matricola;
	
	private Persona autoreRinuncia;
	private Date dataRinuncia;
	
	private Integer annoDiImmatricolazione;
	private Integer cicloDottorato;
	private Integer cicloDottoratoDiRendicontazione;
	private String codiceCorsoDiRendicontazione;
	
	
	private UnitaMisuraDurata unitaMisuraDurata;
	private Character flagUsaDataFineAlPostoDiPeriodo;
	private Character flagNuovoPartner;
	private String nomeNuovoPartner;
	private Nazione nazioneNuovoPartner;
	private Persona persona;
	private String app;
	
	private NominaApprovazione nominaApprovazione;
	
	private NominaValidazione nominaValidazione;
	
	private NominaStaff nominaStaff;
	
	private StrutturaAmministrativa strutturaAmministrativa;
	
	private Set<NominaAllegato> allegati = new HashSet<NominaAllegato>();
	
	// campi non persistiti
	private List<String> tipiAttivitaStaffSelected;
	private ModelMap descrizioniAttivitaStaffSelected;
	private Character inviaEmailAvvisoRiportaInBozza;
	private List<NominaStaffChecklistElement> staffChecklistElements;
	private transient MultipartFile docAllegatoDaAggiungere;
	private String descrizioneAllegatoDaAggiungere;
	private Character flagVisibileAStudenteAllegatoDaAggiungere;

	private Character flagInseritoDaPartner;

	private String stato;

	private Persona autoreCancellazione;

	private Date dataCancellazione;
	
	private String noteCancellazione;

	private Character flagGestioneValidazione;

	private Character flagGestioneApprovazione;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public FlussoScambioEsecuzione getFlussoScambioEsecuzione() {
		return flussoScambioEsecuzione;
	}
	public void setFlussoScambioEsecuzione(
			FlussoScambioEsecuzione flussoScambioEsecuzione) {
		this.flussoScambioEsecuzione = flussoScambioEsecuzione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public Character getGenere() {
		return genere;
	}
	public void setGenere(Character genere) {
		this.genere = genere;
	}
	public Nazione getCittadinanza() {
		return cittadinanza;
	}
	public void setCittadinanza(Nazione cittadinanza) {
		this.cittadinanza = cittadinanza;
	}
	public Nazione getNazioneNascita() {
		return nazioneNascita;
	}
	public void setNazioneNascita(Nazione nazioneNascita) {
		this.nazioneNascita = nazioneNascita;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCellulare() {
		return cellulare;
	}
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
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
	public Date getDataArrivoPrevista() {
		return dataArrivoPrevista;
	}
	public void setDataArrivoPrevista(Date dataArrivoPrevista) {
		this.dataArrivoPrevista = dataArrivoPrevista;
	}
	public Date getDataPartenzaPrevista() {
		return dataPartenzaPrevista;
	}
	public void setDataPartenzaPrevista(Date dataPartenzaPrevista) {
		this.dataPartenzaPrevista = dataPartenzaPrevista;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public String getEsigenzeParticolari() {
		return esigenzeParticolari;
	}
	public void setEsigenzeParticolari(String esigenzeParticolari) {
		this.esigenzeParticolari = esigenzeParticolari;
	}
	public String getNomeReferente() {
		return nomeReferente;
	}
	public void setNomeReferente(String nomeReferente) {
		this.nomeReferente = nomeReferente;
	}
	public String getCognomeReferente() {
		return cognomeReferente;
	}
	public void setCognomeReferente(String cognomeReferente) {
		this.cognomeReferente = cognomeReferente;
	}
	public String getTelefonoReferente() {
		return telefonoReferente;
	}
	public void setTelefonoReferente(String telefonoReferente) {
		this.telefonoReferente = telefonoReferente;
	}
	public String getEmailReferente() {
		return emailReferente;
	}
	public void setEmailReferente(String emailReferente) {
		this.emailReferente = emailReferente;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getScadenzaToken() {
		return scadenzaToken;
	}
	public void setScadenzaToken(Date scadenzaToken) {
		this.scadenzaToken = scadenzaToken;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Programma getProgramma() {
		FlussoScambioEsecuzione flusso = getFlussoScambioEsecuzione();
		if (flusso != null && flusso.getScambioEsecuzione().getSottoProgramma() != null
			&& 	flusso.getScambioEsecuzione().getSottoProgramma().getProgramma() != null)
			return flusso.getScambioEsecuzione().getSottoProgramma().getProgramma();
		return new Programma();
	}
	
	public SottoProgramma getSottoProgramma() {
		FlussoScambioEsecuzione flusso = getFlussoScambioEsecuzione();
		if (flusso != null && flusso.getScambioEsecuzione().getSottoProgramma() != null)
			return flusso.getScambioEsecuzione().getSottoProgramma();
		return new SottoProgramma();
	}
	
	public AccordoOperativo getAccordoOperativo() {
		FlussoScambioEsecuzione flusso = getFlussoScambioEsecuzione();
		if (flusso != null && flusso.getScambioEsecuzione().getEsecuzioneAccordo() != null)
			if (flusso.getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo() != null)
				return flusso.getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo();
		return null;
		
	}
	
	public Accordo getAccordoQuadro() {
		AccordoOperativo accordoOperativo=getAccordoOperativo();
		return accordoOperativo != null  ?  accordoOperativo.getAccordoQuadro() : null;
	}
	
	public PeriodoMobilita getPeriodoMobilita() {
		FlussoScambioEsecuzione flusso = getFlussoScambioEsecuzione();
		if (flusso != null && flusso.getScambioEsecuzione().getEsecuzioneAccordo() != null && flusso.getScambioEsecuzione().getEsecuzioneAccordo().getPeriodoMobilita() != null)
			return flusso.getScambioEsecuzione().getEsecuzioneAccordo().getPeriodoMobilita();
		return null;
	}
	
	public EsecuzioneAccordo getEsecuzioneAccordo() {
		if (flussoScambioEsecuzione != null)
			return flussoScambioEsecuzione.getScambioEsecuzione().getEsecuzioneAccordo();
		return null;
	}
	
	public SortedSet<ValChecklistNomina> getChecklistNomina() {
		return checklistNomina;
	}
	
	public void setChecklistNomina(SortedSet<ValChecklistNomina> checklistNomina) {
		this.checklistNomina = checklistNomina;
	}
	
	public  ValChecklistNomina[] getAChecklistNomina() {
		return (ValChecklistNomina[]) this.checklistNomina.toArray(new ValChecklistNomina[0]);
	}
	
	public boolean addChecklist(ValChecklistNomina valChecklistNomina) {
		 return this.checklistNomina.add(valChecklistNomina);
	}
	
	public boolean addChecklist(ElChecklistNomina elChecklistNomina) {
		ValChecklistNomina val = new ValChecklistNomina();
		val.setElementoChecklist(elChecklistNomina);
		return addChecklist(val);
	}
	
	public String getLabelPeriodoMobilita() {
		if (flussoScambioEsecuzione!=null)
			return flussoScambioEsecuzione.getScambioEsecuzione().getEsecuzioneAccordo().getPeriodoMobilita().getLabel();
		return "";
	}
	public String getLabelAccordo() {
		FlussoScambioEsecuzione flusso = getFlussoScambioEsecuzione();
		if (flusso != null && flusso.getScambioEsecuzione().getEsecuzioneAccordo() != null && flusso.getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo() != null)
			return flusso.getScambioEsecuzione().getEsecuzioneAccordo().getAccordoOperativo().getAccordoOperativoView().getLabel();
		return "";
	}
	public String getQualificaReferente() {
		return qualificaReferente;
	}
	public void setQualificaReferente(String qualificaReferente) {
		this.qualificaReferente = qualificaReferente;
	}
	public String getFaxReferente() {
		return faxReferente;
	}
	public void setFaxReferente(String faxReferente) {
		this.faxReferente = faxReferente;
	}	
	public Date getDataInvioMail() {
		return dataInvioMail;
	}
	public void setDataInvioMail(Date dataInvioMail) {
		this.dataInvioMail = dataInvioMail;
	}
	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public Persona getUtenteInserimento() {
		return utenteInserimento;
	}
	public void setUtenteInserimento(Persona utenteInserimento) {
		this.utenteInserimento = utenteInserimento;
	}
	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}
	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}
	public Persona getUtenteUltimaModifica() {
		return utenteUltimaModifica;
	}
	public void setUtenteUltimaModifica(Persona utenteUltimaModifica) {
		this.utenteUltimaModifica = utenteUltimaModifica;
	}
	public Long getDurata() {
		return durata;
	}
	public void setDurata(Long durata) {
		this.durata = durata;
	}
	public Ateneo getAteneoProvenienza() {
		return ateneoProvenienza;
	}
	public void setAteneoProvenienza(Ateneo ateneoProvenienza) {
		this.ateneoProvenienza = ateneoProvenienza;
	}
	
	public String getStatoInvioMailColor() {
		return (dataInvioMail!=null)?  "green":"white";	
	}
	
	public String getStatoInvioMailColorDesc() {
		return (dataInvioMail!=null)?  "inviata":"non inviata";	
	}

	
	/**
	 *  Ritorna l'ateneo referente dell'accordo operativo , se null ritorna l'ateneo di provenienza sempre che impostato
	 */
	public Ateneo getAteneo() {
		AccordoOperativo acc = getAccordoOperativo();
		if (acc != null)
			return acc.getAteneoPartnerReferente();
		Ateneo ateneo = getAteneoProvenienza();
		if (ateneo != null)
			return ateneo;
		return null;
	}
	
	
	public StudenteIncoming getStudenteIncoming() {
		return studenteIncoming;
	}
	public void setStudenteIncoming(StudenteIncoming studenteIncoming) {
		this.studenteIncoming = studenteIncoming;
	}
	
	public String getNomeAttore() {
		return cognome + " " + nome;
	}
	
	public String getNomeCognome() {
		return Common.getNomeCognomeCapitalized(nome, cognome);
	}
	
	public Character getFlagRinuncia() {
		if (flagRinuncia == null)
			return 'N';
		return flagRinuncia;
	}
	public void setFlagRinuncia(Character flagRinuncia) {
		this.flagRinuncia = flagRinuncia;
	}
	
	public void rinuncia(Persona autore) {
		setFlagRinuncia(Common.CH_S);
		setStato(StatoIncomingStaff.RINUNCIATO.getValore());
		setAutoreRinuncia(autore);
		setDataRinuncia(new Date());
	}

	public void valida(Persona autoreValidazione) {
		// aggiorniamo lo stato della nomina
		StatoNomina nuovoStato = StatoNomina.APPROVATO;
		if (isGestioneApprovazioneAttiva())
			nuovoStato = StatoNomina.DA_APPROVARE;
		setStato(nuovoStato.getValore());

		// aggiorniamo lo stato di validazione a validato
		if (getNominaValidazione()!=null) {
			getNominaValidazione().setStatoValidazione(StatoValidazioneNomina.VALIDATO.getValore());
			getNominaValidazione().setAutoreValidazione(autoreValidazione);
			getNominaValidazione().setDataValidazione(new Date());
		}
	}

	public void tornaDaValidare() {
		setStato(StatoNomina.DA_VALIDARE.getValore());
		if (getNominaValidazione()!=null) {
			getNominaValidazione().setStatoValidazione(StatoValidazioneNomina.DA_VALIDARE.getValore());
			getNominaValidazione().setAutoreValidazione(null);
			getNominaValidazione().setAutoreRifiuto(null);
			getNominaValidazione().setDataRifiuto(null);
			getNominaValidazione().setDataValidazione(null);
			getNominaValidazione().setNoteRifiuto(null);
			getNominaValidazione().setNoteValidazione(null);

		}
	}

	public void rifiuta(Persona autoreRifiuto, String note) {
		// aggiorniamo lo stato della nomina
		setStato(StatoNomina.RIFIUTATO.getValore());

		// aggiorniamo lo stato di validazione a rifiutato
		if (getNominaValidazione()!=null) {
			getNominaValidazione().setStatoValidazione(StatoValidazioneNomina.RIFIUTATO.getValore());
			getNominaValidazione().setAutoreRifiuto(autoreRifiuto);
			getNominaValidazione().setDataRifiuto(new Date());
			if (StringUtils.isNotBlank(note))
				getNominaValidazione().setNoteRifiuto(note);
		}
	}

	public void cancella(Persona autoreCancellazione) {
		setStato(StatoNomina.CANCELLATO.getValore());
		setAutoreCancellazione(autoreCancellazione);
		setDataCancellazione(new Date());
	}
	
	public boolean isRinunciata() {
		return (new Character('S')).equals(flagRinuncia);
	}
	
	public String getColor() {
		return getStatoNomina().getColor();
	}
	
	public String getColorDesc() {
		return getStato();
	}
	
	public boolean isNotStudenteIncomingRegistrato() {
		return getStudenteIncoming() == null || getStudenteIncoming().getId() == null;
	}
	
	public String getLabelAteneo() {
		Ateneo ateneo = getAteneo();
		if (ateneo != null)
			return ateneo.getCodiceErasmus() + " - " + ateneo.getRagioneSociale() + "<br/>" + ateneo.getNazionalita().getNazione();
		return "";
	}
	public Integer getPeriodoPermanenza() {
		return periodoPermanenza;
	}
	public void setPeriodoPermanenza(Integer periodoPermanenza) {
		this.periodoPermanenza = periodoPermanenza;
	}
	
	public String getDurataLabel() {
		String r = "";
		if (durata != null)
			r += durata.toString();
		UnitaMisuraDurata unitaMisuraDurata = getUnitaMisuraDurata();
		if (unitaMisuraDurata==null) {
			if (getFlussoScambioEsecuzione()!=null) {
				unitaMisuraDurata = flussoScambioEsecuzione.getUnitaMisuraDurata();
			}
		}
		if (unitaMisuraDurata!=null) {
			r += " " + unitaMisuraDurata.getUnita().toLowerCase();
		}
		return r;
	}
	public TipoMobilita getTipoMobilita() {
		return tipoMobilita;
	}
	public void setTipoMobilita(TipoMobilita tipoMobilita) {
		this.tipoMobilita = tipoMobilita;
	}
	public Campus getCampus() {
		return campus;
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	public void setCampusDaScambioEsecuzione() {
		if (getFlussoScambioEsecuzione()!=null)
			if (getFlussoScambioEsecuzione().getScambioEsecuzione()!=null)
				setCampus(getFlussoScambioEsecuzione().getScambioEsecuzione().getCampus());
	}
	public Facolta getFacolta() {
		return facolta;
	}
	
	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}
	
	public String getCodiceCorso() {
		return codiceCorso;
	}
	
	public void setCodiceCorso(String codiceCorso) {
		this.codiceCorso = codiceCorso;
	}

	public String getLabelSottoprogrammaCorso()
	{
		return getSottoProgramma().getNome() + (!StringUtils.isBlank(codiceCorso)? "<br/>Corso: "+codiceCorso :"");
	}
	
	public String getSiglaCampus() {
		if (campus == null)
			return "";
		return campus.getId();
	}
	public Character getFlagDottorato() {
		if (flagDottorato == null)
			return 'N';
		return flagDottorato;
	}
	public void setFlagDottorato(Character flagDottorato) {
		this.flagDottorato = flagDottorato;
	}
	public Long getIdReferenteInterno() {
		return idReferenteInterno;
	}	
	public void setIdReferenteInterno(Long idReferenteInterno) {
		this.idReferenteInterno = idReferenteInterno;
	}
	public void setIdReferenteInternoDaAccordoOperativo() {
		Long idReferenteInterno = null;
		if (getAccordoOperativo()!=null)
			if (getAccordoOperativo().getReferenteInterno()!=null)
				idReferenteInterno = getAccordoOperativo().getReferenteInterno().getId();
		setIdReferenteInterno(idReferenteInterno);
	}
	public Character getFlagNecessitaPermessoSoggiorno() {
		return flagNecessitaPermessoSoggiorno;
	}
	public void setFlagNecessitaPermessoSoggiorno(
			Character flagNecessitaPermessoSoggiorno) {
		this.flagNecessitaPermessoSoggiorno = flagNecessitaPermessoSoggiorno;
	}

	public boolean isVisualizzaFacInteresse() {
		PeriodoMobilita periodoMobilita = getPeriodoMobilita();
		return  !Common.dopoRiordinamentoInScluole(periodoMobilita != null ? periodoMobilita.getId(): null);
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
	
	public Character getFlagTipoNomina() {
		if (flagTipoNomina == null)
			return 'N';
		return flagTipoNomina;
	}
	
	public void setFlagTipoNomina(Character flagTipoNomina) {
		this.flagTipoNomina = flagTipoNomina;
	}
	
	public boolean isTipoNormale() {
		return Common.CH_N.equals(getFlagTipoNomina());
	}
	
	public boolean isTipoAggancioMatricola() {
		return Common.CH_M.equals(getFlagTipoNomina());
	}
	
	public boolean isTipoCreazioneIncoming() {
		return Common.CH_I.equals(getFlagTipoNomina());
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
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
	public UnitaMisuraDurata getUnitaMisuraDurata() {
		if (unitaMisuraDurata == null && getFlussoScambioEsecuzione() != null && getFlussoScambioEsecuzione().getUnitaMisuraDurata() != null)
			unitaMisuraDurata = getFlussoScambioEsecuzione().getUnitaMisuraDurata();
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
	
	public Integer getAnnoDiImmatricolazione() {
		return annoDiImmatricolazione;
	}
	public void setAnnoDiImmatricolazione(Integer annoDiImmatricolazione) {
		this.annoDiImmatricolazione = annoDiImmatricolazione;
	}
	public Integer getCicloDottorato() {
		return cicloDottorato;
	}
	public void setCicloDottorato(Integer cicloDottorato) {
		this.cicloDottorato = cicloDottorato;
	}
	public Integer getCicloDottoratoDiRendicontazione() {
		return cicloDottoratoDiRendicontazione;
	}
	public void setCicloDottoratoDiRendicontazione(Integer cicloDottoratoDiRendicontazione) {
		this.cicloDottoratoDiRendicontazione = cicloDottoratoDiRendicontazione;
	}
	public String getCodiceCorsoDiRendicontazione() {
		return codiceCorsoDiRendicontazione;
	}
	public void setCodiceCorsoDiRendicontazione(String codiceCorsoDiRendicontazione) {
		this.codiceCorsoDiRendicontazione = codiceCorsoDiRendicontazione;
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
	public NominaStaff getNominaStaff() {
		return nominaStaff;
	}
	public void setNominaStaff(NominaStaff nominaStaff) {
		this.nominaStaff = nominaStaff;
	}
	public Set<NominaAllegato> getAllegati() {
		return allegati;
	}
	public void setAllegati(Set<NominaAllegato> allegati) {
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
	
	public List<NominaAllegato> getAllegatiList() {
		return new ArrayList<NominaAllegato>(getAllegati());
	}

	public Character getFlagVisibileAStudenteAllegatoDaAggiungere() {
		return flagVisibileAStudenteAllegatoDaAggiungere;
	}

	public void setFlagVisibileAStudenteAllegatoDaAggiungere(
			Character flagVisibileAStudenteAllegatoDaAggiungere) {
		this.flagVisibileAStudenteAllegatoDaAggiungere = flagVisibileAStudenteAllegatoDaAggiungere;
	}
	
	public List<NominaAllegato> getAllegatiVisibiliAStudente() {
		List<NominaAllegato> ret = new ArrayList<NominaAllegato>();
		for (NominaAllegato a: allegati)
			if (a.isVisibileAStudente())
				ret.add(a);
		return ret;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public NominaApprovazione getNominaApprovazione() {
		return nominaApprovazione;
	}
	public void setNominaApprovazione(NominaApprovazione nominaApprovazione) {
		this.nominaApprovazione = nominaApprovazione;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ateneoProvenienza == null) ? 0 : ateneoProvenienza.hashCode());
		result = prime * result + ((campus == null) ? 0 : campus.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((flussoScambioEsecuzione == null) ? 0 : flussoScambioEsecuzione.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Nomina))
			return false;
		Nomina other = (Nomina) obj;
		if (ateneoProvenienza == null) {
			if (other.ateneoProvenienza != null)
				return false;
		} else if (!ateneoProvenienza.equals(other.ateneoProvenienza))
			return false;
		if (campus == null) {
			if (other.campus != null)
				return false;
		} else if (!campus.equals(other.campus))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (flussoScambioEsecuzione == null) {
			if (other.flussoScambioEsecuzione != null)
				return false;
		} else if (!flussoScambioEsecuzione.equals(other.flussoScambioEsecuzione))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}
	public Character getFlagNuovoPartner() {
		if (flagNuovoPartner == null) {
			if (getAteneoProvenienza() == null && (StringUtils.isNotBlank(getNomeNuovoPartner()) || getNazioneNuovoPartner() != null))
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
	
	public String getStatoMobilita() {
		if (isCancellato()) 
			return StatoNomina.CANCELLATO.getValore();
		if (isRinunciata())
			return StatoIncomingStaff.RINUNCIATO.getValore();
		if (getStudenteIncoming() != null && !StatoStudenteIncoming.INIZIALE.getValore().equals(getStudenteIncoming().getStato()))
			return getStudenteIncoming().getStatoStaff().getValore();
		if (isGestioneValidazioneAttiva() && !isValidato())
			return getStatoValidazione();
		if (!isValidazioneDaGestire() && getNominaApprovazione() != null && StringUtils.isNotBlank(getNominaApprovazione().getStatoApprovazione()))
			return getNominaApprovazione().getStatoApprovazione();
		/*
		if (isValidazioneDaGestire())
			return getStatoValidazione();
			*/
		return StatoIncomingStaff.APPROVATO.getValore();
	}
	
	public String getStato() {
		return stato;
	}
	
	public void setStato(String stato) {
		this.stato = stato;
	}

	public StatoNomina getStatoNomina() {
		return StatoNomina.getBy(getStato());
	}
	
	public String getStatoOld() {
		if (isRinunciata())
			return StatoIncomingStaff.RINUNCIATO.getValore();
		if (getStudenteIncoming() != null && !StatoStudenteIncoming.INIZIALE.getValore().equals(getStudenteIncoming().getStato()))
			return getStudenteIncoming().getStatoStaff().getValore();
		if (getNominaApprovazione() == null || StringUtils.isBlank(getNominaApprovazione().getStatoApprovazione()))
			return StatoIncomingStaff.APPROVATO.getValore();
		return getNominaApprovazione().getStatoApprovazione();
	}
	
	public boolean isCancellato() {
		boolean cancellato = false;
		if (getStato()!=null)
			if (StatoNomina.CANCELLATO.getValore().equals(getStato()))
				cancellato = true;
		return cancellato;
	}
	public String getStatoValidazione() {
		String stato = StatoValidazioneNomina.VALIDATO.getValore();
		if (getNominaValidazione()!=null)
			stato = getNominaValidazione().getStatoValidazione();
		return stato;
	}
	public boolean isValidazioneDaGestire() {
		return isGestioneValidazioneAttiva() && !isEsitoValidazioneInserito();
	}
	public boolean isGestioneValidazioneAttiva() {
		boolean daGestire = false;
		if (getFlagGestioneValidazione()!=null)
			daGestire = Common.CH_S.equals(getFlagGestioneValidazione());
		return daGestire;
	}
	
	public Character getFlagGestioneValidazione() {
		return flagGestioneValidazione;
	}
	
	public void setFlagGestioneValidazione(Character flagGestioneValidazione) {
		this.flagGestioneValidazione = flagGestioneValidazione;
	}
	
	public boolean isEsitoValidazioneInserito() {
		return isValidato() || isValidazioneRifiutata();
	}
	public boolean isValidazioneRifiutata() {
		return StatoValidazioneNomina.RIFIUTATO.getValore().equals(getStatoValidazione());
	}
	public boolean isValidato() {
		return StatoValidazioneNomina.VALIDATO.getValore().equals(getStatoValidazione());
	}

	public void setNominaValidazione(NominaValidazione nominaValidazione) {
		this.nominaValidazione = nominaValidazione;
	}
	public NominaValidazione getNominaValidazione() {
		return nominaValidazione;
	}
	
	public Character getFlagInseritoDaPartner() {
		return flagInseritoDaPartner;
	}
	public void setFlagInseritoDaPartner(Character flagInseritoDaPartner) {
		this.flagInseritoDaPartner = flagInseritoDaPartner;
	}
	
	public boolean isInseritoDaPartner() {
		return new Character('S').equals(flagInseritoDaPartner);
	}
	public String getColorStato() {
		return StatoIncomingStaff.get(getStatoMobilita()).getColor();
	}
	
	public boolean isBozza() {
		return StatoIncomingStaff.BOZZA.getValore().equals(getStatoMobilita());
	}
	
	public boolean isDaApprovare() {
		return StatoIncomingStaff.DA_APPROVARE.getValore().equals(getStatoMobilita());
	}
	
	public boolean isApprovato() {
		return StatoIncomingStaff.APPROVATO.getValore().equals(getStatoMobilita());
	}
	
	public boolean isRifiutato() {
		return getNominaApprovazione() != null && StatoIncomingStaff.RIFIUTATO.getValore().equals(getNominaApprovazione().getStatoApprovazione());
	}
	
	public boolean isRinunciato() {
		return StatoIncomingStaff.RINUNCIATO.getValore().equals(getStatoMobilita());
	}
	
	public boolean isAlmenoApprovato() {
		return !isBozza() && !isDaApprovare() && !isRifiutato() && !isRinunciato();
	}
	
	public void aggiornaDatiUltimaModifica() {
		aggiornaDatiUltimaModifica(null);
	}
	
	public void aggiornaDatiUltimaModifica(Persona utente) {
		if (getId() == null)
		{
			setDataInserimento(new Date());
			setUtenteInserimento(utente);
		}
		else
		{
			setDataUltimaModifica(new Date());
			setUtenteUltimaModifica(utente);
		}		
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
	public Character getInviaEmailAvvisoRiportaInBozza() {
		return inviaEmailAvvisoRiportaInBozza;
	}
	public void setInviaEmailAvvisoRiportaInBozza(Character inviaEmailAvvisoRiportaInBozza) {
		this.inviaEmailAvvisoRiportaInBozza = inviaEmailAvvisoRiportaInBozza;
	}
	public List<NominaStaffChecklistElement> getStaffChecklistElements() {
		return staffChecklistElements;
	}
	public void setStaffChecklistElements(List<NominaStaffChecklistElement> staffChecklistElements) {
		this.staffChecklistElements = staffChecklistElements;
	}
	
	public String getStaffChecklistElementsJson() {
		if (getStaffChecklistElements() == null || getStaffChecklistElements().isEmpty())
			return null;
		
		try {
			JSONArray els = new JSONArray(); 
			for (NominaStaffChecklistElement r: getStaffChecklistElements())
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
				els.put(obj);
			}
			
			return els.toString();
		}
		catch (JSONException je) {
			throw new RuntimeException(je);
		}
	}
	public String getApp() {
		if (StringUtils.isBlank(app))
			app = IncomingModificabileDaApp.ElencoApp.ALMARM.getNome();
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	
	public boolean isAppAlmaRM() {
		return IncomingModificabileDaApp.ElencoApp.ALMARM.getNome().equals(getApp());
	}
	
	public boolean isVisiting() {
		SottoProgramma sp = getSottoProgramma();
		if (sp != null)
			return sp.isVisiting();
		return false;
	}
	public StrutturaAmministrativa getStrutturaAmministrativa() {
		return strutturaAmministrativa;
	}
	public void setStrutturaAmministrativa(StrutturaAmministrativa strutturaAmministrativa) {
		this.strutturaAmministrativa = strutturaAmministrativa;
	}
	public Persona getAutoreCancellazione() {
		return autoreCancellazione;
	}
	public void setAutoreCancellazione(Persona autore) {
		this.autoreCancellazione = autore;
	}
	public Date getDataCancellazione() {
		return dataCancellazione;
	}
	public void setDataCancellazione(Date date) {
		this.dataCancellazione = date;
	}
	public String getNoteCancellazione() {
		return noteCancellazione;
	}
	public void setNoteCancellazione(String noteCancellazione) {
		this.noteCancellazione = noteCancellazione;
	}
	public boolean isGestioneApprovazioneAttiva() {
		return Common.CH_S.equals(getFlagGestioneApprovazione());
	}
	private Character getFlagGestioneApprovazione() {
		return flagGestioneApprovazione;
	}
	public void setFlagGestioneApprovazione(Character flagGestioneApprovazione) {
		this.flagGestioneApprovazione = flagGestioneApprovazione;
	}

    public boolean isStudente() {
        return getTipoMobilita() == null || getTipoMobilita().isStudenteODottorando();
    }

    public Date getDataPartenzaPrevistaCalcolata() {
        if (getDataArrivoPrevista() == null || getDurata() == null || getUnitaMisuraDurata() == null)
            return null;
        Float giorniDiPermanenza = getDurata() * getUnitaMisuraDurata().getGiorniCorrispondenti();
        return Common.addDaysToDate(getDataArrivoPrevista(), giorniDiPermanenza.intValue());
    }
}

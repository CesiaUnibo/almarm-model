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

import it.unibo.almarm.model.accordi.Coorte;
import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.model.flussiscambio.PeriodoMobilita;
import it.unibo.almarm.util.Common;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class Bando implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long idBandoPadre;
	private SottoProgramma sottoProgramma;
	private PeriodoMobilita periodoMobilita;
	private String testo;
	private String url;
	private Date dataInizio;
	private Date dataFine;
	private Integer maxRichieste;
	private Character flagSospeso;
	private Character flagDecimaliPunteggioOggettivoCandidature;
	private String rangeValoriPunteggioOggettivoCandidature;
	private Integer suddivisione;
	private String nomeProcOfferta;
	private String nomeProcPunteggioOggettivo;
	private Date dataChiusuraDocenti;
	private Date dataInizioValutazioneDisponibilita;
	private Date dataFineValutazioneDisponibilita;
	private Date dataInizioAccettazione1;
	private Date dataFineAccettazione1;
	private Date dataInizioAccettazione2;
	private Date dataFineAccettazione2;
	private Date dataInizioPubblicazione;
	private Date dataFinePubblicazione;
	private Long countDisponibilita;
	private Character flagPunteggioOggettivoUtilizzato;
	private Character flagCommissioneCalcolaVincitori;
	private Character flagModalitaValutazioneCommissione;
	private String nomeAllegatoOutgoing;

	private Set<RequisitoOfferta> requisitiOfferta = new HashSet<RequisitoOfferta>();
	private String testoCandidatureDefinitive;
	private String testoCandidatureAltre;
	private String testoCarriereFuture;
	private Date dataFineVisCandidatureInHPStudente;
	private Character flagSceltaPeriodoInAccettazione;
	private Date dataInizioPubblicazioneOpen;
	private Date dataFinePubblicazioneOpen;
	private String emailUfficio;
	private String nomeDocInfoLA;
	private Character flagDurataPeriodoLA;
	private Integer maxVersioniLA;
	private Character flagInserimentoCandidature;
	private Character flagBorsaTassata;
	private String nomeDocumentoContratto;
	private String nomeDocumentoContrattoSchedaFiscale;
	private Character flagModificaModalitaDiPagamento;
	
	private BandoConfigurazioneCandidature bandoConfigurazioneCandidature;
	private Integer periodoDefaultInAccettazione;
	private String nomeDocDichStudente;
	private String nomeDocDichStudenteSpa;
	private Character flagGestioneAiPoli;
	private String nomeDocumentoArrivo;
	private Character flagMostraGraduatoria;
	private String nomeDocInfoModLA;
	private String urlRichiestaContributoEconomico;
	private Coorte coorte;
	private Date dataScadenzaRichiestaRiconoscimento;
	private Date dataInizioGestionePeriodoScambioPerStudenti;
	private Date dataVerbaleGraduatoria;
	private String testoHomeOutgoing;
	private String testoContratto;
	private Character flagAvvisoUploadLaFirmatoCCDSAttivo;
	private String nomeDocAutocertificazioneOutgoing;
	private Character flagDurataPrevistaAttiva;
	private Date minDataInizioPlacement;
	private Date maxDataInizioPlacement;
	private Character flagGestioneAvanzataRate;
	/* 2017 Dicembre : il testo conferma candidatura viene portato nei bando-testi e x multilingua
	private String testoConfermaCandidatura;
	----------------------------------------- */
	private Character flagBandoSoloPerCarrieraCorrente;
	private Date dataAperturaDocenti;
	private Character flagAmmetteRidistribuzionePosti;
	private Character flagValutazioneSoggettivaDivisa;
	private String nomeManualeValutazioneGraduatorie;
	private Character flagMinicarrieraSuContrattoFirmato;
	private Character flagModificaPunteggioOggettivo;
	private Character flagDecimaliPunteggioSoggettivoCandidature;
	private String rangeValoriPunteggioSoggettivoCandidature;
	private Character flagNonIdoneiConPunteggioSoggettivoZero;
	private Character flagCalcolaVincitoriCompletata;
	private String testoRichiestaProlungamento;
	private String testoRelazioneFinale;
	private Character flagNoteValutazioneSingolaCandidatura;
	private String nomeProceduraCalcoloDurata;
	private Character flagPrecompilaDocumentoArrivo;
	private String suffissoDocumenti;
	private String testoRelazioneIndividuale;
	private String testoAvvisoStraordinario;
	private Integer ciclo;
	private String nomeDocumentoRichiestaCertificato;
	private Character flagAvvisoLaApprovatoAStudente;
	private Character flagAmmetteScambiVolontariSenzaContributo;
	private Character flagVisualizzaEsitiValidazioneAStudente;
	private Character flagAvvisoAccettazioneScambioAStudente;
	
	// flagNotePresentazioneCandidatura : Se vale 'S' lo studente puo' compilare le note nella candidatura, diversamente il campo non e' visible
	private Character flagNotePresentazioneCandidatura;
	// testoQuestionarioSO : visualizzato nel riquadro questionario della pagina passi dello studente outgoing (se i passi lo prevedono)	
	private String testoQuestionarioSO;
	
	private Character flagSezioneOlsInAccettazione;
	private Date dataPubblicazioneRendicontoBorsa;
	
	// Se la flag vale 'S' : nel caso l'offerta abbia 2 lingue fa scegliere in accettazione allo studente 
	// la lingua per cui e' stato validato se l'offerta ha una sola lingua questa viene scelta tacitamente 
	// sempre in accettazione.  
	private Character flagLinguaPrincipaleValidazioneInAccettazione;
	
	private Character flagProlungamentoZeroGrant;
	
	private Set<BandoGruppo> bandoGruppi = new HashSet<BandoGruppo>();
	
	private Long physDocFascicolo;
	private Character flagRiassegna;

	private Character flagUploadContrattoFirmato;
	private Character tipoGestioneContratto;
	private Date dataLimiteFineMobilita;
	private Date dataFineInfoCand;
	
	private Long idConfigMinicarriera;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIdBandoPadre(Long idBandoPadre) {
		this.idBandoPadre = idBandoPadre;
	}

	public Long getIdBandoPadre() {
		return idBandoPadre;
	}

	public SottoProgramma getSottoProgramma() {
		return sottoProgramma;
	}

	public void setSottoProgramma(SottoProgramma sottoProgramma) {
		this.sottoProgramma = sottoProgramma;
	}

	public PeriodoMobilita getPeriodoMobilita() {
		return periodoMobilita;
	}

	public void setPeriodoMobilita(PeriodoMobilita periodoMobilita) {
		this.periodoMobilita = periodoMobilita;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDataInizio() {
		return dataInizio;
	}
	
	public String getDataInizioLbl() {
		return Common.getDataOraFormattata(dataInizio);
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}
	
	public String getDataFineLbl() {
		return Common.getDataOraFormattata(dataFine);
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Integer getMaxRichieste() {
		return maxRichieste;
	}

	public void setMaxRichieste(Integer maxRichieste) {
		this.maxRichieste = maxRichieste;
	}

	public Character getFlagSospeso() {
		if (flagSospeso == null)
			return 'N';
		return flagSospeso;
	}

	public void setFlagSospeso(Character flagSospeso) {
		this.flagSospeso = flagSospeso;
	}

	public boolean isSospeso() {
		return (Common.CH_S.equals(flagSospeso));
	}
	
	public Set<RequisitoOfferta> getRequisitiOfferta() {
		return requisitiOfferta;
	}

	public void setRequisitiOfferta(Set<RequisitoOfferta> requisitiOfferta) {
		this.requisitiOfferta = requisitiOfferta;
	}

	/*
	public void setDisponibilita(Set<Disponibilita> disponibilita) {
		this.disponibilita = disponibilita;
	}

	public Set<Disponibilita> getDisponibilita() {
		return disponibilita;
	}
	*/
	
	public String getLabel() {
		return testo;
	}
	
	public boolean isScaduto() {
		return !Common.dateBetween(new Date(), dataInizio, dataFine);
	}

	public Character getFlagDecimaliPunteggioOggettivoCandidature() {
		if (flagDecimaliPunteggioOggettivoCandidature == null)
			return 'N';
		return flagDecimaliPunteggioOggettivoCandidature;
	}

	public void setFlagDecimaliPunteggioOggettivoCandidature(
			Character flagDecimaliPunteggioOggettivoCandidature) {
		this.flagDecimaliPunteggioOggettivoCandidature = flagDecimaliPunteggioOggettivoCandidature;
	}

	public String getRangeValoriPunteggioOggettivoCandidature() {
		return rangeValoriPunteggioOggettivoCandidature;
	}

	public void setRangeValoriPunteggioOggettivoCandidature(
			String rangeValoriPunteggioOggettivoCandidature) {
		this.rangeValoriPunteggioOggettivoCandidature = rangeValoriPunteggioOggettivoCandidature;
	}
	
	public boolean getAccettareDecimaliPunteggioOggettivoCandidature() {
		return Common.CH_S.equals(flagDecimaliPunteggioOggettivoCandidature);
	}
	
	public Float getMinValorePunteggioOggettivoCandidature() {
		if (StringUtils.isBlank(rangeValoriPunteggioOggettivoCandidature))
			return null;
		String[] ss = rangeValoriPunteggioOggettivoCandidature.split("-");
		if (ss.length == 2)
			return Float.valueOf(ss[0]);
		if (rangeValoriPunteggioOggettivoCandidature.endsWith("-"))
			return Float.valueOf(ss[0]);
		return null;
	}
	
	public Float getMaxValorePunteggioOggettivoCandidature() {
		if (StringUtils.isBlank(rangeValoriPunteggioOggettivoCandidature))
			return null;
		String[] ss = rangeValoriPunteggioOggettivoCandidature.split("-");
		if (ss.length == 2)
			return Float.valueOf(ss[1]);
		if (rangeValoriPunteggioOggettivoCandidature.startsWith("-"))
			return Float.valueOf(ss[0]);
		return null;
	}
	
	public String getColor() {
		return getStato().getColor();
	}

	public String getColorDesc() {
		return getStato().getValore();
	}
	
	public StatoBando getStato() {
		if (flagSospeso != null && "S".equals(flagSospeso.toString()))
			return StatoBando.SOSPESO;
		Date when = new Date();
		if (dataFine != null && dataFine.before(when))
			return StatoBando.CHIUSO;
		if (dataInizio != null && dataInizio.before(when))
			return StatoBando.ATTIVO;
		return StatoBando.NUOVO;
	}

	public void setSuddivisione(Integer suddivisione) {
		this.suddivisione = suddivisione;
	}

	public Integer getSuddivisione() {
		if (suddivisione == null)
			return 0;
		return suddivisione;
	}

	public void setNomeProcOfferta(String nomeProcOfferta) {
		this.nomeProcOfferta = nomeProcOfferta;
	}

	public String getNomeProcOfferta() {
		return nomeProcOfferta;
	}

	public void setNomeProcPunteggioOggettivo(String nomeProcPunteggioOggettivo) {
		this.nomeProcPunteggioOggettivo = nomeProcPunteggioOggettivo;
	}

	public String getNomeProcPunteggioOggettivo() {
		return nomeProcPunteggioOggettivo;
	}

	public void setDataChiusuraDocenti(Date dataChiusuraDocenti) {
		this.dataChiusuraDocenti = dataChiusuraDocenti;
	}

	public Date getDataChiusuraDocenti() {
		return dataChiusuraDocenti;
	}

	public Date getDataInizioValutazioneDisponibilita() {
		return dataInizioValutazioneDisponibilita;
	}

	public void setDataInizioValutazioneDisponibilita(Date dataInizioValutazioneDisponibilita) {
		this.dataInizioValutazioneDisponibilita = dataInizioValutazioneDisponibilita;
	}

	public Date getDataFineValutazioneDisponibilita() {
		return dataFineValutazioneDisponibilita;
	}

	public void setDataFineValutazioneDisponibilita(Date dataFineValutazioneDisponibilita) {
		this.dataFineValutazioneDisponibilita = dataFineValutazioneDisponibilita;
	}

	public Date getDataInizioAccettazione1() {
		return dataInizioAccettazione1;
	}

	public void setDataInizioAccettazione1(Date dataInizioAccettazione1) {
		this.dataInizioAccettazione1 = dataInizioAccettazione1;
	}

	public Date getDataFineAccettazione1() {
		return dataFineAccettazione1;
	}

	public void setDataFineAccettazione1(Date dataFineAccettazione1) {
		this.dataFineAccettazione1 = dataFineAccettazione1;
	}

	public Date getDataInizioAccettazione2() {
		return dataInizioAccettazione2;
	}

	public void setDataInizioAccettazione2(Date dataInizioAccettazione2) {
		this.dataInizioAccettazione2 = dataInizioAccettazione2;
	}

	public Date getDataFineAccettazione2() {
		return dataFineAccettazione2;
	}

	public void setDataFineAccettazione2(Date dataFineAccettazione2) {
		this.dataFineAccettazione2 = dataFineAccettazione2;
	}
	
	public Boolean isCancellabile() {
		//return requisitiOfferta.isEmpty() && disponibilita.isEmpty();
		return requisitiOfferta.isEmpty() && (countDisponibilita == null || countDisponibilita == 0);
	}

	public Date getDataInizioPubblicazione() {
		return dataInizioPubblicazione;
	}

	public void setDataInizioPubblicazione(Date dataInizioPubblicazione) {
		this.dataInizioPubblicazione = dataInizioPubblicazione;
	}

	public Date getDataFinePubblicazione() {
		return dataFinePubblicazione;
	}

	public void setDataFinePubblicazione(Date dataFinePubblicazione) {
		this.dataFinePubblicazione = dataFinePubblicazione;
	}
	
	/*	 */
	
	public String getColorValutazioneDisponibilita() {
		return getStatoValutazioneDisponibilita().getColor();
	}

	public String getColorDescValutazioneDisponibilita() {
		return getStatoValutazioneDisponibilita().getValore();
	}
	
	private StatoBando getStatoValutazioneDisponibilita() {
		if (flagSospeso != null && "S".equals(flagSospeso.toString()))
			return StatoBando.SOSPESO;
		Date when = new Date();
		if (dataFineValutazioneDisponibilita != null && dataFineValutazioneDisponibilita.before(when))
			return StatoBando.CHIUSO;
		if (dataInizioValutazioneDisponibilita != null && dataInizioValutazioneDisponibilita.before(when))
			return StatoBando.ATTIVO;
		return StatoBando.NUOVO;
	}
	
	public String getColorAccettazione1() {
		return getStatoAccettazione1().getColor();
	}

	public String getColorDescAccettazione1() {
		return getStatoAccettazione1().getValore();
	}
	
	private StatoBando getStatoAccettazione1() {
		if (flagSospeso != null && "S".equals(flagSospeso.toString()))
			return StatoBando.SOSPESO;
		Date when = new Date();
		if (dataFineAccettazione1 != null && dataFineAccettazione1.before(when))
			return StatoBando.CHIUSO;
		if (dataInizioAccettazione1 != null && dataInizioAccettazione1.before(when))
			return StatoBando.ATTIVO;
		return StatoBando.NUOVO;
	}
	
	public String getColorAccettazione2() {
		return getStatoAccettazione2().getColor();
	}

	public String getColorDescAccettazione2() {
		return getStatoAccettazione2().getValore();
	}
	
	private StatoBando getStatoAccettazione2() {
		if (flagSospeso != null && "S".equals(flagSospeso.toString()))
			return StatoBando.SOSPESO;
		Date when = new Date();
		if (dataFineAccettazione2 != null && dataFineAccettazione2.before(when))
			return StatoBando.CHIUSO;
		if (dataInizioAccettazione2 != null && dataInizioAccettazione2.before(when))
			return StatoBando.ATTIVO;
		return StatoBando.NUOVO;
	}
	
	public String getColorChiusuraDocenti() {
		return getStatoChiusuraDocenti().getColor();
	}

	public String getColorDescChiusuraDocenti() {
		return getStatoChiusuraDocenti().getValore();
	}
	
	private StatoBando getStatoChiusuraDocenti() {
		if (flagSospeso != null && "S".equals(flagSospeso.toString()))
			return StatoBando.SOSPESO;
		Date when = new Date();
		if (dataChiusuraDocenti != null && dataChiusuraDocenti.before(when))
			return StatoBando.CHIUSO;
		if (dataChiusuraDocenti != null && dataChiusuraDocenti.after(when))
			return StatoBando.ATTIVO;
		return StatoBando.NUOVO;
	}
	
	public String getColorPubblicazione() {
		return getStatoPubblicazione().getColor();
	}

	public String getColorDescPubblicazione() {
		return getStatoPubblicazione().getValore();
	}
	
	private StatoBando getStatoPubblicazione() {
		if (flagSospeso != null && "S".equals(flagSospeso.toString()))
			return StatoBando.SOSPESO;
		Date when = new Date();
		if (dataFinePubblicazione != null && dataFinePubblicazione.before(when))
			return StatoBando.CHIUSO;
		if (dataInizioPubblicazione != null && dataInizioPubblicazione.before(when))
			return StatoBando.ATTIVO;
		return StatoBando.NUOVO;
	}

	public Date getDataInizioBind() {
		return dataInizio;
	}
	
	public void setDataInizioBind(Date dataInizio) {
		this.dataInizio = getDataCompleta(this.dataInizio, dataInizio);
	}
	
	public Integer getOreInizio() {
		return getOre(dataInizio);
	}
	
	public void setOreInizio(Integer oreInzio) {
		dataInizio = getDataCompleta(dataInizio, oreInzio);
	}
	
	public String getMinutiInizio() {
		return getMinuti(dataInizio);
	}
	
	public void setMinutiInizio(String minutiInizio) {
		dataInizio = getDataCompleta(dataInizio, minutiInizio);
	}
	
	public Date getDataFineBind() {
		return dataFine;
	}
	
	public void setDataFineBind(Date dataFine) {
		this.dataFine = getDataCompleta(this.dataFine, dataFine);
	}

	public Integer getOreFine() {
		return getOre(dataFine);
	}
	
	public void setOreFine(Integer oreFine) {
		dataFine = getDataCompleta(dataFine, oreFine);
	}
	
	public String getMinutiFine() {
		return getMinuti(dataFine);
	}
	
	public void setMinutiFine(String minutiFine) {
		dataFine = getDataCompleta(dataFine, minutiFine);
	}
	
	public Date getDataChiusuraDocentiBind() {
		return dataChiusuraDocenti;
	}
	
	public void setDataChiusuraDocentiBind(Date dataChiusuraDocenti) {
		this.dataChiusuraDocenti = getDataCompleta(this.dataChiusuraDocenti, dataChiusuraDocenti);
	}
	
	public Integer getOreChiusuraDocenti() {
		return getOre(dataChiusuraDocenti);
	}
	
	public void setOreChiusuraDocenti(Integer oreChiusuraDocenti) {
		dataChiusuraDocenti = getDataCompleta(dataChiusuraDocenti, oreChiusuraDocenti);
	}

	public String getMinutiChiusuraDocenti() {
		return getMinuti(dataChiusuraDocenti);
	}
	
	public void setMinutiChiusuraDocenti(String minutiChiusuraDocenti) {
		dataChiusuraDocenti = getDataCompleta(dataChiusuraDocenti, minutiChiusuraDocenti);
	}
	
	public Date getDataInizioValutazioneDisponibilitaBind() {
		return dataInizioValutazioneDisponibilita;
	}
	
	public void setDataInizioValutazioneDisponibilitaBind(Date dataInizioValutazioneDisponibilita) {
		this.dataInizioValutazioneDisponibilita = getDataCompleta(this.dataInizioValutazioneDisponibilita, dataInizioValutazioneDisponibilita);
	}
	
	public Integer getOreInizioValutazioneDisponibilita() {
		return getOre(dataInizioValutazioneDisponibilita);
	}
	
	public void setOreInizioValutazioneDisponibilita(Integer oreInizioValutazioneDisponibilita) {
		dataInizioValutazioneDisponibilita = getDataCompleta(dataInizioValutazioneDisponibilita, oreInizioValutazioneDisponibilita);
	}
	
	public String getMinutiInizioValutazioneDisponibilita() {
		return getMinuti(dataInizioValutazioneDisponibilita);
	}
	
	public void setMinutiInizioValutazioneDisponibilita(String minutiInizioValutazioneDisponibilita) {
		dataInizioValutazioneDisponibilita = getDataCompleta(dataInizioValutazioneDisponibilita, minutiInizioValutazioneDisponibilita);
	}
	
	public Date getDataFineValutazioneDisponibilitaBind() {
		return dataFineValutazioneDisponibilita;
	}
	
	public void setDataFineValutazioneDisponibilitaBind(Date dataFineValutazioneDisponibilita) {
		this.dataFineValutazioneDisponibilita = getDataCompleta(this.dataFineValutazioneDisponibilita, dataFineValutazioneDisponibilita);
	}
	
	public Integer getOreFineValutazioneDisponibilita() {
		return getOre(dataFineValutazioneDisponibilita);
	}
	
	public void setOreFineValutazioneDisponibilita(Integer oreFineValutazioneDisponibilita) {
		dataFineValutazioneDisponibilita = getDataCompleta(dataFineValutazioneDisponibilita, oreFineValutazioneDisponibilita);
	}
	
	public String getMinutiFineValutazioneDisponibilita() {
		return getMinuti(dataFineValutazioneDisponibilita);
	}
	
	public void setMinutiFineValutazioneDisponibilita(String minutiFineValutazioneDisponibilita) {
		dataFineValutazioneDisponibilita = getDataCompleta(dataFineValutazioneDisponibilita, minutiFineValutazioneDisponibilita);
	}
	
	public Date getDataInizioAccettazione1Bind() {
		return dataInizioAccettazione1;
	}
	
	public void setDataInizioAccettazione1Bind(Date dataInizioAccettazione1) {
		this.dataInizioAccettazione1 = getDataCompleta(this.dataInizioAccettazione1, dataInizioAccettazione1);
	}
	
	public Integer getOreInizioAccettazione1() {
		return getOre(dataInizioAccettazione1);
	}
	
	public void setOreInizioAccettazione1(Integer oreInizioAccettazione1) {
		dataInizioAccettazione1 = getDataCompleta(dataInizioAccettazione1, oreInizioAccettazione1);
	}
	
	public String getMinutiInizioAccettazione1() {
		return getMinuti(dataInizioAccettazione1);
	}
	
	public void setMinutiInizioAccettazione1(String minutiInizioAccettazione1) {
		dataInizioAccettazione1 = getDataCompleta(dataInizioAccettazione1, minutiInizioAccettazione1);
	}
	
	public Date getDataFineAccettazione1Bind() {
		return dataFineAccettazione1;
	}
	
	public void setDataFineAccettazione1Bind(Date dataFineAccettazione1) {
		this.dataFineAccettazione1 = getDataCompleta(this.dataFineAccettazione1, dataFineAccettazione1);
	}
	
	public Integer getOreFineAccettazione1() {
		return getOre(dataFineAccettazione1);
	}
	
	public void setOreFineAccettazione1(Integer oreFineAccettazione1) {
		dataFineAccettazione1 = getDataCompleta(dataFineAccettazione1, oreFineAccettazione1);
	}
	
	public String getMinutiFineAccettazione1() {
		return getMinuti(dataFineAccettazione1);
	}
	
	public void setMinutiFineAccettazione1(String minutiFineAccettazione1) {
		dataFineAccettazione1 = getDataCompleta(dataFineAccettazione1, minutiFineAccettazione1);
	}
	
	public Date getDataInizioAccettazione2Bind() {
		return dataInizioAccettazione2;
	}
	
	public void setDataInizioAccettazione2Bind(Date dataInizioAccettazione2) {
		this.dataInizioAccettazione2 = getDataCompleta(this.dataInizioAccettazione2, dataInizioAccettazione2);
	}

	public Integer getOreInizioAccettazione2() {
		return getOre(dataInizioAccettazione2);
	}
	
	public void setOreInizioAccettazione2(Integer oreInizioAccettazione2) {
		dataInizioAccettazione2 = getDataCompleta(dataInizioAccettazione2, oreInizioAccettazione2);
	}
	
	public String getMinutiInizioAccettazione2() {
		return getMinuti(dataInizioAccettazione2);
	}
	
	public void setMinutiInizioAccettazione2(String minutiInizioAccettazione2) {
		dataInizioAccettazione2 = getDataCompleta(dataInizioAccettazione2, minutiInizioAccettazione2);
	}
	
	public Date getDataFineAccettazione2Bind() {
		return dataFineAccettazione2;
	}
	
	public void setDataFineAccettazione2Bind(Date dataFineAccettazione2) {
		this.dataFineAccettazione2 = getDataCompleta(this.dataFineAccettazione2, dataFineAccettazione2);
	}

	public Integer getOreFineAccettazione2() {
		return getOre(dataFineAccettazione2);
	}
	
	public void setOreFineAccettazione2(Integer oreFineAccettazione2) {
		dataFineAccettazione2 = getDataCompleta(dataFineAccettazione2, oreFineAccettazione2);
	}
	
	public String getMinutiFineAccettazione2() {
		return getMinuti(dataFineAccettazione2);
	}
	
	public void setMinutiFineAccettazione2(String minutiFineAccettazione2) {
		dataFineAccettazione2 = getDataCompleta(dataFineAccettazione2, minutiFineAccettazione2);
	}
	
	public Date getDataInizioPubblicazioneBind() {
		return dataInizioPubblicazione;
	}
	
	public void setDataInizioPubblicazioneBind(Date dataInizioPubblicazione) {
		this.dataInizioPubblicazione = getDataCompleta(this.dataInizioPubblicazione, dataInizioPubblicazione);
	}
	
	public Integer getOreInizioPubblicazione() {
		return getOre(dataInizioPubblicazione);
	}
	
	public void setOreInizioPubblicazione(Integer oreInizioPubblicazione) {
		dataInizioPubblicazione = getDataCompleta(dataInizioPubblicazione, oreInizioPubblicazione);
	}
	
	public String getMinutiInizioPubblicazione() {
		return getMinuti(dataInizioPubblicazione);
	}
	
	public void setMinutiInizioPubblicazione(String minutiInizioPubblicazione) {
		dataInizioPubblicazione = getDataCompleta(dataInizioPubblicazione, minutiInizioPubblicazione);
	}
	
	public Date getDataFinePubblicazioneBind() {
		return dataFinePubblicazione;
	}
	
	public void setDataFinePubblicazioneBind(Date dataFinePubblicazione) {
		this.dataFinePubblicazione = getDataCompleta(this.dataFinePubblicazione, dataFinePubblicazione);
	}
	
	public Integer getOreFinePubblicazione() {
		return getOre(dataFinePubblicazione);
	}
	
	public void setOreFinePubblicazione(Integer oreFinePubblicazione) {
		dataFinePubblicazione = getDataCompleta(dataFinePubblicazione, oreFinePubblicazione);
	}
	
	public String getMinutiFinePubblicazione() {
		return getMinuti(dataFinePubblicazione);
	}
	
	public void setMinutiFinePubblicazione(String minutiFinePubblicazione) {
		dataFinePubblicazione = getDataCompleta(dataFinePubblicazione, minutiFinePubblicazione);
	}

	private static Integer getOre(Date data) {
		if (data == null)
			return null;
		return getCalendar(data).get(Calendar.HOUR_OF_DAY);
	}
	
	private static String getMinuti(Date data) {
		if (data == null)
			return null;
		Integer minuti = getCalendar(data).get(Calendar.MINUTE);
		if (minuti < 10)
			return "0" + minuti.toString();
		return minuti.toString();
	}
	
	private static Date getDataCompleta(Date data, Integer ore) {
		return getDataCompleta(data, Calendar.HOUR_OF_DAY, ore);
	}
	
	private static Date getDataCompleta(Date data, String minuti) {
		Integer m = null;
		if (!StringUtils.isEmpty(minuti))
			m = Integer.parseInt(minuti);
		return getDataCompleta(data, Calendar.MINUTE, m);
	}

	
	private static Date getDataCompleta(Date data, int field, Integer value) {
		if (value == null) {
			return data;
		}
		Calendar calendar = null;
		if (data == null)
			calendar = new GregorianCalendar(2001, 0, 1);
		else
			calendar = getCalendar(data);
		calendar.set(field, value);
		return calendar.getTime();
	}
	
	private static Date getDataCompleta(Date data1, Date data2) {
		if (data1 == null) {
			return data2;
		}
		if (data2 == null) {
			return null;
		}
		Calendar origine = getCalendar(data1);
		Calendar calendar = getCalendar(data2);
		calendar.set(Calendar.HOUR_OF_DAY, origine.get(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, origine.get(Calendar.MINUTE));
		return calendar.getTime();
	}
	
	private static Calendar getCalendar(Date data) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(data);
		return calendar;
	}
	
	public boolean isVisualizzazioneAttiva() {
		if (Common.CH_S.equals(flagSospeso))
			return false;
		return Common.dateBetween(new Date(), dataInizioPubblicazione, dataFinePubblicazione);
	}
	
	/*	 */

	public void setCountDisponibilita(Long countDisponibilita) {
		this.countDisponibilita = countDisponibilita;
	}

	public Long getCountDisponibilita() {
		return countDisponibilita;
	}

	public String getTestoCandidatureDefinitive() {
		return testoCandidatureDefinitive;
	}

	public void setTestoCandidatureDefinitive(String testoCandidatureDefinitive) {
		this.testoCandidatureDefinitive = testoCandidatureDefinitive;
	}

	public String getTestoCandidatureAltre() {
		return testoCandidatureAltre;
	}

	public void setTestoCandidatureAltre(String testoCandidatureAltre) {
		this.testoCandidatureAltre = testoCandidatureAltre;
	}

	public String getTestoCarriereFuture() {
		return testoCarriereFuture;
	}

	public void setTestoCarriereFuture(String testoCarriereFuture) {
		this.testoCarriereFuture = testoCarriereFuture;
	}
	
	public boolean isPunteggioOggettivoUtilizzato() {
		return Common.CH_S.equals(flagPunteggioOggettivoUtilizzato);
	}

	public Character getFlagPunteggioOggettivoUtilizzato() {
		return flagPunteggioOggettivoUtilizzato;
	}

	public void setFlagPunteggioOggettivoUtilizzato(
			Character flagPunteggioOggettivoUtilizzato) {
		this.flagPunteggioOggettivoUtilizzato = flagPunteggioOggettivoUtilizzato;
	}
	
	public boolean isCommissioneCalcolaVincitori() {
		return Common.CH_S.equals(flagCommissioneCalcolaVincitori);
	}

	public Character getFlagCommissioneCalcolaVincitori() {
		return flagCommissioneCalcolaVincitori;
	}

	public void setFlagCommissioneCalcolaVincitori(
			Character flagCommissioneCalcolaVincitori) {
		this.flagCommissioneCalcolaVincitori = flagCommissioneCalcolaVincitori;
	}
	
	public boolean isModalitaValutazioneCommissioneAttiva() {
		return Common.CH_S.equals(flagModalitaValutazioneCommissione);
	}

	public Character getFlagModalitaValutazioneCommissione() {
		return flagModalitaValutazioneCommissione;
	}

	public void setFlagModalitaValutazioneCommissione(
			Character flagModalitaValutazioneCommissione) {
		this.flagModalitaValutazioneCommissione = flagModalitaValutazioneCommissione;
	}

	public Date getDataFineVisCandidatureInHPStudente() {
		return dataFineVisCandidatureInHPStudente;
	}

	public void setDataFineVisCandidatureInHPStudente(
			Date dataFineVisCandidatureInHPStudente) {
		this.dataFineVisCandidatureInHPStudente = dataFineVisCandidatureInHPStudente;
	}

	public Character getFlagSceltaPeriodoInAccettazione() {
		if (flagSceltaPeriodoInAccettazione == null)
			return 'N';
		return flagSceltaPeriodoInAccettazione;
	}

	public void setFlagSceltaPeriodoInAccettazione(
			Character flagSceltaPeriodoInAccettazione) {
		this.flagSceltaPeriodoInAccettazione = flagSceltaPeriodoInAccettazione;
	}
	
	public boolean isAttivaSceltaPeriodoInAccettazione() {
		return Common.CH_S.equals(flagSceltaPeriodoInAccettazione);
	}

	public Date getDataInizioPubblicazioneOpen() {
		return dataInizioPubblicazioneOpen;
	}

	public void setDataInizioPubblicazioneOpen(Date dataInizioPubblicazioneOpen) {
		this.dataInizioPubblicazioneOpen = dataInizioPubblicazioneOpen;
	}

	public Date getDataFinePubblicazioneOpen() {
		return dataFinePubblicazioneOpen;
	}

	public void setDataFinePubblicazioneOpen(Date dataFinePubblicazioneOpen) {
		this.dataFinePubblicazioneOpen = dataFinePubblicazioneOpen;
	}

	public boolean isGestioneDecentrata() {
		// prima o poi andra' messo un flag o a livello di sotto programma o a livello di bando
		if (isTesiAllEstero() || isSemestriABuenosAires())
			return true;
		return false;
	}

    public static class  BandoComparatorDataInizio implements Comparator<Bando> {
		public int compare(Bando o1, Bando o2) {
			
			if ((o1 == null && o2 == null)
				||( o1 != null && o2 != null 
				    && ((Common.CH_S.equals(o1.getFlagSospeso()) && Common.CH_S.equals(o2.getFlagSospeso()))
				        || (o1.getDataInizio() == null && o2.getDataInizio() == null))
				   )
				)
				return 0;
			if (o1 == null)
				return 1;
			if (o2 == null)
				return -1;
			if (Common.CH_S.equals(o1.getFlagSospeso()))
				return 1;
			if (Common.CH_S.equals(o2.getFlagSospeso()))
				return -1;
			if (o1.getDataInizio() == null)
				return 1;
			if (o2.getDataInizio() == null)
				return -1;
			
			return -1 * o1.getDataInizio().compareTo(o2.getDataInizio());
		}
	}

	public String getNomeAllegatoOutgoing() {
		return nomeAllegatoOutgoing;
	}

	public void setNomeAllegatoOutgoing(String nomeAllegatoOutgoing) {
		this.nomeAllegatoOutgoing = nomeAllegatoOutgoing;
	}

	public String getEmailUfficio() {
		return emailUfficio;
	}

	public void setEmailUfficio(String emailUfficio) {
		this.emailUfficio = emailUfficio;
	}

	public String getNomeDocInfoLA() {
		return nomeDocInfoLA;
	}

	public void setNomeDocInfoLA(String nomeDocInfoLA) {
		this.nomeDocInfoLA = nomeDocInfoLA;
	}
	
	public boolean isVisibileDurataLA() {
		return Common.CH_D.equals(getFlagDurataPeriodoLA());
	}
	
	public boolean isVisibilePeriodoLA() {
		return Common.CH_P.equals(getFlagDurataPeriodoLA());
	}

	public Character getFlagDurataPeriodoLA() {
		if (flagDurataPeriodoLA == null)
			return 'D';
		return flagDurataPeriodoLA;
	}

	public void setFlagDurataPeriodoLA(Character flagDurataPeriodoLA) {
		this.flagDurataPeriodoLA = flagDurataPeriodoLA;
	}

	public Integer getMaxVersioniLA() {
		if (maxVersioniLA == null)
			return 3;
		return maxVersioniLA;
	}

	public void setMaxVersioniLA(Integer maxVersioniLA) {
		this.maxVersioniLA = maxVersioniLA;
	}
	
	public void setFlagInserimentoCandidature(Character flagInserimentoCandidature) {
		this.flagInserimentoCandidature = flagInserimentoCandidature;
	}

	public Character getFlagInserimentoCandidature() {
		return flagInserimentoCandidature;
	}
	
	public boolean isInserimentoCandidatureManuali() {
		return Common.CH_S.equals(getFlagInserimentoCandidature());
	}

	public BandoConfigurazioneCandidature getBandoConfigurazioneCandidature() {
		return bandoConfigurazioneCandidature;
	}

	public void setBandoConfigurazioneCandidature(
			BandoConfigurazioneCandidature bandoConfigurazioneCandidature) {
		this.bandoConfigurazioneCandidature = bandoConfigurazioneCandidature;
	}

	public Character getFlagBorsaTassata() {
		if (flagBorsaTassata == null)
			return 'N';
		return flagBorsaTassata;
	}

	public void setFlagBorsaTassata(Character flagBorsaTassata) {
		this.flagBorsaTassata = flagBorsaTassata;
	}

	public boolean isBorsaTassata() {
		return Common.CH_S.equals(flagBorsaTassata);
	}

	public String getNomeDocumentoContratto() {
		return nomeDocumentoContratto;
	}

	public void setNomeDocumentoContratto(String nomeDocumentoContratto) {
		this.nomeDocumentoContratto = nomeDocumentoContratto;
	}

	public Integer getPeriodoDefaultInAccettazione() {
		return periodoDefaultInAccettazione;
	}

	public void setPeriodoDefaultInAccettazione(Integer periodoDefaultInAccettazione) {
		this.periodoDefaultInAccettazione = periodoDefaultInAccettazione;
	}

	public String getNomeDocumentoContrattoSchedaFiscale() {
		return nomeDocumentoContrattoSchedaFiscale;
	}

	public void setNomeDocumentoContrattoSchedaFiscale(
			String nomeDocumentoContrattoSchedaFiscale) {
		this.nomeDocumentoContrattoSchedaFiscale = nomeDocumentoContrattoSchedaFiscale;
	}

	public Character getFlagModificaModalitaDiPagamento() {
		if (flagModificaModalitaDiPagamento == null)
			return 'S';
		return flagModificaModalitaDiPagamento;
	}

	public void setFlagModificaModalitaDiPagamento(
			Character flagModificaModalitaDiPagamento) {
		this.flagModificaModalitaDiPagamento = flagModificaModalitaDiPagamento;
	}
	
	public boolean isModificaModalitaDiPagamentoAmmessa() {
		return Common.CH_S.equals(getFlagModificaModalitaDiPagamento());
	}

	public String getNomeDocDichStudente() {
		return nomeDocDichStudente;
	}

	public void setNomeDocDichStudente(String nomeDocDichStudente) {
		this.nomeDocDichStudente = nomeDocDichStudente;
	}

	public String getNomeDocDichStudenteSpa() {
		return nomeDocDichStudenteSpa;
	}

	public void setNomeDocDichStudenteSpa(String nomeDocDichStudenteSpa) {
		this.nomeDocDichStudenteSpa = nomeDocDichStudenteSpa;
	}

	public Character getFlagGestioneAiPoli() {
		if (flagGestioneAiPoli == null)
			return 'S';
		return flagGestioneAiPoli;
	}

	public void setFlagGestioneAiPoli(Character flagGestioneAiPoli) {
		this.flagGestioneAiPoli = flagGestioneAiPoli;
	}
	
	public boolean isGestioneAiPoli() {
		return Common.CH_S.equals(getFlagGestioneAiPoli());
	}

	public String getNomeDocumentoArrivo() {
		return nomeDocumentoArrivo;
	}

	public void setNomeDocumentoArrivo(String nomeDocumentoArrivo) {
		this.nomeDocumentoArrivo = nomeDocumentoArrivo;
	}

	public Character getFlagMostraGraduatoria() {
		if (flagMostraGraduatoria == null)
			return 'S';
		return flagMostraGraduatoria;
	}

	public void setFlagMostraGraduatoria(Character flagMostraGraduatoria) {
		this.flagMostraGraduatoria = flagMostraGraduatoria;
	}
	
	public boolean isMostraGraduatoria() {
		return Common.CH_S.equals(getFlagMostraGraduatoria());
	}

	public String getNomeDocInfoModLA() {
		return nomeDocInfoModLA;
	}

	public void setNomeDocInfoModLA(String nomeDocInfoModLA) {
		this.nomeDocInfoModLA = nomeDocInfoModLA;
	}

	public String getUrlRichiestaContributoEconomico() {
		return urlRichiestaContributoEconomico;
	}

	public void setUrlRichiestaContributoEconomico(
			String urlRichiestaContributoEconomico) {
		this.urlRichiestaContributoEconomico = urlRichiestaContributoEconomico;
	}

	public Coorte getCoorte() {
		return coorte;
	}

	public void setCoorte(Coorte coorte) {
		this.coorte = coorte;
	}
	
	public boolean isBandoPubblicato() {
		Date when = new Date();
		if  (isSospeso()) 
			return false;
	    if (dataFinePubblicazione != null && dataFinePubblicazione.before(when))
	    	return false;
	    if (dataInizioPubblicazione != null && dataInizioPubblicazione.after(when))
	    	return false;
	    return true;
	}
	
	public boolean isBandoPubblicatoOpen()
	{
		Date when = new Date();
		if  (isSospeso()) 
			return false;
	    if (dataFinePubblicazioneOpen != null && dataFinePubblicazioneOpen.before(when))
	    	return false;
	    if (dataInizioPubblicazioneOpen != null && dataInizioPubblicazioneOpen.after(when))
	    	return false;
	    return true;
	}

	public Date getDataScadenzaRichiestaRiconoscimento() {
		return dataScadenzaRichiestaRiconoscimento;
	}

	public void setDataScadenzaRichiestaRiconoscimento(
			Date dataScadenzaRichiestaRiconoscimento) {
		this.dataScadenzaRichiestaRiconoscimento = dataScadenzaRichiestaRiconoscimento;
	}

	public Date getDataInizioGestionePeriodoScambioPerStudenti() {
		return dataInizioGestionePeriodoScambioPerStudenti;
	}

	public void setDataInizioGestionePeriodoScambioPerStudenti(
			Date dataInizioGestionePeriodoScambioPerStudenti) {
		this.dataInizioGestionePeriodoScambioPerStudenti = dataInizioGestionePeriodoScambioPerStudenti;
	}
	
	public boolean isGestionePeriodoScambioPerStudentiAttiva() {
		if (getDataInizioGestionePeriodoScambioPerStudenti() == null)
			return false;
		return (new Date()).after(getDataInizioGestionePeriodoScambioPerStudenti());
	}
	
	public boolean isAlmenoIniziato() {
		return (new Date()).after(dataInizio);
	}

	public Date getDataVerbaleGraduatoria() {
		return dataVerbaleGraduatoria;
	}

	public void setDataVerbaleGraduatoria(Date dataVerbaleGraduatoria) {
		this.dataVerbaleGraduatoria = dataVerbaleGraduatoria;
	}

	public String getTestoHomeOutgoing() {
		return testoHomeOutgoing;
	}

	public void setTestoHomeOutgoing(String testoHomeOutgoing) {
		this.testoHomeOutgoing = testoHomeOutgoing;
	}

	public String getTestoContratto() {
		return testoContratto;
	}

	public void setTestoContratto(String testoContratto) {
		this.testoContratto = testoContratto;
	}

	public Character getFlagAvvisoUploadLaFirmatoCCDSAttivo() {
		if (flagAvvisoUploadLaFirmatoCCDSAttivo == null)
			return 'N';
		return flagAvvisoUploadLaFirmatoCCDSAttivo;
	}

	public void setFlagAvvisoUploadLaFirmatoCCDSAttivo(
			Character flagAvvisoUploadLaFirmatoCCDSAttivo) {
		this.flagAvvisoUploadLaFirmatoCCDSAttivo = flagAvvisoUploadLaFirmatoCCDSAttivo;
	}
	
	public boolean isAvvisoUploadLaFirmatoCCDSAttivo() {
		return Common.CH_S.equals(getFlagAvvisoUploadLaFirmatoCCDSAttivo());
	}

	public String getNomeDocAutocertificazioneOutgoing() {
		return nomeDocAutocertificazioneOutgoing;
	}

	public void setNomeDocAutocertificazioneOutgoing(
			String nomeDocAutocertificazioneOutgoing) {
		this.nomeDocAutocertificazioneOutgoing = nomeDocAutocertificazioneOutgoing;
	}
	
	public boolean isErasmusPlacement() {
		return getSottoProgramma().isErasmusPlacement();
	}
	
	public boolean isErasmus() {
		return getSottoProgramma().isErasmus();
	}
	
	public boolean isSemestriABuenosAires() {
		return getSottoProgramma().isSemestriABuenosAires();
	}

	public boolean isFieldWork() {
		boolean isFieldWork = false;
		if (getSottoProgramma()!=null)
			isFieldWork = getSottoProgramma().isFieldWork();
		return isFieldWork;
	}

	public Character getFlagDurataPrevistaAttiva() {
		if (flagDurataPrevistaAttiva == null)
			return 'N';
		return flagDurataPrevistaAttiva;
	}

	public void setFlagDurataPrevistaAttiva(Character flagDurataPrevistaAttiva) {
		this.flagDurataPrevistaAttiva = flagDurataPrevistaAttiva;
	}
	
	public boolean isDurataPrevistaAttiva() {
		return Common.CH_S.equals(getFlagDurataPrevistaAttiva());
	}

	public Date getMinDataInizioPlacement() {
		return minDataInizioPlacement;
	}

	public void setMinDataInizioPlacement(Date minDataInizioPlacement) {
		this.minDataInizioPlacement = minDataInizioPlacement;
	}

	public Date getMaxDataInizioPlacement() {
		return maxDataInizioPlacement;
	}

	public void setMaxDataInizioPlacement(Date maxDataInizioPlacement) {
		this.maxDataInizioPlacement = maxDataInizioPlacement;
	}

	public Character getFlagGestioneAvanzataRate() {
		if (flagGestioneAvanzataRate == null)
			return 'N';
		return flagGestioneAvanzataRate;
	}

	public void setFlagGestioneAvanzataRate(Character flagGestioneAvanzataRate) {
		this.flagGestioneAvanzataRate = flagGestioneAvanzataRate;
	}
	
	public boolean isGestioneAvanzataRate() {
		return Common.CH_S.equals(getFlagGestioneAvanzataRate());
	}

	public Character getFlagBandoSoloPerCarrieraCorrente() {
		if (flagBandoSoloPerCarrieraCorrente == null)
			return 'N';
		return flagBandoSoloPerCarrieraCorrente;
	}

	public void setFlagBandoSoloPerCarrieraCorrente(
			Character flagBandoSoloPerCarrieraCorrente) {
		this.flagBandoSoloPerCarrieraCorrente = flagBandoSoloPerCarrieraCorrente;
	}
	
	public boolean isBandoSoloPerCarrieraCorrente() {
		return Common.CH_S.equals(getFlagBandoSoloPerCarrieraCorrente());
	}

	public Date getDataAperturaDocenti() {
		return dataAperturaDocenti;
	}

	public void setDataAperturaDocenti(Date dataAperturaDocenti) {
		this.dataAperturaDocenti = dataAperturaDocenti;
	}

	public Character getFlagAmmetteRidistribuzionePosti() {
		if (flagAmmetteRidistribuzionePosti == null)
			return 'N';
		return flagAmmetteRidistribuzionePosti;
	}

	public void setFlagAmmetteRidistribuzionePosti(
			Character flagAmmetteRidistribuzionePosti) {
		this.flagAmmetteRidistribuzionePosti = flagAmmetteRidistribuzionePosti;
	}
	
	public boolean isAmmetteRidistribuzionePosti() {
		return Common.CH_S.equals(getFlagAmmetteRidistribuzionePosti());
	}

	public Character getFlagValutazioneSoggettivaDivisa() {
		if (flagValutazioneSoggettivaDivisa == null)
			return 'N';
		return flagValutazioneSoggettivaDivisa;
	}

	public void setFlagValutazioneSoggettivaDivisa(
			Character flagValutazioneSoggettivaDivisa) {
		this.flagValutazioneSoggettivaDivisa = flagValutazioneSoggettivaDivisa;
	}
	
	public boolean isValutazioneSoggettivaDivisa() {
		return Common.CH_S.equals(getFlagValutazioneSoggettivaDivisa());
	}

	public String getNomeManualeValutazioneGraduatorie() {
		return nomeManualeValutazioneGraduatorie;
	}

	public void setNomeManualeValutazioneGraduatorie(
			String nomeManualeValutazioneGraduatorie) {
		this.nomeManualeValutazioneGraduatorie = nomeManualeValutazioneGraduatorie;
	}

	public Character getFlagMinicarrieraSuContrattoFirmato() {
		if (flagMinicarrieraSuContrattoFirmato == null)
			return 'N';
		return flagMinicarrieraSuContrattoFirmato;
	}

	public void setFlagMinicarrieraSuContrattoFirmato(
			Character flagMinicarrieraSuContrattoFirmato) {
		this.flagMinicarrieraSuContrattoFirmato = flagMinicarrieraSuContrattoFirmato;
	}
	
	public boolean isMinicarrieraSuContrattoFirmato() {
		return Common.CH_S.equals(getFlagMinicarrieraSuContrattoFirmato());
	}

	public Set<BandoGruppo> getBandoGruppi() {
		return bandoGruppi;
	}

	public void setBandoGruppi(Set<BandoGruppo> bandoGruppi) {
		this.bandoGruppi = bandoGruppi;
	}

	public Character getFlagModificaPunteggioOggettivo() {
		if (flagModificaPunteggioOggettivo == null)
			return 'S';
		return flagModificaPunteggioOggettivo;
	}

	public void setFlagModificaPunteggioOggettivo(
			Character flagModificaPunteggioOggettivo) {
		this.flagModificaPunteggioOggettivo = flagModificaPunteggioOggettivo;
	}
	
	public boolean isModificaPunteggioOggettivoAttiva() {
		return Common.CH_S.equals(getFlagModificaPunteggioOggettivo());
	}

	public Character getFlagDecimaliPunteggioSoggettivoCandidature() {
		if (flagDecimaliPunteggioSoggettivoCandidature == null)
			return 'N';
		return flagDecimaliPunteggioSoggettivoCandidature;
	}

	public void setFlagDecimaliPunteggioSoggettivoCandidature(
			Character flagDecimaliPunteggioSoggettivoCandidature) {
		this.flagDecimaliPunteggioSoggettivoCandidature = flagDecimaliPunteggioSoggettivoCandidature;
	}
	
	public boolean isAccettaDecimaliPunteggioSoggettivoCandidature() {
		return Common.CH_S.equals(getFlagDecimaliPunteggioSoggettivoCandidature());
	}

	public String getRangeValoriPunteggioSoggettivoCandidature() {
		return rangeValoriPunteggioSoggettivoCandidature;
	}

	public void setRangeValoriPunteggioSoggettivoCandidature(
			String rangeValoriPunteggioSoggettivoCandidature) {
		this.rangeValoriPunteggioSoggettivoCandidature = rangeValoriPunteggioSoggettivoCandidature;
	}
	
	public Float getMinValorePunteggioSoggettivoCandidature() {
		if (StringUtils.isBlank(rangeValoriPunteggioSoggettivoCandidature))
			return null;
		String[] ss = rangeValoriPunteggioSoggettivoCandidature.split("-");
		if (ss.length == 2)
			return Float.valueOf(ss[0]);
		if (rangeValoriPunteggioSoggettivoCandidature.endsWith("-"))
			return Float.valueOf(ss[0]);
		return null;
	}
	
	public Float getMaxValorePunteggioSoggettivoCandidature() {
		if (StringUtils.isBlank(rangeValoriPunteggioSoggettivoCandidature))
			return null;
		String[] ss = rangeValoriPunteggioSoggettivoCandidature.split("-");
		if (ss.length == 2)
			return Float.valueOf(ss[1]);
		if (rangeValoriPunteggioSoggettivoCandidature.startsWith("-"))
			return Float.valueOf(ss[0]);
		return null;
	}

	public Character getFlagNonIdoneiConPunteggioSoggettivoZero() {
		if (flagNonIdoneiConPunteggioSoggettivoZero == null)
			return 'N';
		return flagNonIdoneiConPunteggioSoggettivoZero;
	}

	public void setFlagNonIdoneiConPunteggioSoggettivoZero(
			Character flagNonIdoneiConPunteggioSoggettivoZero) {
		this.flagNonIdoneiConPunteggioSoggettivoZero = flagNonIdoneiConPunteggioSoggettivoZero;
	}
	
	public boolean isNonIdoneiConPunteggioSoggettivoZero() {
		return Common.CH_S.equals(getFlagNonIdoneiConPunteggioSoggettivoZero());
	}

	public Character getFlagCalcolaVincitoriCompletata() {
		return flagCalcolaVincitoriCompletata;
	}

	public void setFlagCalcolaVincitoriCompletata(
			Character flagCalcolaVincitoriCompletata) {
		this.flagCalcolaVincitoriCompletata = flagCalcolaVincitoriCompletata;
	}

	public boolean isCalcolaVincitoriCompletata() {
		return Common.CH_S.equals(getFlagCalcolaVincitoriCompletata());
	}

	public String getTestoRichiestaProlungamento() {
		return testoRichiestaProlungamento;
	}

	public void setTestoRichiestaProlungamento(String testoRichiestaProlungamento) {
		this.testoRichiestaProlungamento = testoRichiestaProlungamento;
	}

	public String getTestoRelazioneFinale() {
		return testoRelazioneFinale;
	}

	public void setTestoRelazioneFinale(String testoRelazioneFinale) {
		this.testoRelazioneFinale = testoRelazioneFinale;
	}
	
	public boolean isOverseas() {
		return getSottoProgramma().isOverseas();
	}

	public Character getFlagNoteValutazioneSingolaCandidatura() {
		return flagNoteValutazioneSingolaCandidatura;
	}

	public void setFlagNoteValutazioneSingolaCandidatura(
			Character flagNoteValutazioneSingolaCandidatura) {
		this.flagNoteValutazioneSingolaCandidatura = flagNoteValutazioneSingolaCandidatura;
	}
	
	public boolean isNoteValutazioneSingolaCandidaturaAttive() {
		return Common.CH_S.equals(getFlagNoteValutazioneSingolaCandidatura());
	}

	public String getNomeProceduraCalcoloDurata() {
		return nomeProceduraCalcoloDurata;
	}

	public void setNomeProceduraCalcoloDurata(String nomeProceduraCalcoloDurata) {
		this.nomeProceduraCalcoloDurata = nomeProceduraCalcoloDurata;
	}

	public Character getFlagPrecompilaDocumentoArrivo() {
		if (flagPrecompilaDocumentoArrivo == null)
			return 'N';
		return flagPrecompilaDocumentoArrivo;
	}

	public void setFlagPrecompilaDocumentoArrivo(
			Character flagPrecompilaDocumentoArrivo) {
		this.flagPrecompilaDocumentoArrivo = flagPrecompilaDocumentoArrivo;
	}
	
	public boolean isPrecompilaDocumentoArrivo() {
		return Common.CH_S.equals(getFlagPrecompilaDocumentoArrivo());
	}

	public String getSuffissoDocumenti() {
		return suffissoDocumenti;
	}

	public void setSuffissoDocumenti(String suffissoDocumenti) {
		this.suffissoDocumenti = suffissoDocumenti;
	}

	public boolean isDataFraInizioFineAccezione(){
		if (dataInizioAccettazione1 != null && dataFineAccettazione1 != null)
			if (Common.dateBetween(new Date(),dataInizioAccettazione1, dataFineAccettazione1))
				return true;
		if (dataInizioAccettazione2 != null && dataFineAccettazione2 != null)
			if (Common.dateBetween(new Date(),dataInizioAccettazione2, dataFineAccettazione2))
				return true;
		if (dataInizioAccettazione1 != null && dataFineAccettazione1 != null 
			&& dataInizioAccettazione2 != null && dataFineAccettazione2 != null
			&& dataInizioAccettazione1.before(dataFineAccettazione1)
			&& dataInizioAccettazione2.before(dataFineAccettazione2)
			&& dataInizioAccettazione1.before(dataInizioAccettazione2))
			if (Common.dateBetween(new Date(),dataInizioAccettazione1, dataFineAccettazione2))
				return true;
		
		return false;
	}

	public boolean isPrimaAccettazioneAlmenoIniziata(){
		return dataInizioAccettazione1 != null && (dataInizioAccettazione1.before(new Date()));
	}
	
	public boolean isPrimaAccettazioneTerminata(){
		return dataFineAccettazione1 != null && dataFineAccettazione1.before(new Date());
	}

	public boolean isFaseBandoAbilitaRinucia(boolean isOperatore){
		if (!getSottoProgramma().isOffertaErasmus())  
			return true;
			
		// SOLO PER I BANDI ERASMUS e Swisse CI SONO I RICALCOLI DELLE GRADUATORIE e quindi sulla prima 
		// non e' per nulla gestita la rinuncia.
		// IL RICALCOLO DELLA PRIMA GRADUATORIA NON PREVEDE(non gestisce) LO STATO 'RINUNCIATO' 
		// QUINDI FINO ALLA FINE DELLE PRIME ACCETTAZIONI NON POSSIAMO FAR RIFIUTARE. 
		
		// L' Operatore puo' mettere in RINUNCIATO gli outgoing solo a partire dalla fine delle prime accettazioni. 
		if (isOperatore)
			return isPrimaAccettazioneTerminata();
			
		// Lo Studente puo' RINUNCIARE solo fra la fine delle prime accettazioni e l'inizio delle seconde e poi dopo la fine delle seconde accettazioni. 
		return isPrimaAccettazioneAlmenoIniziata() && (!isDataFraInizioFineAccezione());
	    
	}

	public boolean isFaseBandoAbilitaRinuciaStudente(){
		return isFaseBandoAbilitaRinucia(false);
	}

	public boolean isFaseBandoAbilitaRinuciaOperatre(){
		return isFaseBandoAbilitaRinucia(true);
	}

	public String getTestoRelazioneIndividuale() {
		return testoRelazioneIndividuale;
	}

	public void setTestoRelazioneIndividuale(String testoRelazioneIndividuale) {
		this.testoRelazioneIndividuale = testoRelazioneIndividuale;
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
		if (!(obj instanceof Bando))
			return false;
		Bando other = (Bando) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getTestoAvvisoStraordinario() {
		return testoAvvisoStraordinario;
	}

	public void setTestoAvvisoStraordinario(String testoAvvisoStraordinario) {
		this.testoAvvisoStraordinario = testoAvvisoStraordinario;
	}

	public Integer getCiclo() {
		return ciclo;
	}

	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}
	
	public Character getFlagNotePresentazioneCandidatura() {
		return flagNotePresentazioneCandidatura;
	}

	public void setFlagNotePresentazioneCandidatura(
			Character flagNotePresentazioneCandidatura) {
		this.flagNotePresentazioneCandidatura = flagNotePresentazioneCandidatura;
	}

	public boolean isConNotePresentazioneCandidatura() {
		return !Common.CH_N.equals(flagNotePresentazioneCandidatura);
	}

	public String getTestoQuestionarioSO() {
		return testoQuestionarioSO;
	}

	public void setTestoQuestionarioSO(String testoQuestionarioSO) {
		this.testoQuestionarioSO = testoQuestionarioSO;
	}

	public String getNomeDocumentoRichiestaCertificato() {
		return nomeDocumentoRichiestaCertificato;
	}

	public void setNomeDocumentoRichiestaCertificato(
			String nomeDocumentoRichiestaCertificato) {
		this.nomeDocumentoRichiestaCertificato = nomeDocumentoRichiestaCertificato;
	}
		
	public boolean isValutazioneDisponibilitaAperta() {
		if (getDataInizioValutazioneDisponibilita() != null 
				&& getDataInizioValutazioneDisponibilita().after(new Date()))
				return false;
		if (getDataFineValutazioneDisponibilita() != null 
				&& getDataFineValutazioneDisponibilita().before(new Date()))
			return false;
		return true;
	}

	public boolean isValutazioneDisponibilitaAlmenoIniziata() {
		if (getDataInizioValutazioneDisponibilita() != null 
				&& getDataInizioValutazioneDisponibilita().after(new Date()))
				return false;
		return true;
	}
	
	public boolean isRichiedeSemestreSuAttEstereLa() {
		return getPeriodoMobilita().getAnnoAccademico() > 2014 && getSottoProgramma().isRichiedeSemestreSuAttEstereLa();
	}
	
	public boolean isCourseCatalogInLaRichiesto() {
		return getPeriodoMobilita().getAnnoAccademico() > 2014 && getSottoProgramma().isCourseCatalogInLaRichiesto();
	}
	
	public boolean isCompetenzeLinguisticheInLaRichieste() {
		return getPeriodoMobilita().getAnnoAccademico() > 2014 && getSottoProgramma().isCompetenzeLinguisticheInLaRichieste();
	}
	
	public boolean isTracciamentoModificheInLaAttivo() {
		return getPeriodoMobilita().getAnnoAccademico() > 2014 && getSottoProgramma().isTracciamentoModificheInLaAttivo();
	}

	public Character getFlagAvvisoLaApprovatoAStudente() {
		if (flagAvvisoLaApprovatoAStudente == null)
			return 'S';
		return flagAvvisoLaApprovatoAStudente;
	}

	public void setFlagAvvisoLaApprovatoAStudente(Character flagAvvisoLaApprovatoAStudente) {
		this.flagAvvisoLaApprovatoAStudente = flagAvvisoLaApprovatoAStudente;
	}
	
	public boolean isAvvisoLaApprovatoAStudenteAttivo() {
		return Common.CH_S.equals(getFlagAvvisoLaApprovatoAStudente());
	}

	public Character getFlagAmmetteScambiVolontariSenzaContributo() {
		return flagAmmetteScambiVolontariSenzaContributo;
	}

	public void setFlagAmmetteScambiVolontariSenzaContributo(Character flagAmmetteScambiVolontariSenzaContributo) {
		this.flagAmmetteScambiVolontariSenzaContributo = flagAmmetteScambiVolontariSenzaContributo;
	}
	
	public boolean isAmmetteScambiVolontariSenzaContributo() {
		return Common.CH_S.equals(getFlagAmmetteScambiVolontariSenzaContributo());
	}

	public Character getFlagVisualizzaEsitiValidazioneAStudente() {
		return flagVisualizzaEsitiValidazioneAStudente;
	}

	public void setFlagVisualizzaEsitiValidazioneAStudente(
			Character flagVisualizzaEsitiValidazioneAStudente) {
		this.flagVisualizzaEsitiValidazioneAStudente = flagVisualizzaEsitiValidazioneAStudente;
	}
	public boolean isVisualizzaEsitiValidazioneAStudente() {
		return Common.CH_S.equals(getFlagVisualizzaEsitiValidazioneAStudente());
	}

	public boolean isSwissEuropean() {
		return getSottoProgramma().isSwissEuropeanMobilityProgramme();
	}

   /* 2016 - isBandoConTestiSoloSuBando
    * A valle della pulizia della tabella dei bandi qesto metodo 
    * dovrà diventare false per tutti.
    * Con Antonio Abbiamo stabilito che i testi si mettono 
    * solo in una tabella e che quando sarà possibile si toglieranno le colonne dei testi
    * dalla tabella BANDI.	
    * TODO : *ppvv* dovrebbe gia non essere piu usato, controlla!
    */
   public boolean isBandoConTestiSoloSuBando() {
	 return getPeriodoMobilita().getAnnoAccademico().intValue() <= 2016 
			&& (!getId().equals(29L))  
			&& (!getId().equals(30L))
			&& (!getId().equals(92L));
  }

	public boolean isScaduteTutteLeAccettazioni(){
		Date adesso = new Date();
		if (dataInizioAccettazione2 != null && dataFineAccettazione2 != null 
			&& dataInizioAccettazione2.before(dataFineAccettazione2)
			&& adesso.before(dataFineAccettazione2))
			return false;

		if (dataInizioAccettazione1 != null && dataFineAccettazione1 != null 
				&& dataInizioAccettazione1.before(dataFineAccettazione1)
				&& adesso.before(dataFineAccettazione1))
				return false;
		return true;
	}
	
	// Dice se le offerte del bando possono omettere di indicare le aperure
	// Solo le offerte per candidature manuali possono avere questa necessita
	public boolean isRegoleOffertaOpzionali(){
		// Bando 150: Bando Erasmus+ studio - Extra UE - Terzo ciclo - 2016/17
		return new Long(150).equals(this.getId());
	}


	// Campo mansione tirocinante non piu previsto dal 16-17 per il placement 
	public boolean isMansioneTirocinantePlacementGestita(){
		return isErasmusPlacement()   
			 && getPeriodoMobilita() != null 
			 && getPeriodoMobilita().getAnnoAccademico() != null
			 && getPeriodoMobilita().getAnnoAccademico().intValue()< 2016; 
	}
	
	// Aggiunta dei campi citta e regione e cap e nazione della sede operativa del tirocinio 
	public boolean isSedeOperativaPlacementGestita(){
		return  isErasmusPlacement()     
				 && getPeriodoMobilita() != null 
				 && getPeriodoMobilita().getAnnoAccademico() != null
				 && getPeriodoMobilita().getAnnoAccademico().intValue()>= 2016;
	}

	// Avvisi/Blocchi S/N
	// 1 car : errore bloccante residuo insufficiente
	// 2 car : errore bloccante periodo residuo inferiore durata
	// 3 car : avv. periodo in corso
	// 4 car : avv. periodo futuro
	// 5 car : avv. periodo in corso e futuro
	// 6 car : avv. fruito con residuo inferiore 12 mesi
	// 7 car : avv. periodo residuo inferiore durata
	// TODO: aggiungi tabella cfg_avvisi_periodo_residuo
	// FARE quando possibile
	public String getGestionePeriodoResiduoInCandidatura() {
		if (64L == this.id)
			return "SSSNNNN";
		if (31L == this.id)
			return "SNSSSSN";
		if (32L == this.id)
			return "SNSSSSN";
		if (65L == this.id)
			return "SNSSSNS";
		if (66L == this.id)
			return "SNSSSNS";
		if (33L == this.id)
			return "SNSSSSN";
		if (34L == this.id)
			return "SNSSSSN";
		return null;
	}

	public boolean isGestitoPeriodoResiduoInCandidatura() {
		String gestione=getGestionePeriodoResiduoInCandidatura();
		if (StringUtils.isBlank(gestione))
			return false;
		
	   return StringUtils.contains(gestione, 'S');
	}

	public Character getFlagSezioneOlsInAccettazione() {
		return flagSezioneOlsInAccettazione;
	}

	public void setFlagSezioneOlsInAccettazione(
			Character flagSezioneOlsInAccettazione) {
		this.flagSezioneOlsInAccettazione = flagSezioneOlsInAccettazione;
	}
	
	public boolean isSezioneOlsInAccettazione() {
		return Common.CH_S.equals(flagSezioneOlsInAccettazione);
	}

	public Character getFlagAvvisoAccettazioneScambioAStudente() {
		return flagAvvisoAccettazioneScambioAStudente;
	}

	public void setFlagAvvisoAccettazioneScambioAStudente(Character flagAvvisoAccettazioneScambioAStudente) {
		this.flagAvvisoAccettazioneScambioAStudente = flagAvvisoAccettazioneScambioAStudente;
	}
	
	public boolean isAvvisoAccettazioneScambioAStudenteAttivo() {
		return Common.CH_S.equals(getFlagAvvisoAccettazioneScambioAStudente());
	}

	public Date getDataPubblicazioneRendicontoBorsa() {
		return dataPubblicazioneRendicontoBorsa;
	}

	public void setDataPubblicazioneRendicontoBorsa(
			Date dataPubblicazioneRendicontoBorsa) {
		this.dataPubblicazioneRendicontoBorsa = dataPubblicazioneRendicontoBorsa;
	}

	public boolean isRendicontoBorsaSOPubblicato () {
		return getDataPubblicazioneRendicontoBorsa() != null
				&& (getDataPubblicazioneRendicontoBorsa().before(new Date()));
	}

	public Character getFlagLinguaPrincipaleValidazioneInAccettazione() {
		return flagLinguaPrincipaleValidazioneInAccettazione;
	}

	public void setFlagLinguaPrincipaleValidazioneInAccettazione(
			Character flagLinguaPrincipaleValidazioneInAccettazione) {
		this.flagLinguaPrincipaleValidazioneInAccettazione = flagLinguaPrincipaleValidazioneInAccettazione;
	}

	public boolean isLinguaPrincipaleValidazioneInAccettazione() {
		return Common.CH_S.equals(flagLinguaPrincipaleValidazioneInAccettazione);
	}

	public Long getPhysDocFascicolo() {
		return physDocFascicolo;
	}

	public void setPhysDocFascicolo(Long physDocFascicolo) {
		this.physDocFascicolo = physDocFascicolo;
	}

	public Date getMinDataInizioPlacementPerCarrieraFutura() {
		if (!isBandoSoloPerCarrieraCorrente() && getMinDataInizioPlacement() != null) {
			Date minData = Common.getDataDaGiornoMeseAnno("01", "01", new Integer(Common.getAnno(getMinDataInizioPlacement()) + 1).toString());
			return minData ;
		}	
		return null;
	}

	public Character getFlagProlungamentoZeroGrant() {
		return flagProlungamentoZeroGrant;
	}

	public void setFlagProlungamentoZeroGrant(Character flagProlungamentoZeroGrant) {
		this.flagProlungamentoZeroGrant = flagProlungamentoZeroGrant;
	}
	
	public Character getFlagRiassegna() {
		return flagRiassegna;
	}

	public void setFlagRiassegna(Character flagRiassegna) {
		this.flagRiassegna = flagRiassegna;
	}

	public boolean isRiassegnaOutgoing() {
		return Common.CH_O.equals(flagRiassegna) || Common.CH_T.equals(flagRiassegna);
	}
	
	public boolean isRiassegnaCandidatura() {
		return Common.CH_C.equals(flagRiassegna) || Common.CH_T.equals(flagRiassegna);
	}
	
	// Implementata dal 2017 e usata da Erasmus Plus (studio e placement)
	public boolean isProlungamentoZeroGrant (){
		return Common.CH_S.equals(getFlagProlungamentoZeroGrant());
	}
	
	public void setFlagUploadContrattoFirmato(Character flagUploadContrattoFirmato) {
		this.flagUploadContrattoFirmato = flagUploadContrattoFirmato;
	}

	public Character getFlagUploadContrattoFirmato() {
		return flagUploadContrattoFirmato;
	}

	public Date getDataLimiteFineMobilita() {
		return dataLimiteFineMobilita;
	}

	public void setDataLimiteFineMobilita(Date dataLimiteFineMobilita) {
		this.dataLimiteFineMobilita = dataLimiteFineMobilita;
	}

	public Date getDataFineInfoCand() {
		return dataFineInfoCand;
	}

	public void setDataFineInfoCand(Date dataFineInfoCand) {
		this.dataFineInfoCand = dataFineInfoCand;
	}
	
	public boolean isPannelloOperatoreMtoolAttivo() {
		return isErasmusPlacement() && getPeriodoMobilita().getAnnoAccademico().intValue()>=2016; 
	}

	public Character getTipoGestioneContratto() {
		return tipoGestioneContratto;
	}

	public void setTipoGestioneContratto(Character tipoGestioneContratto) {
		this.tipoGestioneContratto = tipoGestioneContratto;
	}

	public Long getIdConfigMinicarriera() {
		return idConfigMinicarriera;
	}

	public void setIdConfigMinicarriera(Long idConfigMinicarriera) {
		this.idConfigMinicarriera = idConfigMinicarriera;
	}

	public boolean isTesiAllEstero() {
		return getSottoProgramma().isTesiAllEstero();
	}

	public boolean isSelezionaLinguaConLivelloInAccettazione(){
		return false;
	}
}
